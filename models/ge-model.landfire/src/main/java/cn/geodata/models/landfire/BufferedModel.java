package cn.geodata.models.landfire;

import java.io.IOException;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

import com.vividsolutions.jts.geom.Geometry;

@GeoProcess(title="Buffer Analysis", description="Calculate buffered geometry that is given distance to the boundary of input geometry.", keywords={"Geospatial", "Topology"})
public class BufferedModel implements Calculate {
	private Geometry geometry;
	private Double distance;
	private Geometry buffered;
	
	public void calculate() throws IOException {
		this.buffered = geometry.buffer(distance);
	}

	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	public int getPercent() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@GeoOutput(title="Buffered Geometry", description="Buffered geometry that is given distance to the boundary of input geometry.")
	public Geometry getBuffered() {
		return buffered;
	}

	@GeoInput(title="Input Geometry", description="The input geometry object. Could be any geometry type")
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	@GeoInput(title="Buffer Distance", description="The distance that will be used to calculate buffered geometry")
	public void setDistance(Double distance) {
		this.distance = distance;
	}
}
