package cn.geodata.models.data.parsers;

import junit.framework.TestCase;

public class GeoTiffComplexParserTest extends TestCase {

	public void testParseAndEncode() throws Exception {
		GeoTiffComplexParser _parser = new GeoTiffComplexParser();
		assertNotNull(_parser.encode(_parser.parse(GeoTiffComplexParserTest.class.getResourceAsStream("/data/ace.tiff"), null, null), null, null));
	}
}
