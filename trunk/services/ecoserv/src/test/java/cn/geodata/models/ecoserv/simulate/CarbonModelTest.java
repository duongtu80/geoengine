package cn.geodata.models.ecoserv.simulate;

import java.util.Date;

import org.geotools.referencing.CRS;

import cn.geodata.models.ecoserv.landcover.LandCover;
import cn.geodata.models.ecoserv.landcover.LandCoverMgr;
import junit.framework.TestCase;

public class CarbonModelTest extends TestCase {
	
	public void testTest1() throws Exception {
		CRS.decode("EPSG:4326");
	}

	public void atestCalculate() throws Exception {
		LandCover _landcover = new LandCoverMgr().getLandCover("Developed");
		
		CarbonModel _model = new CarbonModel();
		_model.initLandCover(_landcover);
		System.out.println(_model.calculate(new Date(95, 6, 18 + 1)));
		_model.initLandCover(new LandCoverMgr().getLandCover("Wetland"));
		System.out.println(_model.calculate(new Date(95, 6, 18 + 1)));
//		for(int i=0;i<30;i++)
//			System.out.println(i + "->" + _model.calculate(new Date(95, 6, i + 1)));
	}
}
