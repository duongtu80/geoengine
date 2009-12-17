package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import net.sf.json.JSONObject;
import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class SearchWetland {
	private String code;
	private double x;
	private double y;

	private InputStream stream;

	public InputStream getStream() {
		return stream;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String execute() throws Exception {
		GeometryFactory _factory = new GeometryFactory();
		Point _location = _factory.createPoint(new Coordinate(x, y));
		
		ProcessLibrary _library = ProcessLibrary.createInstance();
		
		Processing _model = _library.createProcess("LocateWetland");
		_library.setInput(_model, "Location", _location);
		_library.executeProcess(_model);
		
		this.code = (String) _library.getOutput(_model, "Code");
		if(this.code == null){
			this.code = "not found";
		}
		
		JSONObject _object = new JSONObject();
		_object.put("code", code);
		_object.put("x", x);
		_object.put("y", y);
		_object.put("pt", x + ", " + y);
		
		this.stream = new ByteArrayInputStream(_object.toString().getBytes());
		
		return "success";
	}
}
