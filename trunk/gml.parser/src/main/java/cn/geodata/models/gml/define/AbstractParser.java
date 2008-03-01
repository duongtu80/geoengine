package cn.geodata.models.gml.define;

import cn.geodata.models.gml.GMLConfiguration;
import cn.geodata.models.gml.Parser;
import cn.geodata.models.gml.ParserFinder;


public abstract class AbstractParser implements Parser {
	protected GMLConfiguration config;
	protected ParserFinder finder;
	
	public GMLConfiguration getConfig() {
		return config;
	}

	public void setConfig(GMLConfiguration config) {
		this.config = config;
	}
	
	@Override
	public ParserFinder getParserFinder() {
		return this.finder;
	}
	
	@Override
	public void setParserFinder(ParserFinder finder) {
		this.finder = finder;
	}
}
