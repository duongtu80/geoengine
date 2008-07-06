package cn.geodata.models.glacier;

public class BandInfo {
	private double bandAltitude;
	private long allCount;
	private long glacierCount;
	
	public double getBandAltitude() {
		return bandAltitude;
	}
	public void setBandAltitude(double bandAltitude) {
		this.bandAltitude = bandAltitude;
	}
	public long getAllCount() {
		return allCount;
	}
	public void setAllCount(long allCount) {
		this.allCount = allCount;
	}
	public long getGlacierCount() {
		return glacierCount;
	}
	public void setGlacierCount(long glacierCount) {
		this.glacierCount = glacierCount;
	}
	@Override
	public String toString() {
		return this.getBandAltitude() + "|" + this.getAllCount() + "," + this.getGlacierCount();
	}
}
