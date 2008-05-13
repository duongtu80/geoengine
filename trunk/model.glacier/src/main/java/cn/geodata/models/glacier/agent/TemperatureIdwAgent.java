package cn.geodata.models.glacier.agent;

import java.util.Date;

import cn.geodata.models.AbstractProcessing;
import cn.geodata.models.glacier.InvertDistanceWeightModel;
import cn.geodata.models.glacier.TemperatureModel;

import com.vividsolutions.jts.geom.Point;

public class TemperatureIdwAgent extends AbstractProcessing {

	public void execute() throws Exception {
		//Get parameters
		Date _date = new Date(((Long)this.getInputs().get("Date")).longValue());
		Double _maxDistance = (Double) this.getInputs().get("MaxDistance");
		Integer _maxCount = (Integer) this.getInputs().get("MaxCount");
		Point _point = (Point) this.getInputs().get("Site");
		Integer _pow = (Integer) this.getInputs().get("Pow");
		
		//Initialize idw model 
		InvertDistanceWeightModel _idwModel = new InvertDistanceWeightModel();
		if(_maxCount != null)
			_idwModel.setMaxCount(_maxCount);
		if(_maxDistance != null)
			_idwModel.setMaxDistance(_maxDistance);
		if(_pow != null)
			_idwModel.setPow(_pow);
		
		//Inititalize and execute temperature model
		TemperatureModel _tempModel = new TemperatureModel();
		_tempModel.setModel(_idwModel);
		double _value = _tempModel.calculate(_date, _point);
		
		//Output
		this.getOutputs().put("Temperature", new Double(_value));
	}
}
