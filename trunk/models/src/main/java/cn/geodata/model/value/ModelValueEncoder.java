package cn.geodata.model.value;

import org.geotools.feature.FeatureCollection;
import org.jdom.Element;
import org.w3c.dom.Node;

import cn.geodata.gml.ParserUtil;

import net.opengeospatial.wps.ComplexValueType;
import net.opengeospatial.wps.LiteralValueType;

public class ModelValueEncoder {
	public LiteralValueType encodeLiteral(int val){
		LiteralValueType _type = LiteralValueType.Factory.newInstance();

		_type.setDataType("xs:int");
		_type.setStringValue(Integer.toString(val));
		
		return _type;
	}
	
	public LiteralValueType encodeLiteral(long val){
		LiteralValueType _type = LiteralValueType.Factory.newInstance();

		_type.setDataType("xs:long");
		_type.setStringValue(Long.toString(val));
		
		return _type;
	}
	
	public LiteralValueType encodeLiteral(float val){
		LiteralValueType _type = LiteralValueType.Factory.newInstance();

		_type.setDataType("xs:float");
		_type.setStringValue(Float.toString(val));
		
		return _type;
	}
	
	public LiteralValueType encodeLiteral(double val){
		LiteralValueType _type = LiteralValueType.Factory.newInstance();

		_type.setDataType("xs:double");
		_type.setStringValue(Double.toString(val));
		
		return _type;
	}
	
	public ComplexValueType encodeGML(FeatureCollection fs){
		return null;
//		Element _ele = ParserUtil.createParserFinder().encode(fs);
//		
//		ComplexValueType _type = ComplexValueType.Factory.;
//		ComplexValueType _valueNode = type.addNewComplexValue();
//
//		_valueNode.setEncoding("UTF-8");
//		_valueNode.setFormat("text/gml");
//		_valueNode.setSchema(_finder.getConfig().getUriGML().getURI());
//		
//		Node _node = _valueNode.getDomNode();
//		_node.appendChild(_node.getOwnerDocument().importNode(_outputDoc.getDocumentElement(), true));
	}
}
