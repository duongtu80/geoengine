package cn.geodata.models.glacier.actions.models;

import java.util.Date;
import java.util.logging.Logger;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;

import junit.framework.TestCase;

public class RunoffProcessTest extends TestCase {
	private Logger log = Logger.getAnonymousLogger();
	
	public void testTest1() throws Exception {
		ProcessLibrary _library = ProcessLibrary.createInstance();
		
		Point _pt = new GeometryFactory().createPoint(new Coordinate(110, 34));
	
		Processing _p = _library.createProcess("SnowDepthModel");
		_p.setInput("Point", _pt);
		_p.setInput("Date", new Date(80, 0, 1));
		
		_p.run();
		
		System.out.println(_p.getOutput("Depth"));
	}
}
