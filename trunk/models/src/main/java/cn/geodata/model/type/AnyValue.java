package cn.geodata.model.type;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.model.GeoNamespaceContext;

public class AnyValue extends LiteralData {
	public AnyValue(){
	}
	
	@Override
	protected Element encodeDataType(Document doc) throws Exception {
		return doc.createElementNS(GeoNamespaceContext.URI_OWS, "AnyValue");
	}
}
