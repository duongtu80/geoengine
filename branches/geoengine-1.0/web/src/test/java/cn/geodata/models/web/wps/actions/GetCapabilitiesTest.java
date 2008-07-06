package cn.geodata.models.web.wps.actions;

import java.util.logging.Logger;

import junit.framework.TestCase;
import cn.geodata.models.web.wps.operation.GetCapabilitiesOp;

public class GetCapabilitiesTest extends TestCase {
	private Logger log = Logger.getAnonymousLogger();

	public void testGetCapabilities() throws Exception {
		log.info((new GetCapabilitiesOp()).execute(null).toString());
	}
}
