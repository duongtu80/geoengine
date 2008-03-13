package cn.geodata.models;

import java.io.IOException;
import java.util.Map;

import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.ExecuteDocument.Execute;
import net.opengeospatial.wps.ProcessDescriptionsDocument.ProcessDescriptions;
import cn.geodata.models.geoprocessing.ProcessType;
import cn.geodata.models.geoprocessing.ModelType;
import cn.geodata.models.util.ProcessingLibray;

public class ProcessingFactoryWrap {
	
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
		String[] _parts = request.getIdentifier().getStringValue().split("\\.");
		
		ProcessingFactory _model = ProcessingLibray.createInstance().getModelFactories().get(_parts[0]);
		ProcessType _metadata = this.getProcessMetadata(_parts[1], _model.getMetadata());
		Processing _process = _model.createProcessing(_parts[1], params);
		
		return new ProcessingWrap(_process, _metadata, request);
	}
	
	public ProcessType getProcessMetadata(String identify, ModelType metadata) throws IOException{
		for(ProcessType _p : metadata.getProcessArray()){
			if(_p.getId().equals(identify)){
				return _p;
			}
		}
		
		throw new IOException("Not found metadata for " + identify);
	}
}
