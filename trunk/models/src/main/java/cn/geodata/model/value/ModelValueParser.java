package cn.geodata.model.value;

import java.io.IOException;
import java.net.URL;

import org.geotools.feature.FeatureCollection;
import org.jdom.Document;
import org.jdom.input.DOMBuilder;
import org.jdom.input.SAXBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.geodata.gml.ParserUtil;

import net.opengeospatial.wps.ComplexValueType;
import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.LiteralValueType;

public class ModelValueParser {
	
	public Object parseLiteral(LiteralValueType type){
		String _valueString = type.getStringValue();
		
		if(_valueString != null){
			String _type = type.getDataType();
			if(_type == null || _type.length() == 0 || _type.equals("xs:string")){
				return _valueString;
			}
			else if(_type.equals("xs:int") || _type.equals("xs:integer")){
				return Integer.parseInt(_valueString);
			}
			else if(_type.equals("xs:long")){
				return Long.parseLong(_valueString);
			}
			else if(_type.equals("xs:float")){
				return Float.parseFloat(_valueString);
			}
			else if(_type.equals("xs:double")){
				return Double.parseDouble(_valueString);
			}
			else{
				throw new NullPointerException("Does not support require data type");
			}
		}
		else{
			return null;
		}
	}
	
	public String parseLiteralString(LiteralValueType type){
		Object _o = this.parseLiteral(type);
		if(_o != null){
			return _o.toString();
		}
		else{
			return "";
		}
	}
	
	public int parseLiteralInt(LiteralValueType type) throws IOException{
		Object _o = this.parseLiteral(type);
		if (_o instanceof Integer) {
			Integer _val = (Integer) _o;
			return _val.intValue();
		}
		else{
			throw new IOException("Can't be convert to integer");
		}
	}

	public long parseLiteralLong(LiteralValueType type) throws IOException{
		Object _o = this.parseLiteral(type);
		if (_o instanceof Long) {
			Long _val = (Long) _o;
			return _val.longValue();
		}
		else if (_o instanceof Integer) {
			Integer _val = (Integer) _o;
			return _val.intValue();
		}
		else{
			throw new IOException("Can't be convert to long");
		}
	}

	public float parseLiteralFloat(LiteralValueType type) throws IOException{
		Object _o = this.parseLiteral(type);
		if (_o instanceof Float) {
			Float _val = (Float) _o;
			return _val.floatValue();
		}
		else{
			throw new IOException("Can't be convert to float");
		}
	}
	
	public double parseLiteralDouble(LiteralValueType type) throws IOException{
		Object _o = this.parseLiteral(type);
		if (_o instanceof Double) {
			Double _val = (Double) _o;
			return _val.doubleValue();
		}
		else if (_o instanceof Float) {
			Float _val = (Float) _o;
			return _val.floatValue();
		}
		else{
			throw new IOException("Can't be convert to double");
		}
	}
	
	public Object parseComplex(ComplexValueType type) throws Exception {
		if(type.getFormat().equalsIgnoreCase("text/xml") || type.getFormat().equalsIgnoreCase("text/gml")){

			NodeList _nodeList = type.getDomNode().getChildNodes();
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
				return ParserUtil.createParserFinder().encode((new DOMBuilder()).build(_element));
			}
		}
		else{
			throw new IOException("Unsupported complex data format:" + type.getFormat());
		}
	}

	public Object parseComplexReference(IOValueType.ComplexValueReference type) throws Exception {
		if(type.getFormat() == null || type.getFormat().equalsIgnoreCase("text/gml")){
			SAXBuilder _builder = new SAXBuilder();
			Document _doc = _builder.build(new URL(type.getReference()));
			
			return ParserUtil.createParserFinder().parse(_doc.getRootElement());
		}
		else{
			throw new IOException("Unsupported complex reference format:" + type.getFormat());
		}
	}

	public FeatureCollection parseFeatureCollection(ComplexValueType type) throws Exception {
		Object _o = this.parseComplex(type);
		if (_o instanceof FeatureCollection) {
			return (FeatureCollection) _o;
		}
		else{
			throw new IOException("Can't be convert to FeatureCollection");
		}
	}

	public FeatureCollection parseFeatureCollection(IOValueType.ComplexValueReference type) throws Exception {
		Object _o = this.parseComplexReference(type);
		if (_o instanceof FeatureCollection) {
			return (FeatureCollection) _o;
		}
		else{
			throw new IOException("Can't be convert to FeatureCollection");
		}
	}
}
