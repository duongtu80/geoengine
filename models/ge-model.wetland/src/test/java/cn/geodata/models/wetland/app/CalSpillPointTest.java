package cn.geodata.models.wetland.app;

import java.io.File;

import cn.geodata.models.raster.GeoRaster;
import junit.framework.TestCase;

public class CalSpillPointTest extends TestCase {

	public void atestCalculation() throws Exception {
		CalSpillPoint _model = new CalSpillPoint();
		String[] args = new String[] {"p:\\data\\ecoserv\\SpillPoint\\select_west_2.shp", "p:\\data\\ecoserv\\Lidar\\test1.tif", "p:\\data\\ecoserv\\out1.shp"};
		
		GeoRaster _dem = new GeoRaster(new File(args[1]), -340282346638528860000000000000000000000.0f);
		_model.calculate(new File(args[0]), _dem, new File(args[2]));
	}

	public void testCalculation() throws Exception {
		CalSpillPoint _model = new CalSpillPoint();
		String[] args = new String[] {"d:\\Tank\\Data\\ecoserv\\data\\catchment.shp", "o:\\tmp\\lidar_c.tif", "p:\\data\\ecoserv\\out2.shp"};
		
		GeoRaster _dem = new GeoRaster(new File(args[1]), -340282346638528860000000000000000000000.0f);
		_model.calculate(new File(args[0]), _dem, new File(args[2]));
	}
}
