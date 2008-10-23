package cn.geodata.models.glacier;

import java.io.File;

import org.geotools.data.FeatureStore;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.AttributeType;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureType;
import org.geotools.geometry.Envelope2D;
import org.geotools.referencing.CRS;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import cn.geodata.models.tools.Utilities;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import junit.framework.TestCase;

public class ProjectTransformModelTest extends TestCase {
	public void testTest1() throws Exception {
		double cellSize = 0.000249;
		Point _pt = (new GeometryFactory()).createPoint(new Coordinate(80.333326615, 41.826389655));
		
		Envelope2D _e = new Envelope2D(null, _pt.getX(), _pt.getY(), cellSize, cellSize);
		System.out.println(_e.getX());
		System.out.println(_e.getY());
		System.out.println(_e.getWidth());
		System.out.println(_e.getHeight());
		
		String _wkt = "PROJCS[\"Asia_North_Albers_Equal_Area_Conic\",GEOGCS[\"GCS_WGS_1984\",DATUM[\"D_WGS_1984\",SPHEROID[\"WGS_1984\",6378137.0,298.257223563]],PRIMEM[\"Greenwich\",0.0],UNIT[\"Degree\",0.0174532925199433]],PROJECTION[\"Albers\"],PARAMETER[\"False_Easting\",0.0],PARAMETER[\"False_Northing\",0.0],PARAMETER[\"Central_Meridian\",95.0],PARAMETER[\"Standard_Parallel_1\",15.0],PARAMETER[\"Standard_Parallel_2\",65.0],PARAMETER[\"Latitude_Of_Origin\",30.0],UNIT[\"Meter\",1.0]]";

		CoordinateReferenceSystem _sourcePrj = CRS.decode("EPSG:4326", true);
//		CoordinateReferenceSystem _targetPrj = CRS.decode("EPSG:21416");
		CoordinateReferenceSystem _targetPrj = CRS.parseWKT(_wkt);
		
		double _pixelArea = (new ProjectTransformModel(_sourcePrj, _targetPrj)).calculate(Utilities.covertEnvelope2D(new Envelope2D(null, _pt.getX(), _pt.getY(), cellSize, cellSize))).getArea();
		double _pixelLen1 = (new ProjectTransformModel(_sourcePrj, _targetPrj)).calculate((new GeometryFactory()).createLineString(new Coordinate[] {new Coordinate(80.333326615, 41.826389655), new Coordinate(80.333326615 + cellSize, 41.826389655)})).getLength();
		double _pixelLen2 = (new ProjectTransformModel(_sourcePrj, _targetPrj)).calculate((new GeometryFactory()).createLineString(new Coordinate[] {new Coordinate(80.333326615, 41.826389655), new Coordinate(80.333326615, 41.826389655 + cellSize)})).getLength();
//		double _pixelArea = (new ProjectTransformModel("EPSG:4326", "EPSG:32644")).calculate(Utilities.covertEnvelope2D(new Envelope2D(null, _pt.getX(), _pt.getY(), cellSize, cellSize))).getArea();

		System.out.println(_pixelArea);
		System.out.println(_pixelLen1);
		System.out.println(_pixelLen2);
		
//		Polygon _box = Utilities.covertEnvelope2D(new Envelope2D(null, _pt.getX(), _pt.getY(), cellSize, cellSize));
		Polygon _box = (Polygon) (new ProjectTransformModel(_sourcePrj, _targetPrj)).calculate(Utilities.covertEnvelope2D(new Envelope2D(null, _pt.getX(), _pt.getY(), cellSize, cellSize)));
		
		AttributeType[] _atts = new AttributeType[2];
		_atts[0] = (CommonFactoryFinder.getAttributeTypeFactory(GeoTools.getDefaultHints()).newAttributeType("Shape", Polygon.class));
		_atts[1] = (CommonFactoryFinder.getAttributeTypeFactory(GeoTools.getDefaultHints()).newAttributeType("Test", Double.class));
		
		FeatureType _ft = (CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType(_atts, "project1.shp"));
		FeatureCollection _fc = (CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection());
		
		_fc.add(_ft.create(new Object[]{_box, 10}));
		
		ShapefileDataStore _fs = new ShapefileDataStore(new File("D:\\Temp\\data3\\20081010\\shp\\test.shp").toURL());
		_fs.createSchema(_ft);
		FeatureStore _store = (FeatureStore) _fs.getFeatureSource();

		_store.addFeatures(_fc);
	}
}
