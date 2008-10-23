package cn.geodata.models.glacier;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.geotools.feature.FeatureCollection;
import org.geotools.geometry.Envelope2D;
import org.geotools.referencing.CRS;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;
import cn.geodata.models.tools.Utilities;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

@GeoProcess(title="冰川面积模型", keywords={"glacier", "area"})
public class GlacierAreaModel implements Calculate {
	private Logger log = Logger.getAnonymousLogger();

	private DemModel demModel;
	private FeatureCollection glaciers;
	private MultiPolygon catchment;
	private double cellSize;
	private double[] levels;
	private double[] areas;
	
	public void calculate() throws Exception {
		GlacierPrepareModel _m = new GlacierPrepareModel(demModel.getRasterManager(), glaciers);
		
//		Map<Integer, Integer> _pixels = _m.calculate(catchment, cellSize, new File("d:\\Temp\\ttt5.tif"));
//		writePixels(_pixels);
		
//		Map<Integer, Integer> _pixels = _m.calculate(catchment, cellSize, new File("D:\\Temp\\data3\\20081010\\dem3.tif"));
		Map<Integer, Integer> _pixels = _m.calculate(catchment, cellSize, null);
//		Map<Integer, Integer> _pixels = this.readPixels();
		
		Point _pt = this.catchment.getCentroid();
		
		String _wkt = "PROJCS[\"Asia_North_Albers_Equal_Area_Conic\",GEOGCS[\"GCS_WGS_1984\",DATUM[\"D_WGS_1984\",SPHEROID[\"WGS_1984\",6378137.0,298.257223563]],PRIMEM[\"Greenwich\",0.0],UNIT[\"Degree\",0.0174532925199433]],PROJECTION[\"Albers\"],PARAMETER[\"False_Easting\",0.0],PARAMETER[\"False_Northing\",0.0],PARAMETER[\"Central_Meridian\",95.0],PARAMETER[\"Standard_Parallel_1\",15.0],PARAMETER[\"Standard_Parallel_2\",65.0],PARAMETER[\"Latitude_Of_Origin\",30.0],UNIT[\"Meter\",1.0]]";

		CoordinateReferenceSystem _sourcePrj = CRS.decode("EPSG:4326", true);
		CoordinateReferenceSystem _targetPrj = CRS.parseWKT(_wkt);

//		double _pixelArea = (new ProjectTransformModel("EPSG:4326", "EPSG:21416")).calculate(Utilities.covertEnvelope2D(new Envelope2D(null, _pt.getX(), _pt.getY(), cellSize, cellSize))).getArea();
		double _pixelArea = (new ProjectTransformModel(_sourcePrj, _targetPrj)).calculate(Utilities.covertEnvelope2D(new Envelope2D(null, _pt.getX(), _pt.getY(), cellSize, cellSize))).getArea();
		
		log.info("Pixel area:" + _pixelArea);
//		for(Integer _k : _pixels.keySet()){
//			System.out.println("Elevation " + _k + ":" + _pixels.get(_k));
//		}
//		
//		System.out.println("Pixel Area:" + _pixelArea);
		double[] _areas = new double[levels.length];
		for(int i=0;i<levels.length;i++){
			long _pixelCount = 0;
			for(Integer _k : _pixels.keySet()){
				if(i < levels.length - 1){
					if(_k >= levels[i] && _k < levels[i + 1]){
						_pixelCount += _pixels.get(_k).longValue();
					}
				}
				else{
					if(_k >= levels[i]){
						_pixelCount += _pixels.get(_k).longValue();
					}
				}
			}
			
			_areas[i] = _pixelCount * _pixelArea;
		}
		
		this.areas = _areas;
	}

	private Map<Integer, Integer> readPixels() throws NumberFormatException, IOException {
		Map<Integer, Integer> _map = new HashMap<Integer, Integer>();
		for(String _line : (List<String>)FileUtils.readLines(new File("D:\\Temp\\ttt2.txt"))){
			String[] _ps = _line.split("\t");
			_map.put(Integer.parseInt(_ps[0]), Integer.parseInt(_ps[1]));
		}
		
		return _map;
	}

	private void writePixels(Map<Integer, Integer> pixels) throws NumberFormatException, IOException {
		ArrayList<String> _lines = new ArrayList<String>();
		for(Integer _k : pixels.keySet()){
			Integer _v = pixels.get(_k);
			
			_lines.add(_k.toString() + "\t" + _v.toString());
		}
		
		FileUtils.writeLines(new File("D:\\Temp\\ttt2.txt"), _lines, "\n");
	}

	public int getPercent() {
		return 0;
	}

	@GeoOutput(title="冰川面积")
	public double[] getAreas() {
		return areas;
	}

	@GeoInput(title="冰川分布")
	public void setGlaciers(FeatureCollection glaciers) {
		this.glaciers = glaciers;
	}

	@GeoInput(title="目标流域")
	public void setCatchment(MultiPolygon catchment) {
		this.catchment = catchment;
	}

	@GeoInput(title="高程分级")
	public void setLevels(double[] levels) {
		this.levels = levels;
	}
	
	public void setCellSize(double cellSize) {
		this.cellSize = cellSize;
	}

	public void setDemModel(DemModel demModel) {
		this.demModel = demModel;
	}

	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}
