package cn.geodata.models.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	
	/**
	 * Parse IOValueType
	 * 
	 * @param type
	 * @param value
	 * @return
	 * @throws IOException
	 */
	public Object parse(ValueType type, IOValueType value) throws IOException {
		if(type.getId().equalsIgnoreCase(value.getIdentifier().getStringValue()) == false){
			log.warning("Parameter id does not match " + type.getId() + " " + value.getIdentifier().getStringValue());
			throw new IOException("Parameter id does not match");
		}
		
		List<DataCategory> _categories = new ArrayList<DataCategory>();
		for(String _c : type.getCategoryArray()){
			_categories.add(DataCategories.getInstance().findCategory(_c));
		}
		
		return this.parse(_categories, value);
	}

	/**
	 * Parse IOValueType
	 * 
	 * @param category
	 * @param value
	 * @return
	 * @throws IOException
	 */
	public Object parse(DataCategory category, IOValueType value) throws IOException {
		List<DataCategory> _categories = new ArrayList<DataCategory>();
		_categories.add(category);
		
		return this.parse(_categories, value);
	}

	/**
	 * Parse IOValueType
	 * 
	 * @param categories
	 * @param value
	 * @return
	 * @throws IOException
	 */
	public Object parse(List<DataCategory> categories, IOValueType value) throws IOException {
		if(value.isSetLiteralValue()){
			return this.getLiteralParsers().parseLiteral(categories, value.getLiteralValue());
		}
		else if(value.isSetComplexValue() || value.isSetComplexValueReference()){
			ComplexStream _stream = value.isSetComplexValue() ? this.getComplexParsers().parseToStream(categories, value.getComplexValue()) : this.getComplexParsers().parseToStream(categories, value.getComplexValueReference());
			
			return this.getComplexParsers().parserComplex(_stream);
		}
		else{
			log.severe("Only supports literal value and complex value");
			throw new IOException("Only supports literal value and complex value");
		}
	}

	/**
	 * Encode object to implement the OutputDefinitionType request (Used by server)
	 * 
	 * @param type
	 * @param request
	 * @param obj
	 * @param store
	 * @return
	 * @throws IOException
	 */
	public IOValueType encode(ValueType type, OutputDefinitionType request, Object obj, boolean store) throws IOException {
		DataCategories _categories = DataCategories.getInstance();
		
		DataCategory _category = null;
		for(String _cat : type.getCategoryArray()){
			DataCategory _c = _categories.findCategory(_cat);
			if(_c.isInstance(obj)){
				_category = _c;
				break;
			}
		}

		MimeType _mime;
		try {
			//Find the default output MIME type
			_mime = _categories.getDefaultMime(_category);

			if(request != null && request.getFormat() != null && request.getFormat().length() > 0){
				_mime = new MimeType(request.getFormat());
			}

			IOValueType _value = this.createOutputParameterNode(type);
//			
//			DataCategory _category = null;
//			DataCategories _categories = DataCategories.getInstance();
//			for(String _cat : type.getCategoryArray()){
//				DataCategory _c = _categories.findCategory(_cat);
//				if(_c.isInstance(obj)){
//					_category = _c;
//					break;
//				}
//			}
//			
			List<DataCategory> _cats = new ArrayList<DataCategory>();
			_cats.add(_category);

			this.encode(_value, _cats, _mime, obj, store);
			return _value;
		} catch (MimeTypeParseException e) {
			log.log(Level.SEVERE, "failed to parse MIME", e);
			throw new IOException(e);
		}
	}

	/**
	 * Encode object using the specificed MIME
	 * 
	 * @param type
	 * @param mime
	 * @param obj
	 * @param store
	 * @return
	 * @throws IOException
	 */
	public void encode(IOValueType type, List<DataCategory> categories, MimeType mime, Object obj, boolean store) throws IOException {
//		IOValueType _value = this.createOutputParameterNode(type);
//		
//		DataCategory _category = null;
//		DataCategories _categories = DataCategories.getInstance();
//		for(String _cat : type.getCategoryArray()){
//			DataCategory _c = _categories.findCategory(_cat);
//			if(_c.isInstance(obj)){
//				_category = _c;
//				break;
//			}
//		}
//		
//		List<DataCategory> _cats = new ArrayList<DataCategory>();
//		_cats.add(_category);
		if(categories.size() != 1){
			throw new IOException("Only supports single category");
		}
		
		if(categories.get(0).getLiteral()){
			type.setLiteralValue(this.literalParsers.encodeLiteral(categories, obj));
		}
		else{
			ComplexStream _complexStream = this.complexParsers.encodeToStream(categories, mime, obj);
			
			if(store == false){
				type.setComplexValue(this.complexParsers.encodeComplex(_complexStream));
			}
			else{
				if(this.dataRepository == null){
					throw new IOException("No data repository assigned.");
				}
				ComplexValueReference _ref = type.addNewComplexValueReference();
				_ref.setFormat(_complexStream.getMime().toString());
				_ref.setReference(this.dataRepository.store(_complexStream).toString());
			}
		}
	}
	
	/**
	 * Encode without categories
	 * 
	 * @param type
	 * @param mime
	 * @param obj
	 * @param store
	 * @throws IOException
	 */
	public void encode(IOValueType type, MimeType mime, Object obj, boolean store) throws IOException {
		List<DataCategory> _categories = new ArrayList<DataCategory>();
		_categories.add(DataCategories.getInstance().findPossibleCategory(obj));
		
		this.encode(type, _categories, mime, obj, store);
	}

	/**
	 * Encode literal value
	 * @param type
	 * @param obj
	 * @return
	 * @throws IOException
	 */
	public void encodeLiteral(IOValueType type, Object obj) throws IOException {
		this.encode(type, (MimeType)null, obj, false);
	}
	
	/**
	 * Encode Complex value
	 * @param type
	 * @param mime
	 * @param obj
	 * @param store
	 * @return
	 * @throws IOException
	 */
	public void encodeComplex(IOValueType type, MimeType mime, Object obj, boolean store) throws IOException {
		this.encode(type, mime, obj, store);
	}
	
	protected IOValueType createOutputParameterNode(ValueType type){
		IOValueType _value = IOValueType.Factory.newInstance();
		
		_value.addNewIdentifier().setStringValue(type.getId());
		_value.setTitle(type.getTitle());
		_value.setAbstract(type.getDescribe());
		
		return _value;
	}
}
