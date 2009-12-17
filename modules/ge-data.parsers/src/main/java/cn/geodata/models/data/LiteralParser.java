package cn.geodata.models.data;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface LiteralParser {
	List<Class> getCategories();
	
	String encode(Object obj, Map<String, Object> params) throws IOException;
	Object parse(String txt, Class type, Map<String, Object> params) throws IOException;
}
