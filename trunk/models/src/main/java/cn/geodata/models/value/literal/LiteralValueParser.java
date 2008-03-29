package cn.geodata.models.value.literal;

import java.io.IOException;
import java.util.Map;

import net.opengeospatial.wps.LiteralValueType;

import org.apache.xmlbeans.XmlObject;

import cn.geodata.models.value.Encoder;
import cn.geodata.models.value.LiteralEncoder;
import cn.geodata.models.value.LiteralParser;
import cn.geodata.models.value.Parser;

public class LiteralValueParser implements LiteralParser, LiteralEncoder {

	Map<String, Encoder> encoders;
	Map<String, Parser> parsers;
	
	public Object parse(XmlObject type) throws IOException {
		for(Parser _p : this.parsers.values()){
			if(_p.canParse(type)){
				return _p.parse(type);
			}
		}
		
		throw new UnsupportedOperationException();		
	}

	public XmlObject encode(Object obj) throws IOException {
		for(Encoder _e : this.encoders.values()){
			if(_e.canEncode(obj)){
				return _e.encode(obj);
			}
		}
		
		throw new UnsupportedOperationException();
	}

	public double parseLiteralDouble(LiteralValueType type) throws IOException {
		return (Double)this.parse(type);
	}

	public float parseLiteralFloat(LiteralValueType type) throws IOException {
		return (Float)this.parse(type);
	}

	public int parseLiteralInt(LiteralValueType type) throws IOException {
		return (Integer)this.parse(type);
	}

	public long parseLiteralLong(LiteralValueType type) throws IOException {
		return (Long)this.parse(type);
	}

	public String parseLiteralString(LiteralValueType type) throws IOException {
		return (String)this.parse(type);
	}

	public LiteralValueType encodeLiteral(int val) throws IOException {
		return (LiteralValueType)this.encode(val);
	}

	public LiteralValueType encodeLiteral(long val) throws IOException {
		return (LiteralValueType)this.encode(val);
	}

	public LiteralValueType encodeLiteral(float val) throws IOException {
		return (LiteralValueType)this.encode(val);
	}

	public LiteralValueType encodeLiteral(double val) throws IOException {
		return (LiteralValueType)this.encode(val);
	}
	
	public LiteralValueType encodeLiteral(String val) throws IOException {
		return (LiteralValueType)this.encode(val);
	}

	public boolean canParse(XmlObject type) {
		for(Parser _p : this.parsers.values()){
			if(_p.canParse(type)){
				return true;
			}
		}
		return false;
	}

	public boolean canEncode(Object obj) {
		for(Encoder _e : this.encoders.values()){
			if(_e.canEncode(obj)){
				return true;
			}
		}
		return false;
	}

	public Map<String, Encoder> getEncoders() {
		return encoders;
	}

	public void setEncoders(Map<String, Encoder> encoders) {
		this.encoders = encoders;
	}

	public Map<String, Parser> getParsers() {
		return parsers;
	}

	public void setParsers(Map<String, Parser> parsers) {
		this.parsers = parsers;
	}
}
