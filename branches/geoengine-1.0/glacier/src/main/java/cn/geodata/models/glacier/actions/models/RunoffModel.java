package cn.geodata.models.glacier.actions.models;

import java.io.ByteArrayInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;

import com.vividsolutions.jts.geom.Coordinate;

import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.wps.client.WpsProcess;

public class RunoffModel extends PeriodChartModel {
	private String temperatureModelUrl; 
	private String precipitationModelUrl; 
	private String snowDdfModelUrl; 
	private String iceDdfModelUrl;
	
	private String basin;
	private double cellSize;
	private double rainCritical;
	private double snowCritical;
	
	public RunoffModel() {
		title = "径流变化";
		xAxis = "月份";
		yAxis = "流量 m3";

		modelUrl = "http://127.0.0.1:59080/web/wps";
		modelId = "Glacier.Runoff";
		
		cellSize = 1 / 1200;
		rainCritical = 5;
		snowCritical = 0;
		basin = "tailang";
		
		temperatureModelUrl = "http://127.0.0.1:59080/web/wps#Glacier.TemperatureIdw";
		precipitationModelUrl = "http://127.0.0.1:59080/web/wps#Glacier.PrecipitationIdw"; 
		snowDdfModelUrl = "http://127.0.0.1:59080/web/wps#Glacier.SnowDdfIdw"; 
		iceDdfModelUrl = "http://127.0.0.1:59080/web/wps#Glacier.IceDdfIdw";
	}

	public void setBasin(String basin) {
		this.basin = basin;
	}

	public void setCellSize(double cellSize) {
		this.cellSize = cellSize;
	}

	public void setRainCritical(double rainCritical) {
		this.rainCritical = rainCritical;
	}

	public void setSnowCritical(double snowCritical) {
		this.snowCritical = snowCritical;
	}

	public String execute() throws Exception {		
		WpsProcess _p = this.createProcess();
        TimeSeries _s1 = new TimeSeries("径流", Month.class);
		
		Map<String, Object> _inputs = new HashMap<String, Object>();
		
		_inputs.put("CatchmentId", this.basin);
		_inputs.put("CellSize", this.cellSize);
		_inputs.put("RainCritical", this.rainCritical);
		_inputs.put("SnowCritical", this.snowCritical);
		_inputs.put("StartDate", this.getStartDate().getTime());
		_inputs.put("EndDate", this.getEndDate().getTime());
		
		_p.execute(_inputs);
		
		String _txt = (String) _p.getOutput(_p.getResponse().getExecuteResponse().getProcessOutputs().getOutputArray()[0].getIdentifier().getStringValue(), DataCategories.getInstance().findCategory("string"));
		JSONObject _out = JSONObject.fromString(_txt);

		JSONArray _list = (JSONArray) _out.get("runoff");
		for (int i = 0; i < _list.length(); i++) {
			JSONObject _run = _list.getJSONObject(i);
			
			_s1.add(new Month(new Date(_run.getLong("date"))), _run.getDouble("runoff"));
		}
		
		String _code = this.chart.outputChart(_s1, title, xAxis, yAxis);
		_out.put("code", _code);
		
//		this.stream = new ByteArrayInputStream(_result.toString().getBytes());
		this.stream = new ByteArrayInputStream(_out.toString().getBytes());
		
		return "success";
	}
}
