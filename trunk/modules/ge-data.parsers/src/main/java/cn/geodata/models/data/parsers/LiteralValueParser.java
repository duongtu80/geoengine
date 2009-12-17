package cn.geodata.models.data.parsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import cn.geodata.models.data.LiteralParser;
import cn.geodata.models.data.Utilities;

public class LiteralValueParser implements LiteralParser {
	private static Logger log = Utilities.getLogger();
	
	public String encode(Object obj, Map<String, Object> params) throws IOException {
		return obj.toString();
	}

	public List<Class> getCategories() {
		List<Class> _list = new ArrayList<Class>();

		_list.add(Integer.class);
		_list.add(Long.class);
		_list.add(Float.class);
		_list.add(Double.class);
		_list.add(String.class);
		
		return _list;
	}

	public Object parse(String txt, Class type,
			Map<String, Object> params) throws IOException {
		
		if(type.equals(Integer.class)){
			return Integer.parseInt(txt);
		}
		if(type.equals(Long.class)){
			return Long.parseLong(txt);
		}
		if(type.equals(Float.class)){
			return Float.parseFloat(txt);
		}
		if(type.equals(Double.class)){
			return Double.parseDouble(txt);
		}
		if(type.equals(String.class)){
			return txt;
		}
		
		log.warning("Failed to parse the input value \"" + txt + "\"");
		throw new IOException("Failed to parse the input value");
	}
}
