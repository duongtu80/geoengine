package cn.geodata.models.wetland.pollinator;

import java.io.File;

import cn.geodata.models.raster.GeoRaster;
import junit.framework.TestCase;

public class ModelPollinatorTest extends TestCase {

	public void testCalculate() throws Exception {
		ModelPollinator _model = new ModelPollinator();
		_model.setLand(new GeoRaster(new File("e:\\Downloads\\Original.tif"), -1));
		
		GeoRaster _r = _model.calculate();
		_r.save(new File("p:\\data\\ecoserv\\pollinator.tif"));
	}
}
