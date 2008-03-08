package cn.geodata.models.wetland.actions.map;

import java.awt.BasicStroke;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;

import org.jCharts.axisChart.AxisChart;
import org.jCharts.chartData.AxisChartDataSet;
import org.jCharts.chartData.DataSeries;
import org.jCharts.encoders.JPEGEncoder13;
import org.jCharts.encoders.PNGEncoder;
import org.jCharts.properties.AxisProperties;
import org.jCharts.properties.ChartProperties;
import org.jCharts.properties.LegendProperties;
import org.jCharts.properties.LineChartProperties;
import org.jCharts.properties.PointChartProperties;
import org.jCharts.test.TestDataGenerator;
import org.jCharts.types.ChartType;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;


public class ChartImage {
	private String api;
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
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
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
//		String _title= "WaterLevel";
		
		DataSeries dataSeries = new DataSeries( _chart.getXlabels(), _xAxisTitle, _yAxisTitle, null );

		double[][] _data = new double[_chart.getYlabels().length][12];
		int _row = 0;
		int _pos = 0;
		for(int i=0;i<_values.size();i++){
			if(_values.get(i).doubleValue() != Double.NaN)
				_data[_row][_pos] = _values.get(i).doubleValue() * 1000;
			else{
				_data[_row][_pos] = Double.NaN;
			}
			
			_pos++;
			if(_pos >= 12){
				_row ++;
				_pos = 0;
			}
		}
		
		String[] legendLabels= _chart.getYlabels();
		Paint[] paints= TestDataGenerator.getRandomPaints( _chart.getYlabels().length );

		Stroke[] strokes= new Stroke[_chart.getYlabels().length];
		Shape[] shapes= new Shape[_chart.getYlabels().length];
		for(int i=0;i<legendLabels.length;i++){
			strokes[i] = new BasicStroke( 3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 5f, new float[]{ 5f, 5f, 10f, 5f}, 4f );
			shapes[i] = PointChartProperties.SHAPE_CIRCLE;
		}
		
		LineChartProperties lineChartProperties= new LineChartProperties( strokes, shapes );

		AxisChartDataSet axisChartDataSet= new AxisChartDataSet( _data, legendLabels, paints, ChartType.LINE, lineChartProperties );

		dataSeries.addIAxisPlotDataSet( axisChartDataSet );

		ChartProperties chartProperties= new ChartProperties();
		AxisProperties axisProperties= new AxisProperties();
		LegendProperties legendProperties= new LegendProperties();
		
		AxisChart axisChart= new AxisChart( dataSeries, chartProperties, axisProperties, legendProperties, this.getWidth(), this.getHeight());
		
		ByteOutputStream _outputStream = new ByteOutputStream();
		PNGEncoder.encode(axisChart, (OutputStream)_outputStream);
		
		this.stream = _outputStream.newInputStream();

		return "success";
	}
}
