package cn.geodata.models.wetland.actions.map;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

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
		this.chartOut.setShowLegend(true);
		
		charts = new HashMap<String, ChartModel>();
		
		
		charts.put("eT", new ChartModel("ET", "Date", "C", "ET(mm)", new Color(200, 55, 55) , new BasicStroke(1.0f)));
		charts.put("waterLevel", new ChartModel("Water Level", "Date", "m", "Water Level(m)", new Color(55, 55, 200) , new BasicStroke(1.0f)));
		charts.put("precipitation", new ChartModel("Precipitation", "Date", "m3/s", "Precipitation(cm)", new Color(55, 200, 55) , new BasicStroke(1.0f)));
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
		
		List<TimeSeries> _series = new ArrayList<TimeSeries>();
		List<ChartModel> _charts = new ArrayList<ChartModel>();
		
		String[] _tags = this.tag.split("\\s*,\\s*");
		for(String _t : _tags){
			_series.add(this.createTimeSeries4Tag(_t));
			_charts.add(this.charts.get(_t));
		}
		
		String _xAxisTitle= null; //"Date";
		String _yAxisTitle= "Waterlevel";
		String _title= null; //"WaterLevel";
		
		stream = this.chartOut.outputTags(_charts, _series, _title, _xAxisTitle, _yAxisTitle);
		
		return "success";
	}
	
	private TimeSeries createTimeSeries4Tag(String tag){
		JSONObject _data = this.manage.getProcess(id).getData();
		ChartModel _char = this.charts.get(tag);
		
		JSONArray _dates = _data.getJSONArray("date");
		JSONArray _items = _data.getJSONArray(tag);
		
        TimeSeries _s1 = new TimeSeries(_char.getSeriesTitle(), Day.class);
		for(int i=0;i<_dates.size();i++){
			_s1.add(new Day(new Date(_dates.getLong(i))), _items.getDouble(i));
		}
		
		return _s1;
	}
}
