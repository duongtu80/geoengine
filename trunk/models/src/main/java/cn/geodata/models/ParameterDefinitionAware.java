package cn.geodata.models;

import java.util.Map;

import net.opengeospatial.wps.InputDescriptionType;
import net.opengeospatial.wps.OutputDescriptionType;

public interface ParameterDefinitionAware {
	void setOutputDefinitions(Map<String, OutputDescriptionType> outputDefinitions);
	
	void setInputDefinitions(Map<String, InputDescriptionType> inputDefinitions);
}
