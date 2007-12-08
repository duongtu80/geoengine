package cn.geodata.models.earth.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;

import net.opengeospatial.wps.ProcessBriefType;

import cn.geodata.models.wps.WpsClient;

public class ListModel {
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
		
		StringBuilder _txt = new StringBuilder();
		try{
			_txt.append("{identifier:'models', items:[");
			
			boolean _a = false;
			WpsClient _client = new WpsClient(new URI(this.modelUrl));
			for(ProcessBriefType _process : _client.getCapibilities().getCapabilities().getProcessOfferings().getProcessArray()){
				if(_a){
					_txt.append(",");
				}
				_txt.append("{value:'" + _process.getIdentifier().getStringValue() + "',label:'" + _process.getTitle() + "',abstract:'" + _process.getAbstract() + "'}");
				_a = true;
			}
			_txt.append("]}");
		}
		catch(Exception e){
			_txt.append("{identifier:'error', text:\"" + this.formatJSON(e.getMessage()) + "\"}");		
		}
		this.stream = new ByteArrayInputStream(_txt.toString().getBytes());
		
		return "success";
	}
	
	public String formatJSON(String v){
		return v.replace("\\", "\\\\").replace("\"", "\\\"").replace("/", "\\/");
	}
}
