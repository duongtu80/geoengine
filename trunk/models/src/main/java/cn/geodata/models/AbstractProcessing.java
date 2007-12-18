package cn.geodata.models;

import java.util.Map;

import cn.geodata.models.geoprocessing.ProcessType;
import cn.geodata.models.geoprocessing.ValueType;

/**
 * 
 * @author Fengm
 * 
 */
public abstract class AbstractProcessing implements Processing, ParameterAware,
		MetadataAware, ParameterDefinitionAware, StatusAware {
	protected ProcessType metadata;

	protected Map<String, ValueType> outputDefinitions;
	protected Map<String, ValueType> inputDefinitions;

//	protected Map<String, List<IOValueType>> rawInputs;
//	protected Map<String, List<IOValueType>> rawOutputs;
//
	protected Map<String, Object> inputs;
	protected Map<String, Object> outputs;

	@Override
	public Map<String, Object> getInputs() {
		return this.inputs;
	}

	@Override
	public Map<String, Object> getOutputs() {
		return this.outputs;
	}

	@Override
	public void setInputs(Map<String, Object> inputs) {
		this.inputs = inputs;
	}

	@Override
	public void setOutputs(Map<String, Object> outputs) {
		this.outputs = outputs;
	}

//	@Override
//	public Map<String, List<IOValueType>> getRawInputs() {
//		return rawInputs;
//	}
//
//	@Override
//	public Map<String, List<IOValueType>> getRawOutputs() {
//		return rawOutputs;
//	}
//
//	@Override
//	public void setRawInputs(Map<String, List<IOValueType>> rawInputs) {
//		this.rawInputs = rawInputs;
//	}
//
//	@Override
//	public void setRawOutputs(Map<String, List<IOValueType>> rawOutputs) {
//		this.rawOutputs = rawOutputs;
//	}
//
	@Override
	public void setMetadata(ProcessType metadata) {
		this.metadata = metadata;
	}

	@Override
	public void setInputDefinitions(Map<String, ValueType> inputDefinitions) {
		this.inputDefinitions = inputDefinitions;
	}

	@Override
	public void setOutputDefinitions(Map<String, ValueType> outputDefinitions) {
		this.outputDefinitions = outputDefinitions;
	}
}
