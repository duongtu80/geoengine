package cn.geodata.models.gml;


import java.io.IOException;

import org.jdom.Element;



public interface Parser {

	boolean canParse(Element ele);
	boolean canEncode(Object obj);
	
	Object parse(Element ele) throws IOException;
	Element encode(Object obj) throws IOException;
	GMLConfiguration getConfig();
	void setConfig(GMLConfiguration config);
	ParserFinder getParserFinder();
	void setParserFinder(ParserFinder finder);
}
