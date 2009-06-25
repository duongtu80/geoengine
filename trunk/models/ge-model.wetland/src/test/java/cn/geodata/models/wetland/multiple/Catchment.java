package cn.geodata.models.wetland.multiple;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.GeoTools;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureIterator;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.ReferencingFactoryFinder;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.CoordinateOperation;

import cn.geodata.models.wetland.DemAnalysis;
import cn.geodata.models.wetland.DemRaster;
import cn.geodata.models.wetland.Extent;
import cn.geodata.models.wetland.RasterCell;

import com.vividsolutions.jts.geom.MultiPolygon;

/**
 * Catchment of a wetland 
 * 
 * @author tank
 *
 */
public class Catchment {
	private Logger log = Logger.getAnonymousLogger();
	
	private MultiPolygon region;
	private DemRaster dem;
	private String code;
	private double bottomElevation;
	
	public Catchment(DemRaster dem, MultiPolygon region, String code) throws IOException{
		log.info("Create catchment " + code);
		this.dem = dem;
		this.region = region;
		this.code = code;
		
		this.bottomElevation = this.calBottomElevation();
	}
	
	private double calBottomElevation() throws IOException{
		DemAnalysis _dem = new DemAnalysis(this.dem);
		Extent _extent = _dem.calculateExtent(this.region.getEnvelopeInternal());
		
		RasterCell _lowestC = _dem.calcuateLowest4Catchment(this.region, _extent);
		return this.dem.getRaster().readFloat(_lowestC.getRow(), _lowestC.getCol());
	}
	
	/**
	 * Get region
	 * 
	 * @return
	 */
	public MultiPolygon getRegion() {
		return region;
	}

	/**
	 * Load dem
	 * 
	 * @return
	 */
	public DemRaster getDem() {
		return dem;
	}
	
	/**
	 * Catchment code
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Get area under Google Mercator projection
	 * 
	 * @return
	 */
	public double getArea() {
		return this.projectCatchment(this.region).getArea();
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

	
	/**
	 * Load bottom elevation
	 * 
	 * @return
	 */
	public double getBottomElevation() {
		return bottomElevation;
	}
	
	/**
	 * Load all catchments
	 * 
	 * @param dem
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static List<Catchment> loadCatchments(DemRaster dem) throws MalformedURLException, IOException{
		List<Catchment> _cats = new ArrayList<Catchment>();
		
		FeatureIterator _it = new ShapefileDataStore(Catchment.class.getResource("/wetland/data/catchment.shp")).getFeatureSource().getFeatures().features();
		try{
			while(_it.hasNext()){
				Feature _f = _it.next();
				try{
					_cats.add(new Catchment(dem, (MultiPolygon) _f.getDefaultGeometry(), (String)_f.getAttribute("NAME")));
				}
				catch(IndexOutOfBoundsException e){
					Logger.getAnonymousLogger().info("Load " + _f.getAttribute("NAME") + " failed because out the raster boundary");
				}
			}
		}
		finally{
			_it.close();
		}
		
		return _cats;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Catchment) {
			Catchment _c = (Catchment) obj;
			if(_c.getCode().equalsIgnoreCase(this.getCode())){
				return true;
			}
		}
		
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return this.code;
	}
}
