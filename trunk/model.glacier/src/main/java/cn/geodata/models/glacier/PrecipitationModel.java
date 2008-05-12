package cn.geodata.models.glacier;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.geotools.feature.FeatureCollection;

import com.vividsolutions.jts.geom.Point;

public class PrecipitationModel {
	private Logger log = Logger.getLogger(PrecipitationModel.class.getName());
	
	private InvertDistanceWeightModel model;
	private String filePath;
	
	public InvertDistanceWeightModel getModel() {
		return model;
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

	public PrecipitationModel(){
		this.filePath = "/glacier/data/precipitation";
	}
	
//	public double calculate(Date date, Point point) throws MalformedURLException, IOException{
//		String _fileName = String.format("cp%04d%02d.txt", date.getYear() + 1900, date.getMonth() + 1);
//		log.info("File name:" + _fileName);
//		
//		URL _url = PrecipitationModel.class.getResource(filePath + "/" + _fileName);
//		log.info("Url:" + _url);
//		log.info("Point:" + point.toText());
//		
//		List<Map<String, Double>> _sites = new ArrayList<Map<String,Double>>();
//		
//		Pattern _pattern = Pattern.compile("(\\d+),([\\d\\.]+),([\\d\\.]+),([\\d\\.]+)");
//		List<String> _lines = IOUtils.readLines(_url.openStream());
//		
//		FeatureType _featureType = CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType(types, name)
//		double _maxWeight = 0;
//		for(int i=0;i<_lines.size(); i++){
//			String _line = _lines.get(i).trim();
//			if(_line.length() > 0){
//				Matcher _m = _pattern.matcher(_line);
//				if(_m.matches()){
//					Map<String, Double> _site = new HashMap<String, Double>();
//					
//					String _code = _m.group(1);
//					double _lon = Double.parseDouble(_m.group(2));
//					double _lat = Double.parseDouble(_m.group(3));
//					double _val = Double.parseDouble(_m.group(4));
//					double _dis = Math.hypot(point.getX() - _lon, point.getY() - _lat);
//					
//				}
//			}
//		}
//		
//		double _val = 0;
//		for(Map<String, Double> _site : _sites){
//			double _weight = Math.pow(_site.get("dis"), pow) / _maxWeight;
////			log.info("Distance:" + _site.get("dis") + ", Weight:" + _weight + ", Value:" + _site.get("val"));
//			
//			_val += _weight * _site.get("val");
//		}
//		
//		return _val;
//	}

	public double calculate(Date date, Point point) throws Exception{
		String _fileName = String.format("cp%04d%02d.txt", date.getYear() + 1900, date.getMonth() + 1);
		log.info("File name:" + _fileName);
		
		URL _url = PrecipitationModel.class.getResource(filePath + "/" + _fileName);
		log.info("Url:" + _url);
		log.info("Point:" + point.toText());
		
		Pattern _pattern = Pattern.compile("\\d+[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)");
		FeatureCollection _fs = null;
		try {
			_fs = (new TxtFeatureReader()).read("precipitation", _url.openStream(), _pattern);
		} catch (Exception e) {
			throw new IOException("Failed to create feature");
		}
		
		return this.model.calculate(_fs, "val", point);
	}
}
