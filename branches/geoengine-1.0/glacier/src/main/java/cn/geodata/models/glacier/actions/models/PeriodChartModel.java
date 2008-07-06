package cn.geodata.models.glacier.actions.models;

import java.util.Date;

public class PeriodChartModel extends ChartModel {
	protected int startYear;
	protected int endYear;

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	
	public Date getStartDate(){
		return new Date(this.startYear - 1900, 8, 1);
	}
	
	public Date getEndDate(){
		return new Date(this.endYear - 1900, 8, 1);
	}
}
