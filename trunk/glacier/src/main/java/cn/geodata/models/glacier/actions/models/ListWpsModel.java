package cn.geodata.models.glacier.actions.models;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;

import net.opengeospatial.wps.ProcessBriefType;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.geodata.models.wps.client.WpsService;

public class ListWpsModel {
	private String url;
	private InputStream stream;
	
	public InputStream getStream() {
		return stream;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String execute() throws Exception {
		WpsService _s = new WpsService(new URI(this.url));
		_s.connect();
		
		JSONArray _list = new JSONArray();
		for(ProcessBriefType _p : _s.listProcesses()){
			JSONObject _proc = new JSONObject();
			
			_proc.put("id", _p.getIdentifier().getStringValue());
			_proc.put("name", _p.getTitle());
			_proc.put("abstract", _p.getAbstract());
			_proc.put("url", this.url);
			
			_list.put(_proc);
		}
		
		this.stream = new ByteArrayInputStream(_list.toString().getBytes());
		
		return "success";
	}
}
