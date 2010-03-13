package cn.geodata.models.wetland.multiple;

import java.io.File;
import java.util.List;

import org.geotools.data.FeatureStore;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.filter.FilterFactory2;
import org.opengis.filter.PropertyIsEqualTo;

import cn.geodata.models.raster.GeoRaster;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

import junit.framework.TestCase;

public class StorageTest extends TestCase {
	private ElevationZone loadZone(String code) throws Exception{
		GeoRaster _dem = new GeoRaster(new File("o:\\tmp\\lidar_c.tif"), -1);
		
		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		PropertyIsEqualTo _filter = _factory.equals(_factory.property("NAME"), _factory.literal(code));
		
		FeatureCollection<SimpleFeatureType, SimpleFeature> _fs = new ShapefileDataStore(new File("d:\\Tank\\Data\\ecoserv\\data\\catchment.shp").toURL()).getFeatureSource().getFeatures(_filter);
		MultiPolygon _poly = (MultiPolygon) _fs.features().next().getDefaultGeometry();
		
		ElevationZone _model = new ElevationZone(550, 1000, 0.1, _dem, _poly);
		
		return _model;
	}
	
	public void atestMaxStorage() throws Exception {
		GeoRaster _dem = new GeoRaster(new File("o:\\tmp\\lidar_c.tif"), -1);
		List<Catchment> _cats = Catchment.loadCatchments(_dem, new ShapefileDataStore(new File("d:\\Tank\\Data\\ecoserv\\data\\catchment.shp").toURL()).getFeatureSource().getFeatures(), "NAME");
		
		SimpleFeatureTypeBuilder _ftbld = new SimpleFeatureTypeBuilder();
		_ftbld.setName("storage");
		
		_ftbld.add("shape", MultiPolygon.class, _dem.getEnvelope().getCoordinateReferenceSystem());
		_ftbld.length(20);
		_ftbld.add("code", String.class);
		_ftbld.add("spill", Double.class);
		_ftbld.add("max_st",  Double.class);
		
		SimpleFeatureType _ft = _ftbld.buildFeatureType();
		
		ShapefileDataStore _fs = new ShapefileDataStore(new File("p:\\temp\\storage\\test1.shp").toURL());
		_fs.createSchema(_ft);
		
		FeatureStore<SimpleFeatureType, SimpleFeature> _fz = (FeatureStore<SimpleFeatureType, SimpleFeature>) _fs.getFeatureSource();
		FeatureCollection<SimpleFeatureType, SimpleFeature> _fc = (CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints())).newCollection();
		
		HydrologicalModel _model = new HydrologicalModel(_dem, _cats);
		for(WetlandWater _w : _model.getWetlands()){
			SpillPoint _sp = _w.getSpillPoint();
			if(_sp == null)
				continue;
			
			ElevationZone _zone = new ElevationZone(550, 1000000, 0.0001, _dem, _w.getCatchmentRegion());
			double _vol = _zone.calculateVolume(_sp.getElevation());
			
			SimpleFeatureBuilder _fbld = new SimpleFeatureBuilder(_ft);
			_fbld.add(_w.getCatchmentRegion());
			_fbld.add(_w.getCatchments().get(0).getCode());
			_fbld.add(_sp.getElevation());
			_fbld.add(_vol);
			
			_fc.add(_fbld.buildFeature(null));
			
			System.out.println(_w.getCatchments().get(0).getCode() + "\t" + _sp.getElevation() + "\t" + _vol);
		}
		
		_fz.addFeatures(_fc);
	}
	
	public void testWaterMerge() throws Exception {
		GeoRaster _dem = new GeoRaster(new File("o:\\tmp\\lidar_c.tif"), -1);
		List<Catchment> _cats = Catchment.loadCatchments(_dem, new ShapefileDataStore(new File("d:\\Tank\\Data\\ecoserv\\data\\catchment.shp").toURL()).getFeatureSource().getFeatures(), "NAME");
		
		SimpleFeatureTypeBuilder _ftbld = new SimpleFeatureTypeBuilder();
		_ftbld.setName("storage");
		
		_ftbld.add("shape", MultiPolygon.class, _dem.getEnvelope().getCoordinateReferenceSystem());
		_ftbld.length(20);
		_ftbld.add("code", String.class);
		_ftbld.add("spill", Double.class);
		_ftbld.add("max_st",  Double.class);
		
		SimpleFeatureType _ft = _ftbld.buildFeatureType();
		
		ShapefileDataStore _fs = new ShapefileDataStore(new File("p:\\temp\\storage\\test16.shp").toURL());
		_fs.createSchema(_ft);
		
		FeatureStore<SimpleFeatureType, SimpleFeature> _fz = (FeatureStore<SimpleFeatureType, SimpleFeature>) _fs.getFeatureSource();
		FeatureCollection<SimpleFeatureType, SimpleFeature> _fc = (CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints())).newCollection();
		
		HydrologicalModel _model = new HydrologicalModel(_dem, _cats);
		for(WetlandWater _w : _model.getWetlands()){
			if(_w.getCatchments().get(0).getCode().equals("P5")){
				_w.setWaterLevel(_w.getSpillPoint().getElevation() + 0.5);
			}
			else
				_w.setWaterLevel(_w.getSpillPoint().getElevation() - 0.3);
			
		}
		
		for(WaterTable _w : _model.calculateWaterFlow2()){
			System.out.println(_w.toString() + "\t" + _w.getWaterLevel() + "\t" + _w.getWaterVolume());

			SimpleFeatureBuilder _fbld = new SimpleFeatureBuilder(_ft);
			_fbld.add(_w.calculateWaterRegion());
			_fbld.add(_w.toString());
			_fbld.add(_w.getWaterLevel());
			_fbld.add(_w.getWaterVolume());
			
			_fc.add(_fbld.buildFeature(null));
		}
		
		System.out.println("Output...");
		_fz.addFeatures(_fc);
	}

	public void atestWaterSurface() throws Exception {
		GeoRaster _dem = new GeoRaster(new File("o:\\tmp\\lidar_c.tif"), -1);
		List<Catchment> _cats = Catchment.loadCatchments(_dem, new ShapefileDataStore(new File("d:\\Tank\\Data\\ecoserv\\data\\catchment.shp").toURL()).getFeatureSource().getFeatures(), "NAME");
		
		SimpleFeatureTypeBuilder _ftbld = new SimpleFeatureTypeBuilder();
		_ftbld.setName("storage");
		
		_ftbld.add("shape", MultiPolygon.class, _dem.getEnvelope().getCoordinateReferenceSystem());
		_ftbld.length(20);
		_ftbld.add("code", String.class);
		_ftbld.add("spill", Double.class);
		_ftbld.add("max_st",  Double.class);
		
		SimpleFeatureType _ft = _ftbld.buildFeatureType();
		
		ShapefileDataStore _fs = new ShapefileDataStore(new File("p:\\temp\\storage\\test11.shp").toURL());
		_fs.createSchema(_ft);
		
		FeatureStore<SimpleFeatureType, SimpleFeature> _fz = (FeatureStore<SimpleFeatureType, SimpleFeature>) _fs.getFeatureSource();
		FeatureCollection<SimpleFeatureType, SimpleFeature> _fc = (CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints())).newCollection();
		
		HydrologicalModel _model = new HydrologicalModel(_dem, _cats);
		
		for(WetlandWater _w : _model.getWetlands()){
//			if(_w.getCatchments().get(0).getCode().equals("P2") == false)
//				continue;
			
			SpillPoint _sp = _w.getSpillPoint();
			if(_sp == null)
				continue;
			
			_w.setWaterLevel(_sp.getElevation() + 0.1);
			
			ElevationZone _zone = new ElevationZone(550, 1000000, 0.0001, _dem, _w.getCatchmentRegion());
			double _vol = _zone.calculateVolume(_sp.getElevation());
			
			SimpleFeatureBuilder _fbld = new SimpleFeatureBuilder(_ft);
			_fbld.add(_w.calculateWaterRegion());
			_fbld.add(_w.getCatchments().get(0).getCode());
			_fbld.add(_sp.getElevation());
			_fbld.add(_vol);
			
			_fc.add(_fbld.buildFeature(null));
			
			System.out.println(_w.getCatchments().get(0).getCode() + "\t" + _sp.getElevation() + "\t" + _vol);
		}
		
		_fz.addFeatures(_fc);
	}
}
