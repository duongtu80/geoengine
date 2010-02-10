package cn.geodata.models.wetland.soil.erosion;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.geodata.models.raster.GeoRaster;
import cn.geodata.models.wetland.dem.TerrainModel;
import junit.framework.TestCase;

public class ModelRUSLETest extends TestCase {

	public void atestCalculate() throws Exception {
		File _output = new File("o:\\tmp\\rusle\\output3");
		ModelRUSLE _model = new ModelRUSLE();

		GeoRaster _dem = new GeoRaster(new File(
		"d:\\Tank\\Data\\ecoserv\\data\\dem\\lidar_c.tif"), -9999f);

		TerrainModel _terra = new TerrainModel();

		_terra.slope(_dem).save(new File(_output, "slope.tif"));;
		GeoRaster _flow = _terra.flowDirectionMultiple(_dem);
		_flow.save(new File(_output, "flow.tif"));
		_terra.flowAccumulation(_flow).save(new File(_output, "accum.tif"));

		_model.factorLS().save(new File(_output, "ls_factor.tif"));
		_model.factorC().save(new File(_output, "c_factor.tif"));
		
		GeoRaster _r = _model.calculate();
		
		_r.save(new File(_output, "rusle_70.tif"));
	}

	public void testCalculateUTM() throws Exception {
		File _output = new File("o:\\tmp\\rusle\\output5");
		ModelRUSLE _model = new ModelRUSLE();

		GeoRaster _dem = new GeoRaster(new File(
		"o:\\tmp\\claudia\\lidar.dem.rec.2.5m.nad83utm14n.tif"), -3.4028235e+038f);

		TerrainModel _terra = new TerrainModel();

		_terra.slope(_dem).save(new File(_output, "slope.tif"));;
		GeoRaster _flow = _terra.flowDirectionMultiple(_dem);
		_flow.save(new File(_output, "flow.tif"));
		_terra.flowAccumulation(_flow).save(new File(_output, "accum.tif"));

		_model.factorLS().save(new File(_output, "ls_factor.tif"));
//		_model.factorC().save(new File(_output, "c_factor.tif"));
//		
//		GeoRaster _r = _model.calculate();
//		
//		_r.save(new File(_output, "rusle_70.tif"));
	}

	public void atestCalculateLS() throws Exception {
		File _output = new File("o:\\tmp\\rusle");
		ModelRUSLE _model = new ModelRUSLE();

		_model.factorLS().save(new File(_output, "ls.tif"));
	}

	public void atestCalculateR() throws Exception {
		ModelRUSLE _model = new ModelRUSLE();
		
		for(int i=1900;i<=2100;i++){
			
//			System.out.println(i + "\t" + _model.calculateRF("b2", i) + "\t" + _model.calculateRF("a2", i));
			System.out.println(i + "\t" + _model.avgList(_model.precipitationAvgYearly("b2", i)) + "\t" + _model.avgList(_model.precipitationAvgYearly("a2", i)));
		}		
//		_r.save(new File("o:\\tmp\\rusle\\r2.tif"));
	}

	public void atestCalculateC() throws Exception {
		ModelRUSLE _model = new ModelRUSLE();
		GeoRaster _r = _model.factorC();
		
		_r.save(new File("o:\\tmp\\rusle\\land_1.tif"));
	}
}
