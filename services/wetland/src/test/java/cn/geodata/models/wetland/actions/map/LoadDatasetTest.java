package cn.geodata.models.wetland.actions.map;

import junit.framework.TestCase;

public class LoadDatasetTest extends TestCase {
	public void testExecute() throws Exception {
		LoadDataset _d = new LoadDataset(new Catchment());
		_d.execute();
		
		assertNotNull(_d.getStream());
	}

}
