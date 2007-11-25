package cn.geodata.model.type;

import java.net.URI;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.model.Encodable;
import cn.geodata.model.GeoNamespaceContext;

public class Uom implements Encodable {
	
	protected String uom;
	protected java.net.URI reference;
	
	public Uom(String uom, URI reference){
		this.uom = uom;
		this.reference = reference;
	}

	@Override
	public Element encode(Document doc) throws Exception {
		if(uom == null){
			throw new NullPointerException("没有提供单位信息");
		}
		
		Element _uomNode = doc.createElementNS(GeoNamespaceContext.URI_OWS, "UOM");
		if(this.reference != null){
			Attr _attr = doc.createAttributeNS(GeoNamespaceContext.URI_OWS, "reference");
			_attr.setPrefix("ows");
			_attr.setValue(this.reference.toString());
			
			_uomNode.setAttributeNodeNS(_attr);
		}
		
		return _uomNode;
	}

	public String getDataType() {
		return uom;
	}

	public void setDataType(String dataType) {
		this.uom = dataType;
	}

	public java.net.URI getReference() {
		return reference;
	}

	public void setReference(java.net.URI reference) {
		this.reference = reference;
	}
}
