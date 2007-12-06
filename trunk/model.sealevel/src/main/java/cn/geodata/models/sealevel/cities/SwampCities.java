package cn.geodata.models.sealevel.cities;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import net.opengeospatial.wps.IOValueType;

import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.feature.AttributeType;
import org.geotools.feature.AttributeTypeFactory;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.feature.FeatureType;
import org.geotools.feature.FeatureTypeFactory;
import org.geotools.feature.SchemaException;

import cn.geodata.model.GeoProcessing;
import cn.geodata.model.value.ModelValueParserFinder;
import cn.geodata.model.value.ModelValueUtil;

import com.vividsolutions.jts.geom.Point;

public class SwampCities extends GeoProcessing {
	private static Logger log = Logger.getAnonymousLogger();

	protected FeatureType createFeatureType() throws FactoryRegistryException, SchemaException, URISyntaxException {
		FeatureTypeFactory _factory = CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints());
		
		AttributeType[] _attrs = new AttributeType[3];
		_attrs[0] = AttributeTypeFactory.newAttributeType("geom", Point.class);
		_attrs[1] = AttributeTypeFactory.newAttributeType("rank", Integer.class);
		_attrs[2] = AttributeTypeFactory.newAttributeType("name", String.class, true, 255);
		
		return _factory.newFeatureType(_attrs, "cities", new URI("http://www.unep.org"));
	}
	
	@Override
	protected void execute() throws Exception {
		log.info("Start model");
		
		ModelValueParserFinder _finder = ModelValueUtil.createParserFinder();
		double _rise = _finder.getDefaultLiteralParser().parseLiteralDouble(this.getInputs().get("rise").get(0).getLiteralValue());
		FeatureCollection _cities = _finder.getDefaultComplexReferenceParser().parseFeatureCollection(this.getInputs().get("cities").get(0).getComplexValueReference());
		
		FeatureType _ft = this.createFeatureType();
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		FeatureIterator _it = _cities.features();
		try{
			while(_it.hasNext()){
				Feature _f = _it.next();
				if(((Double)_f.getAttribute("altitude")).doubleValue() < _rise){
					log.info("Feature Id:" + _f.getID());
					_fs.add(_ft.create(new Object[] {_f.getDefaultGeometry(), 1, _f.getAttribute("CITY_NAME")}, _f.getID()));
				}
			}
		}
		finally{
			_it.close();
		}
		
//		FilterFactory2 _filterFactory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
//		Filter _filter = _filterFactory.lessOrEqual(_filterFactory.property("altitude"), _filterFactory.literal(_rise));
//		
//		FeatureCollection _fs = this.getCities().getFeatures(_filter);
		
		log.info("Cities number:" + _fs.size());
		
		IOValueType _output = ModelValueUtil.createOutputValue(this.getOutputDefinitions().get("swamp"));
		_output.setComplexValue(_finder.getDefaultComplexEncoder().encodeFeatureCollection(_fs));
		
		this.getOutputs().get("swamp").add(_output);
	}
	
	public FeatureSource getCities() throws IOException {
		return (new ShapefileDataStore(SwampCities.class.getResource("/data/cities.ex.shp"))).getFeatureSource();
	}
	
}
