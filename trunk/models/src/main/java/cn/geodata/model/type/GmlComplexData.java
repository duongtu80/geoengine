package cn.geodata.model.type;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

import org.w3c.dom.Element;

import cn.geodata.model.GeoNamespaceContext;
import cn.geodata.model.util.Utilities;

public class GmlComplexData extends ComplexData {
	public GmlComplexData(){
		super("text/xml", "UTF-8", GeoNamespaceContext.URI_GML);
	}

	@Override
	public boolean canParse(Element node) throws Exception {
		if(super.canParse(node) == false){
			return false;
		}
		
		XPath _xpath = Utilities.createInstance().getXpath();
		Element _complexData = (Element)_xpath.evaluate("//wps:ComplexData", node, XPathConstants.NODE);
		return _complexData.getAttribute("defaultSchema").equals(GeoNamespaceContext.URI_GML);
	}
}
