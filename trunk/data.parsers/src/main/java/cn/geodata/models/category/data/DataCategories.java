package cn.geodata.models.category.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;

import cn.geodata.models.data.Utilities;

import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

public class DataCategories {
	private static Logger log = Utilities.getLogger();
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
					"Feature", Feature.class, false, null));
			instance.addCategory(new DataCategory("featureCollection",
					"Feature Collection", "Feature Collection",
					FeatureCollection.class, false, null));

			instance.addCategory(new DataCategory("point", "Point", "Point",
					Point.class, false, null));
			instance.addCategory(new DataCategory("lineString", "LineString",
					"LineString", LineString.class, false, null));
			instance.addCategory(new DataCategory("polygon", "Polygon", "Polygon",
					Polygon.class, false, null));
			instance.addCategory(new DataCategory("multiPoint", "MultiPoint",
					"MultiPoint", MultiPoint.class, false, null));
			instance.addCategory(new DataCategory("multiLineString",
					"MultiLineString", "MultiLineString",
					MultiLineString.class, false, null));
			instance.addCategory(new DataCategory("multiPolygon", "MultiPolygon",
					"MultiPolygon", MultiPolygon.class, false, null));

			instance.addCategory(new DataCategory("gridCoverage",
					"Grid Coverage", "Grid Coverage", GridCoverage2D.class, false,
					null));

			instance.addCategory(new DataCategory("int",
					"Integer", "Integer", Integer.class, true,
					null));
			instance.addCategory(new DataCategory("long",
					"Long", "Long", Long.class, true,
					null));
			instance.addCategory(new DataCategory("float",
					"Float", "Float", Float.class, true,
					null));
			instance.addCategory(new DataCategory("double",
					"Double", "Double", Double.class, true,
					null));
			instance.addCategory(new DataCategory("string",
					"String", "String", String.class, true,
					null));
		}
		return instance;
	}
	
	public MimeType getDefaultMime(DataCategory category) throws IOException{
		if(category.getLiteral()){
			throw new IOException("Literal type does not support MIME");
		}
		
		if(category.equals(this.findCategory("gridCoverage"))){
			try {
				return new MimeType("geotiff");
			} catch (MimeTypeParseException e) {
				log.log(Level.WARNING, "Failed to create MIME geotiff", e);
				throw new IOException(e);
			}
		}
		else{
			try {
				return new MimeType("text/xml");
			} catch (MimeTypeParseException e) {
				log.log(Level.WARNING, "Failed to create MIME text/xml", e);
				throw new IOException(e);
			}
		}
	}
}
