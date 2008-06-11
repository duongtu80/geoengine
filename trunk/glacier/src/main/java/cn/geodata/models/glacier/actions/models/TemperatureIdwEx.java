package cn.geodata.models.glacier.actions.models;


public class TemperatureIdwEx extends IdwChartPeriodModel {
	private double stand;
	private double grads;
	
	public void setStand(double stand) {
		this.stand = stand;
	}

	public void setGrads(double grads) {
		this.grads = grads;
	}

	public TemperatureIdwEx(){
		startYear = 1980;
		endYear = 1990;
		modelUrl = "http://127.0.0.1:59080/web/wps";
		modelId = "Glacier.TemperatureIdwEx";
		x = 110;
		y = 33;
		
		maxDistance = 0;
		maxCount = 0;
		pow = 2;
		
		title = "气温变化";
		xAxis = "月份";
		yAxis = "气温";
	}
	
	public String execute() throws Exception {
		this.inputs.put("Stand", this.stand);
		this.inputs.put("Grads", this.grads);
		
		return this.execute("温度 C");
	}
}
