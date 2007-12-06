package cn.geodata.model.value;

import java.io.IOException;

import org.apache.xmlbeans.XmlObject;

public interface Parser {
	Object parse(XmlObject type) throws IOException;
}
