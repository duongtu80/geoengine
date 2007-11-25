package cn.geodata.model.type;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.model.GeoNamespaceContext;
import cn.geodata.model.exception.InvalidParameterValueException;

public abstract class AllowedValues extends LiteralData {
	protected abstract void validData(Object value) throws InvalidParameterValueException;
	protected abstract void encodeAllowedValues(Document doc, Element parentNode) throws Exception;
	
	@Override
	protected Element encodeDataType(Document doc) throws Exception {
		Element _valueNode = doc.createElementNS(GeoNamespaceContext.URI_OWS, "AllowedValues");
		this.encodeAllowedValues(doc, _valueNode);
		
		return _valueNode;
	}
}
