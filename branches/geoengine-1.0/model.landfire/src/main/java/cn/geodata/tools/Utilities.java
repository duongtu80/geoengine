package cn.geodata.tools;

import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.Envelope2D;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;

public class Utilities {
	public static Envelope2D getEnvelope(Geometry geometry){
		Envelope _polyext = geometry.getEnvelopeInternal();
		Envelope2D _ext = new Envelope2D(new DirectPosition2D(
				_polyext.getMinX(), _polyext.getMinY()),
				new DirectPosition2D(_polyext.getMaxX(), _polyext.getMaxY()));

		return _ext;
	}
}
