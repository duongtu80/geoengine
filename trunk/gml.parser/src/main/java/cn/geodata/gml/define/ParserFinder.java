package cn.geodata.gml.define;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.jdom.Element;

import cn.geodata.gml.GMLConfiguration;
import cn.geodata.gml.UnsupportedType;


public class ParserFinder {
	private static ParserFinder instance;
	
	public static ParserFinder getInstance() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, URISyntaxException {
		if(instance == null){
			instance = new ParserFinder();
		}
		
		return instance;
	}
	
	private List<Definition> persers;
	
	private ParserFinder() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, URISyntaxException {
		this.persers = new ArrayList<Definition>();
		GMLConfiguration _config = new GMLConfiguration();
		for(String _line : (List<String>)IOUtils.readLines(ParserFinder.class.getResourceAsStream("/META-INF/gml.process.txt"))){
			_line = _line.trim();
			if(_line.length() > 0){
				Definition _parser = (Definition)Class.forName(_line).newInstance();
				_parser.setConfig(_config);
				
				this.persers.add(_parser);
			}
		}
	}

	public List<Definition> getPersers() {
		return persers;
	}
	
	public Element encode(Object obj) throws Exception {
		for (Definition _def : this.persers) {
			if(_def.canEncode(obj)){
				return _def.encode(obj);
			}
		}
		throw new UnsupportedType(obj.toString());
	}
	
	public Object parse(Element ele) throws Exception {
		for (Definition _def : this.persers) {
			if(_def.canParse(ele)){
				return _def.parse(ele);
			}
		}
		throw new UnsupportedType("Element " + ele.getName());
	}
}
