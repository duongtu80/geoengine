package cn.geodata.models.wetland.actions.map;

import java.util.Properties;

import org.apache.commons.io.IOUtils;

import junit.framework.TestCase;

public class WaterRegionTest extends TestCase {
	public void testTest1() throws Exception {
//		Properties _ps = System.getProperties();
//		for(Object _k : _ps.keySet()){
//			System.out.println(_k + "=" + _ps.get(_k));
//		}
//		
//		System.out.println(System.getProperty("java.io.tmpdir"));
		WaterRegion _w = new WaterRegion();
		_w.setWaterlandCode("P4");
		_w.setWaterLevel(0.2);
		
		System.out.println(_w.execute());
		System.out.println(IOUtils.toString(_w.getStream()));
	}
}
