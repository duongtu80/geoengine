package cn.geodata.models.glacier.actions.models;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.logging.Logger;

import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RunoffData extends AbstractRunoff {
	private Logger log = Logger.getAnonymousLogger();
	
	private String id;
	private String tag;
	
	public void setTag(String tag) {
		this.tag = tag;
	}

	private InputStream stream;
	
	public void setId(String id) {
		this.id = id;
	}

	public InputStream getStream() {
		return stream;
	}

	public String execute() throws Exception {
		JSONObject _status = this.manage.getProcess(id).getStatus();
		if((Integer)_status.get("percent") < 100){
			throw new Exception("没有执行结束");
		}
		
		JSONObject _data = this.manage.getProcess(id).getData();
		stream = new ByteArrayInputStream(_data.toString().getBytes("utf-8"));		
		
		return "success";
	}
}
