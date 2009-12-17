package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Logger;

import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;
import cn.geodata.models.geojson.GeoJSON;

public class WaterRegion {
	private static Logger log = Logger.getAnonymousLogger();

	private String waterlandCode;
	private double waterLevel;

	private InputStream stream;
	
	public void setWaterLevel(double waterLevel) {
		this.waterLevel = waterLevel;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setWaterlandCode(String waterlandCode) {
		this.waterlandCode = waterlandCode;
	}

	public String execute() throws Exception {
		ProcessLibrary _library = ProcessLibrary.createInstance();

		Processing _model = _library.createProcess("WaterRegionModel");
		_library.setInput(_model, "WaterLevel", waterLevel);
		_library.setInput(_model, "WetlandCode", waterlandCode);
		_library.executeProcess(_model);
		
		this.stream = new ByteArrayInputStream((new GeoJSON()).encode(_library.getOutput(_model, "WaterRegion")).toString().getBytes("UTF-8"));
		return "success";
	}
}
