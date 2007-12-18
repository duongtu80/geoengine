package cn.geodata.models.data.parsers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.data.LiteralParser;

public class LiteralValueParser implements LiteralParser {
	private static Logger log = Logger.getAnonymousLogger();
	
	@Override
	public String encode(Object obj, DataCategory category,
			Map<String, Object> params) throws IOException {
		if(category.getJavaClass().isInstance(obj)){
			log.warning("Value type does not match the output definition " + obj.getClass().toString() + " " + category.getJavaClass().toString());
			throw new IOException("Value type does not match the output definition");
		}
		
		return obj.toString();
	}

	@Override
	public List<DataCategory> getCategories() {
		List<DataCategory> _list = new ArrayList<DataCategory>();

		_list.add(new DataCategory("int", "Integer", "Integer", Integer.class, null));
		_list.add(new DataCategory("long", "Long", "Long", Long.class, null));
		_list.add(new DataCategory("float", "Float", "Float", Float.class, null));
		_list.add(new DataCategory("double", "Double", "Double", Double.class, null));
		_list.add(new DataCategory("string", "String", "String", String.class, null));
		
		return _list;
	}

	@Override
	public Object parse(String txt, DataCategory category,
			Map<String, Object> params) throws IOException {
		
		if(category.getId().equals("int")){
			return Integer.parseInt(txt);
		}
		if(category.getId().equals("long")){
			return Long.parseLong(txt);
		}
		if(category.getId().equals("float")){
			return Float.parseFloat(txt);
		}
		if(category.getId().equals("double")){
			return Double.parseDouble(txt);
		}
		if(category.getId().equals("string")){
			return txt;
		}
		if(category.getId().equals("int")){
			return Integer.parseInt(txt);
		}
		
		log.warning("Failed to parse the input value \"" + txt + "\"");
		throw new IOException("Failed to parse the input value");
	}
}
