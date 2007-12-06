package cn.geodata.model.value.gml;

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

import cn.geodata.gml.ParserFinder;
import cn.geodata.gml.ParserUtil;
import cn.geodata.model.value.ComplexEncoder;
import cn.geodata.model.value.ComplexParser;
import cn.geodata.model.value.Encoder;
import cn.geodata.model.value.Parser;

import com.vividsolutions.jts.geom.Geometry;

public class GMLComplexValueParser implements Parser, ComplexParser, Encoder,
		ComplexEncoder {

	@Override
	public Object parse(XmlObject type) throws IOException {
		ComplexValueType _type = (ComplexValueType) type;
		if(_type.getFormat().equalsIgnoreCase("text/xml") || _type.getFormat().equalsIgnoreCase("text/gml")){

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
		else{
			throw new IOException("Unsupported complex data format:" + _type.getFormat());
		}
	}

	@Override
	public FeatureCollection parseFeatureCollection(ComplexValueType type)
			throws IOException {
		Object _o = this.parse(type);
		if (_o instanceof FeatureCollection) {
			return (FeatureCollection) _o;
		}
		else{
			throw new IOException("Can't be convert to FeatureCollection");
		}
	}

	@Override
	public ComplexValueType encodeFeatureCollection(FeatureCollection fs)
			throws IOException {
		return (ComplexValueType) this.encode(fs);
	}

	@Override
	public Geometry parseGeometry(ComplexValueType type) throws IOException {
		Object _o = this.parse(type);
		if (_o instanceof Geometry) {
			return (Geometry) _o;
		}
		else{
			throw new IOException("Can't be convert to Geometry");
		}
	}

	@Override
	public ComplexValueType encodeGeometry(Geometry geom) throws IOException {
		return (ComplexValueType) this.encode(geom);
	}

	@Override
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
}
