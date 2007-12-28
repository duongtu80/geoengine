package cn.geodata.models.landfire;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.xmlbeans.XmlException;

import cn.geodata.models.AbstractProcessingFactory;
import cn.geodata.models.Processing;
import cn.geodata.models.geoprocessing.ProcessesDocument;
import cn.geodata.models.geoprocessing.ProcessesType;

public class LandFireFactory extends AbstractProcessingFactory {
	private static Logger log = Logger.getAnonymousLogger();
	
	private ProcessesType metadata;
	
	public LandFireFactory(){
		try {
			this.metadata = ProcessesDocument.Factory.parse(LandFireFactory.class.getResourceAsStream("/META-INF/metadata/landfireModel.xml")).getProcesses();
		} catch (XmlException e) {
			log.log(Level.SEVERE, "Failed to load the metadata for Landfire models", e);
		} catch (IOException e) {
			log.log(Level.SEVERE, "Failed to load the metadata for Landfire models", e);
		}
	}
	@Override
	public Processing createProcessing(String identify,
			Map<String, String> params) throws IOException {
		if(identify.equals("landfire.samples")){
			return new CollectSampleAgent();
		}
		else{
			throw new IOException("Does not support the require process " + identify);
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

}
