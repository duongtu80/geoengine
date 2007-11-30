package cn.geodata.model.value;

import javax.xml.namespace.QName;

import net.opengeospatial.wps.ComplexValueType;
import net.opengeospatial.wps.IOValueType;

import org.apache.log4j.Logger;
import org.jdom.input.DOMBuilder;
import org.jdom.output.DOMOutputter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.geodata.gml.ParserFinder;
import cn.geodata.gml.ParserUtil;

/**
 * The complex value
 * 
 * @author Tank
 *
 */
public class ComplexValue extends ModelValue {
	private static Logger Log = Logger.getLogger(ComplexValue.class);
	
	protected Object value;
	protected QName qname;
	protected boolean parsed;
	
	public QName getQname() {
		return qname;
	}

	public void setQname(QName qname) {
		this.qname = qname;
	}

	public ComplexValue(String identifier, String title, String describe, Object value) throws Exception{
		super(identifier, title, describe);
		
		this.value = value;
		this.qname = null;
	}
	
	public ComplexValue(IOValueType type) throws Exception{
		super(type);
		
		if(type.getComplexValue().getFormat().equalsIgnoreCase("text/xml") || type.getComplexValue().getFormat().equalsIgnoreCase("text/gml")){
//			if(type.getComplexValue().getSchema().startsWith(GeoNamespaceContext.URI_GML_3_1_1_SCHEMA) == false){
//				throw new Exception("Only supports GML 3.1.1");
//			}
//			
			NodeList _nodeList = type.getComplexValue().getDomNode().getChildNodes();
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
//				ByteArrayOutputStream _stream = new ByteArrayOutputStream();
//				Utilities.createInstance().outputDocument(_element, _stream);
//
//				Log.debug("Complex type:" + new String(_stream.toByteArray(), "UTF-8"));
				
				this.value = ParserUtil.createParserFinder().encode((new DOMBuilder()).build(_element));
				this.qname = null;
			}
			
			this.parsed = true;
		}
		else{
			//Set the complex value to object if not GML
			this.value = type.getComplexValue();
			this.value = null;
			this.parsed = false;
		}
	}
	
//	@Override
//	protected Element encodeValue(Document doc) throws Exception {
//		if(this.value == null){
//			throw new NullPointerException("No value");
//		}
//		
//		return ParserUtil.createParserFinder().encode(obj)
//		Element _valueNode = doc.createElementNS(GeoNamespaceContext.URI_WPS, "ComplexValue");
//		
//		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
//		Encoder _encoder = new Encoder(new GMLConfiguration());
//		_encoder.encode(this.value, this.qname, _stream);
//		
//		Document _gmlDoc = Utilities.createInstance().getDocumentBuilder().parse(new ByteArrayInputStream(_stream.toByteArray()));
//		_valueNode.appendChild(doc.importNode(_gmlDoc.getDocumentElement(), true));
//		
//		return _valueNode;
//	}

	public Object getValue() {
		return value;
	}
	
	@Override
	public void encode(IOValueType type) throws Exception {
		super.encode(type);
		
		if(this.value == null){
			throw new NullPointerException("Not found input complex value");
		}
		
		ParserFinder _finder = ParserUtil.createParserFinder();
		org.jdom.Document _doc = new org.jdom.Document(_finder.encode(this.value));
		
		Document _outputDoc = (new DOMOutputter()).output(_doc);
		
		ComplexValueType _valueNode = type.addNewComplexValue();

		_valueNode.setEncoding("UTF-8");
		_valueNode.setFormat("text/gml");
		_valueNode.setSchema(_finder.getConfig().getUriGML().getURI());
		
		Node _node = _valueNode.getDomNode();
		_node.appendChild(_node.getOwnerDocument().importNode(_outputDoc.getDocumentElement(), true));
	}

	/**
	 * 
	 * @return did the complex value being parsed into objects
	 */
	public boolean isParsed() {
		return parsed;
	}

	public void setParsed(boolean parsed) {
		this.parsed = parsed;
	}
}
