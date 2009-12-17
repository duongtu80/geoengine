package cn.geodata.models;

import java.util.Set;

/**
 * @author tank
 *
 */
public interface ProcessContainer {
	
	/**
	 * Add a process
	 * @param proc
	 */
	void pushProcess(Processing proc);
	
	/**
	 * Get a process
	 * @param id
	 * @return
	 */
	Processing getProcess(String id);
	
	/**
	 * Pop a process
	 * @param id
	 * @return
	 */
	Processing popProcess(String id);
	
	/**
	 * Get process list
	 * @return
	 */
	Set<String> getProcessIds();
}
