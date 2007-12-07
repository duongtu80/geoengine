package cn.geodata.models.value.literal;

import java.io.IOException;

import net.opengeospatial.wps.LiteralValueType;

import org.apache.xmlbeans.XmlObject;

import cn.geodata.models.value.Encoder;
import cn.geodata.models.value.LiteralEncoder;
import cn.geodata.models.value.LiteralParser;
import cn.geodata.models.value.Parser;

public class LiteralValueParser implements Parser, LiteralParser, Encoder, LiteralEncoder {

	@Override
	public Object parse(XmlObject type) throws IOException {
		LiteralValueType _val = (LiteralValueType) type;
		
		String _valueString = _val.getStringValue();
		
		if(_valueString != null){
			String _type = _val.getDataType();
			if(_type == null || _type.length() == 0 || _type.equals("xs:string")){
				return _valueString;
			}
			else if(_type.equals("xs:int") || _type.equals("xs:integer")){
				return Integer.parseInt(_valueString);
			}
			else if(_type.equals("xs:long")){
				return Long.parseLong(_valueString);
			}
			else if(_type.equals("xs:float")){
				return Float.parseFloat(_valueString);
			}
			else if(_type.equals("xs:double")){
				return Double.parseDouble(_valueString);
			}
			else{
				throw new NullPointerException("Does not support require data type");
			}
		}
		else{
			return null;
		}
	}

	@Override
	public double parseLiteralDouble(LiteralValueType type) throws IOException {
		Object _o = this.parse(type);
		if (_o instanceof Double) {
			Double _val = (Double) _o;
			return _val.doubleValue();
		}
		else if (_o instanceof Float) {
			Float _val = (Float) _o;
			return _val.floatValue();
		}
		else{
			throw new IOException("Can't be convert to double");
		}
	}

	@Override
	public float parseLiteralFloat(LiteralValueType type) throws IOException {
		Object _o = this.parse(type);
		if (_o instanceof Float) {
			Float _val = (Float) _o;
			return _val.floatValue();
		}
		else{
			throw new IOException("Can't be convert to float");
		}
	}

	@Override
	public int parseLiteralInt(LiteralValueType type) throws IOException {
		Object _o = this.parse(type);
		if (_o instanceof Integer) {
			Integer _val = (Integer) _o;
			return _val.intValue();
		}
		else{
			throw new IOException("Can't be convert to integer");
		}
	}

	@Override
	public long parseLiteralLong(LiteralValueType type) throws IOException {
		Object _o = this.parse(type);
		if (_o instanceof Long) {
			Long _val = (Long) _o;
			return _val.longValue();
		}
		else if (_o instanceof Integer) {
			Integer _val = (Integer) _o;
			return _val.intValue();
		}
		else{
			throw new IOException("Can't be convert to long");
		}
	}

	@Override
	public String parseLiteralString(LiteralValueType type) throws IOException {
		Object _o = this.parse(type);
		if(_o != null){
			return _o.toString();
		}
		else{
			return "";
		}
	}

	@Override
	public LiteralValueType encodeLiteral(int val) throws IOException {
		LiteralValueType _type = LiteralValueType.Factory.newInstance();

		_type.setDataType("xs:int");
		_type.setStringValue(Integer.toString(val));
		
		return _type;
	}

	@Override
	public LiteralValueType encodeLiteral(long val) throws IOException {
		LiteralValueType _type = LiteralValueType.Factory.newInstance();

		_type.setDataType("xs:long");
		_type.setStringValue(Long.toString(val));
		
		return _type;
	}

	@Override
	public LiteralValueType encodeLiteral(float val) throws IOException {
		LiteralValueType _type = LiteralValueType.Factory.newInstance();

		_type.setDataType("xs:float");
		_type.setStringValue(Float.toString(val));
		
		return _type;
	}

	@Override
	public LiteralValueType encodeLiteral(double val) throws IOException {
		LiteralValueType _type = LiteralValueType.Factory.newInstance();

		_type.setDataType("xs:double");
		_type.setStringValue(Double.toString(val));
		
		return _type;
	}

	@Override
	public XmlObject encode(Object obj) throws IOException {
		throw new UnsupportedOperationException();
	}
}
