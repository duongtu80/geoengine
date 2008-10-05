package cn.geodata.models.glacier.actions.models;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

import net.sf.json.JSONObject;

public class RunoffStart extends AbstractRunoff {
	private static Logger log = Logger.getAnonymousLogger();
	
	private InputStream stream;
	private String param;
	private double x;
	private double y;
	private int startYear;
	private int endYear;
	private String basin;
	private BasinArea areas;
	private BasinDataset basins;
	
	public RunoffStart(BasinArea areas, BasinDataset basins){
		this.areas = areas;
		this.basins = basins;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public void setBasin(String basin) {
		try {
			this.basin = new String(basin.getBytes("ISO-8859-1"), "utf-8").trim();
		} catch (UnsupportedEncodingException e) {
		}
	}

	public InputStream getStream() {
		return stream;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String execute() throws Exception {
		JSONObject _inputs = JSONObject.fromString(param);
		
		MultiPolygon _border = this.basins.getBasin(basin);
		Point _pt = _border.getCentroid();
		
		RunoffProcess _process = new RunoffProcess(_pt.getX(), _pt.getY(), startYear, endYear, basin, _inputs, areas.getLevels(), areas.getBasinArea(basin));
		this.manage.pushProcess(_process);
		
		Thread _thread = new Thread(_process);
		_thread.start();
		
//		JSONObject _outputs = new JSONObject();
//		_outputs.put("id", _process.getId());
//		
		stream = new ByteArrayInputStream(_process.getStatus().toString().getBytes("utf-8"));
		
		return "success";
	}
}
