package cn.geodata.models.wetland.actions.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class ProcessManage {
	private Logger log = Logger.getAnonymousLogger();
	private Map<String, Process> processes;
	
	public ProcessManage(){
		this.processes = new HashMap<String, Process>();
	}
	
	public void pushProcess(Process proc){
		this.processes.put(proc.getId(), proc);
	}
	
	public Process getProcess(String id){
		if(this.processes.containsKey(id)){
			return this.processes.get(id);
		}
		
		log.severe("No process:" + id + Arrays.toString(getProcessIds().toArray()));
		throw new NullPointerException("Failed to find process:" + id);
	}
	
	public Process popProcess(String id){
		try{
			return this.processes.get(id);
		}
		finally{
			this.processes.remove(id);
		}
	}
	
	public Set<String> getProcessIds(){
		return this.processes.keySet();
	}
}
