package cn.geodata.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.InputDescriptionType;
import net.opengeospatial.wps.OutputDescriptionType;
import net.opengeospatial.wps.ProcessDescriptionType;

public class ProcessingFactoryWarp {
	
	public ProcessingWrap createProcess(ProcessingFactory factory, Map<String, String> params) throws Exception {
		ProcessDescriptionType _metadata = factory.getMetadata();
		Processing _process = factory.createProcessing(params);
		
		if (_process instanceof MetadataAware) {
			MetadataAware _metadataAware = (MetadataAware) _process;
			_metadataAware.setMetadata(_metadata);
		}
		
		//Initialize the output data types and datasets
		Map<String, OutputDescriptionType> _outputDefinitions = new HashMap<String, OutputDescriptionType>();
		Map<String, List<IOValueType>> _outputs = new HashMap<String, List<IOValueType>>();
		for(OutputDescriptionType _outputType : _metadata.getProcessOutputs().getOutputArray()){
			_outputs.put(_outputType.getIdentifier().getStringValue(), new ArrayList<IOValueType>());
			_outputDefinitions.put(_outputType.getIdentifier().getStringValue(), _outputType);
		}
		
		//Initialize the input data types and datasets
		Map<String, InputDescriptionType> _inputDefinitions = new HashMap<String, InputDescriptionType>();
		Map<String, List<IOValueType>> _inputs = new HashMap<String, List<IOValueType>>();
		for(InputDescriptionType _inputType : _metadata.getDataInputs().getInputArray()){
			_inputs.put(_inputType.getIdentifier().getStringValue(), new ArrayList<IOValueType>());
			_inputDefinitions.put(_inputType.getIdentifier().getStringValue(), _inputType);
		}
		
		_process.setInputs(_inputs);
		_process.setOutputs(_outputs);
		
		if (_process instanceof ParameterDefinitionAware) {
			ParameterDefinitionAware _parameterDefAware = (ParameterDefinitionAware) _process;
			
			_parameterDefAware.setInputDefinitions(_inputDefinitions);
			_parameterDefAware.setOutputDefinitions(_outputDefinitions);
		}
		
		ProcessingWrap _wrap = new ProcessingWrap();
		_wrap.setProcess(_process);
		
		return _wrap;
	}
}
