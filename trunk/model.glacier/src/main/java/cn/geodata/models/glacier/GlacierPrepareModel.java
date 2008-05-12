package cn.geodata.models.glacier;

import java.awt.Rectangle;
import java.awt.image.BandedSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.geometry.Envelope2D;
import org.opengis.filter.FilterFactory2;
import org.opengis.filter.expression.PropertyName;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

import cn.geodata.models.tools.Utilities;
import cn.geodata.models.tools.raster.RasterInfo;
import cn.geodata.models.tools.raster.RasterManager;

/**
 * @author tank
 * 
 * Glacier area model
 *
 */
public class GlacierPrepareModel {
	private static Logger log = Logger.getLogger(GlacierPrepareModel.class.getName());
	private RasterManager rasterManager;
	private String glacierPath;
	
	/**
	 * @param rasterManager DEM raster manager
	 * @param glacierPath	Glacier shapefile path
	 */
	public GlacierPrepareModel(RasterManager rasterManager, String glacierPath){
		this.rasterManager = rasterManager;
		this.glacierPath = glacierPath;
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
	public List<BandInfo> calculate(MultiPolygon catchment, double cellSize, double[] levels, File rasterFile) throws Exception{
		Envelope _extent = catchment.getEnvelopeInternal();
		
		int _colCount = (int) Math.ceil(_extent.getWidth() / cellSize);
		int _rowCount = (int) Math.ceil(_extent.getHeight() / cellSize);
		
		Envelope2D _exte = new Envelope2D(null, _extent.getMinX(), _extent.getMinY(), _colCount * cellSize, _rowCount * cellSize);
		Rectangle _rect = new Rectangle(0, 0, _colCount, _rowCount);
		
		List<BandInfo> _areas = new ArrayList<BandInfo>();
		for(int i=0;i<levels.length;i++){
			BandInfo _bandInfo = new BandInfo();
			_bandInfo.setBandAltitude(levels[i]);
			
			_areas.add(_bandInfo );
		}

		WritableRaster _raster = null;
		if(rasterFile != null){
			SampleModel _sampleModel = new BandedSampleModel(DataBuffer.TYPE_SHORT, (int)_rect.getWidth(), (int)_rect.getHeight(), 1);
			_raster = Raster.createWritableRaster(_sampleModel, null); //(_sampleModel, null);
		}
		FeatureSource _fs = new ShapefileDataStore(GlacierPrepareModel.class.getResource(this.glacierPath)).getFeatureSource();

		this.calculate(_exte, _rect, _raster, _fs , catchment, levels, _areas);
		if(_raster != null)
			Utilities.saveRaster(rasterFile, _raster, _exte);
		
		return _areas;
	}
	
	public void calculate(Envelope2D extent, Rectangle rect, WritableRaster raster, FeatureSource fs, MultiPolygon catchment, double[] levels, List<BandInfo> _areas) throws Exception {
		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());

		Stack<Param> _stack = new Stack<Param>();
		Param _param = new Param();
		
		_param.setExtent(extent);
		_param.setRect(rect);
		_param.setFs(fs.getFeatures());
		
		_stack.push(_param);
		
		this.calculate(_factory.property(fs.getSchema().getDefaultGeometry().getLocalName()), _stack, raster, catchment, levels, _areas);
	}
	
	public void calculate(PropertyName propertyName, Stack<Param> stack, WritableRaster raster, MultiPolygon catchment, double[] levels, List<BandInfo> _areas) throws IOException{
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
			
			FeatureCollection _fs2 = _param.getFs();
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
					
					System.out.println("Rat " + _width1Rat + "," + _height1Rat);
					
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
					double _v = this.rasterManager.getLocationValue(_rasterList, _x, _y);
					
					if(_v > 0){
						for(int i=0;i<levels.length;i++){
							if(_v <= levels[i]){
								_areas.get(i).setGlacierCount(_areas.get(i).getGlacierCount() + 1);
								break;
							}
						}
						if(raster != null){
							System.out.println("Set " + (int)_rect.getMinX() + "," + (int)_rect.getMinY());
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
		private FeatureCollection fs;
		private boolean covered;
		
		public Param(){
			
		}
		
		public Param(boolean covered, FeatureCollection fs, int minX, int minY, int width1, int height1, double minX2, double minY2, double width2, double height2){
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
		
		public FeatureCollection getFs() {
			return fs;
		}

		public void setFs(FeatureCollection fs) {
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
	
	private boolean checkCovered(FeatureCollection fs, Envelope2D ext, MultiPolygon catchment){
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
		
		for(Feature _f : (Feature[]) fs.toArray(new Feature[0])){
			_ext = _ext.difference(_f.getDefaultGeometry());
			if(_ext.isEmpty()){
//				log.info("Covered:" + _ext);
				return true;
			}
		}
//		System.out.println("uncheck");
		
		return false;
	}
	
	private FeatureCollection subCollection(FeatureCollection fs, Envelope2D ext, MultiPolygon catchment){
		Polygon _ext = Utilities.covertEnvelope2D(ext);
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		
		if(catchment.intersects(_ext) == false){
			return _fs; 
		}

		FeatureIterator _it = fs.features();
		try{
			while(_it.hasNext()){
				Feature _f = _it.next();
				if(_f.getDefaultGeometry().intersects(_ext)){
					_fs.add(_f);
				}
			}
		}
		finally{
			if(_it != null){
				_it.close();
			}
		}
		
		return _fs;
	}
}
