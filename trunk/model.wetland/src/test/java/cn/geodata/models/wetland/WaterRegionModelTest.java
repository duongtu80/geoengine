package cn.geodata.models.wetland;

import java.io.File;
import java.io.IOException;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;

import com.vividsolutions.jts.geom.MultiPolygon;

import junit.framework.TestCase;

public class WaterRegionModelTest extends TestCase {

	public void testCalculate() throws NumberFormatException, Exception {
//		WaterRegionModel _model = new WaterRegionModel();
//		_model.setCatchment(this.findCatchment(new ShapefileDataStore(WaterRegionModelTest.class.getResource("/wetland/data/catchment.shp")).getFeatureSource().getFeatures(), "NAME", "P4"));
//		_model.setReader(new EnviRasterReader(WaterRegionProcessing.class.getResource("/wetland/data/dem"), WaterRegionProcessing.class.getResource("/wetland/data/dem.hdr"), 1024 * 1024));
//		_model.setWaterLevel(1);
//		
//		MultiPolygon _water = _model.calculate();
	}
	
	private MultiPolygon findCatchment(FeatureCollection catchments, String fieldName, String fieldValue) throws IOException{
		FeatureIterator _it = catchments.features();
		try{
			while(_it.hasNext()){
				Feature _f = _it.next();
				if(((String)_f.getAttribute(fieldName)).equalsIgnoreCase(fieldValue)){
					return (MultiPolygon) _f.getDefaultGeometry();
				}
			}
			
			throw new IOException("Not found catchement:" + fieldValue);
		}
		finally{
			_it.close();
		}
	}
}
