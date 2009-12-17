package cn.geodata.models.data.parsers;

import java.io.InputStream;

import javax.activation.MimeType;

import org.apache.commons.io.IOUtils;
import org.apache.xmlbeans.impl.util.Base64;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import junit.framework.TestCase;

public class GMLVectorParserTest extends TestCase {
	
	public void testTest1() throws Exception {
		GeometryFactory _factory = new GeometryFactory();
		Point _pt = _factory.createPoint(new Coordinate(100, 40));
		
		VectorXMLParser _p = new VectorXMLParser();
		InputStream _txt = _p.encode(_pt, new MimeType("text", "gml"), "base64");
		
		System.out.println(IOUtils.toString(_txt));
	}

}
