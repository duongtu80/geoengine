package cn.geodata.models.value.gml;

import java.io.IOException;
import java.net.URL;

import net.opengeospatial.wps.ComplexValueType;
import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.IOValueType.ComplexValueReference;

import org.apache.xmlbeans.XmlObject;
import org.geotools.feature.FeatureCollection;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import cn.geodata.models.GeoNamespaceContext;
import cn.geodata.models.gml.ParserUtil;
import cn.geodata.models.value.ReferenceEncoder;
import cn.geodata.models.value.ReferenceParser;

import com.vividsolutions.jts.geom.Geometry;

public class GMLReferenceParser implements ReferenceParser, ReferenceEncoder {

	public FeatureCollection parseFeatureCollection(IOValueType.ComplexValueReference type)
			throws IOException {
		return (FeatureCollection) this.parse(type);
	}

	public Geometry parseGeometry(ComplexValueType type) throws IOException {
		return (Geometry) this.parse(type);
	}

	public Object parse(XmlObject type) throws IOException {
		IOValueType.ComplexValueReference _type = (ComplexValueReference) type;
		
		if(_type.getFormat() == null || _type.getFormat().equalsIgnoreCase("text/gml")){
			SAXBuilder _builder = new SAXBuilder();
			Document _doc;
			try {
				_doc = _builder.build(new URL(_type.getReference()));
			} catch (JDOMException e) {
				throw new IOException(e.getMessage());
			}
			
			return ParserUtil.createParserFinder().parse(_doc.getRootElement());
		}
		else{
			throw new IOException("Unsupported complex reference format:" + _type.getFormat());
		}
	}

	public XmlObject encode(Object obj) throws IOException {
		throw new UnsupportedOperationException();
	}

	public ComplexValueReference encodeUrl(String url, String format, String encoding, String schema) throws IOException {
		IOValueType.ComplexValueReference _type = IOValueType.ComplexValueReference.Factory.newInstance();
		
		_type.setReference(url.toString());
		if(format != null){
			_type.setFormat(format);
		}
		if(encoding != null){
			_type.setEncoding(encoding);
		}
		if(schema != null){
			_type.setSchema(schema);
		}

		return _type;
	}

	public boolean canParse(XmlObject type) {
		if (type instanceof IOValueType.ComplexValueReference) {
			IOValueType.ComplexValueReference _type = (IOValueType.ComplexValueReference) type;
			if(_type.getFormat().equalsIgnoreCase("text/gml")){
				return true;
			}
		}
		return false;
	}

	public boolean canEncode(Object obj) {
		//ComplexReference type can't be encoded by default parameters
		return false;
	}

}
