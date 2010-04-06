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
import org.geotools.data.shapefile.ShapefileDataStore;

import cn.geodata.models.ecoserv.landcover.ConnectionPool;
import cn.geodata.models.ecoserv.utils.DayMet;
import cn.geodata.models.ecoserv.utils.DayMetReader;
import cn.geodata.models.raster.GeoRaster;
import cn.geodata.models.wetland.multiple.Catchment;
import cn.geodata.models.wetland.multiple.HydrologicalModel;
import cn.geodata.models.wetland.multiple.WaterTable;
import cn.geodata.models.wetland.multiple.WetlandWater;
import junit.framework.TestCase;

public class MultipleWaterSurfaceModelTest extends TestCase {
	//New testbed for testing the multiple water surface model using real meteorological data 12/24/09
	public void atestMultipleWaterSurface() throws Exception {
		GeoRaster _reader = new GeoRaster(new File("d:\\Tank\\Data\\ecoserv\\data\\dem\\ned10m.tif"), 0);
		List<Catchment> _cats = Catchment.loadCatchments(_reader, ConnectionPool.getPGDataStore().getFeatureSource("catchment").getFeatures());
		
		for(Catchment _c : _cats){
			System.out.println(_c.getCode() + " :" + _c.getArea());
		}
		
		HydrologicalModel _model = new HydrologicalModel(_reader, _cats);
		for(WetlandWater _w : _model.getWetlands()){
			String _code = "outflow";
			Catchment _c = _w.getSpillPoint().getCatchment();
			if(_c != null){
				_code = _c.getCode();
			}
			_w.setWaterLevel(_w.getBottomElevation());
		}
		
		DayMetReader _met = new DayMetReader();
		
		ArrayList<DayMet> _recs = _met.read(new Date(90, 0, 1), new Date(103, 0, 1), "p4", -99.098, 47.100);
		
		for(int i=0;i<_recs.size();i++){
			DayMet _day = _recs.get(i);
			
			_model.calculateWaterTable(0.08, 1, 1.2, _day.getTday(), _day.getSrad(), _day.getVpd(), _day.getPrcp(), 0.003);
			for(WetlandWater _w: _model.getWetlands()){
				System.out.print(_w.getWaterLevel() + "\t");
			}
			System.out.println();
		}
	}

	public void atestPrecalculateET() throws Exception {
		GeoRaster _reader = new GeoRaster(new File("d:\\Tank\\Data\\ecoserv\\data\\dem\\ned10m.tif"), 0);
		List<Catchment> _cats = Catchment.loadCatchments(_reader, ConnectionPool.getPGDataStore().getFeatureSource("catchment").getFeatures());
		
		for(Catchment _c : _cats){
			System.out.println(_c.getCode() + " :" + _c.getArea());
		}
		
		double _seek = 0.3;
		
		HydrologicalModel _model = new HydrologicalModel(_reader, _cats);
		for(WetlandWater _w : _model.getWetlands()){
			String _code = "outflow";
			Catchment _c = _w.getSpillPoint().getCatchment();
			if(_c != null){
				_code = _c.getCode();
			}
			_w.setWaterLevel(_w.getZones().calculateBottomElevation() - _seek);
		}

		DayMetReader _met = new DayMetReader();
		ArrayList<DayMet> _recs = _met.read(null, null, "p4", -99.098, 47.100);

		Map<Integer, List<Double>> _et = new HashMap<Integer, List<Double>>();
		for(int i=0;i<12;i++){
			_et.put(new Integer(i), new ArrayList<Double>());
		}
		
		List<DateObject<Map<String, Double>>> _data = new ArrayList<DateObject<Map<String,Double>>>();
		for(int i=0;i<_recs.size();i++){
			DayMet _day = _recs.get(i);
			if(_day.getDate().before(new Date(90, 0, 1)) || _day.getDate().after(new Date(103, 0, 1)))
				continue;
			
			double _val = _model.getWetlands().get(0).calEt(0.08, 1, 1.2, _day.getTday(), _day.getSrad(), _day.getVpd());
			_et.get(_day.getDate().getMonth()).add(_val);
		}
		
		for(int i=0;i<12;i++){
			double _val = 0;
			for(double _vv : _et.get(i)){
				_val += _vv;
			}
			System.out.println(i + "\t" + _val / _et.get(i).size());
		}
		
//		File _f = File.createTempFile("watertable_", ".dat");
//		
//		ObjectOutputStream _stream = new ObjectOutputStream(new FileOutputStream(_f));
//		_stream.writeObject(_data);
//		
//		_stream.close();
	}
	
	public void atestPrecalculateWaterSurface4Month() throws Exception {
		double[] _ets = new double[] {0.776261658, 1.380983699, 2.685167412, 5.144484068, 7.134623128, 7.349951357, 7.328081254, 6.885504999, 4.876430947, 2.789769327, 1.229707091, 0.769184209};
		
		GeoRaster _reader = new GeoRaster(new File("d:\\Tank\\Data\\ecoserv\\data\\dem\\lidar4.tif"), -1);
		List<Catchment> _cats = Catchment.loadCatchments(_reader, ConnectionPool.getPGDataStore().getFeatureSource("catchment").getFeatures());
		
		for(Catchment _c : _cats){
			System.out.println(_c.getCode() + " :" + _c.getArea());
		}
		
		double _seek = 0.3;
		
		HydrologicalModel _model = new HydrologicalModel(_reader, _cats);
		for(WetlandWater _w : _model.getWetlands()){
			String _code = "outflow";
			Catchment _c = _w.getSpillPoint().getCatchment();
			if(_c != null){
				_code = _c.getCode();
			}
			_w.setWaterLevel(_w.getZones().calculateBottomElevation() - _seek);
		}

		List<DateObject<Map<String, Double>>> _data = new ArrayList<DateObject<Map<String,Double>>>();
		List<String> _lines = FileUtils.readLines(new File("e:\\Downloads\\sres_b2_prec.txt"));
		Pattern _p = Pattern.compile("(\\d{4}).(\\d{2}).(.+)");
		
		for(int i=1;i<_lines.size();i++){
			Matcher _m = _p.matcher(_lines.get(i).trim());
			if(_m.matches() == false){
				continue;
			}
			
			int _year = Integer.parseInt(_m.group(1));
			int _month = Integer.parseInt(_m.group(2)) - 1;
			double _prec = Double.parseDouble(_m.group(3));			
			
			if(_year < 1990 || _year >= 2010)
				continue;
			
			System.out.println(_m.group());
			
			_model.calculateWaterTable(_ets[_month] * 30, _prec * 10, 0.003 * 30);
			List<WaterTable> _wet = _model.calculateWaterFlow();
			
			Map<String, Double> _ww = new HashMap<String, Double>();
			for(WaterTable _w: _wet){
				for(Catchment _c: _w.getCatchments()){
					double _bottom = _c.getZones().calculateBottomElevation();
					_ww.put(_c.getCode(), _w.getWaterLevel() < _bottom - _seek ? _bottom - _seek: _w.getWaterLevel());
				}
			}
			
			Map<String, Double> _item = new HashMap<String, Double>();
			for(WetlandWater _w: _model.getWetlands()){
				for(Catchment _c : _w.getCatchments()){
					_item.put(_c.getCode(), _w.getWaterLevel());
					
					if(_c.getCode().equals("P1"))
						System.out.println("->" + _ww.get(_c.getCode()));
					_w.setWaterLevel(_ww.get(_c.getCode()));
				}
			}
			
			_data.add(new DateObject<Map<String,Double>>(new Date(_year - 1900, _month, 1), _item));
			System.out.println();
		}
		
		File _f = File.createTempFile("watertable_", ".dat");
		ObjectOutputStream _stream = new ObjectOutputStream(new FileOutputStream(_f));
		_stream.writeObject(_data);
		_stream.close();
		
		readWaterSurfaceResult(_f);
	}
	
	public void atestPrecalculateWaterSurface() throws Exception {
		GeoRaster _reader = new GeoRaster(new File("d:\\Tank\\Data\\ecoserv\\data\\dem\\ned10m.tif"), 0);
		List<Catchment> _cats = Catchment.loadCatchments(_reader, ConnectionPool.getPGDataStore().getFeatureSource("catchment").getFeatures());
		
		for(Catchment _c : _cats){
			System.out.println(_c.getCode() + " :" + _c.getArea());
		}
		
		double _seek = 0.3;
		
		HydrologicalModel _model = new HydrologicalModel(_reader, _cats);
		for(WetlandWater _w : _model.getWetlands()){
			String _code = "outflow";
			Catchment _c = _w.getSpillPoint().getCatchment();
			if(_c != null){
				_code = _c.getCode();
			}
			_w.setWaterLevel(_w.getZones().calculateBottomElevation() - _seek);
		}

		DayMetReader _met = new DayMetReader();
		ArrayList<DayMet> _recs = _met.read(null, null, "p4", -99.098, 47.100);

		List<DateObject<Map<String, Double>>> _data = new ArrayList<DateObject<Map<String,Double>>>();
		for(int i=0;i<_recs.size();i++){
			DayMet _day = _recs.get(i);
			if(_day.getDate().before(new Date(90, 0, 1)) || _day.getDate().after(new Date(103, 0, 1)))
				continue;
			
			System.out.println("Date: " + _day.getDate());
			
			_model.calculateWaterTable(0.08, 1, 1.2, _day.getTday(), _day.getSrad(), _day.getVpd(), _day.getPrcp(), 0.003);
			List<WaterTable> _wet = _model.calculateWaterFlow();
			
			Map<String, Double> _ww = new HashMap<String, Double>();
			for(WaterTable _w: _wet){
				for(Catchment _c: _w.getCatchments()){
					double _bottom = _c.getZones().calculateBottomElevation();
					_ww.put(_c.getCode(), _w.getWaterLevel() < _bottom - _seek ? _bottom - _seek: _w.getWaterLevel());
				}
			}
			
			Map<String, Double> _item = new HashMap<String, Double>();
			for(WetlandWater _w: _model.getWetlands()){
				for(Catchment _c : _w.getCatchments()){
					_item.put(_c.getCode(), _w.getWaterLevel());
					
					if(_c.getCode().equals("P1"))
						System.out.println("->" + _ww.get(_c.getCode()));
					_w.setWaterLevel(_ww.get(_c.getCode()));
				}
			}
			
			_data.add(new DateObject<Map<String,Double>>(_day.getDate(), _item));
			System.out.println();
		}
		
		File _f = File.createTempFile("watertable_", ".dat");
		ObjectOutputStream _stream = new ObjectOutputStream(new FileOutputStream(_f));
		_stream.writeObject(_data);
		_stream.close();
		
		readWaterSurfaceResult(_f);
	}

	public void readWaterSurfaceResult(File file) throws Exception {
		ObjectInputStream _stream = new ObjectInputStream(new FileInputStream(file));
		
		List<DateObject<Map<String, Double>>> _data = (List<DateObject<Map<String, Double>>>) _stream.readObject();
		System.out.println(_data.size());
		
		DateFormat _format = new SimpleDateFormat("yyyy-MM-dd");
		for(DateObject<Map<String, Double>> _date: _data){
			System.out.println(_format.format(_date.getDate()) + "\t" + _date.getValue().get("P1"));
		}
	}

	public void testReadWaterSurfaceResult() throws Exception {
		ObjectInputStream _stream = new ObjectInputStream(new FileInputStream(new File("e:\\Downloads\\a2.dat")));
		
		List<DateObject<Map<String, Double>>> _data = (List<DateObject<Map<String, Double>>>) _stream.readObject();
		System.out.println(_data.size());
		
		DateFormat _format = new SimpleDateFormat("yyyy-MM-dd");
		for(DateObject<Map<String, Double>> _date: _data){
			System.out.println(_format.format(_date.getDate()) + "\t" + _date.getValue().get("P1"));
		}
	}
	
	public void atestCatchment() throws Exception {
		GeoRaster _reader = new GeoRaster(new File("d:\\Tank\\Data\\ecoserv\\data\\dem\\ned10m.tif"), 0);
		List<Catchment> _cats = Catchment.loadCatchments(_reader, ConnectionPool.getPGDataStore().getFeatureSource("catchment").getFeatures());
		
		for(Catchment _c : _cats){
			System.out.println(_c.getCode() + " :" + _c.getArea() + " " + _c.getZones().calculateBottomElevation());
		}
		
		HydrologicalModel _model = new HydrologicalModel(_reader, _cats);
		for(WetlandWater _w : _model.getWetlands()){
			String _code = "outflow";
			Catchment _c = _w.getSpillPoint().getCatchment();
			if(_c != null){
				_code = _c.getCode();
			}
			System.out.println(_w.getCatchments().get(0).getCode() + "->" + _code + " | " + _w.getSpillPoint().getElevation() + "|" + _w.getZones().calculateBottomElevation());
		}
	}
	
	public void atestWaterTable() throws Exception {
		GeoRaster _reader = new GeoRaster(new File("/home/mfeng/mfeng/data/ecoserv/data/dem/ned10m.tif"), 0);
		List<Catchment> _cats = Catchment.loadCatchments(_reader, ConnectionPool.getPGDataStore().getFeatureSource("catchment").getFeatures());
		
		for(Catchment _c : _cats){
			System.out.println(_c.getCode() + " :" + _c.getArea() + " " + _c.getZones().calculateBottomElevation());
		}
		
		HydrologicalModel _model = new HydrologicalModel(_reader, _cats);
		for(WetlandWater _w : _model.getWetlands()){
			_w.setWaterLevel(560.7);
		}
	}
}
