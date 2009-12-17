package cn.geodata.models.wetland;

import java.io.File;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.TestCase;

import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureIterator;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.ReferencingFactoryFinder;
import org.opengis.feature.Feature;
import org.opengis.filter.FilterFactory2;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.CoordinateOperation;

import cn.geodata.models.raster.GeoRaster;

import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPolygon;

public class DemAnalysisTest extends TestCase {
	private Logger log = Logger.getAnonymousLogger();

	public void testTest1() throws Exception {
//		DemRaster _reader = new DemRaster(
//				new File("d:\\Tank\\Save\\Java\\geoengine\\src\\2.0\\trunk\\models\\ge-model.wetland\\src\\main\\resources\\wetland\\data\\dem").toURL(),
//				new File("d:\\Tank\\Save\\Java\\geoengine\\src\\2.0\\trunk\\models\\ge-model.wetland\\src\\main\\resources\\wetland\\data\\dem.hdr").toURL(),
//				1024 * 1024 * 2
//				);
		GeoRaster _reader = new GeoRaster(new File("d:\\Tank\\Data\\ecoserv\\dem\\ned10mbrwgs84.tif"), 0);
	
		DemAnalysis _dem = new DemAnalysis(_reader);
		
		FeatureSource _fs = new ShapefileDataStore(new File("d:\\Tank\\Save\\Java\\geoengine\\src\\2.0\\trunk\\models\\ge-model.wetland\\src\\main\\resources\\wetland\\data\\catchment.shp").toURL()).getFeatureSource();
		MultiPolygon _c = this.findCatchmentByTag(_fs, "P4");
		
		assertNotNull(_c);
		
//		log.info("Area " + Math.sqrt(this.calculateArea(_c)));
		log.info("Area2 " + Math.sqrt(_c.getArea()) / (Math.sqrt(this.calculateArea(_c)) / 1000));
		
		Extent _extent = _dem.calculateExtent(_c.getEnvelopeInternal());
		
		DecimalFormat _format = new DecimalFormat("0.000");
		log.info("area :" + _format.format(this.calculateArea(_c)));
		
		RasterCell _lowestC = _dem.calcuateLowest4Catchment(_c, _extent);
		assertNotNull(_lowestC);
		log.info("Lowest C Cell :" + _lowestC);

		RasterCell _lowestB = _dem.calculateLowest4Boundary((MultiLineString) _c.getBoundary(), _extent);
		assertNotNull(_lowestB);
		log.info("Lowest B Cell :" + _lowestB);
		
		double _spillPoint = _reader.getCell(_lowestB.getCol(), _lowestB.getRow()).doubleValue() - _reader.getCell(_lowestC.getCol(), _lowestC.getRow()).doubleValue();
		log.info("spill point " + _spillPoint);
	}
	
	public MultiPolygon findCatchmentByTag(FeatureSource catchments, String tag) throws NumberFormatException, Exception{
		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		FeatureIterator _it = catchments.getFeatures().features();
		try{
			log.info("tag:" + tag);
			while(_it.hasNext()){
				Feature _f = _it.next();
				String _tag = (String) _f.getProperty("NAME").getValue();
				if(_tag.trim().equals(tag)){
					log.info("found feature");
					return (MultiPolygon) _f.getDefaultGeometryProperty().getValue();
				}
			}

			log.info("not found feature:" + tag);
			throw new NullPointerException("Not found the Catchement");
		}
		finally{
			_it.close();
		}
	}
	
	private double calculateArea(MultiPolygon catchment){
		String _wkt = "PROJCS[\"Google Mercator\",GEOGCS[\"WGS 84\",DATUM[\"World Geodetic System 1984\",SPHEROID[\"WGS 84\",6378137.0,298.257223563,AUTHORITY[\"EPSG\",\"7030\"]],AUTHORITY[\"EPSG\",\"6326\"]],PRIMEM[\"Greenwich\",0.0,AUTHORITY[\"EPSG\",\"8901\"]],UNIT[\"degree\",0.017453292519943295],AXIS[\"Geodetic latitude\",NORTH],AXIS[\"Geodetic longitude\",EAST],AUTHORITY[\"EPSG\",\"4326\"]],PROJECTION[\"Mercator (1SP)\",AUTHORITY[\"EPSG\",\"9804\"]],PARAMETER[\"semi_major\",6378137.0],PARAMETER[\"semi_minor\",6378137.0],PARAMETER[\"latitude_of_origin\",0.0],PARAMETER[\"central_meridian\",0.0],PARAMETER[\"scale_factor\",1.0],PARAMETER[\"false_easting\",0.0],PARAMETER[\"false_northing\",0.0],UNIT[\"m\",1.0],AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH],AUTHORITY[\"EPSG\",\"900913\"]]";
		CoordinateReferenceSystem _google;
		try {
			_google = CRS.parseWKT(_wkt);

			CoordinateReferenceSystem _geo = CRS.decode("EPSG:4326", true);
			CoordinateOperation _operation = ReferencingFactoryFinder.getCoordinateOperationFactory(GeoTools.getDefaultHints()).createOperation(_geo, _google);
			
			return JTS.transform(catchment, _operation.getMathTransform()).getArea();
		} catch (Exception e) {
			log.log(Level.WARNING, "Error with calculating catchment area", e);
		}
		return 0;
	}


}
