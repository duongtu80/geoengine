package cn.geodata.models.wetland.soil.erosion;

import java.awt.image.DataBuffer;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.geotools.geometry.Envelope2D;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.geometry.Envelope;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import cn.geodata.models.csv.CSVReader;
import cn.geodata.models.raster.GeoRaster;

public class RUSLE {
	private Logger log = Logger.getAnonymousLogger();
	
	private GeoRaster dem;
	private GeoRaster slope;
	private GeoRaster flowAccum;
	private GeoRaster kFactor;
	private GeoRaster landcover;
	private List<Double> precipations;
	
	public GeoRaster getSlope() {
		return slope;
	}
	public void setSlope(GeoRaster slope) {
		this.slope = slope;
	}
	public GeoRaster getFlowAccum() {
		return flowAccum;
	}
	public void setFlowAccum(GeoRaster flowAccum) {
		this.flowAccum = flowAccum;
	}
	public GeoRaster getkFactor() {
		return kFactor;
	}
	public void setkFactor(GeoRaster kFactor) {
		this.kFactor = kFactor;
	}
	public GeoRaster getLandcover() {
		return landcover;
	}
	public void setLandcover(GeoRaster landcover) {
		this.landcover = landcover;
	}
	public List<Double> getPrecipations() {
		return precipations;
	}
	public void setPrecipations(List<Double> precipations) {
		this.precipations = precipations;
	}
	
	public GeoRaster calculate() throws Exception {
		this.dem = this.slope;
		
		WritableRaster _e = this.dem.cloneRaster();
		Envelope2D _env = this.dem.getEnvelope();

		double _minX = _env.getMinX() + this.dem.getCellSizeX() / 2;
		double _maxY = _env.getMaxY() - this.dem.getCellSizeY() / 2;

		double _cellX = this.dem.getCellSizeX();
		double _cellY = this.dem.getCellSizeY();

		double _r = this.factorR();
		GeoRaster _c = this.factorC();
//		GeoRaster _l = this.calculateL();
		GeoRaster _s = this.factorLS();
		GeoRaster _k = this.factorK();

		double _y = _maxY;
		for (int _row = 0; _row < _e.getHeight(); _row++) {
			double _x = _minX;
			for (int _col = 0; _col < _e.getWidth(); _col++) {
//				Number _vr = _r.getLocationValue(_x, _y);
				Number _vr = _r; //_r.getLocationValue(_x, _y);
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
					_e.setSample(_col, _row, 0, this.dem.getNodata().doubleValue());
				}

				_x += _cellX;
			}
			_y -= _cellY;
		}

		return new GeoRaster(_e, _env, this.dem.getNodata());
	}

	/**
	 * Calculate factor-K
	 * 
	 * @return
	 */
	public GeoRaster factorK() {
		return this.kFactor;
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
		Envelope _env = this.pixelEnvelope(this.dem);

		double _cellX = _env.getSpan(0)/ this.dem.getColNum();
		double _cellY = _env.getSpan(1)/ this.dem.getRowNum();
		
		double _cellA = (_cellX + _cellY)/2;
		
		for (int _row = 0; _row < _r.getHeight(); _row++) {
			for (int _col = 0; _col < _r.getWidth(); _col++) {
				Number _sn = this.slope.getCell(_col, _row);
				Number _an = this.flowAccum.getCell(_col, _row); 
				
				if(_sn == null || _an == null){
					_r.setSample(_col, _row, 0, this.dem.getNodata().doubleValue());
				}
				else{
					double _val = Math.pow(_an.floatValue() * _cellA / 22.1, 0.4) * Math.pow(Math.sin(_sn.floatValue() * 0.01745) / 0.09, 1.4) * 1.4;
					_r.setSample(_col, _row, 0, _val);
				}
			}
		}

		return new GeoRaster(_r, this.dem.getEnvelope(), this.dem.getNodata());
	}
	
	/**
	 * Generate extent of the raster under UTM-14 projection
	 * 
	 * @param raster
	 * @return
	 * @throws Exception
	 */
	private org.opengis.geometry.Envelope pixelEnvelope(GeoRaster raster) throws Exception {
		CoordinateReferenceSystem _crs = raster.getEnvelope().getCoordinateReferenceSystem();
		if(_crs == null || !(_crs instanceof DefaultGeographicCRS))
			return raster.getEnvelope();
		else
			return CRS.transform(CRS.findMathTransform(raster.getEnvelope().getCoordinateReferenceSystem(), CRS.decode("EPSG:32614", true)), raster.getEnvelope());
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
				Number _val = this.landcover.getLocationValue(this.dem.getX(_col), this.dem.getY(_row));
				if(_val != null){// && this.types.containsKey(_val.intValue())){
					_r.setSample(_col, _row, 0, _map.get(_val.intValue()));
				}
				else
					_r.setSample(_col, _row, 0, this.dem.getNodata().doubleValue());
			}
		}

		return new GeoRaster(_r, this.dem.getEnvelope(), this.dem.getNodata());
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
	public double factorR() throws IOException, ParseException {
		this.log.entering(this.getClass().getCanonicalName(), "Calculate factor-R");

		List<Double> _prec = this.precipations;
		
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
