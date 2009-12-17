package cn.geodata.models.wps.rest.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public class Util {
	private static Util instance = null;
	
	private Logger log = Logger.getAnonymousLogger();
	private XMLConfiguration config;
	
	private Util() {
		try {
			config = new XMLConfiguration(Util.class.getResource("/conf/services.xml"));
		} catch (ConfigurationException e) {
			log.log(Level.SEVERE, "Faied to load service configuration file", e);
		}
	}
	
	/**
	 * @return Instance of the class
	 * @throws ConfigurationException 
	 */
	public static Util getInstance() {
		if(instance == null){
			instance = new Util();
		}
		
		return instance;
	}

	public XMLConfiguration getConfig() {
		return config;
	}
}
