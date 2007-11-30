package cn.geodata.gml.define;

import java.util.logging.Logger;

import junit.framework.TestCase;

import org.jdom.Element;

import cn.geodata.gml.GMLConfiguration;
import cn.geodata.gml.ParserUtil;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class PointDefTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();
	
	public void testParse() throws Exception {
		GMLConfiguration _config = new GMLConfiguration();

		Element _pos = new Element("pos", _config.getUriGML());
		_pos.setText("20 50");
		
		Element _ele = new Element("Point", _config.getUriGML());
		_ele.addContent(_pos);
		
		Point _pt = (Point) ParserUtil.createParserFinder().parse(_ele);
		
		assertEquals(_pt.getX(), 20.0);
		assertEquals(_pt.getY(), 50.0);
	}
	
	public void testEncode() throws Exception {
		GMLConfiguration _config = new GMLConfiguration();

		GeometryFactory _factory = new GeometryFactory();
		Point _pt = _factory.createPoint(new Coordinate(20, 30));
		
		Element _ele = ParserUtil.createParserFinder().encode(_pt);
		assertNotNull(_ele);
		assertEquals(_ele.getChild("pos", _config.getUriGML()).getText(), "20.0 30.0");
	}
}
