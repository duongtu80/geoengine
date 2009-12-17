package cn.geodata.models.glacier.actions.models;


public class ChartModel {
	protected String title;
	protected String xAxis;
	protected String yAxis;
	protected String seriesTitle;
	
	public ChartModel(String title, String xAxis, String yAxis, String seriesTitle){
		this.title = title;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.seriesTitle = seriesTitle;
	}

	public String getSeriesTitle() {
		return seriesTitle;
	}

	public void setSeriesTitle(String seriesTitle) {
		this.seriesTitle = seriesTitle;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getXAxis() {
		return xAxis;
	}
	
	public void setXAxis(String axis) {
		xAxis = axis;
	}
	
	public String getYAxis() {
		return yAxis;
	}
	
	public void setYAxis(String axis) {
		yAxis = axis;
	}
}
