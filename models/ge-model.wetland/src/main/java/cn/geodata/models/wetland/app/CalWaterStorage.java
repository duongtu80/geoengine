package cn.geodata.models.wetland.app;

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
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import cn.geodata.models.raster.GeoRaster;
import cn.geodata.models.wetland.multiple.Catchment;
import cn.geodata.models.wetland.multiple.ElevationZone;
import cn.geodata.models.wetland.multiple.HydrologicalModel;
import cn.geodata.models.wetland.multiple.SpillPoint;
import cn.geodata.models.wetland.multiple.WetlandWater;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

public class CalWaterStorage {
	
	public void calculate(File shp, GeoRaster dem, File out) throws Exception {
		GeoRaster _dem = dem;

		System.out.println("Initialize catchments");
		List<Catchment> _cats = Catchment.loadCatchments(_dem, new ShapefileDataStore(shp.toURL()).getFeatureSource().getFeatures(), "NAME");
		SimpleFeatureType _ft = this.buildFeatureType(_dem.getEnvelope().getCoordinateReferenceSystem());
		
		FeatureCollection<SimpleFeatureType, SimpleFeature> _fc = (CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints())).newCollection();
		
		System.out.println("Calculate maximum storage");
		HydrologicalModel _model = new HydrologicalModel(_dem, _cats);
		for(WetlandWater _w : _model.getWetlands()){
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
		
		System.out.println("Output results to " + out.toString());
		ShapefileDataStore _fs = new ShapefileDataStore(out.toURL());
		_fs.createSchema(_ft);
		
		FeatureStore<SimpleFeatureType, SimpleFeature> _fz = (FeatureStore<SimpleFeatureType, SimpleFeature>) _fs.getFeatureSource();
		_fz.addFeatures(_fc);
	}
	
	private SimpleFeatureType buildFeatureType(CoordinateReferenceSystem crs){
		SimpleFeatureTypeBuilder _ftbld = new SimpleFeatureTypeBuilder();
		_ftbld.setName("storage");
		
		_ftbld.add("shape", MultiPolygon.class);
		_ftbld.length(20);
		_ftbld.add("code", String.class);
		_ftbld.add("spill", Double.class);
		_ftbld.add("max_st",  Double.class);
		
		return _ftbld.buildFeatureType();
	}
	
	public static void main(String[] args) throws Exception {
		CalWaterStorage _model = new CalWaterStorage();
		
		if(args.length < 3){
			System.out.println("Usage " + _model.getClass().getSimpleName() + " [catchment *.shp] [dem *.tif] [output *.shp]");
			return;
		}
		
		GeoRaster _dem = new GeoRaster(new File(args[1]), -340282346638528860000000000000000000000.0f);
		_model.calculate(new File(args[0]), _dem, new File(args[2]));
	}
}
