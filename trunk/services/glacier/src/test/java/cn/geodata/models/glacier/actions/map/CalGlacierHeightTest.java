package cn.geodata.models.glacier.actions.map;

import junit.framework.TestCase;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.simple.SimpleFeature;

import com.vividsolutions.jts.geom.MultiPolygon;

public class CalGlacierHeightTest extends TestCase {
	public void testTest1() throws Exception {
		CalGlacierHeight _model = new CalGlacierHeight();
		
		FeatureIterator _it = new ShapefileDataStore(CalGlacierHeight.class.getResource("/glacier/basin.shp")).getFeatureSource().getFeatures().features();
		SimpleFeature _f = (SimpleFeature) _it.next();
		
		MultiPolygon _p = (MultiPolygon) _f.getDefaultGeometry();
		System.out.println(_model.calculate(_p));
	}
}
