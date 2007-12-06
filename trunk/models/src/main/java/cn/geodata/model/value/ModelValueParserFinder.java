package cn.geodata.model.value;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.xml.XmlBeanFactory;

public class ModelValueParserFinder {
	private Map<String, LiteralEncoder> literalEncoders;
	private Map<String, LiteralParser> literalParsers;
	private Map<String, ComplexEncoder> complexEncoders;
	private Map<String, ComplexParser> complexParsers;
	private Map<String, ComplexReferenceEncoder> complexReferenceEncoders;
	private Map<String, ComplexReferenceParser> complexReferenceParsers;
	
	private LiteralEncoder defaultLiteralEncoder;
	private LiteralParser defaultLiteralParser;
	private ComplexEncoder defaultComplexEncoder;
	private ComplexParser defaultComplexParser;
	private ComplexReferenceEncoder defaultComplexReferenceEncoder;
	private ComplexReferenceParser defaultComplexReferenceParser;
	
	public ModelValueParserFinder() {
		XmlBeanFactory _beanFactory = ModelValueUtil.createBeanFactory();
		
		this.literalEncoders = new HashMap<String, LiteralEncoder>();
		for(String _line: _beanFactory.getBeanNamesForType(LiteralEncoder.class)){
			if(_line.length() > 0){
				this.literalEncoders.put(_line, (LiteralEncoder)_beanFactory.getBean(_line));
			}
		}

		this.literalParsers= new HashMap<String, LiteralParser>();
		for(String _line: _beanFactory.getBeanNamesForType(LiteralParser.class)){
			if(_line.length() > 0){
				this.literalParsers.put(_line, (LiteralParser)_beanFactory.getBean(_line));
			}
		}

		this.complexEncoders = new HashMap<String, ComplexEncoder>();
		for(String _line: _beanFactory.getBeanNamesForType(ComplexEncoder.class)){
			if(_line.length() > 0){
				this.complexEncoders.put(_line, (ComplexEncoder)_beanFactory.getBean(_line));
			}
		}

		this.complexParsers= new HashMap<String, ComplexParser>();
		for(String _line: _beanFactory.getBeanNamesForType(ComplexParser.class)){
			if(_line.length() > 0){
				this.complexParsers.put(_line, (ComplexParser)_beanFactory.getBean(_line));
			}
		}

		this.complexReferenceEncoders= new HashMap<String, ComplexReferenceEncoder>();
		for(String _line: _beanFactory.getBeanNamesForType(ComplexReferenceEncoder.class)){
			if(_line.length() > 0){
				this.complexReferenceEncoders.put(_line, (ComplexReferenceEncoder)_beanFactory.getBean(_line));
			}
		}

		this.complexReferenceParsers= new HashMap<String, ComplexReferenceParser>();
		for(String _line: _beanFactory.getBeanNamesForType(ComplexReferenceParser.class)){
			if(_line.length() > 0){
				this.complexReferenceParsers.put(_line, (ComplexReferenceParser)_beanFactory.getBean(_line));
			}
		}
	}
	
	public Map<String, LiteralEncoder> getLiteralEncoders() {
		return literalEncoders;
	}
	public void setLiteralEncoders(Map<String, LiteralEncoder> literalEncoders) {
		this.literalEncoders = literalEncoders;
	}
	public Map<String, LiteralParser> getLiteralParsers() {
		return literalParsers;
	}
	public void setLiteralParsers(Map<String, LiteralParser> literalParsers) {
		this.literalParsers = literalParsers;
	}
	public Map<String, ComplexEncoder> getComplexEncoders() {
		return complexEncoders;
	}
	public void setComplexEncoders(Map<String, ComplexEncoder> complexEncoders) {
		this.complexEncoders = complexEncoders;
	}
	public Map<String, ComplexParser> getComplexParsers() {
		return complexParsers;
	}
	public void setComplexParsers(Map<String, ComplexParser> complexParsers) {
		this.complexParsers = complexParsers;
	}
	public Map<String, ComplexReferenceEncoder> getComplexReferenceEncoders() {
		return complexReferenceEncoders;
	}
	public void setComplexReferenceEncoders(
			Map<String, ComplexReferenceEncoder> complexReferenceEncoders) {
		this.complexReferenceEncoders = complexReferenceEncoders;
	}
	public Map<String, ComplexReferenceParser> getComplexReferenceParsers() {
		return complexReferenceParsers;
	}
	public void setComplexReferenceParsers(
			Map<String, ComplexReferenceParser> complexReferenceParsers) {
		this.complexReferenceParsers = complexReferenceParsers;
	}
	public LiteralEncoder getDefaultLiteralEncoder() {
		return defaultLiteralEncoder;
	}
	public void setDefaultLiteralEncoder(LiteralEncoder defaultLiteralEncoder) {
		this.defaultLiteralEncoder = defaultLiteralEncoder;
	}
	public LiteralParser getDefaultLiteralParser() {
		return defaultLiteralParser;
	}
	public void setDefaultLiteralParser(LiteralParser defaultLiteralParser) {
		this.defaultLiteralParser = defaultLiteralParser;
	}
	public ComplexEncoder getDefaultComplexEncoder() {
		return defaultComplexEncoder;
	}
	public void setDefaultComplexEncoder(ComplexEncoder defaultComplexEncoder) {
		this.defaultComplexEncoder = defaultComplexEncoder;
	}
	public ComplexParser getDefaultComplexParser() {
		return defaultComplexParser;
	}
	public void setDefaultComplexParser(ComplexParser defaultComplexParser) {
		this.defaultComplexParser = defaultComplexParser;
	}
	public ComplexReferenceEncoder getDefaultComplexReferenceEncoder() {
		return defaultComplexReferenceEncoder;
	}
	public void setDefaultComplexReferenceEncoder(
			ComplexReferenceEncoder defaultComplexReferenceEncoder) {
		this.defaultComplexReferenceEncoder = defaultComplexReferenceEncoder;
	}
	public ComplexReferenceParser getDefaultComplexReferenceParser() {
		return defaultComplexReferenceParser;
	}
	public void setDefaultComplexReferenceParser(
			ComplexReferenceParser defaultComplexReferenceParser) {
		this.defaultComplexReferenceParser = defaultComplexReferenceParser;
	}
}
