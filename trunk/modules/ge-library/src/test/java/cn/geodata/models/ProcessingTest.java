package cn.geodata.models;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;

import cn.geodata.models.exception.ProcessingException;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

public class ProcessingTest extends TestCase {
	public void btestTest1() throws Exception {
		
	}
	
	public void atestArea() throws Exception {
		String[] _basins = new String[] {"Tuotuohe", "阿拉沟", "阿勒泰", "巴音布鲁克", "白吉", "白杨河", "冰沟", "布尔津", "布曲雁石坪站", "策勒", "插剑门", "察汗乌苏", "昌都站", "昌马堡", "楚玛尔河", "大米滩", "大青河", "党城湾", "迪那河", "丰乐河", "富温", "干沟门", "甘孜", "岗拖", "古浪水库", "哈拉衣敏", "黑山", "黑山头", "黑孜", "红山头", "黄河沿", "黄清", "黄水沟", "黄羊水库", "吉勒德", "加勒果拉", "解放大桥", "金川峡水库", "精河山口", "久治", "九条岭", "军功", "卡浪古尔", "卡浪古吕克河", "卡勒格牙", "卡木鲁克", "开垦河", "克尔古提", "克拉他什", "克勒克", "克勒克", "肯斯瓦特", "库克苏", "库鲁克栏干", "库威", "拉萨", "兰干", "李家桥", "马海", "煤窑沟", "那棱格勒", "纳赤台三站", "南营水库", "奴各沙", "努儿", "努买提兰干", "皮山", "匹里青", "破城子", "祁连", "恰甫", "切德克", "群库勒", "桑株", "沙沟寺", "沙里桂兰克", "沙曼", "石门子", "双树寺", "台兰", "台兰", "唐克", "头道河", "瓦房城", "维它克河", "温泉", "乌拉斯台", "乌鲁瓦提", "乌什水", "香日德", "小柴旦", "小川", "协和拉", "新地", "循化", "牙师", "英雄桥", "杂木寺", "则克台", "泽林沟", "札马什克", "制材厂", "朱巴", "濯桑", "尕大滩"};

		FeatureCollection _glaciers = this.getGlaciers();
		double[] _levels = new double[]{0, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000, 2100, 2200, 2300, 2400, 2500, 2600, 2700, 2800, 2900, 3000, 3100, 3200, 3300, 3400, 3500, 3600, 3700, 3800, 3900, 4000, 4100, 4200, 4300, 4400, 4500, 4600, 4700, 4800, 4900, 5000, 5100, 5200, 5300, 5400, 5500, 5600, 5700, 5800, 5900, 6000, 6100, 6200, 6300, 6400, 6500, 6600, 6700, 6800, 6900, 7000, 7100, 7200, 7300, 7400, 7500, 7600, 7700, 7800, 7900, 8000, 8100, 8200, 8300, 8400, 8500, 8600, 8700, 8800, 8900, 9000};
		ProcessLibrary _library = ProcessLibrary.createInstance();

		List<String> _lines = new ArrayList<String>();
		
		_lines.add(arrayToString("Levels", _levels));
		for(String _b : _basins){
			MultiPolygon _catchment = this.getCatchment(_b);
			
			//计算分带冰川面积
			Processing _areaModel = _library.createProcess("GlacierAreaModel");
			_library.setInput(_areaModel, "Glaciers", _glaciers);
			_library.setInput(_areaModel, "Catchment", _catchment);
			_library.setInput(_areaModel, "Levels", _levels);
			
			_library.executeProcess(_areaModel);
			double[] _areas = (double[]) _library.getOutput(_areaModel, "Areas");
			
			String _l = arrayToString(_b, _areas);
			_lines.add(_l);
			
			System.out.println(_l);
		}
		
		FileUtils.writeLines(new File("D:\\Tank\\Temp\\data\\areas.txt"), _lines);
	}
	
	public void testRunoff() throws Exception {
		Map<String, double[]> _map = new HashMap<String, double[]>();
		List<String> _list = FileUtils.readLines(new File("D:\\Tank\\Temp\\data\\areas.txt"));
		
		for(String _l : _list){
			String[] _parts = _l.split("\t");
			String _n = _parts[0];
			
			double[] _vs = new double[_parts.length - 1];
			for(int i=1;i<_parts.length;i++){
				_vs[i-1] = Double.parseDouble(_parts[i]);
			}
			
			_map.put(_n, _vs);
		}
		
		double[] _levels = _map.remove("Levels");
		String _name = "台兰"; 
		double[] _areas = _map.get(_name);
		
		this.calculateRunoff(_name, _levels, _areas);
	}
	
	protected void calculateRunoff(String basin, double[] levels, double[] areas) throws Exception {
		List<String> _lines = new ArrayList<String>();
		
//		FeatureCollection _glaciers = this.getGlaciers();
		MultiPolygon _catchment = this.getCatchment(basin);
		ProcessLibrary _library = ProcessLibrary.createInstance();
		
		//计算分带冰川面积
//		Processing _areaModel = _library.createProcess("GlacierAreaModel");
//		_library.setInput(_areaModel, "Glaciers", _glaciers);
//		_library.setInput(_areaModel, "Catchment", _catchment);
//		_library.setInput(_areaModel, "Levels", _levels);
//		
//		_library.executeProcess(_areaModel);
//		double[] _areas = (double[]) _library.getOutput(_areaModel, "Areas");
		_lines.add(arrayToString("分带面积", areas));
		
		Point _pt = _catchment.getCentroid();
			
		//计算中心点高程
		Processing _demmModel = _library.createProcess("DemModel90m");
		_library.setInput(_demmModel, "Point", _pt);
		
		_library.executeProcess(_demmModel);
		double _elevation = (Double)_library.getOutput(_demmModel, "Elevation");
		System.out.println("Elevation:" + _elevation);

		_pt.getCoordinate().z = _elevation;

		_lines.add("中心点\t" + _pt.getX() + "\t" + _pt.getY() + "\t" + _elevation);

		Processing _tempModel = _library.createProcess("TemperatureModelEx");
		Processing _precModel = _library.createProcess("PrecipitationModel");
		Processing _snowModel = _library.createProcess("SnowDDFModel");
		Processing _iceeModel = _library.createProcess("IceDDFModel");

		_library.setInput(_tempModel, "Point", _pt);
		_library.setInput(_precModel, "Point", _pt);
		_library.setInput(_snowModel, "Point", _pt);
		_library.setInput(_iceeModel, "Point", _pt);

		_library.executeProcess(_snowModel);
		_library.executeProcess(_iceeModel);

		_lines.add("SnowDDF\t" + _library.getOutput(_snowModel, "SnowDDF"));
		_lines.add("IceDDF\t" + _library.getOutput(_iceeModel, "IceDDF"));
		
		Processing _runoModel = _library.createProcess("RunoffModel");
		_library.setInput(_runoModel, "Levels", levels);
		_library.setInput(_runoModel, "Areas", areas);
		_library.setInput(_runoModel, "Location", _pt);

//		_library.setInput(_runoModel, "EvaporationRatio", 1);
//		_library.setInput(_runoModel, "TemperatureGrad", -0.006);
//		_library.setInput(_runoModel, "PrecipitationGrad", 1);
//		_library.setInput(_runoModel, "SnowCritical", 0);
//		_library.setInput(_runoModel, "RainCritical", 5);
//		_library.setInput(_runoModel, "SnowFrozenRatio", 0.3);
		
		Date _startDate = new Date(80, 9, 1);
		Date _endDate = new Date(81, 9, 1);
		

		Calendar _calendar = Calendar.getInstance();
		_calendar.setTime(_startDate);

		DateFormat _format = new SimpleDateFormat("yyyy-MM");
		
		double[] _accumulations = null;
		
		Map<String, List<String>> _itemLines = new HashMap<String, List<String>>();
		_itemLines.put("Temperatures", new ArrayList<String>());
		_itemLines.put("Precipitations", new ArrayList<String>());
		_itemLines.put("Accumulations", new ArrayList<String>());
		_itemLines.put("Balances", new ArrayList<String>());
		_itemLines.put("Runoffs", new ArrayList<String>());
		
		for(String _key : _itemLines.keySet()){
			StringBuilder _l = new StringBuilder("Date");
			for(int i=0;i<levels.length;i++){
				_l.append("\t" + levels[i] + "m");
			}
			
			_itemLines.get(_key).add(_l.toString());
		}
		
		while(_calendar.getTime().before(_endDate)){
			Date _date = _calendar.getTime();
			int _days = this.getDaysOfMonth(_calendar);
			
			System.out.println("Date:" + _format.format(_date));
//			System.out.println("Days:" + _days);
			
			_library.setInput(_tempModel, "Date", _date);
			_library.executeProcess(_tempModel);
//			System.out.println("Temperature:" + _library.getOutput(_tempModel, "Temperature"));

			_library.setInput(_precModel, "Date", _date);
			_library.executeProcess(_precModel);
//			System.out.println("Precipitation:" + _library.getOutput(_precModel, "Precipitation"));
		
			_library.setInput(_runoModel, "Temperature", _library.getOutput(_tempModel, "Temperature"));
			_library.setInput(_runoModel, "Precipitation", _library.getOutput(_precModel, "Precipitation"));
			_library.setInput(_runoModel, "PrecElevation", _library.getOutput(_precModel, "Elevation"));
			_library.setInput(_runoModel, "Accumulations", _accumulations);
			_library.setInput(_runoModel, "SnowDDF", (Double)_library.getOutput(_snowModel, "SnowDDF") * _days);
			_library.setInput(_runoModel, "IceDDF", (Double)_library.getOutput(_iceeModel, "IceDDF") * _days);
			_library.setInput(_runoModel, "Date", _date);
			
			_library.executeProcess(_runoModel);
//			System.out.println("Runoffs:" + Arrays.toString((double[])_library.getOutput(_runoModel, "Runoffs")));
//			System.out.println("Accumulations:" + Arrays.toString((double[])_library.getOutput(_runoModel, "Accumulations")));
//			System.out.println("Balances:" + Arrays.toString((double[])_library.getOutput(_runoModel, "Balances")));

			_accumulations = (double[]) _library.getOutput(_runoModel, "Accumulations");
			//如果是10月，则清理累积值
			if(_date.getMonth() != 9){
				_accumulations = _accumulations.clone();
			}
			else{
				_accumulations = new double[_accumulations.length];
			}
			
			//Jump to next month
			_calendar.add(Calendar.MONTH, 1);
			
			double _runoff = 0;
			for(double _r : (double[])_library.getOutput(_runoModel, "Runoffs")){
				_runoff += _r;
			}
			
			for(String _key : _itemLines.keySet()){
				_itemLines.get(_key).add(arrayToString(_format.format(_date), (double[])_library.getOutput(_runoModel, _key)));
			}
			_lines.add(_format.format(_date) + "\t" + _library.getOutput(_tempModel, "Temperature") + "\t" + _library.getOutput(_precModel, "Precipitation") + "\t" + _runoff);
		}
		
		FileUtils.writeLines(new File("D:\\Temp\\" + basin + "\\ouput3.txt"), _lines, "\n");
		for(String _key : _itemLines.keySet()){
			FileUtils.writeLines(new File(new File("D:\\Temp\\" + basin + "\\"), _key + ".txt"), _itemLines.get(_key), "\n");
		}	
	}

	public void atestTest1() throws Exception {
		List<String> _lines = new ArrayList<String>();
		
//		FeatureCollection _glaciers = this.getGlaciers();
		MultiPolygon _catchment = this.getCatchment("tailang");
		int[] _levels = new int[]{1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000, 5500, 6000, 6500, 7000, 7500, 8000, 8500, 9000};
		
		ProcessLibrary _library = ProcessLibrary.createInstance();
		
		//计算分带冰川面积
//		Processing _areaModel = _library.createProcess("GlacierAreaModel");
//		_library.setInput(_areaModel, "Glaciers", _glaciers);
//		_library.setInput(_areaModel, "Catchment", _catchment);
//		_library.setInput(_areaModel, "Levels", _levels);
//		
//		_library.executeProcess(_areaModel);
//		double[] _areas = (double[]) _library.getOutput(_areaModel, "Areas");
		double[] _areas = new double[] {0, 0, 0, 0, 10071575.96, 74964858.83, 152684710.46, 104250182.91, 57368642.73, 26153179.08, 12096998.84, 4265624.77, 374345.92, 0, 0, 0, 0};
		_lines.add(arrayToString("分带面积", _areas));
		
		Point _pt = _catchment.getCentroid();
			
		//计算中心点高程
		Processing _demmModel = _library.createProcess("DemModel90m");
		_library.setInput(_demmModel, "Point", _pt);
		
		_library.executeProcess(_demmModel);
		double _elevation = (Double)_library.getOutput(_demmModel, "Elevation");
		System.out.println("Elevation:" + _elevation);

		_pt.getCoordinate().z = _elevation;

		_lines.add("中心点\t" + _pt.getX() + "\t" + _pt.getY() + "\t" + _elevation);

		Processing _tempModel = _library.createProcess("TemperatureModelEx");
		Processing _precModel = _library.createProcess("PrecipitationModel");
		Processing _snowModel = _library.createProcess("SnowDDFModel");
		Processing _iceeModel = _library.createProcess("IceDDFModel");

		_library.setInput(_tempModel, "Point", _pt);
		_library.setInput(_precModel, "Point", _pt);
		_library.setInput(_snowModel, "Point", _pt);
		_library.setInput(_iceeModel, "Point", _pt);

		_library.executeProcess(_snowModel);
		_library.executeProcess(_iceeModel);

		_lines.add("SnowDDF\t" + _library.getOutput(_snowModel, "SnowDDF"));
		_lines.add("IceDDF\t" + _library.getOutput(_iceeModel, "IceDDF"));
		
		Processing _runoModel = _library.createProcess("RunoffModel");
		_library.setInput(_runoModel, "Levels", _levels);
		_library.setInput(_runoModel, "Areas", _areas);
		_library.setInput(_runoModel, "Location", _pt);

//		_library.setInput(_runoModel, "EvaporationRatio", 1);
//		_library.setInput(_runoModel, "TemperatureGrad", -0.006);
//		_library.setInput(_runoModel, "PrecipitationGrad", 1);
//		_library.setInput(_runoModel, "SnowCritical", 0);
//		_library.setInput(_runoModel, "RainCritical", 5);
//		_library.setInput(_runoModel, "SnowFrozenRatio", 0.3);
		
		Date _startDate = new Date(80, 9, 1);
		Date _endDate = new Date(90, 9, 1);
		

		Calendar _calendar = Calendar.getInstance();
		_calendar.setTime(_startDate);

		DateFormat _format = new SimpleDateFormat("yyyy-MM");
		
		double[] _accumulations = null;
		
		Map<String, List<String>> _itemLines = new HashMap<String, List<String>>();
		_itemLines.put("Temperatures", new ArrayList<String>());
		_itemLines.put("Precipitations", new ArrayList<String>());
		_itemLines.put("Accumulations", new ArrayList<String>());
		_itemLines.put("Balances", new ArrayList<String>());
		_itemLines.put("Runoffs", new ArrayList<String>());
		
		for(String _key : _itemLines.keySet()){
			StringBuilder _l = new StringBuilder("Date");
			for(int i=0;i<_levels.length;i++){
				_l.append("\t" + _levels[i] + "m");
			}
			
			_itemLines.get(_key).add(_l.toString());
		}
		
		while(_calendar.getTime().before(_endDate)){
			Date _date = _calendar.getTime();
			int _days = this.getDaysOfMonth(_calendar);
			
			System.out.println("Date:" + _format.format(_date));
			System.out.println("Days:" + _days);
			
			_library.setInput(_tempModel, "Date", _date);
			_library.executeProcess(_tempModel);
//			System.out.println("Temperature:" + _library.getOutput(_tempModel, "Temperature"));

			_library.setInput(_precModel, "Date", _date);
			_library.executeProcess(_precModel);
//			System.out.println("Precipitation:" + _library.getOutput(_precModel, "Precipitation"));
		
			_library.setInput(_runoModel, "Temperature", _library.getOutput(_tempModel, "Temperature"));
			_library.setInput(_runoModel, "Precipitation", _library.getOutput(_precModel, "Precipitation"));
			_library.setInput(_runoModel, "PrecElevation", _library.getOutput(_precModel, "Elevation"));
			_library.setInput(_runoModel, "Accumulations", _accumulations);
			_library.setInput(_runoModel, "SnowDDF", (Double)_library.getOutput(_snowModel, "SnowDDF") * _days);
			_library.setInput(_runoModel, "IceDDF", (Double)_library.getOutput(_iceeModel, "IceDDF") * _days);
			_library.setInput(_runoModel, "Date", _date);
			
			_library.executeProcess(_runoModel);
//			System.out.println("Runoffs:" + Arrays.toString((double[])_library.getOutput(_runoModel, "Runoffs")));
//			System.out.println("Accumulations:" + Arrays.toString((double[])_library.getOutput(_runoModel, "Accumulations")));
//			System.out.println("Balances:" + Arrays.toString((double[])_library.getOutput(_runoModel, "Balances")));

			_accumulations = (double[])_library.getOutput(_runoModel, "Accumulations");
			
			//Jump to next month
			_calendar.add(Calendar.MONTH, 1);
			
			double _runoff = 0;
			for(double _r : (double[])_library.getOutput(_runoModel, "Runoffs")){
				_runoff += _r;
			}
			
			for(String _key : _itemLines.keySet()){
				_itemLines.get(_key).add(arrayToString(_format.format(_date), (double[])_library.getOutput(_runoModel, _key)));
			}
			_lines.add(_format.format(_date) + "\t" + _library.getOutput(_tempModel, "Temperature") + "\t" + _library.getOutput(_precModel, "Precipitation") + "\t" + _runoff);
		}
		
		FileUtils.writeLines(new File("D:\\Temp\\ouput3.txt"), _lines, "\n");
		for(String _key : _itemLines.keySet()){
			FileUtils.writeLines(new File(new File("d:\\temp"), _key + ".txt"), _itemLines.get(_key), "\n");
		}
	}
	
	private int getDaysOfMonth(Calendar c){
		Calendar _dd = (Calendar) c.clone();
		_dd.add(Calendar.MONTH, 1);
		
		return (int)((_dd.getTimeInMillis() - c.getTimeInMillis()) / (1000 * 60 * 60 * 24));
	}
	
	private FeatureCollection getGlaciers() throws MalformedURLException, IOException{
		return new ShapefileDataStore(new File("d:\\Tank\\Save\\Java\\geoengine\\var\\glacier\\apache-tomcat-6.0.16\\webapps\\geoserver\\data\\data\\china\\glacier.shp").toURL(), false, Charset.forName("gb2312")).getFeatureSource().getFeatures();
	}
	
	private MultiPolygon getCatchment(String catchmentName) throws MalformedURLException, IOException {
		FeatureIterator _it = new ShapefileDataStore(new File("d:\\Tank\\Save\\Java\\geoengine\\var\\glacier\\apache-tomcat-6.0.16\\webapps\\geoserver\\data\\data\\china\\basin.shp").toURL(), false, Charset.forName("gb2312")).getFeatureSource().getFeatures().features();
		try{
			while(_it.hasNext()){
				Feature _f = _it.next();
				if(_f.getAttribute("STATION").equals(catchmentName)){
					return (MultiPolygon) _f.getDefaultGeometry();
				}
			}
		}
		finally{
			_it.close();
		}
		
		return null;
	}
	
	private String arrayToString(String name, double[] values){
		DecimalFormat _numFormat = new DecimalFormat("0.00");

		StringBuilder _l = new StringBuilder(name);
		for(int i=0;i<values.length;i++){
			if(values[i] == 0){
				_l.append("\t0");
			}
			else{
				_l.append("\t" + _numFormat.format(values[i]));
			}
		}
		
		return _l.toString();
	}
}
