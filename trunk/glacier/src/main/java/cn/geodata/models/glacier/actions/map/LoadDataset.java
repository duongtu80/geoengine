package cn.geodata.models.glacier.actions.map;

import java.io.InputStream;
import java.net.URL;

import org.apache.xml.utils.URI;

public class LoadDataset {
	private String dataset;
	private InputStream stream;
	private String wfsUrl;
	
	public void setWfsUrl(String wfsUrl) {
		this.wfsUrl = wfsUrl;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setDataset(String dataset) {
		this.dataset = dataset;
	}

	public String execute() throws Exception {
		URI _url = new URI(this.wfsUrl);
		_url.setQueryString("service=WFS&request=GetFeature&version=1.0.0&typename=" + this.dataset);
		this.stream = (new URL(_url.toString())).openStream();
		
		return "success";
	}
}
