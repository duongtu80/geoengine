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
import cn.geodata.models.ProcessingFactoryWarp;
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
		ProcessingWrap _processWrap = (new ProcessingFactoryWarp()).createProcess(_execute, null);

		//Run the model process
		_processWrap.run();

		//Create the output doc
		ExecuteResponseDocument _doc = ExecuteResponseDocument.Factory.newInstance();
		ExecuteResponseType _response = _doc.addNewExecuteResponse();
		
		_response.setVersion(WPS.WPS_VERSION);
		_response.setIdentifier(_execute.getIdentifier());
		
		StatusType _status = _response.addNewStatus();
		_processWrap.getStatus().encode(_status);
		
		ProcessOutputs _outputs = _response.addNewProcessOutputs();
		List<IOValueType> _outputParams = new ArrayList<IOValueType>();
		for(String _outputKey : _processWrap.getProcess().getOutputs().keySet()){
			for(IOValueType _outputValue : _processWrap.getProcess().getOutputs().get(_outputKey)){
				_outputParams.add(_outputValue);
			}
		}
		_outputs.setOutputArray((IOValueType[])_outputParams.toArray(new IOValueType[0]));
		
		return _doc;
	}

	@Override
	public String getOperationName() {
		return "Execute";
	}

}
