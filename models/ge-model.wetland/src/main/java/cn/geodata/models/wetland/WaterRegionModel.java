package cn.geodata.models.wetland;

import java.net.URI;
import java.net.URISyntaxException;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.SchemaException;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.opengis.feature.simple.SimpleFeatureType;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;
import cn.geodata.models.raster.GeoRaster;

import com.vividsolutions.jts.geom.MultiPolygon;

@GeoProcess(title="Water Surface Extent", keywords={"water surface", "water region", "geospatial extent"}, description="")
public class WaterRegionModel implements Calculate  {
	private String wetlandCode;
	private double waterLevel;
	private MultiPolygon catchment;
	private FeatureCollection waterRegion;
	private GeoRaster raster;
	
	public WaterRegionModel(GeoRaster raster){
		this.raster = raster;
	}

	protected SimpleFeatureType createFeatureType() throws FactoryRegistryException, SchemaException, URISyntaxException {
		SimpleFeatureTypeBuilder _builder = new SimpleFeatureTypeBuilder();
		_builder.setName("water");
		_builder.setNamespaceURI(new URI("http://www.unep.org"));
		
		_builder.add("geom", MultiPolygon.class);
		_builder.add("deep", Float.class);
		_builder.add("code", String.class);
		_builder.length(20);
		
		return _builder.buildFeatureType();
	}
	
	public void calculate() throws Exception {
		WaterRegionCalc _model = new WaterRegionCalc();
		_model.setCatchment(this.catchment);
		_model.setReader(raster);
		_model.setWaterLevel(waterLevel);
		
		MultiPolygon _water = _model.calculate();
		
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		if(_water != null){
			SimpleFeatureBuilder.build(this.createFeatureType(), new Object[] {_water, waterLevel, wetlandCode}, null);
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
