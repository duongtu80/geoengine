package cn.geodata.models.wetland;

public class WaterTableModel {
	private double waterLevel;
	private double catchmentArea;
	private double saturationPrcp;
	private DayMet dayMet;
	private ETModel etModel;
	private double spillPoint;
	
	public double calculate(){
		etModel.setDayMet(dayMet);

		double _pore = 1;
		if(waterLevel < 0)
			_pore = 0.3;
		
		double _waterLevel = 0;
		if(dayMet.getPrcp() > saturationPrcp){
			_waterLevel = waterLevel + 0.01 * dayMet.getPrcp() / _pore * catchmentArea - etModel.calculate() * 0.001;
		}
		else{
			_waterLevel = waterLevel + 0.01 * dayMet.getPrcp() / _pore - etModel.calculate() * 0.001;
		}
		
		if(_waterLevel > spillPoint)
			_waterLevel = spillPoint;
//		if(_waterLevel < 0)
//			_waterLevel = 0;
		
		waterLevel = _waterLevel; // / _pore;
		
		return _waterLevel;
	}

	public double getWaterLevel() {
		return waterLevel;
	}

	public void setWaterLevel(double waterLevel) {
		this.waterLevel = waterLevel;
	}

	public double getCatchmentArea() {
		return catchmentArea;
	}

	public void setCatchmentArea(double catchmentArea) {
		this.catchmentArea = catchmentArea;
	}

	public double getSaturationPrcp() {
		return saturationPrcp;
	}

	public void setSaturationPrcp(double saturationPrcp) {
		this.saturationPrcp = saturationPrcp;
	}

	public DayMet getDayMet() {
		return dayMet;
	}

	public void setDayMet(DayMet dayMet) {
		this.dayMet = dayMet;
	}

	public ETModel getEtModel() {
		return etModel;
	}

	public void setEtModel(ETModel etModel) {
		this.etModel = etModel;
	}

	public double getSpillPoint() {
		return spillPoint;
	}

	public void setSpillPoint(double spillPoint) {
		this.spillPoint = spillPoint;
	}

}
