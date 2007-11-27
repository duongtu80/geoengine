package cn.geodata.models.web.wps.operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import cn.geodata.model.value.ModelValue;
import cn.geodata.model.value.ValueParser;

public class ExecuteOp extends WpsOperation {

	@Override
	public XmlObject execute(XmlObject input) throws Exception {
		ExecuteDocumentImpl _input = (ExecuteDocumentImpl) input;
		Execute _execute = _input.getExecute();
		
		if(_execute.getStore()){
			throw new OptionNotSupportedException("store");
		}

		String _processId = _execute.getIdentifier().getStringValue();
		ProcessingFactory _model = ProcessingLibray.createInstance().getModelFactories().get(_processId);
		
		Map<String, List<ModelValue>> _inputMap = new HashMap<String, List<ModelValue>>();
		for(IOValueType _identifier : _execute.getDataInputs().getInputArray()){
			String _key = _identifier.getIdentifier().getStringValue();
			if(_inputMap.containsKey(_key) == false){
				_inputMap.put(_key, new ArrayList<ModelValue>());
			}
			
			_inputMap.get(_key).add(ValueParser.parse(_identifier));
		}
		
		Map<String, List<ModelValue>> _outputMap = new HashMap<String, List<ModelValue>>();
		
		GeoProcessing _processing = _model.createProcessing(null);
		_processing.setInputs(_inputMap);
		_processing.setOutputs(_outputMap);
		
		_processing.run();
		
		ExecuteResponseDocument _doc = ExecuteResponseDocument.Factory.newInstance();
		ExecuteResponseType _executeResponse = _doc.addNewExecuteResponse();
		
		_executeResponse.setVersion(WPS.WPS_VERSION);
		_executeResponse.setIdentifier(_execute.getIdentifier());
		
		StatusType _status = _executeResponse.addNewStatus();
		_processing.getStatus().encode(_status);
		
		ProcessOutputs _outputs = _executeResponse.addNewProcessOutputs();
		for(String _outputKey : _processing.getOutput().keySet()){
			for(ModelValue _outputValue : _processing.getOutput().get(_outputKey)){
				_outputValue.encode(_outputs.addNewOutput());
			}
		}
		
		return _doc;
	}

	@Override
	public String getOperationName() {
		return "Execute";
	}

}
