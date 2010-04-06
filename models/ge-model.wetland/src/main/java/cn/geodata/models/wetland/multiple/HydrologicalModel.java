package cn.geodata.models.wetland.multiple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

import com.google.common.collect.Lists;

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
			log.info("Calculate spill point for " + _c.getCode());
			this.wetlands.add(new WetlandWater(_c, SpillPoint.calculateSpillPoint(dem, catchments, _c)));
		}
	}
	
	private void generateWaterCatchment(
			WetlandWater wetland,
			double et,
			double precipitation,
			double saturationPrcp
			){
		wetland.generateWater(precipitation, saturationPrcp, et);
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

	public void calculateWaterTable(
			double et,
			double precipitation,
			double saturationPrcp
			) throws IOException{
		
		//Generate water
		for(WetlandWater _wetland : this.wetlands){
			this.generateWaterCatchment(_wetland, et, precipitation, saturationPrcp);
		}
	}

	/**
	 * @return
	 * @throws IOException
	 * 
	 * @Deprecated
	 * @see calculateWaterFlowEx
	 */
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
	
	/**
	 * Upgraded water flow calculation algorithem
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<WaterTable> calculateWaterFlowEx() throws IOException {
		List<WaterTable> _waters = new ArrayList<WaterTable>();

		// Generate water
		for (WetlandWater _wetland : this.wetlands) {
			_waters.add(_wetland);
		}

		this.waterFlow3(_waters);
		
		return _waters;
	}

	private void waterFlow2(List<WaterTable> waters) throws IOException {
		WaterTable _w = this.findOverflowWater(waters);
		while(_w != null){
			this.waterFlow2(waters, _w);
			_w = this.findOverflowWater(waters);
		}
	}
	
	private void waterFlow3(List<WaterTable> waters) throws IOException {
		WaterTable _water = this.findOverflowWater(waters);
		while(_water != null){
			Stack<WaterTable> _stack = new Stack<WaterTable>();
			_stack.push(_water);
			
			while(!_stack.empty()){
				WaterTable _w = _stack.pop();
				log.info("Process " + _w.toString());
				double _v = _w.getOverflowVolume();
				while(_v > 0){
					SpillPoint _sp = _w.getSpillPoint();
					if(_sp.getCatchment() == null){
						log.info("Out flow");
						
						_w.setWaterLevel(_sp.getElevation());
						_v = 0;
					}
					else{
						WaterTable _w2 = this.findWaterTable(waters, _sp.getCatchment());
						if(_w2.isOverFlow() && _w2.getSpillPoint().getElevation() < _sp.getElevation()){
							log.info("Pre-process neighbor catchment");
							
							_stack.push(_w);
							_stack.push(_w2);
							
							break;
						}

						if(_w2.getWaterLevel() >= _sp.getElevation()){
							log.info("Union");

							List<WaterTable> _subs = new ArrayList<WaterTable>();
							_subs.add(_w);
							_subs.add(_w2);
							
							List<Catchment> _cats = new ArrayList<Catchment>();
							_cats.addAll(_w.getCatchments());
							_cats.addAll(_w2.getCatchments());

							WaterUnion _union = new WaterUnion(_subs, SpillPoint.calculateSpillPoint(dem, this.catchments, _cats));
							waters.add(_union);
							
							log.info("Remove " + _w.toString());
							log.info("Remove " + _w2.toString());
							log.info("Add " + _union.toString());
							
							waters.remove(_w);
							waters.remove(_w2);
							
							_w = _union;
						}
						else{
							log.info("Flow");
							
							_w2.addWaterVolume(_v);
							_w.setWaterLevel(_sp.getElevation());
							
							_w = _w2;
						}
						_v = _w.getOverflowVolume();
					}
				}
			}
			
			_water = this.findOverflowWater(waters);
		}
	}
	
	private WaterTable findOverflowWater(List<WaterTable> waters){
		for(WaterTable _w : waters){
			if(_w.isOverFlow()){
				return _w;
			}
		}
		
		return null;
	}

	private void waterFlow2(List<WaterTable> waters, WaterTable water) throws IOException {
		log.info("Process " + water.toString());
		WaterTable _w = water;
		double _v = water.getOverflowVolume();
		while(_v > 0){
			SpillPoint _sp = _w.getSpillPoint();
			if(_sp.getCatchment() == null){
				log.info("Out flow");
				
				_w.setWaterLevel(_sp.getElevation());
				_v = 0;
			}
			else{
				WaterTable _w2 = this.findWaterTable(waters, _sp.getCatchment());
				if(_w2.getSpillPoint().getElevation() < _sp.getElevation()){
					log.info("Pre-process neighbor catchment");
					this.waterFlow2(waters, _w2);
				}

				if(_w2.getWaterLevel() >= _sp.getElevation()){
//				if(_w2.isFull()){
					log.info("Union");

					List<WaterTable> _subs = new ArrayList<WaterTable>();
					_subs.add(_w);
					_subs.add(_w2);
					
					List<Catchment> _cats = new ArrayList<Catchment>();
					_cats.addAll(_w.getCatchments());
					_cats.addAll(_w2.getCatchments());

					WaterUnion _union = new WaterUnion(_subs, SpillPoint.calculateSpillPoint(dem, this.catchments, _cats));
					waters.add(_union);
					
					log.info("Remove " + _w.toString());
					log.info("Remove " + _w2.toString());
					log.info("Add " + _union.toString());
					
					waters.remove(_w);
					waters.remove(_w2);
					
					_w = _union;
				}
				else{
					log.info("Flow");
					
					_w2.addWaterVolume(_v);
					_w.setWaterLevel(_sp.getElevation());
					
					_w = _w2;
				}
				_v = _w.getOverflowVolume();
			}
		}
	}
	
	private boolean waterFlow(List<WaterTable> waters) throws IOException{
//		boolean _changed = false;
//		for(WaterTable _w : waters){
//			_changed |= this.waterFlow(waters, _w);
//		}
//		
//		return _changed;
		for(WaterTable _w : (WaterTable[])waters.toArray(new WaterTable[0])){
			if(waters.contains(_w)){
				if(this.waterFlow(waters, _w)){
//					return true;
				}
			}
		}
	
//		this.combineWaterTables(waters, _w);
//		for(WaterTable _w : waters){
//			if(this.combineWaterTables(waters, _w)){
//				return true;
//			}
//		}

		return false;
	}

	private boolean waterFlow(List<WaterTable> waters, WaterTable water) throws IOException{
		if(water.isOverFlow()){
//			double _overFlowVol = water.getOverflowVolume();
			WaterTable _next = this.findWaterTable(waters, water.getSpillPoint().getCatchment());
			if(_next == null){
				log.info("No next catchment found for " + water);
				water.setWaterLevel(water.getSpillPoint().getElevation());
				
				return false;
			}
			else{
				if(_next.getWaterLevel() < water.getWaterLevel()){// water.getSpillPoint().getElevation()){
					log.info("Flowing " + water + " to " + _next);
					
					double _overFlowVol = water.getOverflowVolume();

					if(_next.getCatchmentVolume(water.getSpillPoint().getElevation()) >= _overFlowVol){
						//Water over flow
						water.setWaterLevel(water.getSpillPoint().getElevation());
						_next.addWaterVolume(_overFlowVol);
						
						return false;
					}
					else{
						WaterUnion _union = this.combineWaterTables(waters, water, _next);
						return this.waterFlow(waters, _union);
//						if(water.getCatchments().contains(_next.getSpillPoint().getCatchment()) == false){
//							
//						}
//						else{
//							return false;
//						}
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
	
	public WaterUnion combineWaterTables(List<WaterTable> waters, WaterTable water1, WaterTable water2) throws IOException{
		List<WaterTable> _subs = new ArrayList<WaterTable>();
		_subs.add(water1);
		_subs.add(water2);
		
		List<Catchment> _cats = new ArrayList<Catchment>();
		_cats.addAll(water1.getCatchments());
		_cats.addAll(water2.getCatchments());
		
		System.out.println(water1.getCatchmentVolume() + "," + water1.getOverflowVolume() + "," + water1.getWaterLevel() + "," + water1.getSpillPoint().getElevation());
		System.out.println(water2.getCatchmentVolume() + "," + water2.getOverflowVolume() + "," + water2.getWaterLevel() + "," + water2.getSpillPoint().getElevation());

		WaterUnion _union = new WaterUnion(_subs, SpillPoint.calculateSpillPoint(dem, this.catchments, _cats));
		
		if(water1.isOverFlow() == false || water2.isOverFlow() == false){
			System.out.println("----");
			System.out.println(water1.getCatchmentVolume() + "," + water1.getOverflowVolume() + "," + water1.getWaterLevel() + "," + water1.getSpillPoint().getElevation());
			System.out.println(water2.getCatchmentVolume() + "," + water2.getOverflowVolume() + "," + water2.getWaterLevel() + "," + water2.getSpillPoint().getElevation());
		
			throw new IOException("Wrong water union");
		}
		
		log.info("Combine water units " + _union);				

		waters.remove(water1);
		waters.remove(water2);

		waters.add(_union);
		
		return _union;
	}


//	public boolean combineWaterTables(List<WaterTable> waters, WaterTable water) throws IOException{
//		double _overFlowVol = water.getOverflowVolume();
//		if(_overFlowVol > 0){
//			WaterTable _next = this.findWaterTable(waters, water.getSpillPoint().getCatchment());
//			if(_next != null && _next.getWaterLevel() >= water.getSpillPoint().getElevation()){
//				//Create water union
// 
//				List<WaterTable> _subs = new ArrayList<WaterTable>();
//				_subs.add(water);
//				_subs.add(_next);
//				
//				List<Catchment> _cats = new ArrayList<Catchment>();
//				_cats.addAll(water.getCatchments());
//				_cats.addAll(_next.getCatchments());
//				
//				waters.remove(water);
//				waters.remove(_next);
//
//				WaterUnion _union = new WaterUnion(_subs, water.getSpillPoint().getElevation(), SpillPoint.calculateSpillPoint(dem, this.catchments, _cats));
//				waters.add(_union);
//				log.info("Combine water units " + _union);				
//				
//				this.combineWaterTables(waters, _union);
//
//				return true;
//			}
//		}
//		return false;
//	}

}
