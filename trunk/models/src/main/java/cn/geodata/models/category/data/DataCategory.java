package cn.geodata.models.category.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataCategory {
	private String id;
	private String title;
	private String describe;
	private Class javaClass;
	private List<DataCategory> children;
	private boolean literal;

	public DataCategory() {
		
	}
	
	public DataCategory(String id, String title, String describe,
			Class javaClass, boolean literal, List<DataCategory> children) {
		this.id = id;
		this.title = title;
		this.describe = describe;
		this.javaClass = javaClass;
		this.literal = literal;
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
	
	public boolean getLiteral() {
		return this.literal;
	}
	
	public void setLiteral(boolean literal){
		this.literal = literal;
	}
	
	public boolean isInstance(Object obj) throws IOException {
		if(obj == null){
			return false;
		}
		
		if(this.javaClass.isInstance(obj) == true){
			return true;
		}
		else{
			if(obj.getClass().isPrimitive()){
				throw new IOException("Can not accept primitive type");
			}
			else{
				return false;
			}
		}
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
