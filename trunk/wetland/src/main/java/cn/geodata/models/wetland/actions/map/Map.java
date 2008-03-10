package cn.geodata.models.wetland.actions.map;

public class Map {
	private String wetlandLayers;
	private String wetlandWMS;
	
	public String getWetlandLayers() {
		return wetlandLayers;
	}

	public void setWetlandLayers(String wetlandLayers) {
		this.wetlandLayers = wetlandLayers;
	}

	public String getWetlandWMS() {
		return wetlandWMS;
	}

	public void setWetlandWMS(String wetlandWMS) {
		this.wetlandWMS = wetlandWMS;
	}

	public String execute(){
		return "success";
	}
}
