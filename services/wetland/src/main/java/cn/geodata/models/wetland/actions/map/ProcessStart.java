package cn.geodata.models.wetland.actions.map;

import java.io.InputStream;
import java.util.Iterator;

import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;
import cn.geodata.models.exception.ProcessingException;

import net.sf.json.JSONObject;

public abstract class ProcessStart extends AbstractProcess {
	protected InputStream stream;
	protected JSONObject params;

	public InputStream getStream() {
		return stream;
	}

	public void setParams(String params) {
		this.params = JSONObject.fromString(params);
	}
	
	protected Processing createProcess(ProcessLibrary library, JSONObject param) throws ProcessingException{
		Processing _p = library.createProcess(param.getString("id"));
		
		JSONObject _params = param.getJSONObject("params");
		Iterator _keys = _params.keys();
		while(_keys.hasNext()){
			String _k = (String) _keys.next();
			library.setInput(_p, _k, _params.get(_k));
		}
		
		return _p;
	}
}
