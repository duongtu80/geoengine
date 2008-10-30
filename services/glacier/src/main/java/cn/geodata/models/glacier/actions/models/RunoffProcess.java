package cn.geodata.models.glacier.actions.models;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;

import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;
import cn.geodata.models.exception.ProcessingException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

public class RunoffProcess implements Process, Runnable {
	private static Logger log = Logger.getAnonymousLogger();

	private String id;
	private double x;
	private double y;
	private int startYear;
	private int endYear;
	private String basin;
	private JSONObject status;
	private JSONObject data;
	private JSONObject input;
	private Date date;
	private boolean done;
//	private String fileCatchment;
//	private String fileGlacier;
	private double[] levels;
	private double[] areas;
	private Map<String, List<Object>> map;

	public RunoffProcess(double x, double y, int startYear, int endYear, String basin, JSONObject input, double[] levels, double[] areas) {
		this.id = Long.toHexString((new Date()).getTime());
		this.x = x;
		this.y = y;
		this.startYear = startYear;
		this.endYear = endYear;
		this.basin = basin;
		this.done = false;
		this.input = input;
		
		this.levels = levels;
		this.areas = areas;
		
//		this.fileCatchment = fileCatchment;
//		this.fileGlacier = fileGlacier;
		
		this.status = new JSONObject();
		this.status.put("message", "初始化");
		this.status.put("percent", 0);
		this.status.put("id", this.id);
		this.status.put("x", x);
		this.status.put("y", y);
		this.status.put("basin", basin);
	}

	public Date getDate() {
		return date;
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
			this.status.put("message", "计算分带冰川面积");
			
//			MultiPolygon _catchment = this.getCatchment(this.basin);
			ProcessLibrary _library = ProcessLibrary.createInstance();
			Point _pt = new GeometryFactory().createPoint(new Coordinate(x, y)); 

			// 计算中心点高程
			this.status.put("message", "计算中心点高程");
			
			Processing _demmModel = _library.createProcess("DemModel90m");
			_library.setInput(_demmModel, "Point", _pt);

			_library.executeProcess(_demmModel);
			double _elevation = (Double) _library.getOutput(_demmModel, "Elevation");

			_pt.getCoordinate().z = _elevation;

			Processing _tempModel = this.createProcess(_library, input.getJSONObject("Temperature"));
			Processing _precModel = this.createProcess(_library, input.getJSONObject("Precipitation"));
			Processing _snowModel = this.createProcess(_library, input.getJSONObject("SnowDDF"));
			Processing _iceeModel = this.createProcess(_library, input.getJSONObject("IceDDF"));

			_library.setInput(_tempModel, "Point", _pt);
			_library.setInput(_precModel, "Point", _pt);
			_library.setInput(_snowModel, "Point", _pt);
			_library.setInput(_iceeModel, "Point", _pt);
			
			_tempModel.setInput("Power", 3);
			_precModel.setInput("Power", 3);

			this.status.put("message", "计算冰度日因子");
			_library.executeProcess(_snowModel);
			this.status.put("message", "计算雪度日因子");
			_library.executeProcess(_iceeModel);

			Processing _runoModel = this.createProcess(_library, input.getJSONObject("Runoff"));
			_library.setInput(_runoModel, "Levels", levels);
			_library.setInput(_runoModel, "Areas", areas);
			_library.setInput(_runoModel, "Location", _pt);

			Date _startDate = new Date(this.startYear - 1900, 9, 1);
			Date _endDate = new Date(this.endYear - 1900, 9, 1);
			
			int _monthCount = (this.endYear - this.startYear) * 12;

			Calendar _calendar = Calendar.getInstance();
			_calendar.setTime(_startDate);

			DateFormat _format = new SimpleDateFormat("yyyy-MM");

			int _month = 0;
			double[] _accumulations = null;
			
			ArrayList<Long> _listDate = new ArrayList<Long>();
			ArrayList<Double> _listTemp = new ArrayList<Double>();
			ArrayList<Double> _listPrec = new ArrayList<Double>();
			ArrayList<Double> _listRuno = new ArrayList<Double>();
			ArrayList<Double> _listAcut = new ArrayList<Double>();
			
			String[] _listCols = new String[] {"Temperatures", "AccumulatedTemperatures", "Precipitations", "Runoffs", "Accumulations", "Balances"};
			String[] _valuCols = new String[] {"Temperature", "Precipitation", "Runoff"};
			
			//临时存储计算结果
			map = new HashMap<String, List<Object>>();
			for(String _key : _listCols){
				map.put(_key, new ArrayList<Object>());
			}
			for(String _key: _valuCols){
				map.put(_key, new ArrayList<Object>());
			}
			map.put("Dates", new ArrayList<Object>());
			
			while (_calendar.getTime().before(_endDate)) {
				Date _date = _calendar.getTime();
				int _days = this.getDaysOfMonth(_calendar);

				this.status.put("percent", (_month++ * 100) / _monthCount);
				this.status.put("message", "计算" + (_date.getYear() + 1900) + "年" + (_date.getMonth() + 1) + "月" + this.basin + "流域径流");
				
//				System.out.println("Date:" + _format.format(_date));
//				System.out.println("Days:" + _days);
//
				_library.setInput(_tempModel, "Date", _date);
				_library.executeProcess(_tempModel);

				_library.setInput(_precModel, "Date", _date);
				_library.executeProcess(_precModel);

				_library.setInput(_runoModel, "Temperature", (Double)_library.getOutput(_tempModel, "Temperature"));
				_library.setInput(_runoModel, "Precipitation", _library.getOutput(_precModel, "Precipitation"));
				_library.setInput(_runoModel, "PrecElevation", _library.getOutput(_precModel, "Elevation"));
				_library.setInput(_runoModel, "Accumulations", _accumulations);
				_library.setInput(_runoModel, "Days", _days);
				_library.setInput(_runoModel, "SnowDDF", (Double) _library.getOutput(_snowModel, "SnowDDF"));
				_library.setInput(_runoModel, "IceDDF", (Double) _library.getOutput(_iceeModel, "IceDDF"));
				_library.setInput(_runoModel, "Date", _date);

				_library.executeProcess(_runoModel);

				_accumulations = (double[]) _library.getOutput(_runoModel, "Accumulations");
				//如果是10月，则清理累积值
				if(_date.getMonth() != 9){
					_accumulations = _accumulations.clone();
				}
				else{
					_accumulations = new double[_accumulations.length];
				}

				double _runoff = 0;
				for (double _r : (double[]) _library.getOutput(_runoModel, "Runoffs")) {
					_runoff += _r;
				}
				
				_listDate.add(_calendar.getTimeInMillis());
				_listTemp.add((Double)_library.getOutput(_tempModel, "Temperature"));
				_listPrec.add((Double)_library.getOutput(_precModel, "Precipitation"));
				_listRuno.add(_runoff);
				
				for(String _key : _listCols){
					map.get(_key).add(_library.getOutput(_runoModel, _key));
				}
				map.get("Dates").add(_date);
				map.get("Temperature").add((Double)_library.getOutput(_tempModel, "Temperature"));
				map.get("Precipitation").add((Double)_library.getOutput(_precModel, "Precipitation"));
				map.get("Runoff").add(_runoff);

				// Jump to next month
				_calendar.add(Calendar.MONTH, 1);
//				Thread.sleep(1000);
			}
			
			JSONObject _data = new JSONObject();
			
			_data.put("Date", _listDate);
			_data.put("Temperature", JSONArray.fromCollection(_listTemp));
			_data.put("Precipitation", JSONArray.fromCollection(_listPrec));
			_data.put("Runoff", JSONArray.fromCollection(_listRuno));
			_data.put("SnowDDF", (Double)_library.getOutput(_snowModel, "SnowDDF"));
			_data.put("IceDDF", (Double)_library.getOutput(_iceeModel, "IceDDF"));
			_data.put("AuccumlatedTemperature", JSONArray.fromCollection(_listAcut));
			
			this.data = _data;
			
			this.status.put("percent", 100);
			this.status.put("message", "计算完毕");
		} catch (Exception e) {
			this.status.put("percent", -1);
			this.status.put("message", "计算失败:" + e.getMessage());
		}

		this.done = true;
	}
	
	public Map<String, List<Object>> getMap() {
		return map;
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
