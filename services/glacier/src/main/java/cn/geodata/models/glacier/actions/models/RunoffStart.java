package cn.geodata.models.glacier.actions.models;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import net.sf.json.JSONObject;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

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
	//Add land areas, to be implemented
	private LandArea landAreas;
	private BasinDataset basins;
	private boolean async;
	
	public RunoffStart(BasinArea areas, LandArea landAreas, BasinDataset basins){
		this.areas = areas;
		this.landAreas = landAreas;
		this.basins = basins;
		this.async = false;
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

	public void setAsync(boolean async) {
		this.async = async;
	}

	public String execute() throws Exception {
		JSONObject _inputs = JSONObject.fromObject(param);
		
		MultiPolygon _border = this.basins.getBasin(basin);
		Point _pt = _border.getCentroid();
		
		RunoffProcess _process = new RunoffProcess(_border, _pt.getX(), _pt.getY(), startYear, endYear, basin, _inputs, areas.getLevels(), areas.getBasinArea(basin), landAreas.getBasinArea(basin));

		if(this.async){
			this.manage.pushProcess(_process);
			
			Thread _thread = new Thread(_process);
			_thread.start();
		}
		else{
			_process.run();
		}
		
//		JSONObject _outputs = new JSONObject();
//		_outputs.put("id", _process.getId());
//		
		stream = new ByteArrayInputStream(_process.getStatus().toString().getBytes("utf-8"));
		
		return "success";
	}
}
