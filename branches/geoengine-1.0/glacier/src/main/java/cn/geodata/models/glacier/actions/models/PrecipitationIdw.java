package cn.geodata.models.glacier.actions.models;


public class PrecipitationIdw extends IdwChartPeriodModel{
	public PrecipitationIdw(){
		startYear = 1980;
		endYear = 1990;
		modelUrl = "http://127.0.0.1:59080/web/wps";
		modelId = "Glacier.PrecipitationIdw";
		x = 110;
		y = 33;
		
		maxDistance = 0;
		maxCount = 0;
		pow = 2;
		
		title = "降水变化";
		xAxis = "月份";
		yAxis = "降水";
	}
	
	public String execute() throws Exception {
		return this.execute("降水 mm");
	}
}
