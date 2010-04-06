package cn.geodata.models.wetland.app;

import java.io.File;
import java.util.Stack;

import cn.geodata.models.raster.GeoRaster;
import junit.framework.TestCase;

public class CalWaterStorageTest extends TestCase {
	public void atestCalculation() throws Exception {
		CalWaterStorage _model = new CalWaterStorage();
		String[] args = new String[] {
				"d:\\Tank\\Data\\ecoserv\\data\\catchment.shp",
				"o:\\tmp\\lidar_c.tif",
				"p:\\data\\ecoserv\\storage1.shp" };

		GeoRaster _dem = new GeoRaster(new File(args[1]), -1);
		_model.calculate(new File(args[0]), _dem, new File(args[2]));
	}

	public void btestCalculation() throws Exception {
		CalWaterStorage _model = new CalWaterStorage();
		String[] args = new String[] {
				"p:\\data\\ecoserv\\SpillPoint\\select_west_3.shp",
				"p:\\data\\ecoserv\\Lidar\\dem_2m.tif",
				"p:\\data\\ecoserv\\storage2.shp" };

		GeoRaster _dem = new GeoRaster(new File(args[1]), -340282346638528860000000000000000000000.0f);
		_model.calculate(new File(args[0]), _dem, new File(args[2]));
	}

	public void testProblem2() throws Exception {
		CalWaterStorage _model = new CalWaterStorage();
		String[] args = new String[] {
				"p:\\data\\ecoserv\\output\\problem-2\\catchment-2336.shp",
				"p:\\data\\ecoserv\\Lidar\\dem_2m.tif",
				"p:\\data\\ecoserv\\output\\problem-2\\storage-2336-5.shp" };

		GeoRaster _dem = new GeoRaster(new File(args[1]), -340282346638528860000000000000000000000.0f);
		_model.calculate(new File(args[0]), _dem, new File(args[2]));
	}
}
