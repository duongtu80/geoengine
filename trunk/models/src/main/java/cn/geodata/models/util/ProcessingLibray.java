package cn.geodata.models.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.geodata.models.ProcessingFactory;
import cn.geodata.models.geoprocessing.ModelType;
import cn.geodata.models.geoprocessing.ProcessType;

/**
 * Manages models, and provides related functions
 * @author Fengm
 *
 */
public class ProcessingLibray {
	private static ProcessingLibray instance;
	
	private Map<String, ProcessingFactory> models;
	private Map<String, ModelType> metadata;
	
	private ProcessingLibray(Map<String, String> params) {
		this.models = new HashMap<String, ProcessingFactory>();
		this.metadata = new HashMap<String, ModelType>();
		
		List<ProcessingFactory> _list = new ProcessingFactoryFinder().loadModelFactories(params);
		for(ProcessingFactory _m : _list){
			ModelType _modelMetadata = _m.getMetadata();
			
			models.put(_modelMetadata.getId(), _m);
			metadata.put(_modelMetadata.getId(), _modelMetadata);
		}
	}
	
	public Map<String, ModelType> getMetadata() {
		return metadata;
	}

	/**
	 * Load ModelLibrary
	 * @return
	 */
	public static ProcessingLibray createInstance(){
		if(instance == null){
			instance = new ProcessingLibray(null);
		}
		
		return instance;
	}

	/**
	 * 
	 * @return Model factories
	 */
	public Map<String, ProcessingFactory> getModelFactories() {
		return models;
	}
	
	public ProcessType findProcessMetadata(ModelType model, String procId){
		for(ProcessType _p : model.getProcessArray()){
			if(_p.getId().equalsIgnoreCase(procId)){
				return _p;
			}
		}
		return null;
	}
}
