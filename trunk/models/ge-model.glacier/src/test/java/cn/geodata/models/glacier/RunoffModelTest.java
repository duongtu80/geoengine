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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	public void atestTest1() throws Exception {
		String _txt = "{0.52, -0.52, 0.52, -0.52, 0.54, 0.52, 0.52},\r\n{0.48, 0.5, 0.48, 0.5, 0.48, 0.5, 0.5},\r\n{0.54, 0.52, 0.54, 0.54, 0.54, 0.54, 0.54},\r\n{0.46, 0.44, 0.46, 0.46, 0.46, 0.46, 0.46},\r\n{0.48, 0.46, 0.48, 0.46, 0.48, 0.48, 0.46}";
		Pattern _p = Pattern.compile("(-{0,1}[\\d\\.]+)");
		
		Matcher _m = _p.matcher(_txt);
		int _pos = 0;
		while(_m.find(_pos)){
			System.out.println(_m.end(1));
			System.out.println(_m.group(1));
			_pos = _m.end(1);
		}
	}
	
	public void testTest2() throws Exception {
		String _temperatureM = "{\n				{0.52, 0.52, 0.52, 0.52, 0.54, 0.52, 0.52},\n				{0.48, 0.5, 0.48, 0.5, 0.48, 0.5, 0.5},\n				{0.54, 0.52, 0.54, 0.54, 0.54, 0.54, 0.54},\n				{0.46, 0.44, 0.46, 0.46, 0.46, 0.45, 0.46},\n				{0.48, 0.46, 0.48, 0.46, 0.48, 0.48, 0.46}				\n				}";
		String _temperatureV = "{28, 30, 32, 34, 36}";
		String _temperatureL = "{2000, 2500, 3000, 3500, 4000, 4500, 5000}";
		
		this.temperature4Band(30, 2000, 4000, _temperatureM, _temperatureV, _temperatureL);
	}
	
	/**
	 * 计算分带的气温
	 * 
	 * @param val
	 * @param sourceLat
	 * @param targetLat
	 * @return
	 */
	private double temperature4Band(double val, double sourceLat, double targetLat, String temperatureM, String temperatureV, String temperatureL) {
		double[][] _m = new double[5][7];
		List<Double> _mm = this.searchNumbers(temperatureM);
		System.out.println("Len:" + _mm.size());
		for(int _col=0;_col<5;_col++){
			for(int _row=0;_row<7;_row++){
				_m[_col][_row] = _mm.get(_col * 7 + _row);
			}
		}
		
		for(int i=0;i<5;i++){
			System.out.println(Arrays.toString(_m[i]));
		}
		
		List<Double> _v = this.searchNumbers(temperatureV);
		System.out.println(Arrays.toString(_v.toArray()));
		List<Double> _l = this.searchNumbers(temperatureL);
		System.out.println(Arrays.toString(_l.toArray()));
		
		double _lat = 40;
		int _y = _v.size() - 1;
		for(int i=0;i<_v.size();i++){
			if(_lat <= _v.get(i)){
				_y = i;
				break;
			}
		}
		System.out.println("Y:" + _y);
		
		double _d = _m[_y][_l.size() - 1];
		for(int i=0;i<_l.size() - 1;i++){
			if(targetLat <= _m[_y][i]){
				_d = _m[_y][i];
				System.out.println(i);
				break;
			}
		}
		System.out.println("D:" + _d);
		
		return val + _d * (sourceLat - targetLat) / 100.0;
	}

	/**
	 * 从数值字符串列表中提取数值数组
	 * 
	 * @param txt
	 * @return
	 */
	private List<Double> searchNumbers(String txt){
		Pattern _p = Pattern.compile("(-{0,1}[\\d\\.]+)");
		
		List<Double> _list = new ArrayList<Double>();
		Matcher _m = _p.matcher(txt);
		int _pos = 0;
		while(_m.find(_pos)){
			_list.add(Double.parseDouble(_m.group(1)));
			_pos = _m.end(1);
		}
		
		return _list;
	}

	public void atestCalculate() throws Exception {
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
	
//	public void testComputeCT() throws Exception {
//		RunoffModel _m = new RunoffModel();
//		double _v = _m.computerAT(45, 7, 12.7, 31);
//		
//		System.out.println(_v);
//	}
}
