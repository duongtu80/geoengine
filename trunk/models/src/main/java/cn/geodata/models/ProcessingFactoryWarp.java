package cn.geodata.models;

import java.util.Map;

import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.ExecuteDocument.Execute;
import cn.geodata.models.util.ProcessingLibray;

public class ProcessingFactoryWarp {
	
	/**
	 * Find and create a new processing 
	 * 
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public ProcessingWrap createProcess(Execute request, Map<String, String> params) throws Exception {
		//Initialize input parameters
		String _processId = request.getIdentifier().getStringValue();
		
		ProcessingFactory _model = ProcessingLibray.createInstance().getModelFactories().get(_processId);
		
		ProcessDescriptionType _metadata = _model.getMetadata();
		Processing _process = _model.createProcessing(params);
		
		return new ProcessingWrap(_process, _metadata, request);
	}
}
