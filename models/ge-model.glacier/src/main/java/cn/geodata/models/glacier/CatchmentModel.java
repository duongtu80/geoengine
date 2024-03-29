package cn.geodata.models.glacier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.geotools.feature.FeatureCollection;
import org.opengis.feature.Feature;

import cn.geodata.models.tools.WfsFeatureSource;

import com.vividsolutions.jts.geom.MultiPolygon;

public class CatchmentModel {
	private static Logger log = Logger.getLogger(CatchmentModel.class.getName());
	
	private WfsFeatureSource featureSource;
	private String nameField;
	
	public CatchmentModel(){
		this.nameField = "NAME";
	}
	
	public CatchmentModel(WfsFeatureSource featureSource, String nameField){
		this.featureSource = featureSource;
		this.nameField = nameField;
	}
	
	public List<String> getCatchmentList() throws IOException {
		List<String> _list = new ArrayList<String>();
		FeatureCollection _fs = this.featureSource.getFeatureSource().getFeatures();
		
		for(Feature _f : (Feature[])_fs.toArray()){
			String _n = (String)_f.getProperty(this.nameField).getValue();
			if(_n != null){
				_n = _n.trim();
				if(_list.contains(_n) == false){
					_list.add(_n);
				}
			}
		}
		
		return _list;
	}

	public Feature getCatchmentFeature(String catchmentId ) throws IOException{
		for(Feature _f : (Feature[])this.featureSource.getFeatureSource().getFeatures().toArray()){
			String _n = (String)_f.getProperty(this.nameField).getValue();
			if(_n != null){
				if(_n.trim().equals(catchmentId)){
					return _f;
				}
			}
		}
		log.warning("Failed to find the catchment " + catchmentId);
		return null;

//		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
//		FeatureCollection _fs = this.getDataStore().getFeatureSource().getFeatures(_factory.equal(_factory.property(this.nameField), _factory.literal(catchmentId)));
//		
//		if(_fs.size() == 0){
//			log.warning("Failed to find the catchment " + catchmentId);
//		}
//		
//		return ((Feature[])_fs.toArray(new Feature[0]))[0];
	}
	
	public MultiPolygon getCatchmentPolygon(String catchmentId) throws IOException{
		Feature _f = this.getCatchmentFeature(catchmentId);
		if(_f != null){
			return (MultiPolygon) _f.getDefaultGeometryProperty().getValue();
		}
		else{
			return null;
		}
	}
}
