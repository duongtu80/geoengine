package cn.geodata.models.glacier.actions.map;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureIterator;

import cn.geodata.models.glacier.actions.models.RunoffProcess;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

public class GlacierRunoff {
	private Logger log = Logger.getAnonymousLogger();

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		if(args.length != 5){
			System.out.println("Usage: GlacierRunoff [basin shapefile] [basin field name] [startYear] [endYear] [output folder]");
			return;
		}
		
		System.out.println("Basin shapefile:" + args[0]);
		System.out.println("Basin field name:" + args[1]);
		System.out.println("Start year:" + args[2]);
		System.out.println("End year:" + args[3]);
		System.out.println("Data folder:" + args[4]);
		
		GlacierRunoff _glacier = new GlacierRunoff(new File(args[0]), args[1], new File(args[4]));
		_glacier.run(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		
		
	}

	private File basinShp;
	private String fieldName;
	private File dataFolder;
	
	public GlacierRunoff(File basinShp, String fieldName, File dataFolder) {
		this.basinShp = basinShp;
		this.fieldName = fieldName;
		this.dataFolder = dataFolder;
	}
	
	public void run(int startYear, int endYear) throws Exception {
		Map<String, double[]> _map = new HashMap<String, double[]>();
		List<String> _list = FileUtils.readLines(new File(this.dataFolder, "areas.csv"), "gb2312");
		
		for(String _l : _list){
			String[] _parts = _l.split(",");
			String _n = _parts[0];
			
			double[] _vs = new double[_parts.length - 1];
			for(int i=1;i<_parts.length;i++){
				_vs[i-1] = Double.parseDouble(_parts[i]);
			}

			log.info("Adding key " + _n);
			_map.put(_n, _vs);
		}
		
		double[] _levels = _map.remove("Levels");
		
		for(String _b : _map.keySet()){
			double[] _areas = _map.get(_b);
			
			double _a = 0.0;
			for(double _aa : _areas){
				_a += _aa;
			}
			
			if(_a > 0){
				this.calculateRunoff(_b, startYear, endYear, _levels, _areas);
			}
			else{
				log.warning("Skip basin:" + _b);
			}
		}
	}
	
	protected void calculateRunoff(String basin, int startYear, int endYear, double[] levels, double[] areas) throws Exception {
		log.info("Calculating basin:" + basin);
		File _path = new File(this.dataFolder, basin);
		
		if(_path.exists() == false){
			_path.mkdir();
//		}
//		else{
//			return;
		}

		MultiPolygon _border = this.getCatchment(basin, this.basinShp);
		Point _pt = _border.getCentroid();

//		JSONObject _param = JSONObject.fromString(FileUtils.readFileToString(new File(this.folder, "params.txt")));
//		JSONObject _param = JSONObject.fromString("{\"Temperature\":{\"id\":\"TemperatureModelEx\",\"params\":{\"Power\":2,\"Stand\":3000,\"Grads\":-0.006}},\"Precipitation\":{\"id\":\"PrecipitationModel\",\"params\":{\"Power\":2}},\"SnowDDF\":{\"id\":\"SnowDDFModel\",\"params\":{\"Power\":2}},\"IceDDF\":{\"id\":\"IceDDFModel\",\"params\":{\"Power\":2}},\"Runoff\":{\"id\":\"RunoffModel\",\"params\":{\"RainCritical\":2,\"SnowCritical\":-0.5,\"SnowFrozenRatio\":0.1}}}");
		JSONObject _param = JSONObject.fromString("{\"Temperature\":{\"id\":\"TemperatureModelEx\",\"params\":{}},\"Precipitation\":{\"id\":\"PrecipitationModel\",\"params\":{}},\"SnowDDF\":{\"id\":\"SnowDDFModel\",\"params\":{}},\"IceDDF\":{\"id\":\"IceDDFModel\",\"params\":{}},\"Runoff\":{\"id\":\"RunoffModel\",\"params\":{}}}");
		
		RunoffProcess _p = new RunoffProcess(_pt.getX(), _pt.getY(), startYear, endYear, basin, _param, levels, areas);
		
		_p.run();
		
		//判断是否计算失败
		if(_p.getStatus().getInt("percent") < 0){
			log.severe(_p.getStatus().getString("message"));
			return;
		}
		
		String[] _listCols = new String[] {"Temperatures", "AccumulatedTemperatures", "Precipitations", "Runoffs", "Accumulations", "Balances"};
		String[] _valuCols = new String[] {"Temperature", "Precipitation", "Runoff"};

		SimpleDateFormat _dateFormat = new SimpleDateFormat("yyyy-MM");
		DecimalFormat _numbFormat = new DecimalFormat("0.00");
		DecimalFormat _leveFormat = new DecimalFormat("0");		
		
		List<Object> _dates = _p.getMap().get("Dates");
		for(String _key : _listCols){
			List<Object> _item = _p.getMap().get(_key);
			
			FileOutputStream _stream = new FileOutputStream(new File(_path, _key + ".csv"));
			StringBuffer _line = new StringBuffer();
			
			_line.append(_key);
			for(int j=0;j<levels.length;j++){
				_line.append("," + _leveFormat.format(levels[j]) + "m");
			}
			_line.append("\n");

			for(int i=0;i<_item.size();i++){
				Date _d = (Date) _dates.get(i);
				_line.append(_dateFormat.format(_d));

				double[] _list = (double[])_item.get(i);
				for(int j=0;j<_list.length;j++){
					_line.append("," + _numbFormat.format(_list[j]));
				}
				_line.append("\n");
				
			}
			IOUtils.write(_line, _stream);
			_stream.close();
		}
		
		for(String _key : _valuCols){
			List<Object> _item = _p.getMap().get(_key);
			
			FileOutputStream _stream = new FileOutputStream(new File(_path, _key + ".csv"));
			StringBuffer _line = new StringBuffer();

			_line.append("Date," + _key + "\n");
			for(int i=0;i<_item.size();i++){
				Date _d = (Date) _dates.get(i);
				_line.append(_dateFormat.format(_d) + "," + _numbFormat.format((Double)_item.get(i)) + "\n");
				
			}

			IOUtils.write(_line, _stream);
			_stream.close();
		}
		
		List<Object> _balances = _p.getMap().get("Balances");
		
		double _totalArea = 0;
		for(int _b=0;_b<areas.length;_b++){
			_totalArea += areas[_b];
		}
		
		//写入雪线高度和年度平衡值
		List<String> _lines = new ArrayList<String>();
		_lines.add("Year,Balance,SnowLine");
		for(int _year = 0; _year < endYear-startYear; _year ++){
			double _bb = 0;
			int _snowLine = 0;
			
			for(int _b=areas.length-1;_b>=0;_b--){
				if(areas[_b] > 0){
					double _count = 0;
					for(int _mi=0;_mi<12;_mi++){
						double[] _list = (double[])_balances.get(_year * 12 + _mi);
						_count += _list[_b];
						
						//判断出现负值的最高分带作为雪线
						if(_list[_b] < 0 && _snowLine < _b){
							_snowLine = _b;
						}
					}
					_bb += _count * areas[_b] / _totalArea;
				}
			}
			
			//如果雪线低于最低冰川分带，则赋值为最低冰川分带
			if(_snowLine == 0){
				for(int _b=0;_b < areas.length;_b++){
					if(areas[_b] > 0){
						_snowLine = _b;
						break;
					}
				}
			}
			
			_lines.add(_year + startYear + "," + _bb + "," + levels[_snowLine]);
		}
		
		FileUtils.writeLines(new File(_path, "SnowLines.csv"), _lines);
	}

	private MultiPolygon getCatchment(String catchmentName, File path) throws MalformedURLException, IOException {
		FeatureIterator _it = new ShapefileDataStore(path.toURL(), false, Charset.forName("gb2312"))
				.getFeatureSource().getFeatures().features();
		try {
			while (_it.hasNext()) {
				Feature _f = _it.next();
				if (_f.getAttribute(this.fieldName).equals(catchmentName)) {
					return (MultiPolygon) _f.getDefaultGeometry();
				}
			}
		} finally {
			_it.close();
		}
		
		return null;
	}
}
