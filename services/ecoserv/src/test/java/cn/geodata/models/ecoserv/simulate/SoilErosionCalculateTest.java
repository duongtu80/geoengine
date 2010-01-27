package cn.geodata.models.ecoserv.simulate;

import java.io.File;
import java.util.Map;

import cn.geodata.models.csv.CSVReader;
import cn.geodata.models.raster.GeoRaster;
import junit.framework.TestCase;

public class SoilErosionCalculateTest extends TestCase {
	public void testCalculateRFactor() throws Exception {
		GeoRaster _dem = new GeoRaster(new File("d:\\Tank\\Data\\ecoserv\\data\\dem\\lidar4.tif"), -1);
		CSVReader _climate = new CSVReader(new File("d:\\Tank\\Data\\ecoserv\\data\\ipcc\\a2.csv"));
		
		for(Map<String, String> _line : _climate.getRecords()){
//			GeoRaster _rr = new GeoRaster(new File)
			double _e = 0;
			
			double _r = 3786.6 + 1.5679 * Double.parseDouble(_line.get("prec")) - 1.9809 * _e;
		}
	}
}
