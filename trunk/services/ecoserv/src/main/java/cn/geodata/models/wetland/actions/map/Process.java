package cn.geodata.models.wetland.actions.map;

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
