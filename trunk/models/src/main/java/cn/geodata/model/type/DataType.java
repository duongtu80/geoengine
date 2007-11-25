package cn.geodata.model.type;

import java.net.URI;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.model.Encodable;
import cn.geodata.model.GeoNamespaceContext;

public class DataType implements Encodable {
	
	protected String dataType;
	protected java.net.URI reference;
	
	public DataType(String dataType, URI reference){
		this.dataType = dataType;
		this.reference = reference;
	}

	@Override
	public Element encode(Document doc) throws Exception {
		if(dataType == null){
			throw new NullPointerException("没有提供数据类型");
		}
		
		Element _dataTypeNode = doc.createElementNS(GeoNamespaceContext.URI_OWS, "DataType");
		if(this.reference != null){
			Attr _attr = doc.createAttributeNS(GeoNamespaceContext.URI_OWS, "reference");
			_attr.setPrefix("ows");
			_attr.setValue(this.reference.toString());
			
			_dataTypeNode.setAttributeNodeNS(_attr);
		}
		
		return _dataTypeNode;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public java.net.URI getReference() {
		return reference;
	}

	public void setReference(java.net.URI reference) {
		this.reference = reference;
	}
}
