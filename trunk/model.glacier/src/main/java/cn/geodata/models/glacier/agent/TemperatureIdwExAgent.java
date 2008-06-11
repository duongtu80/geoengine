package cn.geodata.models.glacier.agent;

import java.io.File;
import java.util.Date;

import cn.geodata.models.AbstractProcessing;
import cn.geodata.models.GeoInput;
import cn.geodata.models.GeoOutput;
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
		
		this.temperature = _tempModel.calculate(date, site);
	}

	@GeoInput(title="日期")
	public void setDate(long date) {
		this.date = new Date(date);
	}

	@GeoInput(title="最大距离")
	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}

	@GeoInput(title="最大个数")
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	@GeoInput(title="目标位置")
	public void setSite(Point site) {
		this.site = site;
	}

	@GeoInput(title="幂值")
	public void setPow(int pow) {
		this.pow = pow;
	}

	@GeoInput(title="标准位置")
	public void setStand(double stand) {
		this.stand = stand;
	}

	@GeoInput(title="气温垂直递减率")
	public void setGrads(double grads) {
		this.grads = grads;
	}

	@GeoOutput(title="气温")
	public double getTemperature() {
		return temperature;
	}
}
