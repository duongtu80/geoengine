package cn.geodata.models.glacier;

import java.io.IOException;

import org.geotools.feature.FeatureCollection;
import com.vividsolutions.jts.geom.Point;

/**
 * 
 * Interpolate model interface
 * 
 * @author tank
 *
 */
public interface InterpolateModel {
	double calculate(FeatureCollection fs, String fieldName, Point pt) throws IOException;
}
