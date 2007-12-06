package cn.geodata.model.value;

import java.io.IOException;

import net.opengeospatial.wps.ComplexValueType;

import org.geotools.feature.FeatureCollection;

import com.vividsolutions.jts.geom.Geometry;

public interface ComplexEncoder {
	ComplexValueType encodeFeatureCollection(FeatureCollection fs) throws IOException;
	ComplexValueType encodeGeometry(Geometry geom) throws IOException;
}