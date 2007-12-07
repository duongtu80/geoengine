package cn.geodata.models.sealevel.cities;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.ProcessDescriptionsDocument;
import cn.geodata.models.AbstractProcessingFactory;
import cn.geodata.models.Processing;

public class SwampCitiesFactory extends AbstractProcessingFactory {
	private static Logger log = Logger.getAnonymousLogger();
	private ProcessDescriptionType metadata;
	
	public SwampCitiesFactory() {
		try {
			this.metadata = ProcessDescriptionsDocument.Factory.parse(this.getClass().getResourceAsStream("/META-INF/metadata/swampCities.xml")).getProcessDescriptions().getProcessDescriptionArray(0);
		}
		catch (Exception e) {
			log.log(Level.SEVERE, "Failed to parse the metadata", e);
		}
	}
	
	@Override
	public ProcessDescriptionType getMetadata() {
		return this.metadata;
	}

	@Override
	public Map getImplementationHints() {
		return null;
	}

	@Override
	public Processing createProcessing(Map<String, String> params)
			throws Exception {
		return new SwampCities();
	}
}
