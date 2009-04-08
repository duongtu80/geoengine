package cn.geodata.models.wetland.actions.map;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.UrlResource;

import junit.framework.TestCase;

public class WaterFowlStartTest extends TestCase {
	public void testWaterFowls() throws Exception {
		XmlBeanFactory _factory = new XmlBeanFactory(new UrlResource(WaterFowlStartTest.class.getResource("/applicationContext.xml")));
		WaterLevelStart _start = (WaterLevelStart) _factory.getBean("waterLevelStart");
		
//		ProcessManage _manage = new ProcessManage();
		String _params = "{\"startDate\":631123200000,\"endDate\":946569600000,\"basin\":\"P4\",\"params\":{\"ET\":{\"id\":\"ETModel\",\"params\":{\"Albedo\":0.08,\"WindSpeed\":1,\"Coefficient\":1.2}},\"WaterTable\":{\"id\":\"WaterTableModel\",\"params\":{\"SaturationPrcp\":0.003}}}}";
		
//		_start.setManage(_manage);
		_start.setParams(_params);
		
		_start.execute();
		
		System.out.println(IOUtils.toString(_start.getStream()));
		String _id = (String) _start.getManage().getProcessIds().toArray()[0];
		Process _p = _start.getManage().getProcess(_id);
		
		while(_p.getStatus().getInt("percent") >= 0 && _p.getStatus().getInt("percent") < 100){
			Thread.sleep(1000);
			System.out.println(_p.getStatus().toString());
		}
		
//		FileUtils.writeStringToFile(new File("d:\\Temp\\eeee.txt"), _p.getData().toString());
		
		WaterFowlStart _fowl = (WaterFowlStart) _factory.getBean("saterFowlStart");
		_fowl.setId(_id);
		_fowl.setWetlandCode("P4");
		
		System.out.println(_fowl.execute());
		
		IOUtils.copy(_fowl.getStream(), FileUtils.openOutputStream(new File("c:\\mfeng\\tmp\\eeeee2.txt")));
	}
}
