package cn.geodata.models.glacier.actions.models;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.wps.client.WpsProcess;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;

public class IdwChartModel extends ProcessModel {
	protected double x;
	protected double y;

	protected int pow;
	protected int maxCount;
	protected double maxDistance;
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public int getPow() {
		return pow;
	}
	
	public void setPow(int pow) {
		this.pow = pow;
	}
	
	public int getMaxCount() {
		return maxCount;
	}
	
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	
	public double getMaxDistance() {
		return maxDistance;
	}
	
	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}
	
	protected String execute(String seriesTitle) throws Exception {
		double _val = this.calculate(this.createProcess());

		JSONObject _result = new JSONObject();
		_result.put("val", _val);
		
		this.stream = new ByteArrayInputStream(_result.toString().getBytes());
		return "success";
	}

	protected double calculate(WpsProcess process) throws IOException{
		GeometryFactory _factory = new GeometryFactory();
		
		Map<String, Object> _inputs = new HashMap<String, Object>();
		
		_inputs.put("Pow", this.pow);
		_inputs.put("Site", _factory.createPoint(new Coordinate(this.x, this.y)));
		_inputs.put("MaxCount", this.maxCount);
		_inputs.put("MaxDistance", this.maxDistance);
		
		process.execute(_inputs);
		
		return (Double) process.getOutput(process.getResponse().getExecuteResponse().getProcessOutputs().getOutputArray()[0].getIdentifier().getStringValue(), DataCategories.getInstance().findCategory("double"));
	}
}
