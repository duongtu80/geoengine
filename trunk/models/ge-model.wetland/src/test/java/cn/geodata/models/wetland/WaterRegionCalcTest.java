package cn.geodata.models.wetland;

import java.io.File;

import junit.framework.TestCase;

import org.geotools.data.FeatureStore;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import cn.geodata.models.raster.GeoRaster;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.MultiPolygon;

public class WaterRegionCalcTest extends TestCase {
	public void atestMultipleWetland() throws Exception {
		WaterRegionCalcGeoTiff _calc = new WaterRegionCalcGeoTiff();
		
		GeoRaster _raster = new GeoRaster(new File("d:\\Tank\\Data\\ecoserv\\dem\\ned10mbrwgs84.tif"), 0);
		MultiPolygon _poly = (MultiPolygon) ((SimpleFeature)new ShapefileDataStore(new File("d:\\Tank\\Data\\ecoserv\\RUSLE\\catchment.shp").toURL()).getFeatureSource().getFeatures().toArray()[0]).getDefaultGeometry();
		
		assertNotNull(_poly);
		
		int _level = 22;
		_calc.setCatchment(_poly);
		_calc.setReader(_raster);
		_calc.setWaterLevel(_level);
		
		MultiPolygon _region = _calc.calculate();
		if(_region != null){
			System.out.println(_region.getArea());
			outputMultiPolygon(_region, _level);
		}
	}
	
	private void outputMultiPolygon(MultiPolygon poly, int level) throws Exception{
		SimpleFeatureTypeBuilder _builder = new SimpleFeatureTypeBuilder();
		_builder.setName("test1");
		_builder.add("shape", MultiPolygon.class);
		
		SimpleFeatureType _bb = _builder.buildFeatureType();

		ShapefileDataStore _ss = new ShapefileDataStore(new File("d:\\Tank\\Data\\ecoserv\\test\\test1_" + level + ".shp").toURL());
		_ss.createSchema(_bb);
		
		FeatureCollection _fc = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		_fc.add(SimpleFeatureBuilder.build(_bb, new Object[] {poly}, null));
		
		FeatureStore _fw = (FeatureStore) _ss.getFeatureSource();
		_fw.addFeatures(_fc);
	}
	
	public void testDirection() throws Exception {
		WaterRegionCalc _model = new WaterRegionCalc();
		
		System.out.println(Math.toDegrees(_model.direction(new Coordinate(0, 0), new Coordinate(0, 1))));
		System.out.println(Math.toDegrees(_model.direction(new Coordinate(0, 0), new Coordinate(1, 0))));
		System.out.println(Math.toDegrees(_model.direction(new Coordinate(0, 0), new Coordinate(1, 1))));
		System.out.println(Math.toDegrees(_model.direction(new Coordinate(0, 0), new Coordinate(0, -1))));
		System.out.println(Math.toDegrees(_model.direction(new Coordinate(0, 0), new Coordinate(-1, 0))));
		System.out.println(Math.toDegrees(_model.direction(new Coordinate(0, 0), new Coordinate(-1, -1))));
		System.out.println(Math.toDegrees(_model.direction(new Coordinate(0, 0), new Coordinate(-1, 1))));
		System.out.println(Math.toDegrees(_model.direction(new Coordinate(0, 0), new Coordinate(1, -1))));
	}
}
