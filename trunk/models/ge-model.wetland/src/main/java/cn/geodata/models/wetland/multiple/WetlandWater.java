package cn.geodata.models.wetland.multiple;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class WetlandWater extends BasicWaterTable {
	private static final long serialVersionUID = 7008421776546639356L;

	private Logger log = Logger.getAnonymousLogger();
	
	public WetlandWater(Catchment catchment, SpillPoint spillPoint) throws IOException{
		super(catchment.getZones(), spillPoint, Arrays.asList(catchment));
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
		
		double _pressure = 101.3 * Math.pow((293 - 0.0065 * this.bottomElevation) / 293, 5.26);
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
		double _pore = 1;
		
		if(waterLevel < this.bottomElevation)
			_pore = 0.3;

		double _waterLevel = 0;
		if(precipitation > saturationPrcp){
			_waterLevel = 0.01 * precipitation / _pore * (this.getArea() / 100000)  - et * 0.001;
		}
		else{
			_waterLevel = 0.01 * precipitation / _pore - et * 0.001;
		}
		
		this.waterLevel = waterLevel + _waterLevel;
	}	
}
