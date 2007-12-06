package cn.geodata.models.buffer;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.ProcessDescriptionsDocument;
import cn.geodata.model.GeoProcessing;
import cn.geodata.model.ProcessingFactory;

public class BufferProcessingFactory extends ProcessingFactory {
	private static Logger log = Logger.getAnonymousLogger();
	
	private ProcessDescriptionType metadata;
	
	public BufferProcessingFactory() {
		try {
			this.metadata = ProcessDescriptionsDocument.Factory.parse(this.getClass().getResourceAsStream("/META-INF/metadata/buffer.xml")).getProcessDescriptions().getProcessDescriptionArray(0);
		}
		catch (Exception e) {
			log.log(Level.SEVERE, "Failed to parse the metadata", e);
		}
	}
	
	@Override
	public Map getImplementationHints() {
		return null;
	}

	@Override
	public ProcessDescriptionType getMetadata() {
		return this.metadata;
	}

	@Override
	protected GeoProcessing createProcessInstance(Map<String, String> params)
			throws Exception {
		return new BufferProcessing();
	}
}
