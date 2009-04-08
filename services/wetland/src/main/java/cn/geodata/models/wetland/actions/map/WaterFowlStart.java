package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;

import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;
import cn.geodata.models.exception.ProcessingException;

import com.vividsolutions.jts.geom.MultiPolygon;

public class WaterFowlStart extends ProcessStart {
	private static Logger log = Logger.getAnonymousLogger();
	private Catchment catchment;
	private String id;
	private String wetlandCode;
	private String[] waterFowls;
	
	public WaterFowlStart(Catchment catchment){
		this.catchment = catchment;
		this.waterFowls = new String[] {"Mallard", "Gadwall", "American Wigeon", "Green-winged Teal", "Blue-winged Teal", "Northern Shoveler", "Northern Pintail", "Redhead", "Canvasback", "Lesser Scaup", "Ring-necked Duck", "Ruddy Duck"};
	}
	
	public void setCatchment(Catchment catchment) {
		this.catchment = catchment;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setWetlandCode(String wetlandCode) {
		this.wetlandCode = wetlandCode;
	}

	public String execute() throws Exception {
        //Add simulation for water fowls
        JSONArray _waterFowls = new JSONArray();
        
        Process _p = this.manage.getProcess(this.id);
        JSONArray _waterLevels = _p.getData().getJSONArray("waterLevel");
        JSONArray _dates = _p.getData().getJSONArray("date");
    	
        ProcessLibrary _library = ProcessLibrary.createInstance();
        
        for(int i=0;i<_waterLevels.length();i++){
        	Date _date = new Date(_dates.getLong(i));
        	double _waterLevel = _waterLevels.getDouble(i);
        	
        	//Simulate water fowls for May
        	if(_date.getMonth() == 4 && _date.getDate() == 15){
        		JSONObject _birds = new JSONObject();
        		_birds.put("date", _dates);
        		
        		for(String _waterFowl : this.waterFowls){
        			int _waterFowlNum = this.calculateWaterFowlNum(_library, wetlandCode, _waterLevel, _waterFowl);
        			_birds.put(_waterFowl, _waterFowlNum);
        		}
        		
        		_waterFowls.put(_birds);
        	}
        }

		JSONObject _data = this.manage.getProcess(id).getData();
		stream = new ByteArrayInputStream(_data.toString().getBytes("utf-8"));		

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
	
	private int calculateWaterFowlNum(ProcessLibrary library, String wetlandCode, double waterLevel, String waterFowl) throws NumberFormatException, Exception{
		Processing _regionModel = library.createProcess("WaterRegionModel");
		
		MultiPolygon _border = this.catchment.findCatchmentByTag(wetlandCode);
		_regionModel.setInput("Catchment", _border);
		_regionModel.setInput("WaterLevel", waterLevel);
		
		//Execute the process
		library.executeProcess(_regionModel);
		
		//Serialize output feature collection
		FeatureCollection _fs = (FeatureCollection) _regionModel.getOutput("WaterRegion");

		//Calculate water region area
		double _area = 0;
		FeatureIterator _it = _fs.features();
		try{
			while(_it.hasNext()){
				_area += ((MultiPolygon)_it.next().getDefaultGeometry()).getArea();
			}
		}
		finally{
			_it.close();
		}
		
		Processing _waterFowlModel = library.createProcess("WaterFowlModel");
		_waterFowlModel.setInput("WaterArea", _area);
		_waterFowlModel.setInput("WaterFowl", waterFowl);
		
		//Execute the process
		library.executeProcess(_regionModel);
		
		return (Integer)_waterFowlModel.getOutput("Number");
	}
}
