package cn.geodata.models.data.parsers;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

import junit.framework.TestCase;

public class ArrayXMLParserTest extends TestCase {
	public void testTest1() throws Exception {
		ArrayXMLParser _p = new ArrayXMLParser();
		String _txt = "<test xmlns:tt=\"http://www.geodata.cn/data\"><tt:a>ddd</tt:a><tt:b>eeee</tt:b></test>";
		
		Document _doc = new SAXBuilder().build(new ByteArrayInputStream(_txt.getBytes()));
		
//		XPath.newInstance("//tt:a");
		List _list = XPath.selectNodes(_doc, "//tt:a");
		
		for(Object _b: _list){
			System.out.println(_b.toString());
		}
	}
}
