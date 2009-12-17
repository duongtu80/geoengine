package cn.geodata.gml.define;

import java.util.logging.Logger;

import junit.framework.TestCase;

import org.jdom.Element;

import cn.geodata.models.gml.GMLConfiguration;
import cn.geodata.models.gml.ParserUtil;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;

public class LineStringDefTest extends TestCase {
//	private static Logger log = Logger.getAnonymousLogger();

	public void testParse() throws Exception {
		GMLConfiguration _config = new GMLConfiguration();

		Element _posList = new Element("posList", _config.getUriGML());
		_posList.setText("20 50 30 55 22 35");
		_posList.setAttribute("dimension", "2");
		
		Element _ele = new Element("LineString", _config.getUriGML());
		_ele.addContent(_posList);
		
		LineString _line = (LineString) ParserUtil.createParserFinder().parse(_ele);
		
		assertTrue(_line.getNumPoints() == 3);
	}
	
	public void testEncode() throws Exception {
		GMLConfiguration _config = new GMLConfiguration();

		GeometryFactory _factory = new GeometryFactory();
		LineString _line = _factory.createLineString(new Coordinate[]{
				new Coordinate(20, 30),
				new Coordinate(30, 50),
				new Coordinate(40, 60)}
				);

		Element _ele = ParserUtil.createParserFinder().encode(_line);
		assertNotNull(_ele);
		assertEquals(_ele.getChild("posList", _config.getUriGML()).getText(), "20.0 30.0 30.0 50.0 40.0 60.0");
	}

}
