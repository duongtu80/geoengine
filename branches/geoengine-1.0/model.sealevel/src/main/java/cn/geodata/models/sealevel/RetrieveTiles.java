package cn.geodata.models.sealevel;

import java.awt.geom.Rectangle2D;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.data.DataStore;
import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.Hints;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureIterator;
import org.geotools.gce.geotiff.GeoTiffReader;
import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.Envelope2D;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

public class RetrieveTiles {
	private Polygon lastTile;
	private GeometryFactory geometryFactory; 
	
	public static void main(String[] args) throws IOException {
		RetrieveTiles _retrieve = new RetrieveTiles();
		_retrieve.execute2();
	}
	
	public RetrieveTiles(){
		this.geometryFactory = new GeometryFactory();
	}
	
	public void execute2() throws IOException {
		EnviRasterReader _reader = new EnviRasterReader(new File("d:\\mfeng\\data\\dem\\tmp\\080116\\global\\outputdem003"), 50 * 1024 * 1024);

		double _cellSizeX = _reader.getCellSize();
		double _cellSizeY = _reader.getCellSize();
		
		int _cols = _reader.getColCount();
		int _rows = _reader.getRowCount();
		
		Envelope2D _env = _reader.getEnvelope();
		
		DecimalFormat _format = new DecimalFormat("0.0");
		Map<Polygon, String> _tiles = this.getTiles();

		List<String> _list = new ArrayList<String>();
		
		List<Polygon> _previousList = new ArrayList<Polygon>();
		Rectangle2D _eeenv = this.totleTitleExtent(_tiles.keySet());
		
		double _y = _env.getMaxY() - _cellSizeY / 2;
		for(int _row=0;_row < _rows;_row++){
			if(_y <= _eeenv.getMaxY() && _y >= _eeenv.getMinY()){
				
				double _x = _env.getMinX() + _cellSizeX / 2;
				Polygon _envv = null;
	
				List<Polygon> _currentList = new ArrayList<Polygon>();
				for(int _col=0;_col < _cols;_col++){
					int _val = _reader.read(_row, _col);
					if(_val > 1){
						if(_envv != null && _envv.contains(this.createPoint(_x, _y))){
						}
						else{
							Polygon _tt = this.locateTiles(_previousList, _list, _tiles, _x, _y); 
							if(_tt != null){
								_currentList.add(_tt);
							}
							_envv = _tt;
						}
					}
					_x+=_cellSizeX;
				}
				_previousList = _currentList;
			}
			
			_y -= _cellSizeY;			
			System.out.print("\r" + _format.format(_row * 100.0 / _rows) + "%");
//			if(_list.size() > 5){
//				break;
//			}
		}
		
		System.out.println("\nFinished.");
		
		File _file = new File("D:\\mfeng\\data\\dem\\tmp\\080115\\tiles\\tile.70.txt");
		FileUtils.writeLines(_file, _list, "\n");
	}
	
	private Point createPoint(double x, double y){
		return geometryFactory.createPoint(new Coordinate(x, y));
	}
	
	private Rectangle2D totleTitleExtent(Set<Polygon> keySet) {
		Rectangle2D _env = null;
		for(Polygon _e : keySet){
			if(_env == null){
				_env = this.createEnvelope2d(_e.getEnvelopeInternal());
			}
			else{
				_env = _env.createUnion(this.createEnvelope2d(_e.getEnvelopeInternal()));
			}
		}
	
		return _env;
	}
	
	private Envelope2D createEnvelope2d(Envelope env){
		return new Envelope2D(new DirectPosition2D(env.getMinX(), env.getMinY()), 
				new DirectPosition2D(env.getMaxX(), env.getMaxY()));
	}

//	public void execute1() throws IOException {
//		GridCoverage2D _grid = this.loadCoverage();
//		Envelope2D _env = _grid.getEnvelope2D();
//		RenderedImage _image = _grid.getRenderedImage();
//
//		double _cellSizeX = _env.getWidth() / _image.getWidth();
//		double _cellSizeY = _env.getHeight() / _image.getHeight();
//		
//		int _cols = (int) Math.ceil(_env.width / _cellSizeX);
//		int _rows = (int) Math.ceil(_env.height / _cellSizeY);
//		
//		DecimalFormat _format = new DecimalFormat("0.0");
//		Map<Envelope2D, String> _tiles = this.getTiles();
//		this.lastTile = null;
//
//		List<String> _list = new ArrayList<String>();
//		double _y = _env.getMaxY() - _cellSizeY / 2;
//		for(int _row=0;_row < _rows;_row++){
//			double _x = _env.getMinX() + _cellSizeX / 2;
//			Envelope2D _envv = null; 
//			for(int _col=0;_col < _cols;_col++){
////				System.out.println(_col + "," + _row);
//				int _val = this.getLocationValue(_image, _col, _row);
//				if(_val > 1){
//					if(_envv != null && _x > _env.getMinX() && _x < _env.getMaxX()){
//					}
//					else{
//						Envelope2D _tt = this.locateTiles(_list, _tiles, _x, _y); 
////						if(_tt != _envv){
////							if(_envv != null){
////								_tiles.remove(_envv);
////								_envv = null;
////							}
////						}
//						_envv = _tt;
//					}
//				}
//				_x+=_cellSizeX;
//			}
//			_y -= _cellSizeY;
//			
//			System.out.print("\r" + _format.format(_row * 100.0 / _rows) + "%");
////			if(_list.size() > 5){
////				break;
////			}
//		}
//		
//		System.out.println("\nFinished.");
//		
//		File _file = new File("D:\\mfeng\\data\\dem\\tmp\\080115\\tiles\\tile.60.txt");
//		FileUtils.writeLines(_file, _list, "\n");
//	}

	public Map<Polygon, String> getTiles() throws IOException {
		FeatureIterator _it = this.getTmFeatureSource().getFeatures().features();
		try{
			Map<Polygon, String> _tiles = new HashMap<Polygon, String>();
			while(_it.hasNext()){
				Feature _f = _it.next();
//				Object[] _vals = _f.getAttributes(new Object[] {"PATH", "ROW"});
				String _id = _f.getAttribute("PATH") + "," + _f.getAttribute("ROW");
				
				MultiPolygon _mp = (MultiPolygon) _f.getDefaultGeometry();
				Polygon _p = (Polygon) _mp.getGeometryN(0);				
				if(_mp.getNumGeometries() > 1){
					for (int i = 0; i < _mp.getNumGeometries(); i++) {
						if(_mp.getGeometryN(i).getNumPoints() > _p.getNumPoints()){
							_p = (Polygon) _mp.getGeometryN(i);
						}
//						System.out.println("Error:" + i + "" + _mp.getGeometryN(i).getNumPoints());
					}
//					throw new IOException("tile number wrong:" + _mp.getNumGeometries() + _id);
				}
				
//				Envelope _eee = _p.getEnvelopeInternal();
//				Envelope2D _env = new Envelope2D(new DirectPosition2D(_eee.getMinX(), _eee.getMinY()), new DirectPosition2D(_eee.getMaxX(), _eee.getMaxY()));
				
				_tiles.put(_p, _id);
//				_tiles.put(_p, _id);
			}
			
			return _tiles;
		}
		finally{
			_it.close();
		}
	}
	
	public FeatureSource getTmFeatureSource() throws IOException {
		File _f = new File("d:\\mfeng\\data\\path.row\\tm_path_row.shp");
		DataStore _dataStore = new ShapefileDataStore(_f.toURL());
		return _dataStore.getFeatureSource(_dataStore.getTypeNames()[0]);
	}
	
	public boolean contains(Polygon p, Coordinate c){
//		if(p.getEnvelopeInternal().contains(c)){
			Point _pt = new GeometryFactory().createPoint(c);
			if(p.contains(_pt)){
				return true;
			}
//		}
		return false;
	}

	public Polygon locateTiles(List<Polygon> previousList, List<String> list, Map<Polygon, String> tiles, double x, double y) throws IOException{
		for(int i=0;i<previousList.size();i++){
			if(previousList.get(i).contains(this.createPoint(x, y))){
				Polygon _v = previousList.get(i);
				
				for(int j=i;j>=0;j--){
					previousList.remove(j);
				}
				return _v;
			}
		}
		
		for(Polygon _k : tiles.keySet()){
			if(_k.contains(this.createPoint(x, y))){
//			if(this.contains(_k, c)){
				String _id = tiles.get(_k);
				
				if(list.contains(_id) == false){
					list.add(_id);
				}
				return _k;
			}
		}
		return null;
	}

//	public boolean locateTiles(List<String> list, Map<Envelope2D, String> tiles, Coordinate c) throws IOException{
//		for(Envelope2D _k : tiles.keySet()){
//			if(_k.contains(x, y)){
////			if(this.contains(_k, c)){
//				String _id = tiles.get(_k);
//				
//				if(list.contains(_id) == false){
//					list.add(_id);
//					tiles.remove(_k);
//				}
//				return true;
//			}
//		}
//		return false;
//	}

	public boolean locateTiles2(List<String> list, Map<Polygon, String> tiles, Coordinate c) throws IOException{
		if(this.lastTile != null){
			if(this.contains(this.lastTile, c)){
				String _id = tiles.get(this.lastTile);
				
				if(list.contains(_id) == false){
					list.add(_id);
				}
				return true;
			}
		}
		
		for(Polygon _k : tiles.keySet()){
			if(this.contains(_k, c)){
				String _id = tiles.get(_k);
				
				if(list.contains(_id) == false){
					this.lastTile = _k;
//					System.out.println("Add " + _id);
					list.add(_id);
				}
				return true;
			}
		}
		return false;
//		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
//		Contains _contains = _factory.contains(_factory.property("shape"), _factory.literal(_geometryFactory.createPoint(c)));
//		
//		FeatureIterator _it = fs.getFeatures(_contains).features();
//		try{
//			while(_it.hasNext()){
//				Feature _f = _it.next();
//				
//				
//				if(list.contains(_id) == false){
//					System.out.println("Add " + _id);
//					list.add(_id);
//				}
//			}
//		}
//		finally{
//			_it.close();
//		}
	}
	
	public Coordinate pointToCoordinate(Envelope2D env, double cellSizeX, double cellSizeY, int col, int row){
		double _x = env.getMinX() + col * cellSizeX + cellSizeX / 2;
		double _y = env.getMaxY() - row * cellSizeY - cellSizeY / 2;
		
//		System.out.println(_x + "," + _y);
		return new Coordinate(_x, _y);
	}
	
	public GridCoverage2D loadCoverage() throws IOException {
		File _file = new File("d:\\mfeng\\data\\dem\\tmp\\080115\\global\\dem003.tif");
		GeoTiffReader _reader = new GeoTiffReader(_file, new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE));
		
		return (GridCoverage2D) _reader.read(null);
	}
	
	public int getLocationValue(RenderedImage image, int col, int row){
		int _tileX = col / image.getTileWidth();
		int _tileY = row / image.getTileHeight();

		Raster _raster = image.getTile(_tileX, _tileY);
		return _raster.getSample(col, row, 0);
	}
}
