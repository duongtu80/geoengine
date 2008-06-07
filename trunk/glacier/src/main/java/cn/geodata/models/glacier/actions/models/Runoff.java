package cn.geodata.models.glacier.actions.models;

public class Runoff extends PeriodChartModel {
	private String temperatureModelUrl; 
	private String precipitationModelUrl; 
	private String snowDdfModelUrl; 
	private String iceDdfModelUrl;
	private String glacierUrl;
	private String catchmentUrl;

	private double cellSize;
	private double rainCritical;
	private double snowCritical;
	
	public Runoff() {
		modelUrl = "http://127.0.0.1:59080/web/wps";
		modelId = "Glacier.Runoff";
		
		cellSize = 1 / 1200;
		rainCritical = 5;
		snowCritical = 0;
		
		temperatureModelUrl = "http://127.0.0.1:59080/web/wps#Glacier.TemperatureIdw";
		precipitationModelUrl = "http://127.0.0.1:59080/web/wps#Glacier.PrecipitationIdw"; 
		snowDdfModelUrl = "http://127.0.0.1:59080/web/wps#Glacier.SnowDdfIdw"; 
		iceDdfModelUrl = "http://127.0.0.1:59080/web/wps#Glacier.IceDdfIdw";
		glacierUrl = "http://127.0.0.1:48080/geoserver/wfs#glacier";
		catchmentUrl = "http://127.0.0.1:48080/geoserver/wfs#catchment";
	}

	public String execute() throws Exception {
//		private com.vividsolutions.jts.geom.MultiPolygon catchment;
//		private org.geotools.feature.FeatureCollection glacier;
		
		
		
		return "success";
	}
}
