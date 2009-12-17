package cn.geodata.models.raster;

import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.Envelope2D;
import org.geotools.geometry.jts.JTS;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Polygon;

public class Utilities {
	public static Envelope2D getEnvelope(Geometry geometry){
		Envelope _polyext = geometry.getEnvelopeInternal();
		Envelope2D _ext = new Envelope2D(new DirectPosition2D(
				_polyext.getMinX(), _polyext.getMinY()),
				new DirectPosition2D(_polyext.getMaxX(), _polyext.getMaxY()));

		return _ext;
	}
	
	public static Polygon covertEnvelope2D(Envelope2D ext){
		Envelope _env = new Envelope(ext.getMinX(), ext.getMaxX(), ext.getMinY(), ext.getMaxY());
		return JTS.toGeometry(_env);
	}
}
