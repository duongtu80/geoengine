package cn.geodata.models.wetland;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import cn.geodata.models.AbstractProcessingFactory;
import cn.geodata.models.Processing;
import cn.geodata.models.geoprocessing.ModelDocument;
import cn.geodata.models.geoprocessing.ModelType;

public class WetLandFactory extends AbstractProcessingFactory {
	private static Logger log = Logger.getAnonymousLogger();
	private ModelType metadata;
	
	public WetLandFactory(){
		try {
			this.metadata = ModelDocument.Factory.parse(this.getClass().getResourceAsStream("/META-INF/metadata/wetlandMetadata.xml")).getModel();
		}
		catch (Exception e) {
			log.log(Level.SEVERE, "Failed to parse the metadata", e);
		}
	}

	@Override
	public Processing createProcessing(String identify,
			Map<String, String> params) throws IOException {
		if(identify.equalsIgnoreCase("WaterRegion")){
			return new WaterRegionProcessing();
		}
		else{
			throw new IOException("Not support " + identify);
		}
	}

	@Override
	public ModelType getMetadata() {
		return metadata;
	}

	@Override
	public Map getImplementationHints() {
		return null;
	}

}
