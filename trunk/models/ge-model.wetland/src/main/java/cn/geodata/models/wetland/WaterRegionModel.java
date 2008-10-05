package cn.geodata.models.wetland;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.io.IOUtils;
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

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

import com.vividsolutions.jts.geom.MultiPolygon;

@GeoProcess(title="Water Region")
public class WaterRegionModel implements Calculate  {
	private Catchment catchment;
	private String wetlandCode;
	private double waterLevel;
	private FeatureCollection waterRegion;

	protected FeatureType createFeatureType() throws FactoryRegistryException, SchemaException, URISyntaxException {
		AttributeType[] _attrs = new AttributeType[3];
		_attrs[0] = AttributeTypeFactory.newAttributeType("geom", MultiPolygon.class);
		_attrs[1] = AttributeTypeFactory.newAttributeType("deep", Float.class);
		_attrs[2] = AttributeTypeFactory.newAttributeType("code", String.class, true, 20);
		
		return CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType(_attrs, "water", new URI("http://www.unep.org"));
	}
	
	public void calculate() throws Exception {
		String[] _fileList = new String[] {"dem", "dem.hdr"};
		File _temp = new File(System.getProperty("java.io.tmpdir"));
		
		for(String _f : _fileList){
			File _file = new File(_temp, _f);
			if(_file.exists() == false || _file.length() == 0){
				IOUtils.copy(Catchment.class.getResourceAsStream("/wetland/data/" + _f), new FileOutputStream(_file));
			}
		}
		
		WaterRegionCalc _model = new WaterRegionCalc();
		_model.setCatchment(this.catchment.findCatchmentByTag(wetlandCode));
		_model.setReader(new EnviRasterReader(new File(_temp, _fileList[0]).toURL(), new File(_temp, _fileList[1]).toURL(), 1024 * 1024));
		_model.setWaterLevel(waterLevel);
		
		MultiPolygon _water = _model.calculate();
		
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		if(_water != null){
			FeatureType _ft = this.createFeatureType();
			_fs.add(_ft.create(new Object[] {_water, waterLevel, wetlandCode}));
		}
		
		this.waterRegion = _fs;
	}

	public void setCatchment(Catchment catchment) {
		this.catchment = catchment;
	}

	@GeoOutput(title="Water Region")
	public FeatureCollection getWaterRegion() {
		return waterRegion;
	}

	@GeoInput(title="Wetland Code")
	public void setWetlandCode(String wetlandCode) {
		this.wetlandCode = wetlandCode;
	}

	@GeoInput(title="Water Level")
	public void setWaterLevel(double waterLevel) {
		this.waterLevel = waterLevel;
	}

	public int getPercent() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}
