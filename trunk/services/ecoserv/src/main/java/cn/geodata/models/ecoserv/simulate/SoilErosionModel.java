package cn.geodata.models.ecoserv.simulate;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import cn.geodata.models.raster.GeoRaster;
import cn.geodata.models.wetland.dem.TerrainModel;
import cn.geodata.models.wetland.soil.erosion.RUSLE;

public class SoilErosionModel {
	private Logger log = Logger.getAnonymousLogger();
	
	private GeoRaster slope;
	private GeoRaster flowAccum;
	private GeoRaster kFactor;
	
	public SoilErosionModel(GeoRaster dem, GeoRaster kFactor) throws Exception {
		this.kFactor = kFactor;

		TerrainModel _terrain = new TerrainModel();
		
		this.slope = _terrain.slope(dem);
		this.flowAccum = _terrain.flowAccumulation(_terrain.flowDirectionMultiple(dem));
	}
	
	public GeoRaster calculate(List<Double> prec, GeoRaster landcover) throws Exception{
		RUSLE _model = new RUSLE();
		
		_model.setFlowAccum(this.flowAccum);
		_model.setSlope(this.slope);
		_model.setkFactor(this.kFactor);

		_model.setLandcover(landcover);
		_model.setPrecipations(prec);
		
		return _model.calculate();
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
	
	public double soilLossTolerance(double v){
		if(v < 0)
			return 0;
		
		double _vv = v * 0.3 / 3;
		
		if(_vv > 1)
			return _vv;
		
		return _vv;
	}
}
