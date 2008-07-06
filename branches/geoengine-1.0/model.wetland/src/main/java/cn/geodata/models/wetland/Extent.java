package cn.geodata.models.wetland;

public class Extent {
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;
	
	public int getMinX() {
		return minX;
	}
	public void setMinX(int minX) {
		this.minX = minX;
	}
	public int getMinY() {
		return minY;
	}
	public void setMinY(int minY) {
		this.minY = minY;
	}
	public int getMaxX() {
		return maxX;
	}
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	public int getMaxY() {
		return maxY;
	}
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	@Override
	public String toString() {
		return minX + "," + maxX + ";" + minY + "," + maxY;
	}
}
