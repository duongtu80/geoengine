package cn.geodata.models.gml.define;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.feature.AttributeType;
import org.geotools.feature.AttributeTypeFactory;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureType;
import org.geotools.feature.IllegalAttributeException;
import org.geotools.feature.SchemaException;
import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.Namespace;

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
		FeatureType _featureType = _feature.getFeatureType();
		
		Namespace _namespace = Namespace.getNamespace(_featureType.getNamespace().toString());
//		log.info("Feature namespace " + _featureType.getNamespace().toString());
		
		Element _ele = new Element(_featureType.getTypeName(), _namespace);
		_ele.setAttribute("id", _feature.getID());
		
		for(int i=0;i<_featureType.getAttributeCount();i++){
			AttributeType _attributeType = _featureType.getAttributeType(i);
			
			Element _c = new Element(_attributeType.getLocalName(), _namespace);
			if(_attributeType.equals(_featureType.getDefaultGeometry())){
				_c.addContent(this.finder.encode(_feature.getAttribute(i)));
			}
			else{
				String _val = "";
				if(_feature.getAttribute(i) != null){
					_val = _feature.getAttribute(i).toString();
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
		Namespace _namespace = Namespace.getNamespace(featureType.getNamespace().toString());
		
		ArrayList<Object> _list = new ArrayList<Object>();
		for(AttributeType _attributeType : featureType.getAttributeTypes()){
			if(_attributeType.getBinding().equals(Integer.class)){
				String _value = ele.getChildText(_attributeType.getLocalName(), _namespace);
				if(_value != null && _value.length() > 0){
					_list.add(Integer.parseInt(_value));					
				}
				else{
					_list.add(_attributeType.createDefaultValue());
				}
			}
			else if(_attributeType.getBinding().equals(Float.class)){
				String _value = ele.getChildText(_attributeType.getLocalName(), _namespace);
				if(_value != null && _value.length() > 0){
					_list.add(Float.parseFloat(_value));					
				}
				else{
					_list.add(_attributeType.createDefaultValue());
				}
			}
			else if(_attributeType.getBinding().equals(Double.class)){
				String _value = ele.getChildText(_attributeType.getLocalName(), _namespace);
				if(_value != null && _value.length() > 0){
					_list.add(Double.parseDouble(_value));					
				}
				else{
					_list.add(_attributeType.createDefaultValue());
				}
			}
			else if(_attributeType.getBinding().equals(String.class)){
				String _value = ele.getChildText(_attributeType.getLocalName(), _namespace);
				if(_value != null && _value.length() > 0){
					_list.add(_value);					
				}
				else{
					_list.add(_attributeType.createDefaultValue());
				}
			}
			else if(_attributeType.getLocalName().equals(featureType.getDefaultGeometry().getLocalName())){
				Element _child = ele.getChild(_attributeType.getLocalName(), _namespace);
				_list.add(this.getParserFinder().parse((Element)_child.getChildren().get(0)));
			}
			else{
				throw new IOException("Unrecognized field:" + _attributeType.getLocalName() + " type:" + _attributeType.getBinding().getName());
			}
		}
		
		try {
			String _id = null;
			for(Attribute _attr : (List<Attribute>)ele.getAttributes()){
				if("id".equalsIgnoreCase(_attr.getName()) || "fid".equalsIgnoreCase(_attr.getName())){
					_id = _attr.getValue();
				}
			}
			return featureType.create(_list.toArray(), _id);
		} catch (IllegalAttributeException e) {
			throw new IOException(e);
		}
	}
	
	public FeatureType parseFeatureType(Element[] eles) throws IOException{
		if(eles.length == 0){
			throw new NullPointerException("No element inside");
		}
		
		Element _ele = eles[0];
		List<AttributeType> _attributes = new ArrayList<AttributeType>();
		
		for(Element _c : (List<Element>) _ele.getChildren()){
			if(_c.getNamespace().equals(_ele.getNamespace())){
				List<Element> _children = _c.getChildren();
				if(_children.size() == 0){
					_attributes.add(parseSimpleElement(eles, _c.getName(), _c.getNamespace()));
				}
				else if(_children.size() == 1){
					_attributes.add(parseComplexElement(eles, _c.getName(), _c.getNamespace()));
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
			return CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType((AttributeType[])_attributes.toArray(new AttributeType[0]), _ele.getName(), new URI(_ele.getNamespace().getURI()));
		} catch (FactoryRegistryException e) {
			throw new IOException(e);
		} catch (SchemaException e) {
			throw new IOException(e);
		} catch (URISyntaxException e) {
			throw new IOException(e);
		}
	}
	
	private AttributeType parseSimpleElement(Element[] eles, String eleName, Namespace namespace) throws IOException{
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
				return AttributeTypeFactory.newAttributeType(eleName, Integer.class);
			case 1:
				return AttributeTypeFactory.newAttributeType(eleName, Double.class);
			case 2:
				return AttributeTypeFactory.newAttributeType(eleName, String.class, true, _len);
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

	private AttributeType parseComplexElement(Element[] eles, String eleName, Namespace namespace) throws UnsupportedType{
		Element _ele = (Element) eles[0].getChild(eleName, namespace).getChildren().get(0);
		
		if(_ele.getNamespace().equals(config.getUriGML()) == false){
			throw new UnsupportedType("Unsupported type " + _ele.getNamespace().toString() + "{" + _ele.getName() + "}");
		}
		
//		AttributeTypeFactory _factory = CommonFactoryFinder.getAttributeTypeFactory(GeoTools.getDefaultHints());
		if(_ele.getName().equalsIgnoreCase("Point")){
			return AttributeTypeFactory.newAttributeType(eleName, Point.class);
		}
		if(_ele.getName().equalsIgnoreCase("LineString")){
			return AttributeTypeFactory.newAttributeType(eleName, LineString.class);
		}
		if(_ele.getName().equalsIgnoreCase("Polygon")){
			return AttributeTypeFactory.newAttributeType(eleName, Polygon.class);
		}
		if(_ele.getName().equalsIgnoreCase("MultiPoint")){
			return AttributeTypeFactory.newAttributeType(eleName, MultiPoint.class);
		}
		if(_ele.getName().equalsIgnoreCase("MultiLineString")){
			return AttributeTypeFactory.newAttributeType(eleName, MultiLineString.class);
		}
		if(_ele.getName().equalsIgnoreCase("MultiPolygon")){
			return AttributeTypeFactory.newAttributeType(eleName, MultiPolygon.class);
		}
		
		throw new UnsupportedType("Unsupported type " + _ele.getNamespace().toString() + "{" + _ele.getName() + "}");
	}
}
