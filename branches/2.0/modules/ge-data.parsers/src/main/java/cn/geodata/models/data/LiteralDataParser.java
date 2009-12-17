package cn.geodata.models.data;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class LiteralDataParser {
	private Logger log = Logger.getAnonymousLogger();
	private Map<Class, String> types;
	
	public LiteralDataParser(){
		this.types = new HashMap<Class, String>();
		
		this.types.put(Integer.class, "int");
		this.types.put(int.class, "int");
		this.types.put(Float.class, "float");
		this.types.put(float.class, "float");
		this.types.put(Double.class, "double");
		this.types.put(double.class, "double");
		this.types.put(Long.class, "long");
		this.types.put(long.class, "long");
		this.types.put(String.class, "string");
	}
	
	public boolean isLiteral(Class type){
		return this.types.containsKey(type);
	}
	
	public String encode(Class type, Object val){
		if(val == null){
			return "";
		}
		return val.toString();
	}
	
	public Object decode(Class type, String val){
		if(val == null || val.length() == 0){
			return null;
		}
		
		if(type.equals(Integer.class) || type.equals(int.class)){
			return Integer.parseInt(val);
		}
		if(type.equals(Long.class) || type.equals(long.class)){
			return Long.parseLong(val);
		}
		if(type.equals(Float.class) || type.equals(float.class)){
			return Float.parseFloat(val);
		}
		if(type.equals(Double.class) || type.equals(double.class)){
			return Double.parseDouble(val);
		}
		log.warning("Unsupported literal data type " + type.getName());
		return val;
	}
}
