

import java.util.logging.Logger;

import cn.geodata.models.web.wps.operation.DescribeProcessOp;


import net.opengeospatial.wps.DescribeProcessDocument;
import net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess;
import net.opengeospatial.wps.impl.DescribeProcessDocumentImpl;
import junit.framework.TestCase;

public class DescribeProcessOpTest extends TestCase {
	private static Logger log = Logger.getAnonymousLogger();

	public void testExecute() throws Exception {
		DescribeProcessDocumentImpl _inputDoc = (DescribeProcessDocumentImpl) DescribeProcessDocument.Factory.newInstance();
		DescribeProcess _process = _inputDoc.addNewDescribeProcess();
		_process.setService("WPS");
		_process.setVersion("0.4.0");
		
		_process.addNewIdentifier().setStringValue("Buffer");
		
		log.info(_inputDoc.toString());
		
		log.info((new DescribeProcessOp()).execute(_inputDoc).toString());
	}
}
