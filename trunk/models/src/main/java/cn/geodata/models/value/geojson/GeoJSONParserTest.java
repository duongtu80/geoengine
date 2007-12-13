package cn.geodata.models.value.geojson;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.logging.Logger;

import net.sf.json.util.JSONUtils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.FeatureCollection;
import org.jdom.output.XMLOutputter;

import cn.geodata.gml.ParserFinder;
import cn.geodata.gml.ParserUtil;
import cn.geodata.models.geojson.GeoJSON;

import junit.framework.TestCase;

public class GeoJSONParserTest extends TestCase {
	private Logger log = Logger.getAnonymousLogger();
	
	public void testCompare() throws Exception {
		ShapefileDataStore _dataStore = new ShapefileDataStore((new java.io.File("d:\\mfeng\\data\\world\\WorldCountries.shp")).toURL());
		FeatureCollection _fs = _dataStore.getFeatureSource().getFeatures();
		
//		ParserFinder _finder = ParserUtil.createParserFinder();
//		XMLOutputter _outputer = new XMLOutputter();		
//		File _outXml = new File("D:\\mfeng\\tmp\\compare\\gml.xml");
//		
//		Date _start = new Date();
//		_outputer.output(_finder.encode(_fs), new FileOutputStream(_outXml));
//		log.info("" + ((new Date()).getTime() - _start.getTime()));
//		
		Date _start = new Date();
		File _outJson = new File("D:\\mfeng\\tmp\\compare\\json.txt");
		GeoJSON _json = new GeoJSON();
		
		FileUtils.writeStringToFile(_outJson, _json.encode(_fs).toString());
		log.info("" + ((new Date()).getTime() - _start.getTime()));
	}
}
