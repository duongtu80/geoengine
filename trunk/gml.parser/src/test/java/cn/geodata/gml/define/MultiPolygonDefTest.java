package cn.geodata.gml.define;

import java.io.ByteArrayOutputStream;
import java.util.logging.Logger;

import junit.framework.TestCase;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureIterator;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import cn.geodata.gml.GMLConfiguration;

public class MultiPolygonDefTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();

	public void testEncode() throws Exception {
		FeatureIterator _it = new ShapefileDataStore(MultiPolygonDefTest.class.getResource("/data/polygon.test.shp")).getFeatureSource().getFeatures().features();
		Feature _f = _it.next();
		_it.close();
		
		Element _ele = ParserFinder.getInstance().encode(_f.getDefaultGeometry());
		XMLOutputter _outputer = new XMLOutputter();
		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
		_outputer.output(_ele, _stream);
		
		log.info(new String(_stream.toByteArray()));
	}

	public void testParse() {
//		fail("Not yet implemented");
	}

}
