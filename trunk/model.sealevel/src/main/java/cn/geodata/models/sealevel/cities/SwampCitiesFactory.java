package cn.geodata.models.sealevel.cities;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import cn.geodata.models.AbstractProcessingFactory;
import cn.geodata.models.Processing;
import cn.geodata.models.geoprocessing.ModelDocument;
import cn.geodata.models.geoprocessing.ModelType;

public class SwampCitiesFactory extends AbstractProcessingFactory {
	private static Logger log = Logger.getAnonymousLogger();
	private ModelType metadata;
	
	public SwampCitiesFactory() {
		try {
			this.metadata = ModelDocument.Factory.parse(this.getClass().getResourceAsStream("/META-INF/metadata/swampMetadata.xml")).getModel();
		}
		catch (Exception e) {
			log.log(Level.SEVERE, "Failed to parse the metadata", e);
		}
	}
	
	@Override
	public ModelType getMetadata() {
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
