package cn.geodata.models.value.geojson;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.opengeospatial.wps.ComplexValueType;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.util.Base64;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.IllegalAttributeException;
import org.jdom.JDOMException;
import org.jdom.input.DOMBuilder;
import org.jdom.output.DOMOutputter;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import com.vividsolutions.jts.geom.Geometry;

import cn.geodata.models.geojson.GeoJSON;
import cn.geodata.models.gml.ParserFinder;
import cn.geodata.models.gml.ParserUtil;
import cn.geodata.models.util.Utilities;
import cn.geodata.models.value.ComplexEncoder;
import cn.geodata.models.value.ComplexParser;

public class GeoJSONParser implements ComplexParser, ComplexEncoder {
	private static Logger log = Utilities.getLogger();
	
	private GeoJSON geoJson;
	
	public GeoJSONParser() {
		this.geoJson = new GeoJSON();
	}

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
		Text _element = null;
		for(int i=0;i<_nodeList.getLength();i++){
			if(_nodeList.item(i).getNodeType() == Node.TEXT_NODE){
				_element = (Text)_nodeList.item(i);
				break;
			}
		}
		
		if(_element == null){
			throw new NullPointerException("No data found");
		}
		
		try {
			return this.geoJson.parse(_element.getNodeValue());
		} catch (DOMException e) {
			log.log(Level.SEVERE, "Failed to parse GeoJSON", e);
			throw new IOException(e.getMessage());
		} catch (IllegalAttributeException e) {
			log.log(Level.SEVERE, "Failed to parse GeoJSON", e);
			throw new IOException(e.getMessage());
		}
	}

	public XmlObject encode(Object obj) throws IOException {
		ComplexValueType _type = ComplexValueType.Factory.newInstance();

//		_type.setEncoding("UTF-8");
		_type.setFormat("GeoJSON");
		
		Node _node = _type.getDomNode();
		_node.appendChild(_node.getOwnerDocument().createTextNode(this.geoJson.encode(obj).toString()));
		
		return _type;
	}

	public boolean canParse(XmlObject type) {
		if (type instanceof ComplexValueType) {
			ComplexValueType _type = (ComplexValueType) type;
			if(_type.getFormat().equalsIgnoreCase("GeoJSON")){
				return true;
			}
		}
		return false;
	}

	public boolean canEncode(Object obj) {
		return false;
	}
}
