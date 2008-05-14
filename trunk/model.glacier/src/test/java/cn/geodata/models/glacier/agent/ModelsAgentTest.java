package cn.geodata.models.glacier.agent;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;

public class ModelsAgentTest extends TestCase {

	public void testSnowDdf() throws Exception {
		SnowDdfIdwAgent _agent = new SnowDdfIdwAgent();
		
		GeometryFactory _factory = new GeometryFactory();

		Map<String, Object> _inputs = new HashMap<String, Object>();
		_inputs.put("Pow", new Integer(2));
		_inputs.put("Site", _factory.createPoint(new Coordinate(110.2, 33.3)));
		
		Map<String, Object> _outputs = new HashMap<String, Object>();
		
		_agent.setInputs(_inputs);
		_agent.setOutputs(_outputs);
		
		_agent.execute();
		
		for(String _key : _outputs.keySet()){
			System.out.println(_key + ":" + _outputs.get(_key));
		}
	}

	public void testIceDdf() throws Exception {
		IceDdfIdwAgent _agent = new IceDdfIdwAgent();
		
		GeometryFactory _factory = new GeometryFactory();

		Map<String, Object> _inputs = new HashMap<String, Object>();
		_inputs.put("Pow", new Integer(2));
		_inputs.put("Site", _factory.createPoint(new Coordinate(110.2, 33.3)));
		
		Map<String, Object> _outputs = new HashMap<String, Object>();
		
		_agent.setInputs(_inputs);
		_agent.setOutputs(_outputs);
		
		_agent.execute();
		
		for(String _key : _outputs.keySet()){
			System.out.println(_key + ":" + _outputs.get(_key));
		}
	}
}
