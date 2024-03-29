package cn.geodata.models.wetland.actions.map;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;
import cn.geodata.models.exception.ProcessingException;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

public class WaterLevelProcess implements Process, Runnable {
	private static Logger log = Logger.getAnonymousLogger();

	private String id;
	private Date startDate;
	private Date endDate;
	private JSONObject status;
	private JSONObject data;
	private JSONObject input;
	private boolean done;
	private Catchment catchment;
	private String basin;
	private DayMetReader dayMetReader;

	public WaterLevelProcess(Date startDate, Date endDate, String basin, Catchment catchment, JSONObject input, DayMetReader dayMetReader) {
		this.id = Long.toHexString((new Date()).getTime());
		this.startDate = startDate;
		this.endDate = endDate;
		this.basin = basin;
		this.catchment = catchment;
		this.done = false;
		this.input = input;
		this.dayMetReader = dayMetReader;
		
		this.status = new JSONObject();
		this.status.put("message", "Initiallizing");
		this.status.put("percent", 0);
		this.status.put("id", this.id);
		this.status.put("basin", basin);
	}

	public JSONObject getData() {
		return data;
	}

	public String getId() {
		return this.id;
	}

	public JSONObject getStatus() {
		return this.status;
	}

	public boolean isDone() {
		return this.done;
	}

	public void run() {
		this.done = false;

		try {
			this.status.put("percent", 0);
			this.status.put("message", "Start calculation");
			
			MultiPolygon _border = this.catchment.findCatchmentByTag(this.basin);
			
			//Calculate daymet
			Point _center = _border.getCentroid();
			
			//Get data from one year before
			Calendar _c = Calendar.getInstance();
			_c.setTime(startDate);
			_c.add(Calendar.YEAR, -3);
			Date _startDate = _c.getTime();
			
			ArrayList<DayMet> _daymets = dayMetReader.read(_startDate, endDate, basin, _center.getX(), _center.getY());
			
			Map<String, List<Double>> _values = new HashMap<String, List<Double>>();
			for(String _b : new String[] {"tday", "srad", "vpd", "precipitation", "eT", "waterLevel"}){
				_values.put(_b, new ArrayList<Double>());
			}
			List<Long> _dates = new ArrayList<Long>();
			
			//Prepare calculation for ET and watertable
			ProcessLibrary _library = ProcessLibrary.createInstance();
			
			Processing _ctModel = _library.createProcess("TerrainModel");
			_ctModel.setInput("Catchment", _border);
			_library.executeProcess(_ctModel);
			
			double _spillPoint = (Double) _ctModel.getOutput("SpillPoint");
			double _area = this.catchment.projectCatchment(_border).getArea();

			//What's the unit of catchment area in the formula? km2, m2, or anything else?
			_area = _area / (1000 * 2); 
			_area = 3;
			
			log.info("catchment area " + _area);
			log.info("spill point " + _spillPoint);			

			Processing _etModel = this.createProcess(_library, input.getJSONObject("ET"));
			Processing _wtModel = this.createProcess(_library, input.getJSONObject("WaterTable"));
			
	        _wtModel.setInput("WaterLevel", 0);
	        _wtModel.setInput("SpillPoint", _spillPoint);
	        _wtModel.setInput("Area", _area);
	        
	        DateFormat _dateFormat = new SimpleDateFormat("dd/MM/yy");
	        for(int i=0;i<_daymets.size();i++){
	        	Date _date = _daymets.get(i).getDate();
	        	
				this.status.put("percent", (i * 100) / _daymets.size());
				this.status.put("message", "Cal " + _dateFormat.format(_date) + " " + this.basin + " water level");

	        	_etModel.setInput("Tday", _daymets.get(i).getTday());
	        	_etModel.setInput("Srad", _daymets.get(i).getSrad());
	        	_etModel.setInput("Vpd", _daymets.get(i).getVpd());
	        	
	        	_wtModel.setInput("Precipitation", _daymets.get(i).getPrcp());
	        	_wtModel.setInput("Et", _library.getOutput(_etModel, "Et"));
	        	
	        	_library.executeProcess(_wtModel);
	        	_library.executeProcess(_etModel);
	        	
	        	double _waterLevel = (Double)_wtModel.getOutput("WaterLevel");
	        	if(_waterLevel <= 0)
	        		_waterLevel = 0;
	        	else{
	            	_waterLevel = Math.round(_waterLevel * 100) / 100.0;
	        	}
	        	
	        	//Skip the first year
	        	if(_date.before(startDate)){
//	        		log.info("Skip " + _date.toLocaleString());
	        	}
	        	else{
		        	_dates.add(_date.getTime());

		        	_values.get("tday").add(_daymets.get(i).getTday());
		        	_values.get("srad").add(_daymets.get(i).getSrad());
		        	_values.get("vpd").add(_daymets.get(i).getVpd());
		        	_values.get("precipitation").add(_daymets.get(i).getPrcp());
		        	_values.get("eT").add((Double)_etModel.getOutput("Et") / 10.0);
		        	_values.get("waterLevel").add(_waterLevel);
		        	_values.get("vpd").add(_daymets.get(i).getVpd());
	        	}
	        }

			JSONObject _data = new JSONObject();
	        for(String _b : _values.keySet()){
	        	_data.put(_b, JSONArray.fromObject(_values.get(_b).toArray()));
	        }
	        _data.put("date", JSONArray.fromObject(_dates.toArray()));
	        
	        //Add additional parameters
	        JSONObject _inputs = new JSONObject();
	        _inputs.put("basin", this.basin);
	        _inputs.put("startDate", this.startDate.getTime());
	        _inputs.put("endDate", this.endDate.getTime());
	        _inputs.put("params", this.input);
	        
	        _data.put("inputs", _inputs);
	        
	        this.data = _data;
			
			this.status.put("percent", 100);
			this.status.put("message", "Finished");
		} catch (Exception e) {
			log.log(Level.WARNING, "Failed with water level process", e);
			
			this.status.put("percent", -1);
			this.status.put("message", "Failed:" + e.getMessage());
		}

		this.done = true;
	}
	
	private Processing createProcess(ProcessLibrary library, JSONObject param) throws ProcessingException{
		Processing _p = library.createProcess(param.getString("id"));
		
		JSONObject _params = param.getJSONObject("params");
		Iterator _keys = _params.keys();
		while(_keys.hasNext()){
			String _k = (String) _keys.next();
			library.setInput(_p, _k, _params.get(_k));
		}
		
		return _p;
	}
	
	private int getDaysOfMonth(Calendar c) {
		Calendar _dd = (Calendar) c.clone();
		_dd.add(Calendar.MONTH, 1);

		return (int) ((_dd.getTimeInMillis() - c.getTimeInMillis()) / (1000 * 60 * 60 * 24));
	}

}
