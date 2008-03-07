package cn.geodata.models.wetland;

public class ETModel {
	private DayMet dayMet;
	private double albedo;
	private double height;
	private double windSpeed;
	private double et;
	
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getEt() {
		return et;
	}

	public void setEt(double et) {
		this.et = et;
	}

	public double calculate(){
		double _pressure = 101.3 * Math.pow((293 - 0.0065 * this.height) / 293, 5.26);
		double _dedt = 4098 * 0.6108 * Math.exp(17.27 * this.dayMet.getTday() / (this.dayMet.getTday() + 237.3)) / Math.pow((this.dayMet.getTday() + 237.3), 2);
//		double _g0 = 4.903e-9 * Math.pow(this.dayMet.getTday(), 4);
		double _p_constant = 0.665 * 0.001 * _pressure;
		double _vpd = this.dayMet.getVpd() * 0.001;
		
		double _et = (_dedt * dayMet.getSrad() * (1.0 - albedo) * 0.408 + _vpd * this.windSpeed * _p_constant * 900 / (dayMet.getTday() + 273)) / (_dedt + _p_constant * (1 + 0.34 * windSpeed));
		
		this.et = _et;
		return this.et;
	}

	public DayMet getDayMet() {
		return dayMet;
	}

	public void setDayMet(DayMet dayMet) {
		this.dayMet = dayMet;
	}

	public double getAlbedo() {
		return albedo;
	}

	public void setAlbedo(double albedo) {
		this.albedo = albedo;
	}
}
