package cn.geodata.models.gml.define;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.feature.IllegalAttributeException;
import org.geotools.feature.SchemaException;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.Namespace;
import org.opengis.feature.Feature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.feature.type.AttributeType;
import org.opengis.feature.type.FeatureType;
import org.opengis.feature.type.PropertyDescriptor;

import cn.geodata.models.gml.FeatureParser;
import cn.geodata.models.gml.ParserUtil;
import cn.geodata.models.gml.UnsupportedType;

import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;



public class FeatureDef extends AbstractParser implements FeatureParser {
	private static Logger log = ParserUtil.getLogger();

	public boolean canEncode(Object obj) {
		if (obj instanceof Feature) {
			return true;
		}
		return false;
	}

	public boolean canParse(Element ele) {
//		if(ele.getNamespace().equals(this.config.getUriGML())
//				&& ele.getName().equals("Feature")
//				){
//			return true;
//		}
		return false;
	}

	public Element encode(Object obj) throws IOException {
		if(this.canEncode(obj) == false){
			throw new UnsupportedType(obj.toString());
		}
		
		Feature _feature = (Feature) obj;
		FeatureType _featureType = _feature.getType();
		
		Namespace _namespace = Namespace.getNamespace(_featureType.getName().getNamespaceURI());
//		log.info("Feature namespace " + _featureType.getNamespace().toString());
		
		Element _ele = new Element(_featureType.getName().getLocalPart().replace(":", "_"), _namespace);
		_ele.setAttribute("id", _feature.getIdentifier().getID());
		
		Iterator<PropertyDescriptor> _it = _featureType.getDescriptors().iterator();
		while(_it.hasNext()){
			PropertyDescriptor _attributeType = _it.next();
			
			Element _c = new Element(_attributeType.getName().getLocalPart(), _namespace);
			if(_attributeType.equals(_featureType.getGeometryDescriptor())){
				_c.addContent(this.finder.encode(_feature.getProperty(_attributeType.getName())));
			}
			else{
				String _val = "";
				if(_feature.getProperty(_attributeType.getName()) != null){
					_val = _feature.getProperty(_attributeType.getName()).toString();
				}
				
				_c.setText(_val);
			}
			_ele.addContent(_c);
		}
		
		return _ele;
	}

	public Object parse(Element ele) throws IOException {
		throw new UnsupportedOperationException("Feature does not support parse");
	}
	
	public Feature parse(FeatureType featureType, Element ele) throws IOException {
		Namespace _namespace = Namespace.getNamespace(featureType.getName().getNamespaceURI());
		
		ArrayList<Object> _list = new ArrayList<Object>();
		Iterator<PropertyDescriptor> _it = featureType.getDescriptors().iterator();
		while(_it.hasNext()){
			PropertyDescriptor _attributeType = _it.next();
			
			if(_attributeType.getClass().equals(Integer.class)){
				String _value = ele.getChildText(_attributeType.getName().getLocalPart(), _namespace);
				if(_value != null && _value.length() > 0){
					_list.add(Integer.parseInt(_value));					
				}
				else{
					_list.add(null);
				}
			}
			else if(_attributeType.getClass().equals(Float.class)){
				String _value = ele.getChildText(_attributeType.getName().getLocalPart(), _namespace);
				if(_value != null && _value.length() > 0){
					_list.add(Float.parseFloat(_value));					
				}
				else{
					_list.add(null);
				}
			}
			else if(_attributeType.getClass().equals(Double.class)){
				String _value = ele.getChildText(_attributeType.getName().getLocalPart(), _namespace);
				if(_value != null && _value.length() > 0){
					_list.add(Double.parseDouble(_value));					
				}
				else{
					_list.add(null);
				}
			}
			else if(_attributeType.getClass().equals(String.class)){
				String _value = ele.getChildText(_attributeType.getName().getLocalPart(), _namespace);
				if(_value != null && _value.length() > 0){
					_list.add(_value);					
				}
				else{
					_list.add(null);
				}
			}
			else if(_attributeType.getName().equals(featureType.getGeometryDescriptor().getName())){
				Element _child = ele.getChild(_attributeType.getName().getLocalPart(), _namespace);
				_list.add(this.getParserFinder().parse((Element)_child.getChildren().get(0)));
			}
			else{
				throw new IOException("Unrecognized field:" + _attributeType.getName().getLocalPart() + " type:" + _attributeType.getClass().getName());
			}
		}
		
		try {
			String _id = null;
			for(Attribute _attr : (List<Attribute>)ele.getAttributes()){
				if("id".equalsIgnoreCase(_attr.getName()) || "fid".equalsIgnoreCase(_attr.getName())){
					_id = _attr.getValue();
				}
			}
			
			return SimpleFeatureBuilder.build((SimpleFeatureType) featureType, _list, _id);
			
		} catch (IllegalAttributeException e) {
			throw new IOException(e.getMessage());
		}
	}
	
	public FeatureType parseFeatureType(Element[] eles) throws IOException{
		if(eles.length == 0){
			throw new NullPointerException("No element inside");
		}
		
		Element _ele = eles[0];
		
		SimpleFeatureTypeBuilder _builder = new SimpleFeatureTypeBuilder();
		
		for(Element _c : (List<Element>) _ele.getChildren()){
			if(_c.getNamespace().equals(_ele.getNamespace())){
				List<Element> _children = _c.getChildren();
				if(_children.size() == 0){
					parseSimpleElement(eles, _c.getName(), _c.getNamespace(), _builder);
				}
				else if(_children.size() == 1){
					parseComplexElement(eles, _c.getName(), _c.getNamespace(), _builder);
				}
				else{
					log.severe("Node:" + _c.getNamespaceURI() + "#" + _c.getName() + " children size:" + _children.size());
					throw new IOException("Does not support complex field except GML");
				}
			}
			else{
				log.warning("Unparsed node:" + _c.getNamespaceURI() + "#" + _c.getName());
			}
		}
		
		try {
			
			return _builder.buildFeatureType();
		} catch (FactoryRegistryException e) {
			throw new IOException(e.getMessage());
		}
	}
	
	private void parseSimpleElement(Element[] eles, String eleName, Namespace namespace, SimpleFeatureTypeBuilder builder) throws IOException{
		//int 0
		//double 1
		//string 2
		int _type = 0;
		int _len = 0;
		for(Element _ele : eles){
			String _val = _ele.getChildTextTrim(eleName, namespace);
			
			int _newType = evaluateSimpleType(_val);
			if(_newType > _type){
				_type = _newType;
			}
			
			if(_type == 2){
				_len = Math.max(_len, _val.getBytes("UTF-8").length);
			}
		}
		
		switch (_type) {
			case 0:
				builder.add(eleName, Integer.class);
				break;
			case 1:
				builder.add(eleName, Double.class);
				break;
			case 2:
				builder.add(eleName, String.class);
				builder.length(_len);
			default:
				throw new IOException("Unknown type:" + _type);
		}
	}
	
	private int evaluateSimpleType(String val){
		if(Pattern.matches("\\d+", val)){
			return 0;
		}
		else if(Pattern.matches("\\d*\\.\\d*", val)){
			return 1;
		}
		return 2;
	}

	private void parseComplexElement(Element[] eles, String eleName, Namespace namespace, SimpleFeatureTypeBuilder builder) throws UnsupportedType{
		Element _ele = (Element) eles[0].getChild(eleName, namespace).getChildren().get(0);
		
		if(_ele.getNamespace().equals(config.getUriGML()) == false){
			throw new UnsupportedType("Unsupported type " + _ele.getNamespace().toString() + "{" + _ele.getName() + "}");
		}
		
//		AttributeTypeFactory _factory = CommonFactoryFinder.getAttributeTypeFactory(GeoTools.getDefaultHints());
		if(_ele.getName().equalsIgnoreCase("Point")){
			builder.add(eleName, Point.class);
			return;
		}
		if(_ele.getName().equalsIgnoreCase("LineString")){
			builder.add(eleName, LineString.class);
			return;
		}
		if(_ele.getName().equalsIgnoreCase("Polygon")){
			builder.add(eleName, Polygon.class);
			return;
		}
		if(_ele.getName().equalsIgnoreCase("MultiPoint")){
			builder.add(eleName, MultiPoint.class);
			return;
		}
		if(_ele.getName().equalsIgnoreCase("MultiLineString")){
			builder.add(eleName, MultiLineString.class);
			return;
		}
		if(_ele.getName().equalsIgnoreCase("MultiPolygon")){
			builder.add(eleName, MultiPolygon.class);
			return;
		}
		
		throw new UnsupportedType("Unsupported type " + _ele.getNamespace().toString() + "{" + _ele.getName() + "}");
	}
}
