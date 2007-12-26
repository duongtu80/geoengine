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
import org.geotools.feature.IllegalAttributeException;

import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.data.ComplexParser;
import cn.geodata.models.geojson.GeoJSON;
import cn.geodata.models.geojson.GeoJSONUtil;
import cn.geodata.models.util.Utilities;

public class GeoJsonComplexParser implements ComplexParser {
	private static Logger log = Utilities.getLogger();
	private GeoJSON parser;
	
	public GeoJsonComplexParser(){
		this.parser = new GeoJSON();
	}
	
	@Override
	public List<DataCategory> getCategories() {
		DataCategories _c = DataCategories.getInstance();
		
		List<DataCategory> _list = new ArrayList<DataCategory>();
		_list.add(_c.findCategory("point"));
		_list.add(_c.findCategory("lineString"));
		_list.add(_c.findCategory("polygon"));
		_list.add(_c.findCategory("multiPoint"));
		_list.add(_c.findCategory("multiLineString"));
		_list.add(_c.findCategory("multiPolygon"));
		_list.add(_c.findCategory("featureCollection"));
		
		return _list;
	}

	@Override
	public List<MimeType> getMimes() {
		try {
			return Arrays.asList(new MimeType[]{new MimeType("text/json"), new MimeType("text/geojson")});
		} catch (MimeTypeParseException e) {
			log.log(Level.WARNING, "Failed to create MIME list", e);
			return null;
		}
	}

	@Override
	public Object parse(InputStream stream, MimeType mime,
			Map<String, Object> params) throws IOException {
		try {
			return this.parser.parse(IOUtils.toString(stream));
		} catch (IllegalAttributeException e) {
			log.log(Level.SEVERE, "Failed to parse GeoJSON stream", e);
			throw new IOException("Failed to parse GeoJSON stream");
		}
	}

	@Override
	public InputStream encode(Object obj, MimeType mime,
			Map<String, Object> params) throws IOException {
		JSONObject _ele = this.parser.encode(obj);
		
		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
		GeoJSONUtil.writeObject(_ele, _stream);

		return new ByteArrayInputStream(_stream.toByteArray());
	}
}
