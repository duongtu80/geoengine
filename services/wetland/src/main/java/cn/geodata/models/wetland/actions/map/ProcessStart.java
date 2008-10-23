package cn.geodata.models.wetland.actions.map;

import java.io.InputStream;

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
}
