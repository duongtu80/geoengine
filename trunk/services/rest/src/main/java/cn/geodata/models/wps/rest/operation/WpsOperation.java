package cn.geodata.models.wps.rest.operation;

import org.apache.xmlbeans.XmlObject;

import cn.geodata.models.ProcessContainer;
import cn.geodata.models.wps.WPSException;

/**
 * Parent class of all WPS operations.
 * @author Tank
 *
 */
public abstract class WpsOperation{
	
	/**
	 * Get the version of WPS
	 * @return
	 */
	public String getVersion() {
		return "1.0.0";
	}
	
	/**
	 * Get the operation name
	 * @return
	 */
	public abstract String getOperationName();
	
	/**
	 * Call the operation
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public abstract XmlObject execute(ProcessContainer processes, XmlObject input) throws WPSException;
}
