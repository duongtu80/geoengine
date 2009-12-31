package cn.geodata.models.wetland.multiple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import cn.geodata.models.raster.GeoRaster;
import cn.geodata.models.wetland.DemRaster;

public class HydrologicalModel {
	private Logger log = Logger.getAnonymousLogger();
	
	private List<Catchment> catchments;
	private List<WetlandWater> wetlands;
	private GeoRaster dem;
	
	public List<Catchment> getCatchments() {
		return catchments;
	}

	public List<WetlandWater> getWetlands() {
		return wetlands;
	}

	public void setWetlands(List<WetlandWater> wetlands) {
		this.wetlands = wetlands;
	}

	public GeoRaster getDem() {
		return dem;
	}

	public HydrologicalModel(GeoRaster dem, List<Catchment> catchments) throws IOException {
		this.catchments = catchments;
		this.dem = dem;
		this.wetlands = new ArrayList<WetlandWater>();
		
		for(Catchment _c : this.catchments){
			this.wetlands.add(new WetlandWater(_c, SpillPoint.calculateSpillPoint(dem, catchments, _c)));
		}
	}
	
	private void generateWaterCatchment(
			WetlandWater wetland,
			double albedo,
			double windSpeed,
			double coefficient,
			double tday,
			double srad,
			double vpd,
			double precipitation,
			double saturationPrcp
			){
		double _et = wetland.calEt(albedo, windSpeed, coefficient, tday, srad, vpd);
		wetland.generateWater(precipitation, saturationPrcp, _et);
	}
	
	public void calculateWaterTable(
			double albedo,
			double windSpeed,
			double coefficient,
			double tday,
			double srad,
			double vpd,
			double precipitation,
			double saturationPrcp
			) throws IOException{
		
		//Generate water
		for(WetlandWater _wetland : this.wetlands){
			this.generateWaterCatchment(_wetland, albedo, windSpeed, coefficient, tday, srad, vpd, precipitation, saturationPrcp);
		}
	}

	public List<WaterTable> calculateWaterFlow(
			) throws IOException{
		List<WaterTable> _waters = new ArrayList<WaterTable>();
		
		//Generate water
		for(WetlandWater _wetland : this.wetlands){
			_waters.add(_wetland);
		}
		
		while(this.waterFlow(_waters)){
			log.info("Recheck water flow...");
		}
		
		return _waters;
	}

	private WaterTable findWaterTable(List<WaterTable> waters, Catchment catchment){
		for(WaterTable _w : waters){
			if(_w.getCatchments().contains(catchment)){
				return _w;
			}
		}
		
		return null;
	}
	
	private boolean waterFlow(List<WaterTable> waters) throws IOException{
//		boolean _changed = false;
//		for(WaterTable _w : waters){
//			_changed |= this.waterFlow(waters, _w);
//		}
//		
//		return _changed;
		for(WaterTable _w : waters){
			if(this.waterFlow(waters, _w)){
				return true;
			}
		}
	
//		this.combineWaterTables(waters, _w);
		for(WaterTable _w : waters){
			if(this.combineWaterTables(waters, _w)){
				return true;
			}
		}

		return false;
	}

	private boolean waterFlow(List<WaterTable> waters, WaterTable water) throws IOException{
		double _overFlowVol = water.getOverflowVolume();
		if(_overFlowVol > 0){
			WaterTable _next = this.findWaterTable(waters, water.getSpillPoint().getCatchment());
			if(_next == null){
				log.info("No next catchment found for " + water);
				water.setWaterLevel(water.getSpillPoint().getElevation());
				
				return false;
			}
			else{
				if(_next.getWaterLevel() < water.getWaterLevel()){// water.getSpillPoint().getElevation()){
					log.info("Flowing " + water + " to " + _next);
					
					water.setWaterLevel(water.getSpillPoint().getElevation());
					//Water over flow
					_next.addWaterVolume(_overFlowVol);
					
					if(_next.getWaterLevel() < _next.getSpillPoint().getElevation()){
						return false;
					}
					else{
						if(water.getCatchments().contains(_next.getSpillPoint().getCatchment()) == false){
							return this.waterFlow(waters, _next);
						}
						else{
							return false;
						}
					}
//					this.waterFlow(waters, _next);
				}
				else{
					return false;
				}
			}
		}
		
		return false;
	}

	public boolean combineWaterTables(List<WaterTable> waters, WaterTable water) throws IOException{
		double _overFlowVol = water.getOverflowVolume();
		if(_overFlowVol > 0){
			WaterTable _next = this.findWaterTable(waters, water.getSpillPoint().getCatchment());
			if(_next != null && _next.getWaterLevel() >= water.getSpillPoint().getElevation()){
				//Create water union

				List<WaterTable> _subs = new ArrayList<WaterTable>();
				_subs.add(water);
				_subs.add(_next);
				
				List<Catchment> _cats = new ArrayList<Catchment>();
				_cats.addAll(water.getCatchments());
				_cats.addAll(_next.getCatchments());
				
				waters.remove(water);
				waters.remove(_next);

				WaterUnion _union = new WaterUnion(_subs, water.getSpillPoint().getElevation(), SpillPoint.calculateSpillPoint(dem, this.catchments, _cats));
				waters.add(_union);
				log.info("Combine water units " + _union);				
				
				this.combineWaterTables(waters, _union);

				return true;
			}
		}
		return false;
	}


}
