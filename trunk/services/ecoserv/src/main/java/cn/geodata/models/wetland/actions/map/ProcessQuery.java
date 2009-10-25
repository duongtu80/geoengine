package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Logger;

import net.sf.json.JSONObject;

public class ProcessQuery extends AbstractProcess {
	private Logger log = Logger.getAnonymousLogger();
	
	private String id;
	private InputStream stream;
	private long date;
	
	public void setDate(long date) {
		this.date = date;
	}

	public ProcessQuery(){
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public InputStream getStream() {
		return stream;
	}

	public String execute() throws Exception {
		JSONObject _status = this.manage.getProcess(id).getStatus();
		stream = new ByteArrayInputStream(_status.toString().getBytes("utf-8"));		
		
		return "success";
	}
}
