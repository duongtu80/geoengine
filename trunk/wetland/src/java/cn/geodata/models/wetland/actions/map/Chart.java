package cn.geodata.models.wetland.actions.map;

import org.geotools.feature.Feature;

import jj2000.j2k.codestream.CorruptedCodestreamException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class Chart {
	private String code;
	private String pt;
	private GeoEnvironment envi;

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String execute() throws Exception {
		if(this.pt == null || this.pt.length() == 0){
			throw new NullPointerException("Noloation information be provided");
		}
		String[] _parts = this.pt.split(", ");
		if(_parts.length != 2){
			throw new ArrayIndexOutOfBoundsException(_parts.length);
		}
		
		GeometryFactory _factory = new GeometryFactory();
		Point _pt = _factory.createPoint(new Coordinate(Double.parseDouble(_parts[0]), Double.parseDouble(_parts[1]))); 
		
		Feature _f = this.envi.findWetland(_pt);
		if(_f == null){
			return "notfound";
		}
		
		this.code = (String) _f.getAttribute("Name");
		
		return "success";
	}

	public GeoEnvironment getEnvi() {
		return envi;
	}

	public void setEnvi(GeoEnvironment envi) {
		this.envi = envi;
	}
}
