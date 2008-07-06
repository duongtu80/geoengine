package cn.geodata.models.value;

import java.io.IOException;

import org.apache.xmlbeans.XmlObject;

public interface Encoder {
	boolean canEncode(Object obj);
	XmlObject encode(Object obj) throws IOException;
}
