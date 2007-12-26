package cn.geodata.models.data.parsers;

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

import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.data.ComplexParser;
import cn.geodata.models.util.Utilities;

public class GeoTiffComplexParser implements ComplexParser {
	private static Logger log = Utilities.getLogger();

	@Override
	public List<DataCategory> getCategories() {
		DataCategories _c = DataCategories.getInstance();
		
		List<DataCategory> _list = new ArrayList<DataCategory>();
		_list.add(_c.findCategory("coverage"));
		
		return _list;
	}

	@Override
	public List<MimeType> getMimes() {
		try {
			return Arrays.asList(new MimeType[]{new MimeType("image/tiff"), new MimeType("geotiff")});
		} catch (MimeTypeParseException e) {
			log.log(Level.WARNING, "Failed to create MIME list", e);
			return null;
		}
	}

	@Override
	public Object parse(InputStream stream, MimeType mime,
			Map<String, Object> params) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream encode(Object obj, MimeType mime,
			Map<String, Object> params) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
