package cn.geodata.models;

import java.io.IOException;
import java.util.Map;

import cn.geodata.models.geoprocessing.ModelType;

public interface ProcessingFactory extends org.geotools.factory.Factory {
	ModelType getMetadata();
	Processing createProcessing(String identify, Map<String, String> params) throws IOException;
}
