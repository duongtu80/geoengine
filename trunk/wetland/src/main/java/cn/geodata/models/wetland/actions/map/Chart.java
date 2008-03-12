package cn.geodata.models.wetland.actions.map;

import cn.geodata.models.wetland.Catchment;


public class Chart {
	private String code;
	private String pt;
	private Catchment catchment;

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String execute() throws Exception {
		this.code = this.catchment.findCatchmentTag(pt);
		if(this.code == null){
			return "notfound";
		}
		
		return "success";
	}

	public Catchment getCatchment() {
		return catchment;
	}

	public void setCatchment(Catchment catchment) {
		this.catchment = catchment;
	}

}
