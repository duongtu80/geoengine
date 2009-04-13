package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
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

public class WaterFowlsStart extends ProcessStart {
	private static Logger log = Logger.getAnonymousLogger();
	private Catchment catchment;
	private JSONObject waterFowls;
	
	public WaterFowlsStart(Catchment catchment) throws IOException{
		this.catchment = catchment;
		this.waterFowls = JSONObject.fromString(IOUtils.toString(WaterFowlsStart.class.getResourceAsStream("/wetland-data/waterfowls.txt")));
//		this.waterFowls = new String[] {"Mallard", "Gadwall", "American Wigeon", "Green Winged Teal", "Blue Winged Teal", "Northern Shoveler", "Northern Pintail", "Redhead", "Canvasback", "Lesser Scaup", "Ring Necked Duck", "Ruddy Duck"};
	}
	
	public void setCatchment(Catchment catchment) {
		this.catchment = catchment;
	}

	public String execute() throws Exception {
		String _basinCode = this.params.getString("basin");
		Double _waterLevel = this.params.getDouble("level");
		
        //Add simulation for water fowls
		List<String> _lines = new ArrayList<String>();
		_lines.add("lon	lat	title	description	iconSize	iconOffset	icon");
		
		JSONObject _params = this.params.getJSONObject("params");
		
		//Processing
		ProcessLibrary _library = ProcessLibrary.createInstance();
		MultiPolygon _basin = this.catchment.findCatchmentByTag(_basinCode);

		FeatureCollection _regions = this.calculateWaterRegion(_library, _params.getJSONObject("WaterRegion"), _basin, _waterLevel);
		double _area = this.calculateWaterArea(_regions);
		
		int _birdNum = 0;
		JSONObject _birdNums = new JSONObject();
		
		for(int i=0;i<this.waterFowls.names().length();i++){
			String _name = this.waterFowls.names().getString(i);
			String _image = this.waterFowls.getJSONObject(_name).getString("icon");

			JSONObject _infos = new JSONObject();
			_infos.put("icon", _image);
			
			int _waterFowlNum = this.calculateWaterFowlNum(_library, _params.getJSONObject("WaterFowls"), _name, _area);
			
			for(int j=0;j<_waterFowlNum;j++){
        		Point _pt = this.pickupLocation(_basin, null);
        		if(_pt != null){
//        			if(_waterFowl.equalsIgnoreCase("redhead")){
//        				_image = _waterFowl.toLowerCase().replace(" ", "_") + ".png";
//        			}
        			
        			if(_birdNums.has(_name)){
        				_birdNums.put(_name, _birdNums.getInt(_name) + 1);
        			}
        			else{
        				_birdNums.put(_name, 1);
        			}
        			
        			_lines.add(_pt.getX() + "\t" + _pt.getY() + "\t" + _name + "\t" + _name + "\t" + "30,30" + "\t" + "-12.5,-12.5" + "\t" + _image);
        			_birdNum++;
        		}
			}
		}
		//Add a empty line at the end
		_lines.add("");
		
		JSONObject _birds = new JSONObject();
		
		_birds.put("birdNum", _birdNum);
		_birds.put("birdNums", _birdNums);
		_birds.put("types", this.waterFowls);

		JSONObject _data = new JSONObject();
		_data.put("params", _birds);
		
		_data.put("text", StringUtils.join(_lines.iterator(), "\n"));
		stream = new ByteArrayInputStream(_data.toString().getBytes("utf-8"));

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
		GeometryFactory _factory = new GeometryFactory();
		
		for(int i=0;i<20;i++){
			double _x = (Math.random() * _ext.getWidth()) + _ext.getMinX();
			double _y = (Math.random() * _ext.getHeight()) + _ext.getMinY();
	
			Point _pt = _factory.createPoint(new Coordinate(_x, _y));
			if(g.contains(_pt) == false)
				continue;
	
			String _wkt = "PROJCS[\"Google Mercator\", GEOGCS[\"WGS 84\", DATUM[\"World Geodetic System 1984\", SPHEROID[\"WGS 84\", 6378137.0, 298.257223563, AUTHORITY[\"EPSG\",\"7030\"]], AUTHORITY[\"EPSG\",\"6326\"]], PRIMEM[\"Greenwich\", 0.0, AUTHORITY[\"EPSG\",\"8901\"]], UNIT[\"degree\", 0.017453292519943295], AXIS[\"Geodetic latitude\", NORTH], AXIS[\"Geodetic longitude\", EAST], AUTHORITY[\"EPSG\",\"4326\"]], PROJECTION[\"Mercator_1SP\"], PARAMETER[\"semi_minor\", 6378137.0], PARAMETER[\"latitude_of_origin\", 0.0], PARAMETER[\"central_meridian\", 0.0], PARAMETER[\"scale_factor\", 1.0], PARAMETER[\"false_easting\", 0.0], PARAMETER[\"false_northing\", 0.0], UNIT[\"m\", 1.0], AXIS[\"Easting\", EAST], AXIS[\"Northing\", NORTH], AUTHORITY[\"EPSG\",\"900913\"]]";
			CoordinateReferenceSystem _targetPrj = CRS.parseWKT(_wkt);
			CoordinateReferenceSystem _sourcePrj = CRS.decode("EPSG:4326", true);
			
			CoordinateOperation _coFactory = ReferencingFactoryFinder.getCoordinateOperationFactory(GeoTools.getDefaultHints()).createOperation(_sourcePrj, _targetPrj);
			
			return (Point) JTS.transform(_pt, _coFactory.getMathTransform());
		}
		
		return null;
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
	
	private FeatureCollection calculateWaterRegion(ProcessLibrary library, JSONObject params, MultiPolygon basin, double waterLevel) throws NumberFormatException, Exception {
		Processing _regionModel = this.createProcess(library, params);
		
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
	
	private int calculateWaterFowlNum(ProcessLibrary library, JSONObject params, String waterFowl, double waterArea) throws NumberFormatException, Exception{
		Processing _waterFowlModel = this.createProcess(library, params);
		_waterFowlModel.setInput("WaterArea", waterArea);
		_waterFowlModel.setInput("WaterFowl", waterFowl);
		
		//Execute the process
		library.executeProcess(_waterFowlModel);
		
		return (Integer)_waterFowlModel.getOutput("Number");
	}
}
