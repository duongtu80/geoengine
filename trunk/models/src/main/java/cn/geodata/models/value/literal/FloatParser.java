package cn.geodata.models.value.literal;

import java.io.IOException;

import net.opengeospatial.wps.LiteralValueType;

import org.apache.xmlbeans.XmlObject;

import cn.geodata.models.value.Encoder;
import cn.geodata.models.value.Parser;

public class FloatParser implements Encoder, Parser {

	@Override
	public boolean canEncode(Object obj) {
		if (obj instanceof Float) {
			return true;
		}
		return false;
	}

	@Override
	public XmlObject encode(Object obj) throws IOException {
		LiteralValueType _type = LiteralValueType.Factory.newInstance();

		_type.setDataType("xs:float");
		_type.setStringValue(obj.toString());
		
		return _type;
	}

	@Override
	public boolean canParse(XmlObject type) {
		if (type instanceof LiteralValueType) {
			LiteralValueType _type = (LiteralValueType) type;
			if(_type.getDataType().equalsIgnoreCase("xs:float")){
				return true;
			}
		}
		return false;
	}

	@Override
	public Object parse(XmlObject type) throws IOException {
		LiteralValueType _type = (LiteralValueType) type;
		
		return Float.parseFloat(_type.getStringValue());
	}
}
