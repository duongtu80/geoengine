package cn.geodata.models.glacier.actions.models;

import java.io.ByteArrayInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RunoffView extends AbstractRunoff {
	private static Logger log = Logger.getAnonymousLogger();
	
	private String code;
	
	private List<String> dateList;
	private List<String> runoffList;
	private List<String> temperatureList;
	private List<String> precipitationList;
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public List<String> getRunoffList() {
		return runoffList;
	}

	public List<String> getDateList() {
		return dateList;
	}

	public List<String> getTemperatureList() {
		return temperatureList;
	}

	public List<String> getPrecipitationList() {
		return precipitationList;
	}

	public String execute() throws Exception {
		JSONObject _data = this.manage.getProcess(code).getData();
		
		JSONArray _dateList = _data.getJSONArray("Date");
		JSONArray _runoffList = _data.getJSONArray("Runoff");
		JSONArray _temperatureList = _data.getJSONArray("Temperature");
		JSONArray _precipitationList = _data.getJSONArray("Precipitation");
		
		this.dateList = new ArrayList<String>();
		this.runoffList = new ArrayList<String>();
		this.temperatureList = new ArrayList<String>();
		this.precipitationList = new ArrayList<String>();
		
		SimpleDateFormat _dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DecimalFormat _numbFormat = new DecimalFormat("0.00");
		
		for(int i=0;i<_dateList.size();i++){
			Long _time = _dateList.getLong(i);
			
			this.dateList.add(_dateFormat.format(_time));
			this.runoffList.add(_numbFormat.format(_runoffList.getDouble(i)));
			this.temperatureList.add(_numbFormat.format(_temperatureList.getDouble(i)));
			this.precipitationList.add(_numbFormat.format(_precipitationList.getDouble(i)));
		}
		
		return "success";
	}

}
