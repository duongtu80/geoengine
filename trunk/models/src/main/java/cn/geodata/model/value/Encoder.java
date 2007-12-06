package cn.geodata.model.value;

import java.io.IOException;

import org.apache.xmlbeans.XmlObject;

public interface Encoder {
	XmlObject encode(Object obj) throws IOException;
}
