package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ProcessView extends AbstractProcess {
	private static Logger log = Logger.getAnonymousLogger();
	
	private String code;
	
	private List<String> dateList;
	private List<String> etList;
	private List<String> waterLevelList;
	private List<String> precipitationList;
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public List<String> getEtList() {
		return etList;
	}

	public List<String> getDateList() {
		return dateList;
	}

	public List<String> getWaterLevelList() {
		return waterLevelList;
	}

	public List<String> getPrecipitationList() {
		return precipitationList;
	}

	public String execute() throws Exception {
		JSONObject _data = this.manage.getProcess(code).getData();
		
		JSONArray _dateList = _data.getJSONArray("Date");
		JSONArray _etList = _data.getJSONArray("ET");
		JSONArray _waterLevelList = _data.getJSONArray("WaterLevel");
		JSONArray _precipitationList = _data.getJSONArray("Precipitation");
		
		this.dateList = new ArrayList<String>();
		this.etList = new ArrayList<String>();
		this.waterLevelList = new ArrayList<String>();
		this.precipitationList = new ArrayList<String>();
		
		SimpleDateFormat _dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DecimalFormat _numbFormat = new DecimalFormat("0.00");
		
		for(int i=0;i<_dateList.length();i++){
			Long _time = _dateList.getLong(i);
			
			this.dateList.add(_dateFormat.format(_time));
			this.etList.add(_numbFormat.format(_etList.getDouble(i)));
			this.waterLevelList.add(_numbFormat.format(_waterLevelList.getDouble(i)));
			this.precipitationList.add(_numbFormat.format(_precipitationList.getDouble(i)));
		}
		
		return "success";
	}

}
