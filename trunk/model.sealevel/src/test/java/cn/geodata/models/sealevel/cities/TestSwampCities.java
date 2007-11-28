package cn.geodata.models.sealevel.cities;

import java.util.logging.Logger;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureCollection;
import org.opengis.filter.Filter;
import org.opengis.filter.FilterFactory2;

import cn.geodata.model.value.ComplexValue;
import cn.geodata.model.value.LiteralValue;
import junit.framework.TestCase;

public class TestSwampCities extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();
	
	public void testTest1() throws Exception {
		float _rise = 100f;
		
		FilterFactory2 _filterFactory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		Filter _filter = _filterFactory.lessOrEqual(_filterFactory.property("altitude"), _filterFactory.literal(_rise));
		
		FeatureCollection _fs = (new SwampCities()).getCities().getFeatures(_filter);
		
		if (Class.forName("org.geotools.feature.FeatureCollection").isInstance(_fs)) {
			log.info(_fs.getClass().getName());
		}
	}
}
