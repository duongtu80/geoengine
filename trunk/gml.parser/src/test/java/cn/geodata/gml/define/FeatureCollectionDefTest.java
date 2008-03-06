package cn.geodata.gml.define;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.logging.Logger;

import junit.framework.TestCase;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.FeatureCollection;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import cn.geodata.models.gml.ParserFinder;
import cn.geodata.models.gml.ParserUtil;

public class FeatureCollectionDefTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();

	public void atestParse() throws Exception {
		FeatureCollection _fs = new ShapefileDataStore(FeatureCollectionDefTest.class.getResource("/data/polygon.test.shp")).getFeatureSource().getFeatures();
		ParserFinder _finder = ParserUtil.createParserFinder();
		
		Element _ele = _finder.encode(_fs);
		
		XMLOutputter _outputer = new XMLOutputter();
		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
		_outputer.output(_ele, _stream);
		
		log.info("GML:" + new String(_stream.toByteArray()));
		log.info("Obj:" + _finder.parse(_ele).toString());
	}

	public void testWFS() throws Exception {
//		SAXBuilder _builder = new SAXBuilder();
//		Document _doc = _builder.build(new URL("http://127.0.0.1:18080/geoserver/wfs?service=WFS&request=GetFeature&typename=unep:cities&version=1.0.0"));
//		
//		log.info(ParserUtil.createParserFinder().parse(_doc.getRootElement()).toString());
	}
}
