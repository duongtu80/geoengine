package cn.geodata.models.raster;

import java.awt.Color;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;
import javax.media.jai.RasterFactory;

import org.geotools.coverage.Category;
import org.geotools.coverage.GridSampleDimension;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.GridCoverageFactory;
import org.geotools.factory.Hints;
import org.geotools.gce.geotiff.GeoTiffFormat;
import org.geotools.gce.geotiff.GeoTiffReader;
import org.geotools.gce.geotiff.GeoTiffWriteParams;
import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.Envelope2D;
import org.geotools.resources.i18n.Vocabulary;
import org.geotools.resources.i18n.VocabularyKeys;
import org.geotools.util.NumberRange;
import org.opengis.coverage.grid.GridCoverageWriter;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.vividsolutions.jts.geom.Envelope;

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

	public GeoRaster(File file) throws IOException {
		this.file = file;
		this.loadImage(file, null);
		
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

	public GeoRaster(File file, Number nodata) throws IOException {
		this.file = file;
		this.loadImage(file, null);
		this.nodata = nodata;
		
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

	public GeoRaster(GridCoverage2D raster, Number nodata) throws IOException {
		this.file = null;
		this.nodata = nodata;
		this.loadImage(raster);
		
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

	public GeoRaster(WritableRaster raster, Envelope2D env, Number nodata) throws IOException {
		this(GeoRaster.createGrid(raster, env), nodata);
	}

	private void loadImage(File file, CoordinateReferenceSystem crs) throws IOException{
		this.grid = this.loadGeoTiff(file, crs);
		this.image = this.grid.getRenderedImage();
		
		//Reload envelope
		this.envelope = this.grid.getEnvelope2D();
	}

	private void loadImage(GridCoverage2D raster) throws IOException{
		this.grid = raster;
		this.image = this.grid.getRenderedImage();
		
		//Reload envelope
		this.envelope = this.grid.getEnvelope2D();
	}

	protected GridCoverage2D loadGeoTiff(File f, CoordinateReferenceSystem crs) throws IOException{
		Hints _hints = new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE);
		if(crs != null)
			_hints.put(Hints.DEFAULT_COORDINATE_REFERENCE_SYSTEM, crs);
		
		GeoTiffReader _reader = new GeoTiffReader(f, _hints);
		try{
			if(_reader.getMetadata().hasNoData()){
				this.nodata = _reader.getMetadata().getNoData();
				if(this.type == DataBuffer.TYPE_BYTE)
					this.nodata = this.nodata.byteValue();
				else if(this.type == DataBuffer.TYPE_INT)
					this.nodata = this.nodata.intValue();
				else if(this.type == DataBuffer.TYPE_USHORT)
					this.nodata = this.nodata.shortValue();
				else if(this.type == DataBuffer.TYPE_FLOAT)
					this.nodata = this.nodata.floatValue();
				else if(this.type == DataBuffer.TYPE_DOUBLE)
					this.nodata = this.nodata.doubleValue();
			}
			
			return (GridCoverage2D) _reader.read(null);
		}
		finally{
			log.info("Dispose raster stream " + f.getAbsolutePath());
			_reader.dispose();
		}
	}
	
	public Number getLocationValue(DirectPosition2D pt) throws IOException{
		return this.getLocationValue(pt.getX(), pt.getY(), this.band);
	}

	public Number getLocationValue(DirectPosition2D pt, int band) throws IOException{
		return this.getLocationValue(pt.getX(), pt.getY(), band);
	}

	public Number getLocationValue(double x, double y) throws IOException{
		return this.getLocationValue(x, y, this.band);
	}

	public Number getLocationValue(double x, double y, int band) throws IOException{
		int col =  (int)Math.floor(((x - envelope.getMinX()) / cellSizeX));
		int row = (int)Math.floor(((envelope.getMaxY() - y) / cellSizeY));
		
		return this.readCell(col, row, band);
	}

	/**
	 * Create writable raster that has same parameters to the current one
	 * 
	 * @return
	 */
	public WritableRaster cloneRaster(){
		return cloneRaster(this.type);
	}

	/**
	 * Create writable raster that has same parameters to the current one except the data type
	 * 
	 * @param type data type for the new raster
	 * @return
	 */
	public WritableRaster cloneRaster(int type){
		return RasterFactory.createBandedRaster(type, this.colNum, this.rowNum, this.bandNum, null);
	}

	private void initBufferAtLoc(int loc) throws IOException{
		int _end = loc + this.bufferSize;
		if(_end > this.colNum * this.rowNum * this.bandNum){
			_end = this.colNum * this.rowNum * this.bandNum;
		}
		
		int _len = _end - loc;
		_len = _len - (_len % this.bandNum);
		
		this.buffer = new Number[_len];
		this.startPos = loc;
		
		for(int i=0;i< _len;i+= this.bandNum){
			int _loc = (i + loc) / this.bandNum;
			int _row =  _loc / this.colNum;
			int _col = _loc % this.colNum;
			
			for(int _b=0;_b<this.bandNum;_b++){
				this.buffer[i+_b] = this.readCell(_col, _row, _b);
			}
		}
	}
	
	public Number getCell(int col, int row) throws IOException{
		return this.getCell(col, row, this.band);
	}

	public Number getCell(int col, int row, int band) throws IOException{
		if(col < 0 || col >= this.colNum || row < 0 || row >= this.rowNum){
			return null;
		}

		int _loc = (col + row * this.colNum) * this.bandNum;
		if(this.buffer == null || _loc < this.startPos || (_loc + this.bandNum) >= this.startPos + this.buffer.length){
			this.initBufferAtLoc(_loc);
		}
		
		return this.buffer[_loc - this.startPos + band];
	}

	private Number readCell(int col, int row, int band) throws IOException{
		if(col < 0 || col >= this.colNum || row < 0 || row >= this.rowNum){
			return null;
		}

		if(this.rasterCache == null || 
				col < this.rasterCache.getMinX() || col >= this.rasterCache.getMinX() + this.rasterCache.getWidth() ||
				row < this.rasterCache.getMinY() || row >= this.rasterCache.getMinY() + this.rasterCache.getHeight()
				){
			
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
				_val = this.rasterCache.getSample(col, row, band);
				break;
			case DataBuffer.TYPE_FLOAT:
				_val = this.rasterCache.getSampleFloat(col, row, band);
				break;
			case DataBuffer.TYPE_DOUBLE:
				_val = this.rasterCache.getSampleDouble(col, row, band);
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
	
	/**
	 * Write current raster to a GeoTIFF file
	 * 
	 * @param outFile
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	public void save(File outFile) throws IllegalArgumentException, IOException{
//		GeoRaster.writeTiff(outFile, new GridCoverageFactory().create(outFile.getName(), this.getImage(), this.envelope));
		GeoRaster.writeTiff(outFile, this.getGrid());
		
		if(this.file == null)
			this.file = outFile;
	}

	/**
	 * Write GridCoverage2D object to a GeoTIFF file
	 * 
	 * @param outFile
	 * @param grid
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	public static void writeTiff(File outFile, GridCoverage2D grid) throws IllegalArgumentException, IOException{
		GeoTiffFormat _format = new GeoTiffFormat();
		
//		GeoTiffWriteParams _wp = new GeoTiffWriteParams();
//		 _wp.setCompressionMode(GeoTiffWriteParams.MODE_EXPLICIT);
//		 _wp.setCompressionType("LZW");
//		 _wp.setCompressionQuality(0.75F);
		
		GridCoverageWriter _writer = _format.getWriter(outFile);
		_writer.write(grid, null);
	}
	
	public static GridCoverage2D createGrid(WritableRaster raster,
			Envelope2D env) throws IOException {
		ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
		ComponentColorModel cm = RasterFactory.createComponentColorModel(
				raster.getDataBuffer().getDataType(), // dataType
				cs, // color space
				false, // has alpha
				true, // is alphaPremultiplied
				Transparency.TRANSLUCENT); // transparency

		BufferedImage bimage = new BufferedImage(cm, raster, false, null);
		
//		Number nodata = new Byte((byte)0);
//		Category _nodata = null;
//		if(nodata != null){
//			if (nodata instanceof Integer) {
//				_nodata = new Category(Vocabulary.format(VocabularyKeys.NODATA), new Color(0,0,0,0), nodata.intValue());
//			}
//			else if (nodata instanceof Byte) {
//				_nodata = new Category(Vocabulary.format(VocabularyKeys.NODATA), new Color(0,0,0,0), nodata.byteValue());
//			}
//			else if (nodata instanceof Float) {
//				_nodata = new Category(Vocabulary.format(VocabularyKeys.NODATA), new Color(0,0,0,0), nodata.floatValue());
//			}
//			else if (nodata instanceof Long) {
//				_nodata = new Category(Vocabulary.format(VocabularyKeys.NODATA), new Color(0,0,0,0), nodata.longValue());
//			}
//			else if (nodata instanceof Double) {
//				_nodata = new Category(Vocabulary.format(VocabularyKeys.NODATA), new Color(0,0,0,0), nodata.doubleValue());
//			}
//			else{
//				throw new IOException("Unknown nodata value type " + nodata);
//			}
//		}
//		
//		Category _values = null;
//		switch (raster.getDataBuffer().getDataType()) {
//		case DataBuffer.TYPE_BYTE:
//			_values = new Category("values", 
//	                new Color[] {Color.BLUE}, 
//	                new NumberRange((byte)1, (byte)100),
//	                new NumberRange((byte)1, (byte)100)); 
//			break;
//		default:
//			break;
//		}
//		
//		List<Category> _cates = new ArrayList<Category>();
//		_cates.add(_values);
//		_cates.add(_nodata);
//		
//		GridSampleDimension[] _dms = new GridSampleDimension[] {new GridSampleDimension("raster", _cates.toArray(new Category[0]), null)};
		GridSampleDimension[] _dms = null;
		
		return new GridCoverageFactory().create("image", bimage, env, _dms, null, null);
	}
	
	/**
	 * Create writable raster
	 * 
	 * @param dataType
	 * @param col
	 * @param row
	 * @param band
	 * @return
	 */
	public static WritableRaster createWritableRaster(int dataType, int col, int row, int band){
		return RasterFactory.createBandedRaster(dataType, col, row, band, null);
	}

	/**
	 * Write a WritableRaster object to a GeoTIFF file
	 * 
	 * @param outFile
	 * @param env
	 * @param grid
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	public static void writeTiff(File outFile, Envelope2D env, WritableRaster grid) throws IllegalArgumentException, IOException{
		writeTiff(outFile, createGrid(grid, env));
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
			if(this.file != null)
				this.loadImage(this.file, null);
			else
				throw new IOException("No source raster");
		}
		
		return grid;
	}

	public Envelope2D getEnvelope() {
		return envelope;
	}

	public RenderedImage getImage() throws IOException {
		if(this.image == null){
			if(this.file != null)
				this.loadImage(this.file, null);
			else
				throw new IOException("No source raster");
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
