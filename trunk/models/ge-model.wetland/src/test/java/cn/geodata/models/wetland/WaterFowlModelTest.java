package cn.geodata.models.wetland;

import java.util.List;

import org.apache.commons.io.IOUtils;

import junit.framework.TestCase;

public class WaterFowlModelTest extends TestCase {
	public void testLoadResource() throws Exception {
		assertNotNull(WaterFowlModel.class.getResourceAsStream("/wetland/waterFowls.txt"));
		
		for(String _line: (List<String>)IOUtils.readLines(WaterFowlModel.class.getResourceAsStream("/wetland/waterFowls.txt"))){
			String[] _parts = _line.split("\\s*,\\s*");
			assertEquals(_parts.length, 3);
		}
	}
}
