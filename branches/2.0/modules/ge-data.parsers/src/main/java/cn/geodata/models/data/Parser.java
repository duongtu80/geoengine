package cn.geodata.models.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.activation.MimeType;

public interface Parser {
	boolean isSupports(Class type, MimeType mime);

	InputStream encode(Object val, MimeType mime, String encoding) throws IOException;
	Object decode(Class type, InputStream val, MimeType mime, String encoding) throws IOException;
	
	List<MimeType> listMimes(Class type);
}
