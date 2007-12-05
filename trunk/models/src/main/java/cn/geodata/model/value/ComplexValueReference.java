package cn.geodata.model.value;

import java.net.URL;

import net.opengeospatial.wps.IOValueType;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import cn.geodata.gml.ParserUtil;

public class ComplexValueReference extends ModelValue {
	
	protected Object value;
	protected IOValueType.ComplexValueReference type;

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

	public ComplexValueReference(IOValueType type) throws Exception {
		super(type);
		this.type = type.getComplexValueReference();
		
		if(this.type.getFormat() == null || this.type.getFormat().equalsIgnoreCase("text/gml")){
			SAXBuilder _builder = new SAXBuilder();
			Document _doc = _builder.build(new URL(this.type.getReference()));
			
			this.value = ParserUtil.createParserFinder().parse(_doc.getRootElement());
		}
	}
}
