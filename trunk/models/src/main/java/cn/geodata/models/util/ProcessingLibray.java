package cn.geodata.models.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.geodata.models.ProcessingFactory;
import cn.geodata.models.geoprocessing.ProcessType;

/**
 * Manages models, and provides related functions
 * @author Fengm
 *
 */
public class ProcessingLibray {
	private static ProcessingLibray instance;
	
	private Map<String, ProcessingFactory> models;
	private Map<String, ProcessType> metadata;
	
	private ProcessingLibray(Map<String, String> params) {
		this.models = new HashMap<String, ProcessingFactory>();
		this.metadata = new HashMap<String, ProcessType>();
		
		List<ProcessingFactory> _list = ProcessingFactoryFinder.newInstance().loadModelFactories(params);
		for(ProcessingFactory _m : _list){
			for(ProcessType _p : _m.getMetadata().getProcessArray()){
				models.put(_p.getId(), _m);
				metadata.put(_p.getId(), _p);
			}
		}
	}
	
	public Map<String, ProcessType> getMetadata() {
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
}
