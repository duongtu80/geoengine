package cn.geodata.models.wetland;

public class WetlandDemPixel implements Comparable<WetlandDemPixel> {
	private int row;
	private int col;
	private float val;
	private double lon;
	private double lat;
	private EnviRasterReader reader;
	private boolean border;
	private int rank;
	private int angle;
	
	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public boolean equals(Object arg0) {
		if (arg0 instanceof WetlandDemPixel) {
			WetlandDemPixel _obj = (WetlandDemPixel) arg0;
			if(_obj.getRow() == row && _obj.getCol() == col){
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return this.val + "(" + this.row + "," + this.col + ")";
	}

	public WetlandDemPixel(int row, int col, float val, double lon, double lat, boolean border){
		this.row = row;
		this.col = col;
		this.val = val;
		this.lon = lon;
		this.lat = lat;
		this.border = border;
		this.rank = 0;
		this.angle = -1;
	}
	
	public boolean isBorder() {
		return border;
	}
	public void setBorder(boolean border) {
		this.border = border;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public float getVal() {
		return val;
	}
	public void setVal(float val) {
		this.val = val;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public EnviRasterReader getReader() {
		return reader;
	}
	public void setReader(EnviRasterReader reader) {
		this.reader = reader;
	}

	public int compareTo(WetlandDemPixel o) {
		return (int) Math.signum(this.getRank() - o.getRank());
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
