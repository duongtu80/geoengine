package cn.geodata.model.client;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.geotools.data.wfs.WFSDataStore;
import org.geotools.data.wfs.WFSDataStoreFactory;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;

import net.opengeospatial.wps.ProcessBriefType;

import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.gml.ParserFinder;
import cn.geodata.models.gml.ParserUtil;
import cn.geodata.models.wps.client.WpsProcess;
import cn.geodata.models.wps.client.WpsService;
import junit.framework.TestCase;

public class GlacierModelTest extends TestCase {
	private WpsService wps;
	@Override
	protected void setUp() throws Exception {
		super.setUp();

		wps = new WpsService(new URI("http://127.0.0.1:59080/web/wps"));
		wps.connect();
	}
	
	public void testGetCapabilities() throws Exception {
		System.out.println(this.wps.getMetadata().xmlText());
		
		for(ProcessBriefType _p : this.wps.listProcesses()){
			System.out.println(_p.getIdentifier().getStringValue());
		}
	}
	
	public void testTemperatureIdw() throws Exception {
		GeometryFactory _factory = new GeometryFactory();
		
		Map<String, Object> _inputs = new HashMap<String, Object>();
		
		_inputs.put("Date", new Long((new Date(80, 0, 1)).getTime()));
		_inputs.put("Pow", new Integer(2));
		_inputs.put("Site", _factory.createPoint(new Coordinate(110.2, 33.3)));
		
		WpsProcess _p = this.wps.getWpsProcess("Glacier.TemperatureIdw");
		_p.execute(_inputs);
		
		System.out.println(_p.getOutput("Temperature", DataCategories.getInstance().findCategory("double")));
	}
	
	public void testPrecipitationIdw() throws Exception {
		GeometryFactory _factory = new GeometryFactory();
		
		Map<String, Object> _inputs = new HashMap<String, Object>();
		
		_inputs.put("Date", new Long((new Date(80, 0, 1)).getTime()));
		_inputs.put("Pow", new Integer(2));
		_inputs.put("Site", _factory.createPoint(new Coordinate(110.2, 33.3)));
		
		WpsProcess _pp = this.wps.getWpsProcess("Glacier.PrecipitationIdw");
		_pp.execute(_inputs);
		
		System.out.println(_pp.getOutput("Precipitation", DataCategories.getInstance().findCategory("double")));
	}
	
	public void testSnowDdfIdw() throws Exception {
		GeometryFactory _factory = new GeometryFactory();
		
		Map<String, Object> _inputs = new HashMap<String, Object>();
		
		_inputs.put("Pow", new Integer(2));
		_inputs.put("Site", _factory.createPoint(new Coordinate(110.2, 33.3)));
		
		WpsProcess _pp = this.wps.getWpsProcess("Glacier.SnowDdfIdw");
		_pp.execute(_inputs);
		
		System.out.println(_pp.getOutput("SnowDdf", DataCategories.getInstance().findCategory("double")));
	}

	public void testIceDdfIdw() throws Exception {
		GeometryFactory _factory = new GeometryFactory();
		
		Map<String, Object> _inputs = new HashMap<String, Object>();
		
		_inputs.put("Pow", new Integer(2));
		_inputs.put("Site", _factory.createPoint(new Coordinate(110.2, 33.3)));
		
		WpsProcess _pp = this.wps.getWpsProcess("Glacier.IceDdfIdw");
		_pp.execute(_inputs);
		
		System.out.println(_pp.getOutput("IceDdf", DataCategories.getInstance().findCategory("double")));
	}
	
	public void testGlacierRunoff() throws Exception {
		Map<String, Object> _inputs = new HashMap<String, Object>();

		_inputs.put("TemperatureModelUrl", "http://127.0.0.1:59080/web/wps#Glacier.TemperatureIdw");
		_inputs.put("PrecipitationModelUrl", "http://127.0.0.1:59080/web/wps#Glacier.PrecipitationIdw");
		_inputs.put("SnowDdfModelUrl",  "http://127.0.0.1:59080/web/wps#Glacier.SnowDdfIdw");
		_inputs.put("IceDdfModelUrl", "http://127.0.0.1:59080/web/wps#Glacier.IceDdfIdw");
		
		_inputs.put("Catchment", this.findCatchment(this.getWfsFeatureCollection("http://127.0.0.1:48080/geoserver/wfs", "geo:basin"), "tailang"));
		_inputs.put("Glacier", this.getWfsFeatureCollection("http://127.0.0.1:48080/geoserver/wfs", "geo:glacier"));
		_inputs.put("StartDate", new Date(80, 0, 1).getTime());
		_inputs.put("EndDate", new Date(90, 0, 1).getTime());

		_inputs.put("CellSize", 1.0 / 1200);
		_inputs.put("RainCritical", 5);
		_inputs.put("SnowCritical", 0);

		WpsProcess _pp = this.wps.getWpsProcess("Glacier.Runoff");
		_pp.execute(_inputs);
		
		System.out.println(_pp.getOutput("Runoff", DataCategories.getInstance().findCategory("string")));
	}
	
	private FeatureCollection getWfsFeatureCollection(String url, String datasetName) throws IOException{
		WFSDataStoreFactory _factory = new WFSDataStoreFactory();
		
		Map<String, Object> _params = new HashMap<String, Object>();
		_params.put(_factory.URL.key, new URL(url));
		_params.put(_factory.TIMEOUT.key, new Integer(60000));
		_params.put(_factory.PROTOCOL.key, false);
		
		WFSDataStore _dataStore = (WFSDataStore) _factory.createDataStore(_params);
//		for(String _schema : _dataStore.getTypeNames()){
//			System.out.println(_schema);
//		}
			
		return _dataStore.getFeatureSource(datasetName).getFeatures();
	}
	
	private MultiPolygon findCatchment(FeatureCollection fs, String catchment)throws IOException {
		for(Feature _f : (Feature[])fs.toArray(new Feature[0])) {
			if(_f.getAttribute("NAME").equals(catchment)){
				
				return (MultiPolygon) _f.getDefaultGeometry();
			}
		}
		return null;
	}
	
	public void testMultiPolygon() throws Exception {
		MultiPolygon _polygon = this.findCatchment(this.getWfsFeatureCollection("http://127.0.0.1:48080/geoserver/wfs", "geo:basin"), "tailang");
		
		ParserFinder _parser = ParserUtil.createParserFinder();
		Element _element = _parser.encode(_polygon);
		
		XMLOutputter _output = new XMLOutputter(Format.getPrettyFormat());
		_output.output(_element, System.out);
		
		MultiPolygon _polygon2 = (MultiPolygon) _parser.parse(_element);
		System.out.println(_polygon2.getNumGeometries());
		
		System.out.println(_polygon2.getCentroid().toText());
	}
}
