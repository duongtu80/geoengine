package cn.geodata.models.value;

import java.io.IOException;

import org.apache.xmlbeans.XmlObject;

public interface Parser {
	boolean canParse(XmlObject type);
	Object parse(XmlObject type) throws IOException;
}
