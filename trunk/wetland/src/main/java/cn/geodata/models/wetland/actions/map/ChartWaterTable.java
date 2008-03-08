package cn.geodata.models.wetland.actions.map;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.encoders.EncoderUtil;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import cn.geodata.models.wetland.DayMet;
import cn.geodata.models.wetland.DayMetReader;
import cn.geodata.models.wetland.WaterTableModel;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class ChartWaterTable {
	private String pt;
	private InputStream stream;
	private int width;
	private int height;
	private WaterTableModel waterTableModel;
	
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
		
		GeometryFactory _factory = new GeometryFactory();
		Point _pt = _factory.createPoint(new Coordinate(Double.parseDouble(_parts[0]), Double.parseDouble(_parts[1])));
		
		DayMetReader _reader = new DayMetReader();
		ArrayList<DayMet> _daymets = _reader.read(_pt.getX(), _pt.getY());
		
		String _xAxisTitle= null; //"Date";
		String _yAxisTitle= "Waterlevel";
		String _title= null; //"WaterLevel";
		
		waterTableModel.setWaterLevel(0);
		
        TimeSeries s1 = new TimeSeries("P1", Day.class);
        for(int i=0;i<_daymets.size();i++){
        	waterTableModel.setDayMet(_daymets.get(i));
        	
        	s1.add(new Day(_daymets.get(i).getDate()), waterTableModel.calculate());
//        	System.out.println(waterTableModel.getWaterLevel() + "," + waterTableModel.getEtModel().getEt());
        }
        
//        System.out.println(_daymets.get(0).getX() + "," + _daymets.get(0).getY());
        
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
