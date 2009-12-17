/**
 * 
 */
package cn.geodata.models.glacier.actions.models;

import net.sf.json.JSONObject;

/**
 * @author tank
 *
 */
public interface Process {
	String getId();
	boolean isDone();
	JSONObject getStatus();
	JSONObject getData();
}
