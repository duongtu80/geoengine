package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.geotools.factory.GeoTools;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.geometry.jts.JTS;
import org.geotools.geometry.jts.ReferencedEnvelope;
import org.geotools.referencing.CRS;
import org.geotools.referencing.ReferencingFactoryFinder;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.CoordinateOperation;
import org.opengis.referencing.operation.TransformException;

import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;
import cn.geodata.models.exception.ProcessingException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

public class ListWaterFowl extends ProcessStart {
	private static Logger log = Logger.getAnonymousLogger();
	private Catchment catchment;
	private String id;
	private String wetlandCode;
	private String[] waterFowls;
	private int year;
	
	public ListWaterFowl(Catchment catchment){
		this.catchment = catchment;
		this.waterFowls = new String[] {"Mallard", "Gadwall", "American Wigeon", "Green Winged Teal", "Blue Winged Teal", "Northern Shoveler", "Northern Pintail", "Redhead", "Canvasback", "Lesser Scaup", "Ring Necked Duck", "Ruddy Duck"};
	}
	
	public void setCatchment(Catchment catchment) {
		this.catchment = catchment;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setWetlandCode(String wetlandCode) {
		this.wetlandCode = wetlandCode;
	}

	public String execute() throws Exception {
        //Add simulation for water fowls
		List<String> _lines = new ArrayList<String>();
		_lines.add("lon	lat	title	description	iconSize	iconOffset	icon");
		
        Process _p = this.manage.getProcess(this.id);
        JSONArray _waterLevels = _p.getData().getJSONArray("waterLevel");
        JSONArray _dates = _p.getData().getJSONArray("date");
    	
        ProcessLibrary _library = ProcessLibrary.createInstance();
        
        //Calculate the average water level for May
        int _countMay = 0;
        double _waterLevelMay = 0;
        
		MultiPolygon _basin = this.catchment.findCatchmentByTag(wetlandCode);

        for(int i=0;i<_waterLevels.length();i++){
        	Date _date = new Date(_dates.getLong(i));
        	
        	if(_date.getYear() + 1900 == this.year && _date.getMonth() == 4){
        		_countMay++;
        		_waterLevelMay = Math.max(_waterLevelMay, _waterLevels.getDouble(i));
        	}
        	else if(_countMay > 0){
            	//Simulate water fowls for May
        		
        		FeatureCollection _regions = this.calculateWaterRegion(_basin, _library, wetlandCode, _waterLevelMay / _countMay);
        		double _area = this.calculateWaterArea(_regions);
        		
        		for(String _waterFowl : this.waterFowls){
        			int _waterFowlNum = this.calculateWaterFowlNum(_library, _waterFowl, _area);
        			
        			for(int j=0;j<_waterFowlNum;j++){
	            		Point _pt = this.pickupLocation(_basin, null);
	        			_lines.add(_pt.getX() + "\t" + _pt.getY() + "\t" + _waterFowl + "\t" + _waterFowl + "\t" + "25,25" + "\t" + "-12.5,-12.5" + "\t" + "images/waterfowls/" + _waterFowl.toLowerCase().replace(" ", "_") + ".gif");
        			}
        		}
        		
        		_countMay = 0;
        		_waterLevelMay = 0;
        	}
        }

        ByteArrayOutputStream _buffer = new ByteArrayOutputStream(); 
        IOUtils.writeLines(_lines, "\n", _buffer);
        
		stream = new ByteArrayInputStream(_buffer.toByteArray());

		return "success";
	}
	
	private Point pickupLocation(FeatureCollection fs, List<Point> pts) throws MismatchedDimensionException, NoSuchAuthorityCodeException, FactoryException, TransformException{
		if(fs.size() == 1){
			return pickupLocation((Feature)fs.toArray(new Feature[0])[0], pts);
		}
		else{
			return pickupLocation((Feature)fs.toArray(new Feature[0])[(int)Math.round(Math.random() * (fs.size() - 1))], pts);
		}
	}

	private Point pickupLocation(MultiPolygon g, List<Point> pts) throws NoSuchAuthorityCodeException, FactoryException, MismatchedDimensionException, TransformException{
		Envelope _ext = g.getEnvelopeInternal();
		
		double _x = (Math.random() * _ext.getWidth()) + _ext.getMinX();
		double _y = (Math.random() * _ext.getHeight()) + _ext.getMinY();
		
		String _wkt = "PROJCS[\"Google Mercator\", GEOGCS[\"WGS 84\", DATUM[\"World Geodetic System 1984\", SPHEROID[\"WGS 84\", 6378137.0, 298.257223563, AUTHORITY[\"EPSG\",\"7030\"]], AUTHORITY[\"EPSG\",\"6326\"]], PRIMEM[\"Greenwich\", 0.0, AUTHORITY[\"EPSG\",\"8901\"]], UNIT[\"degree\", 0.017453292519943295], AXIS[\"Geodetic latitude\", NORTH], AXIS[\"Geodetic longitude\", EAST], AUTHORITY[\"EPSG\",\"4326\"]], PROJECTION[\"Mercator_1SP\"], PARAMETER[\"semi_minor\", 6378137.0], PARAMETER[\"latitude_of_origin\", 0.0], PARAMETER[\"central_meridian\", 0.0], PARAMETER[\"scale_factor\", 1.0], PARAMETER[\"false_easting\", 0.0], PARAMETER[\"false_northing\", 0.0], UNIT[\"m\", 1.0], AXIS[\"Easting\", EAST], AXIS[\"Northing\", NORTH], AUTHORITY[\"EPSG\",\"900913\"]]";
		CoordinateReferenceSystem _targetPrj = CRS.parseWKT(_wkt);
		CoordinateReferenceSystem _sourcePrj = CRS.decode("EPSG:4326", true);
		
		CoordinateOperation _coFactory = ReferencingFactoryFinder.getCoordinateOperationFactory(GeoTools.getDefaultHints()).createOperation(_sourcePrj, _targetPrj);
		
		GeometryFactory _factory = new GeometryFactory();
		return (Point) JTS.transform(_factory.createPoint(new Coordinate(_x, _y)), _coFactory.getMathTransform());
	}

	private Point pickupLocation(Feature f, List<Point> pts) throws NoSuchAuthorityCodeException, FactoryException, MismatchedDimensionException, TransformException{
		ReferencedEnvelope _ext = f.getBounds();
		
		double _x = (Math.random() * _ext.getWidth()) + _ext.getMinX();
		double _y = (Math.random() * _ext.getHeight()) + _ext.getMinY();
		
		String _wkt = "PROJCS[\"Google Mercator\", GEOGCS[\"WGS 84\", DATUM[\"World Geodetic System 1984\", SPHEROID[\"WGS 84\", 6378137.0, 298.257223563, AUTHORITY[\"EPSG\",\"7030\"]], AUTHORITY[\"EPSG\",\"6326\"]], PRIMEM[\"Greenwich\", 0.0, AUTHORITY[\"EPSG\",\"8901\"]], UNIT[\"degree\", 0.017453292519943295], AXIS[\"Geodetic latitude\", NORTH], AXIS[\"Geodetic longitude\", EAST], AUTHORITY[\"EPSG\",\"4326\"]], PROJECTION[\"Mercator_1SP\"], PARAMETER[\"semi_minor\", 6378137.0], PARAMETER[\"latitude_of_origin\", 0.0], PARAMETER[\"central_meridian\", 0.0], PARAMETER[\"scale_factor\", 1.0], PARAMETER[\"false_easting\", 0.0], PARAMETER[\"false_northing\", 0.0], UNIT[\"m\", 1.0], AXIS[\"Easting\", EAST], AXIS[\"Northing\", NORTH], AUTHORITY[\"EPSG\",\"900913\"]]";
		CoordinateReferenceSystem _targetPrj = CRS.parseWKT(_wkt);
		CoordinateReferenceSystem _sourcePrj = CRS.decode("EPSG:4326", true);
		
		CoordinateOperation _coFactory = ReferencingFactoryFinder.getCoordinateOperationFactory(GeoTools.getDefaultHints()).createOperation(_sourcePrj, _targetPrj);
		
		GeometryFactory _factory = new GeometryFactory();
		return (Point) JTS.transform(_factory.createPoint(new Coordinate(_x, _y)), _coFactory.getMathTransform());
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
	
	private FeatureCollection calculateWaterRegion(MultiPolygon basin, ProcessLibrary library, String wetlandCode, double waterLevel) throws NumberFormatException, Exception {
		Processing _regionModel = library.createProcess("WaterRegionModel");
		
		_regionModel.setInput("Catchment", basin);
		_regionModel.setInput("WaterLevel", waterLevel);
		
		//Execute the process
		library.executeProcess(_regionModel);
		
		//Serialize output feature collection
		return (FeatureCollection) _regionModel.getOutput("WaterRegion");
	}
	
	private double calculateWaterArea(FeatureCollection fs) throws FactoryException, MismatchedDimensionException, NoSuchElementException, TransformException {
		String _wkt = "PROJCS[\"Lambert Azimuthal Equal Area (North America)\",GEOGCS[\"GCS_WGS_1984\",DATUM[\"D_WGS_1984\",SPHEROID[\"WGS_1984\",6378137.0,298.257223563]],PRIMEM[\"Greenwich\",0.0],UNIT[\"Degree\",0.0174532925199433]],PROJECTION[\"Lambert_Azimuthal_Equal_Area\"],PARAMETER[\"False_Easting\",0.0],PARAMETER[\"False_Northing\",0.0],PARAMETER[\"longitude_of_center\",-100],PARAMETER[\"latitude_of_center\",50],UNIT[\"Meter\",1.0]]";
		CoordinateReferenceSystem _targetPrj = CRS.parseWKT(_wkt);
		CoordinateReferenceSystem _sourcePrj = CRS.decode("EPSG:4326", true);
		CoordinateOperation _coFactory = ReferencingFactoryFinder.getCoordinateOperationFactory(GeoTools.getDefaultHints()).createOperation(_sourcePrj, _targetPrj);
		
		//Calculate water region area
		double _area = 0;
		FeatureIterator _it = fs.features();
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
