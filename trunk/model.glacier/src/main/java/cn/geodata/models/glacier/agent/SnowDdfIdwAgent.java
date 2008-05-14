package cn.geodata.models.glacier.agent;

import cn.geodata.models.AbstractProcessing;
import cn.geodata.models.glacier.InvertDistanceWeightModel;
import cn.geodata.models.glacier.SnowDDFModel;

import com.vividsolutions.jts.geom.Point;

public class SnowDdfIdwAgent extends AbstractProcessing {

	public void execute() throws Exception {
		//Get parameters
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
		SnowDDFModel _model = new SnowDDFModel();
		_model.setModel(_idwModel);
		
		double _value = _model.calculate(_point);
		
		//Output
		this.getOutputs().put("SnowDdf", new Double(_value));
	}
}
