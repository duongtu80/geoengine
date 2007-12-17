package cn.geodata.models.landfire;

import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.factory.Hints;
import org.geotools.gce.geotiff.GeoTiffReader;
import org.geotools.geometry.Envelope2D;

import com.vividsolutions.jts.geom.Point;

public class DatasetDNBR {
	private static Logger log = Logger.getAnonymousLogger();
	
	public double getAtLocation(String id, Point pt) throws IOException{
		GridCoverage2D _grid = this.findFireRegionDataset(id);
		
		Envelope2D _extent = _grid.getEnvelope2D();
		RenderedImage _image = _grid.getRenderedImage();

		double _cellSizeX = _extent.getWidth() / _image.getWidth();
		double _cellSizeY = _extent.getHeight() / _image.getHeight();

		log.info("CellSize:" + _cellSizeX + "," + _cellSizeY);
		
		int _tileSizeX = _image.getTileWidth();
		int _tileSizeY = _image.getTileHeight();
		
		log.info("TileSize:" + _tileSizeX + "," + _tileSizeY);
		
		int _col = (int)Math.floor(((pt.getX() - _extent.getMinX()) / _cellSizeX));
		int _row = (int)Math.floor(((_extent.getMaxY() - pt.getY()) / _cellSizeY));
		
		if(_col < 0 || _col >= _image.getWidth() || _row < 0 || _row >= _image.getHeight()){
			log.warning("Out of the image:" + _col + "," + _row);
			return Double.NaN;
		}
		
		return this.evaluateValue(_image, _col, _row);
	}
	
	protected double evaluateValue(RenderedImage image, int col, int row) {
		int _minC = col - 2;
		int _maxC = col + 2;
		
		if(_minC < 0){
			_minC = 0;
		}
		if(_maxC > image.getWidth() - 1){
			_maxC = image.getWidth() - 1;
		}
		
		int _minR = row - 2;
		int _maxR = row + 2;
		
		if(_minR < 0){
			_minR = 0;
		}
		if(_maxR > image.getHeight() - 1){
			_maxR = image.getHeight() - 1;
		}
		
		int _total = 0;
		int _count = 0;
		for(int _row=_minR;_row <= _maxR;_row++){
			for(int _col=_minC;_col <=_maxC;_col++){
				int _val = this.getCellValue(image, _col, _row);
				if(_val >= 0){
					_total += _val;
					_count ++;
				}
			}
		}
		
		if(_count == 0){
			log.warning("Not found avalible cell");
			return Double.NaN;
		}
		return (double)_total / (double)_count;
	}

	protected int getCellValue(RenderedImage image, int col, int row) {
		int _tileX = col / image.getTileWidth();
		int _tileY = row / image.getTileHeight();
		
		Raster _raster = image.getTile(_tileX, _tileY);
		return _raster.getSample(col, row, 0);
	}

	public GridCoverage2D findFireRegionDataset(String id) throws IOException{
		File _file = new File(Configure.getFireRepository(), id + "\\" + id + "_d.tif");
		
		if(_file.exists() == false){
			throw new FileNotFoundException(_file.getAbsolutePath());
		}
		
		GeoTiffReader _reader = new GeoTiffReader(_file, new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE));
		return (GridCoverage2D) _reader.read(null);
	}
}
