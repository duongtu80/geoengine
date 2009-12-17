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
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.IllegalAttributeException;
import org.geotools.feature.SchemaException;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.feature.type.AttributeType;
import org.opengis.feature.type.FeatureType;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class TxtFeatureReader {
	private Logger log = Logger.getLogger(TxtFeatureReader.class.getName());
	
	public FeatureCollection read(String datasetName, InputStream stream, Pattern pattern, boolean threeD) throws IOException, NumberFormatException, IllegalAttributeException{
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
				if(threeD){
					double _x = Double.parseDouble(_m.group(1));
					double _y = Double.parseDouble(_m.group(2));
					double _z = Double.parseDouble(_m.group(3));
					
					Point _pt = _factory.createPoint(new Coordinate(_x, _y, _z));
	
					_fs.add(SimpleFeatureBuilder.build((SimpleFeatureType) _featureType, new Object[]{
							_pt,
							Double.parseDouble(_m.group(4))
						}, null));
				}
				else{
					double _x = Double.parseDouble(_m.group(1));
					double _y = Double.parseDouble(_m.group(2));
					
					Point _pt = _factory.createPoint(new Coordinate(_x, _y));
	
					_fs.add(SimpleFeatureBuilder.build((SimpleFeatureType) _featureType, new Object[]{
							_pt,
							Double.parseDouble(_m.group(3))
						}, null));
				}
			}
		}
		
		return _fs;
	}

	public FeatureType createFeatureType(String datasetName) throws FactoryRegistryException, SchemaException{
		SimpleFeatureTypeBuilder _builder = new SimpleFeatureTypeBuilder();
		_builder.setName(datasetName);
		
		_builder.add("shape", Point.class);
		_builder.add("val", Double.class);

		return _builder.buildFeatureType();
	}
}
