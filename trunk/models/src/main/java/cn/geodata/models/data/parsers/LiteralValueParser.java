package cn.geodata.models.data.parsers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.data.LiteralParser;
import cn.geodata.models.util.Utilities;

public class LiteralValueParser implements LiteralParser {
	private static Logger log = Utilities.getLogger();
	
	@Override
	public String encode(Object obj, DataCategory category,
			Map<String, Object> params) throws IOException {
		if(category.isInstance(obj)){
			log.warning("Value type does not match the output definition " + obj.getClass().toString() + " " + category.getJavaClass().toString());
			throw new IOException("Value type does not match the output definition");
		}
		
		return obj.toString();
	}

	@Override
	public List<DataCategory> getCategories() {
		DataCategories _categories = DataCategories.getInstance();
		
		List<DataCategory> _list = new ArrayList<DataCategory>();

		_list.add(_categories.findCategory("int"));
		_list.add(_categories.findCategory("long"));
		_list.add(_categories.findCategory("float"));
		_list.add(_categories.findCategory("double"));
		_list.add(_categories.findCategory("string"));
		
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
