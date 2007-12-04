package cn.geodata.gml;

import org.geotools.feature.Feature;
import org.geotools.feature.FeatureType;
import org.jdom.Element;

public interface FeatureParser {
	/**
	 * Parse GML feature element to GeoTools FeatureType 
	 * 
	 * @param featureType FeatureType of the feature
	 * @param ele Element to parse
	 * @return Parsed feature
	 * @throws Exception
	 */
	Feature parse(FeatureType featureType, Element ele) throws Exception;
	
	/**
	 * Try to create a FeatureType for the given elements
	 * 
	 * @param eles Feature elements to parse
	 * @return
	 * @throws Exception
	 */
	FeatureType parseFeatureType(Element[] eles) throws Exception;
}