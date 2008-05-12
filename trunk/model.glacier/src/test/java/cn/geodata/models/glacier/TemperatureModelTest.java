package cn.geodata.models.glacier;

import java.awt.Transparency;
import java.awt.image.BandedSampleModel;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.awt.image.WritableRenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.RasterFactory;
import javax.media.jai.RenderableImageAdapter;
import javax.media.jai.RenderedOp;
import javax.media.jai.TiledImage;

import org.geotools.coverage.FactoryFinder;
import org.geotools.coverage.GridSampleDimension;
import org.geotools.coverage.grid.AbstractGridCoverage;
import org.geotools.coverage.grid.GeneralGridGeometry;
import org.geotools.coverage.grid.GeneralGridRange;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.GridCoverageFactory;
import org.geotools.coverage.grid.GridGeometry2D;
import org.geotools.coverage.grid.io.AbstractGridFormat;
import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.factory.Hints;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.gce.geotiff.GeoTiffFormat;
import org.geotools.gce.geotiff.GeoTiffWriteParams;
import org.geotools.gce.geotiff.GeoTiffWriter;
import org.geotools.geometry.Envelope2D;
import org.geotools.geometry.GeneralEnvelope;
import org.geotools.referencing.CRS;
import org.geotools.referencing.operation.builder.MathTransformBuilder;
import org.geotools.util.GeometryConverterFactory;
import org.opengis.coverage.SampleDimension;
import org.opengis.coverage.grid.GridCoverage;
import org.opengis.coverage.grid.GridRange;
import org.opengis.filter.FilterFactory2;
import org.opengis.filter.spatial.BBOX;
import org.opengis.filter.spatial.Contains;
import org.opengis.geometry.BoundingBox;
import org.opengis.geometry.Envelope;
import org.opengis.metadata.Datatype;
import org.opengis.parameter.GeneralParameterValue;
import org.opengis.parameter.ParameterValueGroup;
import org.opengis.referencing.operation.MathTransform2D;

import com.sun.media.jai.codecimpl.SingleTileRenderedImage;
import com.sun.media.jai.iterator.WrapperWRI;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.util.GeometryTransformer;
import com.vividsolutions.jts.operation.overlay.snap.GeometrySnapper;

import junit.framework.TestCase;

public class TemperatureModelTest extends TestCase {
	public void atestCalculate() throws Exception {
//		Configure _configure = new Configure();
//		
//		CatchmentModel _cat = new CatchmentModel();
//		_cat.setCatchmentId("tailang");
//		_cat.setConfigure(_configure);
//		
//		TemperatureModel _model = new TemperatureModel();
//		
//		_model.setConfigure(_configure);
//		_model.setPoint(_cat.getCenterPoint(_cat.getCatchment()));
//		_model.setMaxCount(10);
//		_model.setMaxDistance(20);
//		_model.setDate(new Date(1980, 1, 1));
//		
//		System.out.println("Value:" + _model.calculate());
	}
	
//	public void testTest3() throws Exception {
//		GeoTiffFormat _format = new GeoTiffFormat();
//		
//		GridCoverage2D _grid = (GridCoverage2D) _format.getReader(new File("d:\\test27.tif")).read(null);
//		System.out.println(Arrays.toString(_grid.getGridGeometry().getGridRange().getLowers()));
//		System.out.println(Arrays.toString(_grid.getGridGeometry().getGridRange().getUppers()));
//		
//		System.out.println(_grid.getRenderedImage() + "," + _grid.getRenderedImage().getTileGridYOffset());
//		
//		System.out.println(_grid.getRenderedImage().getTile(0, 0).getSample(1, 0, 0));
//	}
//	
	public void atestTest3() throws Exception {
		Envelope _userRange = new Envelope2D(CRS.decode("EPSG:4326"), 79.5, 42, 1.5, 1);

		GridCoverage2D _gc = (FactoryFinder.getGridCoverageFactory(GeoTools.getDefaultHints())).create("test", new float[][] {{1, 2}, {3, 4}}, _userRange); // new GridCoverage2D("test", _image, _geo, null, null, null);
//		GridCoverage2D _gc = (FactoryFinder.getGridCoverageFactory(GeoTools.getDefaultHints())).create("test", _raster, _geom, null, null, null, null); // new GridCoverage2D("test", _image, _geo, null, null, null);
		
		System.out.println("Tile:" + _gc.getRenderedImage().getNumXTiles() + "," + _gc.getRenderedImage().getNumYTiles());
		Raster _r = _gc.getRenderedImage().getTile(0, 0);
		
		GeoTiffWriteParams _params = new GeoTiffWriteParams();
		_params.setCompressionMode(GeoTiffWriteParams.MODE_EXPLICIT);
		_params.setTilingMode(GeoTiffWriteParams.MODE_EXPLICIT);
		_params.setTiling(10, 10);
		
		GeoTiffFormat _format = new GeoTiffFormat();
		ParameterValueGroup _pars = _format.getWriteParameters();
		_pars.parameter(AbstractGridFormat.GEOTOOLS_WRITE_PARAMS.getName().toString()).setValue(_params);
		
		File _f = new File("d:\\test27.tif");
		GeoTiffWriter _writer = (GeoTiffWriter)_format.getWriter(_f, new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE));
		_writer.write(_gc, null);// (GeneralParameterValue[])_pars.values().toArray(new GeneralParameterValue[0]));
		
		_gc = (GridCoverage2D) _format.getReader(_f, new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE)).read(null);
		System.out.println(_gc.getRenderedImage().getNumXTiles() + "," + _gc.getRenderedImage().getNumYTiles());
		System.out.println("aa:" + _gc.getRenderedImage().getTile(0, 0).getSample(1, 0, 0));
	}
	
	public void testTest2() throws Exception {
		ShapefileDataStore _dataStore = new ShapefileDataStore(new URL("file://o:/tank/doc/2-ÏîÄ¿/3.º®ºµËù/data/geographic/glacier_g.shp"));
		FeatureSource _featureSource = _dataStore.getFeatureSource();
		
		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		BBOX _box = _factory.bbox(_factory.property(_featureSource.getSchema().getDefaultGeometry().getLocalName()), 79.5, 42, 81, 43, null);
		
		FeatureCollection _fs = _featureSource.getFeatures(_box);
		System.out.println("Count:" + _fs.size());
		
		int _rowCount = 12;
		int _colCount = 18;
		
		GeometryFactory _geometryFactory = new GeometryFactory();
		SampleModel _sampleModel = new BandedSampleModel(DataBuffer.TYPE_BYTE, _colCount, _rowCount, 1);
		
		WritableRaster _raster = Raster.createWritableRaster(_sampleModel, null); //(_sampleModel, null);
		
		double _y = 43;
		for(int _row=0;_row < _rowCount;_row++){
			System.out.println("Row:" + _row);
			double _x = 79.5;
			for(int _col=0;_col < _colCount; _col++){
				_raster.setSample(_col, _row, 0, 0);

//				Point _pt = _geometryFactory.createPoint(new Coordinate(_x, _y));
//				System.out.println("Location:" + _x + "," + _y);
			
//				Contains _filter2 = _factory.contains(_factory.property(_featureSource.getSchema().getDefaultGeometry().getLocalName()), _factory.literal(_pt));
				BBOX _filter2 = _factory.bbox(_factory.property(_featureSource.getSchema().getDefaultGeometry().getLocalName()), _x, _y - 1.0/_rowCount, _x + 1.5/_colCount, _y, null);
				FeatureCollection _fs2 = _featureSource.getFeatures(_filter2);
				
				if(_fs2.size() > 0){
					System.out.println("found");
					_raster.setSample(_col, _row, 0, 100);
				}
//				FeatureIterator _it = _fs.features();
//				try{
//					while(_it.hasNext()){
//						if(_it.next().getDefaultGeometry().contains(_pt)){
//							System.out.println("found.");
//							_raster.setSample(_col, _row, 0, 100);
//							break;
//						}
//					}
//				}
//				finally{
//					if(_it != null){
//						_it.close();
//					}
//				}
				
				_x += 1.5 / _colCount;
			}
			_y -= 1.0 / _rowCount;
		}	

		Envelope _userRange = new Envelope2D(null, 79.5, 42, 1.5, 1);

		GridCoverage2D _gc = (FactoryFinder.getGridCoverageFactory(GeoTools.getDefaultHints())).create("test", _raster, _userRange); // new GridCoverage2D("test", _image, _geo, null, null, null);
//		
		GeoTiffWriteParams _params = new GeoTiffWriteParams();
		_params.setCompressionMode(GeoTiffWriteParams.MODE_EXPLICIT);
		_params.setTilingMode(GeoTiffWriteParams.MODE_EXPLICIT);
		_params.setTiling(10, 10);
		
		GeoTiffFormat _format = new GeoTiffFormat();
		ParameterValueGroup _pars = _format.getWriteParameters();
		_pars.parameter(AbstractGridFormat.GEOTOOLS_WRITE_PARAMS.getName().toString()).setValue(_params);
		
		File _f = new File("d:\\test29.tif");
		GeoTiffWriter _writer = (GeoTiffWriter)_format.getWriter(_f, new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE));
		_writer.write(_gc, (GeneralParameterValue[])_pars.values().toArray(new GeneralParameterValue[0]));
	}

	public void atestCreateAPI() throws Exception {		
		ParameterBlock _ps = new ParameterBlock();
		_ps.add((float)200);
		_ps.add((float)100);
		_ps.add(new Short[]{new Short((short)-10)});
		
		
		SampleModel _sampleModel = new BandedSampleModel(DataBuffer.TYPE_SHORT, 2, 5, 2);
		WritableRaster _raster = Raster.createWritableRaster(_sampleModel , null);
		
		_raster.setPixel(0, 0, new int[]{200, 300});
		_raster.setPixel(0, 1, new int[]{3000, 200});
		_raster.setPixel(0, 2, new int[]{100, 100});
		_raster.setPixel(0, 3, new int[]{40000, 0});
		
		PlanarImage _image = JAI.create("constant", _ps);
		
		GeoTiffWriter _writer = new GeoTiffWriter(new File("d:\\test17.tif"));
	
//		WritableRaster _raster = new WritableRaster()
		
		GridRange _gridRange = new GeneralGridRange(new int[] {0, 0}, new int[] {200, 100});
		Envelope _userRange = new Envelope2D(CRS.decode("EPSG:4326"), 82.5, 40, 1.5, 1);
		
		GridGeometry2D _geo = new GridGeometry2D(_gridRange, _userRange);
		GridCoverage2D _gc = (new GridCoverageFactory()).create("test", _raster, _userRange); // new GridCoverage2D("test", _image, _geo, null, null, null);
//		GridCoverage2D _gc = (new GridCoverageFactory()).create("test", new float[][] {new float[] {2, 3, 4}, new float[] {2, 2, 4}}, _userRange); // new GridCoverage2D("test", _image, _geo, null, null, null);
		
		GeoTiffWriteParams _params = new GeoTiffWriteParams();
		_params.setCompressionMode(GeoTiffWriteParams.MODE_EXPLICIT);
		_params.setTilingMode(GeoTiffWriteParams.MODE_EXPLICIT);
		_params.setTiling(10, 10);
		
		GeoTiffFormat _format = new GeoTiffFormat();
		ParameterValueGroup _pars = _format.getWriteParameters();
		_pars.parameter(AbstractGridFormat.GEOTOOLS_WRITE_PARAMS.getName().toString()).setValue(_params);
		
//		GeneralParameterValue[] _params;
		_writer.write(_gc, (GeneralParameterValue[])_pars.values().toArray(new GeneralParameterValue[0]));
	}
}
