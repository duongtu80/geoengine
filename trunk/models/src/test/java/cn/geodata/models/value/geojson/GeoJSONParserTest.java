package cn.geodata.models.value.geojson;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.logging.Logger;

import junit.framework.TestCase;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.FeatureCollection;
import org.jdom.output.XMLOutputter;

import cn.geodata.gml.ParserFinder;
import cn.geodata.gml.ParserUtil;
import cn.geodata.models.geojson.GeoJSON;
import cn.geodata.models.geojson.GeoJSONUtil;

public class GeoJSONParserTest extends TestCase {
	private Logger log = Logger.getAnonymousLogger();
	
	public void testTest1() throws Exception {
		
	}
	
	public void atestCompare() throws Exception {
		File[] _files = new File[] {
			new java.io.File("d:\\mfeng\\data\\global\\cities.shp"),
			new java.io.File("d:\\mfeng\\data\\global\\rivers.shp"),
			new java.io.File("d:\\mfeng\\data\\global\\country.shp"),
			new java.io.File("d:\\mfeng\\data\\global\\gaz.shp"),
			new java.io.File("d:\\mfeng\\data\\global\\admin02.shp")
		};
		
		File _outDir = new File("D:\\mfeng\\tmp\\compare");
		StringBuilder _out = new StringBuilder();
		
		Date _start = null;
		for (File _f : _files) {
			_out.append(_f.getName());
			
			ShapefileDataStore _dataStore = new ShapefileDataStore(_f.toURL());
			FeatureCollection _fs = _dataStore.getFeatureSource().getFeatures();
			
			ParserFinder _finder = ParserUtil.createParserFinder();
			XMLOutputter _outputer = new XMLOutputter();
			
			File _outXml = new File(_outDir, _f.getName() + ".xml");
			
			_start = new Date();
			_outputer.output(_finder.encode(_fs), new FileOutputStream(_outXml));
			_out.append("\t" + ((new Date()).getTime() - _start.getTime()));

			_start = new Date();
			_finder.parse(new FileInputStream(_outXml));
			_out.append("\t" + ((new Date()).getTime() - _start.getTime()));
			
			_out.append("\t" + _outXml.length());

//			Date _start = new Date();
			File _outJson = new File(_outDir, _f.getName() + ".txt");
			GeoJSON _json = new GeoJSON();

			JSONObject _object = _json.encode(_fs);
			FileOutputStream _stream = new FileOutputStream(_outJson);

			_start = new Date();
			GeoJSONUtil.writeObject(_object, _stream);
			_out.append("\t" + ((new Date()).getTime() - _start.getTime()));

			_start = new Date();
			_json.parse(FileUtils.readFileToString(_outJson));
			_out.append("\t" + ((new Date()).getTime() - _start.getTime()));

			_out.append("\t" + _outJson.length());

			_out.append("\n");
		}
		
		FileUtils.writeStringToFile(new File("D:\\mfeng\\tmp\\compare\\log." + (new Date()).getTime() + ".txt"), _out.toString());
	}
}
