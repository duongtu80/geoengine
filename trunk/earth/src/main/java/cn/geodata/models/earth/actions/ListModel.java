package cn.geodata.models.earth.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;

import net.opengeospatial.wps.ProcessBriefType;

import cn.geodata.model.wps.WpsClient;

public class ListModel {
	private InputStream stream;
	private String modelUrl;

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
		StringBuilder _txt = new StringBuilder();
		_txt.append("[");
		
		WpsClient _client = new WpsClient(new URI(this.modelUrl));
		for(ProcessBriefType _process : _client.getCapibilities().getCapabilities().getProcessOfferings().getProcessArray()){
			_txt.append("['identifier':'" + _process.getIdentifier().getStringValue() + "','name':'" + _process.getTitle() + "','description':'" + _process.getIdentifier() + "']");
		}
		_txt.append("]");
		
		this.stream = new ByteArrayInputStream(_txt.toString().getBytes());
		
		return "success";
	}
}
