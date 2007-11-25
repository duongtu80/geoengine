package cn.geodata.model;

public interface Parsable {
	void parse(org.w3c.dom.Element node) throws Exception;
	boolean canParse(org.w3c.dom.Element node) throws Exception;
}
