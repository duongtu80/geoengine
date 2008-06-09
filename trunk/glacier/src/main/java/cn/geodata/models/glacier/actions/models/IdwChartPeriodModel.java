package cn.geodata.models.glacier.actions.models;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;

import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.wps.client.WpsProcess;
import cn.geodata.models.wps.client.WpsService;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;

public class IdwChartPeriodModel extends PeriodChartModel {
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
		WpsProcess _p = this.createProcess();
        TimeSeries _s1 = new TimeSeries(seriesTitle, Month.class);
		
		JSONArray _list = new JSONArray();
		Date _endDate = new Date(this.endYear - 1900, 9, 1);
		for(Date _startDate = new Date(this.startYear - 1900, 9, 1); _startDate.before(_endDate);){
			double _val = this.calculate(_p, _startDate);

			_s1.add(new Month(_startDate), _val);

			JSONObject _item = new JSONObject();
			_item.put("date", _startDate.getTime());
			_item.put("val", _val);
			_list.put(_item);
			
			Calendar _c = Calendar.getInstance();
			_c.setTime(_startDate);
			_c.add(Calendar.MONTH, 1);
			_startDate = _c.getTime();
		}
		
		String _code = this.chart.outputChart(_s1, title, xAxis, yAxis);
		
		JSONObject _result = new JSONObject();
		_result.put("items", _list);
		_result.put("code", _code);
		
		this.stream = new ByteArrayInputStream(_result.toString().getBytes());
		
		return "success";
	}

	protected double calculate(WpsProcess process, Date date) throws IOException{
		GeometryFactory _factory = new GeometryFactory();
		
		Map<String, Object> _inputs = new HashMap<String, Object>();
		
		_inputs.put("Date", date.getTime());
		_inputs.put("Pow", this.pow);
		_inputs.put("Site", _factory.createPoint(new Coordinate(this.x, this.y)));
		_inputs.put("MaxCount", this.maxCount);
		_inputs.put("MaxDistance", this.maxDistance);
		
		process.execute(_inputs);
		return (Double) process.getOutput(process.getResponse().getExecuteResponse().getProcessOutputs().getOutputArray()[0].getIdentifier().getStringValue(), DataCategories.getInstance().findCategory("double"));
	}
}
