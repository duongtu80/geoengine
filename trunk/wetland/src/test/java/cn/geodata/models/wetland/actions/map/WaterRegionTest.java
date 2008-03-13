package cn.geodata.models.wetland.actions.map;

import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

import junit.framework.TestCase;

public class WaterRegionTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();

	public void testExecute() throws Exception {
		WaterRegion _region = new WaterRegion();
		_region.setCatchmentURL("http://127.0.0.1:58080/geoserver/wfs?version=1.0.0&");
		_region.setModelURL("http://127.0.0.1:8080/web/wps");
		_region.setWaterlandCode("P4");
		_region.setWaterLevel(1);
		
		log.info("Result:" + _region.execute());
		
		log.info("Response:" + IOUtils.toString(_region.getStream()));
	}

}
