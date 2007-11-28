package cn.geodata.models.sealevel.cities;

import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import junit.framework.TestCase;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.data.DataStore;
import org.geotools.data.FeatureSource;
import org.geotools.data.FeatureStore;
import org.geotools.data.FeatureWriter;
import org.geotools.data.Transaction;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryConfigurationError;
import org.geotools.factory.GeoTools;
import org.geotools.factory.Hints;
import org.geotools.feature.AttributeType;
import org.geotools.feature.AttributeTypeFactory;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.feature.FeatureType;
import org.geotools.feature.FeatureTypeBuilder;
import org.geotools.feature.SchemaException;
import org.geotools.gce.geotiff.GeoTiffReader;
import org.geotools.geometry.Envelope2D;

import com.vividsolutions.jts.geom.Point;

public class TestInitCities extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();
	
	public void testTest1() throws Exception {
		log.info("test...");
	}
//	public void atestCreateNewCitiesDataset() throws Exception {
//		FeatureSource _inputSource = this.getOriginalCities();
//		FeatureType _inputFeatureType = _inputSource.getSchema();
//		
//		FeatureStore _outputStore = (FeatureStore) this.createEmptyFeatureSource(_inputFeatureType);
//
//		FeatureCollection _outCol = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
//
//		FeatureCollection _inCol = _inputSource.getFeatures();
//		FeatureIterator _inIt = _inCol.features();
//		
//		while(_inIt.hasNext()){
//			Feature _inFeature = _inIt.next();
//			
//			ArrayList<Object> _outAttri = new ArrayList<Object>();
//			for(int i=0; i < _inputFeatureType.getAttributeCount();i++){
//				_outAttri.add(_inFeature.getAttribute(i));
//			}
//			_outAttri.add(new Double(0.0));
//			
//			_outCol.add(_outputStore.getSchema().create(_outAttri.toArray()));
//		}
//		
//		_outputStore.addFeatures(_outCol);
//	}
//	
//	private FeatureSource getOriginalCities() throws Exception {
//		File _file = new File("d:\\mfeng\\data\\global\\cities.shp");
//		
//		ShapefileDataStore _dataStore = new ShapefileDataStore(_file.toURL());
//		return _dataStore.getFeatureSource();
//	}
//	
//	public FeatureType createFeatureType(FeatureType inputType) throws FactoryConfigurationError, SchemaException {
//		AttributeTypeFactory _attribFeatory = CommonFactoryFinder.getAttributeTypeFactory(GeoTools.getDefaultHints());
//		FeatureTypeBuilder _featureFactory = CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints());
//		
//		ArrayList<AttributeType> _attrs = new ArrayList<AttributeType>();
//		for(AttributeType _a : inputType.getAttributeTypes()){
//			_attrs.add(_a);
//		}
//		
//		_attrs.add(_attribFeatory.newAttributeType("altitude", Double.class));
//		
//		return _featureFactory.newFeatureType((AttributeType[])_attrs.toArray(new AttributeType[0]), "cities.ex.shp");
//	}
//	
//	public FeatureSource createEmptyFeatureSource(FeatureType inputType) throws IOException, FactoryConfigurationError, SchemaException, URISyntaxException {
//		DataStore _dataStore = this.createEmptyDataStore();
//		_dataStore.createSchema(this.createFeatureType(inputType));
//		
//		return _dataStore.getFeatureSource(_dataStore.getTypeNames()[0]);
//	}
//	
//	public DataStore createEmptyDataStore() throws IOException, URISyntaxException {
//		ShapefileDataStoreFactory _factory = new ShapefileDataStoreFactory();
//		
//		File _output = new File("D:\\mfeng\\save\\java\\wps\\data\\test1\\cities.ex.shp");
//		
//		Map _param = new HashMap();
//		_param.put(ShapefileDataStoreFactory.NAMESPACEP.key, new URI("http://www.geodata.cn/dataview"));
//		_param.put(ShapefileDataStoreFactory.URLP.key, _output.toURL());
//		
//		return _factory.createNewDataStore(_param);
//	}
//	
//	private FeatureSource getModifiedCities() throws Exception {
//		File _file = new File("d:\\mfeng\\save\\java\\wps\\data\\test1\\cities.ex.shp");
//		
//		ShapefileDataStore _dataStore = new ShapefileDataStore(_file.toURL());
//		return _dataStore.getFeatureSource();
//	}
//	
//	private GridCoverage2D getDemGridCoverage() throws IOException {
//		File _file = new File("d:\\mfeng\\data\\dem\\global\\SRTM_GTOPO_u30_mosaic.tif");
//		
//		GeoTiffReader _reader = new GeoTiffReader(_file, new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE));
//		GridCoverage2D _coverage = (GridCoverage2D)_reader.read(null);
//		
//		return _coverage;
//	}
//
//	private GridCoverage2D getTestGridCoverage() throws IOException {
//		File _file = new File("d:\\mfeng\\lib\\svn\\geotools\\2.4.x\\modules\\plugin\\geotiff\\src\\test\\resources\\org\\geotools\\gce\\geotiff\\test-data\\cir.tif");
//		
//		GeoTiffReader _reader = new GeoTiffReader(_file, new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE));
//		GridCoverage2D _coverage = (GridCoverage2D)_reader.read(null);
//		
//		return _coverage;
//	}
//	
//	/**
//	 * Coverage read grid from upperleft corner
//	 * @throws Exception
//	 */
//	public void atestGrid() throws Exception {
//		GridCoverage2D _coverage = this.getTestGridCoverage();
//		Envelope2D _extent = _coverage.getEnvelope2D();
//		RenderedImage _image = _coverage.getRenderedImage();
//
//		double _cellSizeX = _extent.getWidth() / _image.getWidth();
//		double _cellSizeY = _extent.getHeight() / _image.getHeight();
//
//		log.info("CellSize:" + _cellSizeX + "," + _cellSizeY);
//		
//		int _tileSizeX = _image.getTileWidth();
//		int _tileSizeY = _image.getTileHeight();
//		
//		log.info("TileSize:" + _tileSizeX + "," + _tileSizeY);
//
//		int _col = 0;
//		int _row = 0;
//		
//		int _tileX = (int)Math.floor((double)_col / (double)_tileSizeX);
//		int _tileY = (int)Math.floor((double)_row / (double)_tileSizeY);
//		
//		log.info("Tile:" + _tileX + "," + _tileY);
//		
//		Raster _r = _image.getTile(_tileX, _tileY);
//		int _value = _r.getSample(_col, _row, 0);
//		
//		log.info("Value:" + _value + "," + _r.getSample(_col, _row, 1) + "," + _r.getSample(_col, _row, 2));
//	}
//
//	public void atestLoadCities() throws Exception {
//		GridCoverage2D _coverage = this.getDemGridCoverage();
//		Envelope2D _extent = _coverage.getEnvelope2D();
//		RenderedImage _image = _coverage.getRenderedImage();
//
//		double _cellSizeX = _extent.getWidth() / _image.getWidth();
//		double _cellSizeY = _extent.getHeight() / _image.getHeight();
//
//		log.info("CellSize:" + _cellSizeX + "," + _cellSizeY);
//		
//		int _tileSizeX = _image.getTileWidth();
//		int _tileSizeY = _image.getTileHeight();
//		
//		log.info("TileSize:" + _tileSizeX + "," + _tileSizeY);
//
//		FeatureSource _fs = this.getModifiedCities();
////		FeatureIterator _it = _fs.getFeatures().features();
//		
//		FeatureStore _store = (FeatureStore) _fs;
//		FeatureWriter _writer = _store.getDataStore().getFeatureWriter(_fs.getSchema().getTypeName(), Transaction.AUTO_COMMIT);
//		while(_writer.hasNext()){
//			Feature _f = _writer.next();
//			
//			log.info("City:" + _f.getAttribute("CITY_NAME") + "(" + _f.getAttribute("CNTRY_NAME") + ")");
//			
//			Point _pt = (Point) _f.getDefaultGeometry();
//			
//			int _col = (int)Math.floor(((_pt.getX() - _extent.getMinX()) / _cellSizeX));
//			int _row = (int)Math.floor(((_extent.getMaxY() - _pt.getY()) / _cellSizeY));
//			
//			log.info("Pt:" + _pt.getX() + "," + _pt.getY() + " " + _col + "," + _row);
//
//			int _tileX = (int)Math.floor((double)_col / (double)_tileSizeX);
//			int _tileY = (int)Math.floor((double)_row / (double)_tileSizeY);
//			
//			log.info("Tile:" + _tileX + "," + _tileY);
//			
//			Raster _r = _image.getTile(_tileX, _tileY);
//			int _value = _r.getSample(_col, _row, 0);
//			
//			log.info("Value:" + _value);
//			_f.setAttribute("altitude", _value);
//			
////			break;
//		}
//		_writer.close();
//	}
}
