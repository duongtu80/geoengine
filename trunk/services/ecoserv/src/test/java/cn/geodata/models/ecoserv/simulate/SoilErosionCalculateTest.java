package cn.geodata.models.ecoserv.simulate;

import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.geotools.coverage.grid.GridCoverageFactory;
import org.geotools.geometry.Envelope2D;

import cn.geodata.models.csv.CSVReader;
import cn.geodata.models.raster.GeoRaster;
import junit.framework.TestCase;

public class SoilErosionCalculateTest extends TestCase {
	private Number nodata;
	private GeoRaster dem;
	
	@Override
	protected void setUp() throws Exception {
		this.nodata = new Float(-9999f);
		this.dem = new GeoRaster(new File("d:\\Tank\\Data\\ecoserv\\data\\dem\\lidar_c.tif"), this.nodata);
		
		super.setUp();
	}

	public void testCalculateRFactor() throws Exception {
		GeoRaster _dem = new GeoRaster(new File("d:\\Tank\\Data\\ecoserv\\data\\dem\\lidar4.tif"), -1);
		CSVReader _climate = new CSVReader(new File("d:\\Tank\\Data\\ecoserv\\data\\ipcc\\a2.csv"));
		
		for(Map<String, String> _line : _climate.getRecords()){
//			GeoRaster _rr = new GeoRaster(new File)
			double _e = 0;
			
			double _r = 3786.6 + 1.5679 * Double.parseDouble(_line.get("prec")) - 1.9809 * _e;
		}
	}
	
	public void calculate(File outFile) throws IOException{
		WritableRaster _e = null;
		Envelope2D _env = null;
		
		double _minX = 0;
		double _minY = 0;
		
		double _cellX = 0;
		double _cellY = 0;
		
		GeoRaster _r = this.calculateR();
		GeoRaster _c = this.calculateC();
		GeoRaster _l = this.calculateL();
		GeoRaster _s = this.calculateS();
		GeoRaster _k = this.calculateK();
		
		double _y = _minY;
		for(int _row=0;_row<_e.getHeight();_row++){
			double _x = _minX;
			for(int _col=0;_col<_e.getWidth();_col++){
				Number _vr = _r.getLocationValue(_x, _y);
				Number _vc = _c.getLocationValue(_x, _y);
				Number _vl = _l.getLocationValue(_x, _y);
				Number _vs = _s.getLocationValue(_x, _y);
				Number _vk = _k.getLocationValue(_x, _y);
				
				if(_vr != null && _vc != null && _vl != null && _vs != null & _vk != null){
					float _val = _vr.floatValue() * _vc.floatValue() * _vl.floatValue() * _vs.floatValue() * _vk.floatValue();
					_e.setSample(_col, _row, 0, _val);
				}
				else{
					_e.setSample(_col, _row, 0, this.nodata.floatValue());
				}
				
				_x += _cellX;
			}
			_y += _cellY;
		}
		
		GeoRaster.writeTiff(outFile, _env, _e);
	}

	private GeoRaster calculateK() {
		
		
		return null;
	}

	private GeoRaster calculateS() {
		// TODO Auto-generated method stub
		return null;
	}

	private GeoRaster calculateL() {
		// TODO Auto-generated method stub
		return null;
	}

	private GeoRaster calculateC() {
		// TODO Auto-generated method stub
		return null;
	}

	private GeoRaster calculateR() {
		// TODO Auto-generated method stub
		return null;
	}
}
