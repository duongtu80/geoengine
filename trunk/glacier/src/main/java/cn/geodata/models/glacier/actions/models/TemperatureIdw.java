package cn.geodata.models.glacier.actions.models;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.encoders.EncoderUtil;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.wps.client.WpsProcess;
import cn.geodata.models.wps.client.WpsService;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;

public class TemperatureIdw {
	private Logger log = Logger.getLogger(TemperatureIdw.class.getName());
	private InputStream stream;
	
	private int startYear;
	private int endYear;
	private String modelUrl;
	private String modelId;
	private double x;
	private double y;

	private double maxDistance;
	private int pow;
	private int maxCount;
	
	private String tempDir;
	private String title;
	private String xAxis;
	private String yAxis;
	private boolean showLegend;
	private int width;
	private int height;
	
	public TemperatureIdw(){
		startYear = 1980;
		endYear = 1990;
		modelUrl = "http://127.0.0.1:59080/web/wps";
		modelId = "Glacier.TemperatureIdw";
		x = 110;
		y = 33;
		
		maxDistance = 0;
		maxCount = 0;
		pow = 2;
		
		tempDir = "/tmp";
		title = "气温变化";
		xAxis = "月份";
		yAxis = "气温";
		showLegend = false;
		width = 800;
		height = 300;
	}
	
	public String execute() throws Exception {
		WpsService _s = new WpsService(new URI(this.modelUrl));
		_s.connect();
		
		WpsProcess _p = _s.getWpsProcess(this.modelId);

        TimeSeries _s1 = new TimeSeries("温度 C", Month.class);
		
		JSONArray _list = new JSONArray();
		Date _endDate = new Date(this.endYear - 1900, 9, 1);
		for(Date _startDate = new Date(this.startYear - 1900, 9, 1); _startDate.before(_endDate);){
			double _val = this.calculate(_p, _startDate);

			_s1.add(new Month(_startDate), _val);

			JSONObject _item = new JSONObject();
			_item.put("date", _startDate.getTime());
			_item.put("val", _val);
			_list.put(_item);
			
			Calendar _c = Calendar.getInstance();
			_c.setTime(_startDate);
			_c.add(Calendar.MONTH, 1);
			_startDate = _c.getTime();
		}
		
		String _code = this.outputChart(_s1);
		
		JSONObject _result = new JSONObject();
		_result.put("items", _list);
		_result.put("code", _code);
		
		this.stream = new ByteArrayInputStream(_result.toString().getBytes());
		
		return "success";
	}
	
	private String outputChart(TimeSeries s) throws IOException{
	    TimeSeriesCollection _dataset = new TimeSeriesCollection();
	    _dataset.addSeries(s);

        JFreeChart _chart = ChartFactory.createTimeSeriesChart(
                this.title,  // title
                this.xAxis,             // x-axis label
                this.yAxis,   // y-axis label
                _dataset,            // data
                this.showLegend,               // create legend?
                true,               // generate tooltips?
                false               // generate URLs?
            );
        
        String _code = Long.toHexString((new Date()).getTime());
        
        OutputStream _outputStream = FileUtils.openOutputStream(new File(this.tempDir, _code));
        EncoderUtil.writeBufferedImage(_chart.createBufferedImage(this.width, this.height), "png", _outputStream);
        _outputStream.close();
		
        return _code;
	}
	
	public double calculate(WpsProcess process, Date date) throws IOException{
		GeometryFactory _factory = new GeometryFactory();
		
		Map<String, Object> _inputs = new HashMap<String, Object>();
		
		_inputs.put("Date", date.getTime());
		_inputs.put("Pow", this.pow);
		_inputs.put("Site", _factory.createPoint(new Coordinate(this.x, this.y)));
		_inputs.put("MaxCount", this.maxCount);
		_inputs.put("MaxDistance", this.maxDistance);
		
		process.execute(_inputs);
		
		System.out.println(process.getResponse().xmlText());
		
		return (Double) process.getOutput("Temperature", DataCategories.getInstance().findCategory("double"));
	}

	public InputStream getStream() {
		return stream;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public void setModelUrl(String modelUrl) {
		this.modelUrl = modelUrl;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}

	public void setPow(int pow) {
		this.pow = pow;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
}
