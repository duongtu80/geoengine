package cn.geodata.models.glacier.actions.map;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.Feature;
import org.opengis.feature.simple.SimpleFeature;

import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;

import com.vividsolutions.jts.geom.MultiPolygon;

public class GlacierArea {
	private File path;
	private File glacier;
	private File basin;
	private String fieldName;
	private int interval;

	public GlacierArea(File basin, String fieldName, File glacier, File path, int interval) {
		this.path = path;
		this.fieldName = fieldName;
		this.basin = basin;
		this.glacier = glacier;
		this.interval = interval;
	}

	public static void main(String[] args) throws Exception {
		if(args.length != 5){
			System.out.println("Usage: GlacierArea [basin shapefile] [basin field name] [glacier shapefile] [output folder] [elevation interval]");
			return;
		}
		
		System.out.println("Basin shapefile:" + args[0]);
		System.out.println("Basin field name:" + args[1]);
		System.out.println("Glacier shapefile:" + args[2]);
		System.out.println("Output folder:" + args[3]);
		System.out.println("Elevation interval:" + args[4]);

//		this.path = new File("D:\\Temp\\data3\\20081021");
//		this.glacier = new File("d:\\Tank\\Save\\Java\\geoengine\\var\\glacier\\apache-tomcat-6.0.16\\webapps\\geoserver\\data\\data\\china\\glacier.shp");
//		this.glacier = new File("d:\\Temp\\data3\\data\\glacier.shp");
//		this.basin = new File("d:\\Temp\\data3\\20081021\\data\\昌马堡.shp");

		GlacierArea _p = new GlacierArea(new File(args[0]), args[1], new File(args[2]), new File(args[3]), Integer.parseInt(args[4]));
//		_p.setPath(new File(args[0]));
//		_p.setBasin(new File(args[1]));
//		_p.setGlacier(new File(args[2]));
		
		_p.run();
	}
	
	public void run() throws Exception {
//		String[] _basins = new String[] {"Tuotuohe", "阿拉沟", "阿勒泰", "巴音布鲁克", "白吉", "白杨河", "冰沟", "布尔津", "布曲雁石坪站", "策勒", "插剑门", "察汗乌苏", "昌都站", "昌马堡", "楚玛尔河", "大米滩", "大青河", "党城湾", "迪那河", "丰乐河", "富温", "干沟门", "甘孜", "岗拖", "古浪水库", "哈拉衣敏", "黑山", "黑山头", "黑孜", "红山头", "黄河沿", "黄清", "黄水沟", "黄羊水库", "吉勒德", "加勒果拉", "解放大桥", "金川峡水库", "精河山口", "久治", "九条岭", "军功", "卡浪古尔", "卡浪古吕克河", "卡勒格牙", "卡木鲁克", "开垦河", "克尔古提", "克拉他什", "克勒克", "克勒克", "肯斯瓦特", "库克苏", "库鲁克栏干", "库威", "拉萨", "兰干", "李家桥", "马海", "煤窑沟", "那棱格勒", "纳赤台三站", "南营水库", "奴各沙", "努儿", "努买提兰干", "皮山", "匹里青", "破城子", "祁连", "恰甫", "切德克", "群库勒", "桑株", "沙沟寺", "沙里桂兰克", "沙曼", "石门子", "双树寺", "台兰", "台兰2", "唐克", "头道河", "瓦房城", "维它克河", "温泉", "乌拉斯台", "乌鲁瓦提", "乌什水", "香日德", "小柴旦", "小川", "协和拉", "新地", "循化", "牙师", "英雄桥", "杂木寺", "则克台", "泽林沟", "札马什克", "制材厂", "朱巴", "濯桑", "尕大滩"};
		List<String> _basins = this.loadCatchments();
		System.out.println("Found basins:" + Arrays.toString(_basins.toArray()));

		FeatureCollection _glaciers = this.getGlaciers();
		
		int _intervalSize = (int)Math.ceil(10000.0 / this.interval);
		double[] _levels = new double[_intervalSize];
		for(int i=0;i<_intervalSize;i++){
			_levels[i] = i * this.interval;
		}
		
		ProcessLibrary _library = ProcessLibrary.createInstance();

		List<String> _lines = new ArrayList<String>();
		List<String> _landLines = new ArrayList<String>();
		
		_lines.add(arrayToString("Levels", _levels));
		_landLines.add(arrayToString("Levels", _levels));
		for(String _b : _basins){
			System.out.print("Basin" + _b + "\t");
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

			double[] _landAreas = (double[]) _library.getOutput(_areaModel, "LandAreas");
			_landLines.add(arrayToString(_b, _landAreas));

			System.out.println(_l);
		}
		
		System.out.println("Output to " + new File(path, "areas.csv").getAbsolutePath());
		FileUtils.writeLines(new File(path, "areas.csv"), "gb2312", _lines);

		System.out.println("Output to " + new File(path, "landAreas.csv").getAbsolutePath());
		FileUtils.writeLines(new File(path, "landAreas.csv"), "gb2312", _landLines);
	}

	private int getDaysOfMonth(Calendar c){
		Calendar _dd = (Calendar) c.clone();
		_dd.add(Calendar.MONTH, 1);
		
		return (int)((_dd.getTimeInMillis() - c.getTimeInMillis()) / (1000 * 60 * 60 * 24));
	}
	
	private FeatureCollection getGlaciers() throws MalformedURLException, IOException{
		return new ShapefileDataStore(this.glacier.toURL(), false, Charset.forName("gb2312")).getFeatureSource().getFeatures();
	}
	
	private MultiPolygon getCatchment(String catchmentName) throws MalformedURLException, IOException {
		FeatureIterator _it = new ShapefileDataStore(this.basin.toURL(), false, Charset.forName("gb2312")).getFeatureSource().getFeatures().features();
		try{
			while(_it.hasNext()){
				SimpleFeature _f = (SimpleFeature) _it.next();
				if(_f.getAttribute(fieldName).equals(catchmentName)){
					return (MultiPolygon) _f.getDefaultGeometry();
				}
			}
		}
		finally{
			_it.close();
		}
		
		return null;
	}
	
	private List<String> loadCatchments() throws MalformedURLException, IOException {
		List<String> _list = new ArrayList<String>();
		FeatureIterator _it = new ShapefileDataStore(this.basin.toURL(), false, Charset.forName("gb2312")).getFeatureSource().getFeatures().features();
		try{
			while(_it.hasNext()){
				SimpleFeature _f = (SimpleFeature) _it.next();
				
				String _val = (String)_f.getAttribute(this.fieldName);
				if(_val != null && _val.trim().length() > 0){
					_list.add(_val.trim());
				}
			}
		}
		finally{
			_it.close();
		}
		
		return _list;
	}
	
	private String arrayToString(String name, double[] values){
		DecimalFormat _numFormat = new DecimalFormat("0.00");

		StringBuilder _l = new StringBuilder(name);
		for(int i=0;i<values.length;i++){
			if(values[i] == 0){
				_l.append(",0");
			}
			else{
				_l.append("," + _numFormat.format(values[i]));
			}
		}
		
		return _l.toString();
	}
}
