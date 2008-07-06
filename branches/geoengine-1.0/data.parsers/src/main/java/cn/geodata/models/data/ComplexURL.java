package cn.geodata.models.data;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.activation.MimeType;

import cn.geodata.models.category.data.DataCategory;

public class ComplexURL {
	private MimeType mime;
	private List<DataCategory> categories;
	private URL url;
	
	public ComplexURL() {
		this.mime = null;
		this.categories = null;
		this.url = null;
	}
	
	public ComplexURL(MimeType mime, List<DataCategory> categories, URL url){
		this.mime = mime;
		this.categories = categories;
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

	public List<DataCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<DataCategory> categories) {
		this.categories = categories;
	}
}
