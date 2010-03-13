package cn.geodata.models.wetland.app;

import java.io.File;

import cn.geodata.models.raster.GeoRaster;
import junit.framework.TestCase;

public class CalWaterStorageTest extends TestCase {
	public void testCalculation() throws Exception {
		CalWaterStorage _model = new CalWaterStorage();
		String[] args = new String[] {
				"d:\\Tank\\Data\\ecoserv\\data\\catchment.shp",
				"o:\\tmp\\lidar_c.tif",
				"p:\\data\\ecoserv\\storage1.shp" };

		GeoRaster _dem = new GeoRaster(new File(args[1]), -1);
		_model.calculate(new File(args[0]), _dem, new File(args[2]));
	}
}
