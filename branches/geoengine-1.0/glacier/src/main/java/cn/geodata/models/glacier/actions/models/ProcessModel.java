package cn.geodata.models.glacier.actions.models;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import cn.geodata.models.wps.client.WpsProcess;
import cn.geodata.models.wps.client.WpsService;

public class ProcessModel {
	protected InputStream stream;
	
	protected String modelUrl;
	protected String modelId;

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

	public String getModelUrl() {
		return modelUrl;
	}

	public void setModelUrl(String modelUrl) {
		this.modelUrl = modelUrl;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	
	protected WpsProcess createProcess() throws URISyntaxException, IOException {
		WpsService _s = new WpsService(new URI(this.modelUrl));
		_s.connect();
		
		return _s.getWpsProcess(this.modelId);
	}

	protected WpsProcess createProcess(String url) throws URISyntaxException, IOException {
		String[] _parts = url.split("#", 2);
		if(_parts.length == 2){
			WpsService _s = new WpsService(new URI(_parts[0]));
			_s.connect();
			
			return _s.getWpsProcess(_parts[1]);
		}
		else{
			throw new IOException("Bad formated model url");
		}
	}
}
