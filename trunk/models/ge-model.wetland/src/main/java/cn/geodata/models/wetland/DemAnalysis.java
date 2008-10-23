package cn.geodata.models.wetland;

import java.io.IOException;
import java.util.logging.Logger;

import org.geotools.geometry.Envelope2D;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPolygon;

public class DemAnalysis {
	private Logger log = Logger.getAnonymousLogger();
	private DemRaster raster;
	private float nodata;
	private GeometryFactory factory;
	
	public DemAnalysis(DemRaster raster, float nodata){
		this.raster = raster;
		if(this.raster == null){
			this.log.warning("No reader set to DEM Analysis");
		}
		this.factory = new GeometryFactory();
		this.nodata = nodata;
	}
	
	public DemAnalysis(DemRaster raster){
		this(raster, 0);
	}
	
	/**
	 * Calculate raster extent(row, col) from given envelope(lon, lat) 
	 * 
	 * @param env
	 * @return
	 */
	public Extent calculateExtent(Envelope env){
		Envelope _env2 = env;
		log.info("ENV:" + _env2.toString());
		
		Envelope2D _env = this.raster.getRaster().getEnvelope();
		
		Extent _extent = new Extent();
		_extent.setMinX(0);
		_extent.setMinY(0);
		_extent.setMaxX(this.raster.getRaster().getColCount());
		_extent.setMaxY(this.raster.getRaster().getRowCount());
		
		if(_env.getMinX() < _env2.getMinX()){
			_extent.setMinX((int) Math.floor((_env2.getMinX() - _env.getMinX()) / this.raster.getRaster().getCellSize()));
		}
		if(_env.getMaxX() > _env2.getMaxX()){
			_extent.setMaxX((int) Math.ceil((_env2.getMaxX() - _env.getMinX()) / this.raster.getRaster().getCellSize()));
		}
		if(_env.getMaxY() > _env2.getMaxY()){
			_extent.setMinY((int) Math.floor((_env.getMaxY() - _env2.getMaxY())/ this.raster.getRaster().getCellSize()));
		}
		if(_env.getMinY() < _env2.getMinY()){
			_extent.setMaxY((int) Math.floor((_env.getMaxY() - _env2.getMinY()) / this.raster.getRaster().getCellSize()));
		}
		
		return _extent;
	}
	
	/**
	 * If the cell locates on the border
	 * 
	 * @param col
	 * @param row
	 * @param polygon
	 * @param nodata
	 * @return
	 * @throws IOException
	 */
	public boolean isBoundary(int col, int row, MultiLineString border) throws IOException{
		double _maxDis = Math.hypot(this.raster.getRaster().getCellSize(), this.raster.getRaster().getCellSize()) / 2; 
		float _val = this.raster.getRaster().readFloat(row, col);
		
		if(_val != nodata){
			double _distance = border.distance(factory.createPoint(this.raster.getRaster().getLocation(row, col)));
			if(_distance <= _maxDis){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Calculate the lowest cell in the given catchment
	 * 
	 * @param polygon
	 * @param extent
	 * @return
	 * @throws IOException
	 */
	public RasterCell calcuateLowest4Catchment(MultiPolygon polygon, Extent extent) throws IOException {
		double _cellSize = this.raster.getRaster().getCellSize();
		
		RasterCell _cell = null;
		double _low = Double.MAX_VALUE;
		double _y = this.raster.getRaster().getEnvelope().getMaxY() - _cellSize * extent.getMinY() - _cellSize / 2;
		for(int _row = extent.getMinY();_row <= extent.getMaxY();_row++){
			double _x = this.raster.getRaster().getEnvelope().getMinX() + this.raster.getRaster().getCellSize() * extent.getMinX() + this.raster.getRaster().getCellSize() / 2;
			for(int _col=extent.getMinX(); _col <= extent.getMaxX(); _col++){
				float _val = this.raster.getRaster().readFloat(_row, _col);
				if(_val != nodata){
					double _distance = polygon.distance(factory.createPoint(new Coordinate(_x, _y)));
					if(_distance == 0 && _val < _low){
						_cell = new RasterCell(this.raster.getRaster(), _row, _col);
						_low = _val;
					}
				}
				_x += _cellSize;
			}
			_y -= _cellSize;
		}
		
		return _cell;
	}
	
	/**
	 * Calculate the lowest cell in the given boundary
	 * 
	 * @param border
	 * @param extent
	 * @return
	 * @throws IOException
	 */
	public RasterCell calculateLowest4Boundary(MultiLineString border, Extent extent) throws IOException {
		double _cellSize = this.raster.getRaster().getCellSize();
		
		RasterCell _cell = null;
		double _low = Double.MAX_VALUE;
		double _y = this.raster.getRaster().getEnvelope().getMaxY() - _cellSize * extent.getMinY() - _cellSize / 2;
		for(int _row = extent.getMinY();_row <= extent.getMaxY();_row++){
			double _x = this.raster.getRaster().getEnvelope().getMinX() + this.raster.getRaster().getCellSize() * extent.getMinX() + this.raster.getRaster().getCellSize() / 2;
			for(int _col=extent.getMinX(); _col <= extent.getMaxX(); _col++){
				if(this.isBoundary(_col, _row, border)){
					float _val = this.raster.getRaster().readFloat(_row, _col);
					if(_val < _low){
						_cell = new RasterCell(this.raster.getRaster(), _row, _col);
						_low = _val;
					}
				}
				_x += _cellSize;
			}
			_y -= _cellSize;
		}
		
		return _cell;		
	}
}
