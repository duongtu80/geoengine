package cn.geodata.models.glacier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;

import com.vividsolutions.jts.geom.Point;

public class InvertDistanceWeightModel implements InterpolateModel {
	private double maxDistance;
	private int maxCount;
	private int pow;
	
	public double getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public int getPow() {
		return pow;
	}

	public void setPow(int pow) {
		this.pow = pow;
	}

	public double calculate(FeatureCollection fs, String fieldName, Point point) throws IOException {
		List<Map<String, Double>> _sites = new ArrayList<Map<String,Double>>();

		double _maxWeight = 0;
		for(Feature _f : (Feature[])fs.toArray(new Feature[0])){
			double _val = ((Double)_f.getAttribute(fieldName)).doubleValue(); 
			double _dis = _f.getDefaultGeometry().distance(point);
			
			if(_dis == 0){
				return _val;
			}
			
			if(this.maxDistance == 0 || _dis < this.maxDistance){
				Map<String, Double> _site = new HashMap<String, Double>();

				_site.put("dis", _dis);
				_site.put("val", _val);
				
				_sites.add(_site);
				_maxWeight += Math.pow(_dis, pow);
				
				if(this.maxCount > 0 && _sites.size() >= this.maxCount){
					break;
				}
			}

		}
		
		double _val = 0;
		for(Map<String, Double> _site : _sites){
			double _weight = Math.pow(_site.get("dis"), pow) / _maxWeight;
//			log.info("Distance:" + _site.get("dis") + ", Weight:" + _weight + ", Value:" + _site.get("val"));
			
			_val += _weight * _site.get("val");
		}
		
		return _val;
	}
}
