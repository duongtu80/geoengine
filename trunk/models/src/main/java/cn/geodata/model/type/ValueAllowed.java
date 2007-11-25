package cn.geodata.model.type;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.model.GeoNamespaceContext;
import cn.geodata.model.exception.InvalidParameterValueException;

public class ValueAllowed extends AllowedValues {
	protected List<Object> values;
	
	public ValueAllowed(){
		
	}
	
	public ValueAllowed(List<Object> values){
		this.values = values;
	}
	
	@Override
	protected void encodeAllowedValues(Document doc, Element parentNode)
			throws Exception {
		for(Object _value : this.values){
			Element _valueNode = doc.createElementNS(GeoNamespaceContext.URI_OWS, "value");
			if(_value != null){
				_valueNode.setTextContent(_value.toString());
			}
			
			parentNode.appendChild(_valueNode);
		}
	}

	@Override
	protected void validData(Object value) throws InvalidParameterValueException {
		if(this.getValues().contains(value) == false){
			throw new InvalidParameterValueException(value + "不在有效取值范围内");
		}
	}

	public List<Object> getValues() {
		return values;
	}

	public void setValues(List<Object> values) {
		this.values = values;
	}

}
