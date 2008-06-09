package cn.geodata.models.glacier.actions.models;


public class SnowDdfIdw extends IdwChartModel {
	public SnowDdfIdw(){
		modelUrl = "http://127.0.0.1:59080/web/wps";
		modelId = "Glacier.SnowDdfIdw";
		x = 110;
		y = 33;
		
		maxDistance = 0;
		maxCount = 0;
		pow = 2;
	}
	
	public String execute() throws Exception {
		return this.execute("雪度日因子");
	}
}
