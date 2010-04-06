package cn.geodata.models.ecoserv.simulate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import cn.geodata.models.csv.CSVReader;
import cn.geodata.models.ecoserv.landcover.ConnectionPool;
import cn.geodata.models.raster.GeoRaster;
import cn.geodata.models.wetland.multiple.Catchment;
import cn.geodata.models.wetland.multiple.HydrologicalModel;
import cn.geodata.models.wetland.multiple.WaterTable;
import cn.geodata.models.wetland.multiple.WetlandWater;
import junit.framework.TestCase;

public class MultipleWaterTableTest extends TestCase {

	public static void main(String[] args) throws NumberFormatException,
			Exception {
		new MultipleWaterTableTest().precalculateWaterSurface4Month(new File(
				args[0]), new File(args[1]), Double.parseDouble(args[2]),
				Double.parseDouble(args[3]));
	}

	public void testTest1() throws Exception {
		new MultipleWaterTableTest().precalculateWaterSurface4Month(
				new File("d:\\Tank\\Data\\ecoserv\\data\\dem\\lidar4.tif"), new File("d:\\Tank\\Data\\ecoserv\\data\\tmp\\b2.csv"), 1,
				1);
	}

	public void precalculateWaterSurface4Month(File raster, File prec,
			double et, double p) throws Exception {
		double[] _ets = new double[] { 0.776261658, 1.380983699, 2.685167412,
				5.144484068, 7.134623128, 7.349951357, 7.328081254,
				6.885504999, 4.876430947, 2.789769327, 1.229707091, 0.769184209 };

		GeoRaster _reader = new GeoRaster(raster, 0);
		List<Catchment> _cats = Catchment.loadCatchments(_reader,
				ConnectionPool.getPGDataStore().getFeatureSource("catchment")
						.getFeatures());

		for (Catchment _c : _cats) {
			System.out.println(_c.getCode() + " :" + _c.getArea());
		}

		double _seek = 0.3;

		HydrologicalModel _model = new HydrologicalModel(_reader, _cats);
		for (WetlandWater _w : _model.getWetlands()) {
			String _code = "outflow";
			Catchment _c = _w.getSpillPoint().getCatchment();
			if (_c != null) {
				_code = _c.getCode();
			}
			_w.setWaterLevel(_w.getZones().calculateBottomElevation()
					- _seek);
		}

		CSVReader _climate = new CSVReader(prec);
		List<DateObject<Map<String, Double>>> _data = new ArrayList<DateObject<Map<String, Double>>>();

		Pattern _p = Pattern.compile("(\\d{4}).(\\d{2})");

		for (int i = 1; i < _climate.getRecords().size(); i++) {
			Map<String, String> _line = _climate.getRecords().get(i);
			Matcher _m = _p.matcher(_line.get("month"));
			if (_m.matches() == false) {
				continue;
			}

			int _year = Integer.parseInt(_m.group(1));
			int _month = Integer.parseInt(_m.group(2)) - 1;

			if (_year < 1990 || _year >= 2010)
				continue;

			System.out.println(_line.get("month"));
			
//			_model.calculateWaterTable(0.08, Double.parseDouble(_line
//					.get("wspd")), 120,
//					(Double.parseDouble(_line.get("tmax")) + Double
//							.parseDouble(_line.get("tmin"))) / 2, Double
//							.parseDouble(_line.get("srad")), Double
//							.parseDouble(_line.get("vapr")) * 100, Double
//							.parseDouble(_line.get("prec")) * 0.1 * 40, 0.003);
//
//			System.out.println(_model.getWetlands().get(0).calEt(0.08, Double.parseDouble(_line
//					.get("wspd")), 1.2,
//					(Double.parseDouble(_line.get("tmax")) + Double
//							.parseDouble(_line.get("tmin"))) / 2, Double
//							.parseDouble(_line.get("srad")), Double
//							.parseDouble(_line.get("vapr")) * 100)); 
			
			_model.calculateWaterTable(_ets[_month] * 5,
							Double.parseDouble(_line.get("prec")) * 10 / 10, 0.003);

			List<WaterTable> _wet = _model.calculateWaterFlow();

			Map<String, Double> _ww = new HashMap<String, Double>();
			for (WaterTable _w : _wet) {
				for (Catchment _c : _w.getCatchments()) {
					double _bottom = _c.getZones().calculateBottomElevation();
					_ww.put(_c.getCode(), _w.getWaterLevel() < _bottom
							- _seek ? _bottom - _seek : _w
							.getWaterLevel());
				}
			}

			Map<String, Double> _item = new HashMap<String, Double>();
			for (WetlandWater _w : _model.getWetlands()) {
				for (Catchment _c : _w.getCatchments()) {
					_item.put(_c.getCode(), _w.getWaterLevel());

					if (_c.getCode().equals("P1"))
						System.out.println("->" + _ww.get(_c.getCode()));
					_w.setWaterLevel(_ww.get(_c.getCode()));
				}
			}

			_data.add(new DateObject<Map<String, Double>>(new Date(
					_year - 1900, _month, 1), _item));
			System.out.println();
		}

		File _f = File.createTempFile("watertable_", ".dat");
		System.out.println("Output " + _f.getAbsolutePath());
		
		ObjectOutputStream _stream = new ObjectOutputStream(
				new FileOutputStream(_f));
		_stream.writeObject(_data);
		_stream.close();

		readWaterSurfaceResult(_f);
	}

	public void readWaterSurfaceResult(File file) throws Exception {
		ObjectInputStream _stream = new ObjectInputStream(new FileInputStream(
				file));

		List<DateObject<Map<String, Double>>> _data = (List<DateObject<Map<String, Double>>>) _stream
				.readObject();
		System.out.println(_data.size());

		DateFormat _format = new SimpleDateFormat("yyyy-MM-dd");
		for (DateObject<Map<String, Double>> _date : _data) {
			System.out.println(_format.format(_date.getDate()) + "\t"
					+ _date.getValue().get("P1"));
		}
	}
}
