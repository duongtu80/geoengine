package cn.geodata.models.wetland;

import cn.geodata.models.raster.GeoRaster;

/**
 * Cell of raster
 * 
 * @author tank
 *
 */
public class RasterCell {
	private int row;
	private int col;
	private double x;
	private double y;
	private GeoRaster reader;
	
	public RasterCell(GeoRaster reader, int row, int col){
		this.reader = reader;
		this.row = row;
		this.col = col;
		
		y = this.reader.getEnvelope().getMaxY() - this.getReader().getCellSizeY() * this.row - this.getReader().getCellSizeY() / 2;
		x = this.reader.getEnvelope().getMinX() + this.getReader().getCellSizeX() * this.col + this.getReader().getCellSizeX() / 2;
	}

	public int getRow() {
		return row;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getCol() {
		return col;
	}

	public GeoRaster getReader() {
		return reader;
	}

	@Override
	public String toString() {
		return "[" + this.row + "," + this.col + "] = [" + x + "," + y + "]";
	}
}
