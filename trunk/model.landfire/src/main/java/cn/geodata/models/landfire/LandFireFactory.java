package cn.geodata.models.landfire;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.xmlbeans.XmlException;

import cn.geodata.models.AbstractProcessingFactory;
import cn.geodata.models.Processing;
import cn.geodata.models.geoprocessing.ModelDocument;
import cn.geodata.models.geoprocessing.ModelType;

public class LandFireFactory extends AbstractProcessingFactory {
	private static Logger log = Logger.getAnonymousLogger();
	
	private ModelType metadata;
	
	public LandFireFactory(){
		try {
			this.metadata = ModelDocument.Factory.parse(LandFireFactory.class.getResourceAsStream("/META-INF/metadata/landfireModel.xml")).getModel();
		} catch (XmlException e) {
			log.log(Level.SEVERE, "Failed to load the metadata for Landfire models", e);
		} catch (IOException e) {
			log.log(Level.SEVERE, "Failed to load the metadata for Landfire models", e);
		}
	}

	public Processing createProcessing(String identify,
			Map<String, String> params) throws IOException {
		if(identify.equals("landfire.samples")){
			return new CollectSampleAgent();
		}
		else{
			throw new IOException("Does not support the require process " + identify);
		}
	}

	public ModelType getMetadata() {
		return this.metadata;
	}

	public Map getImplementationHints() {
		return null;
	}

}
