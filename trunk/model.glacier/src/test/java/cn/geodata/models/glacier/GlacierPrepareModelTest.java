package cn.geodata.models.glacier;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;
import cn.geodata.models.tools.WfsFeatureSource;
import cn.geodata.models.tools.raster.RasterManager;

public class GlacierPrepareModelTest extends TestCase {

	public void testCalculate() throws Exception {
		WfsFeatureSource _featureSource = new WfsFeatureSource("http://127.0.0.1:48080/geoserver/wfs", "geo:basin");
		CatchmentModel _catchmentModel = new CatchmentModel(_featureSource, "NAME");

		System.out.println(Arrays.toString(_catchmentModel.getCatchmentList().toArray()));
		
		RasterManager _manager = new RasterManager(new File("O:\\tank\\data\\dem\\tiff"), 0);
		GlacierPrepareModel _model = new GlacierPrepareModel(_manager, new WfsFeatureSource("http://127.0.0.1:48080/geoserver/wfs", "geo:glacier"));
				
//		double[] _levels = new double[] {2000, 3000, 4000, 5000, 6000, 8000};
		double _cellSize = 1.0 / (1200 * 4);
		
		Map<Integer, Integer> _areas = _model.calculate(
//				_catchmentModel.getCatchmentPolygon("伊犁河"), 
				_catchmentModel.getCatchmentPolygon("tailang"), 
				_cellSize,
				null
//				new File("d:\\test39.tif")
			);
		
		Integer[] _keys = (Integer[]) _areas.keySet().toArray(new Integer[0]);
		Arrays.sort(_keys);
		
		for(Integer _k : _keys){
			System.out.println(_k.toString() + "\t" + _areas.get(_k).toString());
		}
//		Stack<Param> _stack = new Stack<Param>();
//		
//		Envelope2D _extent = new Envelope2D(null, 79.5, 42, 1.5, 1);
//		Rectangle _rect = new Rectangle(0, 0, 1800 * 2, 1200 * 2);
//		
//		ShapefileDataStore _dataStore = new ShapefileDataStore(new URL("file://o:/tank/doc/2-项目/3.寒旱所/data/geographic/glacier_g.shp"));
//		FeatureSource _featureSource = _dataStore.getFeatureSource();
//
//		SampleModel _sampleModel = new BandedSampleModel(DataBuffer.TYPE_SHORT, (int)_rect.getWidth(), (int)_rect.getHeight(), 1);
//		WritableRaster _raster = Raster.createWritableRaster(_sampleModel, null); //(_sampleModel, null);
//
//		RasterManager _manager = new RasterManager(new File("O:\\tank\\data\\dem\\tiff"), 0);
//		GlacierPrepareModel _model = new GlacierPrepareModel(_manager);
//		_model.calculate(_extent, _rect, _raster, _featureSource);
//		
//		GridCoverage2D _gc = (FactoryFinder.getGridCoverageFactory(GeoTools.getDefaultHints())).create("test", _raster, _extent); // new GridCoverage2D("test", _image, _geo, null, null, null);
////		
//		GeoTiffWriteParams _params = new GeoTiffWriteParams();
//		_params.setCompressionMode(GeoTiffWriteParams.MODE_EXPLICIT);
//		_params.setTilingMode(GeoTiffWriteParams.MODE_EXPLICIT);
//		_params.setTiling(10, 10);
//		
//		GeoTiffFormat _format = new GeoTiffFormat();
//		ParameterValueGroup _pars = _format.getWriteParameters();
//		_pars.parameter(AbstractGridFormat.GEOTOOLS_WRITE_PARAMS.getName().toString()).setValue(_params);
//		
//		File _f = new File("d:\\test37.tif");
//		GeoTiffWriter _writer = (GeoTiffWriter)_format.getWriter(_f, new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE));
//		_writer.write(_gc, (GeneralParameterValue[])_pars.values().toArray(new GeneralParameterValue[0]));
	}
}
