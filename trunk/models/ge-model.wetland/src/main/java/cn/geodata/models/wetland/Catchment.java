package cn.geodata.models.wetland;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
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
	
	private String fieldName;
	private FeatureSource catchments;

	public Catchment(String shpUrl) throws MalformedURLException, IOException{
		String[] _fileList = new String[] {"catchment.dbf", "catchment.prj", "catchment.sbn", "catchment.sbx", "catchment.shp", "catchment.shx", "catchment.xml"};
		File _temp = new File(System.getProperty("java.io.tmpdir"));
		
		for(String _f : _fileList){
			File _file = new File(_temp, _f);
			if(_file.exists() == false || _file.length() == 0){
				IOUtils.copy(Catchment.class.getResourceAsStream(shpUrl + _f), new FileOutputStream(_file));
			}
		}
		
		this.catchments = (new ShapefileDataStore((new File(_temp, "catchment").toURL()))).getFeatureSource();
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

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
		FeatureIterator _it = this.catchments.getFeatures().features();
		try{
			log.info("tag:" + tag);
			while(_it.hasNext()){
				Feature _f = _it.next();
				String _tag = (String) _f.getAttribute(this.fieldName);
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

	public Feature findWetland(Point pt) throws IOException {
		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		FeatureIterator _it = this.catchments.getFeatures(_factory.contains(_factory.property(this.catchments.getSchema().getDefaultGeometry().getLocalName()), _factory.literal(pt))).features();
		try{
			log.info("location:" + pt.toText());
			if(_it.hasNext()){
				log.info("found feature");
				return _it.next();
			}
			
			log.info("not found feature:" + pt);
			return null;
		}
		finally{
			_it.close();
		}
	}
}
