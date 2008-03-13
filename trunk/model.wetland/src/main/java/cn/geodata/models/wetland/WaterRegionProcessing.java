package cn.geodata.models.wetland;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
import org.geotools.feature.SchemaException;

import cn.geodata.models.AbstractProcessing;

import com.vividsolutions.jts.geom.MultiPolygon;

public class WaterRegionProcessing extends AbstractProcessing {

	@Override
	public void execute() throws Exception {
		String _wetlandCode = (String)this.getInputs().get("WetlandCode");
		String _codeField = (String)this.getInputs().get("CodeField");
		float _waterLevel = (Float)this.getInputs().get("WaterLevel");
		FeatureCollection _catchment = (FeatureCollection) this.getInputs().get("Catchment");
		
		WaterRegionModel _model = new WaterRegionModel();
		_model.setCatchment(this.findCatchment(new ShapefileDataStore(WaterRegionModel.class.getResource("/wetland/data/catchment.shp")).getFeatureSource().getFeatures(), _codeField, _wetlandCode));
//		_model.setCatchment(this.findCatchment(_catchment, _codeField, _wetlandCode));
		_model.setReader(new EnviRasterReader(WaterRegionProcessing.class.getResource("/wetland/data/dem"), WaterRegionProcessing.class.getResource("/wetland/data/dem.hdr"), 1024 * 1024));
		_model.setWaterLevel(_waterLevel);
		
		MultiPolygon _water = _model.calculate();
		
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		if(_water != null){
			FeatureType _ft = this.createFeatureType();
			_fs.add(_ft.create(new Object[] {_water, _waterLevel, _wetlandCode}));
		}
		
		this.getOutputs().put("WaterRegion", _fs);
	}
	
	protected FeatureType createFeatureType() throws FactoryRegistryException, SchemaException, URISyntaxException {
		AttributeType[] _attrs = new AttributeType[3];
		_attrs[0] = AttributeTypeFactory.newAttributeType("geom", MultiPolygon.class);
		_attrs[1] = AttributeTypeFactory.newAttributeType("deep", Float.class);
		_attrs[2] = AttributeTypeFactory.newAttributeType("code", String.class, true, 20);
		
		return CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType(_attrs, "water", new URI("http://www.unep.org"));
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
