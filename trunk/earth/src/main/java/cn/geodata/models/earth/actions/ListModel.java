package cn.geodata.models.earth.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import cn.geodata.models.wps.client.WpsService;

import net.opengeospatial.wps.ProcessBriefType;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ListModel {
	private static Logger log = Logger.getAnonymousLogger();
	
	private InputStream stream;
	private String modelUrl;

	public ListModel() {
		this.modelUrl = "http://127.0.0.1:8080/web/wps";
	}
	
	public String getModelUrl() {
		return modelUrl;
	}

	public void setModelUrl(String modelUrl) {
		this.modelUrl = modelUrl;
	}

	public InputStream getStream() {
		return stream;
	}

	public String execute() throws Exception {
		log.info("Model Url:" + this.modelUrl);
		JSONObject _models = new JSONObject();
		try{
			WpsService _service = new WpsService(new URI(this.modelUrl));
			_service.connect();
			
			List<JSONObject> _items = new ArrayList<JSONObject>();
			for(ProcessBriefType _process : _service.listProcesses()){
				JSONObject _model = new JSONObject();
				
				_model.put("id", _process.getIdentifier().getStringValue());
				_model.put("name", _process.getTitle());
				_model.put("abstract", _process.getAbstract());
				
				_items.add(_model);
			}
			
			_models.put("identifier", "id");
			_models.put("items", JSONArray.fromCollection(_items));
		}
		catch(Exception e){
			_models.put("identifier", "error");
			_models.put("text", e.getMessage());
		}
		
		this.stream = new ByteArrayInputStream(_models.toString().getBytes());
		
		return "success";
	}
}
