package cn.geodata.models.landfire;

import java.util.Arrays;

import junit.framework.TestCase;

public class TestPoint extends TestCase {
	private double[] resolutions = new double[] {
	        1.40625, 
	        0.703125, 
	        0.3515625, 
	        0.17578125, 
	        0.087890625, 
	        0.0439453125,
	        0.02197265625, 
	        0.010986328125, 
	        0.0054931640625, 
	        0.00274658203125,
	        0.001373291015625, 
	        0.0006866455078125, 
	        0.00034332275390625, 
	        0.000171661376953125, 
	        0.0000858306884765625, 
	        0.00004291534423828125
	    };

	
	public void testTest1() throws Exception {
		System.out.println(Arrays.toString(this.LatLongToPixelXY(36.11354072045737,-115.13779163360595, 16)));
	}
	
	public void testTest2() throws Exception {
		System.out.println(Arrays.toString(this.locateTile(36.11354072045737,-115.13779163360595, 0)));
	}
	
	private double minX = -180;
	private double maxX = 180;
	private double minY = -90;
	private double maxY = 90;
	
	public int[] locateTile(double latitude, double longitude, int level){
		double _x = (longitude - minX) / this.resolutions[level];
		double _y = (latitude - minY) / this.resolutions[level];
		
		int _cellX = (int) Math.floor(_x);
		int _cellY = (int) Math.floor(_y);
		System.out.println(_cellX + "," + _cellY);
		
		return new int[] {_cellX, _cellY};
	}
	
	public int[] LatLongToPixelXY(double latitude, double longitude,
			int levelOfDetail) {

		int retInt[] = { 0, 0 };
		latitude = Clip(latitude, MinLatitude, MaxLatitude);
		longitude = Clip(longitude, MinLongitude, MaxLongitude);
		
		double x = (longitude + 180) / 360;
		double sinLatitude = Math.sin(latitude * Math.PI / 180);
		double y = 0.5 - Math.log((1 + sinLatitude) / (1 - sinLatitude)) /
		(4 * Math.PI);
		
		int mapSize = MapSize(levelOfDetail);
		
		retInt[0] = (int) Clip(x * mapSize + 0.5, 0, mapSize - 1);
		retInt[1] = (int) Clip(y * mapSize + 0.5, 0, mapSize - 1);

		return retInt;
	}

	public int[] PixelXYToTileXY(int pixelX, int pixelY) {
		int retInt[] = { 0, 0 };
		retInt[0] = pixelX / 256;
		retInt[1] = pixelY / 256;
		return retInt;
	}

	private double MinLatitude = -85.05112878;
	private double MaxLatitude = 85.05112878;
	private double MinLongitude = -180;
	private double MaxLongitude = 180;

	private double Clip(double n, double minValue, double maxValue) {
		return Math.min(Math.max(n, minValue), maxValue);
	}

	private int MapSize(int levelOfDetail) {
		return (int) 256 << levelOfDetail;
	}
}
