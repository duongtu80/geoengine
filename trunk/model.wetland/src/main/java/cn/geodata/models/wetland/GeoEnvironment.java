package cn.geodata.models.wetland;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;

import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;

/**
 * @author mfeng
 *
 */
public class GeoEnvironment {
	private static Logger log = Logger.getAnonymousLogger();
	
	private String geoserver;
	private String wetland;
	private FeatureSource featureSource;
	
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
	
	public FeatureSource getFeatureSource() throws MalformedURLException, IOException {
		if(this.featureSource == null)
			this.featureSource = new ShapefileDataStore(new File(new File(this.getGeoserver()), this.getWetland()).toURL()).getFeatureSource();
		
		return this.featureSource;		
	}
}
