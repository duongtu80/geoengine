package cn.geodata.models.landfire;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import cn.geodata.tools.RasterInfo;

import com.vividsolutions.jts.geom.Point;

public abstract class AbstractRasterSampleModel extends AbstractSampleModel {
	private RasterInfo cacheRaster;
	private String cacheId;

	@Override
	public Double[] getSample(String id, Point pt) throws IOException {
		if(cacheId != null && cacheId.equals(id)){
		}
		else{
			File _file = this.getImageFile(id);
			if(_file.exists() == false){
				throw new FileNotFoundException(_file.getAbsolutePath());
			}
			
			this.cacheRaster = new RasterInfo(_file, 0);
		}
		
		int _col = this.cacheRaster.getCol(pt.getX());
		int _row = this.cacheRaster.getRow(pt.getY());
		
		if(_col < 0 || _col >= this.cacheRaster.getImage().getWidth() || _row < 0 || _row >= this.cacheRaster.getImage().getHeight()){
			log.warning("Out of the image:" + _col + "," + _row);
			return new Double[]{Double.NaN};
		}
		
		return this.evaluateValue(this.cacheRaster, _col, _row);
	}

	protected Double[] evaluateValue(RasterInfo raster, int col, int row) {
		int _minC = col - 1;
		int _maxC = col + 1;
		
		if(_minC < 0){
			_minC = 0;
		}
		if(_maxC > raster.getImage().getWidth() - 1){
			_maxC = raster.getImage().getWidth() - 1;
		}
		
		int _minR = row - 1;
		int _maxR = row + 1;
		
		if(_minR < 0){
			_minR = 0;
		}
		if(_maxR > raster.getImage().getHeight() - 1){
			_maxR = raster.getImage().getHeight() - 1;
		}
		
		int _total = 0;
		int _count = 0;
		for(int _row=_minR;_row <= _maxR;_row++){
			for(int _col=_minC;_col <=_maxC;_col++){
				int _val = raster.getCell(_col, _row);
				if(_val >= 0){
					_total += _val;
					_count ++;
				}
			}
		}
		
		if(_count == 0){
			log.warning("Not found avalible cell");
			return new Double[]{Double.NaN};
		}
		return new Double[]{_total / (double)_count};
	}

	public abstract File getImageFile(String id);
}
