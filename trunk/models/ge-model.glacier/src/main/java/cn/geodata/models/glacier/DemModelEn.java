package cn.geodata.models.glacier;

import java.io.File;
import java.io.IOException;

import com.vividsolutions.jts.geom.Point;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;
import cn.geodata.models.tools.raster.RasterManager;

@GeoProcess(title="DEM Model", keywords={"dem"})
public class DemModelEn implements Calculate {
	
	private int nodata;
	private String demPath;
	private Point point;
	private double elevation;
	private RasterManager rasterManager;
	
	public void calculate() throws Exception {
		this.elevation = this.getRasterManager().getLocationValue(point.getX(), point.getY());
	}

	@GeoOutput(title="Altitude")
	public double getElevation() {
		return elevation;
	}

	@GeoInput(title="Target Location")
	public void setPoint(Point point) {
		this.point = point;
	}

	public int getPercent() {
		return 0;
	}

	public void setNodata(int nodata) {
		this.nodata = nodata;
	}

	public void setDemPath(String demPath) throws IOException {
		if(this.demPath == null || !this.demPath.equalsIgnoreCase(demPath)){
			this.rasterManager = new RasterManager(new File(demPath), nodata);
		}
		
		this.demPath = demPath;
	}
	
	public RasterManager getRasterManager() throws IOException{
		return this.rasterManager;
	}

	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}
