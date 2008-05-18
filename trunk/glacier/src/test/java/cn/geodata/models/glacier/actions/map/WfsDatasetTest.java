package cn.geodata.models.glacier.actions.map;

import java.net.URL;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;

import junit.framework.TestCase;

public class WfsDatasetTest extends TestCase {
	public void testDatasets() throws Exception {
		SAXBuilder _builder = new SAXBuilder();
		Document _doc = _builder.build(new URL("http://127.0.0.1:48080/geoserver/wfs?service=WFS&request=GetCapabilities"));
		
		Namespace _wfsNamespace = Namespace.getNamespace("wfs", "http://www.opengis.net/wfs");
		
		XPath _xpath = XPath.newInstance("//wfs:FeatureType");
		
		_xpath.addNamespace("wfs", "http://www.opengis.net/wfs");
		_xpath.addNamespace("ogc", "http://www.opengis.net/ogc");
		_xpath.addNamespace("geo", "http://www.geodata.cn/data");
		_xpath.addNamespace("ows", "http://www.opengis.net/ows");
		
		List<Element> _nodes = _xpath.selectNodes(_doc);
		for(Element _n : _nodes){
			System.out.println(_n.getChildTextTrim("Name", _wfsNamespace));
			System.out.println(_n.getChildTextTrim("Title", _wfsNamespace));
		}
		
//		XMLOutputter _output = new XMLOutputter(Format.getPrettyFormat());
//		_output.output(_doc, System.out);
	}
}
