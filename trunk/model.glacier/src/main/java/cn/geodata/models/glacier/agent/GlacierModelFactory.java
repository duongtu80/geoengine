package cn.geodata.models.glacier.agent;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.xmlbeans.XmlException;

import cn.geodata.models.AbstractProcessingFactory;
import cn.geodata.models.Processing;
import cn.geodata.models.geoprocessing.ModelDocument;
import cn.geodata.models.geoprocessing.ModelType;

public class GlacierModelFactory extends AbstractProcessingFactory {
	private static Logger log = Logger.getLogger(GlacierModelFactory.class.getName());
	private ModelType modelMetadata;
	
	public GlacierModelFactory(){
		try {
			this.modelMetadata = ModelDocument.Factory.parse(GlacierModelFactory.class.getResourceAsStream("/META-INF/metadata/glacierMetadata.xml")).getModel();
		} catch (XmlException e) {
			e.printStackTrace();
			log.severe(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			log.severe(e.getMessage());
		}
	}

	public Processing createProcessing(String arg0, Map<String, String> arg1)
			throws IOException {
		if(arg0.equalsIgnoreCase("TemperatureIdw")){
			return new TemperatureIdwAgent();
		}
		else if(arg0.equalsIgnoreCase("PrecipitationIdw")){
			return new PrecipitationIdwAgent();
		}
		else if(arg0.equalsIgnoreCase("SnowDdfIdw")){
			return new SnowDdfIdwAgent();
		}
		else if(arg0.equalsIgnoreCase("IceDdfIdw")){
			return new IceDdfIdwAgent();
		}
		else if(arg0.equalsIgnoreCase("Runoff")){
			return new RunoffAgent();
		}
		else if(arg0.equalsIgnoreCase("TemperatureIdwEx")){
			return new TemperatureIdwExAgent();
		}
		else{
			log.severe("Unkown process name:" + arg0);
			throw new IOException("Unknow process name:" + arg0);
		}
	}

	public ModelType getMetadata() {
		return this.modelMetadata;
	}

	public Map getImplementationHints() {
		return null;
	}

}