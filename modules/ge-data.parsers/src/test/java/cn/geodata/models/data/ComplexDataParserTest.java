package cn.geodata.models.data;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.List;

import javax.activation.MimeType;

import org.apache.commons.io.IOUtils;

import cn.geodata.models.data.parsers.VectorXMLParser;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import junit.framework.TestCase;

public class ComplexDataParserTest extends TestCase {
	public void atestTest1() throws Exception {
		ComplexDataParser _p = new ComplexDataParser();
		List<MimeType> _types = _p.getMimes(Polygon.class);
		for(MimeType _t : _types){
			System.out.println(_t.toString());
		}
		
		GeometryFactory _factory = new GeometryFactory();
		Point _pt = _factory.createPoint(new Coordinate(100, 40));
		
		InputStream _txt = _p.encode(_pt, new MimeType("text", "xml"), "utf-8");
		System.out.println(IOUtils.toString(_txt));
	}
	
	public void atestTest2() throws Exception {
		double[] _t1 = new double[]{1, 2, 3};
		Double[] _t2 = new Double[]{1.0, 2.0, 3.0};
		
		System.out.println(_t1.getClass().getName());
		System.out.println(_t1.getClass().isArray());
		System.out.println(_t1.getClass().getComponentType().getName());
		System.out.println(_t2.getClass().getName());
		System.out.println(_t2.getClass().getComponentType().getName());
	}
	
	public void testTest3() throws Exception {
		double[] _t1 = new double[]{1, 2, 3};
		Double[] _t2 = new Double[]{1.0, 2.0, 3.0};
		
		ComplexDataParser _p = new ComplexDataParser();
		for(MimeType _m : _p.getMimes(_t1.getClass())){
			System.out.println(_m.toString());
		}
		InputStream _txt = _p.encode(_t1, new MimeType("text", "xml"), "utf-8");
		System.out.println(IOUtils.toString(_txt));
	}
}
