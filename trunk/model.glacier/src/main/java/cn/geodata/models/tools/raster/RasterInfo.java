package cn.geodata.models.tools.raster;

import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.factory.Hints;
import org.geotools.gce.geotiff.GeoTiffReader;
import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.Envelope2D;

public class RasterInfo {
	private File file;
	private GridCoverage2D grid;
	private Envelope2D envelope;
	private RenderedImage image;
	private double cellSizeX;
	private double cellSizeY;
	private int nodata;
	private Raster rasterCache;
	private int lastTileX;
	private int lastTileY;
	
	public RasterInfo(File file, int nodata) throws IOException{
		this.file = file;
		
		this.grid = this.loadGeoTiff(this.file);
		this.envelope = this.grid.getEnvelope2D();
		this.image = this.grid.getRenderedImage();

		cellSizeX = envelope.getWidth() / image.getWidth();
		cellSizeY = envelope.getHeight() / image.getHeight();
		this.nodata = nodata;
	}
	
	protected GridCoverage2D loadGeoTiff(File f) throws IOException{
		GeoTiffReader _reader = new GeoTiffReader(f, new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE));
		return (GridCoverage2D) _reader.read(null);
	}
	
	public int getLocationValue(DirectPosition2D pt){
		return this.getLocationValue(pt.getX(), pt.getY());
	}

	public int getLocationValue(double x, double y){
		int _col = (int)Math.floor(((x - envelope.getMinX()) / cellSizeX));
		int _row = (int)Math.floor(((envelope.getMaxY() - y) / cellSizeY));
		
		if(_col < 0 || _col >= image.getWidth() || _row < 0 || _row >= image.getHeight()){
//			log.warning("Out of the image:" + _col + "," + _row);
			return this.nodata;
		}

		int _tileX = _col / image.getTileWidth();
		int _tileY = _row / image.getTileHeight();

		Raster _raster = null;
		if(this.rasterCache != null && this.lastTileX == _tileX && this.lastTileY == _tileY){
			_raster = this.rasterCache;
		}
		else{
			_raster = image.getTile(_tileX, _tileY);
			this.rasterCache = _raster;
			this.lastTileX = _tileX;
			this.lastTileY = _tileY;
		}
		
//		Raster _raster = image.getTile(_tileX, _tileY);
		return _raster.getSample(_col, _row, 0);
	}

	public File getFile() {
		return file;
	}

	public GridCoverage2D getGrid() {
		return grid;
	}

	public Envelope2D getEnvelope() {
		return envelope;
	}

	public RenderedImage getImage() {
		return image;
	}

	public double getCellSizeX() {
		return cellSizeX;
	}

	public double getCellSizeY() {
		return cellSizeY;
	}

	public int getNodata() {
		return nodata;
	}
}
