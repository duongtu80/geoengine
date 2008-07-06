package cn.geodata.models.data;

import java.io.InputStream;
import java.util.List;

import javax.activation.MimeType;

import cn.geodata.models.category.data.DataCategory;

public class ComplexStream {
	private MimeType mime;
	private List<DataCategory> categories;
	private InputStream stream;
	
	public ComplexStream() {
		this.mime = null;
		this.categories = null;
		this.stream = null;
	}
	
	public ComplexStream(MimeType mime, List<DataCategory> categories, InputStream stream){
		this.mime = mime;
		this.categories = categories;
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

	public List<DataCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<DataCategory> categories) {
		this.categories = categories;
	}
}
