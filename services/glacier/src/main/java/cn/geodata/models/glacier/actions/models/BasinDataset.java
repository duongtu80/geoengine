package cn.geodata.models.glacier.actions.models;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.logging.Logger;

import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.simple.SimpleFeature;

import com.vividsolutions.jts.geom.MultiPolygon;

public class BasinDataset {
	private Logger log = Logger.getAnonymousLogger();
	
	private FeatureSource featureSource;
	private String fieldName;
	
	public BasinDataset(String fieldName) throws MalformedURLException, IOException{
		this.featureSource = new ShapefileDataStore(BasinDataset.class.getResource("/glacier/basin.shp"), false, Charset.forName("gb2312"))
				.getFeatureSource();
		
		this.fieldName = fieldName;
	}
	
	public FeatureCollection getBasins() throws IOException{
		return this.featureSource.getFeatures();
	}
	
	public MultiPolygon getBasin(String name) throws IOException{
		log.info("Looking for:|" + name + "|");
		
		FeatureIterator _it = this.featureSource.getFeatures().features();
		try {
			while (_it.hasNext()) {
				SimpleFeature _f = (SimpleFeature) _it.next();
				String _station = _f.getAttribute(fieldName).toString().trim();
				if (_station.equalsIgnoreCase(name)) {
					return (MultiPolygon) _f.getDefaultGeometry();
				}
			}
		} finally {
			_it.close();
		}
		log.warning("Failed to find basin with name " + name);
		
		return null;
	}
}
