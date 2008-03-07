package cn.geodata.models.wetland;

public class WaterTableModel {
	private double waterLevel;
	private double catchmentArea;
	private double saturationPrcp;
	private DayMet dayMet;
	private ETModel etModel;
	
	public double calculate(){
		etModel.setDayMet(dayMet);
		
		double _waterLevel = 0;
		if(dayMet.getPrcp() > saturationPrcp){
			_waterLevel = waterLevel + 0.01 * dayMet.getPrcp() * catchmentArea - etModel.calculate() * 0.01;
		}
		else{
			_waterLevel = waterLevel + 0.01 * dayMet.getPrcp() - etModel.calculate() * 0.001;
		}
		
		if(_waterLevel < 0)
			_waterLevel = 0;
		
		waterLevel = _waterLevel;
		
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

}
