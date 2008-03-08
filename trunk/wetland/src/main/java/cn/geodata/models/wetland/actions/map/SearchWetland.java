package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import net.sf.json.JSONObject;

public class SearchWetland {
	private String code;
	private String pt;
	private Catchment catchment;
	private InputStream stream;

	public InputStream getStream() {
		return stream;
	}

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String execute() throws Exception {
		this.code = this.catchment.findCatchment(pt);
		if(this.code == null){
			this.code = "not found";
		}
		
		JSONObject _object = new JSONObject();
		_object.put("code", this.code);
		_object.put("pt", this.pt);
		
		this.stream = new ByteArrayInputStream(_object.toString().getBytes());
		
		return "success";
	}

	public Catchment getCatchment() {
		return catchment;
	}

	public void setCatchment(Catchment catchment) {
		this.catchment = catchment;
	}
}
