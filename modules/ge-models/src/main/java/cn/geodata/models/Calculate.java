package cn.geodata.models;

/**
 * Interface for geo-spatial processing
 * 
 * @author tank
 *
 */
public interface Calculate {
	
	/**
	 * Percent of the process
	 * 
	 * @return
	 */
	int getPercent();
	
	/**
	 * Status of the process
	 * 
	 * @return
	 */
	String getStatus();
	
	/**
	 * Cancel the process
	 */
	void cancel();
	
	/**
	 * Run the calculation
	 * 
	 * @throws Exception
	 */
	void calculate() throws Exception;

}
