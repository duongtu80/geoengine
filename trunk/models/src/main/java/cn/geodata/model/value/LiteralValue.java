package cn.geodata.model.value;

import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.LiteralValueType;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LiteralValue extends ModelValue {
	protected Object value;
	protected String dataType;
	
	public LiteralValue(String identifier, String title, String describe, Object value) throws Exception{
		super(identifier, title, describe);
		this.setValue(value);
	}
	
	public LiteralValue(IOValueType type) throws Exception{
		super(type);
		
		Object _value = null;
		String _valueString = type.getLiteralValue().getStringValue();
		if(_valueString != null){
			String _type = type.getLiteralValue().getDataType();
			if(_type == null || _type.length() == 0 || _type.equals("xs:string")){
				_value = _valueString;
			}
			else if(_type.equals("xs:int") || _type.equals("xs:integer")){
				_value = Integer.parseInt(_valueString);
			}
			else if(_type.equals("xs:long")){
				_value = Long.parseLong(_valueString);
			}
			else if(_type.equals("xs:float")){
				_value = Float.parseFloat(_valueString);
			}
			else if(_type.equals("xs:double")){
				_value = Double.parseDouble(_valueString);
			}
			if(_value != null){
				this.setValue(_value);
			}
			else{
				throw new NullPointerException("不支持指定的数据类型");
			}
		}
	}
	
	public void setValue(Object value) throws Exception {
		if(value == null){
			throw new NullPointerException("不能提供空值");
		}
		
		Class _class = value.getClass();
		if(_class.equals(String.class)){
			dataType = "xs:string";
		}
		else if(_class.equals(Integer.class)){
			dataType = "xs:int";
		}
		else if(_class.equals(Long.class)){
			dataType = "xs:long";
		}
		else if(_class.equals(Float.class)){
			dataType = "xs:float";
		}
		else if(_class.equals(Double.class)){
			dataType = "xs:double";
		}
		else{
			throw new Exception("不支持该数据类型:" + _class.getName());
		}
		
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

//	@Override
//	protected Element encodeValue(Document doc) {
//		if(this.value == null){
//			throw new NullPointerException("No value");
//		}
//		
//		Element _valueNode = doc.createElementNS(GeoNamespaceContext.URI_WPS, "LiteralValue");
//		_valueNode.setTextContent(this.value.toString());
//		
//		return _valueNode;
//	}
//
	@Override
	public void encode(IOValueType type) throws Exception {
		super.encode(type);
		
		if(this.value == null){
			throw new NullPointerException("不能提供空值");
		}
		
		LiteralValueType _valueNode = type.addNewLiteralValue();
		_valueNode.setStringValue(this.getValue().toString());
		if(this.getDataType() != null){
			_valueNode.setDataType(this.getDataType());
		}
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
