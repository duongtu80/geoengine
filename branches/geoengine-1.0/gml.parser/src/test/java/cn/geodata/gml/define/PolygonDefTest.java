package cn.geodata.gml.define;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.logging.Logger;

import junit.framework.TestCase;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import cn.geodata.models.gml.GMLConfiguration;
import cn.geodata.models.gml.ParserUtil;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Polygon;

public class PolygonDefTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();
	
	public void testParse() throws Exception {
		GMLConfiguration _config = new GMLConfiguration();		
		
		Document _doc = (new SAXBuilder()).build(new ByteArrayInputStream("<gml:Polygon xmlns:gml=\"http://www.opengis.net/gml\"><gml:exterior><gml:posList dimension=\"2\">0.0 20.0 20.0 20.0 20.0 40.0 0.0 20.0</gml:posList></gml:exterior></gml:Polygon>".getBytes()));
		Element _ele = _doc.getRootElement();
		
		Polygon _poly = (Polygon) ParserUtil.createParserFinder().parse(_ele);
		
		log.info("" + _poly.getExteriorRing().getNumPoints());
		assertTrue(_poly.getExteriorRing().getNumPoints() > 0);
	}
	
	public void testEncode() throws Exception {
		Coordinate[] _exterior = new Coordinate[4];
		_exterior[0] = new Coordinate(0, 20);
		_exterior[1] = new Coordinate(20, 20);
		_exterior[2] = new Coordinate(20, 40);
		_exterior[3] = new Coordinate(0, 20);
		
		GeometryFactory _factory = new GeometryFactory();
		Polygon _polygon = _factory.createPolygon(_factory.createLinearRing(_exterior), null);
		
		GMLConfiguration _config = new GMLConfiguration();

		log.info(_polygon.getClass().getName());
		Element _ele = ParserUtil.createParserFinder().encode(_polygon);
		
		assertNotNull(_ele);
		
		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
		XMLOutputter _outputer = new XMLOutputter();
		_outputer.output(_ele, _stream);
		
		log.info(new String(_stream.toByteArray()));
//		assertEquals(_ele.getChild("pos", _config.getUriGML()).getText(), "20.0 30.0");
	}
}
