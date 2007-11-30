package cn.geodata.gml;


import org.jdom.Element;



public interface Parser {
	
	boolean canParse(Element ele);
	boolean canEncode(Object obj);
	
	Object parse(Element ele) throws Exception;
	Element encode(Object obj) throws Exception;
	GMLConfiguration getConfig();
	void setConfig(GMLConfiguration config);
	ParserFinder getParserFinder();
	void setParserFinder(ParserFinder finder);
}
