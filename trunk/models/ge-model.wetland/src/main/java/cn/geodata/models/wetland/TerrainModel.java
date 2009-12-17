package cn.geodata.models.wetland;

import java.util.logging.Logger;

import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPolygon;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

@GeoProcess(title="Terrain Model", keywords={"terrain", "dem"})
public class TerrainModel implements Calculate {
	private Logger log = Logger.getAnonymousLogger();
	
	private DemAnalysis dem;
	private MultiPolygon catchment;
	private double spillPoint;
	
	@GeoOutput(title="Spill Point")
	public double getSpillPoint() {
		return spillPoint;
	}

	@GeoInput(title="Catchment", keywords={"catchment"})
	public void setCatchment(MultiPolygon catchment) {
		this.catchment = catchment;
	}

	public TerrainModel(DemAnalysis dem){
		this.dem = dem;
	}

	public void calculate() throws Exception {
		Extent _extent = dem.calculateExtent(this.catchment.getEnvelopeInternal());
		
		RasterCell _lowestC = dem.calcuateLowest4Catchment(this.catchment, _extent);
		RasterCell _lowestB = dem.calculateLowest4Boundary((MultiLineString) catchment.getBoundary(), _extent);
		
		spillPoint = _lowestB.getReader().getCell(_lowestB.getCol(), _lowestB.getRow()).doubleValue() - _lowestC.getReader().getCell(_lowestC.getCol(), _lowestC.getRow()).doubleValue();
		log.info("spill point " + spillPoint);
	}

	public void cancel() {
	}

	public int getPercent() {
		return 0;
	}

	public String getStatus() {
		return null;
	}
}
