package cn.geodata.models.wetland.actions.map;

import junit.framework.TestCase;

public class WaterRegionStartTest extends TestCase {
	public void testTest1() throws Exception {
		WaterRegionStart _s = new WaterRegionStart(new Catchment());
		_s.setManage(null);
		_s.setParams("{\"basin\":\"P4\",\"params\":{\"WaterRegion\":{\"id\":\"WaterRegionModel\",\"params\":{}}}}");
		
		_s.execute();
	}
}
