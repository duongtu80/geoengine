package cn.geodata.model;

import java.io.IOException;
import java.net.URI;

import javax.xml.parsers.ParserConfigurationException;

import org.geotools.gml3.GMLConfiguration;
import org.geotools.xml.Parser;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class GmlReference {
	private URI reference;
	private String format;
	private String encoding;
	private URI schema;
	
	public GmlReference(URI reference){
		this.reference = reference;
		this.format = "text/xml";
		this.encoding = "UTF-8";
		this.schema = null;
	}
	
	public URI getReference() {
		return reference;
	}
	
	public void setReference(URI reference) {
		this.reference = reference;
	}
	
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	public URI getSchema() {
		return schema;
	}
	
	public void setSchema(URI schema) {
		this.schema = schema;
	}
	
	public Object loadData() throws Exception {
		Parser _parser = new Parser(new GMLConfiguration());
		return _parser.parse(GmlReference.class.getResourceAsStream("Polygon.xml"));
	}
	
	public Element encode(Document doc) {
		Element _refNode = doc.createElementNS(GeoNamespaceContext.URI_WPS, "ComplexValueReference");

		Attr _attr = doc.createAttributeNS(GeoNamespaceContext.URI_OWS, "reference");
		_attr.setPrefix("ows");
		_attr.setValue(this.getReference().toString());
		_refNode.setAttributeNode(_attr);
		
		if(this.getEncoding() != null)
			_refNode.setAttribute("encoding", this.getEncoding());
		
		if(this.getFormat() != null)
			_refNode.setAttribute("format", this.getFormat());

		if(this.getSchema() != null)
			_refNode.setAttribute("schema", this.getSchema().toString());
		
		return _refNode;
	}
}
