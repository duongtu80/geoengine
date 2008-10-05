package cn.geodata.models.wetland;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

@GeoProcess(title="Water Table Model")
public class WaterTableModel implements Calculate {
	private double waterLevel;
	private double catchmentArea;
	private double saturationPrcp;
	private double precipitation;
	private double et;
	private double spillPoint;
	
	public void calculate(){
		double _pore = 1;
		if(waterLevel < 0)
			_pore = 0.3;
		
		double _waterLevel = 0;
		if(precipitation > saturationPrcp){
			_waterLevel = waterLevel + 0.01 * precipitation / _pore * catchmentArea - et * 0.001;
		}
		else{
			_waterLevel = waterLevel + 0.01 * precipitation / _pore - et * 0.001;
		}
		
		if(_waterLevel > spillPoint)
			_waterLevel = spillPoint;
//		if(_waterLevel < 0)
//			_waterLevel = 0;
		
		waterLevel = _waterLevel; // / _pore;
	}

	@GeoOutput(title="Water Level")
	public double getWaterLevel() {
		return waterLevel;
	}

	@GeoInput(title="Water Level")
	public void setWaterLevel(double waterLevel) {
		this.waterLevel = waterLevel;
	}

	@GeoInput(title="Catchment Area")
	public void setCatchmentArea(double catchmentArea) {
		this.catchmentArea = catchmentArea;
	}

	@GeoInput(title="Saturation Prcp")
	public void setSaturationPrcp(double saturationPrcp) {
		this.saturationPrcp = saturationPrcp;
	}

	@GeoInput(title="Spill Point")
	public void setSpillPoint(double spillPoint) {
		this.spillPoint = spillPoint;
	}

	@GeoInput(title="Precipitation")
	public void setPrecipitation(double precipitation) {
		this.precipitation = precipitation;
	}

	@GeoInput(title="ET")
	public void setEt(double et) {
		this.et = et;
	}

	public int getPercent() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}
