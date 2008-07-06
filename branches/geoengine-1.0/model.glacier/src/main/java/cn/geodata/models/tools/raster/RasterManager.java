package cn.geodata.models.tools.raster;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.Envelope2D;
import org.geotools.geometry.jts.JTS;

import cn.geodata.models.tools.Utilities;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Polygon;

public class RasterManager {
	private static Logger log = Logger.getAnonymousLogger();
	private File basePath;
	private List<RasterInfo> rasters;
	private int nodata;
	private RasterInfo lastKey;
	
	public RasterManager(File basePath, int nodata) throws IOException{
		this.basePath = basePath;
		this.nodata = nodata;
		
		this.lastKey = null;
		this.rasters = new ArrayList<RasterInfo>();
		for(File _f : (Collection<File>)FileUtils.listFiles(basePath, new String[]{"tif"}, true)){
			String _key = _f.getName();
			log.info("load " + _f.getAbsolutePath());
			this.rasters.add(new RasterInfo(_f, this.nodata));
		}
	}
	
	public File getBasePath() {
		return basePath;
	}

	public List<RasterInfo> getRasterList() {
		return this.rasters;
	}
	
	public List<RasterInfo> findDatasets(Polygon poly) {
		List<RasterInfo> _list = new ArrayList<RasterInfo>();
		
		Envelope2D _ext = Utilities.getEnvelope(poly);
		for(RasterInfo _raster : this.rasters){
			if(_raster.getEnvelope().intersects(_ext)){
				_list.add(_raster);
			}
		}
		
		return _list;
	}
	
	public int getLocationValue(List<RasterInfo> keys, DirectPosition2D pt){
		return this.getLocationValue(keys, pt.getX(), pt.getY());
	}

	public int getLocationValue(List<RasterInfo> keys, double x, double y){
		if(this.lastKey != null){
			int _val = this.lastKey.getLocationValue(x, y);
			if(_val != this.nodata){
				return _val;
			}
		}
		
		for(RasterInfo _key : keys){
			if(_key.equals(this.lastKey) == false){
				int _val = _key.getLocationValue(x, y);
				if(_val != this.nodata){
					this.lastKey = _key;
					return _val;
				}
			}
		}
		
		return this.nodata;
	}

	public int getLocationValue(double x, double y){
		return this.getLocationValue(this.getRasterList(), x, y);
	}
}
