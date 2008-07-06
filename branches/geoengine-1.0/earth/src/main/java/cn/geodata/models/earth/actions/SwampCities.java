package cn.geodata.models.earth.actions;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.data.ComplexStream;
import cn.geodata.models.data.DataParser;
import cn.geodata.models.wps.client.WpsProcess;
import cn.geodata.models.wps.client.WpsService;

public class SwampCities {
	private Logger log = Logger.getAnonymousLogger();
	
	private double seaLevel;
	private InputStream stream;
	private String modelUrl;
	private String dataUrl;
	
	public SwampCities() {
		this.modelUrl = "http://127.0.0.1:8080/web/wps";
		this.seaLevel = 1;
	}
	
	public String getModelUrl() {
		return modelUrl;
	}

	public void setModelUrl(String modelUrl) {
		this.modelUrl = modelUrl;
	}

	public double getSeaLevel() {
		return seaLevel;
	}

	public void setSeaLevel(double seaLevel) {
		this.seaLevel = seaLevel;
	}
	
	public InputStream getStream() {
		return stream;
	}

	public String execute() throws Exception {
		log.info("Model Url:" + this.modelUrl);
		
		WpsService _service = new WpsService(new URI(this.modelUrl));
		_service.connect();
		
		WpsProcess _proc = _service.getWpsProcess("Swamp.Cities");
		
		org.apache.xml.utils.URI _citiesUrl = new org.apache.xml.utils.URI(this.dataUrl);
		_citiesUrl.setQueryString("service=WFS&request=GetFeature&typename=unep:cities&version=1.0.0");
		
		Map<String, Object> _inputs = new HashMap<String, Object>();
		_inputs.put("rise", this.seaLevel);
		_inputs.put("cities", _proc.createComplexRef(_citiesUrl.toString(), "text/xml", "utf-8", null));
		
		_proc.execute(_inputs);
		
		List<DataCategory> _categories = new ArrayList<DataCategory>();
		
		ComplexStream _complexStream = DataParser.getInstance().getComplexParsers().parseToStream(_categories, _proc.getOutput("swamp").getComplexValue());
		this.stream = _complexStream.getStream();
		
		return "success";
	}

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}
}
