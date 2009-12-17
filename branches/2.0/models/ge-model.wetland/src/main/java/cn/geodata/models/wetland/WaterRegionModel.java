package cn.geodata.models.wetland;

import java.net.URI;
import java.net.URISyntaxException;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.feature.AttributeType;
import org.geotools.feature.AttributeTypeFactory;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureType;
import org.geotools.feature.SchemaException;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

import com.vividsolutions.jts.geom.MultiPolygon;

@GeoProcess(title="Water Surface Extent", keywords={"water surface", "water region", "geospatial extent"}, description="")
public class WaterRegionModel implements Calculate  {
	private String wetlandCode;
	private double waterLevel;
	private MultiPolygon catchment;
	private FeatureCollection waterRegion;
	private DemRaster raster;
	
	public WaterRegionModel(DemRaster raster){
		this.raster = raster;
	}

	protected FeatureType createFeatureType() throws FactoryRegistryException, SchemaException, URISyntaxException {
		AttributeType[] _attrs = new AttributeType[3];
		_attrs[0] = AttributeTypeFactory.newAttributeType("geom", MultiPolygon.class);
		_attrs[1] = AttributeTypeFactory.newAttributeType("deep", Float.class);
		_attrs[2] = AttributeTypeFactory.newAttributeType("code", String.class, true, 20);
		
		return CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType(_attrs, "water", new URI("http://www.unep.org"));
	}
	
	public void calculate() throws Exception {
		WaterRegionCalc _model = new WaterRegionCalc();
		_model.setCatchment(this.catchment);
		_model.setReader(raster);
		_model.setWaterLevel(waterLevel);
		
		MultiPolygon _water = _model.calculate();
		
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		if(_water != null){
			FeatureType _ft = this.createFeatureType();
			_fs.add(_ft.create(new Object[] {_water, waterLevel, wetlandCode}));
		}
		
		this.waterRegion = _fs;
	}

	@GeoInput(title="Catchment", srid={"EPSG:4326"})
	public void setCatchment(MultiPolygon catchment) {
		this.catchment = catchment;
	}

	@GeoOutput(title="Water Region", srid={"EPSG:4326"})
	public FeatureCollection getWaterRegion() {
		return waterRegion;
	}
	
	@GeoInput(title="Water Level", units={"meters"})
	public void setWaterLevel(double waterLevel) {
		this.waterLevel = waterLevel;
	}

	public int getPercent() {
		return 0;
	}

	public void cancel() {
	}

	public String getStatus() {
		return null;
	}
}
