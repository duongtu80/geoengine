package cn.geodata.models.web.wps.operation;

import java.util.ArrayList;
import java.util.List;

import net.opengeospatial.wps.ExecuteResponseDocument;
import net.opengeospatial.wps.ExecuteResponseType;
import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.StatusType;
import net.opengeospatial.wps.ExecuteDocument.Execute;
import net.opengeospatial.wps.ExecuteResponseType.ProcessOutputs;
import net.opengeospatial.wps.impl.ExecuteDocumentImpl;

import org.apache.xmlbeans.XmlObject;

import cn.geodata.model.GeoProcessing;
import cn.geodata.model.ProcessingFactory;
import cn.geodata.model.WPS;
import cn.geodata.model.exception.OptionNotSupportedException;
import cn.geodata.model.util.ProcessingLibray;

public class ExecuteOp extends WpsOperation {

	@Override
	public XmlObject execute(XmlObject input) throws Exception {
		ExecuteDocumentImpl _input = (ExecuteDocumentImpl) input;
		Execute _execute = _input.getExecute();
		
		if(_execute.getStore()){
			throw new OptionNotSupportedException("store");
		}

		//Initialize input parameters
		String _processId = _execute.getIdentifier().getStringValue();
		ProcessingFactory _model = ProcessingLibray.createInstance().getModelFactories().get(_processId);
		
		GeoProcessing _processing = _model.createProcess(null);
		for(IOValueType _inputParam : _execute.getDataInputs().getInputArray()){
			_processing.getInputs().get(_inputParam.getIdentifier().getStringValue()).add(_inputParam);
		}
		
		//Run the model process
		_processing.run();

		//Create the output doc
		ExecuteResponseDocument _doc = ExecuteResponseDocument.Factory.newInstance();
		ExecuteResponseType _executeResponse = _doc.addNewExecuteResponse();
		
		_executeResponse.setVersion(WPS.WPS_VERSION);
		_executeResponse.setIdentifier(_execute.getIdentifier());
		
		StatusType _status = _executeResponse.addNewStatus();
		_processing.getStatus().encode(_status);
		
		List<IOValueType> _outputParams = new ArrayList<IOValueType>();
		ProcessOutputs _outputs = _executeResponse.addNewProcessOutputs();
		for(String _outputKey : _processing.getOutputs().keySet()){
			for(IOValueType _outputValue : _processing.getOutputs().get(_outputKey)){
				_outputParams.add(_outputValue);
			}
		}
		_executeResponse.getProcessOutputs().setOutputArray((IOValueType[])_outputParams.toArray(new IOValueType[0]));
		
		return _doc;
	}

	@Override
	public String getOperationName() {
		return "Execute";
	}

}
