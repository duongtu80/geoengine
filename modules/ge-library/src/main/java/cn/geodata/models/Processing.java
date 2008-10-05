package cn.geodata.models;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import cn.geodata.models.exception.ProcessingException;

public class Processing extends Thread {
	private static Logger log = Logger.getLogger(Processing.class.getName());
	
	private String id;
	private Calculate process;
	private Status status;
	private boolean running;
	private ProcessLibrary library;
	
	public String getProcessId() {
		return id;
	}

	public Calculate getProcess() {
		return process;
	}

	public synchronized Status getStatus() {
		if(this.running == true){
			return new Status(this.process.getPercent(), this.process.getStatus());
		}
		else{
			return status;
		}
	}

	public Processing(Calculate process, ProcessLibrary library) {
		this.id = Long.toHexString((new Date()).getTime());

		this.running = false;
		this.status = new Status(0, "");

		this.process = process;
		this.library = library;
	}
	
	public void run() {
		this.running = true;
		try{
			//execute the model process
			process.calculate();
			
			this.status = new Status(100, "");
		}
		catch(ProcessingException err){
			log.log(Level.SEVERE, "Failed to execute", err);
			this.status = new Status(err.getMessage());
		}
		catch(Exception err){
			log.log(Level.SEVERE, "Failed to execute", err);
			this.status = new Status(err.getMessage());
		}
		
		this.running = false;
	}
	
	public void setInput(String key, Object val) throws ProcessingException{
		this.library.setInput(this.process, key, val);
	}

	public Object getOutput(String key) throws ProcessingException{
		return this.library.getOutput(this.process, key);
	}
}
