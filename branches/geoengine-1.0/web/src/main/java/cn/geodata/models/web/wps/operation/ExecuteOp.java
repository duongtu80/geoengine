package cn.geodata.models.web.wps.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import net.opengeospatial.wps.ExecuteResponseDocument;
import net.opengeospatial.wps.ExecuteResponseType;
import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.StatusType;
import net.opengeospatial.wps.ExecuteDocument.Execute;
import net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs;
import net.opengeospatial.wps.impl.ExecuteDocumentImpl;

import org.apache.xmlbeans.XmlObject;

import cn.geodata.models.ProcessingFactory;
import cn.geodata.models.ProcessingFactoryWrap;
import cn.geodata.models.ProcessingWrap;
import cn.geodata.models.WPS;
import cn.geodata.models.exception.OptionNotSupportedException;
import cn.geodata.models.util.ProcessingLibray;

public class ExecuteOp extends WpsOperation {
	private static Logger log = Logger.getLogger("cn.geodata.models.web");

	@Override
	public XmlObject execute(XmlObject input) throws Exception {
		ExecuteDocumentImpl _input = (ExecuteDocumentImpl) input;
		Execute _execute = _input.getExecute();

		//Create process
		ProcessingWrap _processWrap = (new ProcessingFactoryWrap()).createProcess(_execute, null);

		//Run the model process
		_processWrap.run();

		//Create the output doc
		return _processWrap.createReponse();
	}

	@Override
	public String getOperationName() {
		return "Execute";
	}

}
