package cn.geodata.models.ecoserv.simulate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.SchemaException;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import cn.geodata.models.ecoserv.landcover.ConnectionPool;
import cn.geodata.models.ecoserv.utils.DayMet;
import cn.geodata.models.raster.GeoRaster;
import cn.geodata.models.wetland.multiple.Catchment;
import cn.geodata.models.wetland.multiple.HydrologicalModel;
import cn.geodata.models.wetland.multiple.WaterTable;
import cn.geodata.models.wetland.multiple.WetlandWater;

import com.vividsolutions.jts.geom.MultiPolygon;

public class MultipleWaterSurfaceModel {
	private Logger log = Logger.getAnonymousLogger();
	private GeoRaster dem;
	
	public MultipleWaterSurfaceModel(GeoRaster dem) {
		super();
		
		this.dem = dem;
	}

	/**
	 *  Initializes each catchment using same water table. Only for test
	 * 
	 * @param waterTable
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public FeatureCollection<SimpleFeatureType, SimpleFeature> calculate(double waterTable) throws Exception {
		List<Catchment> _cats = Catchment.loadCatchments(dem, ConnectionPool.getPGDataStore().getFeatureSource("catchment").getFeatures());
		HydrologicalModel _model = new HydrologicalModel(dem, _cats);
		
		//Initialize the wetland catchments
		for(WetlandWater _w : _model.getWetlands()){
			String _code = "outflow";
			Catchment _c = _w.getSpillPoint().getCatchment();
			if(_c != null){
				_code = _c.getCode();
			}
			
//			_w.setWaterLevel(_w.getSpillPoint().getElevation() + waterTable);
			_w.setWaterLevel(548 + waterTable);
		}

		//Calcaulate water table for each catchment after adjust the water volume
		List<WaterTable> _waters = null;
		_waters = _model.calculateWaterFlow();
		
		return this.writeWaters(_waters);
	}
	
	/**
	 * Initializes each catchment using give water tables
	 * 
	 * @param watertables
	 * @return
	 * @throws Exception
	 */
	public FeatureCollection<SimpleFeatureType, SimpleFeature> calculate(Map<String, Double> watertables) throws Exception {
		List<Catchment> _cats = Catchment.loadCatchments(dem, ConnectionPool.getPGDataStore().getFeatureSource("catchment").getFeatures());
		HydrologicalModel _model = new HydrologicalModel(dem, _cats);
		
		//Initialize the wetland catchments
		for(WetlandWater _w : _model.getWetlands()){
			String _code = "outflow";
			Catchment _c = _w.getSpillPoint().getCatchment();
			if(_c != null){
				_code = _c.getCode();
				_w.setWaterLevel(_w.getBottomElevation());
			}

			if(watertables.containsKey(_code)){
				log.info("Set " + _code + " water table " + watertables.get(_code));
				_w.setWaterLevel(watertables.get(_code));
			}
		}

		//Calcaulate water table for each catchment after adjust the water volume
		List<WaterTable> _waters = null;
		_waters = _model.calculateWaterFlow();
		
		return this.writeWaters(_waters);
	}

	
	private FeatureCollection<SimpleFeatureType, SimpleFeature> writeWaters(List<WaterTable> waters) throws Exception {
		SimpleFeatureType _ft = this.createFeatureType("water");
		FeatureCollection<SimpleFeatureType, SimpleFeature> _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		
		for(WaterTable _w : waters){
			_fs.add(SimpleFeatureBuilder.build(_ft, new Object[] {_w.calculateWaterRegion(), _w.getWaterLevel(), _w.toString()}, null));
		}
		
		return _fs;
	}
	
	private SimpleFeatureType createFeatureType(String name) throws FactoryRegistryException, SchemaException{
		SimpleFeatureTypeBuilder _builder = new SimpleFeatureTypeBuilder();
		
		_builder.setName(name);
		
		_builder.add("shape", MultiPolygon.class);
		_builder.add("height", Double.class);
		_builder.add("codes", String.class);
		_builder.length(50);
		
		return _builder.buildFeatureType();
	}

	public List<DateObject<Map<String,Double>>> calculateWaterTable(Date startDate, Date endDate, ArrayList<DayMet> climate) throws IOException, ParseException {
		List<Catchment> _cats = Catchment.loadCatchments(dem, ConnectionPool.getPGDataStore().getFeatureSource("catchment").getFeatures());
		HydrologicalModel _model = new HydrologicalModel(dem, _cats);

		//Initialize the wetland catchments
		for(WetlandWater _w : _model.getWetlands()){
			_w.setWaterLevel(_w.getBottomElevation());
		}

		List<DateObject<Map<String, Double>>> _waters = new ArrayList<DateObject<Map<String, Double>>>();
		for(int i=0;i<climate.size();i++){
			DayMet _day = climate.get(i);
			if(_day.getDate().getYear() < startDate.getYear() || _day.getDate().getYear() > endDate.getYear()){
				continue;
			}
			log.info("  Water table calculation:" + _day.getDate().toString());
			
			_model.calculateWaterTable(0.08, 1, 1.2, _day.getTday(), _day.getSrad(), _day.getVpd(), _day.getPrcp(), 0.003);
			
			Map<String, Double> _wets = new java.util.HashMap<String, Double>();
			for(WetlandWater _w : _model.getWetlands()){
				_wets.put(_w.getCatchments().get(0).getCode(), (double)_w.getWaterLevel());
			}
			
			_waters.add(new DateObject<Map<String,Double>>(_day.getDate(), _wets));
		}
		
		return _waters;
	}

}
