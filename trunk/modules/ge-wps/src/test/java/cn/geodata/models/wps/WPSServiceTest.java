package cn.geodata.models.wps;

import java.io.File;

import net.opengis.wps.x100.DescribeProcessDocument;

import org.apache.commons.configuration.XMLConfiguration;
import org.apache.xmlbeans.XmlObject;

import cn.geodata.models.container.MemeryContainer;

import junit.framework.TestCase;

public class WPSServiceTest extends TestCase {
	public void testTest1() throws Exception {
		WPSOperations _s = new WPSOperations(new MemeryContainer(), new XMLConfiguration(new File("d:\\Tank\\Save\\Java\\geoengine\\src\\1.0\\geoengine-1.0\\ge-services\\web\\src\\main\\resources\\conf\\services.xml")));
		
		XmlObject _c = _s.getCapabilities(null);
		System.out.println(_c.toString());
	}
	
	public void testDescribeProcesses() throws Exception {
		DescribeProcessDocument _doc = DescribeProcessDocument.Factory.newInstance();
		_doc.addNewDescribeProcess().addNewIdentifier().setStringValue("IceDDFModel");
		
		WPSOperations _s = new WPSOperations(new MemeryContainer(), new XMLConfiguration(new File("d:\\Tank\\Save\\Java\\geoengine\\src\\1.0\\geoengine-1.0\\ge-services\\web\\src\\main\\resources\\conf\\services.xml")));
		System.out.println(_s.describeProcesses(_doc).toString());
	}
}
