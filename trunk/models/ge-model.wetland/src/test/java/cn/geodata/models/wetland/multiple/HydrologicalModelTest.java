package cn.geodata.models.wetland.multiple;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.xerces.impl.dv.xs.DayDV;
import org.geotools.data.FeatureStore;
import org.geotools.data.shapefile.ShapefileDataStore;
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

import cn.geodata.models.raster.GeoRaster;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

public class HydrologicalModelTest extends TestCase {
	
	public void testCalculateSpillPoint() throws Exception {
		GeoRaster _raster = new GeoRaster(new File("d:\\Tank\\Data\\ecoserv\\data\\dem\\lidar_c_flow_dir.tif"), -9999);
		
		List<Catchment> _cats = Catchment.loadCatchments(_raster, new ShapefileDataStore(new File("d:\\Tank\\Data\\ecoserv\\data\\catchment.shp").toURL()).getFeatureSource().getFeatures(), "NAME");
		for(Catchment _c : _cats){
			System.out.println(_c.getCode() + " :" + _c.getArea());
		}
		
		HydrologicalModel _model = new HydrologicalModel(_raster, _cats);
		for(WetlandWater _w : _model.getWetlands()){
			String _code = "outflow";
			Catchment _c = _w.getSpillPoint().getCatchment();
			if(_c != null){
				_code = _c.getCode();
			}
			
			Point _pt = _w.getSpillPoint().getLocation();
			System.out.println(_w.getCatchments().get(0).getCode() + "\t" + _pt.getX() + "," + _pt.getY() + "\t" + _w.toString());
		}
	}

//	public void atestCalculate() throws Exception {
//		DemRaster _reader = new DemRaster(
//				Catchment.class.getResource("/wetland/data/dem"),
//				Catchment.class.getResource("/wetland/data/dem.hdr"),
//				1024 * 1024 * 2
//				);
//		
//		assertNotNull(Catchment.class.getResource("/wetland/data/catchment.shp"));
//		
//		List<Catchment> _cats = Catchment.loadCatchments(_reader);
//		for(Catchment _c : _cats){
//			System.out.println(_c.getCode() + " :" + _c.getArea());
//		}
//		
//		HydrologicalModel _model = new HydrologicalModel(_reader, _cats);
//		for(WetlandWater _w : _model.getWetlands()){
//			String _code = "outflow";
//			Catchment _c = _w.getSpillPoint().getCatchment();
//			if(_c != null){
//				_code = _c.getCode();
//			}
//			
//			System.out.println(_w.toString());
////			System.out.println(_w.getCatchments().get(0).getCode() + "->" + _code);
//		}
//		
//		List<WaterTable> _waters = null;
//		for(int i=0;i<10;i++){
//			_waters = _model.calculate(1, 1, 1, 100, 0.3, 0.5, 0.0015, 0.00001);
//			this.writeWaters1(_waters, new File(new File("c:\\mfeng\\test\\wetland\\m_watertable"), "levels" + (i + 1) + ".csv"));
//			this.writeWaters2(_waters, new File(new File("c:\\mfeng\\test\\wetland\\m_watertable"), "water" + (i + 1) + ".shp"));
//			this.writeWaters3(_waters, new File(new File("c:\\mfeng\\test\\wetland\\m_watertable"), "basin" + (i + 1) + ".shp"));
//		}
//	}

	public void atestWaterTable() throws Exception {
		GeoRaster _reader = new GeoRaster(new File("d:\\Tank\\Data\\ecoserv\\dem\\ned10mbrwgs84.tif"), 0);
		assertNotNull(Catchment.class.getResource("/wetland/data/catchment.shp"));
		
		List<Catchment> _cats = Catchment.loadCatchments(_reader, new ShapefileDataStore(Catchment.class.getResource("/wetland/data/catchment.shp")).getFeatureSource().getFeatures());
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
			_w.setWaterLevel(_w.getSpillPoint().getElevation() + 10);
			
			System.out.println(_w.toString());
//			System.out.println(_w.getCatchments().get(0).getCode() + "->" + _code);
		}
		
		List<WaterTable> _waters = null;
		for(int i=0;i<1;i++){
			_waters = _model.calculateWaterFlow();
			this.writeWaters1(_waters, new File(new File("d:\\Temp\\test\\wetland\\m_watertable"), "levels" + (i + 1) + ".csv"));
			this.writeWaters2(_waters, new File(new File("d:\\Temp\\test\\wetland\\m_watertable"), "water" + (i + 1) + ".shp"));
			this.writeWaters3(_waters, new File(new File("d:\\Temp\\test\\wetland\\m_watertable"), "basin" + (i + 1) + ".shp"));
		}
	}

	private void writeWaters3(List<WaterTable> waters, File file) throws IOException, FactoryRegistryException, SchemaException, IllegalAttributeException{
		SimpleFeatureType _ft = this.createFeatureType(file);
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
			
			_fs.add(SimpleFeatureBuilder.build(_ft, new Object[] {_w.getCatchmentRegion(), _w.getWaterLevel(), _codes}, null));
//			_fs.add(_ft.create(new Object[] {_w.calculateWaterRegion(), _w.getWaterLevel(), _w.toString()}));
		}
		
		_store.addFeatures(_fs);
	}

	private void writeWaters2(List<WaterTable> waters, File file) throws IOException, FactoryRegistryException, SchemaException, IllegalAttributeException{
		SimpleFeatureType _ft = this.createFeatureType(file);
		(new ShapefileDataStore(file.toURL())).createSchema(_ft);
		
		FeatureStore _store = (FeatureStore) (new ShapefileDataStore(file.toURL())).getFeatureSource();
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		
		for(WaterTable _w : waters){
//			_fs.add(_ft.create(new Object[] {_w.getCatchmentRegion(), _w.getWaterLevel(), _w.toString()}));
			_fs.add(SimpleFeatureBuilder.build(_ft, new Object[] {_w.calculateWaterRegion(), _w.getWaterLevel(), _w.toString()}, null));
		}
		
		_store.addFeatures(_fs);
	}
	
	private SimpleFeatureType createFeatureType(File file) throws FactoryRegistryException, SchemaException{
		SimpleFeatureTypeBuilder _builder = new SimpleFeatureTypeBuilder();
		
		_builder.setName(file.getName());
		
		_builder.add("shape", MultiPolygon.class);
		_builder.add("height", Double.class);
		_builder.add("codes", String.class);
		_builder.length(50);
		
		return _builder.buildFeatureType();
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
