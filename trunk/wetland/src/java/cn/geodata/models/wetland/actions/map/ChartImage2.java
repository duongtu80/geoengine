package cn.geodata.models.wetland.actions.map;

import java.io.InputStream;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.encoders.EncoderUtil;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public class ChartImage2 {
	private int width;
	private int height;
	private String chartType;
	private String title;
	private ChartManager manager;
	private String wetland;
	private InputStream stream;
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public InputStream getStream() {
		return stream;
	}
	public String getWetland() {
		return wetland;
	}
	public void setWetland(String wetland) {
		this.wetland = wetland;
	}
	public ChartManager getManager() {
		return manager;
	}
	public void setManager(ChartManager manager) {
		this.manager = manager;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getChartType() {
		return chartType;
	}
	public void setChartType(String chartType) {
		this.chartType = chartType;
	}
	
	public String execute() throws Exception{		
		ChartData2 _chart = this.getManager().loadChartData2(this.getType());
		if(_chart.getData().containsKey(this.getWetland()) == false){
			throw new NullPointerException("Not found the request wetland");
		}
		
		ArrayList<Double> _values = _chart.getData().get(this.getWetland());
		
		String _xAxisTitle= "Month";
		String _yAxisTitle= "Waterlevel";
		String _title= null; //"WaterLevel";
		
        TimeSeries s1 = new TimeSeries(this.getWetland(), Month.class);
		int _row = 0;
		int _pos = 0;
		for(int i=0;i<_values.size();i++){
			if(_values.get(i).doubleValue() != Double.NaN){
				s1.add(new Month(_pos + 1, 1988 + _row), _values.get(i).doubleValue());
			}
			
			_pos++;
			if(_pos >= 12){
				_row ++;
				_pos = 0;
			}
		}
	
	    TimeSeriesCollection dataset = new TimeSeriesCollection();
	    dataset.addSeries(s1);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                _title,  // title
                _xAxisTitle,             // x-axis label
                _yAxisTitle,   // y-axis label
                dataset,            // data
                false,               // create legend?
                true,               // generate tooltips?
                false               // generate URLs?
            );

		ByteOutputStream _outputStream = new ByteOutputStream();
        EncoderUtil.writeBufferedImage(chart.createBufferedImage(this.width, this.height), "png", _outputStream);
		
		this.stream = _outputStream.newInputStream();

		return "success";
	}
}
