package cn.geodata.models.glacier;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.geotools.geometry.Envelope2D;

import cn.geodata.models.tools.Utilities;
import cn.geodata.models.tools.raster.RasterManager;

import com.vividsolutions.jts.geom.Point;

import junit.framework.TestCase;

public class RunoffModelTest extends TestCase {
//	private RasterManager demModel;
//	
//	private LocationModel temperatureModel;
//	private LocationModel precipitationModel;
//	private LocationModel snowDDFModel;
//	private LocationModel iceDDFModel;
//
//	private GlacierPrepareModel prepareModel;
//	private ProjectTransformModel projectModel;
	
	public void testCalculate() throws Exception {
//		double[] _levels = new double[0];
//		
//		
//		List<String> _lines = new ArrayList<String>();
//		
//		if(levels == null || levels.length == 0){
//			throw new NullPointerException("No valid levels");
//		}
//		if(cellSize <= 0){
//			throw new IOException("No valid cellsize");
//		}
//		
//		Point _sitePoint = catchment.getCentroid();
//		log.info("Centeroid point:" + _sitePoint.toText());
//		
//		_lines.add("CenteroidPoint\t" + _sitePoint.toText());
//		
//		double _siteDem = demModel.getLocationValue(_sitePoint.getX(), _sitePoint.getY());
//		
//		//Calculate ddfs
//		double _snowDDF = (Double)this.snowDDFModel.calculate(null, _sitePoint);
//		double _iceDDF = (Double)this.iceDDFModel.calculate(null, _sitePoint);
//		
//		log.info("Snow DDF:" + _snowDDF);
//		log.info("Ice DDF:" + _iceDDF);
//		
//		_lines.add("SnowDDF\t" + _snowDDF);
//		_lines.add("IceDDF\t" + _iceDDF);
//		
//		DateFormat _format = new SimpleDateFormat("yyyy-MM");
//		
//		Calendar _calendar = Calendar.getInstance();
//		_calendar.setTime(startDate);
//		
//		Map<Integer, Integer> _areas = this.prepareModel.calculate(catchment, cellSize, null); 
//		List<BandInfo> _pixels = new ArrayList<BandInfo>();
//		for(int i=0;i<levels.length;i++){
//			BandInfo _band = new BandInfo();
//			_band.setBandAltitude(levels[i]);
//			
//			long _glaicerCount = 0;
//			for(Integer _k : _areas.keySet()){
//				if(_k <= levels[i]){
//					_glaicerCount += _areas.get(_k).longValue();
//				}
//			}
//			_band.setGlacierCount(_glaicerCount);
//			
//			_pixels.add(_band);
//		}
//		
//		double _pixelArea = this.projectModel.calculate(Utilities.covertEnvelope2D(new Envelope2D(null, _sitePoint.getX(), _sitePoint.getY(), cellSize, cellSize))).getArea();
//		
//		log.info(Arrays.toString(_pixels.toArray()));
//		log.info("Pixel Area:" + _pixelArea);
//		
//		_lines.add("Area\t" + _pixelArea);
//		
//		List<ObjectMonth> _months = new ArrayList<ObjectMonth>();
//		while(_calendar.getTime().before(endDate)){
//			StringBuilder _line = new StringBuilder();
//			_line.append(_format.format(_calendar.getTime()));
//			
//			log.info("Date:" + _format.format(_calendar.getTime()));
//			
//			//Calculate precipitation temperature values
//			double _temp = (Double)this.temperatureModel.calculate(_calendar.getTime(), _sitePoint);
//			log.info("Temperature:" + _temp);
//			
//			double _prec = (Double)this.precipitationModel.calculate(_calendar.getTime(), _sitePoint);
//			log.info("Precipitation:" + _prec);
//			
////			double _accuml = 0;
//			double _runoff = 0;
//
//		}
//		
//		FileUtils.writeLines(new File("d:\\Temp\\outputEx.txt"), "gb2312", _lines, "\n");
//
	}
	
	public void testComputeCT() throws Exception {
		RunoffModel _m = new RunoffModel();
		double _v = _m.computerAT(45, 7, 12.7, 31);
		
		System.out.println(_v);
	}
}
