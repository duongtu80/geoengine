package cn.geodata.models;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.opengeospatial.wps.ExecuteResponseDocument;
import net.opengeospatial.wps.ExecuteResponseType;
import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.StatusType;
import net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs;

import cn.geodata.models.exception.NoApplicableCodeException;
import cn.geodata.models.exception.ProcessingException;
import cn.geodata.models.status.ProcessAccepted;
import cn.geodata.models.status.ProcessFailed;
import cn.geodata.models.status.ProcessSucceeded;
import cn.geodata.models.status.Status;
import cn.geodata.models.util.Utilities;

public class ProcessingWrap implements Runnable {
	private static Logger log = Utilities.getLogger();
	
	private Processing process;
	private Status status; 
	
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

	public Processing getProcess() {
		return process;
	}

	public void setProcess(Processing process) {
		this.process = process;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public ExecuteResponseDocument createReponse() {
		ExecuteResponseDocument _doc = ExecuteResponseDocument.Factory.newInstance();
		ExecuteResponseType _response = _doc.addNewExecuteResponse();
		
		_response.setVersion(WPS.WPS_VERSION);
		_response.setIdentifier(this.getProcess().get);
		
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
	}
}
