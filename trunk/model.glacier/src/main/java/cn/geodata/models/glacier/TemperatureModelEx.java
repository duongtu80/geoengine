package cn.geodata.models.glacier;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;

import cn.geodata.models.tools.raster.RasterManager;

import com.vividsolutions.jts.geom.Point;

public class TemperatureModelEx {
	private Logger log = Logger.getLogger(TemperatureModelEx.class.getName());
	
	private InterpolateModel idwModel;
	private RasterManager demModel;
	private double grads;
	private double stand;

	public InterpolateModel getIdwModel() {
		return idwModel;
	}

	public void setIdwModel(InterpolateModel idwModel) {
		this.idwModel = idwModel;
	}

	public TemperatureModelEx(){
	}
	
	public double calculate(Date date, Point point) throws Exception{
		double _elevation = this.demModel.getLocationValue(point.getX(), point.getY());
		if(_elevation <= 0){
			log.warning("Incorrect elevation at location " + point.toText());
			return 0;
		}
		
		String _fileName = String.format("t%04d%02d.txt", date.getYear() + 1900, date.getMonth() + 1);
		log.info("File name:" + _fileName);
		
		File _tmp = File.createTempFile("temperature", ".zip");
		File _file = new File(_tmp.getParentFile(), "temperature.zip");
		_tmp.delete();
		
		if(_file.exists() == false || _file.length() > 0){
			IOUtils.copy(PrecipitationModel.class.getResourceAsStream("/glacier/data/temperature.zip"), FileUtils.openOutputStream(_file));
		}
		
		ZipFile _zip = new ZipFile(_file);
		try{
			Pattern _pattern = Pattern.compile("\\d+[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)");
			
			FeatureCollection _fs = null;
			try {
				_fs = (new TxtFeatureReader()).read("temperature", _zip.getInputStream(_zip.getEntry(_fileName)), _pattern);
			} catch (Exception e) {
				throw new IOException("没有找到该日期的站点数据");
			}

			FeatureCollection _f2 = null;
			for(Feature _f : (Feature[])_fs.toArray(new Feature[0])){
				Point _pt = (Point) _f.getDefaultGeometry();
				double _elv = this.demModel.getLocationValue(_pt.getX(), _pt.getY());
				
				if(_elv > 0){
					double _val = ((Double)_f.getAttribute("val"));
					_f.setAttribute("val", _val + (_elv - this.stand) * this.grads);
					
					_f2.add(_f);
				}
			}

			return this.idwModel.calculate(_fs, "val", point) - (_elevation - this.stand) * this.grads;
		}
		finally{
			if(_zip != null){
				_zip.close();
			}
		}
	}

	public RasterManager getDemModel() {
		return demModel;
	}

	public void setDemModel(RasterManager demModel) {
		this.demModel = demModel;
	}

	public double getGrads() {
		return grads;
	}

	public void setGrads(double grads) {
		this.grads = grads;
	}

	public double getStand() {
		return stand;
	}

	public void setStand(double stand) {
		this.stand = stand;
	}
}
