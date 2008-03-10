package cn.geodata.models.wetland;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import junit.framework.TestCase;

public class ETModelTest extends TestCase {

	public void testCalculate() throws IOException, ParseException {
		DayMetReader _reader = new DayMetReader();
		
		double _x = -99.08000;
		double _y = 47.08000;
		
		Date _startDate = new Date(88, 0, 1);
		Date _endDate = new Date(99, 11, 31);
		
		System.out.println(_startDate.toString());
		
		ArrayList<DayMet> _list = _reader.read(_startDate, _endDate, _x, _y);
		
		System.out.println("Size" + _list.size());
		
		ETModel _etModel =  new ETModel();
		_etModel.setAlbedo(0.08);
		_etModel.setHeight(557.7);
		_etModel.setWindSpeed(1);
		
		WaterTableModel _waterModel = new WaterTableModel();
		_waterModel.setWaterLevel(0);
		_waterModel.setCatchmentArea(3);
		_waterModel.setSaturationPrcp(0.003);
		
		ArrayList<String> _outputs = new ArrayList<String>();
		for (int i = 0; i < _list.size(); i++) {
			_waterModel.setDayMet(_list.get(i));
			_waterModel.setEtModel(_etModel);
			
			System.out.println(_waterModel.calculate());
			_outputs.add(String.format("%d\t%d\t%f\t%f\t%f", _list.get(i).getYear(), _list.get(i).getDay(), _etModel.getEt(), _list.get(i).getPrcp(), _waterModel.getWaterLevel()));
		}
		
		FileUtils.writeLines(new File("D:/mfeng/save/c++/zhengpeng/out.txt"), _outputs);
	}
}
