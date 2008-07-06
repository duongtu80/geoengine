package cn.geodata.models.glacier;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.geotools.feature.FeatureCollection;

import com.vividsolutions.jts.geom.Point;

public class PrecipitationModel {
	private Logger log = Logger.getLogger(PrecipitationModel.class.getName());
	
	private InvertDistanceWeightModel model;
	
	public InvertDistanceWeightModel getModel() {
		return model;
	}

	public void setModel(InvertDistanceWeightModel model) {
		this.model = model;
	}

	public PrecipitationModel(){
	}
	
	public double calculate(Date date, Point point) throws Exception{
		String _fileName = String.format("cp%04d%02d.txt", date.getYear() + 1900, date.getMonth() + 1);
		log.info("File name:" + _fileName);
		
		File _tmp = File.createTempFile("precipitation", ".zip");
		File _file = new File(_tmp.getParentFile(), "precipitation.zip");
		_tmp.delete();
		
		if(_file.exists() == false || _file.length() > 0){
			IOUtils.copy(PrecipitationModel.class.getResourceAsStream("/glacier/data/precipitation.zip"), FileUtils.openOutputStream(_file));
		}
		
		ZipFile _zip = new ZipFile(_file);
		try{
			Pattern _pattern = Pattern.compile("\\d+[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)");
			FeatureCollection _fs = null;
			try {
				_fs = (new TxtFeatureReader()).read("precipitation", _zip.getInputStream(_zip.getEntry(_fileName)), _pattern);
			} catch (Exception e) {
				throw new IOException("没有找到该日期的站点数据");
			}
			
			return this.model.calculate(_fs, "val", point);
		}
		finally{
			if(_zip != null){
				_zip.close();
			}
		}
	}
}
