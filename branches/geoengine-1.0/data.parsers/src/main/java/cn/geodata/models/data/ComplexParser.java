package cn.geodata.models.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.activation.MimeType;

import cn.geodata.models.category.data.DataCategory;

public interface ComplexParser {
	List<DataCategory> getCategories();
	List<MimeType> getMimes();
	
	InputStream encode(Object obj, MimeType mime, Map<String, Object> params) throws IOException;
	Object parse(InputStream stream, MimeType mime, Map<String, Object> params) throws IOException;
}
