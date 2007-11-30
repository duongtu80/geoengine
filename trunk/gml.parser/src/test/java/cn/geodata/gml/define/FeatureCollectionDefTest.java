package cn.geodata.gml.define;

import java.io.ByteArrayOutputStream;
import java.util.logging.Logger;

import junit.framework.TestCase;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.FeatureCollection;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import cn.geodata.gml.ParserFinder;
import cn.geodata.gml.ParserUtil;

public class FeatureCollectionDefTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();

	public void testParse() throws Exception {
		FeatureCollection _fs = new ShapefileDataStore(MultiPolygonDefTest.class.getResource("/data/polygon.test.shp")).getFeatureSource().getFeatures();
		ParserFinder _finder = ParserUtil.createParserFinder();
		
		Element _ele = _finder.encode(_fs);
		
		XMLOutputter _outputer = new XMLOutputter();
		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
		_outputer.output(_ele, _stream);
		
		log.info("GML:" + new String(_stream.toByteArray()));
		log.info("Obj:" + _finder.parse(_ele).toString());
	}

}
