package cn.geodata.model.value;

import java.net.URL;

import net.opengeospatial.wps.IOValueType;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import cn.geodata.gml.ParserUtil;

public class ComplexValueReference extends ModelValue {
	
	protected Object value;
	protected IOValueType.ComplexValueReference type;
	protected String reference;
	protected String encoding;
	protected String format;
	protected String schema;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public IOValueType.ComplexValueReference getType() {
		return type;
	}

	public void setType(IOValueType.ComplexValueReference type) {
		this.type = type;
	}

	public ComplexValueReference(String identifier, String title, String describe, String ref, String format, String encoding, String schema) throws Exception{
		super(identifier, title, describe);
		this.reference = ref;
		this.encoding = encoding;
		this.format = format;
		this.schema = schema;
	}
	
	public ComplexValueReference(IOValueType type) throws Exception {
		super(type);
		
		this.type = type.getComplexValueReference();
		
		if(this.type.getFormat() == null || this.type.getFormat().equalsIgnoreCase("text/gml")){
			SAXBuilder _builder = new SAXBuilder();
			Document _doc = _builder.build(new URL(this.type.getReference()));
			
			this.value = ParserUtil.createParserFinder().parse(_doc.getRootElement());
		}
	}
	
	@Override
	public void encode(IOValueType type) throws Exception {
		super.encode(type);
		
		if(this.reference == null){
			throw new NullPointerException();
		}

		IOValueType.ComplexValueReference _valueNode = type.addNewComplexValueReference();
		
		_valueNode.setReference(this.reference);
		_valueNode.setFormat(this.format);
		if(this.encoding != null){
			_valueNode.setEncoding(this.encoding);
		}
		if(this.schema != null){
			_valueNode.setSchema(this.schema);
		}
	}
}
