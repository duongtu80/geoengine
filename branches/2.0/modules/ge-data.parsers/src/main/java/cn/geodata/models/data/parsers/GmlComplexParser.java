package cn.geodata.models.data.parsers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import org.geotools.feature.FeatureCollection;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import cn.geodata.models.data.ComplexParser;
import cn.geodata.models.data.Utilities;
import cn.geodata.models.gml.ParserFinder;
import cn.geodata.models.gml.ParserUtil;

import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

public class GmlComplexParser implements ComplexParser {
	private static Logger log = Utilities.getLogger();
	private ParserFinder finder;
	
	public GmlComplexParser() {
		this.finder = ParserUtil.createParserFinder();
	}
	
	public List<Class> getCategories() {
		List<Class> _list = new ArrayList<Class>();
		_list.add(Point.class);
		_list.add(LineString.class);
		_list.add(Polygon.class);
		_list.add(MultiPoint.class);
		_list.add(MultiLineString.class);
		_list.add(MultiPolygon.class);
		_list.add(FeatureCollection.class);
		
		return _list;
	}

	public List<MimeType> getMimes() {
		try {
			return Arrays.asList(new MimeType[]{new MimeType("text/xml"), new MimeType("text/gml")});
		} catch (MimeTypeParseException e) {
			log.log(Level.WARNING, "Failed to create MIME list", e);
			return null;
		}
	}

	public Object parse(InputStream stream, MimeType mime, Map<String, Object> params) throws IOException {
		try {
			return this.finder.parse((new SAXBuilder()).build(stream).getRootElement());
		} catch (JDOMException e) {
			log.log(Level.SEVERE, "Failed to parse the xml", e);
			throw new IOException("Failed to parse the xml");
		}
	}

	public InputStream encode(Object obj, MimeType mime, Map<String, Object> params) throws IOException {
		Element _ele = finder.encode(obj);
		XMLOutputter _outputter = new XMLOutputter();
		
		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
		_outputter.output(_ele, _stream);
		
		return new ByteArrayInputStream(_stream.toByteArray());
	}
}
