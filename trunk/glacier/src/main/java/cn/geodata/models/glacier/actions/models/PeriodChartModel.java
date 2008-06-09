package cn.geodata.models.glacier.actions.models;

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
}
