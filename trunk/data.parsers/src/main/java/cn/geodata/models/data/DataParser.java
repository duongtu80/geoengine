package cn.geodata.models.data;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.OutputDefinitionType;
import net.opengeospatial.wps.IOValueType.ComplexValueReference;
import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.data.parsers.GeoJsonComplexParser;
import cn.geodata.models.data.parsers.GmlComplexParser;
import cn.geodata.models.data.parsers.LiteralValueParser;
import cn.geodata.models.geoprocessing.ValueType;

public class DataParser {
	private static Logger log = Utilities.getLogger();
	
	private ComplexParsers complexParsers;
	private LiteralParsers literalParsers;
	private DataRepository dataRepository;
	
	private static DataParser instance;
	
	private DataParser(){
		
	}
	
	public static DataParser getInstance(){
		if(instance == null){
			instance = new DataParser();
			
			instance.setComplexParsers(new ComplexParsers());
			instance.getComplexParsers().setParsers(Arrays.asList(new ComplexParser[]{new GmlComplexParser(), new GeoJsonComplexParser()}));
			
			instance.setLiteralParsers(new LiteralParsers());
			instance.getLiteralParsers().setParsers(Arrays.asList(new LiteralParser[]{new LiteralValueParser()}));
		}
		return instance;
	}
	
	public DataRepository getDataRepository() {
		return dataRepository;
	}

	public void setDataRepository(DataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}

	public ComplexParsers getComplexParsers() {
		return complexParsers;
	}

	public void setComplexParsers(ComplexParsers complexParsers) {
		this.complexParsers = complexParsers;
	}
	
	public LiteralParsers getLiteralParsers() {
		return literalParsers;
	}
	
	public void setLiteralParsers(LiteralParsers literalParsers) {
		this.literalParsers = literalParsers;
	}
	
	public Object parse(ValueType type, IOValueType value) throws IOException {
		if(type.getId().equalsIgnoreCase(value.getIdentifier().getStringValue()) == false){
			log.warning("Parameter id does not match " + type.getId() + " " + value.getIdentifier().getStringValue());
			throw new IOException("Parameter id does not match");
		}
		
		if(value.isSetLiteralValue()){
			return this.getLiteralParsers().parseLiteral(type, value.getLiteralValue());
		}
		else if(value.isSetComplexValue() || value.isSetComplexValueReference()){
			ComplexStream _stream = value.isSetComplexValue() ? this.getComplexParsers().parseToStream(type, value.getComplexValue()) : this.getComplexParsers().parseToStream(type, value.getComplexValueReference());
			return this.getComplexParsers().parserComplex(_stream);
		}
		else{
			log.severe("Only supports literal value and complex value");
			throw new IOException("Only supports literal value and complex value");
		}
	}
	
	public IOValueType encode(ValueType type, OutputDefinitionType request, Object obj, boolean store) throws IOException {
		IOValueType _value = IOValueType.Factory.newInstance();
		
		_value.addNewIdentifier().setStringValue(type.getId());
		_value.setTitle(type.getTitle());
		_value.setAbstract(type.getDescribe());
		
		DataCategory _category = null;
		DataCategories _categories = DataCategories.getInstance();
		for(String _cat : type.getCategoryArray()){
			DataCategory _c = _categories.findCategory(_cat);
			if(_c.isInstance(obj)){
				_category = _c;
				break;
			}
		}
		
		if(_category.getLiteral()){
			_value.setLiteralValue(this.literalParsers.encodeLiteral(type, obj));
		}
		else{
			MimeType _mime;
			ComplexStream _complexStream;
			try {
				//Find the default output MIME type
				_mime = _categories.getDefaultMime(_category);

				if(request != null && request.getFormat() != null && request.getFormat().length() > 0){
					_mime = new MimeType(request.getFormat());
				}
				_complexStream = this.complexParsers.encodeToStream(type, _mime, obj);
			} catch (MimeTypeParseException e) {
				log.log(Level.SEVERE, "failed to parse MIME", e);
				throw new IOException(e);
			}
			
			if(store == false){
				_value.setComplexValue(this.complexParsers.encodeComplex(_complexStream));
			}
			else{
				ComplexValueReference _ref = _value.addNewComplexValueReference();
				_ref.setFormat(_complexStream.getMime().toString());
				_ref.setReference(this.dataRepository.store(_complexStream).toString());
			}
		}
		
		return _value;
	}
}
