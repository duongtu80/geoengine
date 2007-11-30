package cn.geodata.gml;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.AttributeType;
import org.geotools.feature.AttributeTypeFactory;
import org.geotools.feature.FeatureType;
import org.jdom.Element;
import org.jdom.Namespace;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;


public class ParserUtil {
	public static String BEANS_RESOURCE = "/META-INF/gml.parser.xml";
	
	/**
	 * @return Create bean factory
	 */
	public static XmlBeanFactory createBeanFactory (){
		return new XmlBeanFactory(new ClassPathResource(ParserUtil.BEANS_RESOURCE));
	}
	
	/**
	 * @return Create a new ParserFinder instance
	 */
	public static ParserFinder createParserFinder() {
		return (ParserFinder) ParserUtil.createBeanFactory().getBean("gml.parserFinder");
	}
}
