package cn.geodata.models.wps.client;

import java.util.logging.Logger;

import junit.framework.TestCase;

public class WpsServiceTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();
	
	private WpsService service;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.service = new WpsService();
	}

	public void testTest1() throws Exception {
//		this.service.setUri(new java.net.URI("http://127.0.0.1:8080/web/wps"));
//		this.service.connect();
//		
//		log.info(this.service.findPostUri("DescribeProcess").toString());
//		
//		WpsProcess _proc = this.service.getWpsProcess("swamp.cities");
//		
//		Map<String, Object> _inputs = new HashMap<String, Object>();
//		
//		URI _citiesUrl = new URI("http://127.0.0.1:18080/geoserver/wfs?");
//		_citiesUrl.setQueryString("service=WFS&request=GetFeature&typename=unep:cities&version=1.0.0");
//
//		_inputs.put("cities", _proc.createComplexRef(_citiesUrl.toString(), "text/xml", null, null));
//		_inputs.put("rise", new Double(3));
//		
//		_proc.execute(_inputs);
//		
////		log.info(_proc.getResponse().xmlText());
//		FeatureCollection _fs = (FeatureCollection) _proc.getOutput("swamp", DataCategories.getInstance().findCategory("featureCollection"));
//		assertNotNull(_fs);
//		
//		log.info("Feature size:" + _fs.size());
//		this.service.describeProcess("swamp.cities");
	}
}
