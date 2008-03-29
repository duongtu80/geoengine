package cn.geodata.models.data.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.geotools.coverage.grid.io.AbstractGridFormat;
import org.geotools.coverage.grid.io.imageio.GeoToolsWriteParams;
import org.geotools.factory.Hints;
import org.geotools.gce.geotiff.GeoTiffFormat;
import org.geotools.gce.geotiff.GeoTiffWriteParams;
import org.opengis.coverage.grid.GridCoverage;
import org.opengis.coverage.grid.GridCoverageWriter;
import org.opengis.parameter.GeneralParameterValue;
import org.opengis.parameter.ParameterValueGroup;

import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.data.ComplexParser;
import cn.geodata.models.data.Utilities;

public class GeoTiffComplexParser implements ComplexParser {
	private static Logger log = Utilities.getLogger();

	public List<DataCategory> getCategories() {
		DataCategories _c = DataCategories.getInstance();
		
		List<DataCategory> _list = new ArrayList<DataCategory>();
		_list.add(_c.findCategory("coverage"));
		
		return _list;
	}

	public List<MimeType> getMimes() {
		try {
			return Arrays.asList(new MimeType[]{new MimeType("image/tiff"), new MimeType("geotiff")});
		} catch (MimeTypeParseException e) {
			log.log(Level.WARNING, "Failed to create MIME list", e);
			return null;
		}
	}

	public Object parse(InputStream stream, MimeType mime,
			Map<String, Object> params) throws IOException {
		File _file = cn.geodata.models.data.Utilities.createTempFile();
		IOUtils.copy(stream, FileUtils.openOutputStream(_file));
		
		GeoTiffFormat _format = new GeoTiffFormat();
		return _format.getReader(_file, new
				Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE)).read(null);
	}

	public InputStream encode(Object obj, MimeType mime,
			Map<String, Object> params) throws IOException {
		File _file = cn.geodata.models.data.Utilities.createTempFile();
		
		GeoTiffFormat _format = new GeoTiffFormat();

		GeoTiffWriteParams _wp = new GeoTiffWriteParams();
//		wp.setCompressionMode(GeoTiffWriteParams.MODE_EXPLICIT);
//		wp.setCompressionType("ZLib");
//		wp.setCompressionQuality(0.75F);
		_wp.setTilingMode(GeoToolsWriteParams.MODE_EXPLICIT);
		_wp.setTiling(256, 256);
		
		final ParameterValueGroup _params = _format.getWriteParameters();
		_params.parameter(
				AbstractGridFormat.GEOTOOLS_WRITE_PARAMS.getName().toString())
				.setValue(_wp);

		GridCoverageWriter _writer = _format.getWriter(_file);
		_writer.write((GridCoverage)obj, (GeneralParameterValue[])_params.values().toArray(new GeneralParameterValue[0]));
		
		return new FileInputStream(_file);
	}
}
