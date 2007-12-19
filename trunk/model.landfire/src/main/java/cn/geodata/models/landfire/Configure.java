package cn.geodata.models.landfire;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.configuration.ConfigurationException;
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
	
	public File getFireRepository(){
		return new File(this.configure.getString("dataset.path"));
	}
	
	public File getTempOutputPath(){
		return new File(this.configure.getString("output"));
	}
}
