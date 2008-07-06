package cn.geodata.models.glacier;

public class ObjectBand {
	private double level;
	private double temperature;
	private double precipitation;
	private double accumulation;
	private double runoff;
	private double balance;
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getLevel() {
		return level;
	}
	public void setLevel(double level) {
		this.level = level;
	}
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
	public double getAccumulation() {
		return accumulation;
	}
	public void setAccumulation(double accumulation) {
		this.accumulation = accumulation;
	}
	public double getRunoff() {
		return runoff;
	}
	public void setRunoff(double runoff) {
		this.runoff = runoff;
	}
}
