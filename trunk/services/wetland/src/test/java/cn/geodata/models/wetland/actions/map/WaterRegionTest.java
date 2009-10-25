package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.geotools.data.FeatureStore;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.feature.AttributeType;
import org.geotools.feature.AttributeTypeFactory;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureTypeFactory;
import org.geotools.feature.SchemaException;
import org.opengis.feature.type.FeatureType;

import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;
import cn.geodata.models.geojson.GeoJSON;

import com.vividsolutions.jts.geom.MultiPolygon;

import junit.framework.TestCase;

public class WaterRegionTest extends TestCase {
	public void testTest1() throws Exception {
//		Properties _ps = System.getProperties();
//		for(Object _k : _ps.keySet()){
//			System.out.println(_k + "=" + _ps.get(_k));
//		}
//		
//		System.out.println(System.getProperty("java.io.tmpdir"));
		Catchment _catchment = new Catchment();
		MultiPolygon _p = _catchment.findCatchmentByTag("P1");
		
		ProcessLibrary _library = ProcessLibrary.createInstance();

		Processing _model = _library.createProcess("WaterRegionModel");
		
		for(int i=1;i<40;i+=5){
			_library.setInput(_model, "WaterLevel", i * 0.1);
			_library.setInput(_model, "Catchment", _p);
			_library.executeProcess(_model);
			
			org.geotools.feature.FeatureType _featureType = this.createFeatureType();
			FeatureCollection _region = (FeatureCollection) _library.getOutput(_model, "WaterRegion");
			
			new ShapefileDataStore(new File("c:\\mfeng\\data\\tmp1\\" + i + ".shp").toURL()).createSchema(_featureType);
			FeatureStore _fs = (FeatureStore) new ShapefileDataStore(new File("c:\\mfeng\\data\\tmp1\\" + i + ".shp").toURL()).getFeatureSource();
			_fs.addFeatures(_region);
		}
	}
	
	private org.geotools.feature.FeatureType createFeatureType() throws FactoryRegistryException, SchemaException{
		FeatureTypeFactory _factory = CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints());
		
		AttributeType[] _attrs = new AttributeType[3];
		_attrs[0] = AttributeTypeFactory.newAttributeType("geom", MultiPolygon.class);
		_attrs[1] = AttributeTypeFactory.newAttributeType("deep", Float.class);
		_attrs[2] = AttributeTypeFactory.newAttributeType("code", String.class, true, 20);		
		
		return _factory.newFeatureType(_attrs , "test");
	}
}
