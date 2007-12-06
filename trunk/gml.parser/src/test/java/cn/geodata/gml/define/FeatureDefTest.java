package cn.geodata.gml.define;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureIterator;
import org.geotools.feature.FeatureType;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import cn.geodata.gml.GMLConfiguration;
import cn.geodata.gml.ParserFinder;
import cn.geodata.gml.ParserUtil;

import junit.framework.TestCase;

public class FeatureDefTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();

	public void testParseFeatureType() throws Exception {
		Element _ele = this.getFeatureElement();
		
		ParserFinder _finder = ParserUtil.createParserFinder();
		
		FeatureType _featureType = _finder.findFeatureParser().parseFeatureType(new Element[] {_ele});
		log.info(_featureType.toString());
		
		Feature _f = _finder.findFeatureParser().parse(_featureType, _ele);
		log.info(_f.toString());
	}
	
	public void atestEncode() throws Exception {
		FeatureIterator _it = new ShapefileDataStore(MultiPolygonDefTest.class.getResource("/data/polygon.test.shp")).getFeatureSource().getFeatures().features();
		Feature _f = _it.next();
		_it.close();
		
		Element _ele = ParserUtil.createParserFinder().encode(_f);
		XMLOutputter _outputer = new XMLOutputter();
		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
		_outputer.output(_ele, _stream);
		
		log.info(new String(_stream.toByteArray()));
	}
	
	private Element getFeatureElement() throws JDOMException, IOException {
		String _gml = "<polygon xmlns=\"http://www.geodata.cn/data\" id=\"polygon.1\"><the_geom><gml:MultiPolygon xmlns:gml=\"http://www.opengis.net/gml\"><gml:polygonMember><gml:Polygon><gml:exterior><gml:posList dimension=\"2\">-113.68957703927492 46.152531419275746 -108.79531722054381 46.22050725009145 -108.79531722054381 46.22050725009145 -109.47507552870091 40.44256163075611 -112.33006042296073 39.83077915341472 -116.68051359516616 43.50147401746305 -113.68957703927492 46.152531419275746</gml:posList></gml:exterior></gml:Polygon></gml:polygonMember></gml:MultiPolygon></the_geom><test1>23.0</test1><test2>11</test2><test3>min</test3></polygon>";
		return (new SAXBuilder()).build(new ByteArrayInputStream(_gml.getBytes())).getRootElement();
	}
}
