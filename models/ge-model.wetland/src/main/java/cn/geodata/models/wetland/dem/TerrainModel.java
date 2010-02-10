package cn.geodata.models.wetland.dem;

import java.awt.Point;
import java.awt.image.DataBuffer;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Logger;

import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.geometry.Envelope;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import cn.geodata.models.raster.GeoRaster;

public class TerrainModel {
	private Number nodata;
	private Logger log = Logger.getAnonymousLogger();
	
	public TerrainModel(){
		this.nodata = new Float(-9999.0f);
	}
	
	/**
	 * Calculate slope from DEM
	 * 
	 * @param dem
	 * @return
	 * @throws Exception
	 */
	public GeoRaster slope(GeoRaster dem) throws Exception{
		this.log.entering(this.getClass().getCanonicalName(), "Calculate slope");

		WritableRaster _r = dem.cloneRaster(DataBuffer.TYPE_FLOAT);
		Envelope _env = this.pixelEnvelope(dem);

		double _cellX = _env.getSpan(0)/ dem.getColNum();
		double _cellY = _env.getSpan(1)/ dem.getRowNum();
		
		for (int _row = 0; _row < _r.getHeight(); _row++) {
			for (int _col = 0; _col < _r.getWidth(); _col++) {
				_r.setSample(_col, _row, 0, this.pixelSlope(dem, _col, _row, _cellX, _cellY)); 
			}
		}

		return new GeoRaster(_r, dem.getEnvelope(), this.nodata);
	}
	
	/**
	 * Calculate aspect from DEM
	 * 
	 * @param dem
	 * @return
	 * @throws Exception
	 */
	public GeoRaster aspect(GeoRaster dem) throws Exception {
		this.log.entering(this.getClass().getCanonicalName(), "Calculate aspect");

		WritableRaster _r = dem.cloneRaster(DataBuffer.TYPE_FLOAT);
		
		Envelope _env = this.pixelEnvelope(dem);

		double _cellX = _env.getSpan(0)/ dem.getColNum();
		double _cellY = _env.getSpan(1)/ dem.getRowNum();
		
		for (int _row = 0; _row < _r.getHeight(); _row++) {
			for (int _col = 0; _col < _r.getWidth(); _col++) {
				_r.setSample(_col, _row, 0, this.pixelAspect(dem, _col, _row, _cellX, _cellY)); 
			}
		}

		return new GeoRaster(_r, dem.getEnvelope(), this.nodata);
	}
	
	/**
	 * Calculate flow accumulation from flow direction
	 * 
	 * @param flowDir Flow direction
	 * @return
	 * @throws Exception
	 */
	public GeoRaster flowAccumulation(GeoRaster flowDir) throws Exception {
		this.log.entering(this.getClass().getCanonicalName(), "Calculate accumulation");

		WritableRaster _r = flowDir.cloneRaster(DataBuffer.TYPE_FLOAT);
		Map<Integer, List<Integer>> _list = new HashMap<Integer, List<Integer>>();
		int[] _list2 = new int[_r.getHeight() * _r.getWidth()];

		for (int _row = 0; _row < _r.getHeight(); _row++) {
			for (int _col = 0; _col < _r.getWidth(); _col++) {
				List<Integer> _val = this.pixelFlowAccumMultiple(flowDir, _col, _row);
				if(_val != null){
					if(_val.size() > 0){
						_list.put(_row * _r.getWidth() + _col, _val);
					}
					
					_list2[_row * _r.getWidth() + _col] = _val.size();
					_r.setSample(_col, _row, 0, _val.size()); 
				}
				else{
					_list2[_row * _r.getWidth() + _col] = -1;
					_r.setSample(_col, _row, 0, this.nodata.floatValue());
				}
			}
		}
		
		for(int i=0;i<_list2.length;i++){
			if(_list2[i] > 0){
				Stack<Integer> _stack = new Stack<Integer>();
				_stack.push(i);
				
				Stack<Integer> _wait = new Stack<Integer>();
				while(! _stack.empty()){
	//				System.out.println("  " + _stack.size() + "\t" + _wait.size());
					Integer _v = _stack.pop();
					_list2[_v] = -1;
					
					_wait.push(_v);
					for(Integer _l : _list.get(_v)){
						if(_list2[_l] > 0){
							_stack.push(_l);
						}
					}
				}
				
				while(! _wait.empty()){
					Integer _v = _wait.pop();
					
					int row = _v / _r.getWidth();
					int col = _v % _r.getWidth();
					
					float _count = _r.getSample(col, row, 0);
					
					for(Integer _l : _list.get(_v)){
						int _row = _l / _r.getWidth();
						int _col = _l % _r.getWidth();
						
						float _val = _r.getSample(_col, _row, 0);
						if(_val > 0){
							_count += _val;
						}
					}
					
					_r.setSample(col, row, 0, _count);
				}
			}
		}
		
		return new GeoRaster(_r, flowDir.getEnvelope(), this.nodata.floatValue());
	}
	
	
	
	
	/**
	 * Calculate aspect from DEM, use flowDirectionMultiple instead
	 * 
	 * @param dem
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public GeoRaster flowDirection(GeoRaster dem) throws Exception {
		this.log.entering(this.getClass().getCanonicalName(), "Calculate flow direction");
		WritableRaster _r = dem.cloneRaster(DataBuffer.TYPE_BYTE);
		
		for (int _row = 0; _row < _r.getHeight(); _row++) {
			for (int _col = 0; _col < _r.getWidth(); _col++) {
				_r.setSample(_col, _row, 0, this.pixelFlowDir(dem, _col, _row)); 
			}
		}

		return new GeoRaster(_r, dem.getEnvelope(), new Integer(-1));
	}

	public GeoRaster flowDirectionMultiple(GeoRaster dem) throws Exception {
		this.log.entering(this.getClass().getCanonicalName(), "Calculate flow direction");
		WritableRaster _r = dem.cloneRaster(DataBuffer.TYPE_BYTE);
		
		for (int _row = 0; _row < _r.getHeight(); _row++) {
			for (int _col = 0; _col < _r.getWidth(); _col++) {
				_r.setSample(_col, _row, 0, this.pixelFlowDirMultiple(dem, _col, _row)); 
			}
		}

		return new GeoRaster(_r, dem.getEnvelope(), new Integer(0));
	}

	/**
	 * Calculate aspect at the location
	 * 
	 * @param raster
	 * @param col
	 * @param row
	 * @param cellX
	 * @param cellY
	 * @return
	 * @throws IOException
	 */
	protected double pixelAspect(GeoRaster raster, int col, int row, double cellX, double cellY)
			throws IOException {
		
		double[] _ls = new double[9];
		int _pos = 0;
		for (int _row = row - 1; _row <= row + 1; _row++) {
			for (int _col = col - 1; _col <= col + 1; _col++) {
				Number _ele = raster.getCell(_col, _row);
				if (_ele == null) {
					return nodata.doubleValue();
				}
				
				_ls[_pos++] = _ele.doubleValue();
			}
		}
		
		Number _val = raster.getCell(col, row);
		if(_val == null){
			return nodata.doubleValue();
		}
		
		double _xd = ((_ls[2] + 2 * _ls[5] + _ls[8]) - (_ls[0] + 2* _ls[3] + _ls[6])) / (8 * cellX);
		double _yd = ((_ls[6] + 2 * _ls[7] + _ls[8]) - (_ls[0] + 2* _ls[1] + _ls[2])) / (8 * cellY);
		
		return this.aspectDirection(-1 * _xd, -1 * _yd);
	}
	
	/**
	 * Calculate flow direction at the location
	 * 
	 * @param raster
	 * @param col
	 * @param row
	 * @param cellX
	 * @param cellY
	 * @return
	 * @throws IOException
	 */
	protected List<Integer> pixelFlowAccum(GeoRaster raster, int col, int row) throws IOException {
		Number _val = raster.getCell(col, row);
		if(_val == null){
			return null;
		}

		List<Integer> _pixels = new ArrayList<Integer>();
		Point _pt = new Point(col, row);
		for (int _row = row - 1; _row <= row + 1; _row++) {
			for (int _col = col - 1; _col <= col + 1; _col++) {
				if(_col != col || _row != row){
					Number _ele = raster.getCell(_col, _row);
					if (_ele != null) {
						if(this.direction(new Point(_col, _row), _pt) == _ele.intValue())
							_pixels.add(_row * raster.getColNum() + _col);
					}
				}
			}
		}
		
		return _pixels;
	}
	
	protected List<Integer> pixelFlowAccumMultiple(GeoRaster raster, int col, int row) throws IOException {
		Number _val = raster.getCell(col, row);
		if(_val == null){
			return null;
		}

		List<Integer> _pixels = new ArrayList<Integer>();
		Point _pt = new Point(col, row);
		for (int _row = row - 1; _row <= row + 1; _row++) {
			for (int _col = col - 1; _col <= col + 1; _col++) {
				if(_col != col || _row != row){
					Number _ele = raster.getCell(_col, _row);
					if (_ele != null) {
						int _dir = _ele.intValue();
						if((this.direction(new Point(_col, _row), _pt) & _dir) == _dir)
							_pixels.add(_row * raster.getColNum() + _col);
					}
				}
			}
		}
		
		return _pixels;
	}
	
	/**
	 * Calculate flow direction at the location
	 * 
	 * @param raster
	 * @param col
	 * @param row
	 * @param cellX
	 * @param cellY
	 * @return
	 * @throws IOException
	 */
	protected int pixelFlowAccum(GeoRaster flowDir, WritableRaster raster, List<Long> cache, int col, int row) throws IOException {
		cache.remove(new Long(row * raster.getWidth() + col));
		
		int _val = raster.getSample(col, row, 0);
		if(_val <= 1)
			return _val;

		Point _pt = new Point(col, row);
		int _count = _val;
		
		for (int _row = row - 1; _row <= row + 1; _row++) {
			for (int _col = col - 1; _col <= col + 1; _col++) {
				if(_col >= 0 && _row >= 0 && _col < raster.getWidth() && _row < raster.getHeight() && (_col != col || _row != row)){
					int _ele = raster.getSample(_col, _row, 0);
					if(_ele > 0 && this.direction(new Point(_col, _row), _pt) == flowDir.getCell(_col, _row).intValue()){
						if(_ele == 1){
							_count += 1;
						}
						else if(_ele > 1){
							_count += this.pixelFlowAccum(flowDir, raster, cache, _col, _row);
						}
					}
				}
			}
		}
		raster.setSample(col, row, 0, _count);
		
		return _count;
	}


	/**
	 * Calculate flow direction at the location
	 * 
	 * @param raster
	 * @param col
	 * @param row
	 * @param cellX
	 * @param cellY
	 * @return
	 * @throws IOException
	 */
	protected int pixelFlowDir(GeoRaster raster, int col, int row) throws IOException {
		Number _val = raster.getCell(col, row);
		if(_val == null){
			return -1;
		}
		

		Point _pt = null;
		double _max_drop = 0;
		for (int _row = row - 1; _row <= row + 1; _row++) {
			for (int _col = col - 1; _col <= col + 1; _col++) {
				Number _ele = raster.getCell(_col, _row);
				if (_ele == null) {
					return -1;
				}
				
				if(_col != col || _row != row){
					double _drop = (_val.doubleValue() - _ele.doubleValue()) / (Math.hypot(_row - row, _col - col));
					
					if(_pt == null || _drop > _max_drop){
						_pt = new Point(_col, _row);
						_max_drop = _drop;
					}
				}
			}
		}
		
		return direction(new Point(col, row), _pt);
	}
	
	/**
	 * Calculate flow direction from DEM with support to multiple directions
	 * 
	 * @param raster
	 * @param col
	 * @param row
	 * @return
	 * @throws IOException
	 */
	protected int pixelFlowDirMultiple(GeoRaster raster, int col, int row) throws IOException {
		Number _val = raster.getCell(col, row);
		if(_val == null){
			return 0;
		}
		

		List<Point> _pts = new ArrayList<Point>();
		double _max_drop = 0;
		for (int _row = row - 1; _row <= row + 1; _row++) {
			for (int _col = col - 1; _col <= col + 1; _col++) {
				Number _ele = raster.getCell(_col, _row);
				if (_ele == null) {
					return 0;
				}
				
				if(_col != col || _row != row){
					double _drop = (_val.doubleValue() - _ele.doubleValue()) / (Math.hypot(_row - row, _col - col));
					
					if(_drop > _max_drop){
						_pts = new ArrayList<Point>();
					}
					
					if(_pts.size() == 0 || _drop >= _max_drop){
						_pts.add(new Point(_col, _row));
						_max_drop = _drop;
					}
				}
			}
		}
		
		int _dir = 0;
		for(Point _pt : _pts){
			_dir += direction(new Point(col, row), _pt);
		}
		
		return _dir;
	}
	
	public int direction(Point from, Point to){
		int _d = -1;
		if(from.y == to.y){
			if(from.x < to.x)
				_d = 0;
			else if(from.x == to.x)
				_d = -1;
			else
				_d = 4;
		}
		else if(from.y < to.y){
			if(from.x < to.x)
				_d = 1;
			else if(from.x == to.x)
				_d = 2;
			else
				_d = 3;
		}
		else{
			if(from.x < to.x)
				_d = 7;
			else if(from.x == to.x)
				_d = 6;
			else
				_d = 5;
		}
		
		if(_d < -1)
			return 0;
		
		return (int)Math.pow(2, _d);
	}

	/**
	 * Determine the aspect direction at pixel
	 * 
	 * @param xd
	 * @param yd
	 * @return
	 */
	public double aspectDirection(double xd, double yd){
		if(xd == 0 && yd == 0) return -1;
		
		if(xd == 0){
			if(yd < 0)	return 0;
			else return 180;
		}
		
		if(yd == 0){
			if(xd > 0)	return 90;
			else return 270;
		}
		
		double _d = Math.toDegrees(Math.atan(yd / xd));
		if(xd > 0){
			return _d + 90;
		}
		else{
			return _d + 270;
		}
	}

	@Deprecated
	public Point locateNeighbor(GeoRaster raster, int col, int row)
			throws IOException {
		Point _pt = null;
		for (int _row = row - 1; _row <= row + 1; _row++) {
			for (int _col = col - 1; _col <= col + 1; _col++) {
				Number _ele = raster.getCell(_col, _row);
				if (_ele != null) {
					if (_pt == null
							|| Math.abs(raster.getCell(_pt.x, _pt.y)
									.doubleValue()
									- raster.getCell(col, row).doubleValue()) < Math
									.abs(_ele.doubleValue()
											- raster.getCell(col, row)
													.doubleValue())) {
						_pt = new Point(_col, _row);
					}
				}
			}
		}

		return _pt;
	}
	
	/**
	 * Generate extent of the raster under UTM-14 projection
	 * 
	 * @param raster
	 * @return
	 * @throws Exception
	 */
	public org.opengis.geometry.Envelope pixelEnvelope(GeoRaster raster) throws Exception {
		CoordinateReferenceSystem _crs = raster.getEnvelope().getCoordinateReferenceSystem();
		if(_crs == null || !(_crs instanceof DefaultGeographicCRS))
			return raster.getEnvelope();
		else
			return CRS.transform(CRS.findMathTransform(raster.getEnvelope().getCoordinateReferenceSystem(), CRS.decode("EPSG:32614", true)), raster.getEnvelope());
	}

	/**
	 * Calculate slope at the location
	 * 
	 * @param raster
	 * @param col
	 * @param row
	 * @param cellX
	 * @param cellY
	 * @return
	 * @throws IOException
	 */
	protected double pixelSlope(GeoRaster raster, int col, int row, double cellX, double cellY)
			throws IOException {
		
		double[] _ls = new double[9];
		int _pos = 0;
		for (int _row = row - 1; _row <= row + 1; _row++) {
			for (int _col = col - 1; _col <= col + 1; _col++) {
				Number _ele = raster.getCell(_col, _row);
				if (_ele == null) {
					return nodata.doubleValue();
				}
				
				_ls[_pos++] = _ele.doubleValue();
			}
		}
		
		Number _val = raster.getCell(col, row);
		if(_val == null){
			return nodata.doubleValue();
		}
		
		double _xd = ((_ls[2] + 2 * _ls[5] + _ls[8]) - (_ls[0] + 2* _ls[3] + _ls[6])) / (8 * cellX);
		double _yd = ((_ls[6] + 2 * _ls[7] + _ls[8]) - (_ls[0] + 2* _ls[1] + _ls[2])) / (8 * cellY);
		
		double _rise_sun = Math.sqrt((Math.pow(_xd, 2) + Math.pow(_yd, 2)));
		double _slope = Math.atan(_rise_sun) * 57.29578;

		return _slope;
	}
}
