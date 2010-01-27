package cn.geodata.models.ecoserv.simulate;

import java.awt.Point;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.media.jai.RasterFactory;

import org.geotools.data.FeatureSource;
import org.geotools.data.FeatureStore;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.data.shapefile.ShapefileUtilities;
import org.geotools.data.shapefile.shp.JTSUtilities;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.geometry.jts.JTS;
import org.geotools.geometry.jts.ReferencedEnvelope;
import org.geotools.graph.util.geom.GeometryUtil;
import org.geotools.referencing.CRS;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

import cn.geodata.models.raster.GeoRaster;
import cn.geodata.models.wetland.multiple.Catchment;
import cn.geodata.models.wetland.multiple.HydrologicalModel;
import cn.geodata.models.wetland.multiple.SpillPoint;
import cn.geodata.models.wetland.multiple.WetlandWater;
import junit.framework.TestCase;

public class CatchementTest extends TestCase {
	
	public void testCatchmentParam() throws Exception {
		GeoRaster _dem = new GeoRaster(new File("o:\\tmp\\lidar_c.tif"), 0);
		List<Catchment> _catchments = Catchment.loadCatchments(_dem, new ShapefileDataStore(new File("o:\\tmp\\tmp\\catchments_c.shp").toURL()).getFeatureSource().getFeatures(), "NAME");
		
		HydrologicalModel _model = new HydrologicalModel(_dem, _catchments);
		for(WetlandWater _w : _model.getWetlands()){
			String _code = "outflow";
			
			SpillPoint _spill = _w.getSpillPoint();
			if(_spill.getCatchment() != null)
				_code = _spill.getCatchment().getCode();
			
			System.out.println(_w.getCatchments().get(0).getCode() + "(" + _w.getCatchmentRegion().getArea() + ")->" + _code);
		}
	}
	
	public void atestProcessCatchment() throws Exception {
		FeatureSource<SimpleFeatureType, SimpleFeature> _fs = new ShapefileDataStore(new File("o:\\tmp\\basin_flowdir_fill_lidar_c_01.shp").toURL()).getFeatureSource();
		FeatureCollection<SimpleFeatureType, SimpleFeature> _fc = _fs.getFeatures();
		
		Polygon _env = JTS.toGeometry((Envelope)_fs.getBounds());
		FeatureCollection<SimpleFeatureType, SimpleFeature> _col = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		
		FeatureIterator<SimpleFeature> _it = _fc.features();
		while(_it.hasNext()){
			SimpleFeature _f = _it.next();
			if(((Geometry)_f.getDefaultGeometry()).distance(_env.getExteriorRing()) == 0){
				System.out.println("Skip " + _f.getAttribute("GRIDCODE"));
			}
			else{
				_col.add(_f);
			}
		}
		
		_it.close();
		
		this.outputShapefile(new File("o:\\tmp\\tmp\\test1.shp"), _fs.getSchema(), _col);
	}
	
	private void outputShapefile(File f, SimpleFeatureType featureType, FeatureCollection<SimpleFeatureType, SimpleFeature> fs) throws IOException{
		ShapefileDataStore _fs = new ShapefileDataStore(f.toURL());
		_fs.createSchema(featureType);
		
		FeatureStore<SimpleFeatureType, SimpleFeature> _store = (FeatureStore<SimpleFeatureType, SimpleFeature>) _fs.getFeatureSource();
		_store.addFeatures(fs);
	}
	
	public void atestSmoothDEM() throws Exception {
		GeoRaster _dir = new GeoRaster(new File("o:\\tmp\\lidar_c_flow_dir.tif"), 0);
		
		int _cells = 3;
		WritableRaster _raster = RasterFactory.createBandedRaster(DataBuffer.TYPE_FLOAT, _dir.getColNum(), _dir.getRowNum(), 1, null);
		for(int _row=0;_row < _dir.getRowNum();_row++){
			System.out.println("Row :" + _row);
			for(int _col=0;_col < _dir.getColNum(); _col++){
				_raster.setSample(_col, _row, 0, this.smoothPixelDEM(_dir, _col, _row, _cells));
//				if(_row < _cells || _col < _cells || _row >= _dir.getRowNum() - _cells || _col >= _dir.getColNum() - _cells){
//					_raster.setSample(_col, _row, 0, _dir.getCell(_col, _row).byteValue());
//				}
//				else{
//					_raster.setSample(_col, _row, 0, this.smoothPixel(_dir, _col, _row, _cells).byteValue());
//				}
			}
		}
		
		GeoRaster.writeTiff(new File("o:\\tmp\\smooth_dem_3.tif"), _dir.getEnvelope(), _raster);
	}

	
	public void atestSmoothFlowDirection() throws Exception {
		GeoRaster _dir = new GeoRaster(new File("o:\\tmp\\lidar_c_flow_dir.tif"), 0);
		
		int _cells = 5;
		WritableRaster _raster = RasterFactory.createBandedRaster(DataBuffer.TYPE_BYTE, _dir.getColNum(), _dir.getRowNum(), 1, null);
		for(int _row=0;_row < _dir.getRowNum();_row++){
			System.out.println("Row :" + _row);
			for(int _col=0;_col < _dir.getColNum(); _col++){
				_raster.setSample(_col, _row, 0, this.smoothPixelEx(_dir, _col, _row, _cells).byteValue());
//				if(_row < _cells || _col < _cells || _row >= _dir.getRowNum() - _cells || _col >= _dir.getColNum() - _cells){
//					_raster.setSample(_col, _row, 0, _dir.getCell(_col, _row).byteValue());
//				}
//				else{
//					_raster.setSample(_col, _row, 0, this.smoothPixel(_dir, _col, _row, _cells).byteValue());
//				}
			}
		}
		
		GeoRaster.writeTiff(new File("o:\\tmp\\smooth_ex_5.tif"), _dir.getEnvelope(), _raster);
	}
	
	public void atestWaterFlowTo() throws Exception {
		GeoRaster _dir = new GeoRaster(new File("o:\\tmp\\test3.tif"), 0);
		
		int _cells = 4;
		WritableRaster _raster = RasterFactory.createBandedRaster(DataBuffer.TYPE_BYTE, _dir.getColNum(), _dir.getRowNum(), 1, null);
		for(int _row=0;_row < _dir.getRowNum();_row++){
			System.out.println("Row :" + _row);
			for(int _col=0;_col < _dir.getColNum(); _col++){
				_raster.setSample(_col, _row, 0, this.flowIntoPixel(_dir, _col, _row, _cells));
			}
		}
		
		GeoRaster.writeTiff(new File("o:\\tmp\\flow7.tif"), _dir.getEnvelope(), _raster);
	}
	
	public void atestCatchmentBorder() throws Exception {
		GeoRaster _dir = new GeoRaster(new File("o:\\tmp\\flow7.tif"), -1);
		
		int _cells = 3;
		WritableRaster _raster = RasterFactory.createBandedRaster(DataBuffer.TYPE_DOUBLE, _dir.getColNum(), _dir.getRowNum(), 1, null);
		for(int _row=0;_row < _dir.getRowNum();_row++){
			System.out.println("Row :" + _row);
			for(int _col=0;_col < _dir.getColNum(); _col++){
				_raster.setSample(_col, _row, 0, this.borderPossible(_dir, _col, _row, _cells));
			}
		}
		
		GeoRaster.writeTiff(new File("o:\\tmp\\possi7_4.tif"), _dir.getEnvelope(), _raster);
	}
	
	private Number smoothPixel(GeoRaster r, int col, int row, int cells) throws IOException{
		Map<Number, Integer> _count = new HashMap<Number, Integer>();
		for(int _row= row-cells; _row< row+cells;_row++){
			for(int _col=col -cells;_col < col + cells;_col++){
				if(_col < 0 || _col > r.getColNum() - 1 || _row < 0 || _row > r.getRowNum() - 1 ){
					continue;
				}
				
				Number _val = r.getCell(_col, _row);
				
				if(_count.containsKey(_val) == false)
					_count.put(_val, 1);
				else
					_count.put(_val, _count.get(_val) + 1);
			}
		}
		
		Number _key = null;
		for(Number _k : _count.keySet()){
			if(_key == null || _count.get(_k) > _count.get(_key)){
				_key = _k;
			}
		}
		
		return _key;
	}

	private float smoothPixelDEM(GeoRaster r, int col, int row, int cells) throws IOException{
		Float _elevation = 0f;
		int _pixelCount = 0;
		
		for(int _row= row-cells; _row< row+cells;_row++){
			for(int _col=col -cells;_col < col + cells;_col++){
				if(_col < 0 || _col > r.getColNum() - 1 || _row < 0 || _row > r.getRowNum() - 1 ){
					continue;
				}
				
				Number _val = r.getCell(_col, _row);
				_elevation += _val.floatValue();
				_pixelCount ++;
			}
		}
		
		if(_pixelCount == 0)
			return -1;
		
		return _elevation / _pixelCount;
	}

	private Number smoothPixelEx(GeoRaster r, int col, int row, int cells) throws Exception{
		Map<Number, Integer> _count = new HashMap<Number, Integer>();
		Point _to = new Point(col, row);

		for(int _row= row-cells; _row< row+cells;_row++){
			for(int _col=col -cells;_col < col + cells;_col++){
				if(_col < 0 || _col > r.getColNum() - 1 || _row < 0 || _row > r.getRowNum() - 1 ){
					continue;
				}
				
				Point _from = new Point(_col, _row);
				Number _val = r.getCell(_col, _row);

				int _d = this.calculateDirect(_from, _to);
//				this.assertNotSame(_d, 0);
				
				if(_d == 0 || _d == _val.intValue() || this.invertDirection(_d) == r.getCell(col, row).intValue()){
					if(_count.containsKey(_val) == false)
						_count.put(_val, 1);
					else
						_count.put(_val, _count.get(_val) + 1);
				}
			}
		}
		
		Number _key = null;
		for(Number _k : _count.keySet()){
			if(_key == null || _count.get(_k) > _count.get(_key)){
				_key = _k;
			}
		}
		
		assertNotNull(_key);
		return _key;
	}

	private int invertDirection(int d){
		int _d = (int)Math.round(Math.log(d) / Math.log(2));
		return (int)Math.pow(2, (_d + 4)% 8);
	}
	
	private int flowIntoPixel(GeoRaster r, int col, int row, int cells) throws Exception{
		int _count = 0;
		
		Point _to = new Point(col, row);
		for(int _row= row-cells; _row< row+cells;_row++){
			for(int _col=col -cells;_col < col + cells;_col++){
				if(_col < 0 || _col >= r.getColNum() - 1 || (_col == col && _row == row) || _row < 0 || _row >= r.getRowNum() - 1){
					continue;
				}
				
				Point _from = new Point(_col, _row);
				int _d = this.calculateDirect(_from, _to);
				
				if(_d == r.getCell(_col, _row).intValue()){
					_count ++;
				}
			}
		}
		
		return _count;
	}
	
	private float borderPossible(GeoRaster r, int col, int row, int cells) throws Exception{
		float _count = 0;
		
		for(int _row= row-cells; _row< row+cells;_row++){
			for(int _col=col -cells;_col < col + cells;_col++){
				if(_col < 0 || _col >= r.getColNum() - 1 || _row < 0 || _row >= r.getRowNum() - 1){
					continue;
				}
				
				_count += Math.exp(r.getCell(_col, _row).intValue() * Math.hypot(_col - col, _row - row));
			}
		}
		
//		System.out.println(_count);
		return _count;
	}

	private int calculateDirect(Point from, Point to) throws Exception{
		double _x = Math.signum(to.x - from.x);
		double _y = Math.signum(to.y - from.y);
		
		if(_x == 0 && _y == 0)
			return 0;
		else if(_x > 0 && _y == 0)
			return 1;
		else if(_x > 0 && _y > 0)
			return 2;
		else if(_x == 0 && _y > 0)
			return 4;
		else if(_x < 0 && _y > 0)
			return 8;
		else if(_x < 0 && _y == 0)
			return 16;
		else if(_x < 0 && _y < 0)
			return 32;
		else if(_x == 0 && _y < 0)
			return 64;
		else if(_x > 0 && _y < 0)
			return 128;
		else
			throw new Exception("Unknown direction (" + _x + ", " + _y + ")");
	}
}
