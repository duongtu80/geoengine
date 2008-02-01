package cn.geodata.models.landfire;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.configuration.HierarchicalConfiguration;

import com.vividsolutions.jts.geom.Point;

public abstract class AbstractSampleModel {
	protected Logger log = Logger.getAnonymousLogger();
	protected HierarchicalConfiguration config;
	
	public AbstractSampleModel(){
		config = (new Configure()).getSubConfig(this.getModelName());
	}
	
	protected HierarchicalConfiguration getConfig(){
		return this.config;
	}
	
	public abstract String[] getFields();
	
	public abstract Double[] getSample(String id, Point pt) throws IOException ;
	
	public abstract String getModelName();
}
