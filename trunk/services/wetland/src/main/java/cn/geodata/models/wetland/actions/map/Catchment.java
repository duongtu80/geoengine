package cn.geodata.models.wetland.actions.map;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.ReferencingFactoryFinder;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.filter.FilterFactory2;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.CoordinateOperation;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

public class Catchment {
	private Logger log = Logger.getAnonymousLogger();
	
	private String fieldName;
	private FeatureSource features;

	public Catchment() throws MalformedURLException, IOException{
		this.features = new ShapefileDataStore(Catchment.class.getResource("/wetland-data/shp/catchment.shp")).getFeatureSource();
		this.fieldName = "NAME";
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public FeatureSource getFeatures() {
		return features;
	}

	public String findCatchment(double x, double y) throws Exception {
		GeometryFactory _factory = new GeometryFactory();
		Point _pt = _factory.createPoint(new Coordinate(x, y)); 
		
		SimpleFeature _f = this.findWetland(_pt);
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
		FeatureIterator _it = this.features.getFeatures().features();
		try{
			log.info("tag:" + tag);
			while(_it.hasNext()){
				SimpleFeature _f = (SimpleFeature) _it.next();
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

	public SimpleFeature findWetland(Point pt) throws IOException {
		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		FeatureIterator _it = this.features.getFeatures(_factory.contains(_factory.property(this.features.getSchema().getGeometryDescriptor().getLocalName()), _factory.literal(pt))).features();
		try{
			log.info("location:" + pt.toText());
			if(_it.hasNext()){
				log.info("found feature");
				return (SimpleFeature) _it.next();
			}
			
			log.info("not found feature:" + pt);
			return null;
		}
		finally{
			_it.close();
		}
	}
	
	public FeatureCollection getCatchments() throws IOException {
		return this.features.getFeatures();
	}
	
	/**
	 * Project the catchment to Google Mercator Projection
	 * 
	 * @param catchment
	 * @return
	 */
	public MultiPolygon projectCatchment(MultiPolygon catchment){
		String _wkt = "PROJCS[\"Google Mercator\",GEOGCS[\"WGS 84\",DATUM[\"World Geodetic System 1984\",SPHEROID[\"WGS 84\",6378137.0,298.257223563,AUTHORITY[\"EPSG\",\"7030\"]],AUTHORITY[\"EPSG\",\"6326\"]],PRIMEM[\"Greenwich\",0.0,AUTHORITY[\"EPSG\",\"8901\"]],UNIT[\"degree\",0.017453292519943295],AXIS[\"Geodetic latitude\",NORTH],AXIS[\"Geodetic longitude\",EAST],AUTHORITY[\"EPSG\",\"4326\"]],PROJECTION[\"Mercator (1SP)\",AUTHORITY[\"EPSG\",\"9804\"]],PARAMETER[\"semi_major\",6378137.0],PARAMETER[\"semi_minor\",6378137.0],PARAMETER[\"latitude_of_origin\",0.0],PARAMETER[\"central_meridian\",0.0],PARAMETER[\"scale_factor\",1.0],PARAMETER[\"false_easting\",0.0],PARAMETER[\"false_northing\",0.0],UNIT[\"m\",1.0],AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH],AUTHORITY[\"EPSG\",\"900913\"]]";
		CoordinateReferenceSystem _google;
		try {
			_google = CRS.parseWKT(_wkt);

			CoordinateReferenceSystem _geo = CRS.decode("EPSG:4326", true);
			CoordinateOperation _operation = ReferencingFactoryFinder.getCoordinateOperationFactory(GeoTools.getDefaultHints()).createOperation(_geo, _google);
			
			return (MultiPolygon) JTS.transform(catchment, _operation.getMathTransform());
		} catch (Exception e) {
			log.log(Level.WARNING, "Error with calculating catchment area", e);
		}
		return catchment;
	}
}
