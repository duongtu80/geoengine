package cn.geodata.models.wetland.actions.map;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.activation.MimeType;

import net.opengeospatial.wps.OutputDefinitionType;

import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.data.ComplexStream;
import cn.geodata.models.data.DataParser;
import cn.geodata.models.wps.client.WpsProcess;
import cn.geodata.models.wps.client.WpsService;

public class WaterRegion {
	private static Logger log = Logger.getAnonymousLogger();
	private String waterlandCode;
	private String catchmentURL;
	private String modelURL;
	private float waterLevel;
	private InputStream stream;
	
	public String getCatchmentURL() {
		return catchmentURL;
	}
	public void setCatchmentURL(String catchmentURL) {
		this.catchmentURL = catchmentURL;
	}
	public float getWaterLevel() {
		return waterLevel;
	}
	public void setWaterLevel(float waterLevel) {
		this.waterLevel = waterLevel;
	}
	public InputStream getStream() {
		return stream;
	}
	public void setStream(InputStream stream) {
		this.stream = stream;
	}
	public String getModelURL() {
		return modelURL;
	}
	public void setModelURL(String modelURL) {
		this.modelURL = modelURL;
	}
	
	public String execute() throws Exception {
		log.info("Model Url:" + this.modelURL);
		
		WpsService _service = new WpsService(new URI(this.modelURL));
		_service.connect();
		
		WpsProcess _proc = _service.getWpsProcess("Wetland.WaterRegion");
		
//		org.apache.xml.utils.URI _citiesUrl = new org.apache.xml.utils.URI(this.catchmentURL);
//		_citiesUrl.setQueryString("service=WFS&request=GetFeature&typename=wet:catchment&version=1.0.0");
		
		Map<String, Object> _inputs = new HashMap<String, Object>();
		_inputs.put("CodeField", "NAME");
		_inputs.put("WaterLevel", this.waterLevel);
		_inputs.put("WetlandCode", this.waterlandCode);
//		_inputs.put("Catchment", _proc.createComplexRef(_citiesUrl.toString(), "text/xml", "utf-8", null));
		
		_proc.getOutputFormat().put("WaterRegion", new MimeType("text/json"));

		_proc.execute(_inputs);
		
		List<DataCategory> _categories = new ArrayList<DataCategory>();
		_categories.add(DataCategories.getInstance().findCategory("featureCollection"));

		ComplexStream _complexStream = DataParser.getInstance().getComplexParsers().parseToStream(_categories, _proc.getOutput("WaterRegion").getComplexValue());
		this.stream = _complexStream.getStream();
		
		return "success";
	}
	public String getWaterlandCode() {
		return waterlandCode;
	}
	public void setWaterlandCode(String waterlandCode) {
		this.waterlandCode = waterlandCode;
	}
	
}
