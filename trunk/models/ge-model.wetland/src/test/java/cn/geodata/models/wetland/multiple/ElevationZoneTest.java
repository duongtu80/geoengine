package cn.geodata.models.wetland.multiple;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

import org.apache.commons.collections.ListUtils;
import org.geotools.data.Query;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureCollection;
import org.geotools.referencing.CRS;
import org.geotools.referencing.factory.epsg.HsqlEpsgDatabase;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.filter.FilterFactory2;
import org.opengis.filter.PropertyIsEqualTo;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.vividsolutions.jts.geom.MultiPolygon;

import cn.geodata.models.raster.GeoRaster;
import junit.framework.TestCase;

public class ElevationZoneTest extends TestCase {
	private ElevationZone loadZone(String code) throws Exception{
		GeoRaster _dem = new GeoRaster(new File("o:\\tmp\\lidar_c.tif"), -1);
		
		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		PropertyIsEqualTo _filter = _factory.equals(_factory.property("NAME"), _factory.literal(code));
		
		FeatureCollection<SimpleFeatureType, SimpleFeature> _fs = new ShapefileDataStore(new File("d:\\Tank\\Data\\ecoserv\\data\\catchment.shp").toURL()).getFeatureSource().getFeatures(_filter);
		MultiPolygon _poly = (MultiPolygon) _fs.features().next().getDefaultGeometry();
		
		ElevationZone _model = new ElevationZone(550, 1000, 0.1, _dem, _poly);
		
		return _model;
	}
	
	public void testVolumeAndWaterTable() throws Exception {
		ElevationZone _model = this.loadZone("P1");
		
		double _waterTable = 567.005;
		this.assertEquals(_waterTable, _model.calculateWaterTable(_model.calculateVolume(_waterTable)));
	}
	
	public void testMerge() throws Exception {
		ElevationZone _model1 = this.loadZone("P1");
		ElevationZone _model2 = this.loadZone("P2");
		
		ElevationZone _model3 = ElevationZone.merge(_model1, _model2);
		
		this.assertTrue(Math.abs(_model3.calculateFullVolume() - (_model1.calculateFullVolume() + _model2.calculateFullVolume())) < 0.0001);
	}
	
	public void testCollection() throws Exception {
		List<String> _test = new ArrayList<String>();
		
		_test.add("a");
		_test.add("b");
		_test.add("c");
		_test.add("d");
		
		List<String> _test2 = new ArrayList<String>();
		for(String _dd: _test)
			_test2.add(_dd);
		
		for(String _dd : (String[])_test.toArray(new String[0])){
			if(_test2.contains("b"))
				_test2.remove("b");
			
			if(_test2.contains(_dd)){
				System.out.println(_dd);
			}
		}
		
	}
}
