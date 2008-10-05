package cn.geodata.models.wetland;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

@GeoProcess(title="ET Model")
public class ETModel implements Calculate {
	private double albedo;
	private double height;
	private double windSpeed;
	private double et;
	private double coefficient;
	private double tday;
	private double srad;
	private double vpd;
	
	public void calculate(){
		double _pressure = 101.3 * Math.pow((293 - 0.0065 * this.height) / 293, 5.26);
		double _dedt = 4098 * 0.6108 * Math.exp(17.27 * tday / (tday + 237.3)) / Math.pow((tday + 237.3), 2);
//		double _g0 = 4.903e-9 * Math.pow(tday, 4);
		double _p_constant = 0.665 * 0.001 * _pressure;
		double _vpd = vpd * 0.001;
		
		double _et = (_dedt * srad * (1.0 - albedo) * 0.408 + _vpd * this.windSpeed * _p_constant * 900 / (tday + 273)) / (_dedt + _p_constant * (1 + 0.34 * windSpeed));
		
		this.et = _et * coefficient;
	}

	@GeoOutput(title="ET")
	public double getEt() {
		return et;
	}

	@GeoInput(title="Albedo")
	public void setAlbedo(double albedo) {
		this.albedo = albedo;
	}

	@GeoInput(title="Height")
	public void setHeight(double height) {
		this.height = height;
	}

	@GeoInput(title="Wind Speed")
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	@GeoInput(title="Coefficient")
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	@GeoInput(title="Daily Temperature")
	public void setTday(double tday) {
		this.tday = tday;
	}

	@GeoInput(title="Srad")
	public void setSrad(double srad) {
		this.srad = srad;
	}

	@GeoInput(title="Vpd")
	public void setVpd(double vpd) {
		this.vpd = vpd;
	}

	public int getPercent() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}
