package cn.geodata.models.wetland.actions.map;

import org.geotools.feature.Feature;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class Catchment {
	private GeoEnvironment envi;
	private String fieldName;
	
	public String findCatchment(double x, double y) throws Exception {
		GeometryFactory _factory = new GeometryFactory();
		Point _pt = _factory.createPoint(new Coordinate(x, y)); 
		
		Feature _f = this.envi.findWetland(_pt);
		if(_f == null){
			return null;
		}
		
		return (String)_f.getAttribute(this.fieldName);
	}

	public String findCatchment(String pt) throws NumberFormatException, Exception{
		if(pt == null || pt.length() == 0){
			throw new NullPointerException("Noloation information be provided");
		}
		String[] _parts = pt.split(", ");
		if(_parts.length != 2){
			throw new ArrayIndexOutOfBoundsException(_parts.length);
		}
		
		return this.findCatchment(Double.parseDouble(_parts[0]), Double.parseDouble(_parts[1]));
	}

	public GeoEnvironment getEnvi() {
		return envi;
	}

	public void setEnvi(GeoEnvironment envi) {
		this.envi = envi;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}
