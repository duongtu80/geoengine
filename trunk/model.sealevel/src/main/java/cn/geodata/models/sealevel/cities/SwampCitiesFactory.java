package cn.geodata.models.sealevel.cities;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import cn.geodata.models.AbstractProcessingFactory;
import cn.geodata.models.Processing;
import cn.geodata.models.geoprocessing.ProcessesDocument;
import cn.geodata.models.geoprocessing.ProcessesType;

public class SwampCitiesFactory extends AbstractProcessingFactory {
	private static Logger log = Logger.getAnonymousLogger();
	private ProcessesType metadata;
	
	public SwampCitiesFactory() {
		try {
			this.metadata = ProcessesDocument.Factory.parse(this.getClass().getResourceAsStream("/META-INF/metadata/swampModel.xml")).getProcesses();
		}
		catch (Exception e) {
			log.log(Level.SEVERE, "Failed to parse the metadata", e);
		}
	}
	
	@Override
	public ProcessesType getMetadata() {
		return this.metadata;
	}
	
	@Override
	public Map getImplementationHints() {
		return null;
	}

	@Override
	public Processing createProcessing(String identify, Map<String, String> params)
			throws IOException {
		if(identify.equalsIgnoreCase("swamp.report")){
			return new SwampReport();
		}
		else if(identify.equalsIgnoreCase("swamp.cities")){
			return new SwampCities();
		}
		else{
			log.severe("Does not support the require process " + identify);
			throw new IOException("Does not support the require process");
		}
	}
}
