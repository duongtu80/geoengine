package cn.geodata.models.wetland.soil.erosion;

import java.awt.Point;
import java.awt.image.DataBuffer;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;

import org.geotools.data.ows.CRSEnvelope;
import org.geotools.geometry.Envelope2D;
import org.geotools.geometry.GeneralEnvelope;
import org.geotools.referencing.CRS;
import org.opengis.geometry.Envelope;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.TransformException;

import com.google.common.collect.MapMaker;

import cn.geodata.models.csv.CSVReader;
import cn.geodata.models.raster.GeoRaster;
import cn.geodata.models.wetland.dem.TerrainModel;

public class ModelRUSLE {
	private Logger log = Logger.getLogger(ModelRUSLE.class.getCanonicalName());
	
	private Number nodata;
	private GeoRaster dem;
	private GeoRaster prec;
	private GeoRaster land;
	private GeoRaster k_factor;
	private TerrainModel terra;
	private File scenarioPath;
	private int year;
	private Map<Integer, Integer> types;

	public ModelRUSLE() throws Exception {
		this.nodata = new Float(-9999f);
		this.year = 2000;
		this.dem = new GeoRaster(new File(
				"d:\\Tank\\Data\\ecoserv\\data\\dem\\lidar_c.tif"), this.nodata);
//		this.land = new GeoRaster(new File("o:\\tmp\\rusle\\original.tif"), 0);
		this.land = new GeoRaster(new File("D:\\Tank\\Save\\Java\\geoengine\\src\\3.0\\trunk\\services\\ecoserv\\src\\main\\resources\\data\\north_dakota\\region.tif"), 0);
		this.k_factor = new GeoRaster(new File("o:\\tmp\\rusle\\test2\\kfcacthwgs84.tif"), -340282346638528860000000000000000000000.0f);
		this.scenarioPath = new File("d:\\Tank\\Data\\ecoserv\\data\\ipcc");
		this.terra = new TerrainModel();
		
		this.types = new HashMap<Integer, Integer>();
		
		this.types.put(11, 1);
		this.types.put(12, 1);
			
		this.types.put(21, 2);
		this.types.put(22, 2);
		this.types.put(23, 2);
		this.types.put(24, 2);
		this.types.put(31, 2);
		this.types.put(32, 2);
			
		this.types.put(41, 3);
		this.types.put(42, 3);
		this.types.put(43, 3);
		this.types.put(51, 3);
		this.types.put(52, 3);
			
		this.types.put(71, 4);
		this.types.put(72, 4);
		this.types.put(73, 4);
		this.types.put(74, 4);
			
		this.types.put(81, 5);
		this.types.put(82, 5);
			
		this.types.put(90, 6);
		this.types.put(91, 6);
		this.types.put(92, 6);
		this.types.put(93, 6);
		this.types.put(94, 6);
		this.types.put(95, 6);
		this.types.put(96, 6);
		this.types.put(97, 6);
		this.types.put(98, 6);
		this.types.put(99, 6);

	}

	public GeoRaster calculate() throws Exception {
		WritableRaster _e = this.dem.cloneRaster(DataBuffer.TYPE_FLOAT);
		Envelope2D _env = this.dem.getEnvelope();

		double _minX = _env.getMinX() + this.dem.getCellSizeX() / 2;
		double _maxY = _env.getMaxY() - this.dem.getCellSizeY() / 2;

		double _cellX = this.dem.getCellSizeX();
		double _cellY = this.dem.getCellSizeY();

//		GeoRaster _r = this.calculateR();
		GeoRaster _c = this.factorC();
//		GeoRaster _l = this.calculateL();
		GeoRaster _s = this.factorLS();
		GeoRaster _k = this.factorK();

		double _y = _maxY;
		for (int _row = 0; _row < _e.getHeight(); _row++) {
			double _x = _minX;
			for (int _col = 0; _col < _e.getWidth(); _col++) {
//				Number _vr = _r.getLocationValue(_x, _y);
				Number _vr = 70; //_r.getLocationValue(_x, _y);
				Number _vc = _c.getLocationValue(_x, _y);
//				Number _vl = _l.getLocationValue(_x, _y);
				Number _vs = _s.getLocationValue(_x, _y);
				Number _vk = _k.getLocationValue(_x, _y);

				if (_vr != null && _vc != null
//						&& _vl != null
						&& _vs != null
						& _vk != null) {
					float _val = _vr.floatValue() 
							* _vc.floatValue()
//							* _vl.floatValue() 
							* _vs.floatValue()
							* _vk.floatValue();
					
					if(Double.isInfinite(_val))
						System.out.println(_vr + "," + _vc+ "," +_vs+ "," +_vk);
//					System.out.println(_val);
					_e.setSample(_col, _row, 0, _val);
				} else {
					_e.setSample(_col, _row, 0, this.nodata.floatValue());
				}

				_x += _cellX;
			}
			_y -= _cellY;
		}

		return new GeoRaster(_e, _env, this.nodata);
	}

	/**
	 * Calculate factor-K
	 * 
	 * @return
	 */
	public GeoRaster factorK() {
		return this.k_factor;
	}

	/**
	 * Calculate factor-LS
	 * 
	 * @return
	 * @throws Exception
	 */
	public GeoRaster factorLS() throws Exception {
		this.log.entering(this.getClass().getCanonicalName(), "calculate factor-LS");

		WritableRaster _r = this.dem.cloneRaster(DataBuffer.TYPE_FLOAT);
		
		GeoRaster _slope = this.terra.slope(this.dem);
		GeoRaster _flow = this.terra.flowDirectionMultiple(this.dem);
		GeoRaster _accum = this.terra.flowAccumulation(_flow);

		Envelope _env = this.terra.pixelEnvelope(this.dem);

		double _cellX = _env.getSpan(0)/ this.dem.getColNum();
		double _cellY = _env.getSpan(1)/ this.dem.getRowNum();
		
		double _cellA = (_cellX + _cellY)/2;
		
		for (int _row = 0; _row < _r.getHeight(); _row++) {
			for (int _col = 0; _col < _r.getWidth(); _col++) {
				Number _sn = _slope.getCell(_col, _row);
				Number _an = _accum.getCell(_col, _row); 
				
				if(_sn == null || _an == null){
					_r.setSample(_col, _row, 0, this.nodata.floatValue());
				}
				else{
					double _val = Math.pow(_an.floatValue() * _cellA / 22.1, 0.4) * Math.pow(Math.sin(_sn.floatValue() * 0.01745) / 0.09, 1.4) * 1.4;
					_r.setSample(_col, _row, 0, _val);
				}
			}
		}

		return new GeoRaster(_r, this.dem.getEnvelope(), this.nodata);
	}

	/**
	 * Calculate C-factor
	 * 
	 * @return
	 * @throws Exception
	 */
	public GeoRaster factorC() throws Exception {
		this.log.entering(this.getClass().getCanonicalName(), "Calculate factor-C");

		Map<Integer, Double> _map = new HashMap<Integer, Double>();
		_map.put(1, 0.0);
		_map.put(2, 0.0);
		_map.put(3, 0.004);
		_map.put(4, 0.03);
		_map.put(5, 0.2);
		_map.put(6, 0.0);
		_map.put(7, 0.02);
		
		WritableRaster _r = this.dem.cloneRaster(DataBuffer.TYPE_FLOAT);

		for (int _row = 0; _row < _r.getHeight(); _row++) {
			for (int _col = 0; _col < _r.getWidth(); _col++) {
				Number _val = this.land.getLocationValue(this.dem.getX(_col), this.dem.getY(_row));
				if(_val != null){// && this.types.containsKey(_val.intValue())){
					_r.setSample(_col, _row, 0, _map.get(this.types.get(_val.intValue())));
				}
				else
					_r.setSample(_col, _row, 0, this.nodata.floatValue());
			}
		}

		return new GeoRaster(_r, this.dem.getEnvelope(), this.nodata);
	}

	/**
	 * Calculate factor-R
	 * 
	 * @param scenario
	 * @param year
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public double factorR(String scenario, int year) throws IOException, ParseException {
		this.log.entering(this.getClass().getCanonicalName(), "Calculate factor-R");

		List<Double> _prec = this.precipitationAvgYearly(scenario, year);
		
		double _f = this.factorF(_prec);
		double _val = 0;
		if(_f < 55){
			_val = 0.7397 * Math.pow(_f, 1.847);
		}
		else{
			_val = 95.77 - 6.081 + 0.04770 * Math.pow(_f, 2);
		}

		return _val;
	}
		
	/**
	 * @param scenario
	 * @param year
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public List<Double> precipitationAvgYearly(String scenario, int year) throws ParseException, IOException {
		CSVReader _rd = new CSVReader(new File(this.scenarioPath, scenario.toLowerCase() + ".csv"));

		List<Double> _prec = new ArrayList<Double>();
		
		SimpleDateFormat _format = new SimpleDateFormat("yyyy-MM");
		for (Map<String, String> _d : _rd.getRecords()) {
			Date _date = _format.parse(_d.get("month"));

			if (_date.getYear() + 1900 == year) {
				_prec.add(Double.parseDouble(_d.get("prec")));
			}
		}

		return _prec;
	}

	public double sumList(List<Double> prec){
		double _prec = 0;
		for(double _p: prec){
			_prec += _p;
		}
		
		return _prec;
	}

	public double avgList(List<Double> prec){
		if( prec.size() == 0)
			return 0;
		
		double _prec = 0;
		for(double _p: prec){
			_prec += _p;
		}
		
		return _prec / prec.size();
	}

	/**
	 * Calculate factor-F
	 * 
	 * @param prec
	 * @return
	 */
	public double factorF(List<Double> prec){
		double _f = 0;
		double _c = 0;
		for(double _p : prec){
			_f += _p * _p;
			_c += _p;
		}
		
		return _f / (_c / prec.size());
	}
}
