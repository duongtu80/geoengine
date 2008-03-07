package cn.geodata.models.wetland.actions.map;

import java.io.File;
import java.io.FileOutputStream;
import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;
import cn.geodata.models.wetland.ETModel;
import cn.geodata.models.wetland.WaterTableModel;

public class ChartETTest extends TestCase {

	public void testExecute() throws Exception {
		ChartWaterTable _et = new ChartWaterTable();
		_et.setWidth(800);
		_et.setHeight(500);
		_et.setPt(-99.09437808990478 + ", " + 47.10128746032715);
		
		ETModel _etModel =  new ETModel();
		_etModel.setAlbedo(0.10);
		_etModel.setHeight(557.7);
		_etModel.setWindSpeed(1);
		
		WaterTableModel _waterModel = new WaterTableModel();
		_waterModel.setWaterLevel(0);
		_waterModel.setCatchmentArea(3);
		_waterModel.setSaturationPrcp(0.003);
		_waterModel.setEtModel(_etModel);
		
		_et.setWaterTableModel(_waterModel);
		System.out.println(_et.execute());
		
		FileOutputStream _stream = new FileOutputStream(new File("D:/mfeng/save/c++/zhengpeng/test.png"));
		IOUtils.copy(_et.getStream(), _stream);
		_stream.close();
	}
}
