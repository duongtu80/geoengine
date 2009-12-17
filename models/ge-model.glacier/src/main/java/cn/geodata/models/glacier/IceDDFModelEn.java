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

@GeoProcess(title="Ice Degree-day Factors Calculation", keywords={"ice", "idw"})
public class IceDDFModelEn implements Calculate {
	private Logger log = Logger.getLogger(IceDDFModelEn.class.getName());

	private String filePath;
	private InvertDistanceWeightModel model;
	private Long date;
	private Point point;
	private double iceDDF;
	private int maxCount;
	private double maxDistance;
	private int power;
	
	public IceDDFModelEn(){
		power = 0;
		maxCount = 0;
		maxDistance = 0;

		this.filePath = "/glacier/data/ddf_ice.txt";
	}
	
	public void calculate() throws IOException {
		URL _url = PrecipitationModel.class.getResource(this.filePath);
		log.info("Url:" + _url);
		log.info("Point:" + point.toText());
		
		Pattern _pattern = Pattern.compile("\\d+[,\\s]\\S+[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)");
		FeatureCollection _fs = null;
		try {
			_fs = (new TxtFeatureReader()).read("ice_ddf", _url.openStream(), _pattern, false);
		} catch (Exception e) {
			throw new IOException("Failed to create feature");
		}
		
		if(this.power > 0) this.model.setPower(power);
		if(this.maxCount > 0) this.model.setMaxCount(maxCount);
		if(this.maxDistance > 0) this.model.setMaxDistance(maxDistance);
		
		this.iceDDF = this.model.calculate(_fs, "val", point);
	}

	public void setModel(InvertDistanceWeightModel model) {
		this.model = model;
	}

	@GeoOutput(title="Ice Degree-day Factors")
	public double getIceDDF() {
		return iceDDF;
	}

	@GeoInput(title="Month")
	public void setDate(Long date) {
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

	@GeoInput(title="Maximum Distance")
	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}
	
	@GeoInput(title="Power")
	public void setPower(int power) {
		this.power = power;
	}

	public int getPercent() {
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
