package cn.geodata.models.glacier.actions.map;

public class Map {
	private String wmsMapUrl;
	private String wmsLayerName;
	
	public String execute() throws Exception{
		return "success";
	}

	public String getWmsMapUrl() {
		return wmsMapUrl;
	}

	public void setWmsMapUrl(String wmsMapUrl) {
		this.wmsMapUrl = wmsMapUrl;
	}

	public String getWmsLayerName() {
		return wmsLayerName;
	}

	public void setWmsLayerName(String wmsLayerName) {
		this.wmsLayerName = wmsLayerName;
	}
}
