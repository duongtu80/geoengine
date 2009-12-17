package cn.geodata.models.wetland.actions.map;

import java.awt.Paint;
import java.awt.Stroke;

public class ChartModel {
	protected String title;
	protected String xAxis;
	protected String yAxis;
	protected String seriesTitle;
	protected Stroke stroke;
	protected Paint paint;
	
	public ChartModel(String title, String xAxis, String yAxis, String seriesTitle, Paint paint, Stroke stroke){
		this.title = title;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.seriesTitle = seriesTitle;
		this.paint = paint;
		this.stroke = stroke;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

	public Stroke getStroke() {
		return stroke;
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
