package cn.geodata.models.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import net.opengis.ows.x11.ValueType;
import net.opengis.wps.x100.ComplexDataType;
import net.opengis.wps.x100.DataType;
import net.opengis.wps.x100.DocumentOutputDefinitionType;
import net.opengis.wps.x100.InputReferenceType;
import net.opengis.wps.x100.LiteralDataType;
import net.opengis.wps.x100.OutputDataType;
import net.opengis.wps.x100.OutputDefinitionType;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.data.parsers.GeoJsonComplexParser;
import cn.geodata.models.data.parsers.GmlComplexParser;
import cn.geodata.models.data.parsers.LiteralValueParser;

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
	public Object parse(GeoInput metadata, Class type, DataType value) throws IOException {
		return this.parse(type, value);
	}

	/**
	 * Parse IOValueType
	 * 
	 * @param category
	 * @param value
	 * @return
	 * @throws IOException
	 */
	public Object parse(Class type, DataType value) throws IOException {
		if(value.isSetLiteralData()){
			return this.getLiteralParsers().parseLiteral(type, value.getLiteralData());
		}
		else if(value.isSetComplexData()){
			ComplexStream _stream = this.getComplexParsers().parseToStream(type, value.getComplexData()); 
			
			return this.getComplexParsers().parserComplex(_stream);
		}
		else{
			log.severe("Only supports literal value and complex value");
			throw new IOException("Only supports literal value and complex value");
		}
	}

	/**
	 * Parse IOValueType
	 * 
	 * @param category
	 * @param value
	 * @return
	 * @throws IOException
	 */
	public Object parse(Class type, InputReferenceType value) throws IOException {
		ComplexStream _stream = this.getComplexParsers().parseToStream(type, value); 
		
		return this.getComplexParsers().parserComplex(_stream);
	}

	/**
	 * Encode output value to wps:OutputDataType
	 * 
	 * @param obj
	 * @param metadata
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public OutputDataType encode(Object obj, GeoOutput metadata, DocumentOutputDefinitionType request) throws IOException{
		MimeType _mime = null;
		try {
			_mime = new MimeType("text/xml");
			if(request != null && request.getMimeType() != null){
				_mime = new MimeType(request.getMimeType());
			}
		} catch (MimeTypeParseException e) {
			log.log(Level.WARNING, "Failed to create MIME object", e);
		}
		
		OutputDataType _type = OutputDataType.Factory.newInstance();
		
		_type.setIdentifier(request.getIdentifier());
		_type.addNewTitle().setStringValue(metadata.title());
		
		DataType _data = _type.addNewData();
		if(this.isLiteral(obj.getClass())){
			_data.setLiteralData(this.encodeLiteral(obj, metadata));
		}
		else{
			_data.setComplexData(this.encodeComplex(obj, _mime, metadata));
		}
		
		return _type;
	}
	
	public boolean isLiteral(Class type){
		return type.isPrimitive();
	}

	public LiteralDataType encodeLiteral(Object obj, GeoOutput metadata) throws IOException {
		return this.getLiteralParsers().encodeLiteral(obj);
	}
	
	public ComplexDataType encodeComplex(Object obj, MimeType mime, GeoOutput metadata) throws IOException {
		ComplexStream _stream = this.getComplexParsers().encodeToStream(mime, obj);
		return this.getComplexParsers().encodeComplex(_stream);
	}
}
