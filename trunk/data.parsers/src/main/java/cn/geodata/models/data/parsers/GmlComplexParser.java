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

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.data.ComplexParser;
import cn.geodata.models.data.Utilities;
import cn.geodata.models.gml.ParserFinder;
import cn.geodata.models.gml.ParserUtil;

public class GmlComplexParser implements ComplexParser {
	private static Logger log = Utilities.getLogger();
	private ParserFinder finder;
	
	public GmlComplexParser() {
		this.finder = ParserUtil.createParserFinder();
	}
	
	public List<DataCategory> getCategories() {
		DataCategories _c = DataCategories.getInstance();
		
		List<DataCategory> _list = new ArrayList<DataCategory>();
		_list.add(_c.findCategory("point"));
		_list.add(_c.findCategory("lineString"));
		_list.add(_c.findCategory("polygon"));
		_list.add(_c.findCategory("multiPoint"));
		_list.add(_c.findCategory("multiLineString"));
		_list.add(_c.findCategory("multiPolygon"));
		_list.add(_c.findCategory("featureCollection"));
		
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
