package cn.geodata.models.ecoserv.landcover;

import junit.framework.TestCase;

import org.geotools.data.FeatureSource;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

public class ConnectionPoolTest extends TestCase {
	public void testPGConnection() throws Exception {
//		Connection _con = ConnectionPool.getPGConnection().getConnection();
		FeatureSource<SimpleFeatureType, SimpleFeature> _fs = ConnectionPool.getPGDataStore().getFeatureSource("basin");
		
		System.out.println(_fs.getFeatures().size());
	}
}
