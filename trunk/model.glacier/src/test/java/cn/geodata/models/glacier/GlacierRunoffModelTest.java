package cn.geodata.models.glacier;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.geotools.data.FeatureSource;
import org.geotools.data.wfs.WFSDataStore;
import org.geotools.data.wfs.WFSDataStoreFactory;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureIterator;
import org.geotools.feature.FeatureType;
import org.opengis.filter.FilterFactory2;
import org.opengis.filter.Id;
import org.opengis.filter.identity.Identifier;
import org.opengis.filter.spatial.BBOX;
import org.opengis.filter.spatial.Equals;

import cn.geodata.models.tools.WfsFeatureSource;
import cn.geodata.models.tools.raster.RasterManager;
import junit.framework.TestCase;

public class GlacierRunoffModelTest extends TestCase {
	public void atestTest1() throws Exception {
		String _txt = "1	ÎÚÂ³Ä¾Æë1ºÅ±ù´¨	43.089	86.825	3.1";
//		String _txt = "1	ss	43.089 	86.825";
		Pattern _pattern = Pattern.compile("(\\d+)[,\\s](\\S+)[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)");
//		Pattern _pattern = Pattern.compile("(\\d+)\\s(\\S+)\\s([\\d\\.]+)\\s([\\d\\.]+)");
		
		Matcher _m = _pattern.matcher(_txt);
		if(_m.find()){
			System.out.println(_m.group(1));
		}
		else{
			System.out.println("failed");
		}
	}
	
	public void atestTest3() throws Exception {
		WFSDataStoreFactory _factory = new WFSDataStoreFactory();
		
		Map<String, Object> _params = new HashMap<String, Object>();
		_params.put(_factory.URL.key, new URL("http://127.0.0.1:48080/geoserver/wfs"));
		_params.put(_factory.TIMEOUT.key, new Integer(60000));
		_params.put(_factory.PROTOCOL.key, false);
		
		WFSDataStore _dataStore = (WFSDataStore) _factory.createDataStore(_params);
		for(String _schema : _dataStore.getTypeNames()){
			System.out.println(_schema);
		}
			
		FeatureSource _fs = _dataStore.getFeatureSource("geo:basin");
		assertNotNull(_fs);
		FeatureType _ft = _fs.getSchema();
		assertNotNull(_ft);
		
		FilterFactory2 _filterFactory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		
//		Set<Identifier> _ids = new HashSet<Identifier>();
//		_ids.add(_filterFactory.featureId("province.6"));
//		_ids.add(_filterFactory.featureId("province.53"));
//
//		Id _filter = _filterFactory.id(_ids);
//		BBOX _filter = _filterFactory.bbox(_filterFactory.property(_ft.getDefaultGeometry().getLocalName()), 110, 23, 111, 24, null);
//		Equals _filter = _filterFactory.equal(_filterFactory.property("NAME"), _filterFactory.literal("ÉÏº£ÊÐ"));
//		FeatureIterator _it = _fs.getFeatures(_filter).features();
		FeatureIterator _it = _fs.getFeatures().features();
		while(_it.hasNext()){
			Feature _f = _it.next();
			System.out.println(_f.getID() + "\t" + _f.getAttribute("NAME"));
			assertNotNull(_f.getDefaultGeometry().getEnvelopeInternal());
		}
	}
	
	public void testTest2() throws Exception {
		
	}
	
	public void atestCalculate() throws Exception {
		RasterManager _demModel = new RasterManager(new File("O:\\tank\\data\\dem\\tiff"), 0);
		
		double[] _levels = new double[20];
		for(int i=0;i<20;i++){
			_levels[i] = 3000 + i * 250;
		}
		
		InvertDistanceWeightModel _idwModel = new InvertDistanceWeightModel();
		_idwModel.setMaxCount(10);
		_idwModel.setMaxDistance(0);
		_idwModel.setPow(2);

		TemperatureModel _temperatureModel = new TemperatureModel();
		_temperatureModel.setModel(_idwModel);
		
		PrecipitationModel _precipitationModel = new PrecipitationModel();
		_precipitationModel.setModel(_idwModel);
		
		SnowDDFModel _snowDdfModel = new SnowDDFModel();
		_snowDdfModel.setModel(_idwModel);
		
		IceDDFModel _iceDdfModel = new IceDDFModel();
		_iceDdfModel.setModel(_idwModel);
		
		System.out.println(Arrays.toString(_levels));
		GlacierRunoffModel _model = new GlacierRunoffModel();
		
		WfsFeatureSource _basinFs = new WfsFeatureSource("http://127.0.0.1:48080/geoserver/wfs", "geo:basin");

		_model.setTemperatureModel(_temperatureModel);
		_model.setPrecipitationModel(_precipitationModel);
		_model.setCatchmentModel(new CatchmentModel(_basinFs, "NAME"));
		_model.setIceDDFModel(_iceDdfModel);
		_model.setSnowDDFModel(_snowDdfModel);
		_model.setPrepareModel(new GlacierPrepareModel(_demModel, new WfsFeatureSource("http://127.0.0.1:48080/geoserver/wfs", "geo:glacier")));
		_model.setProjectModel(new ProjectTransformModel("EPSG:4326", "EPSG:21416"));
		_model.setDemModel(_demModel);

		_model.setLevels(_levels);
		_model.setCellSize(1 / 300.0);
		_model.setRainCritical(5);
		_model.setSnowCritical(0);
		
		List<ObjectMonth> _list = _model.calculate(new Date(80, 9, 1), new Date(100, 8, 1), "tailang");
		
		DateFormat _dateFormat = new SimpleDateFormat("yyyy-MM");
		DecimalFormat _deciFormat = new DecimalFormat("0.00");
		for(ObjectMonth _m : _list){
			System.out.println(_dateFormat.format(_m.getDate()) + "\t" + _deciFormat.format(_m.getTemperature()) + "\t" + _deciFormat.format(_m.getPrecipitation()) + "\t" +  _deciFormat.format(_m.getRunoff()));
		}
	}
}
