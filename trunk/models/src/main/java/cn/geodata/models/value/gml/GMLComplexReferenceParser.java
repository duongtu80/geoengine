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

import com.vividsolutions.jts.geom.Geometry;

import cn.geodata.gml.ParserUtil;
import cn.geodata.models.GeoNamespaceContext;
import cn.geodata.models.value.ComplexReferenceEncoder;
import cn.geodata.models.value.ComplexReferenceParser;
import cn.geodata.models.value.Encoder;
import cn.geodata.models.value.Parser;

public class GMLComplexReferenceParser implements Parser, Encoder, ComplexReferenceParser, ComplexReferenceEncoder {

	@Override
	public FeatureCollection parseFeatureCollection(IOValueType.ComplexValueReference type)
			throws IOException {
		Object _o = this.parse(type);
		if (_o instanceof FeatureCollection) {
			return (FeatureCollection) _o;
		}
		else{
			throw new IOException("Can't be convert to FeatureCollection");
		}
	}

	@Override
	public Object parse(XmlObject type) throws IOException {
		IOValueType.ComplexValueReference _type = (ComplexValueReference) type;
		
		if(_type.getFormat() == null || _type.getFormat().equalsIgnoreCase("text/gml")){
			SAXBuilder _builder = new SAXBuilder();
			Document _doc;
			try {
				_doc = _builder.build(new URL(_type.getReference()));
			} catch (JDOMException e) {
				throw new IOException(e);
			}
			
			return ParserUtil.createParserFinder().parse(_doc.getRootElement());
		}
		else{
			throw new IOException("Unsupported complex reference format:" + _type.getFormat());
		}
	}

	@Override
	public Geometry parseGeometry(ComplexValueType type) throws IOException {
		Object _o = this.parse(type);
		if (_o instanceof Geometry) {
			return (Geometry) _o;
		}
		else{
			throw new IOException("Can't be convert to Geometry");
		}
	}

	@Override
	public XmlObject encode(Object obj) throws IOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public ComplexValueReference encodeGMLUrl(String url, String encoding) throws IOException {
		IOValueType.ComplexValueReference _type = IOValueType.ComplexValueReference.Factory.newInstance();
		
		_type.setReference(url);
		_type.setFormat("text/gml");
		_type.setEncoding(encoding);
		_type.setSchema(GeoNamespaceContext.URI_GML);
		
		return _type;
	}

}
