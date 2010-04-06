package cn.geodata.models.ecoserv.simulate;

import java.io.IOException;
import java.util.logging.Logger;

import cn.geodata.models.raster.GeoRaster;
import cn.geodata.models.wetland.pollinator.ModelPollinator;

public class PollinatorModel {
	private Logger log = Logger.getAnonymousLogger();
	
	public PollinatorModel() throws Exception {
	}
	
	public double calculate(GeoRaster landcover) throws Exception{
		ModelPollinator _model = new ModelPollinator();
		_model.setLand(landcover);
		
		GeoRaster _r = _model.calculate();
		
		double _sum = 0;
		int _count = 0;
		for(int _row=0;_row<_r.getRowNum();_row++){
			for(int _col=0;_col<_r.getColNum();_col++){
				Number _vv = _r.getCell(_col, _row);
				if(_vv != null){
					_sum += _vv.doubleValue() / 100.0;
					_count ++;
				}
			}
		}
		
		if(_count == 0)
			return 0;
		else
			return _sum / _count;
	}
	
	public double averageRaster(GeoRaster raster) throws IOException{
		double _val = 0;
		int _count = 0;
		
		for(int _row=0;_row<raster.getRowNum();_row++){
			for(int _col=0;_col<raster.getColNum();_col++){
				Number _vv = raster.getCell(_col, _row);
				if(_vv != null){
					_val += _vv.doubleValue();
					_count ++;
				}
			}
		}
		
		if(_count > 0)
			return _val / _count;
		else
			return 0;
	}
}
