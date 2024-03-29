package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.encoders.EncoderUtil;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;
import cn.geodata.models.exception.ProcessingException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class ChartWaterTable {
	private static Logger log = Logger.getAnonymousLogger();
	
	private String pt;
	private InputStream stream;
	private int width;
	private int height;
	private long startDate;
	private long endDate;
	private DayMetReader dayMetReader;
	private String tempDir;
	private String param;

	public void setTempDir(String tempDir) {
		this.tempDir = tempDir;
	}

	public void setDayMetReader(DayMetReader dayMetReader) {
		this.dayMetReader = dayMetReader;
	}
	
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public String execute() throws Exception {
		if(this.pt == null || this.pt.length() == 0){
			throw new NullPointerException("Noloation information be provided");
		}
		String[] _parts = this.pt.split(", ");
		if(_parts.length != 2){
			throw new ArrayIndexOutOfBoundsException(_parts.length);
		}
		
		double _x = Double.parseDouble(_parts[0]);
		double _y = Double.parseDouble(_parts[1]);

		ProcessLibrary _library = ProcessLibrary.createInstance();

		Date _startDate = new Date(this.startDate);
		Date _endDate = new Date(this.endDate);

		GeometryFactory _factory = new GeometryFactory();
		Point _location = _factory.createPoint(new Coordinate(_x, _y));
		
		Processing _ctModel = _library.createProcess("LocateWetland");
		_library.setInput(_ctModel, "Location", _location);
		_library.executeProcess(_ctModel);

		ArrayList<DayMet> _daymets = dayMetReader.read(_startDate, _endDate, (String)_library.getOutput(_ctModel, "Code"), _location.getX(), _location.getY());
		
		String _xAxisTitle= null; //"Date";
		String _yAxisTitle= "Waterlevel";
		String _title= null; //"WaterLevel";
	
		log.info("Params:" + param);
	
		JSONObject _input = JSONObject.fromObject(param);

		Processing _etModel = this.createProcess(_library, _input.getJSONObject("ET"));
		Processing _wtModel = this.createProcess(_library, _input.getJSONObject("WT"));

		JSONArray _waterTableArray = new JSONArray();
		JSONArray _dateTimeArray = new JSONArray();
		
        TimeSeries s1 = new TimeSeries("WaterTable (m)", Day.class);
        TimeSeries s2 = new TimeSeries("ET (cm)", Day.class);
        TimeSeries s3 = new TimeSeries("Prep (cm)", Day.class);

        _library.setInput(_wtModel, "WaterLevel", 0);
        for(int i=0;i<_daymets.size();i++){
        	_library.setInput(_etModel, "Tday", _daymets.get(i).getTday());
        	_library.setInput(_etModel, "Srad", _daymets.get(i).getSrad());
        	_library.setInput(_etModel, "Vpd", _daymets.get(i).getVpd());
        	
        	_library.setInput(_wtModel, "Precipitation", _daymets.get(i).getPrcp());
        	_library.setInput(_wtModel, "Et", _library.getOutput(_etModel, "Et"));
        	_library.executeProcess(_wtModel);
        	
        	_library.executeProcess(_etModel);
        	
        	Date _date = _daymets.get(i).getDate();
        	Day _day = new Day(_date);

        	double _waterLevel = (Double)_library.getOutput(_wtModel, "WaterLevel");
        	if(_waterLevel <= 0)
        		_waterLevel = 0;
        	else{
            	_waterLevel = Math.round(_waterLevel * 100) / 100.0;
        	}
        	
        	s1.add(_day, _waterLevel);
        	s2.add(_day, (Double)_library.getOutput(_etModel, "Et") / 10.0);
        	s3.add(_day, _daymets.get(i).getPrcp());
  
        	_dateTimeArray.add(_date.getTime());
        	_waterTableArray.add(_waterLevel);
//        	_waterTable.put(_daymets.get(i).getDate().toLocaleString(), waterTableModel.getWaterLevel());
//        	System.out.println(waterTableModel.getWaterLevel() + "," + waterTableModel.getEtModel().getEt());
        }
        
		JSONObject _dataObj = new JSONObject();
		_dataObj.put("water", _waterTableArray);
		_dataObj.put("date", _dateTimeArray);
		_dataObj.put("size", _waterTableArray.size());
        
//        System.out.println(_daymets.get(0).getX() + "," + _daymets.get(0).getY());
        
	    TimeSeriesCollection dataset = new TimeSeriesCollection();
	    dataset.addSeries(s1);
	    dataset.addSeries(s2);
	    dataset.addSeries(s3);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                _title,  // title
                _xAxisTitle,             // x-axis label
                _yAxisTitle,   // y-axis label
                dataset,            // data
                true,               // create legend?
                true,               // generate tooltips?
                false               // generate URLs?
            );
        String _code = Long.toHexString((new Date()).getTime());
        
        OutputStream _outputStream = FileUtils.openOutputStream(new File(this.tempDir, _code));
        EncoderUtil.writeBufferedImage(chart.createBufferedImage(this.width, this.height), "png", _outputStream);
        _outputStream.close();
        
		JSONObject _object = new JSONObject();
		_object.put("status", "finish");
		_object.put("code", _code);
		_object.put("pt", this.pt);
		_object.put("data", _dataObj);
		

		this.stream = new ByteArrayInputStream(_object.toString().getBytes());
        
		return "success";
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
	
	public void setParam(String param) {
		this.param = param;
	}

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public InputStream getStream() {
		return stream;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
