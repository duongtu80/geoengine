package cn.geodata.models.landfire;

import java.io.File;
import java.util.logging.Logger;

import org.geotools.factory.Hints;
import org.geotools.gce.geotiff.GeoTiffReader;

import junit.framework.TestCase;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class DatasetDNBRTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();
	
	public void atestGeoTiff() throws Exception {
		GeoTiffReader _reader = new GeoTiffReader(new File("o:\\tank\\tmp\\test2\\ace.tiff"), new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE));
		assertNotNull(_reader);
	}

	public void testGetAtLocation() throws Exception {
		GeometryFactory _factory = new GeometryFactory();
		
		DatasetDNBR _dnbr = new DatasetDNBR();
		Point _pt = _factory.createPoint(new Coordinate(-2264945.9, 1776611.26));
		
		log.info("Value:" + _dnbr.getAtLocation("FS-0507-072-961018", _pt));
	}
}
