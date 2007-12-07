package cn.geodata.models;

import java.util.Map;

import net.opengeospatial.wps.ProcessDescriptionType;

public interface ProcessingFactory extends org.geotools.factory.Factory {
	ProcessDescriptionType getMetadata();
	Processing createProcessing(Map<String, String> params) throws Exception;
}
