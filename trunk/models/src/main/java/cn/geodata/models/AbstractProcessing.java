package cn.geodata.models;

import java.util.List;
import java.util.Map;

import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.InputDescriptionType;
import net.opengeospatial.wps.OutputDescriptionType;
import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.ExecuteDocument.Execute;

/**
 * 
 * @author Fengm
 *
 */
public abstract class AbstractProcessing implements Processing, MetadataAware, ParameterDefinitionAware, StatusAware {
	protected ProcessDescriptionType metadata;
	protected Execute request;
	
	@Override
	public Execute getRequest() {
		return request;
	}

	protected Map<String, OutputDescriptionType> outputDefinitions;
	protected Map<String, InputDescriptionType> inputDefinitions;
	
	protected Map<String, List<IOValueType>> inputs;
	protected Map<String, List<IOValueType>> outputs;
	
	@Override
	public Map<String, List<IOValueType>> getInputs() {
		return inputs;
	}

	@Override
	public Map<String, List<IOValueType>> getOutputs() {
		return outputs;
	}

	@Override
	public void setInputs(Map<String, List<IOValueType>> inputs) {
		this.inputs = inputs;		
	}

	@Override
	public void setOutputs(Map<String, List<IOValueType>> outputs) {
		this.outputs = outputs;		
	}

	@Override
	public void setMetadata(ProcessDescriptionType metadata) {
		this.metadata = metadata;		
	}

	@Override
	public void setInputDefinitions(
			Map<String, InputDescriptionType> inputDefinitions) {
		this.inputDefinitions = inputDefinitions;		
	}

	@Override
	public void setOutputDefinitions(
			Map<String, OutputDescriptionType> outputDefinitions) {
		this.outputDefinitions = outputDefinitions;		
	}
}
