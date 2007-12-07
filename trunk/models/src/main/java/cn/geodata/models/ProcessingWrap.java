package cn.geodata.models;

import java.util.logging.Level;
import java.util.logging.Logger;

import cn.geodata.models.exception.NoApplicableCodeException;
import cn.geodata.models.exception.ProcessingException;
import cn.geodata.models.status.ProcessAccepted;
import cn.geodata.models.status.ProcessFailed;
import cn.geodata.models.status.ProcessSucceeded;
import cn.geodata.models.status.Status;

public class ProcessingWrap implements Runnable {
	private static Logger log = Logger.getLogger("cn.geodata.models");
	
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
}
