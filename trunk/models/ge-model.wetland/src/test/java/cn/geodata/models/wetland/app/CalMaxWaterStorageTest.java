package cn.geodata.models.wetland.app;

import java.io.File;

import cn.geodata.models.raster.GeoRaster;
import junit.framework.TestCase;

public class CalMaxWaterStorageTest extends TestCase {

	public void testProblem2() throws Exception {
		CalMaxWaterStorage _model = new CalMaxWaterStorage();
		String[] args = new String[] {
				"p:\\data\\ecoserv\\catchments\\select_small5.shp",
				"p:\\data\\ecoserv\\Lidar\\dem_2m.tif",
				"p:\\data\\ecoserv\\output\\problem-1\\storage-small8.shp" };

		GeoRaster _dem = new GeoRaster(new File(args[1]), -340282346638528860000000000000000000000.0f);
		_model.calculate(new File(args[0]), _dem, new File(args[2]), 610);
	}
}
