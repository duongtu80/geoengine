package cn.geodata.models.ecoserv.simulate;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;

import junit.framework.TestCase;

public class RandomModelTest extends TestCase {
	public void atestCalculate() throws Exception {
		RandomModel _model = new RandomModel();
		
		Scenario _vv = _model.calculate(new Date(), new Date(), Arrays.asList(new String[] {"wetland", "crop"}));
		System.out.println(_vv.getId());
	}
	
	public void testLoadData() throws Exception {
		Scenario _vv = Scenario.load("mod3232838170594915611");
		
		System.out.println(Arrays.toString(_vv.getDates().toArray()));
		
		_vv.generateLineChart("Water Storage", new FileOutputStream(new File("c:\\mfeng\\tmp\\tttt.png")), 300, 400);
	}
}
