package cn.geodata.gml.define;

import org.jdom.Element;

import cn.geodata.gml.UnsupportedType;

public interface Definition {
	
	boolean canParse(Element ele);
	boolean canEncode(Object obj);
	
	Object parse(Element ele) throws Exception;
	Element encode(Object obj) throws Exception;
	
}
