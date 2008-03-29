package cn.geodata.models.value.gml;

import java.io.IOException;

import net.opengeospatial.wps.ComplexValueType;

import org.apache.xmlbeans.XmlObject;
import org.geotools.feature.FeatureCollection;
import org.jdom.JDOMException;
import org.jdom.input.DOMBuilder;
import org.jdom.output.DOMOutputter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.geodata.models.gml.ParserFinder;
import cn.geodata.models.gml.ParserUtil;
import cn.geodata.models.value.ComplexEncoder;
import cn.geodata.models.value.ComplexParser;

import com.vividsolutions.jts.geom.Geometry;

public class GMLComplexValueParser implements ComplexParser, ComplexEncoder {

	public FeatureCollection parseFeatureCollection(ComplexValueType type)
			throws IOException {
		return (FeatureCollection) this.parse(type);
	}

	public ComplexValueType encodeFeatureCollection(FeatureCollection fs)
			throws IOException {
		return (ComplexValueType) this.encode(fs);
	}

	public Geometry parseGeometry(ComplexValueType type) throws IOException {
		return (Geometry) this.parse(type);
	}

	public ComplexValueType encodeGeometry(Geometry geom) throws IOException {
		return (ComplexValueType) this.encode(geom);
	}

	public Object parse(XmlObject type) throws IOException {
		ComplexValueType _type = (ComplexValueType) type;

		NodeList _nodeList = _type.getDomNode().getChildNodes();
		Element _element = null;
		for(int i=0;i<_nodeList.getLength();i++){
			if(_nodeList.item(i).getNodeType() == Node.ELEMENT_NODE){
				_element = (Element)_nodeList.item(i);
				break;
			}
		}
		if(_element == null){
			throw new NullPointerException("No data found");
		}
		else{
			return ParserUtil.createParserFinder().parse((new DOMBuilder()).build(_element));
		}
	}

	public XmlObject encode(Object obj) throws IOException {
		ParserFinder _finder = ParserUtil.createParserFinder();
		
		org.jdom.Document _doc = new org.jdom.Document(_finder.encode(obj));
		Document _outputDoc;
		try {
			_outputDoc = (new DOMOutputter()).output(_doc);
		} catch (JDOMException e) {
			throw new IOException(e);
		}
		
		ComplexValueType _type = ComplexValueType.Factory.newInstance();

		_type.setEncoding("UTF-8");
		_type.setFormat("text/gml");
		_type.setSchema(_finder.getConfig().getUriGML().getURI());
		
		Node _node = _type.getDomNode();
		_type.getDomNode().appendChild(_node.getOwnerDocument().importNode(_outputDoc.getDocumentElement(), true));
		
		return _type;
	}

	public boolean canParse(XmlObject type) {
		if (type instanceof ComplexValueType) {
			ComplexValueType _type = (ComplexValueType) type;
			if(_type.getFormat().equalsIgnoreCase("text/gml")){
				return true;
			}
		}
		return false;
	}

	public boolean canEncode(Object obj) {
		return false;
	}
}
