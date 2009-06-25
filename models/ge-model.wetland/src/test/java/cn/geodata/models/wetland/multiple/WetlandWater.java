package cn.geodata.models.wetland.multiple;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import cn.geodata.models.wetland.WaterRegionCalc;

import com.vividsolutions.jts.geom.MultiPolygon;

public class WetlandWater implements WaterTable {
	private Logger log = Logger.getAnonymousLogger();
	
	private SpillPoint spillPoint;
	private Catchment catchment;
	//Water level
	protected double waterLevel;
	//Bottom elevation
	protected double bottomElevation;
	//Spill point
	
	public WetlandWater(Catchment catchment, SpillPoint spillPoint){
		this.spillPoint = spillPoint;
		this.catchment = catchment;
		this.bottomElevation = catchment.getBottomElevation();
		this.waterLevel = catchment.getBottomElevation();
	}
	
	/**
	 * If over flowing
	 * 
	 * @return
	 */
	public boolean isOverFlow(){
		return this.waterLevel  > this.spillPoint.getElevation();
	}
		
	public List<Catchment> getCatchments() {
		List<Catchment> _list = new ArrayList<Catchment>();
		_list.add(this.catchment);
		
		return _list;
	}
	
	/**
	 * Calculate ET for the catchment
	 * 
	 * @param albedo
	 * @param windSpeed
	 * @param et
	 * @param coefficient
	 * @param tday
	 * @param srad
	 * @param vpd
	 */
	public double calEt(double albedo,
			double windSpeed,
			double coefficient,
			double tday,
			double srad,
			double vpd
			){
		
		double _pressure = 101.3 * Math.pow((293 - 0.0065 * this.catchment.getBottomElevation()) / 293, 5.26);
		double _dedt = 4098 * 0.6108 * Math.exp(17.27 * tday / (tday + 237.3)) / Math.pow((tday + 237.3), 2);
//		double _g0 = 4.903e-9 * Math.pow(tday, 4);
		double _p_constant = 0.665 * 0.001 * _pressure;
		double _vpd = vpd * 0.001;
		
		double _et = (_dedt * srad * (1.0 - albedo) * 0.408 + _vpd * windSpeed * _p_constant * 900 / (tday + 273)) / (_dedt + _p_constant * (1 + 0.34 * windSpeed));
		
		return _et * coefficient;
	}
	
	/**
	 * Generate water in the catchment
	 * 
	 * @param precipitation
	 * @param saturationPrcp
	 */
	public void generateWater(double precipitation, double saturationPrcp, double et){
//		double _pore = 1;
//		
//		if(waterLevel < this.bottomElevation)
//			_pore = 0.3;
//		
//		double _waterLevel = 0;
//		if(precipitation > saturationPrcp){
//			_waterLevel = waterLevel + 0.01 * precipitation / _pore * this.getArea() - et * 0.001;
//		}
//		else{
//			_waterLevel = waterLevel + 0.01 * precipitation / _pore - et * 0.001;
//		}
//		
//		if(_waterLevel < this.bottomElevation){
//			_waterLevel = this.bottomElevation;
//		}
//		
//		waterLevel = _waterLevel; // / _pore;
		this.waterLevel += 0.2;
	}
	
	public MultiPolygon calculateWaterRegion() {
		WaterRegionCalc _model = new WaterRegionCalc();
		_model.setCatchment(this.getCatchmentRegion());
		_model.setReader(this.catchment.getDem());
		_model.setWaterLevel(waterLevel);
		
		MultiPolygon _water = null;
		try {
			_water = _model.calculate2();
		} catch (Exception e) {
			log.info("Failed to calculate water region: " + e.getMessage());
		}
		return _water;
	}

	public void addWaterVolume(double waterTable) {
		this.waterLevel += waterTable / this.getArea();
	}

	public double getArea() {
		return this.catchment.getArea();
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

	public SpillPoint getSpillPoint() {
		return this.spillPoint;
	}

	public double getWaterLevel() {
		return this.waterLevel;
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
		
		return this.catchment.toString() + "(" + this.waterLevel + ") -> " + _code + "(" + this.spillPoint.getElevation() + ")";  
	}

	public MultiPolygon getCatchmentRegion() {
		return this.catchment.getRegion();
	}
}
