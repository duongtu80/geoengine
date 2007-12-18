package cn.geodata.models;

import java.util.Map;

import cn.geodata.models.geoprocessing.ValueType;

import net.opengeospatial.wps.InputDescriptionType;
import net.opengeospatial.wps.OutputDescriptionType;

public interface ParameterDefinitionAware {
	void setOutputDefinitions(Map<String, ValueType> outputDefinitions);
	
	void setInputDefinitions(Map<String, ValueType> inputDefinitions);
}
