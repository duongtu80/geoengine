package cn.geodata.models.ecoserv.simulate;

import java.util.ArrayList;
import java.util.Date;

import org.geotools.referencing.CRS;

import cn.geodata.models.ecoserv.landcover.LandCover;
import cn.geodata.models.ecoserv.landcover.LandCoverMgr;
import cn.geodata.models.ecoserv.utils.DayMet;
import cn.geodata.models.ecoserv.utils.DayMetReader;
import junit.framework.TestCase;

public class CarbonModelTest extends TestCase {
	
	public void testTest1() throws Exception {
		System.out.println("test%#23 we".replaceAll("[^\\w\\d]+", "_"));
	}

	public void atestCalculate() throws Exception {
		LandCover _landcover = new LandCoverMgr().getLandCover("Developed");
		
		ArrayList<DayMet> _days = new DayMetReader().read(null, null, "p4", -114, 45);
		
		CarbonModel _model = new CarbonModel();
		_model.initLandCover(_landcover, _days);
		System.out.println(_model.calculate(new Date(95, 6, 18 + 1)));
		_model.initLandCover(new LandCoverMgr().getLandCover("Wetland"), _days);
		System.out.println(_model.calculate(new Date(95, 6, 18 + 1)));
//		for(int i=0;i<30;i++)
//			System.out.println(i + "->" + _model.calculate(new Date(95, 6, i + 1)));
	}
}
