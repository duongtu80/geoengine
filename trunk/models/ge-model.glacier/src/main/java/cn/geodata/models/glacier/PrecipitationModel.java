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

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

import com.vividsolutions.jts.geom.Point;

@GeoProcess(title="降水插值模型", keywords={"precipitation", "idw"})
public class PrecipitationModel implements Calculate {
	private Logger log = Logger.getLogger(PrecipitationModel.class.getName());
	
	private InvertDistanceWeightModel model;
	private Date date;
	private Point point;
	private double precipitation;
	private double elevation;
	private int maxCount;
	private double maxDistance;
	private int power;
	
	public PrecipitationModel(){
		power = 0;
		maxCount = 0;
		maxDistance = 0;
	}
	
	public InvertDistanceWeightModel getModel() {
		return model;
	}

	public void setModel(InvertDistanceWeightModel model) {
		this.model = model;
	}

	public void calculate() throws Exception{
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
			Pattern _pattern = Pattern.compile("\\d+[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)");
			FeatureCollection _fs = null;
			try {
				_fs = (new TxtFeatureReader()).read("precipitation", _zip.getInputStream(_zip.getEntry(_fileName)), _pattern, true);
			} catch (Exception e) {
				throw new IOException("没有找到该日期的站点数据");
			}
			
			if(this.power > 0) this.model.setPower(power);
			if(this.maxCount > 0) this.model.setMaxCount(maxCount);
			if(this.maxDistance > 0) this.model.setMaxDistance(maxDistance);
				
			this.precipitation = this.model.calculate(_fs, "val", point);
			this.elevation = this.model.getElevation();
		}
		finally{
			if(_zip != null){
				_zip.close();
			}
		}
	}
	
	@GeoOutput(title="降水")
	public double getPrecipitation() {
		return precipitation;
	}

	@GeoOutput(title="标准高程")
	public double getElevation() {
		return elevation;
	}

	@GeoInput(title="月份")
	public void setDate(Date date) {
		this.date = date;
	}

	@GeoInput(title="目标点")
	public void setPoint(Point point) {
		this.point = point;
	}
	
	@GeoInput(title="最大选点个数")
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	@GeoInput(title="最大选点距离")
	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}
	
	@GeoInput(title="幂值")
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
