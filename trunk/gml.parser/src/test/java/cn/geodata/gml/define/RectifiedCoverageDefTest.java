package cn.geodata.gml.define;

import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Logger;

import junit.framework.TestCase;

import org.geotools.gce.geotiff.GeoTiffReader;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.opengis.coverage.grid.GridCoverage;

import cn.geodata.gml.ParserUtil;

public class RectifiedCoverageDefTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();

	public void testEncode() throws Exception {
//		File _file = new File("o:\\tank\\lib\\svn-repo\\geotools\\2.4.x\\modules\\plugin\\geotiff\\src\\test\\resources\\org\\geotools\\gce\\geotiff\\test-data\\cir.tif");
//		GeoTiffReader _reader = new GeoTiffReader(_file);
//		
//		GridCoverage _coverage = _reader.read(null);
//		Element _ele = ParserUtil.createParserFinder().encode(_coverage);
//		
//		assertNotNull(_ele);
//		XMLOutputter _output = new XMLOutputter();
//		FileOutputStream _stream = new FileOutputStream(new File("O:\\tank\\tmp\\wps\\grid.xml"));
//		_output.output(_ele, _stream);
//		_stream.close();
	}

}
