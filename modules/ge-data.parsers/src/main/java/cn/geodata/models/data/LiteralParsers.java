package cn.geodata.models.data;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import net.opengis.wps.x100.LiteralDataType;

public class LiteralParsers {
	private List<LiteralParser> parsers;

	public List<LiteralParser> getParsers() {
		return parsers;
	}

	public void setParsers(List<LiteralParser> parsers) {
		this.parsers = parsers;
	}
	
	public boolean supports(Class type){
		for(LiteralParser _parser : this.parsers){
			if(_parser.getCategories().contains(type)){
				return true;
			}
		}
		return false;
	}
	
	public Object parseLiteral(Class type, LiteralDataType value) throws IOException {
		if(this.parsers == null || this.parsers.size() == 0){
			throw new IOException("Failed to find a avaliable literal parser");
		}
		
		return this.parsers.get(0).parse(value.getStringValue(), type, new HashMap<String, Object>());
	}
	
	public LiteralDataType encodeLiteral(Object obj) throws IOException{
		LiteralDataType _val = LiteralDataType.Factory.newInstance();
		_val.setStringValue(this.parsers.get(0).encode(obj, new HashMap<String, Object>()));
		
		return _val;
	}
}
