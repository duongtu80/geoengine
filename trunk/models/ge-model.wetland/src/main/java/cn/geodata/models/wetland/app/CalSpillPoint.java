package cn.geodata.models.wetland.app;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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

import com.vividsolutions.jts.geom.Point;

import cn.geodata.models.raster.GeoRaster;
import cn.geodata.models.wetland.multiple.Catchment;
import cn.geodata.models.wetland.multiple.HydrologicalModel;
import cn.geodata.models.wetland.multiple.SpillPoint;
import cn.geodata.models.wetland.multiple.WetlandWater;

public class CalSpillPoint {
	
	public void calculate(File shp, GeoRaster dem, File out) throws Exception{
		System.out.println("Initialize catchments");
		List<Catchment> _cats = Catchment.loadCatchments(null, new ShapefileDataStore(shp.toURL()).getFeatureSource().getFeatures(), "NAME");
		
		System.out.println("Calculate spill points");
		HydrologicalModel _hyd = new HydrologicalModel(dem, _cats);
		
		System.out.println("Output results to " + out.toString());
		SimpleFeatureType _ft = this.buildFeatureType(dem.getEnvelope().getCoordinateReferenceSystem());
		FeatureCollection<SimpleFeatureType, SimpleFeature> _cols = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		
		for(WetlandWater _w : _hyd.getWetlands()){
			SimpleFeatureBuilder _builder = new SimpleFeatureBuilder(_ft);
			
			SpillPoint _sp = _w.getSpillPoint();
			Point _loc = _sp.getLocation();
			_builder.add(_loc);
			_builder.add(_loc.getX());
			_builder.add(_loc.getY());
			_builder.add(_sp.getElevation());
			_builder.add(_w.getCatchments().get(0).getCode());
			
			if(_sp.getCatchment() != null){
				_builder.add(_sp.getCatchment().getCode());
			}
			else{
				_builder.add("[out]");
			}
			
			_cols.add(_builder.buildFeature(null));
		}
		
		ShapefileDataStore _shp = new ShapefileDataStore(out.toURL());
		_shp.createSchema(_ft);
		
		((FeatureStore<SimpleFeatureType, SimpleFeature>)_shp.getFeatureSource()).addFeatures(_cols);
	}
	
	private SimpleFeatureType buildFeatureType(CoordinateReferenceSystem crs){
		SimpleFeatureTypeBuilder _builder = new SimpleFeatureTypeBuilder();
		
		_builder.setName("spillpoint");
		
		_builder.add("SHAPE", Point.class, crs);
		_builder.length(10);
		_builder.add("X", Double.class);
		_builder.add("Y", Double.class);
		_builder.add("Z", Double.class);
		_builder.add("FROM", String.class);
		_builder.add("TO", String.class);
		
		return _builder.buildFeatureType();
	}
	
	public static void main(String[] args) throws Exception {
		CalSpillPoint _model = new CalSpillPoint();
		
		if(args.length < 3){
			System.out.println("Usage CalSpillpoint [catchment *.shp] [dem *.tif] [output *.shp]");
			return;
		}
		
		GeoRaster _dem = new GeoRaster(new File(args[1]), -340282346638528860000000000000000000000.0f);
		_model.calculate(new File(args[0]), _dem, new File(args[2]));
	}
}
