package cn.geodata.models.wetland;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;

import org.geotools.data.FeatureSource;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureIterator;
import org.opengis.filter.FilterFactory2;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

public class Catchment {
	private Logger log = Logger.getAnonymousLogger();
	private GeoEnvironment envi;
	private String fieldName;
	
	public String findCatchment(double x, double y) throws Exception {
		GeometryFactory _factory = new GeometryFactory();
		Point _pt = _factory.createPoint(new Coordinate(x, y)); 
		
		Feature _f = this.findWetland(_pt);
		if(_f == null){
			return null;
		}
		
		return (String)_f.getAttribute(this.fieldName);
	}

	public String findCatchmentTag(String pt) throws NumberFormatException, Exception{
		if(pt == null || pt.length() == 0){
			throw new NullPointerException("Noloation information be provided");
		}
		String[] _parts = pt.split(", ");
		if(_parts.length != 2){
			throw new ArrayIndexOutOfBoundsException(_parts.length);
		}
		
		return this.findCatchment(Double.parseDouble(_parts[0]), Double.parseDouble(_parts[1]));
	}

	public MultiPolygon findCatchmentByTag(String tag) throws NumberFormatException, Exception{
		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		FeatureSource _featureSource = this.getEnvi().getFeatureSource();
		
		FeatureIterator _it = _featureSource.getFeatures().features();
		try{
			log.info("tag:" + tag);
			while(_it.hasNext()){
				Feature _f = _it.next();
				String _tag = (String) _f.getAttribute(this.getFieldName());
				if(_tag.trim().equals(tag)){
					log.info("found feature");
					return (MultiPolygon) _f.getDefaultGeometry();
				}
			}

			log.info("not found feature:" + tag);
			throw new NullPointerException("Not found the Catchement");
		}
		finally{
			_it.close();
		}
	}

	public GeoEnvironment getEnvi() {
		return envi;
	}

	public void setEnvi(GeoEnvironment envi) {
		this.envi = envi;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public Feature findWetland(Point pt) throws IOException {
		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		FeatureSource _featureSource = this.getEnvi().getFeatureSource();
		FeatureIterator _it = _featureSource.getFeatures(_factory.contains(_factory.property(_featureSource.getSchema().getDefaultGeometry().getLocalName()), _factory.literal(pt))).features();
		try{
			log.info("location:" + pt.toText());
			if(_it.hasNext()){
				log.info("found feature");
				return _it.next();
			}
			
			log.info("not found feature:" + pt);
			return null;
//			throw new NullPointerException("Not found the Catchement");
		}
		finally{
			_it.close();
		}
	}
}
