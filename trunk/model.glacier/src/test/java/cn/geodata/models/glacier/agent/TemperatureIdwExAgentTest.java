package cn.geodata.models.glacier.agent;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.geodata.models.AbstractProcessing;
import cn.geodata.models.GeoInput;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import junit.framework.TestCase;

public class TemperatureIdwExAgentTest extends TestCase {
	private TemperatureIdwExAgent model;

	protected void setUp() throws Exception {
		this.model = new TemperatureIdwExAgent();
	}

	public void atestExecute() throws Exception {
		Map<String, Object> _inputs = new HashMap<String, Object>();

		GeometryFactory _factory = new GeometryFactory();
		_inputs.put("Date", new Date(80, 0, 1));
		_inputs.put("Pow", new Integer(2));
		_inputs.put("Site", _factory.createPoint(new Coordinate(110.2, 33.3)));
		_inputs.put("Stand", 3000.0);
		_inputs.put("Grads", 0.78);
		
		Map<String, Object> _outputs = new HashMap<String, Object>();
		
		model.setInputs(_inputs);
		model.setOutputs(_outputs);
		
		model.execute();
	}

	public void atestTest1() throws Exception {
//		for(Field _f : TemperatureIdwExAgent.class.getDeclaredFields()){
//			System.out.println(_f.getName() + "," + _f.getType().getName());
//		}
		
		for(Method _m : TemperatureIdwExAgent.class.getMethods()){
			if(_m.getName().startsWith("set") && _m.getDeclaringClass().equals(AbstractProcessing.class) == false)
				System.out.println(_m.getModifiers() + "," + _m.getName() + "," + _m.getReturnType().getName());
		}
	}
	
	public void testTest2() throws Exception {
		Method _m = TemperatureIdwExAgent.class.getMethod("setMaxDistance", double.class);
		System.out.println(_m.getName());
		
		_m.invoke(this.model, 10);
		System.out.println(this.model.maxDistance);
		
		System.out.println(_m.getAnnotations().length);
		for(Annotation _a : _m.getAnnotations()){
			GeoInput _g = (GeoInput) _a;
			System.out.println(_g.title() + "," + _g.keywords());
		}
	}
}
