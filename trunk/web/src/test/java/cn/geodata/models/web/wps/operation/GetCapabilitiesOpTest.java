package cn.geodata.models.web.wps.operation;

import java.util.logging.Logger;

import cn.geodata.models.web.util.Util;
import junit.framework.TestCase;

public class GetCapabilitiesOpTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();
	
	public void testTest1() throws Exception {
		log.info(Util.getInstance().getConfig().getString("global.port"));
	}
	
	public void testGetCapabilities() throws Exception {
		GetCapabilitiesOp _op = new GetCapabilitiesOp();
		log.info(_op.execute(null).toString());
	}
}
