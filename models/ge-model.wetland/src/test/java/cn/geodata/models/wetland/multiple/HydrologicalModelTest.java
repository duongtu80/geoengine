package cn.geodata.models.wetland.multiple;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.geotools.data.FeatureStore;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.feature.AttributeType;
import org.geotools.feature.AttributeTypeFactory;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureType;
import org.geotools.feature.IllegalAttributeException;
import org.geotools.feature.SchemaException;

import com.vividsolutions.jts.geom.MultiPolygon;

import junit.framework.TestCase;
import cn.geodata.models.wetland.DemRaster;

public class HydrologicalModelTest extends TestCase {

	public void testCalculate() throws Exception {
		DemRaster _reader = new DemRaster(
				Catchment.class.getResource("/wetland/data/dem"),
				Catchment.class.getResource("/wetland/data/dem.hdr"),
				1024 * 1024 * 2
				);
		
		assertNotNull(Catchment.class.getResource("/wetland/data/catchment.shp"));
		
		List<Catchment> _cats = Catchment.loadCatchments(_reader);
		for(Catchment _c : _cats){
			System.out.println(_c.getCode() + " :" + _c.getArea());
		}
		
		HydrologicalModel _model = new HydrologicalModel(_reader, _cats);
		for(WetlandWater _w : _model.getWetlands()){
			String _code = "outflow";
			Catchment _c = _w.getSpillPoint().getCatchment();
			if(_c != null){
				_code = _c.getCode();
			}
			
			System.out.println(_w.toString());
//			System.out.println(_w.getCatchments().get(0).getCode() + "->" + _code);
		}
		
		List<WaterTable> _waters = null;
		for(int i=0;i<10;i++){
			_waters = _model.calculate(1, 1, 1, 100, 0.3, 0.5, 0.0015, 0.00001);
			this.writeWaters1(_waters, new File(new File("D:\\Tank\\Temp\\test8"), "levels" + (i + 1) + ".csv"));
			this.writeWaters2(_waters, new File(new File("D:\\Tank\\Temp\\test8"), "water" + (i + 1) + ".shp"));
			this.writeWaters3(_waters, new File(new File("D:\\Tank\\Temp\\test8"), "basin" + (i + 1) + ".shp"));
		}
	}

	private void writeWaters3(List<WaterTable> waters, File file) throws IOException, FactoryRegistryException, SchemaException, IllegalAttributeException{
		FeatureType _ft = this.createFeatureType(file);
		(new ShapefileDataStore(file.toURL())).createSchema(_ft);
		
		FeatureStore _store = (FeatureStore) (new ShapefileDataStore(file.toURL())).getFeatureSource();
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		
		for(WaterTable _w : waters){
			String _codes = "";
			for(Catchment _c : _w.getCatchments()){
				if(_codes.length() == 0)
					_codes = _c.getCode();
				else
					_codes = _codes.concat("," + _c.getCode());
			}
			
			_fs.add(_ft.create(new Object[] {_w.getCatchmentRegion(), _w.getWaterLevel(), _codes}));
//			_fs.add(_ft.create(new Object[] {_w.calculateWaterRegion(), _w.getWaterLevel(), _w.toString()}));
		}
		
		_store.addFeatures(_fs);
	}

	private void writeWaters2(List<WaterTable> waters, File file) throws IOException, FactoryRegistryException, SchemaException, IllegalAttributeException{
		FeatureType _ft = this.createFeatureType(file);
		(new ShapefileDataStore(file.toURL())).createSchema(_ft);
		
		FeatureStore _store = (FeatureStore) (new ShapefileDataStore(file.toURL())).getFeatureSource();
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		
		for(WaterTable _w : waters){
//			_fs.add(_ft.create(new Object[] {_w.getCatchmentRegion(), _w.getWaterLevel(), _w.toString()}));
			_fs.add(_ft.create(new Object[] {_w.calculateWaterRegion(), _w.getWaterLevel(), _w.toString()}));
		}
		
		_store.addFeatures(_fs);
	}
	
	private FeatureType createFeatureType(File file) throws FactoryRegistryException, SchemaException{
		AttributeTypeFactory _attType = CommonFactoryFinder.getAttributeTypeFactory(GeoTools.getDefaultHints());
		
		List<AttributeType> _attrs = new ArrayList<AttributeType>();
		_attrs.add(_attType.newAttributeType("shape", MultiPolygon.class));
		_attrs.add(_attType.newAttributeType("height", Double.class));
		_attrs.add(_attType.newAttributeType("codes", String.class, true, 50));
		
		return CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType((AttributeType[])_attrs.toArray(new AttributeType[0]), file.getName());
	}
	
	private void writeWaters1(List<WaterTable> waters, File file) throws IOException{
		FileOutputStream _out = FileUtils.openOutputStream(file);
		
		for(WaterTable _w : waters){
			List<String> _names = new ArrayList<String>();
			for(Catchment _c : _w.getCatchments()){
				_names.add(_c.getCode());
			}
			
			IOUtils.write("\"" + Arrays.toString(_names.toArray()) + "\"," + _w.getWaterLevel() + "\n", _out);
		}
		_out.close();
	}
}
