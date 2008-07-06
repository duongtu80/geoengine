package cn.geodata.models.data;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import net.opengeospatial.wps.LiteralValueType;

import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.geoprocessing.ValueType;

public class LiteralParsers {
	private List<LiteralParser> parsers;

	public List<LiteralParser> getParsers() {
		return parsers;
	}

	public void setParsers(List<LiteralParser> parsers) {
		this.parsers = parsers;
	}
	
	public boolean supports(DataCategory category){
		for(LiteralParser _parser : this.parsers){
			if(_parser.getCategories().contains(category)){
				return true;
			}
		}
		return false;
	}
	
	public Object parseLiteral(List<DataCategory> categories, LiteralValueType value) throws IOException {
		if(categories.size() != 1){
			throw new IOException("Literal value can only support one type");
		}
		
		if(this.parsers == null || this.parsers.size() == 0){
			throw new IOException("Failed to find a avaliable literal parser");
		}
		
		return this.parsers.get(0).parse(value.getStringValue(), categories.get(0), new HashMap<String, Object>());
	}
	
	public LiteralValueType encodeLiteral(List<DataCategory> categories, Object obj) throws IOException{
		if(categories.size() != 1){
			throw new IOException("Literal value can only support one type");
		}
		
		if(this.parsers == null || this.parsers.size() == 0){
			throw new IOException("Failed to find a avaliable literal parser");
		}
		
		LiteralValueType _val = LiteralValueType.Factory.newInstance();
		_val.setStringValue(this.parsers.get(0).encode(obj, categories.get(0), new HashMap<String, Object>()));
		
		return _val;
	}
}
