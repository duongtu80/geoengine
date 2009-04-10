package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.ReferencingFactoryFinder;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.CoordinateOperation;

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
		this.waterFowls = new String[] {"Mallard", "Gadwall", "American Wigeon", "Green Winged Teal", "Blue Winged Teal", "Northern Shoveler", "Northern Pintail", "Redhead", "Canvasback", "Lesser Scaup", "Ring Necked Duck", "Ruddy Duck"};
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
        
        //Calculate the average water level for May
        int _countMay = 0;
        double _waterLevelMay = 0;
        
        for(int i=0;i<_waterLevels.length();i++){
        	Date _date = new Date(_dates.getLong(i));
        	
        	if(_date.getMonth() == 4){
        		_countMay++;
        		_waterLevelMay = Math.max(_waterLevelMay, _waterLevels.getDouble(i));
        	}
        	else if(_countMay > 0){
            	//Simulate water fowls for May

        		JSONObject _birds = new JSONObject();
        		double _area = this.calculateWaterArea(_library, wetlandCode, _waterLevelMay / _countMay);
        		
        		_birds.put("date", _date.getTime());
        		_birds.put("waterLevel", _waterLevelMay / _countMay);
        		_birds.put("waterArea", _area);
        		
        		for(String _waterFowl : this.waterFowls){
        			int _waterFowlNum = this.calculateWaterFowlNum(_library, _waterFowl, _area);
        			_birds.put(_waterFowl, _waterFowlNum);
        		}
        		
        		_waterFowls.put(_birds);        		
        		
        		_countMay = 0;
        		_waterLevelMay = 0;
        	}
        }

		stream = new ByteArrayInputStream(_waterFowls.toString().getBytes("utf-8"));		

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
	
	private double calculateWaterArea(ProcessLibrary library, String wetlandCode, double waterLevel) throws NumberFormatException, Exception{
		Processing _regionModel = library.createProcess("WaterRegionModel");
		
		MultiPolygon _border = this.catchment.findCatchmentByTag(wetlandCode);
		_regionModel.setInput("Catchment", _border);
		_regionModel.setInput("WaterLevel", waterLevel);
		
		//Execute the process
		library.executeProcess(_regionModel);
		
		//Serialize output feature collection
		FeatureCollection _fs = (FeatureCollection) _regionModel.getOutput("WaterRegion");
		
		String _wkt = "PROJCS[\"Lambert Azimuthal Equal Area (North America)\",GEOGCS[\"GCS_WGS_1984\",DATUM[\"D_WGS_1984\",SPHEROID[\"WGS_1984\",6378137.0,298.257223563]],PRIMEM[\"Greenwich\",0.0],UNIT[\"Degree\",0.0174532925199433]],PROJECTION[\"Lambert_Azimuthal_Equal_Area\"],PARAMETER[\"False_Easting\",0.0],PARAMETER[\"False_Northing\",0.0],PARAMETER[\"longitude_of_center\",-100],PARAMETER[\"latitude_of_center\",50],UNIT[\"Meter\",1.0]]";
		CoordinateReferenceSystem _targetPrj = CRS.parseWKT(_wkt);
		CoordinateReferenceSystem _sourcePrj = CRS.decode("EPSG:4326", true);
		CoordinateOperation _coFactory = ReferencingFactoryFinder.getCoordinateOperationFactory(GeoTools.getDefaultHints()).createOperation(_sourcePrj, _targetPrj);
		
		//Calculate water region area
		double _area = 0;
		FeatureIterator _it = _fs.features();
		try{
			while(_it.hasNext()){
				_area += ((MultiPolygon)JTS.transform(_it.next().getDefaultGeometry(), _coFactory.getMathTransform())).getArea();
			}
		}
		finally{
			_it.close();
		}
		
		return _area;
	}
	
	private int calculateWaterFowlNum(ProcessLibrary library, String waterFowl, double waterArea) throws NumberFormatException, Exception{
		Processing _waterFowlModel = library.createProcess("WaterFowlModel");
		_waterFowlModel.setInput("WaterArea", waterArea);
		_waterFowlModel.setInput("WaterFowl", waterFowl);
		
		//Execute the process
		library.executeProcess(_waterFowlModel);
		
		return (Integer)_waterFowlModel.getOutput("Number");
	}
}
