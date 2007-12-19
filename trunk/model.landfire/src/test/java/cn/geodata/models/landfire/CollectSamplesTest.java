package cn.geodata.models.landfire;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
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
import com.vividsolutions.jts.geom.Polygon;

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
		
		Polygon _p = _o.findFireRegion(_id);
		int _count = (int)(_p.getArea() / 250000);
		
		log.info("Area:" + _p.getArea() + " count:" + _count);
		
		List<Point> _list = _o.findSamples(_id, _count, 120);
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
		
		File _output = new File((new Configure()).getTempOutputPath(), (new Date()).getTime() + ".shp");
		ShapefileDataStore _dataStore = new ShapefileDataStore(_output.toURL());
		_dataStore.createSchema(CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType(_attrs, _output.getName()));
		
		return (FeatureStore) _dataStore.getFeatureSource();
	}
}
