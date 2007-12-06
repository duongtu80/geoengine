package cn.geodata.model.value;

import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.InputDescriptionType;
import net.opengeospatial.wps.OutputDescriptionType;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ModelValueUtil {
	public static String BEANS_RESOURCE = "/META-INF/model.value.xml";
	
	/**
	 * @return Create bean factory
	 */
	public static XmlBeanFactory createBeanFactory (){
		return new XmlBeanFactory(new ClassPathResource(BEANS_RESOURCE));
	}
	
	/**
	 * @return Create a new ParserFinder instance
	 */
	public static ModelValueParserFinder createParserFinder() {
		return (ModelValueParserFinder) createBeanFactory().getBean("modelValue.paserFinder");
	}
	
	public static IOValueType createInputValue(InputDescriptionType inputType){
		IOValueType _type = IOValueType.Factory.newInstance();
		_type.setIdentifier(inputType.getIdentifier());
		_type.setTitle(inputType.getTitle());
		_type.setAbstract(inputType.getAbstract());
		
		return _type;
	}
	
	public static IOValueType createOutputValue(OutputDescriptionType outputType){
		IOValueType _type = IOValueType.Factory.newInstance();
		_type.setIdentifier(outputType.getIdentifier());
		_type.setTitle(outputType.getTitle());
		_type.setAbstract(outputType.getAbstract());
		
		return _type;
	}
}
