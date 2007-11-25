package cn.geodata.models.web.wps.operation;

import org.apache.xmlbeans.XmlObject;

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
		return "0.4.0";
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
	public abstract XmlObject execute(XmlObject input) throws Exception;
}
