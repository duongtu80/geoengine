package cn.geodata.models.tools;

import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import org.geotools.coverage.FactoryFinder;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.io.AbstractGridFormat;
import org.geotools.factory.GeoTools;
import org.geotools.factory.Hints;
import org.geotools.gce.geotiff.GeoTiffFormat;
import org.geotools.gce.geotiff.GeoTiffWriteParams;
import org.geotools.gce.geotiff.GeoTiffWriter;
import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.Envelope2D;
import org.geotools.geometry.jts.JTS;
import org.opengis.parameter.GeneralParameterValue;
import org.opengis.parameter.ParameterValueGroup;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Polygon;

public class Utilities {
	public static Envelope2D getEnvelope(Geometry geometry){
		Envelope _polyext = geometry.getEnvelopeInternal();
		Envelope2D _ext = new Envelope2D(new DirectPosition2D(
				_polyext.getMinX(), _polyext.getMinY()),
				new DirectPosition2D(_polyext.getMaxX(), _polyext.getMaxY()));

		return _ext;
	}
	
	public static Polygon covertEnvelope2D(Envelope2D ext){
		Envelope _env = new Envelope(ext.getMinX(), ext.getMaxX(), ext.getMinY(), ext.getMaxY());
		return JTS.toGeometry(_env);
	}
	
	public static void saveRaster(File file, WritableRaster raster, Envelope2D extent) throws IOException{
		GridCoverage2D _gc = (FactoryFinder.getGridCoverageFactory(GeoTools.getDefaultHints())).create("raster", raster, extent); // new GridCoverage2D("test", _image, _geo, null, null, null);
//		
		GeoTiffWriteParams _params = new GeoTiffWriteParams();
		_params.setCompressionMode(GeoTiffWriteParams.MODE_EXPLICIT);
		_params.setTilingMode(GeoTiffWriteParams.MODE_EXPLICIT);
		_params.setTiling(128, 128);
		
		GeoTiffFormat _format = new GeoTiffFormat();
		ParameterValueGroup _pars = _format.getWriteParameters();
		_pars.parameter(AbstractGridFormat.GEOTOOLS_WRITE_PARAMS.getName().toString()).setValue(_params);
		
		GeoTiffWriter _writer = (GeoTiffWriter)_format.getWriter(file, new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE));
		_writer.write(_gc, (GeneralParameterValue[])_pars.values().toArray(new GeneralParameterValue[0]));
	}
}
