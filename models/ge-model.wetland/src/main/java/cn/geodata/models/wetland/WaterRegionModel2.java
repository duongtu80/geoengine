package cn.geodata.models.wetland;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;
import cn.geodata.models.raster.GeoRaster;

import com.vividsolutions.jts.geom.MultiPolygon;

@GeoProcess(title="Water Surface Extent", keywords={"water surface", "geospatial extent"}, description="")
public class WaterRegionModel2 implements Calculate  {
	private double waterLevel;
	private MultiPolygon catchment;
	private MultiPolygon waterRegion;
	private GeoRaster raster;
	
	public WaterRegionModel2(GeoRaster raster){
		this.raster = raster;
	}

	public void calculate() throws Exception {
		WaterRegionCalc _model = new WaterRegionCalc();
		_model.setCatchment(this.catchment);
		_model.setReader(raster);
		_model.setWaterLevel(waterLevel);
		
		this.waterRegion = _model.calculate();
	}

	@GeoInput(title="Catchment", srid={"EPSG:4326"})
	public void setCatchment(MultiPolygon catchment) {
		this.catchment = catchment;
	}

	@GeoOutput(title="Water Region", srid={"EPSG:4326"})
	public MultiPolygon getWaterRegion() {
		return waterRegion;
	}
	
	@GeoInput(title="Water Level", units={"meters"})
	public void setWaterLevel(double waterLevel) {
		this.waterLevel = waterLevel;
	}

	public int getPercent() {
		return 0;
	}

	public void cancel() {
	}

	public String getStatus() {
		return null;
	}
}
