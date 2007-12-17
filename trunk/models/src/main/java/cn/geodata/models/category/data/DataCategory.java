package cn.geodata.models.category.data;

import java.util.ArrayList;
import java.util.List;

public class DataCategory {
	private String id;
	private String title;
	private String describe;
	private Class javaClass;
	private List<DataCategory> children;

	public DataCategory() {
		
	}
	
	public DataCategory(String id, String title, String describe,
			Class javaClass, List<DataCategory> children) {
		this.id = id;
		this.title = title;
		this.describe = describe;
		this.javaClass = javaClass;
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Class getJavaClass() {
		return javaClass;
	}

	public void setJavaClass(Class javaClass) {
		this.javaClass = javaClass;
	}

	public List<DataCategory> getChildren() {
		if(this.children == null){
			return new ArrayList<DataCategory>();
		}
		return children;
	}

	public void setChildren(List<DataCategory> children) {
		this.children = children;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DataCategory) {
			DataCategory _obj = (DataCategory) obj;
			return this.getId().equals(_obj.getId());
		}
		return false;
	}

	@Override
	public String toString() {
		return this.id + "[" + this.title + "]";
	}
}
