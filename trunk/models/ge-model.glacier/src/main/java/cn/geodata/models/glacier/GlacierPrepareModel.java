package cn.geodata.models.glacier;

import java.awt.Rectangle;
import java.awt.image.BandedSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Logger;

import org.geotools.feature.FeatureCollection;
import org.geotools.geometry.Envelope2D;
import org.opengis.feature.Feature;

import cn.geodata.models.tools.Utilities;
import cn.geodata.models.tools.raster.RasterInfo;
import cn.geodata.models.tools.raster.RasterManager;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

/**
 * @author tank
 * 
 * Glacier area model
 *
 */
public class GlacierPrepareModel {
	private static Logger log = Logger.getLogger(GlacierPrepareModel.class.getName());
	
	private RasterManager rasterManager;
	private FeatureCollection glaciers;
	
	/**
	 * @param rasterManager DEM raster manager
	 * @param glacierPath	Glacier shapefile path
	 */
	public GlacierPrepareModel(RasterManager rasterManager, FeatureCollection glaciers){
		this.rasterManager = rasterManager;
		this.glaciers = glaciers;
	}
	
	public RasterManager getRasterManager() {
		return rasterManager;
	}

	/**
	 * 
	 * Calculate glacier area for each band
	 * 
	 * @param catchment	shape of target hydrological catchment
	 * @param cellSize	cell size
	 * @param levels	bands
	 * @param rasterFile	output raster file path, null if don't want output raster
	 * @return
	 * @throws Exception
	 */
	public Map<Integer, Integer> calculateGlacierArea(MultiPolygon catchment, double cellSize, File rasterFile) throws Exception{
		Envelope _extent = catchment.getEnvelopeInternal();
		
		int _colCount = (int) Math.ceil(_extent.getWidth() / cellSize);
		int _rowCount = (int) Math.ceil(_extent.getHeight() / cellSize);
		
		Envelope2D _exte = new Envelope2D(null, _extent.getMinX(), _extent.getMinY(), _colCount * cellSize, _rowCount * cellSize);
		Rectangle _rect = new Rectangle(0, 0, _colCount, _rowCount);
		
		WritableRaster _raster = null;
		if(rasterFile != null){
			SampleModel _sampleModel = new BandedSampleModel(DataBuffer.TYPE_SHORT, (int)_rect.getWidth(), (int)_rect.getHeight(), 1);
			_raster = Raster.createWritableRaster(_sampleModel, null); //(_sampleModel, null);
		}

		//Calculate glacier area for each zone
		Map<Integer, Integer> _areas = new HashMap<Integer, Integer>();
		
		List<MultiPolygon> _glaciers = new ArrayList<MultiPolygon>();
		for(Feature _f: (Feature[])this.glaciers.toArray(new Feature[0])){
			_glaciers.add((MultiPolygon)_f.getDefaultGeometryProperty().getValue());
		}
		
		this.calculateGlacierArea(_exte, _rect, _raster, _glaciers, catchment, _areas);

		if(_raster != null)
			Utilities.saveRaster(rasterFile, _raster, _exte);
		
		return _areas;
	}

	/**
	 * 
	 * Calculate glacier area for each band
	 * 
	 * @param catchment	shape of target hydrological catchment
	 * @param cellSize	cell size
	 * @param levels	bands
	 * @param rasterFile	output raster file path, null if don't want output raster
	 * @return
	 * @throws Exception
	 */
	public Map<Integer, Integer> calculateLandArea(MultiPolygon catchment, double cellSize, File rasterFile) throws Exception{
		Envelope _extent = catchment.getEnvelopeInternal();
		
		int _colCount = (int) Math.ceil(_extent.getWidth() / cellSize);
		int _rowCount = (int) Math.ceil(_extent.getHeight() / cellSize);
		
		Envelope2D _exte = new Envelope2D(null, _extent.getMinX(), _extent.getMinY(), _colCount * cellSize, _rowCount * cellSize);
		Rectangle _rect = new Rectangle(0, 0, _colCount, _rowCount);
		
		WritableRaster _raster = null;
		if(rasterFile != null){
			SampleModel _sampleModel = new BandedSampleModel(DataBuffer.TYPE_SHORT, (int)_rect.getWidth(), (int)_rect.getHeight(), 1);
			_raster = Raster.createWritableRaster(_sampleModel, null); //(_sampleModel, null);
		}

		//Calculate land area for each zone
		Map<Integer, Integer> _landAreas = new HashMap<Integer, Integer>();
		
		List<MultiPolygon> _land = new ArrayList<MultiPolygon>();
		_land.add(catchment);
		
		this.calculateLandArea(_exte, _rect, _raster, _land, catchment, _landAreas);
		
		if(_raster != null)
			Utilities.saveRaster(rasterFile, _raster, _exte);
		
		return _landAreas;
	}

	/**
	 * Calculate the land area for each altitude level/zone
	 * 
	 * @param extent	Spatial extent for the DEM area
	 * @param rect		DEM area size
	 * @param raster	Output DEM file
	 * @param catchment	Catchment geometry polygon
	 * @param areas		Output list for land area at each altitude level
	 * @throws Exception
	 */
	private void calculateLandArea(Envelope2D extent, Rectangle rect, WritableRaster raster, List<MultiPolygon> land, MultiPolygon catchment, Map<Integer, Integer> areas) throws Exception {
		Stack<Param> _stack = new Stack<Param>();
		Param _param = new Param();
		
		_param.setExtent(extent);
		_param.setRect(rect);
		_param.setFs(land);
		
		_stack.push(_param);
		
		this.calculate(_stack, raster, catchment, areas);
	}

	
	/**
	 * Calculate the glacier area for each altitude level
	 * 
	 * @param extent	Spatial extent for the DEM area
	 * @param rect		DEM area size
	 * @param raster	Output DEM file
	 * @param fs		Glacier feature collection
	 * @param catchment	Catchment geometry polygon
	 * @param areas		Output list for area at each altitude level
	 * @throws Exception
	 */
	private void calculateGlacierArea(Envelope2D extent, Rectangle rect, WritableRaster raster, List<MultiPolygon> fs, MultiPolygon catchment, Map<Integer, Integer> areas) throws Exception {
		Stack<Param> _stack = new Stack<Param>();
		Param _param = new Param();
		
		_param.setExtent(extent);
		_param.setRect(rect);
		_param.setFs(fs);
		
		_stack.push(_param);
		
		this.calculate(_stack, raster, catchment, areas);
	}
	
	private void calculate(Stack<Param> stack, WritableRaster raster, MultiPolygon catchment, Map<Integer, Integer> areas) throws IOException{
//		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		List<RasterInfo> _rasterList = null; 

		while(stack.size() > 0){
			Param _param = stack.pop();
			Envelope2D _exte = _param.getExtent();

			if(_rasterList == null){
				_rasterList = this.rasterManager.findDatasets(Utilities.covertEnvelope2D(_exte));
			}
			
//			System.out.println(_param.getRect().getMinX() + "," + _param.getRect().getMinY() + " width:" + _param.getRect().getWidth() + " height:" + _param.getRect().getHeight());

//			BBOX _filter = _factory.bbox(propertyName, _exte.getMinX(), _exte.getMinY(), _exte.getMaxX(), _exte.getMaxY(), null);
//			FeatureCollection _fs2 = _param.getFs().subCollection(_filter);
			
			List<MultiPolygon> _fs2 = _param.getFs();
			boolean _covered = _param.isCovered();
			
			if(_covered == false){
				_fs2 = this.subCollection(_param.getFs(), _exte, catchment);
				_covered = checkCovered(_fs2, _param.getExtent(), catchment);
			}
			
			if(_fs2.size() > 0){
				Rectangle _rect = _param.getRect();
				if((int)_rect.getWidth() > 1 || (int)_rect.getHeight() > 1){
					int _width1 = (int)_rect.getWidth();
					int _height1 = (int)_rect.getHeight();
					int _width2 = 0;
					int _height2 = 0;
					
					if(_rect.getWidth() > 1){
						_width1 = (int)Math.ceil(_rect.getWidth() / 2);
						_width2 = (int) (_rect.getWidth() - _width1);
					}
					if(_rect.getHeight() > 1){
						_height1 = (int)Math.ceil(_rect.getHeight() / 2);
						_height2 = (int) (_rect.getHeight() - _height1);
					}
					
					double _width1Rat = _width1 / _rect.getWidth();
					double _height1Rat = _height1 / _rect.getHeight();
					
//					System.out.println("Rat " + _width1Rat + "," + _height1Rat);
					
					if(_height1 > 0){
						if(_width1 > 0)
							stack.push(new Param(_covered, _fs2,
									(int)_rect.getMinX(), 
									(int)_rect.getMinY(), 
									_width1, 
									_height1, 
									_exte.getMinX(), 
									_exte.getMaxY() - _exte.getHeight() * _height1Rat, 
									_exte.getWidth() * _width1Rat, 
									_exte.getHeight() * _height1Rat
								));
						if(_width2 > 0)
							stack.push(new Param(_covered, _fs2,
									(int)_rect.getMinX() + _width1, 
									(int)_rect.getMinY(),
									_width2, 
									_height1, 
									_exte.getMinX() + _exte.getWidth() * _width1Rat, 
									_exte.getMaxY() - _exte.getHeight() * _height1Rat, 
									_exte.getWidth() * (1 - _width1Rat), 
									_exte.getHeight() * _height1Rat
								));
					}
					if(_height2 > 0){
						if(_width1 > 0)
							stack.push(new Param(_covered, _fs2,
									(int)_rect.getMinX(), 
									(int)_rect.getMinY() + _height1, 
									_width1, 
									_height2, 
									_exte.getMinX(), 
									_exte.getMinY(), 
									_exte.getWidth() * _width1Rat, 
									_exte.getHeight() * (1 - _height1Rat)
								));
						if(_width2 > 0)
							stack.push(new Param(_covered, _fs2,
									(int)_rect.getMinX() + _width1, 
									(int)_rect.getMinY() + _height1, 
									_width2, 
									_height2, 
									_exte.getMinX() + _exte.getWidth() * _width1Rat, 
									_exte.getMinY(), 
									_exte.getWidth() * (1 - _width1Rat), 
									_exte.getHeight() * (1 - _height1Rat)
								));
					}
				}
				else{
					double _x = _exte.getCenterX();
					double _y = _exte.getCenterY();
					Integer _v = this.rasterManager.getLocationValue(_rasterList, _x, _y);
					
					if(_v > 0){
						if(areas.containsKey(_v)){
							areas.put(_v, areas.get(_v) + 1);
						}
						else{
							areas.put(_v, 1);
						}
						
						if(raster != null){
//							System.out.println("Set " + (int)_rect.getMinX() + "," + (int)_rect.getMinY());
							if(raster.getSample((int)_rect.getMinX(), (int)_rect.getMinY(), 0) > 0){
								System.out.println("Over:" + (int)_rect.getMinX() + "," + (int)_rect.getMinY() + "," + raster.getSample((int)_rect.getMinX(), (int)_rect.getMinY(), 0) + "," + _v);
							}
							raster.setSample((int)_rect.getMinX(), (int)_rect.getMinY(), 0, _v);
						}
					}
				}
			}
		}
	}
	
	public class Param{
		private Envelope2D extent;
		private Rectangle rect;
		private List<MultiPolygon> fs;
		private boolean covered;
		
		public Param(){
			
		}
		
		public Param(boolean covered, List<MultiPolygon> fs, int minX, int minY, int width1, int height1, double minX2, double minY2, double width2, double height2){
			this.covered = covered;
			this.fs = fs;
			this.extent = new Envelope2D(null, minX2, minY2, width2, height2);
			this.rect = new Rectangle(minX, minY, width1, height1);
		}
		
		public Envelope2D getExtent() {
			return extent;
		}
		
		public void setExtent(Envelope2D extent) {
			this.extent = extent;
		}
		
		public List<MultiPolygon> getFs() {
			return fs;
		}

		public void setFs(List<MultiPolygon> fs) {
			this.fs = fs;
		}

		public Rectangle getRect() {
			return rect;
		}

		public void setRect(Rectangle rect) {
			this.rect = rect;
		}

		public boolean isCovered() {
			return covered;
		}

		public void setCovered(boolean covered) {
			this.covered = covered;
		}
	}
	
	private boolean checkCovered(List<MultiPolygon> fs, Envelope2D ext, MultiPolygon catchment){
		if(fs.size() == 0){
			return true;
		}
		
		if(fs.size() > 1){
			return false;
		}
		
		
//		System.out.println("check");
		Geometry _ext = Utilities.covertEnvelope2D(ext);
		if(catchment.contains(_ext) == false){
			return false;
		}
		
		for(MultiPolygon _f : fs){
			_ext = _ext.difference(_f);
			if(_ext.isEmpty()){
//				log.info("Covered:" + _ext);
				return true;
			}
		}
//		System.out.println("uncheck");
		
		return false;
	}
	
	private List<MultiPolygon> subCollection(List<MultiPolygon> fs, Envelope2D ext, MultiPolygon catchment){
		Polygon _ext = Utilities.covertEnvelope2D(ext);
		List<MultiPolygon> _fs = new ArrayList<MultiPolygon>();
		
		if(catchment.intersects(_ext) == false){
			return _fs; 
		}

		for(MultiPolygon _p : fs){
			if(_p.intersects(_ext)){
				_fs.add(_p);
			}
		}
		
		return _fs;
	}
}
