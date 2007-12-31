package cn.geodata.models.landfire;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

import junit.framework.TestCase;

import org.geotools.data.FeatureSource;
import org.geotools.data.FeatureStore;
import org.geotools.data.FeatureWriter;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.factory.Hints;
import org.geotools.feature.AttributeType;
import org.geotools.feature.AttributeTypeFactory;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureType;
import org.geotools.feature.SchemaException;
import org.geotools.feature.type.GeometricAttributeType;
import org.geotools.geometry.GeneralDirectPosition;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.ReferencingFactoryFinder;
import org.geotools.referencing.factory.epsg.DefaultFactory;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.CoordinateOperation;
import org.opengis.referencing.operation.CoordinateOperationFactory;
import org.opengis.referencing.operation.MathTransform;

import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

public class CollectSamplesTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();
	
	public void testFindFireRegion() throws Exception {
		CollectSamples _o = new CollectSamples();
		
		Feature _fs = _o.findFireFeature("FS-0507-072-961018");
		Polygon _pt = _o.findFireRegion("FS-0507-072-961018");
		
		CoordinateReferenceSystem _co = _fs.getFeatureType().getDefaultGeometry().getCoordinateSystem();
		log.info("Co:" + _co.toWKT());
		assertNotNull(_fs);
		
		DefaultFactory _factory = (DefaultFactory) ReferencingFactoryFinder.getCRSAuthorityFactory("EPSG",
                new Hints(Hints.CRS_AUTHORITY_FACTORY, DefaultFactory.class));

		log.info(_co.toWKT());
		_co = CRS.decode("EPSG:42303");
//		_co = CRS.parseWKT(_co.toWKT());
		log.info(_co.toWKT());
		CoordinateReferenceSystem _target = CRS.decode("EPSG:4326");
		
		CoordinateOperationFactory _coFactory = ReferencingFactoryFinder.getCoordinateOperationFactory(GeoTools.getDefaultHints());
		CoordinateOperation _ch = _coFactory.createOperation(_co, _target);
		
		MathTransform _trans = _ch.getMathTransform();
		
		Polygon _poly = (Polygon) JTS.transform(_pt, _trans);
		for(int i=0;i<_poly.getExteriorRing().getNumPoints();i++){
			Point _p = _poly.getExteriorRing().getPointN(i);
			log.info(i + ":" + _p.getX() + "," + _p.getY());
		}
		
		ShapefileDataStore _dataStore = new ShapefileDataStore((new File("O:\\tank\\save\\java\\geoengine\\data\\tmp\\out2.shp")).toURL());
		
		FeatureType _featureType = CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints())
			.newFeatureType(new AttributeType[]{
					CommonFactoryFinder.getAttributeTypeFactory(GeoTools.getDefaultHints()).newAttributeType("shape", Polygon.class)
			}, "out2.shp");
		
		_dataStore.createSchema(_featureType);
		
		Feature _feature = _featureType.create(new Object[] {_poly});
		FeatureCollection _fs2 = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		_fs2.add(_feature);
		
		FeatureStore _writer = (FeatureStore) _dataStore.getFeatureSource();
		_writer.addFeatures(_fs2);
	}
	
	public void atestFindSamples() throws Exception {
		DatasetDNBR _dnbr = new DatasetDNBR();
		
		String _id = "FS-0507-072-961018";
		CollectSamples _o = new CollectSamples();
		
		Polygon _p = _o.findFireRegion(_id);
		int _count = (int)(_p.getArea() / 250000);
		
		log.info("Area:" + _p.getArea() + " count:" + _count);
		
		FeatureCollection _fs = _o.findSamples(_id, _count, 120);
		FeatureStore _store = this.getFeatureWriter();
		
		_store.addFeatures(_fs);
	}
	
	private FeatureStore getFeatureWriter() throws IOException, FactoryRegistryException, SchemaException {
		AttributeTypeFactory _factory = CommonFactoryFinder.getAttributeTypeFactory(GeoTools.getDefaultHints());
		AttributeType[] _attrs = new AttributeType[2];
		_attrs[0] = _factory.newAttributeType("shape", Point.class);
		_attrs[1] = _factory.newAttributeType("dnbr", Double.class);
		
		File _output = new File((new Configure()).getTempOutputPath(), (new Date()).getTime() + ".shp");
		ShapefileDataStore _dataStore = new ShapefileDataStore(_output.toURL());
		_dataStore.createSchema(CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType(_attrs, _output.getName()));
		
		return (FeatureStore) _dataStore.getFeatureSource();
	}
}
