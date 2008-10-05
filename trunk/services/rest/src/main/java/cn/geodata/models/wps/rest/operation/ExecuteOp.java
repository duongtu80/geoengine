package cn.geodata.models.wps.rest.operation;

import java.util.logging.Logger;

import net.opengis.wps.x100.ExecuteDocument;

import org.apache.xmlbeans.XmlObject;

import cn.geodata.models.ProcessContainer;
import cn.geodata.models.wps.WPSException;
import cn.geodata.models.wps.WPSOperations;
import cn.geodata.models.wps.rest.util.Util;

public class ExecuteOp extends WpsOperation {
	private static Logger log = Logger.getLogger("cn.geodata.models.web");

	@Override
	public XmlObject execute(ProcessContainer processes, XmlObject input) throws WPSException {
		WPSOperations _op = new WPSOperations(processes, Util.getInstance().getConfig());
		
		return _op.execute((ExecuteDocument) input);
	}

	@Override
	public String getOperationName() {
		return "Execute";
	}
}
