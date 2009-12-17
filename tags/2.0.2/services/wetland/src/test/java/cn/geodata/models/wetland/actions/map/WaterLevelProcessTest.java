package cn.geodata.models.wetland.actions.map;

import net.sf.json.JSONArray;

import org.apache.commons.io.IOUtils;

import junit.framework.TestCase;

public class WaterLevelProcessTest extends TestCase {
	public void testTest() throws Exception {
		WaterLevelStart _start = new WaterLevelStart(new Catchment(), new DayMetReader("c:\\mfeng\\tmp"));
		
		ProcessManage _manage = new ProcessManage();
		String _params = "{\"startDate\":631123200000,\"endDate\":946569600000,\"basin\":\"P4\",\"params\":{\"ET\":{\"id\":\"ETModel\",\"params\":{\"Albedo\":0.08,\"WindSpeed\":1,\"Coefficient\":1.2}},\"WaterTable\":{\"id\":\"WaterTableModel\",\"params\":{\"SaturationPrcp\":0.003}}}}";
		
		_start.setManage(_manage);
		_start.setParams(_params);
		
		_start.execute();
		
		System.out.println(IOUtils.toString(_start.getStream()));
		String _id = (String) _manage.getProcessIds().toArray()[0];
		
		Process _p = _manage.getProcess(_id);
		while(_p.getStatus().getInt("percent") >= 0 && _p.getStatus().getInt("percent") < 100){
			Thread.sleep(1000);
			System.out.println(_p.getStatus().toString());
		}
		
		System.out.println("done");
		JSONArray _arr = _p.getData().getJSONArray("waterLevel");
		System.out.println(_arr.length());
		
		
	}	
}
