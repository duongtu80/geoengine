package cn.geodata.models.glacier.actions.models;

import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.encoders.EncoderUtil;
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
	
	public InputStream outputChart(TimeSeries s, String title, String xAxis, String yAxis) throws IOException{
	    TimeSeriesCollection _dataset = new TimeSeriesCollection();
	    _dataset.addSeries(s);

        JFreeChart _chart = ChartFactory.createTimeSeriesChart(
                title,  // title
                xAxis,             // x-axis label
                yAxis,   // y-axis label
                _dataset,            // data
                this.showLegend,               // create legend?
                true,               // generate tooltips?
                false               // generate URLs?
            );
        
        Font _font = new Font("宋体", Font.PLAIN, 13);
        _chart.getTitle().setFont(_font);
        
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
