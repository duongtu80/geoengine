package cn.geodata.models.glacier;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.feature.AttributeType;
import org.geotools.feature.AttributeTypeFactory;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureType;
import org.geotools.feature.IllegalAttributeException;
import org.geotools.feature.SchemaException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class TxtFeatureReader {
	private Logger log = Logger.getLogger(TxtFeatureReader.class.getName());
	
	public FeatureCollection read(String datasetName, InputStream stream, Pattern pattern) throws IOException, NumberFormatException, IllegalAttributeException{
		GeometryFactory _factory = new GeometryFactory();
		FeatureType _featureType = null;
		try {
			_featureType = this.createFeatureType(datasetName);
		} catch (FactoryRegistryException e) {
			log.warning(e.getMessage());
			throw new IOException("GeoTools factory registry exception");
		} catch (SchemaException e) {
			log.warning(e.getMessage());
			throw new IOException("Failed to create feature type");
		}
		
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		for(String _line : (List<String>)IOUtils.readLines(stream)){
			Matcher _m = pattern.matcher(_line);
			
			if(_m.find()){
				double _x = Double.parseDouble(_m.group(1));
				double _y = Double.parseDouble(_m.group(2));
				
				Point _pt = _factory.createPoint(new Coordinate(_x, _y));

				_fs.add(_featureType.create(new Object[]{
						_pt,
						Double.parseDouble(_m.group(3))
					}));
			}
		}
		
		return _fs;
	}

	public FeatureType createFeatureType(String datasetName) throws FactoryRegistryException, SchemaException{
		AttributeTypeFactory _attributeFty = CommonFactoryFinder.getAttributeTypeFactory(GeoTools.getDefaultHints());
		
		List<AttributeType> _attrs = new ArrayList<AttributeType>();
		
		_attrs.add(_attributeFty.newAttributeType("shape", Point.class));
		_attrs.add(_attributeFty.newAttributeType("val", Double.class));
		
		return CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType(_attrs.toArray(new AttributeType[0]), datasetName);
	}
}
