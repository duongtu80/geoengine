package cn.geodata.models.ecoserv.simulate;

import java.io.File;
import java.io.IOException;
import java.util.List;

import cn.geodata.models.ecoserv.landcover.LandCover;
import cn.geodata.models.ecoserv.landcover.LandCoverMgr;
import cn.geodata.models.raster.GeoRaster;
import cn.geodata.models.wetland.dem.ClimateModel;
import junit.framework.TestCase;

public class SoilErosionModelTest extends TestCase {

	public void testCalculate() throws Exception {
		GeoRaster _dem = new GeoRaster(new File(
		"d:\\Tank\\Data\\ecoserv\\data\\dem\\lidar_c.tif"), 0f);
		
		GeoRaster _kFactor = new GeoRaster(new File("o:\\tmp\\rusle\\test2\\kfcacthwgs84.tif"), -340282346638528860000000000000000000000.0f);

		ClimateModel _climate = new ClimateModel(new File("d:\\Tank\\Data\\ecoserv\\data\\ipcc"));
		SoilErosionModel _model = new SoilErosionModel(_dem, _kFactor);
		
		LandCoverMgr _mgr = new LandCoverMgr();
		LandCover _landcover = _mgr.getLandCover("Wetland");
		
		for(int _year = 2000;_year < 2010;_year++){
			double _val = _model.soilLossTolerance(_model.averageRaster(_model.calculate(_climate.precipitationAvgYearly("b2", _year), _landcover.toRaster())));
			System.out.println(_year + "\t" + _val);
		}
	}
	
	
	public void atestLandCover() throws Exception {
		LandCoverMgr _mgr = new LandCoverMgr();
		List<LandCover> _lands = _mgr.listLandCover(null);		
		
		for(LandCover _land: _lands){
			System.out.println(_land.getTitle());
		}
	}
}
