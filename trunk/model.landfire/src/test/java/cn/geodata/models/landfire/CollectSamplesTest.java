package cn.geodata.models.landfire;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Logger;

import org.geotools.data.FeatureStore;
import org.geotools.data.FeatureWriter;
import org.geotools.data.Transaction;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.feature.AttributeType;
import org.geotools.feature.AttributeTypeFactory;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.SchemaException;

import com.vividsolutions.jts.geom.Point;

import junit.framework.TestCase;

public class CollectSamplesTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();
	
	public void atestFindFireRegion() throws Exception {
		CollectSamples _o = new CollectSamples();
		assertNotNull(_o.findFireRegion("FS-0507-072-961018"));
	}
	
	public void testFindSamples() throws Exception {
		DatasetDNBR _dnbr = new DatasetDNBR();
		
		String _id = "FS-0507-072-961018";
		CollectSamples _o = new CollectSamples();
		
		List<Point> _list = _o.findSamples(_id, 20, 120);
		FeatureStore _store = this.getFeatureWriter();
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		for(Point _pt : _list){
			_fs.add(_store.getSchema().create(new Object[]{_pt, _dnbr.getAtLocation(_id, _pt)}));
		}
		
		_store.addFeatures(_fs);
	}
	
	private FeatureStore getFeatureWriter() throws IOException, FactoryRegistryException, SchemaException {
		AttributeTypeFactory _factory = CommonFactoryFinder.getAttributeTypeFactory(GeoTools.getDefaultHints());
		AttributeType[] _attrs = new AttributeType[2];
		_attrs[0] = _factory.newAttributeType("shape", Point.class);
		_attrs[1] = _factory.newAttributeType("dnbr", Double.class);
		
		ShapefileDataStore _dataStore = new ShapefileDataStore((new File("O:\\tank\\save\\java\\geoengine\\data\\tmp\\out.shp").toURL()));
		_dataStore.createSchema(CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType(_attrs, "out.shp"));
		
		return (FeatureStore) _dataStore.getFeatureSource();
	}
}
