package cn.geodata.models.wetland.app;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
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
import cn.geodata.models.wetland.multiple.WaterTable;
import cn.geodata.models.wetland.multiple.WetlandWater;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

public class CalMaxWaterStorage {
	
	public void calculate(File shp, GeoRaster dem, File out, double waterTable) throws Exception {
		GeoRaster _dem = dem;
		double _waterTable = waterTable;

		System.out.println("Initialize catchments");
		
		List<Catchment> _cats = Catchment.loadCatchments(_dem, new ShapefileDataStore(shp.toURL()).getFeatureSource().getFeatures(), "NAME");
		SimpleFeatureType _ft = this.buildFeatureType(_dem.getEnvelope().getCoordinateReferenceSystem());
		FeatureCollection<SimpleFeatureType, SimpleFeature> _fc = (CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints())).newCollection();

		SimpleFeatureType _ftSP = this.buildSPFeatureType(_dem.getEnvelope().getCoordinateReferenceSystem());
		FeatureCollection<SimpleFeatureType, SimpleFeature> _fcSP = (CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints())).newCollection();

		System.out.println("Calculate maximum storage (" + _waterTable + ")");
		HydrologicalModel _model = new HydrologicalModel(_dem, _cats);
		for(WetlandWater _w : _model.getWetlands()){
			_w.setWaterLevel(_waterTable);
		}
		
		System.out.println("Generate water surface");
		for(WaterTable _w : _model.calculateWaterFlowEx()){
			SpillPoint _sp = _w.getSpillPoint();
			if(_sp == null)
				continue;
			
			//Create water surface
			double _vol = _w.getWaterVolume();
			SimpleFeatureBuilder _fbld = new SimpleFeatureBuilder(_ft);
			_fbld.add(_w.calculateWaterRegion());
			_fbld.add(_w.toString());
			_fbld.add(_sp.getElevation());
			_fbld.add(_w.getWaterLevel());
			_fbld.add(_vol);
			
			_fc.add(_fbld.buildFeature(null));
			
			//Create spill point
			SimpleFeatureBuilder _fbldSP = new SimpleFeatureBuilder(_ftSP);
			_fbldSP.add(_sp.getLocation());
			_fbldSP.add(_w.toString());
			
			String _out = "out";
			if(_sp.getCatchment() != null)
				_out = _sp.getCatchment().getCode();
			_fbldSP.add(_out);
			_fbldSP.add(_sp.getElevation());
			
			_fcSP.add(_fbldSP.buildFeature(null));
			
			System.out.println(_w.getCatchments().get(0).getCode() + "\t" + _sp.getElevation() + "\t" + _vol);
		}
		
		System.out.println("Output results to " + out.toString());
		ShapefileDataStore _fs = new ShapefileDataStore(out.toURL());
		_fs.createSchema(_ft);
		
		FeatureStore<SimpleFeatureType, SimpleFeature> _fz = (FeatureStore<SimpleFeatureType, SimpleFeature>) _fs.getFeatureSource();
		_fz.addFeatures(_fc);
		
		File _outSP = new File(out.getParentFile(), FilenameUtils.getBaseName(out.getName()) + "_sp.shp");
		System.out.println("Output spill points to " + _outSP.toString());
		ShapefileDataStore _fsSP = new ShapefileDataStore(_outSP.toURL());
		_fsSP.createSchema(_ftSP);
		
		FeatureStore<SimpleFeatureType, SimpleFeature> _fzSP = (FeatureStore<SimpleFeatureType, SimpleFeature>) _fsSP.getFeatureSource();
		_fzSP.addFeatures(_fcSP);
	}
	
	private SimpleFeatureType buildFeatureType(CoordinateReferenceSystem crs){
		SimpleFeatureTypeBuilder _ftbld = new SimpleFeatureTypeBuilder();
		_ftbld.setName("storage");
		
		_ftbld.add("shape", MultiPolygon.class);
		_ftbld.length(2000);
		_ftbld.add("code", String.class);
		_ftbld.add("spill", Double.class);
		_ftbld.add("height", Double.class);
		_ftbld.add("max_st",  Double.class);
		
		return _ftbld.buildFeatureType();
	}
	
	private SimpleFeatureType buildSPFeatureType(CoordinateReferenceSystem crs){
		SimpleFeatureTypeBuilder _ftbld = new SimpleFeatureTypeBuilder();
		_ftbld.setName("spillpoint");
		
		_ftbld.add("shape", Point.class);
		_ftbld.length(2000);
		_ftbld.add("code", String.class);
		_ftbld.length(20);
		_ftbld.add("out", String.class);
		_ftbld.add("spill", Double.class);
		
		return _ftbld.buildFeatureType();
	}

	public static void main(String[] args) throws Exception {
		CalMaxWaterStorage _model = new CalMaxWaterStorage();
		
		if(args.length < 4){
			System.out.println("Usage " + _model.getClass().getSimpleName() + " [catchment *.shp] [dem *.tif] [output *.shp] [water table]");
			return;
		}
		
		GeoRaster _dem = new GeoRaster(new File(args[1]), -340282346638528860000000000000000000000.0f);
		_model.calculate(new File(args[0]), _dem, new File(args[2]), Double.parseDouble(args[3]));
	}
}
