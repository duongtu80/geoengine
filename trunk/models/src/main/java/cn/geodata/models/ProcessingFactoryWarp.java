package cn.geodata.models;

import java.io.IOException;
import java.util.Map;

import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.ExecuteDocument.Execute;
import net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions;
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
		
		ProcessDescriptionType _metadata = this.getProcessMetadata(_processId, _model.getMetadata());
		Processing _process = _model.createProcessing(_processId, params);
		
		return new ProcessingWrap(_process, _metadata, request);
	}
	
	public ProcessDescriptionType getProcessMetadata(String identify, ProcessDescriptions metadata) throws IOException{
		for(ProcessDescriptionType _p : metadata.getProcessDescriptionArray()){
			if(_p.getIdentifier().getStringValue().equals(identify)){
				return _p;
			}
		}
		
		throw new IOException("Not found metadata for " + identify);
	}
}
