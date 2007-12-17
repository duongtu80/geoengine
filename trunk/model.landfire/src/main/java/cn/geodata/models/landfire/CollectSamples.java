package cn.geodata.models.landfire;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureIterator;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

public class CollectSamples {
	private static Logger log = Logger.getAnonymousLogger();
	private static int MAX_TRY = 10;
	
	public List<Point> findSamples(String id, int count, double minDistance) throws IOException{
		List<Point> _list = new ArrayList<Point>();
		Polygon _p = this.findFireRegion(id);
		
		for(int i=0;i<count;i++){
			Point _pt = findSample(id, _p, _list, minDistance);
			if(_pt != null){
				_list.add(_pt);
			}
		}
		
		return _list;
	}
	
	public Point findSample(String id, Polygon polygon, List<Point>list, double minDistance) throws IOException{
		Envelope _extent = polygon.getEnvelopeInternal();
		GeometryFactory _factory = new GeometryFactory();
		DatasetDNBR _dnbr = new DatasetDNBR();
		
		Random _r = new Random();
		for(int i=0;i<MAX_TRY;i++){
			log.info("Try " + i);
			
			double _x = _r.nextDouble();
			double _y = _r.nextDouble();
			
			_x = _extent.getMinX() + (_x * _extent.getWidth());
			_y = _extent.getMinY() + (_y * _extent.getHeight());
			
			Point _pt = _factory.createPoint(new Coordinate(_x, _y));
			
			if(polygon.contains(_pt) && isOverLay(list, _pt, minDistance) == false){
				double _val = _dnbr.getAtLocation(id, _pt);
				
				if(_val != Double.NaN){
					return _pt;
				}
			}
		}
		log.warning("Not found a valiable location within max try");
		return null;
	}
	
	public boolean isOverLay(List<Point> list, Point pt, double minDistance){
		for(Point _loc : list){
			if(_loc.distance(pt) < minDistance){
				return true;
			}
		}
		return false;
	}
	
	public boolean validatePoint(Point pt){
		return false;
	}
	
	public Polygon findFireRegion(String id) throws IOException{
		FeatureIterator _it = this.findFireRegionDataset(id).getFeatures().features();
		try{
			if(_it.hasNext() == false){
				throw new IOException("Dataset is empty");
			}
			
			Feature _f = _it.next();
			MultiPolygon _multiPolygon = (MultiPolygon) _f.getDefaultGeometry();
			
			return (Polygon) _multiPolygon.getGeometryN(0);
		}
		finally{
			_it.close();
		}
	}
	
	public FeatureSource findFireRegionDataset(String id) throws IOException{
		File _file = new File(Configure.getFireRepository(), id + "\\" + id + ".shp");
		
		if(_file.exists() == false){
			throw new FileNotFoundException(_file.getAbsolutePath());
		}
		
		return (new ShapefileDataStore(_file.toURL())).getFeatureSource();
	}
}
