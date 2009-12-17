package cn.geodata.models.ecoserv.models;

import java.util.Date;

import cn.geodata.models.ecoserv.landcover.LandCover;

public class DateStatus {
	private int id;
	private Date date;
	private LandCover landcover;
	private Integer[] cells;
	private double precipitation;
	private int precipitationState;
	private Simulation simulation;
	
	public DateStatus(int id, LandCover landcover, Integer[] cells,
			double precipitation, int precipitationState, Date date, Simulation simulation) {
		super();
		this.id = id;
		this.landcover = landcover;
		this.cells = cells;
		this.precipitation = precipitation;
		this.precipitationState = precipitationState;
		this.date = date;
		this.simulation = simulation;
	}

	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LandCover getLandcover() {
		return landcover;
	}

	public void setLandcover(LandCover landcover) {
		this.landcover = landcover;
	}

	public Integer[] getCells() {
		return cells;
	}

	public void setCells(Integer[] cells) {
		this.cells = cells;
	}

	public double getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(double precipitation) {
		this.precipitation = precipitation;
	}

	public int getPrecipitationState() {
		return precipitationState;
	}

	public void setPrecipitationState(int precipitationState) {
		this.precipitationState = precipitationState;
	}
}
