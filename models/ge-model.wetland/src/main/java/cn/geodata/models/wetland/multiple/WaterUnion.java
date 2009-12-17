package cn.geodata.models.wetland.multiple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import cn.geodata.models.wetland.WaterRegionCalc;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

public class WaterUnion implements WaterTable {
	private Logger log = Logger.getAnonymousLogger();
	
	private List<WaterTable> waterTables;
	private double waterLevel;
	private SpillPoint spillPoint;
	private double bottomElevation;
	
	public WaterUnion(List<WaterTable> waterTables, double bottomElevation, SpillPoint spillPoint){
		this.waterLevel = 0;
		this.spillPoint = spillPoint;
		this.waterTables = waterTables;
		this.bottomElevation = bottomElevation;
		
		averageWaterLevel();
	}
	
	private void averageWaterLevel(){
		double _overFlowVol = 0;
		for(WaterTable _w: this.waterTables){
			_overFlowVol += _w.getOverflowVolume();
		}
		
		double _waterLevel = _overFlowVol / this.getArea() + this.bottomElevation;
		for(WaterTable _w: this.waterTables){
			_w.setWaterLevel(_waterLevel);
		}
		
		this.waterLevel = _waterLevel;
	}
	
	public List<Catchment> getCatchments(){
		List<Catchment> _list = new ArrayList<Catchment>();
		
		for(WaterTable _w : this.waterTables){
			if (_w instanceof WaterUnion) {
				WaterUnion _union = (WaterUnion) _w;
				_list.addAll(_union.getCatchments());
			}
			else{
				WetlandWater _water = (WetlandWater) _w;
				_list.addAll(_water.getCatchments());
			}
		}

		return _list;
	}
	
	public MultiPolygon calculateWaterRegion() {
		WaterRegionCalc _model = new WaterRegionCalc();
		_model.setCatchment(this.getCatchmentRegion());
		_model.setReader(this.getCatchments().get(0).getDem());
		_model.setWaterLevel(waterLevel);
		
		MultiPolygon _water = null;
		try {
			_water = _model.calculate2();
		} catch (Exception e) {
			log.info("Failed to calculate water region: " + e.getMessage());
		}
		return _water;
	}

	public void addWaterVolume(double volume) {
		this.waterLevel += volume / this.getArea();
		
		for(WaterTable _w : this.waterTables){
			_w.setWaterLevel(this.waterLevel);
//			_w.addWaterVolume(volume / _w.getArea());
		}
	}

	public double getArea() {
		double _area = 0;
		for(WaterTable _w : this.waterTables){
			_area += _w.getArea();
		}
		
		return _area;
	}

	public SpillPoint getSpillPoint() {
		return this.spillPoint;
	}

	public double getWaterLevel() {
		return this.waterLevel;
	}

	public double getCatchmentVolume() {
		if(this.waterLevel >= this.spillPoint.getElevation()){
			return 0;
		}
		
		return (this.spillPoint.getElevation() - this.waterLevel) * this.getArea();
	}

	public double getOverflowVolume() {
		if(this.waterLevel <= this.spillPoint.getElevation()){
			return 0;
		}
		
		return (this.waterLevel - this.spillPoint.getElevation()) * this.getArea();
	}

	public void setWaterLevel(double waterLevel) {
		this.waterLevel = waterLevel;
	}

	@Override
	public String toString() {
		String _code = "outflow";
		if(this.spillPoint.getCatchment() != null){
			_code = this.spillPoint.getCatchment().toString();
		}
		
		return Arrays.toString(this.getCatchments().toArray()) + "(" + this.waterLevel + ") -> " + _code + "(" + this.spillPoint.getElevation() + ")";  
	}

	public MultiPolygon getCatchmentRegion() {
		return this.combineCatchments(this.getCatchments());
	}

	/**
	 * Combine catchment regions into one multiple polygon
	 * 
	 * @param catchments
	 * @return
	 */
	private MultiPolygon combineCatchments(List<Catchment> catchments){
		MultiPolygon _polygon = null;
		for(Catchment _c : catchments){
			if(_polygon == null){
				_polygon = _c.getRegion();
			}
			else{
				Geometry _p = _polygon.union(_c.getRegion());
				if (_p instanceof MultiPolygon) {
					_polygon = (MultiPolygon) _p;
				}
				else if(_p instanceof Polygon){
					_polygon = (new GeometryFactory()).createMultiPolygon(new Polygon[] {(Polygon)_p});
				}
				else
					Logger.getAnonymousLogger().info("Unsupported geometry type");
			}
		}
		
		return _polygon;
	}
}
