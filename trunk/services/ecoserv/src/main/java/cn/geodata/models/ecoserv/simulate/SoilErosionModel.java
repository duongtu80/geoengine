package cn.geodata.models.ecoserv.simulate;

import java.io.IOException;
import java.util.logging.Logger;

import cn.geodata.models.ecoserv.landcover.LandCover;
import cn.geodata.models.raster.GeoRaster;

public class SoilErosionModel {
	private Logger log = Logger.getAnonymousLogger();
	
	private double r;
	private GeoRaster kFactor;
	private GeoRaster lsFactor;
	private GeoRaster cFactor;
	private GeoRaster pFactor;
	
	public SoilErosionModel() {
	}
	
	public void init(double r, GeoRaster kFactor,
			GeoRaster lsFactor, GeoRaster cFactor, GeoRaster pFactor) {
		this.r = r;
		this.kFactor = kFactor;
		this.lsFactor = lsFactor;
		this.cFactor = cFactor;
		this.pFactor = pFactor;
	}
	
	public double calculate(LandCover landcover) throws IOException{
		double _soil = 0;
		long _count = 0;
		
		double _y = landcover.getExtent().getMaxY() - landcover.getCellY() / 2;
		for(int _row=0;_row < landcover.getRowCount();_row++){
			double _x = landcover.getExtent().getMinX() + landcover.getCellX() / 2;
			for(int _col=0;_col < landcover.getColCount();_col++){
				double _r = this.r;
				
				Number _k = this.kFactor.getLocationValue(_x, _y);
				Number _ls = this.lsFactor.getLocationValue(_x, _y);
				Number _c = this.cFactor.getLocationValue(_x, _y);
				Number _p = this.pFactor.getLocationValue(_x, _y);
				
				if(_k == null || _ls == null || _c == null || _p == null){
					continue;
				}
				
				_soil += _r * _k.doubleValue() * _ls.doubleValue() * _c.doubleValue() * _p.doubleValue();
				_count ++;
				
				_x += landcover.getCellX();
			}
			_y -= landcover.getCellY();
		}
		
		if(_count > 0)
			return _soil / _count;
		
		return 0;
	}
}
