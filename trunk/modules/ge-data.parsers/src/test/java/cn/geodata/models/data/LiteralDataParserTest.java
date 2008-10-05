package cn.geodata.models.data;

import java.util.Date;

import junit.framework.TestCase;

public class LiteralDataParserTest extends TestCase {
	public void testTest1() throws Exception {
		LiteralDataParser _p = new LiteralDataParser();
		
//		System.out.println(Integer.class.getName());
//		System.out.println(int.class.getName());
		
		assertTrue(_p.isLiteral(int.class));
		assertTrue(_p.isLiteral(Long.class));
		assertFalse(_p.isLiteral(Date.class));
		
		assertEquals(_p.encode(Integer.class, 10), "10");
		assertEquals(_p.encode(float.class, 10.1f), "10.1");
		assertEquals(_p.decode(Integer.class, "10"), 10);
		assertEquals(_p.decode(float.class, "10.1"), 10.1f);
	}
}
