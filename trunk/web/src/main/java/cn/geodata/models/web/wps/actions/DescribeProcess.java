package cn.geodata.models.web.wps.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Logger;

public class DescribeProcess {
	private static Logger log = Logger.getAnonymousLogger();
	
	private InputStream result;
	
	public InputStream getResult() {
		return this.result;
	}	
	
	public String execute() throws Exception {
		log.info("describe processing ...");
		
		
		
		this.result = new ByteArrayInputStream("<test></test>".getBytes());
		return "success";
	}
}
