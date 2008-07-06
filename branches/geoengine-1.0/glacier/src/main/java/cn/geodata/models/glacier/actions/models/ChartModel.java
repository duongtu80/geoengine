package cn.geodata.models.glacier.actions.models;


public class ChartModel extends ProcessModel {
	protected ChartOutputter chart;
	protected String title;
	protected String xAxis;
	protected String yAxis;

	public ChartOutputter getChart() {
		return chart;
	}
	
	public void setChart(ChartOutputter chart) {
		this.chart = chart;
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
