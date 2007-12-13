package cn.geodata.models.geojson;

import java.util.logging.Logger;

import org.geotools.feature.FeatureCollection;

import junit.framework.TestCase;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

public class GeoJSONTest extends TestCase {
	private Logger log = Logger.getAnonymousLogger();
	
	public void testPoint() throws Exception {
		GeoJSON _json = new GeoJSON();
		String _txt = "{\"type\": \"Point\", \"coordinates\": [100.0, 0.0]}";
		
		Object _obj = _json.parse(_txt);
		log.info(_obj.toString());
		log.info(_json.encodePoint((Point)_obj).toString());
	}

	public void testLine() throws Exception {
		GeoJSON _json = new GeoJSON();
		String _txt = "{\"type\": \"LineString\", \"coordinates\": [[100.0, 0.0], [101.0, 1.0]]}";
		
		Object _obj = _json.parse(_txt);
		log.info(_obj.toString());
		log.info(_json.encodeLineString((LineString)_obj).toString());
	}

	public void testPolygon() throws Exception {
		GeoJSON _json = new GeoJSON();
		String _txt = "{\"type\": \"Polygon\", \"coordinates\": [[ [100.0, 0.0], [101.0, 0.0], [101.0, 1.0], [100.0, 1.0], [100.0, 0.0] ]]}";
		
		Object _obj = _json.parse(_txt);
		log.info(_obj.toString());
		log.info(_json.encodePolygon((Polygon)_obj).toString());
	}

	public void testMultiPoint() throws Exception {
		GeoJSON _json = new GeoJSON();
		String _txt = "{ \"type\": \"MultiPoint\", \"coordinates\": [ [100.0, 0.0], [101.0, 1.0] ]}";
		
		Object _obj = _json.parse(_txt);
		log.info(_obj.toString());
		log.info(_json.encodeMultiPoint((MultiPoint)_obj).toString());
	}

	public void testMultiLineString() throws Exception {
		GeoJSON _json = new GeoJSON();
		String _txt = "{ \"type\": \"MultiLineString\", \"coordinates\": [ [ [100.0, 0.0], [101.0, 1.0] ], [ [102.0, 2.0], [103.0, 3.0] ] ]}";
		
		Object _obj = _json.parse(_txt);
		log.info(_obj.toString());
		log.info(_json.encodeMultiLineString((MultiLineString)_obj).toString());
	}

	public void testMultiPolygon() throws Exception {
		GeoJSON _json = new GeoJSON();
		String _txt = "{   \"type\": \"MultiPolygon\",   \"coordinates\": [       [           [ [102.0, 2.0], [103.0, 2.0], [103.0, 3.0], [102.0, 3.0], [102.0, 2.0] ]       ],       [           [ [100.0, 0.0], [101.0, 0.0], [101.0, 1.0], [100.0, 1.0], [100.0, 0.0] ],           [ [100.2, 0.2], [100.8, 0.2], [100.8, 0.8], [100.2, 0.8], [100.2, 0.2] ]       ]   ]}";
		
		Object _obj = _json.parse(_txt);
		log.info(_obj.toString());
		log.info(_json.encodeMultiPolygon((MultiPolygon)_obj).toString());
	}
	
	public void testBox() throws Exception {
		GeoJSON _json = new GeoJSON();
		String _txt = "{   \"type\": \"Box\", \"coordinates\": [[100.0, 0.0], [101.0, 1.0]]}";
		
		Object _obj = _json.parse(_txt);
		log.info(_obj.toString());
		log.info(_json.encodeBox((Envelope)_obj).toString());
	}
	
	public void testFeatureCollection() throws Exception {
		GeoJSON _json = new GeoJSON();
		String _txt = "{   \"type\": \"FeatureCollection\",   \"members\": [       {           \"type\": \"Feature\",           \"id\": \"id0\",           \"geometry\": {               \"type\": \"LineString\",               \"coordinates\": [                   [102.0, 0.0], [103.0, 1.0], [104.0, 0.0], [105.0, 1.0]               ]           },           \"properties\": {               \"prop0\": \"value0\",               \"prop1\": \"value1\"           }       },       {           \"type\": \"Feature\",           \"id\": \"id1\",           \"geometry\": {               \"type\": \"LineString\",\"coordinates\": [[100.0, 0.0], [101.0, 0.0], [101.0, 1.0], [100.0, 1.0]]}, \"properties\": {\"prop0\": \"value0\",\"prop1\": \"value1\"           }       }   ]}";
		
		Object _obj = _json.parse(_txt);
		log.info(_obj.toString());
		log.info(_json.encodeFeatureCollection((FeatureCollection)_obj).toString());
	}
}
