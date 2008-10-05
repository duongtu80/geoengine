package cn.geodata.models.wetland;

import com.vividsolutions.jts.geom.Point;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

@GeoProcess(title="Locate Wetland")
public class LocateWetland implements Calculate {
	private Point location;
	private Catchment catchment;
	private String code;
	
	public void setCatchment(Catchment catchment) {
		this.catchment = catchment;
	}

	public void calculate() throws Exception {
		this.code = this.catchment.findCatchment(location.getX(), location.getY());
	}

	@GeoOutput(title="Catchment code")
	public String getCode() {
		return code;
	}

	@GeoInput(title="Location")
	public void setLocation(Point location) {
		this.location = location;
	}

	public int getPercent() {
		return 0;
	}

	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}
