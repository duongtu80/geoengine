package cn.geodata.models.glacier.actions.models;

public class Runoff {
	private String temperatureModelUrl; 
	private String precipitationModelUrl; 
	private String snowDdfModelUrl; 
	private String iceDdfModelUrl;
	private com.vividsolutions.jts.geom.MultiPolygon catchment;
	private org.geotools.feature.FeatureCollection glacier;
	private long startDate;
	private long endDate;
	private double cellSize;
	private double rainCritical;
	private double snowCritical;
	public void setTemperatureModelUrl(String temperatureModelUrl) {
		this.temperatureModelUrl = temperatureModelUrl;
	}
	public void setPrecipitationModelUrl(String precipitationModelUrl) {
		this.precipitationModelUrl = precipitationModelUrl;
	}
	public void setSnowDdfModelUrl(String snowDdfModelUrl) {
		this.snowDdfModelUrl = snowDdfModelUrl;
	}
	public void setIceDdfModelUrl(String iceDdfModelUrl) {
		this.iceDdfModelUrl = iceDdfModelUrl;
	}
	public void setCatchment(com.vividsolutions.jts.geom.MultiPolygon catchment) {
		this.catchment = catchment;
	}
	public void setGlacier(org.geotools.feature.FeatureCollection glacier) {
		this.glacier = glacier;
	}
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}
	public void setCellSize(double cellSize) {
		this.cellSize = cellSize;
	}
	public void setRainCritical(double rainCritical) {
		this.rainCritical = rainCritical;
	}
	public void setSnowCritical(double snowCritical) {
		this.snowCritical = snowCritical;
	}
	
	public String execute() throws Exception {
		
		
		
		
		return "success";
	}
}
