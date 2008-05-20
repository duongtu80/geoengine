package cn.geodata.models.glacier.actions.models;


public class TemperatureIdw extends IdwChartPeriodModel {
	public TemperatureIdw(){
		startYear = 1980;
		endYear = 1990;
		modelUrl = "http://127.0.0.1:59080/web/wps";
		modelId = "Glacier.TemperatureIdw";
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
		return this.execute("温度 C");
	}
}
