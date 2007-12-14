package cn.geodata.models;

import java.util.List;
import java.util.Map;

import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.ExecuteDocument.Execute;

public interface Processing {
	void setInputs(Map<String, List<IOValueType>> inputs);
	Map<String, List<IOValueType>> getInputs();
	
	void setOutputs(Map<String, List<IOValueType>> outputs);
	Map<String, List<IOValueType>> getOutputs();

	/**
	 * @return The request of the processing
	 */
	Execute getRequest();
	
	/**
	 * @param req 
	 */
	void setRequest(Execute req);
	
	/**
	 * Execute the processing
	 * @throws Exception
	 */
	void execute() throws Exception;
}
