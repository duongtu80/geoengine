package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.encoders.EncoderUtil;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import cn.geodata.models.wetland.Catchment;
import cn.geodata.models.wetland.DayMet;
import cn.geodata.models.wetland.DayMetReader;
import cn.geodata.models.wetland.WaterTableModel;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class ChartWaterTable {
	private String pt;
	private InputStream stream;
	private int width;
	private int height;
	private WaterTableModel waterTableModel;
	private Date startDate;
	private Date endDate;
	private DayMetReader dayMetReader;
	private String tempDir;
	
	public String getTempDir() {
		return tempDir;
	}

	public void setTempDir(String tempDir) {
		this.tempDir = tempDir;
	}

	public DayMetReader getDayMetReader() {
		return dayMetReader;
	}

	public void setDayMetReader(DayMetReader dayMetReader) {
		this.dayMetReader = dayMetReader;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public WaterTableModel getWaterTableModel() {
		return waterTableModel;
	}

	public void setWaterTableModel(WaterTableModel waterTableModel) {
		this.waterTableModel = waterTableModel;
	}

	public String execute() throws ParseException, IOException {
		if(this.pt == null || this.pt.length() == 0){
			throw new NullPointerException("Noloation information be provided");
		}
		String[] _parts = this.pt.split(", ");
		if(_parts.length != 2){
			throw new ArrayIndexOutOfBoundsException(_parts.length);
		}
		
		System.out.println("StartDate:" + startDate.toString());
		System.out.println("EndDate:" + endDate.toString());

		GeometryFactory _factory = new GeometryFactory();
		Point _pt = _factory.createPoint(new Coordinate(Double.parseDouble(_parts[0]), Double.parseDouble(_parts[1])));
		
		ArrayList<DayMet> _daymets = dayMetReader.read(this.startDate, this.endDate, _pt.getX(), _pt.getY());
		
		String _xAxisTitle= null; //"Date";
		String _yAxisTitle= "Waterlevel";
		String _title= null; //"WaterLevel";
		
		waterTableModel.setWaterLevel(0);

		JSONArray _waterTableArray = new JSONArray();
		JSONArray _dateTimeArray = new JSONArray();
		
        TimeSeries s1 = new TimeSeries("WaterTable (m)", Day.class);
        TimeSeries s2 = new TimeSeries("ET (cm)", Day.class);
        TimeSeries s3 = new TimeSeries("Prep (cm)", Day.class);
        for(int i=0;i<_daymets.size();i++){
        	waterTableModel.setDayMet(_daymets.get(i));
        	waterTableModel.calculate();
        	
        	Date _date = _daymets.get(i).getDate();
        	Day _day = new Day(_date);

        	double _waterLevel = waterTableModel.getWaterLevel();
        	if(_waterLevel < 0)
        		_waterLevel = 0;
        	
        	s1.add(_day, _waterLevel);
        	s2.add(_day, waterTableModel.getEtModel().getEt() / 10.0);
        	s3.add(_day, _daymets.get(i).getPrcp());
  
        	_dateTimeArray.put(_date.getTime());
        	_waterTableArray.put(_waterLevel);
//        	_waterTable.put(_daymets.get(i).getDate().toLocaleString(), waterTableModel.getWaterLevel());
//        	System.out.println(waterTableModel.getWaterLevel() + "," + waterTableModel.getEtModel().getEt());
        }
        
		JSONObject _dataObj = new JSONObject();
		_dataObj.put("water", _waterTableArray);
		_dataObj.put("date", _dateTimeArray);
		_dataObj.put("size", _waterTableArray.length());
        
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
