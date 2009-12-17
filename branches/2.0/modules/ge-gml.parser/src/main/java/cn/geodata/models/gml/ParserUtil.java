package cn.geodata.models.gml;


import java.util.logging.Logger;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


public class ParserUtil {
	public static String BEANS_RESOURCE = "/META-INF/gml.parser.xml";
	
	/**
	 * @return Create bean factory
	 */
	public static XmlBeanFactory createBeanFactory (){
		return new XmlBeanFactory(new ClassPathResource(BEANS_RESOURCE));
	}
	
	/**
	 * @return Create a new ParserFinder instance
	 */
	public static ParserFinder createParserFinder() {
		return (ParserFinder) createBeanFactory().getBean("gml.parserFinder");
	}
	
	public static Logger getLogger() {
		return Logger.getLogger("cn.geodata.models.parser.gml");
	}
}
