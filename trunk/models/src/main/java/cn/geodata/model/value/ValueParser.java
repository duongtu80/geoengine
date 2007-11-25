package cn.geodata.model.value;

import net.opengeospatial.wps.IOValueType;

public abstract class ValueParser {
	public static ModelValue parse(IOValueType value) throws Exception{
		if(value.getLiteralValue() != null){
			return new LiteralValue(value);
		}
		else if(value.getComplexValue() != null){
			return new ComplexValue(value);
		}
		else{
			throw new Exception("不支持的数据类型");
		}
	}
}
