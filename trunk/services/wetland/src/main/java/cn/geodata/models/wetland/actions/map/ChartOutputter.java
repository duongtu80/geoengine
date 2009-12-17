package cn.geodata.models.wetland.actions.map;

import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.encoders.EncoderUtil;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class ChartOutputter {
	private String tempDir;
	private boolean showLegend;
	private int width;
	private int height;
	
	public ChartOutputter(){
		tempDir = "/tmp";
		showLegend = false;
		width = 970;
		height = 300;
	}
	
	public InputStream outputTags(List<ChartModel> charts, List<TimeSeries> series, String title, String xAxis, String yAxis) throws IOException{
		TimeSeriesCollection _s = new TimeSeriesCollection();
		for(int i=0;i<series.size();i++){
			_s.addSeries(series.get(i));
		}
		
        JFreeChart _chart = ChartFactory.createTimeSeriesChart(
                title,  // title
                xAxis,   // x-axis label
                yAxis,   // y-axis label
                _s,      // data
                this.showLegend, // create legend?
                true,    // generate tooltips?
                false    // generate URLs?
            );
        
        TextTitle _title = _chart.getTitle();
        if(_title != null){
        	Font _font = new Font("Verdana", Font.PLAIN, 11);
        	_chart.getTitle().setFont(_font);
        }
        
        final XYPlot _plot = _chart.getXYPlot();
        //_plot.setOutlinePaint(null);
        _plot.setBackgroundPaint(Color.lightGray);
        _plot.setDomainGridlinePaint(Color.white);
        _plot.setRangeGridlinePaint(Color.white);
    //    _plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        _plot.setDomainCrosshairVisible(true);
        _plot.setRangeCrosshairVisible(false);
        
        final XYItemRenderer _renderer = _plot.getRenderer();
        for(int i=0;i<charts.size();i++){
        	_renderer.setSeriesPaint(i, charts.get(i).getPaint());
        	_renderer.setSeriesStroke(i, charts.get(i).getStroke());
        }
        
        _chart.setBackgroundImageAlpha(0.5f);
        _chart.setBackgroundPaint(Color.white);
        
        ByteArrayOutputStream _outStream = new ByteArrayOutputStream();
        EncoderUtil.writeBufferedImage(_chart.createBufferedImage(this.width, this.height), "png", _outStream);
        
        return new ByteArrayInputStream(_outStream.toByteArray());	
	}
	
	public InputStream outputChart(TimeSeriesCollection s, String title, String xAxis, String yAxis) throws IOException{
        JFreeChart _chart = ChartFactory.createTimeSeriesChart(
                title,  // title
                xAxis,   // x-axis label
                yAxis,   // y-axis label
                s,            // data
                this.showLegend,               // create legend?
                true,               // generate tooltips?
                false               // generate URLs?
            );
        
        TextTitle _title = _chart.getTitle();
        if(_title != null){
        	Font _font = new Font("Verdana", Font.PLAIN, 11);
        	_chart.getTitle().setFont(_font);
        }
        
        ByteArrayOutputStream _outStream = new ByteArrayOutputStream();
        EncoderUtil.writeBufferedImage(_chart.createBufferedImage(this.width, this.height), "png", _outStream);
        
        return new ByteArrayInputStream(_outStream.toByteArray());
	}
	
	public String getTempDir() {
		return tempDir;
	}

	public void setTempDir(String tempDir) {
		this.tempDir = tempDir;
	}

	public boolean isShowLegend() {
		return showLegend;
	}

	public void setShowLegend(boolean showLegend) {
		this.showLegend = showLegend;
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
