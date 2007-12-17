package cn.geodata.models.data.parsers;

import java.io.File;
import java.util.Arrays;
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
	
	public void testTest1() throws Exception {
		ProcessesType _processes = ProcessesDocument.Factory.parse(new File("d:\\mfeng\\save\\java\\wps\\src\\geoengine\\test1\\src\\main\\test1.xml")).getProcesses();
		
		log.info(_processes.getProcess().getId());
	}
}
