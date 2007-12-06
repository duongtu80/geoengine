package cn.geodata.model;

import java.util.List;
import java.util.Map;

import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.InputDescriptionType;
import net.opengeospatial.wps.OutputDescriptionType;
import net.opengeospatial.wps.ProcessDescriptionType;

import org.apache.log4j.Logger;

import cn.geodata.model.exception.NoApplicableCodeException;
import cn.geodata.model.exception.ProcessingException;
import cn.geodata.model.status.ProcessAccepted;
import cn.geodata.model.status.ProcessFailed;
import cn.geodata.model.status.ProcessSucceeded;
import cn.geodata.model.status.Status;

/**
 * 
 * @author Fengm
 *
 */
public abstract class GeoProcessing implements Runnable {
	private static Logger Log = Logger.getLogger(GeoProcessing.class);
	
	private ProcessDescriptionType metadata;
	
	private Map<String, OutputDescriptionType> outputDefinitions;
	private Map<String, InputDescriptionType> inputDefinitions;
	
	private Map<String, List<IOValueType>> inputs;
	private Map<String, List<IOValueType>> outputs;
	
	private Status Status;
	
	public Map<String, List<IOValueType>> getInputs() {
		return inputs;
	}

	/**
	 * 
	 * @param inputs
	 */
	public void setInputs(Map<String, List<IOValueType>> inputs) {
		this.inputs = inputs;
	}

	/**
	 * 
	 * @return
	 */
	public Map<String, List<IOValueType>> getOutputs() {
		return outputs;
	}

	/**
	 * 
	 * @param output
	 */
	public void setOutputs(Map<String, List<IOValueType>> outputs) {
		this.outputs = outputs;
	}

	/**
	 * 
	 * @return
	 */
	public Status getStatus() {
		return Status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(Status status) {
		Status = status;
	}

	/**
	 * 
	 */
	protected abstract void execute() throws Exception;

	@Override
	public void run() {
		try{
			this.Status = new ProcessAccepted();
			//execute the model process
			this.execute();
			this.Status = new ProcessSucceeded();			
		}
		catch(ProcessingException err){
			Log.error("Failed to execute", err);
			this.Status = new ProcessFailed(err);
		}
		catch(Exception err){
			Log.error("Failed to execute", err);
			this.Status = new ProcessFailed(new NoApplicableCodeException(err.getMessage()));			
		}
	}

	public ProcessDescriptionType getMetadata() {
		return metadata;
	}

	public void setMetadata(ProcessDescriptionType metadata) {
		this.metadata = metadata;
	}

	public Map<String, OutputDescriptionType> getOutputDefinitions() {
		return outputDefinitions;
	}

	public Map<String, InputDescriptionType> getInputDefinitions() {
		return inputDefinitions;
	}

	public void setOutputDefinitions(
			Map<String, OutputDescriptionType> outputDefinitions) {
		this.outputDefinitions = outputDefinitions;
	}

	public void setInputDefinitions(
			Map<String, InputDescriptionType> inputDefinitions) {
		this.inputDefinitions = inputDefinitions;
	}
}
