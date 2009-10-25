package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.logging.Logger;

import net.sf.json.JSONObject;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

public class WaterLevelStart extends ProcessStart {
	private static Logger log = Logger.getAnonymousLogger();
	private Catchment catchment;
	private DayMetReader daymetReader;
	
	public WaterLevelStart(Catchment catchment, DayMetReader daymetReader){
		this.catchment = catchment;
		this.daymetReader = daymetReader;
	}

	public String execute() throws Exception {
		String _basin = this.params.getString("basin");
		Date _startDate = new Date(this.params.getLong("startDate"));
		Date _endDate = new Date(this.params.getLong("endDate"));
		JSONObject _params = this.params.getJSONObject("params");
		
		WaterLevelProcess _process = new WaterLevelProcess(_startDate, _endDate, _basin, this.catchment, _params, daymetReader);
		this.manage.pushProcess(_process);
		
//		_process.run();
		Thread _thread = new Thread(_process);
		_thread.start();
		
		JSONObject _outputs = new JSONObject();
		_outputs.put("id", _process.getId());
		
		stream = new ByteArrayInputStream(_process.getStatus().toString().getBytes("utf-8"));
		
		return "success";
	}
}
