package cn.geodata.models;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.geotools.data.FeatureStore;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.feature.AttributeType;
import org.geotools.feature.AttributeTypeFactory;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureType;
import org.geotools.feature.IllegalAttributeException;
import org.geotools.feature.SchemaException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;

import cn.geodata.models.annotation.GeoProcess;
import cn.geodata.models.container.MemeryContainer;

import net.opengis.wps.x100.DescribeProcessDocument;

import junit.framework.TestCase;

public class ProcessLibraryTest extends TestCase {
	public void atestloadModels() throws Exception {
		ProcessLibrary _lib = ProcessLibrary.createInstance();
		Map<String, Class> _ps = _lib.getModelList();
		
//		for(String _k : _ps.keySet()){
//			System.out.println(_k + ":" + _ps.get(_k).getName());
//		}
//		

		MemeryContainer _container = new MemeryContainer();
		Processing _b = _lib.createProcess("TestModel");
		
//		GeometryFactory _factory = new GeometryFactory();
//		_b.setInput("Point", _factory.createPoint(new Coordinate(100, 40)));
		
		_lib.executeProcess(_container, _b);
		
		while(_b.getStatus().getPercent() < 100){
			System.out.println(_b.getStatus().getPercent());
			Thread.sleep(100);
		}
	}
	
	public void atestModelTest() throws Exception {
		ProcessLibrary _lib = ProcessLibrary.createInstance();
		Map<String, Class> _ps = _lib.getModelList();

		for(String _k : _ps.keySet()){
			System.out.println(_k);
//			Processing _p = _lib.createProcess(_k);
			GeoProcess _p = _lib.getProcessMetadata(_ps.get(_k));
			
			Map<String, Method> _inputs = _lib.getInputs(_ps.get(_k));
			for(String _i: _inputs.keySet()){
				Class _it = _lib.getInputType(_inputs.get(_i));
				System.out.println("  " + _i + "|" + _it.getCanonicalName());
			}
			
			System.out.println("  ------------");
			Map<String, Method> _outputs = _lib.getOutputs(_ps.get(_k));
			for(String _o: _outputs.keySet()){
				Class _ot = _lib.getOutputType(_outputs.get(_o));
				System.out.println("  " + _o + "|" + _ot.getCanonicalName());
			}
			
//			break;
		}
	}
	
	public void testModelTest2() throws Exception {
		ProcessLibrary _lib = ProcessLibrary.createInstance();
		Map<String, Class> _ps = _lib.getModelList();
		
//		Class _p = _ps.get("WaterRegionModel");
		Processing _p = _lib.createProcess("WaterRegionModel");
		_p.setInput("WaterLevel", 17.78);
		Feature _f = (Feature) new ShapefileDataStore(new File("c:\\mfeng\\codes\\java\\geoengine\\src\\geoengine\\services\\wetland\\src\\main\\resources\\wetland-data\\shp\\catchment.shp").toURL()).getFeatureSource().getFeatures().toArray(new Feature[0])[15];
		_p.setInput("Catchment", _f.getDefaultGeometry());
		_p.run();
		
		MultiPolygon _ww = (MultiPolygon) _p.getOutput("WaterRegion");
		this.saveMultiPolygon(new File("c:\\mfeng\\tmp\\test5.shp"), _ww);
	}
	
	protected void saveMultiPolygon(File f, MultiPolygon polygon) throws Exception {
		AttributeType[] _attrs = new AttributeType[2];
		_attrs[0] = AttributeTypeFactory.newAttributeType("geom", MultiPolygon.class);
		_attrs[1] = AttributeTypeFactory.newAttributeType("test1", Double.class);
		
		FeatureType _ft = CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType(_attrs, "test", new URI("http://www.geodata.cn"));
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		if(polygon != null){
			_fs.add(_ft.create(new Object[] {polygon, 2}));
			
			ShapefileDataStore _ss = new ShapefileDataStore(f.toURL());
			_ss.createSchema(_ft);
			
			FeatureStore _fo = (FeatureStore) _ss.getFeatureSource();
			_fo.addFeatures(_fs);
			_ss.dispose();
		}
		else{
			throw new NullPointerException("No multipolygon");
		}
	}
}
