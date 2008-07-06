package cn.geodata.models.tools.raster;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import org.geotools.geometry.Envelope2D;

public class RasterGrid {
	private static Logger log = Logger.getAnonymousLogger();
	
	private Envelope2D envelope;
	private int row;
	private int col;
	private short[][] data;
	
	public RasterGrid(String id, Envelope2D envelope, int row, int col){
		this.envelope = envelope;
		this.row = row;
		this.col = col;
		
		this.data = new short[this.row][this.col];
	}

	public Envelope2D getEnvelope() {
		return envelope;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public short[][] getData() {
		return data;
	}
	
	public void setValue(int row, int col, short value){
		this.data[row][col] = value;
	}
	
	public short getValue(int row, int col){
		return this.data[row][col];
	}
	
	public void outputEnvi(File output) throws IOException{
		FileOutputStream _stream = new FileOutputStream(output);
		DataOutputStream _cache = new DataOutputStream(_stream);
		for(int _row = 0; _row < this.row ;_row++){
			for(int _col =0;_col < this.col; _col++){
				_cache.writeShort(this.data[_row][_col]);
			}
		}
		
		_cache.flush();
		_cache.close();
		_stream.flush();
		_stream.close();
	}
}
