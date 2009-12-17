package cn.geodata.models.gml;

import java.io.IOException;

import org.jdom.Element;
import org.opengis.feature.Feature;
import org.opengis.feature.type.FeatureType;

public interface FeatureParser {
	/**
	 * Parse GML feature element to GeoTools FeatureType 
	 * 
	 * @param featureType FeatureType of the feature
	 * @param ele Element to parse
	 * @return Parsed feature
	 * @throws Exception
	 */
	Feature parse(FeatureType featureType, Element ele) throws IOException;
	
	/**
	 * Try to create a FeatureType for the given elements
	 * 
	 * @param eles Feature elements to parse
	 * @return
	 * @throws Exception
	 */
	FeatureType parseFeatureType(Element[] eles) throws IOException;
}
