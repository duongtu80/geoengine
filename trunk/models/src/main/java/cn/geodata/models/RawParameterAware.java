package cn.geodata.models;

import java.util.List;
import java.util.Map;

import net.opengeospatial.wps.IOValueType;

public interface RawParameterAware {
	void setRawInputs(Map<String, List<IOValueType>> rawInputs);
	Map<String, List<IOValueType>> getRawInputs();
	
	void setRawOutputs(Map<String, List<IOValueType>> rawOutputs);
	Map<String, List<IOValueType>> getRawOutputs();
}
