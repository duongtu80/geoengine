package cn.geodata.models.sealevel.cities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureCollection;
import org.geotools.gml3.GMLConfiguration;
import org.opengis.filter.Filter;
import org.opengis.filter.FilterFactory2;

import cn.geodata.model.GeoProcessing;
import cn.geodata.model.util.Utilities;
import cn.geodata.model.value.ComplexValue;
import cn.geodata.model.value.LiteralValue;
import cn.geodata.model.value.ModelValue;

public class SwampCities extends GeoProcessing {
	private static Logger log = Logger.getAnonymousLogger();

	@Override
	protected void execute() throws Exception {
		float _rise = ((Float)((LiteralValue)this.getInputs().get("rise").get(0)).getValue()).floatValue();
		
		FilterFactory2 _filterFactory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		Filter _filter = _filterFactory.greater(_filterFactory.property("altitude"), _filterFactory.literal(_rise));
		
		FeatureCollection _fs = this.getCities().getFeatures(_filter);
		
		log.info("Cities number:" + _fs.size());
		ArrayList<ModelValue> _output = new ArrayList<ModelValue>();
		_output.add(new ComplexValue("cities", "", "", _fs));
		
		this.getOutput().put("cities", _output);
	}
	
	public FeatureSource getCities() throws IOException {
		return (new ShapefileDataStore(SwampCities.class.getResource("/data/cities.ex.shp"))).getFeatureSource();
	}
	
}
