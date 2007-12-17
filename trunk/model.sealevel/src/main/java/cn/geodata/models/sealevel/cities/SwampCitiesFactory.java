package cn.geodata.models.sealevel.cities;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.opengeospatial.wps.ProcessDescriptionsDocument;
import net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions;
import cn.geodata.models.AbstractProcessingFactory;
import cn.geodata.models.Processing;

public class SwampCitiesFactory extends AbstractProcessingFactory {
	private static Logger log = Logger.getAnonymousLogger();
	private ProcessDescriptions metadata;
	
	public SwampCitiesFactory() {
		try {
			this.metadata = ProcessDescriptionsDocument.Factory.parse(this.getClass().getResourceAsStream("/META-INF/metadata/swampCities.xml")).getProcessDescriptions();
		}
		catch (Exception e) {
			log.log(Level.SEVERE, "Failed to parse the metadata", e);
		}
	}
	
	@Override
	public ProcessDescriptions getMetadata() {
		return this.metadata;
	}
	
	@Override
	public Map getImplementationHints() {
		return null;
	}

	@Override
	public Processing createProcessing(String identify, Map<String, String> params)
			throws IOException {
		return new SwampCities();
	}
}
