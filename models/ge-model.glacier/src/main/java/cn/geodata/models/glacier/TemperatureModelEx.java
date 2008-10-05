package cn.geodata.models.glacier;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

import com.vividsolutions.jts.geom.Point;

@GeoProcess(title="修正的气温插值模型", keywords={"temperature", "idw"})
public class TemperatureModelEx implements Calculate {
	private Logger log = Logger.getLogger(TemperatureModelEx.class.getName());
	
	private InvertDistanceWeightModel model;
	private double grads;
	private double stand;
	private Date date;
	private Point point;
	private double temperature;
	private int maxCount;
	private double maxDistance;
	private int power;
	
	public TemperatureModelEx(){
		power = 0;
		maxCount = 0;
		maxDistance = 0;
	}

	public void calculate() throws Exception{
		double _elevation = this.point.getCoordinate().z;
//		double _elevation = this.demModel.getLocationValue(point.getX(), point.getY());
		if(_elevation <= 0){
			log.warning("Incorrect elevation at location " + point.toText());
			this.temperature = 0;
			return;
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
			Pattern _pattern = Pattern.compile("\\d+[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)");
			
			FeatureCollection _fs = null;
			try {
				_fs = (new TxtFeatureReader()).read("temperature", _zip.getInputStream(_zip.getEntry(_fileName)), _pattern, true);
			} catch (Exception e) {
				throw new IOException("没有找到该日期的站点数据");
			}

			FeatureCollection _fs2 = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
			for(Feature _f : (Feature[])_fs.toArray(new Feature[0])){
				Point _pt = (Point) _f.getDefaultGeometry();
				double _elv = _pt.getCoordinate().z; //this.demModel.getLocationValue(_pt.getX(), _pt.getY());
				
				if(_elv > 0){
					double _val = ((Double)_f.getAttribute("val"));
					_f.setAttribute("val", _val - (_elv - this.stand) * this.grads);
					
					_fs2.add(_f);
				}
			}

			if(this.power > 0) this.model.setPower(power);
			if(this.maxCount > 0) this.model.setMaxCount(maxCount);
			if(this.maxDistance > 0) this.model.setMaxDistance(maxDistance);
				
			this.temperature = this.model.calculate(_fs2, "val", point) + (_elevation - this.stand) * this.grads; 
		}
		finally{
			if(_zip != null){
				_zip.close();
			}
		}
	}

	@GeoOutput(title="气温")
	public double getTemperature() {
		return temperature;
	}

	@GeoInput(title="月份")
	public void setDate(Date date) {
		this.date = date;
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

	@GeoInput(title="目标点")
	public void setPoint(Point point) {
		this.point = point;
	}
	
	@GeoInput(title="气温垂直递减率")
	public void setGrads(double grads) {
		this.grads = grads;
	}

	@GeoInput(title="标准高程")
	public void setStand(double stand) {
		this.stand = stand;
	}

	public void setModel(InvertDistanceWeightModel model) {
		this.model = model;
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
