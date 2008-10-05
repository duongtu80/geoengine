package cn.geodata.models;

import java.util.List;
import java.util.Map;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;

import cn.geodata.models.container.MemeryContainer;

import net.opengis.wps.x100.DescribeProcessDocument;

import junit.framework.TestCase;

public class ProcessLibraryTest extends TestCase {
	public void testloadModels() throws Exception {
		ProcessLibrary _lib = ProcessLibrary.createInstance();
		Map<String, Class> _ps = _lib.getModelList();
		
//		for(String _k : _ps.keySet()){
//			System.out.println(_k + ":" + _ps.get(_k).getName());
//		}
//		

		MemeryContainer _container = new MemeryContainer();
		Processing _b = _lib.createProcess("TestModel");
		
//		GeometryFactory _factory = new GeometryFactory();
//		_b.setInput("Point", _factory.createPoint(new Coordinate(100, 40)));
		
		_lib.executeProcess(_container, _b);
		
		while(_b.getStatus().getPercent() < 100){
			System.out.println(_b.getStatus().getPercent());
			Thread.sleep(100);
		}
	}
	
}
