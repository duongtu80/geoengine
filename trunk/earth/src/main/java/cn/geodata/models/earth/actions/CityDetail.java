package cn.geodata.models.earth.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import net.opengeospatial.wps.ExecuteResponseDocument;
import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.InputDescriptionType;
import net.opengeospatial.wps.ProcessDescriptionType;

import org.geotools.data.DataStore;
import org.geotools.data.FeatureSource;
import org.geotools.data.wfs.WFSDataStoreFactory;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureIterator;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.DOMBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.opengis.filter.Filter;
import org.opengis.filter.FilterFactory2;
import org.opengis.filter.identity.FeatureId;

import cn.geodata.models.GeoNamespaceContext;
import cn.geodata.models.value.ModelValueParserFinder;
import cn.geodata.models.value.ModelValueUtil;
import cn.geodata.models.wps.WpsClient;

public class CityDetail {
	private static Logger log = Logger.getAnonymousLogger();
	
	private String id;
	private String cityName;
	private String countryName;
	private String status;
	private int popRank;
	private String popClass;
	private String dataUrl;
	private String modelUrl;

	public CityDetail() {
		this.dataUrl = "http://152.61.40.52:18080/geoserver/wfs?version=1.0.0&";
		this.modelUrl = "http://127.0.0.1:8080/web/wps";
	}
	
	public String getModelUrl() {
		return modelUrl;
	}

	public void setModelUrl(String modelUrl) {
		this.modelUrl = modelUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}

	public String getCityName() {
		return cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getStatus() {
		return status;
	}

	public int getPopRank() {
		return popRank;
	}

	public String getPopClass() {
		return popClass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String execute() throws Exception {
		log.info("Model Url:" + this.modelUrl);
		WpsClient _client = new WpsClient(new URI(this.modelUrl));
		
		org.apache.xml.utils.URI _citiesUrl = new org.apache.xml.utils.URI(this.dataUrl);
		_citiesUrl.setQueryString("service=WFS&request=GetFeature&typename=unep:cities&version=1.0.0");

		log.info("Cities url:" + _citiesUrl.toString());

		ProcessDescriptionType _processDesc = _client.describeProcess(new String[]{"swamp.report"}).getProcessDescriptions().getProcessDescriptionArray(0);
		
		Map<String, InputDescriptionType> _inputDefinitions = new HashMap<String, InputDescriptionType>();
		for(InputDescriptionType _inputType : _processDesc.getDataInputs().getInputArray()){
			_inputDefinitions.put(_inputType.getIdentifier().getStringValue(), _inputType);
		}

		ModelValueParserFinder _finder = ModelValueUtil.createParserFinder();
		
		List<IOValueType> _inputs = new ArrayList<IOValueType>();
		
		IOValueType _paramRise = ModelValueUtil.createInputValue(_inputDefinitions.get("cityId"));
		_paramRise.setLiteralValue(_finder.getLiteralEncoder().encodeLiteral(this.id));
		_inputs.add(_paramRise);
		
		IOValueType _paramCities = ModelValueUtil.createInputValue(_inputDefinitions.get("cities"));
		_paramCities.setComplexValueReference(_finder.getReferenceEncoder().encodeUrl(_citiesUrl.toString(), "text/gml", "utf-8", null));
		_inputs.add(_paramCities);
		
		ExecuteResponseDocument _execute = _client.execute(_processDesc.getIdentifier().getStringValue(), _inputs.toArray(new IOValueType[0]));
		
		
//		XmlOptions _options = new XmlOptions();
//		_options.setSaveUseOpenFrag();
//		_options.setSaveOuter();
		
//		this.stream = _execute.getExecuteResponse().getProcessOutputs().getOutputArray(0).getComplexValue().newInputStream(_options);

		Element _ele = (new DOMBuilder()).build((org.w3c.dom.Element)_execute.getExecuteResponse().getProcessOutputs().getOutputArray(0).getComplexValue().getDomNode());
		
		Namespace _namespace = Namespace.getNamespace(GeoNamespaceContext.URI_GML);
		Element _featureCollection = _ele.getChild("FeatureCollection", _namespace);
		
		if(_featureCollection != null){
			List<Element> _features = _featureCollection.getChildren("featureMember", _namespace);
			if(_features.size() > 0){
				Element _f = (Element)_features.get(0).getChildren().get(0);
				
				this.cityName = _f.getChildText("CITY_NAME", _f.getNamespace());
				this.countryName = _f.getChildText("CNTRY_NAME", _f.getNamespace());
				this.popClass = _f.getChildText("POP_CLASS", _f.getNamespace());
				this.popRank = Integer.parseInt(_f.getChildText("POP_RANK", _f.getNamespace()));
				this.status = _f.getChildText("STATUS", _f.getNamespace());
			}
		}
		
		return "success";

//		FeatureSource _dataSource = this.getDataStore().getFeatureSource("unep:cities");
//		
//		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
//		
//		Set<FeatureId> _set = new HashSet<FeatureId>();
//		_set.add(_factory.featureId(this.id));
//		Filter _filter = _factory.id(_set);
//		
//		FeatureIterator _it = _dataSource.getFeatures(_filter).features();
//		try{
//			Feature _f = _it.next();
//			this.cityName = (String)_f.getAttribute("CITY_NAME");
//			this.countryName = (String)_f.getAttribute("CNTRY_NAME");
//			this.popClass = (String)_f.getAttribute("POP_CLASS");
//			this.popRank = (Integer)_f.getAttribute("POP_RANK");
//			this.status = (String)_f.getAttribute("STATUS");
//		}
//		finally{
//			_it.close();
//		}
//		
//		return "success";
	}
	
	private DataStore getDataStore() throws IOException {
		WFSDataStoreFactory _factory = new WFSDataStoreFactory();

		Map _params = new HashMap();
		_params.put(_factory.URL.key, this.dataUrl);
		
		log.info("Url:" + this.dataUrl.toString());
		
		return _factory.createDataStore(_params );
	}

	public String getDataUrl() {
		return dataUrl;
	}
}
