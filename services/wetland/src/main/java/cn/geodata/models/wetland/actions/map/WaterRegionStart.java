package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.logging.Logger;

import net.sf.json.JSONObject;

import org.dom4j.Element;
import org.geotools.feature.FeatureCollection;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;

import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;
import cn.geodata.models.exception.ProcessingException;
import cn.geodata.models.gml.ParserUtil;

import com.vividsolutions.jts.geom.MultiPolygon;

public class WaterRegionStart extends ProcessStart {
	private static Logger log = Logger.getAnonymousLogger();
	private Catchment catchment;
	
	public WaterRegionStart(Catchment catchment){
		this.catchment = catchment;
	}

	public String execute() throws Exception {
		XMLOutputter _output = new XMLOutputter();
		try{
			//Input Parameters
			String _basin = this.params.getString("basin");
			double _waterLevel = this.params.getDouble("level");
			
			JSONObject _params = this.params.getJSONObject("params");
	
			//Processing
			ProcessLibrary _library = ProcessLibrary.createInstance();
			Processing _regionModel = this.createProcess(_library, _params.getJSONObject("WaterRegion"));
			
			MultiPolygon _border = this.catchment.findCatchmentByTag(_basin);
			_regionModel.setInput("Catchment", _border);
			_regionModel.setInput("WaterLevel", _waterLevel);
	
			//Execute the process
			_library.executeProcess(_regionModel);
			
			//Serialize output feature collection
			FeatureCollection _fs = (FeatureCollection) _regionModel.getOutput("WaterRegion");
			String _txt = _output.outputString(ParserUtil.createParserFinder().encode(_fs));
			this.stream = new ByteArrayInputStream(_txt.getBytes("utf-8"));
		}
		catch(Exception err){
			org.jdom.Element _err = new org.jdom.Element("error");
			_err.setText(err.getMessage());
			
			this.stream = new ByteArrayInputStream(_output.outputString(_err).getBytes("utf-8"));			
		}
		
		return "success";
	}
	
	private Processing createProcess(ProcessLibrary library, JSONObject param) throws ProcessingException{
		Processing _p = library.createProcess(param.getString("id"));
		
		JSONObject _params = param.getJSONObject("params");
		Iterator _keys = _params.keys();
		while(_keys.hasNext()){
			String _k = (String) _keys.next();
			library.setInput(_p, _k, _params.get(_k));
		}
		
		return _p;
	}
}
