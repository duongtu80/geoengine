package cn.geodata.models.value;

import java.io.IOException;

import net.opengeospatial.wps.ComplexValueType;
import net.opengeospatial.wps.IOValueType;

import org.geotools.feature.FeatureCollection;

import com.vividsolutions.jts.geom.Geometry;

public interface ComplexReferenceParser extends Parser {
	FeatureCollection parseFeatureCollection(IOValueType.ComplexValueReference type) throws IOException;
	Geometry parseGeometry(ComplexValueType type) throws IOException;
}
