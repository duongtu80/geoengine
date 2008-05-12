package cn.geodata.models.glacier;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.opengis.filter.FilterFactory2;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

public class CatchmentModel {
	private static Logger log = Logger.getLogger(CatchmentModel.class.getName());
	private String path;
	private String nameField;
	
	public CatchmentModel(){
		this.path = "/glacier/data/catchment/catchment.shp";
		this.nameField = "WRRNM";
	}
	
	public CatchmentModel(String path, String nameField){
		this.path = path;
		this.nameField = nameField;
	}
	
	public List<String> getCatchmentList() throws IOException {
		List<String> _list = new ArrayList<String>();
		FeatureCollection _fs = this.getDataStore().getFeatureSource().getFeatures();
		
		for(Feature _f : (Feature[])_fs.toArray()){
			String _n = (String)_f.getAttribute(this.nameField);
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
		for(Feature _f : (Feature[])this.getDataStore().getFeatureSource().getFeatures().toArray()){
			String _n = (String)_f.getAttribute(this.nameField);
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
			return (MultiPolygon) _f.getDefaultGeometry();
		}
		else{
			return null;
		}
	}
	
	private ShapefileDataStore getDataStore() throws MalformedURLException{
		URL _url = CatchmentModel.class.getResource(this.path);
		log.info(_url.toString());
		
		ShapefileDataStore _dataStore = new ShapefileDataStore(_url, false, Charset.forName("gb2312"));
		
		return _dataStore;
	}
}
