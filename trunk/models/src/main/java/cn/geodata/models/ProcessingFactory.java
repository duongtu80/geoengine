package cn.geodata.models;

import java.io.IOException;
import java.util.Map;

import net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions;

public interface ProcessingFactory extends org.geotools.factory.Factory {
	ProcessDescriptions getMetadata();
	Processing createProcessing(String identify, Map<String, String> params) throws IOException;
}
