package cn.geodata.models.glacier.actions.models;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.annotation.GeoProcess;

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
		ProcessLibrary _lib = ProcessLibrary.createInstance();
		Map<String, Class> _procs = _lib.getModelList();
		
		JSONArray _list = new JSONArray();
		for(String _key : _procs.keySet()){
			JSONObject _proc = new JSONObject();
			
			GeoProcess _p = _lib.getProcessMetadata(_procs.get(_key));
			
			_proc.put("id", _key);
			_proc.put("name", _p.title());
			_proc.put("abstract", _p.description());
			_proc.put("keywords", JSONArray.fromObject(_p.keywords()));
			
			_list.add(_proc);
		}
		
		this.stream = new ByteArrayInputStream(_list.toString().getBytes("UTF-8"));
		
		return "success";
	}
}
