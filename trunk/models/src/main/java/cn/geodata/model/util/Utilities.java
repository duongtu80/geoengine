package cn.geodata.model.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.apache.xalan.processor.TransformerFactoryImpl;
import org.apache.xerces.jaxp.DocumentBuilderFactoryImpl;
import org.apache.xml.serializer.OutputPropertiesFactory;
import org.apache.xpath.jaxp.XPathFactoryImpl;
import org.geotools.gml3.GMLConfiguration;
import org.geotools.xml.Encoder;
import org.geotools.xml.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import cn.geodata.model.GeoNamespaceContext;

/**
 * @author Fengm
 *
 */
public class Utilities {
	private static Logger Log = Logger.getLogger(Utilities.class);
	private static Utilities instance;
	
	private XPath xpath;
	private DocumentBuilder documentBuilder;
	private Encoder gmlEncoder;
	private Parser gmlParser;
	
	private Map<String, QName> gmlElementMap;
	
	private Utilities(){
		this.xpath = new XPathFactoryImpl().newXPath();
		this.xpath.setNamespaceContext(new GeoNamespaceContext());
		
		DocumentBuilderFactory _builderFactory = new DocumentBuilderFactoryImpl();
		_builderFactory.setNamespaceAware(true);
		try {
			this.documentBuilder = _builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			Log.error("创建DocumentBuilder失败", e);
		}
		
		this.gmlElementMap = new HashMap<String, QName>();
		Properties _props = new Properties();
		try {
			_props.load(Utilities.class.getResourceAsStream("/conf/GmlQName.txt"));
		} catch (IOException e) {
			Log.error("加载GML元素配置文件失败", e);
		}
		
		Pattern _pattern = Pattern.compile("\\{[\"](.+)[\"],\\s*[\"](.+)[\"]\\}");
		for(Object _key : _props.keySet()){
			Matcher _m = _pattern.matcher(_props.get(_key).toString());
			if(_m.matches()){
				this.gmlElementMap.put(_key.toString(), new QName(_m.group(1), _m.group(2)));
			}
		}
		
		GMLConfiguration _gmlConfiguration = new GMLConfiguration();
		
		this.gmlEncoder = new Encoder(_gmlConfiguration);
		this.gmlParser = new Parser(_gmlConfiguration);
	}

	/**
	 * 加载Utilities对象
	 * @return
	 */
	public static Utilities createInstance(){
		if(instance == null){
			instance = new Utilities();
		}
		
		return instance;
	}
	
	/**
	 * 返回默认XPath对象
	 * @return
	 */
	public XPath getXpath() {
		return xpath;
	}
	
	/**
	 * 返回默认DocumentBuilder对象
	 * @return
	 */
	public DocumentBuilder getDocumentBuilder(){
		return this.documentBuilder;
	}
	
	/**
	 * 创建新的DOM对象
	 * @return
	 */
	public Document createBlankDocument() {
		return this.documentBuilder.newDocument();
	}
	
	/**
	 * 获取节点的标识
	 * @param node
	 * @return
	 * @throws XPathExpressionException
	 */
	public String getIdentifier(Node node) throws XPathExpressionException{
		return (String)this.getXpath().evaluate("ows:Identifier/text()", node, XPathConstants.STRING);
	}

	/**
	 * 从字符串解析输入参数
	 * @param node
	 * @param value
	 * @return
	 * @throws Exception
	 */
//	public Object getInputValue(Element node, Element value) throws Exception {
//		int _minOccurs = Integer.parseInt((String)this.getXpath().evaluate("wps:MinimumOccurs", node, XPathConstants.STRING));
//		if(value == null){
//			if(_minOccurs == 0){
//				return null;
//			}
//			else{
//				throw new MissingParameterValueException((String)this.getXpath().evaluate("ows:Title/text()", node, XPathConstants.STRING));				
//			}
//		}
//		Element _valueNode = null;
//		_valueNode = (Element)this.getXpath().evaluate("wps:LiteralValue", value, XPathConstants.NODE);
//		if(_valueNode != null){
//			String _type = (String)this.getXpath().evaluate("wps:LiteralData/ows:DataType/text()", node, XPathConstants.STRING);
//			if(_type == null || _type.length() == 0){
//				_type = "xs:string";
//			}
//			
//			String _valueText = _valueNode.getTextContent();
//			if(_type.equals("xs:string")){
//				return _valueText;
//			}
//			else{
//				if(_type.equals("xs:int")){
//					return Integer.parseInt(_valueText);
//				}
//				if(_type.equals("xs:long")){
//					return Long.parseLong(_valueText);
//				}
//				if(_type.equals("xs:float")){
//					return Float.parseFloat(_valueText);
//				}
//				if(_type.equals("xs:double")){
//					return Double.parseDouble(_valueText);
//				}
//				Log.warn("不支持的类型:" + _type);
//				return _valueText;
//			}
//		}
//		else{
//			_valueNode = (Element)this.getXpath().evaluate("wps:BoundingBoxValue", value, XPathConstants.NODE);
//			if(_valueNode != null){
//				throw new InvalidParameterValueException("不支持BoundingBoxData类型");
//			}
//			else{
//				_valueNode = (Element)this.getXpath().evaluate("wps:ComplexValue", value, XPathConstants.NODE);
//				if(_valueNode != null){
//					//寻找ComplexValue的唯一的可用子元素
//					Element _valueElemnt = null;
//					for(int i=0;i < _valueNode.getChildNodes().getLength();i++){
//						if (_valueNode.getChildNodes().item(i) instanceof Element) {
//							_valueElemnt = (Element)_valueNode.getChildNodes().item(i);
//							break;
//						}
//					}
//					ByteArrayOutputStream _outStream = new ByteArrayOutputStream();
//					Utilities.createInstance().outputDocument(_valueElemnt, _outStream);
//					
//					GMLConfiguration _config = new GMLConfiguration();
//					Parser _parser = new Parser(_config);
//					
//					return _parser.parse(new ByteArrayInputStream(_outStream.toByteArray()));
//				}
//				else{
//					throw new NullPointerException("没有定义输入参数类型");
//				}
//			}
//		}
//	}
	
	/**
	 * 输出DOM
	 * @param doc
	 * @param response
	 * @throws IOException
	 * @throws TransformerException
	 */
	public void outputDocument(Element element, OutputStream stream){
		try {
			Transformer _transformer = (new TransformerFactoryImpl()).newTransformer();
			
			java.util.Properties xmlProps = OutputPropertiesFactory.getDefaultMethodProperties("xml");
			xmlProps.setProperty("indent", "yes");
			xmlProps.setProperty("standalone", "no");
			
			_transformer.setOutputProperties(xmlProps);
			
			_transformer.transform(new DOMSource(element), new StreamResult(stream));
		}
		catch (TransformerConfigurationException e) {
			Log.error("创建Transformer失败", e);
		}
		catch (TransformerException e) {
			Log.error("转换失败", e);
		}
	}

	/**
	 * 将DOM对象序列化为XML文本
	 * @param doc
	 * @return
	 * @throws IOException 
	 */
	public String outputDocument2Text(Element element) throws IOException{
		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
		this.outputDocument(element, _stream);
		
		return new String(_stream.toByteArray(), "UTF-8");
	}
	
	/**
	 * 获取GML元素映射表
	 * @return
	 */
	public Map<String, QName> getGmlElementMap() {
		return gmlElementMap;
	}

	public Encoder getGmlEncoder() {
		return gmlEncoder;
	}

	public Parser getGmlParser() {
		return gmlParser;
	}
}
