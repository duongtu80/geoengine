package cn.geodata.models.wps.client;

public abstract class WpsObject {
	private String service = "WPS";
	private String version = "0.4.0";
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
}
