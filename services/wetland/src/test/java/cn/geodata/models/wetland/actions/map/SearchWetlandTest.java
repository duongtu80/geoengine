package cn.geodata.models.wetland.actions.map;

import org.apache.commons.io.IOUtils;

import junit.framework.TestCase;

public class SearchWetlandTest extends TestCase {
	public void testTest1() throws Exception {
		SearchWetland _t = new SearchWetland();
		
		_t.setX(-99.09382);
		_t.setY(47.10073);
		
		System.out.println(_t.execute());
		System.out.println(IOUtils.toString(_t.getStream()));
	}
}
