package cn.geodata.models.glacier.agent;

import java.io.File;
import java.util.Date;

import cn.geodata.models.AbstractProcessing;
import cn.geodata.models.GeoInput;
import cn.geodata.models.glacier.InvertDistanceWeightModel;
import cn.geodata.models.glacier.TemperatureModelEx;
import cn.geodata.models.tools.raster.RasterManager;

import com.vividsolutions.jts.geom.Point;

public class TemperatureIdwExAgent extends AbstractProcessing {
	private Date date;
	public double maxDistance;
	private int maxCount;
	private Point site;
	private int pow;
	private double stand;
	private double grads;
	private double temperature;

	public void execute() throws Exception {
		this.initializeInputs();
		
		//Initialize idw model 
		InvertDistanceWeightModel _idwModel = new InvertDistanceWeightModel();
		if(maxCount > 0)
			_idwModel.setMaxCount(maxCount);
		if(maxDistance > 0)
			_idwModel.setMaxDistance(maxDistance);
		if(pow > 0)
			_idwModel.setPow(pow);

		RasterManager _demModel = new RasterManager(new File("O:\\tank\\data\\dem\\tiff"), 0);
		
		//Inititalize and execute temperature model
		TemperatureModelEx _tempModel = new TemperatureModelEx();
		_tempModel.setIdwModel(_idwModel);
		_tempModel.setDemModel(_demModel);
		_tempModel.setGrads(this.grads);
		_tempModel.setStand(this.stand);
		
		double _value = _tempModel.calculate(date, site);
		
		//Output
		this.getOutputs().put("Temperature", new Double(_value));
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@GeoInput(title="MaxDistance")
	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public void setSite(Point site) {
		this.site = site;
	}

	public void setPow(int pow) {
		this.pow = pow;
	}

	public void setStand(double stand) {
		this.stand = stand;
	}

	public void setGrads(double grads) {
		this.grads = grads;
	}

	public double getTemperature() {
		return temperature;
	}
}
