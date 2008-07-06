package cn.geodata.models.glacier.actions.models;


public class IceDdfIdw extends IdwChartModel {
	public IceDdfIdw(){
		modelUrl = "http://127.0.0.1:59080/web/wps";
		modelId = "Glacier.IceDdfIdw";
		x = 110;
		y = 33;
		
		maxDistance = 0;
		maxCount = 0;
		pow = 2;
	}
	
	public String execute() throws Exception {
		return this.execute("冰度日因子");
	}
}
