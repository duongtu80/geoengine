package cn.geodata.model.value;

import java.io.IOException;

import net.opengeospatial.wps.ComplexValueType;

import org.geotools.feature.FeatureCollection;

import com.vividsolutions.jts.geom.Geometry;

public interface ComplexParser {
	FeatureCollection parseFeatureCollection(ComplexValueType type) throws IOException;
	Geometry parseGeometry(ComplexValueType type) throws IOException;
}
