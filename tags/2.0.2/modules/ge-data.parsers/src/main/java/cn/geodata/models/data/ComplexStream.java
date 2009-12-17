package cn.geodata.models.data;

import java.io.InputStream;

import javax.activation.MimeType;

public class ComplexStream {
	private MimeType mime;
	private Class type;
	private InputStream stream;
	
	public ComplexStream() {
		this.mime = null;
		this.type = null;
		this.stream = null;
	}
	
	public ComplexStream(MimeType mime, Class type, InputStream stream){
		this.mime = mime;
		this.type = type;
		this.stream = stream;
	}
	
	public MimeType getMime() {
		return mime;
	}
	
	public void setMime(MimeType mime) {
		this.mime = mime;
	}
	
	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

	public Class getType() {
		return type;
	}

	public void setType(Class type) {
		this.type = type;
	}
}
