package cn.geodata.models.value.geotiff;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import net.opengeospatial.wps.ComplexValueType;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.util.Base64;
import org.geotools.feature.FeatureCollection;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import cn.geodata.models.value.ComplexEncoder;
import cn.geodata.models.value.ComplexParser;

import com.vividsolutions.jts.geom.Geometry;

public class GeoTiffParser implements ComplexParser, ComplexEncoder {
	private static Logger log = Logger.getAnonymousLogger();

	public FeatureCollection parseFeatureCollection(ComplexValueType type)
			throws IOException {
		throw new UnsupportedOperationException();
	}

	public Geometry parseGeometry(ComplexValueType type) throws IOException {
		throw new UnsupportedOperationException();
	}

	public boolean canParse(XmlObject type) {
		if (type instanceof ComplexValueType) {
			ComplexValueType _type = (ComplexValueType) type;
			if(_type.getFormat().equalsIgnoreCase("GeoTIFF")){
				return true;
			}
		}
		return false;
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
		
		//Write it to a temp folder
		File _f = File.createTempFile("geotiff", ".tif");
		FileUtils.writeByteArrayToFile(_f, Base64.decode(_element.getNodeValue().getBytes()));
		
		return _f;
		//Read it into a GridCoverage2D object
//		GeoTiffReader _reader = new GeoTiffReader(_f, null);
//		return _reader.read(null);
	}

	public ComplexValueType encodeFeatureCollection(FeatureCollection fs)
			throws IOException {
		throw new UnsupportedOperationException();
	}

	public ComplexValueType encodeGeometry(Geometry geom) throws IOException {
		throw new UnsupportedOperationException();
	}

	public boolean canEncode(Object obj) {
		if(obj instanceof File){
			File _f = (File) obj;
			if(_f.getName().toLowerCase().endsWith(".tif")){
				return true;
			}
		}
		return false;
//		if (obj instanceof GridCoverage2D) {
//			return true;
//		}
//		return false;
	}

	public XmlObject encode(Object obj) throws IOException {
		File _f = (File) obj;
		
		ComplexValueType _type = ComplexValueType.Factory.newInstance();

		_type.setEncoding("base64");
		_type.setFormat("GeoTIFF");
		
//		XmlBase64BinaryImpl _base64 = new XmlBase64BinaryImpl();
//		_base64.set(Base64.encode(FileUtils.readFileToByteArray(_f)));
//		
//		_type.set(_base64);
		
		Node _node = _type.getDomNode();
		_node.appendChild(_node.getOwnerDocument().createTextNode(new String(Base64.encode(FileUtils.readFileToByteArray(_f)))));
		
//		JavaStringHolder _holder = new JavaStringHolder();
//		_holder.set(new String(Base64.encode(FileUtils.readFileToByteArray(_f))));
//		_type.getDomNode().appendChild( (_holder);
		
		return _type;

	}
}
