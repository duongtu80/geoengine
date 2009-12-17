package cn.geodata.models.glacier.actions.map;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.simple.SimpleFeature;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiPolygon;

public class CalGlacierHeight {
	public double calculate(MultiPolygon basin) throws MalformedURLException, IOException {
		double _area = 0;
		double _height = 0;
		
		FeatureIterator _it = new ShapefileDataStore(CalGlacierHeight.class.getResource("/glacier/glacier_n.shp"), true, Charset.forName("gb2312")).getFeatureSource().getFeatures().features();
		while(_it.hasNext()){
			SimpleFeature _f = (SimpleFeature) _it.next();
			
			if(basin.contains((Geometry) _f.getDefaultGeometry())){
				double _a = (Double)_f.getAttribute("AREA");
				
				_area += _a;
				_height += _a * (Integer)_f.getAttribute("DEPTH");
			}
		}
		
		if(_area > 0){
			return _height / _area;
		}
		
		return 0;
	}
}
