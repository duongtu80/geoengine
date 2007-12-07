package cn.geodata.model.client;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import junit.framework.TestCase;
import net.opengeospatial.wps.ExecuteResponseDocument;
import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.InputDescriptionType;
import net.opengeospatial.wps.ProcessBriefType;
import net.opengeospatial.wps.ProcessDescriptionType;

import org.geotools.data.FeatureStore;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.feature.AttributeType;
import org.geotools.feature.AttributeTypeFactory;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureIterator;
import org.geotools.feature.FeatureType;
import org.geotools.feature.FeatureTypeFactory;
import org.geotools.feature.SchemaException;

import cn.geodata.models.value.ModelValueParserFinder;
import cn.geodata.models.value.ModelValueUtil;
import cn.geodata.models.wps.WpsClient;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

public class BufferClientTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();

	public void stestTest2() throws Exception {
		WpsClient _client = new WpsClient(new URI("http://127.0.0.1:8080/web/wps"));
		for(ProcessBriefType _process : _client.getCapibilities().getCapabilities().getProcessOfferings().getProcessArray()){
			log.info(_process.getTitle());
		}
	}
	
	public void testSwampCities() throws Exception {
		WpsClient _client = new WpsClient(new URI("http://127.0.0.1:8080/web/wps"));

		String _dataUrl = "http://127.0.0.1:18080/geoserver/wfs";
		double _seaLevel = 5;
		
		org.apache.xml.utils.URI _citiesUrl = new org.apache.xml.utils.URI(_dataUrl);
		_citiesUrl.setQueryString("service=WFS&request=GetFeature&typename=unep:cities");

		log.info("Cities url:" + _citiesUrl.toString());

		ProcessDescriptionType _processDesc = _client.describeProcess(new String[]{"swamp.cities"}).getProcessDescriptions().getProcessDescriptionArray(0);
		
		Map<String, InputDescriptionType> _inputDefinitions = new HashMap<String, InputDescriptionType>();
		for(InputDescriptionType _inputType : _processDesc.getDataInputs().getInputArray()){
			_inputDefinitions.put(_inputType.getIdentifier().getStringValue(), _inputType);
		}

		ModelValueParserFinder _finder = ModelValueUtil.createParserFinder();
		
		List<IOValueType> _inputs = new ArrayList<IOValueType>();
		
		IOValueType _paramRise = ModelValueUtil.createInputValue(_inputDefinitions.get("rise"));
		_paramRise.setLiteralValue(_finder.getDefaultLiteralEncoder().encodeLiteral(_seaLevel));
		_inputs.add(_paramRise);
		
		IOValueType _paramCities = ModelValueUtil.createInputValue(_inputDefinitions.get("cities"));
		_paramCities.setComplexValueReference(_finder.getDefaultComplexReferenceEncoder().encodeGMLUrl(_citiesUrl.toString(), "utf-8"));
		_inputs.add(_paramCities);
		
		ExecuteResponseDocument _execute = _client.execute(_processDesc.getIdentifier().getStringValue(), _inputs.toArray(new IOValueType[0]));		

//		ModelValue[] _inputs = new ModelValue[2];
//		_inputs[0] = new LiteralValue("rise", "rise", "", 5.0);
//		_inputs[1] = new ComplexValueReference("cities", "cities", "", "http://152.61.40.52:18080/geoserver/wfs?service=WFS&version=1.1.0&request=GetFeature&typename=unep:cities", "text/gml", "utf-8", null);
//		
//		ExecuteResponseDocument _execute = _client.execute("SwampCities", _inputs);
		log.info(_execute.getExecuteResponse().xmlText());
	}
	
	public void atestBuffer() throws Exception {
//		WpsClient _client = new WpsClient(new URI("http://127.0.0.1:8080/web/wps"));
//		ModelValue[] _inputs = new ModelValue[2];
//		_inputs[0] = new LiteralValue("Distance", "Distance", "", 1f);
//		
//		GeometryFactory _factory = new GeometryFactory();
//		
//		LinearRing _ring = _factory.createLinearRing(new Coordinate[]{
//				new Coordinate(0, 0, 0),
//				new Coordinate(10, 0, 0),
//				new Coordinate(10, 10, 0),
//				new Coordinate(10, 0, 0),
//				new Coordinate(0, 0, 0)
//			});
//		_inputs[1] = new ComplexValue("Geometry", "", "", _factory.createPolygon(_ring, null));
//		
//		ExecuteResponseDocument _execute = _client.execute("Buffer", _inputs);
//		
//		ComplexValue _output = (ComplexValue) ValueParser.parse(_execute.getExecuteResponse().getProcessOutputs().getOutputArray(0));
//		Polygon _outputs = (Polygon)_output.getValue();
//		System.out.println("Output count:" + _outputs.getNumPoints());
//		
//		FeatureStore _outputStore = this.createOutputShapeFile();
//		FeatureType _outFeatureType = _outputStore.getSchema();
//		
//		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
//		
//		for(int i=0;i<_outputs.getNumGeometries();i++){
//			_fs.add(_outFeatureType.create(new Object[] {_outputs, "Test" + i}));
//		}
//		
//		_outputStore.addFeatures(_fs);
	}
	
	public void atestTest1() throws Exception {
//		ShapefileDataStoreFactory _factory = new ShapefileDataStoreFactory();
//		Map _inputParams = new HashMap();
//		
//		_inputParams.put(ShapefileDataStoreFactory.DBFCHARSET.key, "GB2312");
//		_inputParams.put(ShapefileDataStoreFactory.URLP.key, new URL("file://D:/mfeng/tmp/wps/data/buffer.shp"));
//		ShapefileDataStore _inputDataStore = (ShapefileDataStore) _factory.createDataStore(_inputParams);
//
//		FeatureStore _outputStore = this.createOutputShapeFile();
//		FeatureType _outFeatureType = _outputStore.getSchema();
//	
//		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
//		
//		WpsClient _client = new WpsClient(new URI("http://127.0.0.1:8080/web/wps"));
//		ModelValue[] _inputs = new ModelValue[2];
//		_inputs[0] = new LiteralValue("Distance", "Distance", "", 0.1f);
//		FeatureIterator _it = _inputDataStore.getFeatureSource().getFeatures().features();
//		
//		Collection<Polygon> _polygons = new ArrayList<Polygon>();
//		int _pos = 0;
//		while(_it.hasNext()){
//			Feature _f = _it.next();
//			MultiPolygon _multiPolygon = (MultiPolygon) _f.getDefaultGeometry();
//			if(_multiPolygon.getNumGeometries() == 1){
//				_polygons.add((Polygon)_multiPolygon.getGeometryN(0));
//			}
////			System.out.println(_f.getDefaultGeometry().getClass().getName());
////			Geometry _geometry = _f.getDefaultGeometry().buffer(0.0001);
////			if (_geometry instanceof Polygon) {
////				Polygon _polygon = (Polygon) _geometry;
////				
////			}
////			else{
////				System.out.println(_geometry.getClass().getName());
////			}
////			_inputs[1] = new ComplexValue("Geometry", "Geometry", "", _f.getDefaultGeometry());
////			ExecuteResponseDocument _execute = _client.execute("Buffer", _inputs);
////			
////			ComplexValue _output = (ComplexValue) ValueParser.parse(_execute.getExecuteResponse().getProcessOutputs().getOutputArray(0));
////			System.out.println(_output.getValue().getClass().getName());
////			Polygon _outputValue = (Polygon) _output.getValue();
////			System.out.println("point count:" + _outputValue.getNumPoints());
////			_fs.add(_outFeatureType.create(new Object[] {_output.getValue(), _pos}));
//			
//			if(_pos == 0){
//				break;
//			}
//			System.out.println("pos:" + _pos++);
////			break;
//		}
//
//		assertTrue(_polygons.size() > 0);
//		_inputs[1] = new ComplexValue("Geometry", "Geometry", "", (new GeometryFactory()).createMultiPolygon(_polygons.toArray(new Polygon[0])));
//		ExecuteResponseDocument _execute = _client.execute("Buffer", _inputs);
//		
//		ComplexValue _output = (ComplexValue) ValueParser.parse(_execute.getExecuteResponse().getProcessOutputs().getOutputArray(0));
//		MultiPolygon _outputs = (MultiPolygon)_output.getValue();
//		System.out.println("Output count:" + _outputs.getNumGeometries());
//		for(int i=0;i<_outputs.getNumGeometries();i++){
//			_fs.add(_outFeatureType.create(new Object[] {_outputs.getGeometryN(i), "Test" + i}));
//		}
//		
//		_outputStore.addFeatures(_fs);
//		_it.close();
	}
	
	public FeatureStore createOutputShapeFile() throws IOException, FactoryRegistryException, SchemaException{
		ShapefileDataStoreFactory _factory = new ShapefileDataStoreFactory();
		Map _inputParams = new HashMap();
		_inputParams.put(ShapefileDataStoreFactory.DBFCHARSET.key, "GB2312");
		_inputParams.put(ShapefileDataStoreFactory.URLP.key, new URL("file://D:/mfeng/tmp/wps/data/buffer.shp"));
		
		ShapefileDataStore _outputDataStore = (ShapefileDataStore) _factory.createNewDataStore(_inputParams);
		
		FeatureTypeFactory _featureTypeFactory = CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints());
		AttributeTypeFactory _attributeTypeFactory = CommonFactoryFinder.getAttributeTypeFactory(GeoTools.getDefaultHints());
		
		List<AttributeType> _attrs = new ArrayList<AttributeType>();
		_attrs.add(_attributeTypeFactory.newAttributeType("shape", Polygon.class));
		_attrs.add(_attributeTypeFactory.newAttributeType("test", String.class, true, 50));
		
		FeatureType _featureType = _featureTypeFactory.newFeatureType(_attrs.toArray(new AttributeType[0]), "out2");
		_outputDataStore.createSchema(_featureType);
		
		return (FeatureStore)_outputDataStore.getFeatureSource();
	}
	
	public void atestTest2() throws Exception {
		ShapefileDataStoreFactory _factory = new ShapefileDataStoreFactory();
		Map _inputParams = new HashMap();
		_inputParams.put(ShapefileDataStoreFactory.DBFCHARSET.key, "GB2312");
		_inputParams.put(ShapefileDataStoreFactory.URLP.key, new URL("file://o:/tank/data/temp/bou2_4p.shp"));
		ShapefileDataStore _inputDataStore = (ShapefileDataStore) _factory.createDataStore(_inputParams);
		
		int _polygonCount = 0;
		int _pointCount = 0;
		FeatureIterator _it = _inputDataStore.getFeatureSource().getFeatures().features();
		while(_it.hasNext()){
			Feature _f = _it.next();
			MultiPolygon _multiPolygon = (MultiPolygon)_f.getDefaultGeometry();
			_polygonCount += _multiPolygon.getNumGeometries();
			_pointCount += _multiPolygon.getNumPoints();
		}
		
		System.out.println("Polygon count:" + _polygonCount);
		System.out.println("Point count:" + _pointCount);
	}
}
