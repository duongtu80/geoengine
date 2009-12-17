package cn.geodata.models.data;

import java.net.URL;

import javax.activation.MimeType;

public class ComplexURL {
	private MimeType mime;
	private Class type;
	private URL url;
	
	public ComplexURL() {
		this.mime = null;
		this.type = null;
		this.url = null;
	}
	
	public ComplexURL(MimeType mime, Class type, URL url){
		this.mime = mime;
		this.type = type;
		this.url = url;
	}
	
	public MimeType getMime() {
		return mime;
	}
	
	public void setMime(MimeType mime) {
		this.mime = mime;
	}
	
	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public Class getType() {
		return type;
	}

	public void setType(Class type) {
		this.type = type;
	}
}
