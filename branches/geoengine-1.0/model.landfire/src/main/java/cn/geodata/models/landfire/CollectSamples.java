package cn.geodata.models.landfire;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import org.apache.commons.configuration.HierarchicalConfiguration;
import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.AttributeType;
import org.geotools.feature.AttributeTypeFactory;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureIterator;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.ReferencingFactoryFinder;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.CoordinateOperation;
import org.opengis.referencing.operation.CoordinateOperationFactory;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

public class CollectSamples {
	private static Logger log = Logger.getAnonymousLogger();	
	private HierarchicalConfiguration config;
	private MathTransform transform;
	
	public CollectSamples() throws NoSuchAuthorityCodeException, FactoryException{
		this.config = (new Configure()).getSubConfig("sample");

		CoordinateReferenceSystem _proCoordSys = CRS.decode("EPSG:42303");
		CoordinateReferenceSystem _geoCoordSys = CRS.decode("EPSG:4326");
		
		CoordinateOperationFactory _coFactory = ReferencingFactoryFinder.getCoordinateOperationFactory(GeoTools.getDefaultHints());
		CoordinateOperation _ch = _coFactory.createOperation(_proCoordSys, _geoCoordSys);
		
		this.transform = _ch.getMathTransform();
	}
	
	private AbstractRasterSampleModel rasterModel;
	
	public AbstractRasterSampleModel getRasterModel() {
		return rasterModel;
	}

	public void setRasterModel(AbstractRasterSampleModel rasterModel) {
		this.rasterModel = rasterModel;
	}
	
	public Map<String, AttributeType> getFields(){
		Map<String, AttributeType> _fields = new HashMap<String, AttributeType>();

		_fields.put("sample", AttributeTypeFactory.newAttributeType("sample", Point.class));
		_fields.put("id", AttributeTypeFactory.newAttributeType("id", String.class, true, 100));
		_fields.put("fireId", AttributeTypeFactory.newAttributeType("fireId", String.class, true, 100));
		_fields.put("x", AttributeTypeFactory.newAttributeType("x", Double.class));
		_fields.put("y", AttributeTypeFactory.newAttributeType("y", Double.class));
		_fields.put("lat", AttributeTypeFactory.newAttributeType("lat", Double.class));
		_fields.put("lon", AttributeTypeFactory.newAttributeType("lon", Double.class));
		_fields.put("fireArea", AttributeTypeFactory.newAttributeType("fireArea", Double.class));
		_fields.put("BuffArea", AttributeTypeFactory.newAttributeType("buffArea", Double.class));
		
		return _fields;
	}

//	protected FeatureType createResultFeatureType() throws IOException{
//		AttributeTypeFactory _attributeFactory = CommonFactoryFinder.getAttributeTypeFactory(GeoTools.getDefaultHints());
//		List<AttributeType> _attrs = new ArrayList<AttributeType>();
//		
//		_attrs.add(_attributeFactory.newAttributeType("shape", Point.class));
//		_attrs.add(_attributeFactory.newAttributeType("dnbr", Double.class));
//		
//		try {
//			return CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType((AttributeType[])_attrs.toArray(new AttributeType[0]), "samples");
//		} catch (FactoryRegistryException e) {
//			log.log(Level.SEVERE, "Failed to create featureType", e);
//			throw new IOException(e);
//		} catch (SchemaException e) {
//			log.log(Level.SEVERE, "Failed to create featureType", e);
//			throw new IOException(e);
//		}
//	}
//	
	public List<Map<String, Object>> findSamples(String id, double numFactor, double minDistance, double bufferFactor, int maxTry) throws IOException, MismatchedDimensionException, TransformException{
		List<Map<String, Object>> _list = new ArrayList<Map<String, Object>>();
		
		Polygon _p = this.findFireRegion(id);
		int _count = (int) Math.ceil(_p.getArea() * numFactor);
		
		double _bufferDistance = Math.sqrt(_p.getArea() / Math.PI) * bufferFactor;
//		Polygon _bufP = (Polygon) _p.buffer(_bufferDistance);
		Polygon _bufP = _p;
		
		log.info("count:" + _count);
		log.info("area:" + _p.getArea());
		log.info("bufferDistance:" + _bufferDistance);
		log.info("bufferArea:" + _bufP.getArea());
		
		for(int i=0;i<_count;i++){
			Map<String, Object> _sample = findSample(id, _bufP, _list, minDistance, maxTry);
			if(_sample != null){
				Point _pt = (Point) _sample.get("sample");
				Point _geoPt = this.transform2Geo(_pt);
				
				_sample.put("fireId", id);
				_sample.put("fireArea", _p.getArea());
				_sample.put("buffArea", _bufP.getArea() - _p.getArea());
				
				_sample.put("id", id + "-" + String.format("%04d", i));
				_sample.put("x", _pt.getX());
				_sample.put("y", _pt.getY());
				_sample.put("lon", _geoPt.getX());
				_sample.put("lat", _geoPt.getY());
				
				_list.add(_sample);
			}
		}
		
		return _list;
	}
	
	public Map<String, Object> findSample(String id, Polygon polygon, List<Map<String, Object>>list, double minDistance, int maxTry) throws IOException{
		Envelope _extent = polygon.getEnvelopeInternal();
		GeometryFactory _factory = new GeometryFactory();

		Random _r = new Random();
		for(int i=0;i<maxTry;i++){
			log.info("try " + i);
			
			double _x = _r.nextDouble();
			double _y = _r.nextDouble();
			
			_x = _extent.getMinX() + (_x * _extent.getWidth());
			_y = _extent.getMinY() + (_y * _extent.getHeight());
			
			Point _pt = _factory.createPoint(new Coordinate(_x, _y));
			
			if(polygon.contains(_pt) && isOverLay(list, _pt, minDistance) == false){
				double _val = this.getRasterModel().getSample(id, _pt)[0];
				
				if(_val != Double.NaN){
					Map<String, Object> _map = new HashMap<String, Object>();
					_map.put("sample", _pt);
					_map.put("dnbr", _val);
					
					log.info("found point:" + _x + "," + _y);
					
					return _map;
				}
			}
		}
		log.warning("Not found a valiable location within max try");
		return null;
	}
	
	public boolean isOverLay(List<Map<String, Object>> list, Point pt, double minDistance){
		for(Map<String, Object> _loc : list){
			if(((Point)_loc.get("sample")).distance(pt) < minDistance){
				return true;
			}
		}
		return false;
	}
	
	public boolean validatePoint(Point pt){
		return false;
	}
	
	public Polygon findFireRegion(String id) throws IOException{
		MultiPolygon _multiPolygon = (MultiPolygon) this.findFireFeature(id).getDefaultGeometry();

		return (Polygon) _multiPolygon.getGeometryN(0);
	}

	public Feature findFireFeature(String id) throws IOException{
		FeatureIterator _it = this.findFireRegionDataset(id).getFeatures().features();
		try{
			if(_it.hasNext() == false){
				throw new IOException("Dataset is empty");
			}
			
			return _it.next();
		}
		finally{
			_it.close();
		}
	}

	public FeatureSource findFireRegionDataset(String id) throws IOException{
		File _file = new File(config.getString("shapefile"), id + "\\" + id + ".shp");
		
		if(_file.exists() == false){
			throw new FileNotFoundException(_file.getAbsolutePath());
		}
		
		return (new ShapefileDataStore(_file.toURL())).getFeatureSource();
	}
	
	public Point transform2Geo(Point pt) throws MismatchedDimensionException, TransformException{
		return (Point) JTS.transform(pt, this.transform);

	}
}
