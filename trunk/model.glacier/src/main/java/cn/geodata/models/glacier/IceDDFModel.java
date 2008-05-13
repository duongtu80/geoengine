package cn.geodata.models.glacier;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.geotools.feature.FeatureCollection;

import com.vividsolutions.jts.geom.Point;

public class IceDDFModel {
	private Logger log = Logger.getLogger(IceDDFModel.class.getName());

	private String filePath;
	private InterpolateModel model;
	
	public IceDDFModel(){
		this.filePath = "/glacier/data/ddf_ice.txt";
	}
	
	public double calculate(Point point) throws IOException {
		URL _url = PrecipitationModel.class.getResource(this.filePath);
		log.info("Url:" + _url);
		log.info("Point:" + point.toText());
		
		Pattern _pattern = Pattern.compile("\\d+[,\\s]\\S+[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)");
		FeatureCollection _fs = null;
		try {
			_fs = (new TxtFeatureReader()).read("ice_ddf", _url.openStream(), _pattern);
		} catch (Exception e) {
			throw new IOException("Failed to create feature");
		}
		
		return this.model.calculate(_fs, "val", point);
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public InterpolateModel getModel() {
		return model;
	}

	public void setModel(InterpolateModel model) {
		this.model = model;
	}
}
