package cn.geodata.models.wetland.actions.map;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;

import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureIterator;
import org.opengis.filter.FilterFactory2;

import com.vividsolutions.jts.geom.Point;

/**
 * @author mfeng
 *
 */
public class GeoEnvironment {
	private static Logger log = Logger.getAnonymousLogger();
	
	private String geoserver;
	private String wetland;
	
	public String getGeoserver() {
		return geoserver;
	}

	public void setGeoserver(String geoserver) {
		this.geoserver = geoserver;
	}

	public String getWetland() {
		return wetland;
	}
	
	public void setWetland(String wetland) {
		this.wetland = wetland;
	}
	
	public Feature findWetland(Point pt) throws IOException{
		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		
		FeatureSource _featureSource = new ShapefileDataStore(new File(new File(this.getGeoserver()), this.wetland).toURL()).getFeatureSource();
		FeatureIterator _it = _featureSource.getFeatures(_factory.contains(_factory.property(_featureSource.getSchema().getDefaultGeometry().getLocalName()), _factory.literal(pt))).features();
		try{
			log.info("location:" + pt.toText());
			if(_it.hasNext()){
				log.info("found feature");
				return _it.next();
			}
			else{
				log.info("not found feature");
				return null;
			}
		}
		finally{
			_it.close();
		}
	}
}
