package cn.geodata.models.glacier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;
import cn.geodata.models.csv.CSVReader;

import com.vividsolutions.jts.geom.Point;

@GeoProcess(title="积雪深度模型", keywords={"snow depth"})
public class SnowDepthModel implements Calculate {

	private Logger log = Logger.getLogger(TemperatureModelEx.class.getName());
	private InvertDistanceWeightModel model;
	
	private Date date;
	private Point point;
	private double depth;

	public SnowDepthModel(){
		
	}

	public void calculate() throws Exception {
//		double _elevation = this.point.getCoordinate().z;
		CSVReader _reader = new CSVReader(SnowDepthModel.class.getResourceAsStream("/glacier/data/snow_depth.csv"));
		List<Map<String, Double>> _list = new ArrayList<Map<String, Double>>(); 
		
		for(Map<String, String> _l : _reader.getRecords()){
			if(Integer.parseInt(_l.get("YEAR")) == this.date.getYear() + 1900){
				Map<String, Double> _vals = new HashMap<String, Double>();

				_vals.put("LON", Double.parseDouble(_l.get("LON")));
				_vals.put("LAT", Double.parseDouble(_l.get("LAT")));
				_vals.put("DEPTH", Double.parseDouble(_l.get("DEPTH")));
				
				_list.add(_vals);
			}
		}
		
		if(_list.size() == 0){
			throw new IOException("没有找到该年份的站点数据");
		}
		
		this.depth = this.model.calculate(_list, "DEPTH", point); 
	}

	@GeoInput(title="目标点")
	public void setPoint(Point point) {
		this.point = point;
	}

	@GeoInput(title="月份")
	public void setDate(Date date) {
		this.date = date;
	}

	@GeoOutput(title="雪深")
	public double getDepth() {
		return depth;
	}

	public void setModel(InvertDistanceWeightModel model) {
		this.model = model;
	}

	public void cancel() {
	}

	public int getPercent() {
		return 0;
	}

	public String getStatus() {
		return null;
	}

}
