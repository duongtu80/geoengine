package cn.geodata.gml.define;

import org.jdom.Element;

public interface Definition {
	
	boolean canParse(Element ele);
	boolean canEncode(Object obj);
	
	Object parse(Element ele);
	Element encode(Object obj);
	
}
