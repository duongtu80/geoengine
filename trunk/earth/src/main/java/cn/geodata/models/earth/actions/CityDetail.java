package cn.geodata.models.earth.actions;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;

import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.wps.client.WpsProcess;
import cn.geodata.models.wps.client.WpsService;

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
	
	public String getDataUrl() {
		return dataUrl;
	}
	
	public String execute() throws Exception {
		log.info("Model Url:" + this.modelUrl);
		
		WpsService _service = new WpsService(new URI(this.modelUrl));
		_service.connect();
		
		WpsProcess _proc = _service.getWpsProcess("Swamp.Report");
		
		org.apache.xml.utils.URI _citiesUrl = new org.apache.xml.utils.URI(this.dataUrl);
		_citiesUrl.setQueryString("service=WFS&request=GetFeature&typename=unep:cities&version=1.0.0");
		
		Map<String, Object> _inputs = new HashMap<String, Object>();
		_inputs.put("cityId", this.id);
		_inputs.put("cities", _proc.createComplexRef(_citiesUrl.toString(), "text/xml", "utf-8", null));
		
		_proc.execute(_inputs);
		
		FeatureCollection _fs = (FeatureCollection) _proc.getOutput("report", DataCategories.getInstance().findCategory("featureCollection"));
		FeatureIterator _it = _fs.features();
		try{
			Feature _f = _it.next();
			this.cityName = (String)_f.getAttribute("CITY_NAME");
			this.countryName = (String)_f.getAttribute("CNTRY_NAME");
			this.popClass = (String)_f.getAttribute("POP_CLASS");
			this.popRank = (Integer)_f.getAttribute("POP_RANK");
			this.status = (String)_f.getAttribute("STATUS");
		}
		finally{
			_it.close();
		}
		
		return "success";
	}
}
