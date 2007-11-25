package cn.geodata.model.type;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.model.Encodable;
import cn.geodata.model.GeoNamespaceContext;
import cn.geodata.model.Parsable;
import cn.geodata.model.util.Utilities;

public abstract class ModelData implements Encodable, Parsable {
	
	public static final javax.xml.namespace.QName TYPE_INPUT = new javax.xml.namespace.QName(GeoNamespaceContext.URI_WPS, "Input");
	public static final javax.xml.namespace.QName TYPE_OUTPUT = new javax.xml.namespace.QName(GeoNamespaceContext.URI_WPS, "Output");
	
	protected String identifier;
	protected String title;
	protected String describe;
	protected QName type;
	protected int minimumOccures;
	
	public int getMinimumOccures() {
		return minimumOccures;
	}
	public void setMinimumOccures(int minimumOccures) {
		this.minimumOccures = minimumOccures;
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
	public QName getType() {
		return type;
	}
	public void setType(QName type) {
		this.type = type;
	}

	/**
	 * 对取值进行编码
	 * @param doc
	 * @return
	 */
	protected abstract Element encodeType(Document doc) throws Exception;

	/**
	 * 编码为XML DOM Element
	 * @param doc
	 * @return
	 */
	public Element encode(Document doc) throws Exception{
		Element _valueNode = doc.createElementNS(type.getNamespaceURI(), type.getLocalPart());
		
		Element _identifierNode = doc.createElementNS(GeoNamespaceContext.URI_OWS, "Identifier");
		_valueNode.appendChild(_identifierNode);
		_identifierNode.setTextContent(this.identifier);
		
		Element _titleNode = doc.createElementNS(GeoNamespaceContext.URI_OWS, "Title");
		_valueNode.appendChild(_titleNode);
		_titleNode.setTextContent(this.title);
		
		if(this.describe != null){
			Element _abstractNode = doc.createElementNS(GeoNamespaceContext.URI_OWS, "Abstract");
			_valueNode.appendChild(_abstractNode);
			_abstractNode.setTextContent(this.describe);
		}
		
		_valueNode.appendChild(this.encodeType(doc));		
		
		Element _minimumOccursNode = doc.createElementNS(GeoNamespaceContext.URI_WPS, "MinimumOccurs");
		_valueNode.appendChild(_minimumOccursNode);
		_minimumOccursNode.setTextContent(this.minimumOccures + "");
		
		return _valueNode;
	}
	
	@Override
	public void parse(Element node) throws Exception {
		XPath _xpath = Utilities.createInstance().getXpath();
		
		this.identifier = (String)_xpath.evaluate("//ows:Identifier/text()", node, XPathConstants.STRING); 
		this.title = (String)_xpath.evaluate("//ows:Title/text()", node, XPathConstants.STRING); 
		this.describe = (String)_xpath.evaluate("//ows:Abstract/text()", node, XPathConstants.STRING);
		
		String _minimumOccurs = (String)_xpath.evaluate("//wps:MinimumOccurs/text()", node, XPathConstants.STRING);
		if(_minimumOccurs != null){
			this.minimumOccures = Integer.parseInt(_minimumOccurs);
		}
	}
	
	@Override
	public boolean canParse(Element node) throws Exception {
		XPath _xpath = Utilities.createInstance().getXpath();
		
		if(node == null){
			return false;
		}

		if((String)_xpath.evaluate("//ows:Identifier/text()", node, XPathConstants.STRING) == null){
			return false;
		}
		
		if((String)_xpath.evaluate("//ows:Title/text()", node, XPathConstants.STRING) == null){
			return false;
		}
		
		return true;
	}
}
