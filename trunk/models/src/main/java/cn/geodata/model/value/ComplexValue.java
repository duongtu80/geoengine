package cn.geodata.model.value;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.namespace.QName;

import net.opengeospatial.wps.ComplexValueType;
import net.opengeospatial.wps.IOValueType;

import org.apache.log4j.Logger;
import org.geotools.gml3.GMLConfiguration;
import org.geotools.xml.Encoder;
import org.geotools.xml.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.geodata.model.GeoNamespaceContext;
import cn.geodata.model.util.Utilities;

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
		
		this.setValue(value);
	}
	
	public ComplexValue(IOValueType type) throws Exception{
		super(type);
		
		if(type.getComplexValue().getEncoding().equalsIgnoreCase("text/xml") || type.getComplexValue().getEncoding().equalsIgnoreCase("text/gml")){
			if(type.getComplexValue().getSchema().startsWith(GeoNamespaceContext.URI_GML_3_1_1_SCHEMA) == false){
				throw new Exception("Only supports GML 3.1.1");
			}
			
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
				ByteArrayOutputStream _stream = new ByteArrayOutputStream();
				Utilities.createInstance().outputDocument(_element, _stream);

//				Log.debug("Complex type:" + new String(_stream.toByteArray(), "UTF-8"));
				setValue(Utilities.createInstance().getGmlParser().parse(new ByteArrayInputStream(_stream.toByteArray())));
			}
			
			this.parsed = true;
		}
		else{
			//Set the complex value to object if not GML
			setValue(type.getComplexValue());
			this.parsed = false;
		}
	}
	
	public void setValue(Object value) throws Exception {
		if(value == null){
			throw new NullPointerException("不能提供空值");
		}
		
		if(Utilities.createInstance().getGmlElementMap().containsKey(value.getClass().getName())){
			this.qname = Utilities.createInstance().getGmlElementMap().get(value.getClass().getName());
			this.value = value;
		}
		else{
			throw new Exception("不支持当前GML元素类型:" + value.getClass().getName());
		}
	}

	@Override
	protected Element encodeValue(Document doc) throws Exception {
		if(this.value == null){
			throw new NullPointerException("没有赋值");
		}
		
		Element _valueNode = doc.createElementNS(GeoNamespaceContext.URI_WPS, "ComplexValue");
		
		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
		Encoder _encoder = new Encoder(new GMLConfiguration());
		_encoder.encode(this.value, this.qname, _stream);
		
		Document _gmlDoc = Utilities.createInstance().getDocumentBuilder().parse(new ByteArrayInputStream(_stream.toByteArray()));
		_valueNode.appendChild(doc.importNode(_gmlDoc.getDocumentElement(), true));
		
		return _valueNode;
	}

	public Object getValue() {
		return value;
	}
	
	@Override
	public void encode(IOValueType type) throws Exception {
		super.encode(type);
		
		if(this.value == null){
			throw new NullPointerException("Not found input complex value");
		}
		
		ComplexValueType _valueNode = type.addNewComplexValue();

		_valueNode.setEncoding("UTF-8");
		_valueNode.setFormat("text/xml");
		
		ByteArrayOutputStream _bufferStream = new ByteArrayOutputStream();
		
		Utilities.createInstance().getGmlEncoder().encode(this.getValue(), this.getQname(), _bufferStream);
		
		Document _gmlDoc = Utilities.createInstance().getDocumentBuilder().parse(new ByteArrayInputStream(_bufferStream.toByteArray()));
		Node _node = _valueNode.getDomNode();
		_node.appendChild(_node.getOwnerDocument().importNode(_gmlDoc.getDocumentElement(), true));

		_valueNode.setSchema(GeoNamespaceContext.URI_GML_3_1_1_SCHEMA + "#" + _gmlDoc.getDocumentElement().getLocalName());
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
