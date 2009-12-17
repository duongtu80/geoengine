package cn.geodata.models.wetland;

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
	private EnviRasterReader reader;
	
	public RasterCell(EnviRasterReader reader, int row, int col){
		this.reader = reader;
		this.row = row;
		this.col = col;
		
		y = this.reader.getEnvelope().getMaxY() - this.getReader().getCellSize() * this.row - this.getReader().getCellSize() / 2;
		x = this.reader.getEnvelope().getMinX() + this.getReader().getCellSize() * this.col + this.getReader().getCellSize() / 2;
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

	public EnviRasterReader getReader() {
		return reader;
	}

	@Override
	public String toString() {
		return "[" + this.row + "," + this.col + "] = [" + x + "," + y + "]";
	}
}
