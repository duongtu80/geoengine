package cn.geodata.models.gml;


import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import cn.geodata.models.gml.define.FeatureDef;



/**
 * Manage and search GML parsers an encoders
 * 
 * @author mfeng
 *
 */
public class ParserFinder {
	private List<Parser> persers;
	private GMLConfiguration config;
	
	public GMLConfiguration getConfig() {
		return config;
	}

	public void setConfig(GMLConfiguration config) {
		this.config = config;
		
		for(Parser _d : this.persers){
			_d.setConfig(config);
		}
	}

	public ParserFinder() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, URISyntaxException {
		XmlBeanFactory _beanFactory = ParserUtil.createBeanFactory();
		
		this.persers = new ArrayList<Parser>();
		for(String _line: _beanFactory.getBeanNamesForType(Parser.class)){
			if(_line.length() > 0){
				Parser _parser = (Parser)_beanFactory.getBean(_line);
				_parser.setParserFinder(this);
				
				this.persers.add(_parser);
			}
		}
	}

	public List<Parser> getPersers() {
		return persers;
	}
	
	public Element encode(Object obj) throws IOException {
		return this.findEncoder(obj).encode(obj);
	}
	
	public Object parse(Element ele) throws IOException {
		return this.findParser(ele).parse(ele);
	}
	
	public Object parse(InputStream stream) throws IOException, JDOMException {
		SAXBuilder _builder = new SAXBuilder();
		return this.parse(_builder.build(stream).getRootElement());
	}
	
	public Parser findParser(Element ele) throws UnsupportedType {
		for (Parser _def : this.persers) {
			if(_def.canParse(ele)){
				return _def;
			}
		}
		throw new UnsupportedType("Element " + ele.getName());
	}
	
	public Parser findEncoder(Object obj) throws UnsupportedType{
		for (Parser _def : this.persers) {
			if(_def.canEncode(obj)){
				return _def;
			}
		}
		throw new UnsupportedType(obj.toString());
	}
	
	public FeatureParser findFeatureParser() {
		for (Parser _def : this.persers) {
			if(_def instanceof FeatureDef){
				return (FeatureParser)_def;
			}
		}
		
		throw new NullPointerException("Not feature parser avaliable");
	}
}
