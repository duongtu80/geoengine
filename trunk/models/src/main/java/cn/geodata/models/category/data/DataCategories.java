package cn.geodata.models.category.data;

import java.util.ArrayList;
import java.util.List;

import net.opengeospatial.wps.ComplexValueType;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

public class DataCategories {
	private static DataCategories instance;

	private List<DataCategory> categories;

	private DataCategories() {
		this.categories = new ArrayList<DataCategory>();
	}

	public List<DataCategory> getCategories() {
		return categories;
	}

	public void addCategory(DataCategory category) {
		this.categories.add(category);
	}
	
	public DataCategory findCategory(String path) {
		DataCategory _c = null;
		for(String _p : path.split("\\.")){
			List<DataCategory> _list = null;
			if(_c == null){
				_list = this.getCategories();
			}
			else{
				_list = _c.getChildren();
			}
			
			DataCategory _cat = null;
			for(DataCategory _d : _list){
				if(_d.getId().equalsIgnoreCase(_p)){
					_cat = _d;
					break;
				}
			}
			if(_cat == null){
				return null;
			}
			else{
				_c = _cat;
			}
		}
		
		return _c;
	}

	public static DataCategories getInstance() {
		if (instance == null) {
			instance = new DataCategories();

			instance.addCategory(new DataCategory("feature", "Feature",
					"Feature", Feature.class, null));
			instance.addCategory(new DataCategory("featureCollection",
					"Feature Collection", "Feature Collection",
					FeatureCollection.class, null));

			instance.addCategory(new DataCategory("point", "Point", "Point",
					Point.class, null));
			instance.addCategory(new DataCategory("lineString", "LineString",
					"LineString", LineString.class, null));
			instance.addCategory(new DataCategory("polygon", "Polygon", "Polygon",
					Polygon.class, null));
			instance.addCategory(new DataCategory("multiPoint", "MultiPoint",
					"MultiPoint", MultiPoint.class, null));
			instance.addCategory(new DataCategory("multiLineString",
					"MultiLineString", "MultiLineString",
					MultiLineString.class, null));
			instance.addCategory(new DataCategory("multiPolygon", "MultiPolygon",
					"MultiPolygon", MultiPolygon.class, null));

			instance.addCategory(new DataCategory("gridCoverage",
					"Grid Coverage", "Grid Coverage", GridCoverage2D.class,
					null));
		}
		return instance;
	}
}
