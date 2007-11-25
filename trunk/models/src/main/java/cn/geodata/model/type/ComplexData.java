package cn.geodata.model.type;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.model.GeoNamespaceContext;
import cn.geodata.model.exception.InvalidParameterValueException;
import cn.geodata.model.util.Utilities;

public abstract class ComplexData extends ModelData {
	protected String format;
	protected String encoding;
	protected String schema;

	public ComplexData(String format, String encoding, String schema){
		this.format = format;
		this.encoding = encoding;
		this.schema = schema;
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

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	@Override
	protected Element encodeType(Document doc) throws Exception {
		Element _dataNode = doc.createElementNS(GeoNamespaceContext.URI_WPS, "ComplexData");
		_dataNode.setAttribute("defaultFormat", this.format);
		_dataNode.setAttribute("defaultEncoding", this.encoding);
		_dataNode.setAttribute("defaultSchema", this.schema);

		Element _supportData = doc.createElementNS(GeoNamespaceContext.URI_WPS, "SupportedComplexData");
		_dataNode.appendChild(_supportData);
		_supportData.setAttribute("defaultFormat", this.format);
		_supportData.setAttribute("defaultEncoding", this.encoding);
		_supportData.setAttribute("defaultSchema", this.schema);
		
		return _dataNode;
	}

	@Override
	public void parse(Element node) throws Exception {
		super.parse(node);
		XPath _xpath = Utilities.createInstance().getXpath();
		Element _complexNode = (Element)_xpath.evaluate("//wps:ComplexData", node, XPathConstants.NODE);
		if(_complexNode == null){
			throw new InvalidParameterValueException("内容与类型不匹配");
		}
		
		this.format = _complexNode.getAttribute("defaultFormat");
	}

	@Override
	public boolean canParse(Element node) throws Exception {
		if(super.canParse(node) == false){
			return false;
		}
		
		XPath _xpath = Utilities.createInstance().getXpath();
		if((Element)_xpath.evaluate("//wps:ComplexData", node, XPathConstants.NODE) == null){
			return false;
		}
		
		return true;
	}
}
