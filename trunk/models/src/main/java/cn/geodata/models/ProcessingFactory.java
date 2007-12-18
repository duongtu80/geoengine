package cn.geodata.models;

import java.io.IOException;
import java.util.Map;

import cn.geodata.models.geoprocessing.ProcessesType;

public interface ProcessingFactory extends org.geotools.factory.Factory {
	ProcessesType getMetadata();
	Processing createProcessing(String identify, Map<String, String> params) throws IOException;
}
