package cn.geodata.models.glacier;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.geotools.feature.FeatureCollection;

import com.vividsolutions.jts.geom.Point;

public class TemperatureModel {
	private Logger log = Logger.getLogger(TemperatureModel.class.getName());
	
	private InterpolateModel model;
	private String filePath;

	public InterpolateModel getModel() {
		return model;
	}

	public void setModel(InterpolateModel model) {
		this.model = model;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public TemperatureModel(){
		this.filePath = "/glacier/data/temperature";
	}
	
	public double calculate(Date date, Point point) throws Exception{
		String _fileName = String.format("t%04d%02d.txt", date.getYear() + 1900, date.getMonth() + 1);
		log.info("File name:" + _fileName);
		
		URL _url = TemperatureModel.class.getResource(this.filePath + "/" + _fileName);
		log.info("Url:" + _url);
		log.info("Point:" + point.toText());
		
		Pattern _pattern = Pattern.compile("\\d+[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)");
		FeatureCollection _fs = null;
		try {
			_fs = (new TxtFeatureReader()).read("temperature", _url.openStream(), _pattern);
		} catch (Exception e) {
			throw new IOException("Failed to create feature");
		}
		
		return this.model.calculate(_fs, "val", point);
	}
}
