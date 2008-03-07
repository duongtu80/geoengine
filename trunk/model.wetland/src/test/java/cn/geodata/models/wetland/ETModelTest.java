package cn.geodata.models.wetland;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import junit.framework.TestCase;

public class ETModelTest extends TestCase {

	public void testCalculate() throws IOException {
//		DayMetReader _reader = new DayMetReader();
//		
//		double _x = -99.08000;
//		double _y = 47.08000;
//		
//		ArrayList<DayMet> _list = _reader.read(_x, _y);
//		
//		System.out.println("Size" + _list.size());
//		
//		ETModel _etModel =  new ETModel();
//		_etModel.setAlbedo(0.10);
//		_etModel.setHeight(557.7);
//		_etModel.setWindSpeed(1);
//		
//		WaterTableModel _waterModel = new WaterTableModel();
//		_waterModel.setWaterLevel(0);
//		_waterModel.setCatchmentArea(3);
//		_waterModel.setSaturationPrcp(0.003);
//		
//		ArrayList<String> _outputs = new ArrayList<String>();
//		for (int i = 0; i < _list.size(); i++) {
//			if(_list.get(i).getYear() < 1988){
//				continue;
//			}
//			
//			_waterModel.setDayMet(_list.get(i));
//			_waterModel.setEtModel(_etModel);
//			
//			System.out.println(_waterModel.calculate());
//			_outputs.add(String.format("%d %d %f %f %f", _list.get(i).getYear(), _list.get(i).getDay(), _etModel.getEt(), _list.get(i).getPrcp(), _waterModel.getWaterLevel()));
//		}
//		
//		FileUtils.writeLines(new File("D:/mfeng/save/c++/zhengpeng/out.txt"), _outputs);
	}
}
