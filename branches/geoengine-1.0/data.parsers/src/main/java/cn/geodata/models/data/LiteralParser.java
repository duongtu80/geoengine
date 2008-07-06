package cn.geodata.models.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import cn.geodata.models.category.data.DataCategory;

public interface LiteralParser {
	List<DataCategory> getCategories();
	
	String encode(Object obj, DataCategory category, Map<String, Object> params) throws IOException;
	Object parse(String txt, DataCategory category, Map<String, Object> params) throws IOException;
}
