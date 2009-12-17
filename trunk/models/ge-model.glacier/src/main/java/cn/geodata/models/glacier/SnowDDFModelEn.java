package cn.geodata.models.glacier;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.geotools.feature.FeatureCollection;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

import com.vividsolutions.jts.geom.Point;

@GeoProcess(title="Snow DDF Calculation", keywords={"snow", "idw"})
public class SnowDDFModelEn implements Calculate {
	private Logger log = Logger.getLogger(SnowDDFModelEn.class.getName());

	private InvertDistanceWeightModel model;
	private Date date;
	private Point point;
	private double snowDDF;
	private int maxCount;
	private double maxDistance;
	private int power;
	private String filePath;
	
	public SnowDDFModelEn(){
		power = 0;
		maxCount = 0;
		maxDistance = 0;

		this.filePath = "/glacier/data/ddf_snow.txt";
	}
	
	public void setModel(InvertDistanceWeightModel model) {
		this.model = model;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void calculate() throws IOException {
		URL _url = PrecipitationModel.class.getResource(this.filePath);
		log.info("Url:" + _url);
		log.info("Point:" + point.toText());
		
		Pattern _pattern = Pattern.compile("\\d+[,\\s]\\S+[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)");
		FeatureCollection _fs = null;
		try {
			_fs = (new TxtFeatureReader()).read("snow_ddf", _url.openStream(), _pattern, false);
		} catch (Exception e) {
			throw new IOException("Failed to create feature");
		}
		
		if(this.power > 0) this.model.setPower(power);
		if(this.maxCount > 0) this.model.setMaxCount(maxCount);
		if(this.maxDistance > 0) this.model.setMaxDistance(maxDistance);
		
		this.snowDDF = this.model.calculate(_fs, "val", point);
	}

	@GeoOutput(title="Snow DDF")
	public double getSnowDDF() {
		return snowDDF;
	}

	@GeoInput(title="Month")
	public void setDate(Date date) {
		this.date = date;
	}

	@GeoInput(title="Target Location")
	public void setPoint(Point point) {
		this.point = point;
	}

	@GeoInput(title="Maximum Observation Number")
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	@GeoInput(title="Maximum Searching Distance")
	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}
	
	@GeoInput(title="Power")
	public void setPower(int power) {
		this.power = power;
	}

	public int getPercent() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}
