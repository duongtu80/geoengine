package cn.geodata.models.glacier.agent;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.geotools.feature.Feature;

import cn.geodata.models.glacier.CatchmentModel;
import cn.geodata.models.tools.WfsFeatureSource;

import junit.framework.TestCase;

public class RunoffAgentTest extends TestCase {
	public void testExecute() throws Exception {
		RunoffAgent _agent = new RunoffAgent();
		
		Map<String, Object> _inputs = new HashMap<String, Object>();

		_inputs.put("temperatureModelUrl", "http://127.0.0.1:59080/web/wps#Glacier.TemperatureIdw");
		_inputs.put("precipitationModelUrl", "http://127.0.0.1:59080/web/wps#Glacier.PrecipitationIdw");
		_inputs.put("snowDdfModelUrl",  "http://127.0.0.1:59080/web/wps#Glacier.SnowDdfIdw");
		_inputs.put("iceDdfModelUrl", "http://127.0.0.1:59080/web/wps#Glacier.IceDdfIdw");
		
		WfsFeatureSource _basinFs = new WfsFeatureSource("http://127.0.0.1:48080/geoserver/wfs", "geo:basin");
		WfsFeatureSource _glacier = new WfsFeatureSource("http://127.0.0.1:48080/geoserver/wfs", "geo:glacier");
		
		CatchmentModel _catchmentModel = new CatchmentModel(_basinFs, "NAME");
		
		_inputs.put("catchment", _catchmentModel.getCatchmentPolygon("tailang"));
		_inputs.put("glacier", _glacier.getFeatureSource().getFeatures());
		_inputs.put("startDate", new Date(80, 0, 1).getTime());
		_inputs.put("endDate", new Date(90, 0, 1).getTime());

		_inputs.put("cellSize", 1.0 / 1200);
		_inputs.put("rainCritical", 5);
		_inputs.put("snowCritical", 0);

		_agent.setInputs(_inputs);

		Map<String, Object> _outputs = new HashMap<String, Object>();
		_agent.setOutputs(_outputs);

		_agent.execute();
		
		System.out.println(_outputs.get("Runoff"));
	}
}
