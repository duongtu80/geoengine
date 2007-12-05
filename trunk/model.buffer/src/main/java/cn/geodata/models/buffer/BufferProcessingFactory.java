package cn.geodata.models.buffer;

import java.io.InputStream;
import java.util.Map;

import cn.geodata.model.GeoProcessing;
import cn.geodata.model.ProcessingFactory;

public class BufferProcessingFactory extends ProcessingFactory {

	@Override
	public String getDescription() {
		return "Buffer geometries";
	}

	@Override
	public String getTitle() {
		return "Buffer";
	}

	@Override
	public Map getImplementationHints() {
		return null;
	}

	@Override
	public String getIdentifier() {
		return "Buffer";
	}

	@Override
	public InputStream getMetadataStream() throws Exception {
		//Metadata stream
		return BufferProcessing.class.getResourceAsStream("/META-INF/metadata/buffer.xml");
	}

	@Override
	public GeoProcessing createProcessing(Map<String, String> params)
			throws Exception {
		//Create a model instance
		return new BufferProcessing();
	}
}
