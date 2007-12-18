package cn.geodata.models.data.parsers;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import cn.geodata.models.geoprocessing.ProcessesDocument;
import cn.geodata.models.geoprocessing.ProcessesType;

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
