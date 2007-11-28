package cn.geodata.models.web.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public class Util {
	private static Util instance = null;
	
	private XMLConfiguration config;
	
	private Util() throws ConfigurationException {
		config = new XMLConfiguration(Util.class.getResource("/conf/services.xml"));
	}
	
	/**
	 * @return Instance of the class
	 * @throws ConfigurationException 
	 */
	public static Util getInstance() throws ConfigurationException {
		if(instance == null){
			instance = new Util();
		}
		
		return instance;
	}

	public XMLConfiguration getConfig() {
		return config;
	}
}
