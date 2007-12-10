package cn.geodata.models.value.literal;

import java.io.IOException;
import java.util.logging.Logger;

import junit.framework.TestCase;
import cn.geodata.models.value.ModelValueParserFinder;
import cn.geodata.models.value.ModelValueUtil;

public class IntegerParserTest extends TestCase {
	private Logger log = Logger.getAnonymousLogger();
	
	public void testEncode() throws Exception {
		ModelValueParserFinder _finder = ModelValueUtil.createParserFinder();
		log.info(_finder.getLiteralEncoder().encode(13).xmlText());
	}

	public void testParse() throws IOException {
		ModelValueParserFinder _finder = ModelValueUtil.createParserFinder();
		log.info(_finder.parse(_finder.getLiteralEncoder().encode(13)).toString());
	}
}
