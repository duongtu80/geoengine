package cn.geodata.gml.define;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.logging.Logger;

import junit.framework.TestCase;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.FeatureIterator;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.opengis.feature.Feature;

import cn.geodata.models.gml.ParserUtil;

public class MultiPolygonDefTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();

	public void testEncode() throws Exception {
		FeatureIterator _it = new ShapefileDataStore(MultiPolygonDefTest.class.getResource("/data/polygon.test.shp")).getFeatureSource().getFeatures().features();
		Feature _f = _it.next();
		_it.close();
		
		Element _ele = ParserUtil.createParserFinder().encode(_f.getDefaultGeometryProperty());
		XMLOutputter _outputer = new XMLOutputter();
		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
		_outputer.output(_ele, _stream);
		
		log.info(new String(_stream.toByteArray()));
	}

	public void testParse() throws Exception {
		String _gml = "<gml:MultiPolygon xmlns:gml=\"http://www.opengis.net/gml\"><gml:polygonMember><gml:Polygon><gml:exterior><gml:posList dimension=\"2\">-113.68957703927492 46.152531419275746 -108.79531722054381 46.22050725009145 -108.79531722054381 46.22050725009145 -109.47507552870091 40.44256163075611 -112.33006042296073 39.83077915341472 -116.68051359516616 43.50147401746305 -113.68957703927492 46.152531419275746</gml:posList></gml:exterior></gml:Polygon></gml:polygonMember></gml:MultiPolygon>";
		Element _ele = (new SAXBuilder()).build(new ByteArrayInputStream(_gml.getBytes())).getRootElement();
		
		log.info(ParserUtil.createParserFinder().parse(_ele).toString());
//		fail("Not yet implemented");
	}

}
