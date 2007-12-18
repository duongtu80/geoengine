package cn.geodata.models.value;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.XmlObject;

public class ModelValueParserFinder {
	Map<String, Encoder> encoders;
	Map<String, Parser> parsers;
	
	private String defaultLiteralEncoder;
	private String defaultLiteralParser;
	private String defaultComplexEncoder;
	private String defaultComplexParser;
	private String defaultReferenceEncoder;
	private String defaultReferenceParser;
	
	public String getDefaultLiteralEncoder() {
		return defaultLiteralEncoder;
	}
	
	public void setDefaultLiteralEncoder(String defaultLiteralEncoder) {
		this.defaultLiteralEncoder = defaultLiteralEncoder;
	}

	public String getDefaultLiteralParser() {
		return this.defaultLiteralParser;
	}
	
	public void setDefaultLiteralParser(String defaultLiteralParser) {
		this.defaultLiteralParser = defaultLiteralParser;
	}
	
	public String getDefaultComplexEncoder() {
		return defaultComplexEncoder;
	}
	
	public void setDefaultComplexEncoder(String defaultComplexEncoder) {
		this.defaultComplexEncoder = defaultComplexEncoder;
	}
	
	public String getDefaultComplexParser() {
		return defaultComplexParser;
	}
	
	public void setDefaultComplexParser(String defaultComplexParser) {
		this.defaultComplexParser = defaultComplexParser;
	}
	
	public String getDefaultReferenceEncoder() {
		return defaultReferenceEncoder;
	}
	
	public void setDefaultReferenceEncoder(String defaultReferenceEncoder) {
		this.defaultReferenceEncoder = defaultReferenceEncoder;
	}
	
	public String getDefaultReferenceParser() {
		return defaultReferenceParser;
	}
	
	public void setDefaultReferenceParser(String defaultReferenceParser) {
		this.defaultReferenceParser = defaultReferenceParser;
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
	
	/**
	 * Try all parser engines to parse this type
	 * @param type
	 * @return
	 * @throws IOException
	 */
	public Object parse(XmlObject type) throws IOException {
		List<String> _list = new ArrayList<String>();
		
		_list.add(this.defaultLiteralParser);
		_list.add(this.defaultComplexParser);
		_list.add(this.defaultReferenceParser);
		
		for(String _k : _list){
			if(this.parsers.get(_k).canParse(type)){
				return this.parsers.get(_k).parse(type);
			}
		}
		
		for(String _k : this.parsers.keySet()){
			if(_list.contains(_k) == false){
				if(this.parsers.get(_k).canParse(type)){
					this.parsers.get(_k).parse(type);
				}
			}
		}
		
		throw new UnsupportedOperationException();		
	}
	
//	public XmlObject encode(Object obj) throws IOException {
//		List<String> _list = new ArrayList<String>();
//		
//		_list.add(this.defaultLiteralEncoder);
//		_list.add(this.defaultComplexEncoder);
//		_list.add(this.defaultReferenceEncoder);
//		
//		for(String _k : _list){
//			if(this.encoders.get(_k).canEncode(obj)){
//				return this.encoders.get(_k).encode(obj);
//			}
//		}
//		
//		for(String _k : this.encoders.keySet()){
//			if(_list.contains(_k) == false){
//				if(this.encoders.get(_k).canEncode(obj)){
//					this.encoders.get(_k).encode(obj);
//				}
//			}
//		}
//		
//		throw new UnsupportedOperationException();		
//	}
	
	/**
	 * @return default literal value encoder
	 */
	public LiteralEncoder getLiteralEncoder() {
		return (LiteralEncoder) this.encoders.get(this.defaultLiteralEncoder);
	}
	
	/**
	 * @return default literal value parser
	 */
	public LiteralParser getLiteralParser(){
		return (LiteralParser) this.parsers.get(this.defaultLiteralParser);
	}
	
	/**
	 * return default complex value encoder
	 */
	public ComplexEncoder getComplexEncoder(){
		return (ComplexEncoder) this.encoders.get(this.defaultComplexEncoder);
	}
	
	/**
	 * @return default complex value parser
	 */
	public ComplexParser getComplexParser(){
		return (ComplexParser) this.parsers.get(this.defaultComplexParser);
	}
	
	/**
	 * @return default complex reference value encoder
	 */
	public ReferenceEncoder getReferenceEncoder() {
		return (ReferenceEncoder) this.encoders.get(this.defaultReferenceEncoder);
	}
	
	/**
	 * @return default complex reference value parser
	 */
	public ReferenceParser getReferenceParser(){
		return (ReferenceParser) this.parsers.get(this.defaultReferenceParser);
	}
}
