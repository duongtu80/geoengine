package cn.geodata.models.util;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import cn.geodata.models.ProcessingFactory;
import cn.geodata.models.geoprocessing.ProcessType;

/**
 * 管理环境中的所有模型，并提供相关的辅助功能
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
	 * 加载ModelLibrary对象
	 * @return
	 */
	public static ProcessingLibray createInstance(){
		if(instance == null){
			instance = new ProcessingLibray(null);
		}
		
		return instance;
	}

	/**
	 * 返回模型库
	 * @return
	 */
	public Map<String, ProcessingFactory> getModelFactories() {
		return models;
	}
}
