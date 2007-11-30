package cn.geodata.gml.define;

import cn.geodata.gml.GMLConfiguration;

public abstract class AbstractDefinition implements Definition {
	protected GMLConfiguration config;
	
	public GMLConfiguration getConfig() {
		return config;
	}

	public void setConfig(GMLConfiguration config) {
		this.config = config;
	}
}
