package cn.geodata.models.wetland;

import java.io.File;

import junit.framework.TestCase;

public class WaterRegionModelTest extends TestCase {

	public void testCalculate() throws NumberFormatException, Exception {
		GeoEnvironment _geo = new GeoEnvironment();
		_geo.setGeoserver("D:/mfeng/save/java/wps/service/wetland/tomcat-6.0.16");
		_geo.setWetland("webapps/geoserver/data/data/wetland/catchment.shp");
		
		Catchment _catch = new Catchment();
		_catch.setEnvi(_geo);
		_catch.setFieldName("NAME");
		
		WaterRegionModel _model = new WaterRegionModel();
		_model.setCatchment(_catch);
		_model.setReader(new EnviRasterReader(new File("d:/mfeng/save/java/wps/src/geoengine/model.wetland/resources/data/dem"), 1024 * 1024));
		_model.setWetlandTag("P4");
		_model.setWaterLevel(1);
		
		_model.calculate();
	}

}
