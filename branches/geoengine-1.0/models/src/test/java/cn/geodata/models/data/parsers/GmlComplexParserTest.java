package cn.geodata.models.data.parsers;

import java.util.logging.Logger;

import junit.framework.TestCase;

public class GmlComplexParserTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();
	private GmlComplexParser parser;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		this.parser = new GmlComplexParser();
	}

	public void testGetMimes() throws Exception {
		log.info(this.parser.getMimes().toString());
	}
	
	public void testGetCategories() throws Exception {
		log.info(this.parser.getCategories().toString());
	}
}
