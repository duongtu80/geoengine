package cn.geodata.model.value;

import org.jdom.Element;

import net.opengeospatial.wps.IOValueType;

import cn.geodata.model.Encodable;
import cn.geodata.model.GeoNamespaceContext;

public abstract class ModelValue implements Encodable  {
	public static final javax.xml.namespace.QName TYPE_INPUT = new javax.xml.namespace.QName(GeoNamespaceContext.URI_WPS, "Input");
	public static final javax.xml.namespace.QName TYPE_OUTPUT = new javax.xml.namespace.QName(GeoNamespaceContext.URI_WPS, "Output");
	
	protected String identifier;
	protected String title;
	protected String describe;
	
	public ModelValue(String identifier, String title, String describe){
		this.identifier = identifier;
		this.title = title;
		this.describe = describe;
	}
	
	public ModelValue(IOValueType type){
		this.identifier = type.getIdentifier().getStringValue();
		this.title = type.getTitle();
		this.describe = type.getAbstract();
	}
	
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
//	/**
//	 * 对取值进行编码
//	 * @param doc
//	 * @return
//	 */
//	protected abstract Element encodeValue(Element doc) throws Exception;
//
//	/**
//	 * 编码为XML DOM Element
//	 * @param doc
//	 * @return
//	 */
//	public Element encode(Element doc) throws Exception{
//		Element _valueNode = doc.createElementNS(TYPE_INPUT.getNamespaceURI(), TYPE_INPUT.getLocalPart());
//		
//		Element _identifierNode = doc.createElementNS(GeoNamespaceContext.URI_OWS, "Identifier");
//		_valueNode.appendChild(_identifierNode);
//		_identifierNode.setTextContent(this.identifier);
//		
//		Element _titleNode = doc.createElementNS(GeoNamespaceContext.URI_OWS, "Title");
//		_valueNode.appendChild(_titleNode);
//		_titleNode.setTextContent(this.title);
//		
//		if(this.describe != null){
//			Element _abstractNode = doc.createElementNS(GeoNamespaceContext.URI_OWS, "Abstract");
//			_valueNode.appendChild(_abstractNode);
//			_abstractNode.setTextContent(this.describe);
//		}
//		
//		_valueNode.appendChild(this.encodeValue(doc));
//		
//		return _valueNode;
//	}
//	
	public void encode(IOValueType type) throws Exception{
		type.addNewIdentifier().setStringValue(this.getIdentifier());
		type.setTitle(this.getTitle());
		type.setAbstract(this.getDescribe());
	}
}
