package cn.geodata.models.glacier.actions.models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import junit.framework.TestCase;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

public class RunoffProcessTest extends TestCase {
	private Logger log = Logger.getAnonymousLogger();
	private File folder;
	private String fieldName;
	
	public RunoffProcessTest() {
		folder = new File("D:\\Temp\\data3\\20081023");
		this.fieldName = "站点";
	}
	
	public void testTest2() throws Exception {
		Map<String, double[]> _map = new HashMap<String, double[]>();
		List<String> _list = FileUtils.readLines(new File(this.folder, "areas.csv"), "gb2312");
		
		assertNotNull(_list);
		
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
		assertNotNull(_levels);
		
		for(String _b : _map.keySet()){
			double[] _areas = _map.get(_b);
			
			double _a = 0.0;
			for(double _aa : _areas){
				_a += _aa;
			}
			
			if(_a > 0){
				this.calculateRunoff(_b, 1960, 2007, _levels, _areas);
//				this.calculateRunoff(_b, 1980, 1990, _levels, _areas);
			}
			else{
				log.warning("Skip basin:" + _b);
			}
		}
	}
	
	protected void calculateRunoff(String basin, int startYear, int endYear, double[] levels, double[] areas) throws Exception {
		log.info("Calculating basin:" + basin);
		File _path = new File(this.folder, basin);
		
		if(_path.exists() == false){
			_path.mkdir();
//		}
//		else{
//			return;
		}

		JSONObject _param = JSONObject.fromString("{\"Temperature\":{\"id\":\"TemperatureModelEx\",\"params\":{\"Power\":2,\"Stand\":3000,\"Grads\":-0.006}},\"Precipitation\":{\"id\":\"PrecipitationModel\",\"params\":{\"Power\":2}},\"SnowDDF\":{\"id\":\"SnowDDFModel\",\"params\":{\"Power\":2}},\"IceDDF\":{\"id\":\"IceDDFModel\",\"params\":{\"Power\":2}},\"Runoff\":{\"id\":\"RunoffModel\",\"params\":{\"RainCritical\":2,\"SnowCritical\":-0.5,\"SnowFrozenRatio\":0.1}}}");
		
		MultiPolygon _border = this.getCatchment(basin, new File(this.folder, "data\\basin.shp"));
		Point _pt = _border.getCentroid();
		RunoffProcess _p = new RunoffProcess(_pt.getX(), _pt.getY(), startYear, endYear, basin, _param, levels, areas);
		
		_p.run();
		
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
	}

	private FeatureCollection getGlaciers(String path) throws MalformedURLException,
			IOException {
		return new ShapefileDataStore(new File(path).toURL(),
				false, Charset.forName("gb2312")).getFeatureSource()
				.getFeatures();
	}

	private MultiPolygon getCatchment(String catchmentName, String path)
			throws MalformedURLException, IOException {
		return this.getCatchment(catchmentName, new File(path));
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
