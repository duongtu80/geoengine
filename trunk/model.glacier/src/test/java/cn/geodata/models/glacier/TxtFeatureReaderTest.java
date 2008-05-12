package cn.geodata.models.glacier;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

import org.geotools.factory.FactoryRegistryException;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.SchemaException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import junit.framework.TestCase;

public class TxtFeatureReaderTest extends TestCase {

	public void testCreateFeatureType() throws Exception {
		String filePath = "/glacier/data/catchment/ddf_snow.txt";

		URL _url = PrecipitationModel.class.getResource(filePath);
		
		Pattern _pattern = Pattern.compile("\\d+[,\\s]\\S+[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)[,\\s]([\\d\\.]+)");
		FeatureCollection _fs = null;
		_fs = (new TxtFeatureReader()).read("snow_ddf", _url.openStream(), _pattern);
		
		Point _point = (new GeometryFactory()).createPoint(new Coordinate(105, 34));
		(new InvertDistanceWeightModel()).calculate(_fs, "val", _point);
	}

}
