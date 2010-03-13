package cn.geodata.models.wetland.pollinator;

import java.awt.image.DataBuffer;
import java.awt.image.WritableRaster;
import java.io.IOException;

import org.geotools.geometry.Envelope2D;

import cn.geodata.models.raster.GeoRaster;

public class ModelPollinator {
	private GeoRaster land;

	public ModelPollinator(){
		
	}
	
	public void setLand(GeoRaster land) {
		this.land = land;
	}

	public GeoRaster calculate() throws Exception {
		WritableRaster _e = this.land.cloneRaster();

		for(int _row=0;_row < _e.getHeight();_row++){
			for(int _col=0;_col < _e.getWidth();_col++){
				Number _v = this.land.getCell(_col, _row);
				if(_v == null)
					_e.setSample(_col, _row, 0, this.land.getNodata().intValue());
				else{
					_e.setSample(_col, _row, 0, this.pollinator(_col, _row));
				}
			}
		}

		return new GeoRaster(_e, this.land.getEnvelope(), this.land.getNodata());
	}
	
	private int pollinator(int col, int row) throws IOException{
		int _upland = 0;
		int _grass = 0;
		
		for(int _row= row - 5;_row < row + 5;_row++){
			for(int _col= col -5 ;_col < col + 5;_col++){
				Number _v = this.land.getCell(_col, _row);
				if(_v != null){
					int _vv = _v.intValue();
					if(_vv != 1 && _vv != 6){
						_upland++;
						if(_vv == 4){
							_grass++;
						}
					}
				}
			}
		}
		
		if(_upland == 0)
			return 0;
		else
			return _grass * 100 / _upland;
	}
}
