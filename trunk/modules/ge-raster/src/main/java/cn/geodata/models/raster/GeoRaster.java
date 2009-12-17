package cn.geodata.models.raster;

import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.GridCoverageFactory;
import org.geotools.factory.Hints;
import org.geotools.gce.geotiff.GeoTiffFormat;
import org.geotools.gce.geotiff.GeoTiffReader;
import org.geotools.gce.geotiff.GeoTiffWriteParams;
import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.Envelope2D;
import org.opengis.coverage.grid.GridCoverageWriter;

public class GeoRaster {
	private Logger log = Logger.getAnonymousLogger();
	
	private File file;
	private GridCoverage2D grid;
	private Envelope2D envelope;
	private RenderedImage image;
	private double cellSizeX;
	private double cellSizeY;
	private int bandNum;
	private int band;
	private int type;
	private int colNum;
	private int rowNum;
	private int tileWidth;
	private int tileHeight;
	private Number nodata;
	private Raster rasterCache;
	private int lastTileX;
	private int lastTileY;
	
	private Number[] buffer;
	private int startPos;
	private int bufferSize = 1024 * 60;
	
	public GeoRaster(File file, Envelope2D envelope, int colNum, int rowNum, int tileWidth, int tileHeight, int type, int bandNum, int band, String nodata) throws IOException {
		this.file = file;
		this.envelope = envelope;
		this.colNum = colNum;
		this.rowNum = rowNum;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.type = type;
		this.bandNum = bandNum;
		this.band = band;

		switch(this.type){
			case DataBuffer.TYPE_BYTE:
			case DataBuffer.TYPE_SHORT:
			case DataBuffer.TYPE_USHORT:
			case DataBuffer.TYPE_INT:
				this.nodata = Integer.parseInt(nodata);
				break;
			case DataBuffer.TYPE_FLOAT:
				this.nodata = Float.parseFloat(nodata);
				break;
			case DataBuffer.TYPE_DOUBLE:
				this.nodata = Double.parseDouble(nodata);
				break;
			default:
				throw new IOException("Unsupported data type: " + this.type);
		}

		cellSizeX = envelope.getWidth() / colNum;
		cellSizeY = envelope.getHeight() / rowNum;
	}
	
	public GeoRaster(File file, Envelope2D envelope, int colNum, int rowNum, int tileWidth, int tileHeight, int type, int bandNum, int band, Number nodata) {
		this.file = file;
		this.nodata = nodata;
		this.envelope = envelope;
		this.colNum = colNum;
		this.rowNum = rowNum;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.type = type;
		this.bandNum = bandNum;
		this.band = band;
		
		cellSizeX = envelope.getWidth() / colNum;
		cellSizeY = envelope.getHeight() / rowNum;
	}

	public GeoRaster(File file, Number nodata) throws IOException {
		this.file = file;
		this.nodata = nodata;
		
		this.loadImage();
		
		this.envelope = this.grid.getEnvelope2D();
		this.colNum = this.image.getWidth();
		this.rowNum = this.image.getHeight();
		this.tileWidth = this.image.getTileWidth();
		this.tileHeight = this.image.getTileHeight();
		this.type = this.image.getSampleModel().getDataType();
		this.bandNum = this.image.getSampleModel().getNumBands();
		this.band = 0;
		
		cellSizeX = envelope.getWidth() / colNum;
		cellSizeY = envelope.getHeight() / rowNum;
	}
	
	private void loadImage() throws IOException{
		this.grid = this.loadGeoTiff(this.file);
		this.image = this.grid.getRenderedImage();
		
		//Reload envelope
		this.envelope = this.grid.getEnvelope2D();
	}
	
	protected GridCoverage2D loadGeoTiff(File f) throws IOException{
		GeoTiffReader _reader = new GeoTiffReader(f, new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE));
		return (GridCoverage2D) _reader.read(null);
	}
	
	public Number getLocationValue(DirectPosition2D pt) throws IOException{
		return this.getLocationValue(pt.getX(), pt.getY());
	}

	public Number getLocationValue(double x, double y) throws IOException{
		int col =  (int)Math.floor(((x - envelope.getMinX()) / cellSizeX));
		int row = (int)Math.floor(((envelope.getMaxY() - y) / cellSizeY));
		
		return this.readCell(col, row);
	}
	
	private void initBufferAtLoc(int loc) throws IOException{
//		System.out.print("buffer...");
		
		int _end = loc + this.bufferSize;
		if(_end > this.colNum * this.rowNum){
			_end = this.colNum * this.rowNum;
		}
		
		int _len = _end - loc;
		this.buffer = new Number[_len];
		this.startPos = loc;
		
		for(int i=0;i< _len;i++){
//			System.out.println(i);
			int _row = (i + loc) / this.colNum;
			int _col = (i + loc) % this.colNum;
			
			this.buffer[i] = this.readCell(_col, _row);
		}
		
//		System.out.println(" " + this.buffer.length);
	}
	
	public Number getCell(int col, int row) throws IOException{
		if(col < 0 || col >= this.colNum || row < 0 || row >= this.rowNum){
			return this.nodata;
		}

		int _loc = col + row * this.colNum;
		if(this.buffer == null || _loc < this.startPos || _loc >= this.startPos + this.buffer.length){
			this.initBufferAtLoc(_loc);
		}
		
		return this.buffer[_loc - this.startPos];
	}

	private Number readCell(int col, int row) throws IOException{
		if(col < 0 || col >= this.colNum || row < 0 || row >= this.rowNum){
			return null;
		}

//		System.out.println(col + "|" + row);
		if(this.rasterCache == null || 
				col < this.rasterCache.getMinX() || col >= this.rasterCache.getMinX() + this.rasterCache.getWidth() ||
				row < this.rasterCache.getMinY() || row >= this.rasterCache.getMinY() + this.rasterCache.getHeight()
				){
//			System.out.println("Read tile");
			
			int _tileX = col / this.tileWidth;
			int _tileY = row / this.tileHeight;
			
			this.rasterCache = this.getImage().getTile(_tileX, _tileY);
			
			this.lastTileX = _tileX;
			this.lastTileY = _tileY;
		}			
		
		Number _val = null;
		switch(this.type){
			case DataBuffer.TYPE_BYTE:
			case DataBuffer.TYPE_SHORT:
			case DataBuffer.TYPE_USHORT:
			case DataBuffer.TYPE_INT:
				_val = this.rasterCache.getSample(col, row, this.band);
				break;
			case DataBuffer.TYPE_FLOAT:
				_val = this.rasterCache.getSampleFloat(col, row, this.band);
				break;
			case DataBuffer.TYPE_DOUBLE:
				_val = this.rasterCache.getSampleDouble(col, row, this.band);
				break;
			default:
				throw new IOException("Unsupported data type: " + this.type);
		}
		
		if(_val == null || _val.equals(this.nodata))
			return null;
		
		return _val;
	}
	
	public Raster getTile(int x, int y) throws IOException{
		Raster _raster = null;
		if(this.rasterCache != null && this.lastTileX == x && this.lastTileY == y){
			_raster = this.rasterCache;
		}
		else{
			_raster = this.getImage().getTile(x, y);
			
			this.rasterCache = _raster;
			this.lastTileX = x;
			this.lastTileY = y;
		}
		
		return _raster;
	}
	
	public Number getTile2(int col, int row) throws IOException{
		if(col < 0 || col >= this.colNum || row < 0 || row >= this.rowNum){
			return null;
		}

		if(this.rasterCache == null || 
				col < this.rasterCache.getMinX() || col >= this.rasterCache.getMinX() + this.rasterCache.getWidth() ||
				row < this.rasterCache.getMinY() || row >= this.rasterCache.getMinY() + this.rasterCache.getHeight()
				){
			int _tileX = col / this.tileWidth;
			int _tileY = row / this.tileHeight;
			
			Raster _raster = this.getImage().getTile(_tileX, _tileY);
				
			this.rasterCache = _raster;
			this.lastTileX = _tileX;
			this.lastTileY = _tileY;
		}
		
		Number _val = null;
		switch(this.type){
			case DataBuffer.TYPE_BYTE:
			case DataBuffer.TYPE_SHORT:
			case DataBuffer.TYPE_USHORT:
			case DataBuffer.TYPE_INT:
				_val = this.getTile(lastTileX, lastTileY).getSample(col, row, this.band);
				break;
			case DataBuffer.TYPE_FLOAT:
				_val = this.getTile(lastTileX, lastTileY).getSampleFloat(col, row, this.band);
				break;
			case DataBuffer.TYPE_DOUBLE:
				_val = this.getTile(lastTileX, lastTileY).getSampleDouble(col, row, this.band);
				break;
			default:
				throw new IOException("Unsupported data type: " + this.type);
		}
		
		if(_val == null || _val.equals(this.nodata))
			return null;
		
		return _val;
	}
	
	public void save(File outFile) throws IllegalArgumentException, IOException{
		GeoRaster.writeTiff(outFile, new GridCoverageFactory().create(outFile.getName(), this.getImage(), this.envelope));
	}

	public static void writeTiff(File outFile, GridCoverage2D grid) throws IllegalArgumentException, IOException{
		GeoTiffFormat _format = new GeoTiffFormat();
		
		GeoTiffWriteParams _wp = new GeoTiffWriteParams();
		_wp.setCompressionMode(GeoTiffWriteParams.MODE_EXPLICIT);
		_wp.setCompressionType("LZW");
		_wp.setCompressionQuality(0.75F);
		
		GridCoverageWriter _writer = _format.getWriter(outFile);
		_writer.write(grid, null);
	}
	
	public static void writeTiff(File outFile, Envelope2D env, WritableRaster grid) throws IllegalArgumentException, IOException{
		writeTiff(outFile, new GridCoverageFactory().create(outFile.getName(), grid, env));
	}
	
	public int getCol(double x){
		return (int)Math.floor(((x - envelope.getMinX()) / cellSizeX));
	}
	
	public int getRow(double y){
		return (int)Math.floor(((envelope.getMaxY() - y) / cellSizeY));
	}
	
	public int getColInExtent(double x){
		int _col = (int)Math.floor(((x - envelope.getMinX()) / cellSizeX));

		if(_col >= this.colNum)
			_col = this.colNum - 1;
		if(_col < 0)
			_col = 0;
		
		return _col;
	}
	
	public int getRowInExtent(double y){
		int _row = (int)Math.floor(((envelope.getMaxY() - y) / cellSizeY));
		
		if(_row >= this.rowNum)
			_row = this.rowNum - 1;
		if(_row < 0)
			_row = 0;
		
		return _row;
	}
	
	public double getX(int col){
		return this.envelope.getMinX() + this.cellSizeX * col + this.cellSizeX * 0.5;
	}
	
	public double getY(int row){
		return this.envelope.getMaxY() - this.cellSizeY * row - this.cellSizeY * 0.5;
	}

	public File getFile() {
		return file;
	}

	public GridCoverage2D getGrid() throws IOException {
		if(this.grid == null){
			this.loadImage();
		}
		return grid;
	}

	public Envelope2D getEnvelope() {
		return envelope;
	}

	public RenderedImage getImage() throws IOException {
		if(this.image == null){
			this.loadImage();
		}
		
		return image;
	}

	public double getCellSizeX() {
		return cellSizeX;
	}

	public double getCellSizeY() {
		return cellSizeY;
	}

	public Number getNodata() {
		return nodata;
	}
	
	public int getBandNum() {
		return bandNum;
	}

	public int getBand() {
		return band;
	}

	public int getType() {
		return type;
	}

	public int getColNum() {
		return colNum;
	}

	public int getRowNum() {
		return rowNum;
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public int getLastTileX() {
		return lastTileX;
	}

	public int getLastTileY() {
		return lastTileY;
	}

	public void setBand(int band) {
		this.band = band;
	}
}
