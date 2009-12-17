package cn.geodata.models.glacier;

import java.util.Date;
import java.util.List;

public class ObjectMonth {
	private double temperature;
	private double precipitation;
//	private double accumulation;
	private double runoff;
	private Date Date;
	private List<ObjectBand> bands;
	
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(double precipitation) {
		this.precipitation = precipitation;
	}
//	public double getAccumulation() {
//		return accumulation;
//	}
//	public void setAccumulation(double accumulation) {
//		this.accumulation = accumulation;
//	}
	public double getRunoff() {
		return runoff;
	}
	public void setRunoff(double runoff) {
		this.runoff = runoff;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public List<ObjectBand> getBands() {
		return bands;
	}
	public void setBands(List<ObjectBand> bands) {
		this.bands = bands;
	}
}
