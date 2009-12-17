package cn.geodata.models.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.activation.MimeType;

public interface ComplexParser {
	List<Class> getCategories();
	List<MimeType> getMimes();
	
	InputStream encode(Object obj, MimeType mime, Map<String, Object> params) throws IOException;
	Object parse(InputStream stream, MimeType mime, Map<String, Object> params) throws IOException;
}
