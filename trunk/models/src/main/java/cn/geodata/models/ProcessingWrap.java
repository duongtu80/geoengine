package cn.geodata.models;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeTypeParseException;
import javax.xml.parsers.ParserConfigurationException;

import net.opengeospatial.wps.ExecuteResponseDocument;
import net.opengeospatial.wps.ExecuteResponseType;
import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.OutputDefinitionType;
import net.opengeospatial.wps.StatusType;
import net.opengeospatial.wps.ExecuteDocument.Execute;
import net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs;

import org.xml.sax.SAXException;

import cn.geodata.models.data.DataParser;
import cn.geodata.models.exception.NoApplicableCodeException;
import cn.geodata.models.exception.OptionNotSupportedException;
import cn.geodata.models.exception.ProcessingException;
import cn.geodata.models.geoprocessing.ProcessType;
import cn.geodata.models.geoprocessing.ValueType;
import cn.geodata.models.status.ProcessAccepted;
import cn.geodata.models.status.ProcessFailed;
import cn.geodata.models.status.ProcessSucceeded;
import cn.geodata.models.status.Status;
import cn.geodata.models.util.Utilities;

public class ProcessingWrap implements Runnable {
	private static Logger log = Utilities.getLogger();
	
	private ProcessType metadata;
	private Processing process;
	private Status status; 
	private Execute request;
	
	private Map<String, ValueType> outputDefinitions;
	private Map<String, ValueType> inputDefinitions;
	
	private boolean store;
	
	public Execute getRequest() {
		return request;
	}

	public ProcessingWrap(Processing process, ProcessType metadata, Execute request) throws OptionNotSupportedException, IOException {
		this.store = request.getStore();

		//Initialize input parameters
		String _processId = request.getIdentifier().getStringValue();

		if (process instanceof MetadataAware) {
			MetadataAware _metadataAware = (MetadataAware) process;
			_metadataAware.setMetadata(metadata);
		}
		
		//Initialize the output data types and datasets
		outputDefinitions = new HashMap<String, ValueType>();
		Map<String, List<IOValueType>> _rawOutputs = new HashMap<String, List<IOValueType>>();
		for(ValueType _outputType : metadata.getOutputs().getOutputArray()){
			_rawOutputs.put(_outputType.getId(), new ArrayList<IOValueType>());
			outputDefinitions.put(_outputType.getId(), _outputType);
		}
		
		//Initialize the input data types and datasets
		inputDefinitions = new HashMap<String, ValueType>();
		Map<String, List<IOValueType>> _rawInputs = new HashMap<String, List<IOValueType>>();
		
		for(ValueType _inputType : metadata.getInputs().getInputArray()){
			_rawInputs.put(_inputType.getId(), new ArrayList<IOValueType>());
			inputDefinitions.put(_inputType.getId(), _inputType);
		}
		
		if (process instanceof ParameterDefinitionAware) {
			ParameterDefinitionAware _parameterDefAware = (ParameterDefinitionAware) process;
			
			_parameterDefAware.setInputDefinitions(inputDefinitions);
			_parameterDefAware.setOutputDefinitions(outputDefinitions);
		}
		
		if (process instanceof RawParameterAware) {
			RawParameterAware _rawParameterAware = (RawParameterAware) process;

			//Initialize the raw input data
			for(IOValueType _inputParam : request.getDataInputs().getInputArray()){
				_rawInputs.get(_inputParam.getIdentifier().getStringValue()).add(_inputParam);
			}

			_rawParameterAware.setRawInputs(_rawInputs);
			_rawParameterAware.setRawOutputs(_rawOutputs);
		}
		
		if (process instanceof ParameterAware) {
			Map<String, Object> _inputs = new HashMap<String, Object>();
			Map<String, Object> _outputs = new HashMap<String, Object>();			
			
			DataParser _dataParser = DataParser.getInstance();
			
			//Initialize the input data
			for(IOValueType _inputParam : request.getDataInputs().getInputArray()){
				String _id = _inputParam.getIdentifier().getStringValue(); 
				_inputs.put(_id, _dataParser.parse(inputDefinitions.get(_id), _inputParam));
			}
			
			ParameterAware _parameterAware = (ParameterAware) process;
			_parameterAware.setInputs(_inputs);
			this.initializeInputs(_parameterAware);
			
			_parameterAware.setOutputs(_outputs);
		}
		
		this.process = process;
		this.request = request;
		this.metadata = metadata;
	}

	public void run() {
		try{
			this.status = new ProcessAccepted();
			//execute the model process
			process.execute();
			
			this.initializeOutputs((ParameterAware) process);
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
	public ProcessType getMetadata() {
		return metadata;
	}
	
	/**
	 * 
	 * Create and return a ExecuteResponseDocument object, which identifies the current process status
	 * 
	 * @return 
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 * @throws MimeTypeParseException 
	 * @throws IOException 
	 */
	public ExecuteResponseDocument createReponse() throws IOException {
		ExecuteResponseDocument _doc = ExecuteResponseDocument.Factory.newInstance();
		ExecuteResponseType _response = _doc.addNewExecuteResponse();
		
		_response.setVersion(WPS.WPS_VERSION);
		_response.addNewIdentifier().setStringValue(this.metadata.getId());
		
		StatusType _status = _response.addNewStatus();
		this.getStatus().encode(_status);
		
		List<IOValueType> _outputParams = new ArrayList<IOValueType>();
		if (this.process instanceof RawParameterAware) {
			//Raw parameters
			RawParameterAware _rawParameterAware = (RawParameterAware) this.process;
			
			for(String _outputKey : _rawParameterAware.getRawOutputs().keySet()){
				for(IOValueType _outputValue : _rawParameterAware.getRawOutputs().get(_outputKey)){
					_outputParams.add(_outputValue);
				}
			}
		}
		else if(this.process instanceof ParameterAware){
			ParameterAware _parameterAware = (ParameterAware) this.process;
			Map<String, Object> _outputs = _parameterAware.getOutputs();
			
			DataParser _dataParser = DataParser.getInstance();
			for(String _key : _outputs.keySet()){
				if(this.outputDefinitions.get(_key) == null){
					throw new NullPointerException("Failed to find definition for parameter " + _key);
				}
				
				_outputParams.add(_dataParser.encode(this.outputDefinitions.get(_key), findOutputRequest(_key), _outputs.get(_key), this.store));
			}
		}
		ProcessOutputs _outputs = _response.addNewProcessOutputs();
		_outputs.setOutputArray((IOValueType[])_outputParams.toArray(new IOValueType[0]));			
		
		return _doc;
	}
	

	public static Method findInputMethod(ParameterAware proc, String name){
		for(Method _m : proc.getClass().getDeclaredMethods()){
			if(("set" + name).equalsIgnoreCase(_m.getName()) && _m.getDeclaringClass().equals(AbstractProcessing.class) == false && _m.getAnnotation(GeoInput.class) != null){
				return _m;
			}
		}
		
		return null;
	}
	
	public static void initializeInputs(ParameterAware proc) {
		for(String _key : proc.getInputs().keySet()){
			Method _m = findInputMethod(proc, _key);
			if(_m != null){
				try {
					_m.invoke(proc, proc.getInputs().get(_key));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				log.info("Set " + _key + ":" + proc.getInputs().get(_key));
			}
		}
	}
	
	public static void initializeOutputs(ParameterAware proc) {
		for(Method _m : proc.getClass().getDeclaredMethods()){
			if(_m.getName().startsWith("get") && _m.getAnnotation(GeoOutput.class) != null){
				try {
					proc.getOutputs().put(_m.getName().substring(3), _m.invoke(proc));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	protected OutputDefinitionType findOutputRequest(String id){
		if(this.request.getOutputDefinitions() == null){
			return null;
		}
		for(OutputDefinitionType _type : this.request.getOutputDefinitions().getOutputArray()){
			if(_type.getIdentifier().getStringValue().equalsIgnoreCase(id)){
				return _type;
			}
		}
		return null;
	}
}
