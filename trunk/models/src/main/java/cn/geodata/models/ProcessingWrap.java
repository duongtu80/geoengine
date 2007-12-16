package cn.geodata.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.opengeospatial.wps.ExecuteResponseDocument;
import net.opengeospatial.wps.ExecuteResponseType;
import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.InputDescriptionType;
import net.opengeospatial.wps.OutputDescriptionType;
import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.StatusType;
import net.opengeospatial.wps.ExecuteDocument.Execute;
import net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs;
import cn.geodata.models.exception.NoApplicableCodeException;
import cn.geodata.models.exception.OptionNotSupportedException;
import cn.geodata.models.exception.ProcessingException;
import cn.geodata.models.status.ProcessAccepted;
import cn.geodata.models.status.ProcessFailed;
import cn.geodata.models.status.ProcessSucceeded;
import cn.geodata.models.status.Status;
import cn.geodata.models.util.Utilities;

public class ProcessingWrap implements Runnable {
	private static Logger log = Utilities.getLogger();
	
	private ProcessDescriptionType metadata;
	private Processing process;
	private Status status; 
	private Execute request;
	
	public Execute getRequest() {
		return request;
	}

	public ProcessingWrap(Processing process, ProcessDescriptionType metadata, Execute request) throws OptionNotSupportedException {
		if(request.getStore()){
			throw new OptionNotSupportedException("store");
		}

		//Initialize input parameters
		String _processId = request.getIdentifier().getStringValue();

		if (process instanceof MetadataAware) {
			MetadataAware _metadataAware = (MetadataAware) process;
			_metadataAware.setMetadata(metadata);
		}
		
		//Initialize the output data types and datasets
		Map<String, OutputDescriptionType> _outputDefinitions = new HashMap<String, OutputDescriptionType>();
		Map<String, List<IOValueType>> _outputs = new HashMap<String, List<IOValueType>>();
		for(OutputDescriptionType _outputType : metadata.getProcessOutputs().getOutputArray()){
			_outputs.put(_outputType.getIdentifier().getStringValue(), new ArrayList<IOValueType>());
			_outputDefinitions.put(_outputType.getIdentifier().getStringValue(), _outputType);
		}
		
		//Initialize the input data types and datasets
		Map<String, InputDescriptionType> _inputDefinitions = new HashMap<String, InputDescriptionType>();
		Map<String, List<IOValueType>> _inputs = new HashMap<String, List<IOValueType>>();
		for(InputDescriptionType _inputType : metadata.getDataInputs().getInputArray()){
			_inputs.put(_inputType.getIdentifier().getStringValue(), new ArrayList<IOValueType>());
			_inputDefinitions.put(_inputType.getIdentifier().getStringValue(), _inputType);
		}
		
		process.setInputs(_inputs);
		process.setOutputs(_outputs);
		
		if (process instanceof ParameterDefinitionAware) {
			ParameterDefinitionAware _parameterDefAware = (ParameterDefinitionAware) process;
			
			_parameterDefAware.setInputDefinitions(_inputDefinitions);
			_parameterDefAware.setOutputDefinitions(_outputDefinitions);
		}
		
		//Initialize the input data
		for(IOValueType _inputParam : request.getDataInputs().getInputArray()){
			process.getInputs().get(_inputParam.getIdentifier().getStringValue()).add(_inputParam);
		}
		
		this.process = process;
		this.request = request;
		this.metadata = metadata;
	}

	@Override
	public void run() {
		try{
			this.status = new ProcessAccepted();
			//execute the model process
			process.execute();
			this.status = new ProcessSucceeded();			
		}
		catch(ProcessingException err){
			log.log(Level.SEVERE, "Failed to execute", err);
			this.status = new ProcessFailed(err);
		}
		catch(Exception err){
			log.log(Level.SEVERE, "Failed to execute", err);
			this.status = new ProcessFailed(new NoApplicableCodeException(err.getMessage()));			
		}
	}

	/**
	 * @return Processing object
	 */
	public Processing getProcess() {
		return process;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	/**
	 * @return Metadata of the process
	 */
	public ProcessDescriptionType getMetadata() {
		return metadata;
	}
	
	/**
	 * 
	 * Create and return a ExecuteResponseDocument object, which identifies the current process status
	 * 
	 * @return 
	 */
	public ExecuteResponseDocument createReponse() {
		ExecuteResponseDocument _doc = ExecuteResponseDocument.Factory.newInstance();
		ExecuteResponseType _response = _doc.addNewExecuteResponse();
		
		_response.setVersion(WPS.WPS_VERSION);
		_response.setIdentifier(this.metadata.getIdentifier());
		
		StatusType _status = _response.addNewStatus();
		this.getStatus().encode(_status);
		
		ProcessOutputs _outputs = _response.addNewProcessOutputs();
		List<IOValueType> _outputParams = new ArrayList<IOValueType>();
		for(String _outputKey : this.getProcess().getOutputs().keySet()){
			for(IOValueType _outputValue : this.getProcess().getOutputs().get(_outputKey)){
				_outputParams.add(_outputValue);
			}
		}
		_outputs.setOutputArray((IOValueType[])_outputParams.toArray(new IOValueType[0]));
		
		return _doc;
	}
}
