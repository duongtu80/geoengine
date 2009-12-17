package cn.geodata.models.data.parsers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.IllegalAttributeException;

import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import cn.geodata.models.data.ComplexParser;
import cn.geodata.models.data.Utilities;
import cn.geodata.models.geojson.GeoJSON;
import cn.geodata.models.geojson.GeoJSONUtil;

public class GeoJsonComplexParser implements ComplexParser {
	private static Logger log = Utilities.getLogger();
	private GeoJSON parser;
	
	public GeoJsonComplexParser(){
		this.parser = new GeoJSON();
	}
	
	public List<Class> getCategories() {
		List<Class> _list = new ArrayList<Class>();
		_list.add(Point.class);
		_list.add(LineString.class);
		_list.add(Polygon.class);
		_list.add(MultiPoint.class);
		_list.add(MultiLineString.class);
		_list.add(MultiPolygon.class);
		_list.add(FeatureCollection.class);
		
		return _list;
	}

	public List<MimeType> getMimes() {
		try {
			return Arrays.asList(new MimeType[]{new MimeType("text/json"), new MimeType("text/geojson")});
		} catch (MimeTypeParseException e) {
			log.log(Level.WARNING, "Failed to create MIME list", e);
			return null;
		}
	}

	public Object parse(InputStream stream, MimeType mime,
			Map<String, Object> params) throws IOException {
		try {
			return this.parser.parse(IOUtils.toString(stream));
		} catch (IllegalAttributeException e) {
			log.log(Level.SEVERE, "Failed to parse GeoJSON stream", e);
			throw new IOException("Failed to parse GeoJSON stream");
		}
	}

	public InputStream encode(Object obj, MimeType mime,
			Map<String, Object> params) throws IOException {
		JSONObject _ele = this.parser.encode(obj);
		
		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
		GeoJSONUtil.writeObject(_ele, _stream);

		return new ByteArrayInputStream(_stream.toByteArray());
	}
}
