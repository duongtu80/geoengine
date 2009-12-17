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
	private int power;
	private double elevation;
	
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

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	public double calculate(List<Map<String, Double>> list, String fieldName, Point point) throws IOException {
		List<Map<String, Double>> _sites = new ArrayList<Map<String,Double>>();

		double _maxWeight = 0;
		for(Map<String, Double> _f : list){
			double _lon = _f.get("LON");
			double _lat = _f.get("LAT");
			
			double _val = _f.get(fieldName);
			double _dis = Math.hypot(point.getX() - _lon, point.getY() - _lat);
			
			if(_dis == 0){
				return _val;
			}
			
			if(this.maxDistance == 0 || _dis < this.maxDistance){
				Map<String, Double> _site = new HashMap<String, Double>();

				_site.put("dis", _dis);
				_site.put("val", _val);
				_site.put("elv", 0.0);
				_site.put("weight", 1.0 / Math.pow(_dis, power));
				
				boolean _added = false;
				for(int i=0;i<_sites.size();i++){
					if(_sites.get(i).get("dis") > _dis){
						_sites.add(i, _site);
						
						_added = true;
						break;
					}
				}
				
				if(_added == false){
					_sites.add(_site);
				}
				_maxWeight += (double)_site.get("weight");
			}
		}
		
		if(maxCount > 0 && maxCount < _sites.size()){
			for(int i=_sites.size() - 1;i >= maxCount;i--){
				_sites.remove(i);
			}
		}
		
		double _val = 0;
		double _elv = 0;
		for(Map<String, Double> _site : _sites){
			double _weight = (double)_site.get("weight") / _maxWeight;
			
			_val += _weight * _site.get("val");
			_elv += _weight * _site.get("elv");
		}
		
		this.elevation = _elv;
		
		return _val;
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
				_site.put("elv", ((Point)_f.getDefaultGeometry()).getCoordinate().z);
				_site.put("weight", 1.0 / Math.pow(_dis, power));
				
				boolean _added = false;
				for(int i=0;i<_sites.size();i++){
					if(_sites.get(i).get("dis") > _dis){
						_sites.add(i, _site);
						
						_added = true;
						break;
					}
				}
				
				if(_added == false){
					_sites.add(_site);
				}
				_maxWeight += (double)_site.get("weight");
			}
		}
		
		if(maxCount > 0 && maxCount < _sites.size()){
			for(int i=_sites.size() - 1;i >= maxCount;i--){
				_sites.remove(i);
			}
		}
		
		double _val = 0;
		double _elv = 0;
		for(Map<String, Double> _site : _sites){
			double _weight = (double)_site.get("weight") / _maxWeight;
//			log.info("Distance:" + _site.get("dis") + ", Weight:" + _weight + ", Value:" + _site.get("val"));
			
			_val += _weight * _site.get("val");
			_elv += _weight * _site.get("elv");
		}
		
		this.elevation = _elv;
		
		return _val;
	}

	public double getElevation() {
		return elevation;
	}
}
