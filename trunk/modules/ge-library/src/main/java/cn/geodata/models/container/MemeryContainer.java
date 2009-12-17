package cn.geodata.models.container;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import cn.geodata.models.ProcessContainer;
import cn.geodata.models.Processing;

public class MemeryContainer implements ProcessContainer {
	private Logger log = Logger.getAnonymousLogger();
	private Map<String, Processing> processes;
	
	public MemeryContainer(){
		this.processes = new HashMap<String, Processing>();
	}
	
	public void pushProcess(Processing proc){
		this.processes.put(proc.getProcessId(), proc);
	}
	
	public Processing getProcess(String id){
		if(this.processes.containsKey(id)){
			return this.processes.get(id);
		}
		
		log.severe("没有模型进程:" + id + Arrays.toString(getProcessIds().toArray()));
		throw new NullPointerException("没有找到模型进程:" + id);
	}
	
	public Processing popProcess(String id){
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
