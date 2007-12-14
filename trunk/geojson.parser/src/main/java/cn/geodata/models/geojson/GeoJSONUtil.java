package cn.geodata.models.geojson;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONFunction;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import net.sf.json.util.JSONUtils;

public class GeoJSONUtil {
	public static void valueToString(Object value, OutputStream stream)
			throws IOException {
		if (value == null || JSONUtils.isNull(value)) {
			IOUtils.write("null", stream);
		} else if (value instanceof JSONFunction) {
			IOUtils.write(((JSONFunction) value).toString(), stream);
		} else if (value instanceof JSONString) {
			Object o;
			try {
				o = ((JSONString) value).toJSONString();
			} catch (Exception e) {
				throw new JSONException(e);
			}
			if (o instanceof String) {
				IOUtils.write((String) o, stream);
			}
			throw new JSONException("Bad value from toJSONString: " + o);
		} else if (value instanceof Number) {
			IOUtils.write(JSONUtils.numberToString((Number) value), stream);
		} else if (value instanceof Boolean) {
			IOUtils.write(value.toString(), stream);
		} else if (value instanceof JSONObject) {
			writeObject((JSONObject) value, stream);
		} else if (value instanceof JSONArray) {
			writeArray((JSONArray) value, stream);
		} else {
			IOUtils.write(JSONUtils.quote(value.toString()), stream);
		}
	}

	public static void writeObject(JSONObject obj, OutputStream stream)
			throws IOException {
		if (obj.isNullObject()) {
			IOUtils.write(JSONNull.getInstance().toString(), stream);
		}

		Iterator keys = obj.keys();
		boolean _first = true;
		IOUtils.write("{", stream);

		while (keys.hasNext()) {
			if (!_first) {
				IOUtils.write(",", stream);
			}
			_first = false;

			Object o = keys.next();
			IOUtils.write(JSONUtils.quote(o.toString()), stream);
			IOUtils.write(":", stream);
			valueToString(obj.get((String)o), stream);
		}
		IOUtils.write("}", stream);
	}

	public static void writeArray(JSONArray obj, OutputStream stream)
			throws IOException {
		IOUtils.write("[", stream);
		joinArray(obj, ",", stream);
		IOUtils.write("]", stream);
	}

	public static void joinArray(JSONArray obj, String separator, OutputStream stream) throws IOException {
		
		int len = obj.length();
		for (int i = 0; i < len; i += 1) {
			if (i > 0) {
				IOUtils.write(separator, stream);
			}
			
			valueToString(obj.get(i), stream);
		}
	}
}
