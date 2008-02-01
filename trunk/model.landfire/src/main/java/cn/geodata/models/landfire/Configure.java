package cn.geodata.models.landfire;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

public class Configure {
	private static Logger log = Logger.getAnonymousLogger();
	private XMLConfiguration configure;
	
	public Configure() {
		try {
			configure = new XMLConfiguration(Configure.class.getResource("/META-INF/landfire.conf.xml"));
		} catch (ConfigurationException e) {
			log.log(Level.SEVERE, "Failed to load configure file", e);
		}
	}
	
	public XMLConfiguration getConfigure(){
		return this.configure;
	}
	
	public HierarchicalConfiguration getSubConfig(String sub){
		return (new Configure()).getConfigure().configurationAt(sub);
	}
}
