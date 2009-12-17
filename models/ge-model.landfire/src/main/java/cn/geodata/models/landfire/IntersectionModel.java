package cn.geodata.models.landfire;

import java.io.IOException;

import com.vividsolutions.jts.geom.Geometry;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

@GeoProcess(title="Spatial Intersection Analysis", description="Calculate intersection geometry from given two input geometry objects.", keywords={"Geospatial", "Topology"})
public class IntersectionModel implements Calculate {
	private Geometry geometry1;
	private Geometry geometry2;
	private Geometry intersection;
	
	public void calculate() throws IOException {
		this.intersection = this.geometry1.intersection(geometry2);
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

	@GeoOutput(title="Intersection Geometry", description="The geometry represents the common part of two input geometry objects")
	public Geometry getIntersection() {
		return intersection;
	}

	@GeoInput(title="Input Geometry", description="The input geometry object A")
	public void setGeometry1(Geometry geometry1) {
		this.geometry1 = geometry1;
	}

	@GeoInput(title="Input Geometry", description="The input geometry object B")
	public void setGeometry2(Geometry geometry2) {
		this.geometry2 = geometry2;
	}
}
