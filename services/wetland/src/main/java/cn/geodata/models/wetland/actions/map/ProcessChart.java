package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ProcessChart extends AbstractProcess {
	private Logger log = Logger.getAnonymousLogger();
	
	private String id;
	private String tag;
	private InputStream stream;
	private Map<String, ChartModel> charts;
	private ChartOutputter chartOut;
	
	public ProcessChart(){
		this.chartOut = new ChartOutputter();
		
		charts = new HashMap<String, ChartModel>();
		
		charts.put("ET", new ChartModel("ET", "Date", "C", "ET"));
		charts.put("WaterLevel", new ChartModel("Water Level", "Date", "m", "WaterLevel"));
		charts.put("Precipitation", new ChartModel("Precipitation", "Date", "m3/s", "Precipitation"));
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setId(String id) {
		this.id = id;
	}

	public InputStream getStream() {
		return stream;
	}

	public String execute() throws Exception {		
		JSONObject _status = this.manage.getProcess(id).getStatus();
		if((Integer)_status.get("percent") < 100){
			throw new Exception("Not finished");
		}
		
		JSONObject _data = this.manage.getProcess(id).getData();
		ChartModel _char = this.charts.get(this.tag);
		
		JSONArray _dates = _data.getJSONArray("Date");
		JSONArray _items = _data.getJSONArray(this.tag);
		
        TimeSeries _s1 = new TimeSeries(_char.getSeriesTitle(), Day.class);
		for(int i=0;i<_dates.length();i++){
			_s1.add(new Day(new Date(_dates.getLong(i))), _items.getDouble(i));
		}
		
		stream = this.chartOut.outputChart(_s1, _char.getTitle(), _char.getXAxis(), _char.getYAxis());
		
		return "success";
	}
}
