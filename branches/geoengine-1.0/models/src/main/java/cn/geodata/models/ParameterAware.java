package cn.geodata.models;

import java.util.Map;

public interface ParameterAware {
	Map<String, Object> getInputs();
	void setInputs(Map<String, Object> inputs);
	
	Map<String, Object> getOutputs();
	void setOutputs(Map<String, Object> outputs);
}
