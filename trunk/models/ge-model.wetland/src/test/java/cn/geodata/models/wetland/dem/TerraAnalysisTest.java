package cn.geodata.models.wetland.dem;

import java.awt.Point;
import java.io.File;

import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;

import cn.geodata.models.raster.GeoRaster;
import junit.framework.TestCase;

public class TerraAnalysisTest extends TestCase {
	public void atestSlope() throws Exception {
		GeoRaster _dem = new GeoRaster(new File(
		"d:\\Tank\\Data\\ecoserv\\data\\dem\\lidar_c.tif"), -9999f);

		TerrainModel _model = new TerrainModel();
		_model.slope(_dem).save(new File("o:\\tmp\\rusle\\test4\\slope_2.tif"));		
	}
	
	public void atestFlowDirection() throws Exception {
		GeoRaster _dem = new GeoRaster(new File(
		"d:\\Tank\\Data\\ecoserv\\data\\dem\\lidar_c.tif"), -9999f);

		TerrainModel _model = new TerrainModel();
		_model.flowDirection(_dem).save(new File("o:\\tmp\\rusle\\flow_dir_1.tif"));
	}

	public void atestFlowDirectionMultiple() throws Exception {
		GeoRaster _dem = new GeoRaster(new File(
		"d:\\Tank\\Data\\ecoserv\\data\\dem\\lidar_c.tif"), -9999f);

		TerrainModel _model = new TerrainModel();
		_model.flowDirectionMultiple(_dem).save(new File("o:\\tmp\\rusle\\flow_dir_4.tif"));
	}

	public void atestFlowAccumulation() throws Exception {
		GeoRaster _dem = new GeoRaster(new File(
		"o:\\tmp\\rusle\\flow_dir_4.tif"), new Integer(0));

		TerrainModel _model = new TerrainModel();
		_model.flowAccumulation(_dem).save(new File("o:\\tmp\\rusle\\flow_acu_8.tif"));
	}
	
	public void atestDirection() throws Exception {
		TerrainModel _model = new TerrainModel();

		Point _pt = new Point(0, 0);
		assertEquals(_model.direction(_pt, new Point(0, 0)), 0);
		assertEquals(_model.direction(_pt, new Point(1, 0)), 1);
		assertEquals(_model.direction(_pt, new Point(1, 1)), 2);
		assertEquals(_model.direction(_pt, new Point(0, 1)), 4);
		assertEquals(_model.direction(_pt, new Point(-1, 1)), 8);
		assertEquals(_model.direction(_pt, new Point(-1, 0)), 16);
		assertEquals(_model.direction(_pt, new Point(-1, -1)), 32);
		assertEquals(_model.direction(_pt, new Point(0, -1)), 64);
		assertEquals(_model.direction(_pt, new Point(1, -1)), 128);
	}
}
