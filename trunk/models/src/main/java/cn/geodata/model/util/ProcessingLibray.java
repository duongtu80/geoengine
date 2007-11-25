package cn.geodata.model.util;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import cn.geodata.model.ProcessingFactory;

/**
 * 管理环境中的所有模型，并提供相关的辅助功能
 * @author Fengm
 *
 */
public class ProcessingLibray {
	private static ProcessingLibray instance;
	
	private Map<String, ProcessingFactory> models;
	
	private ProcessingLibray(Map<String, String> params) {
		this.models = new Hashtable<String, ProcessingFactory>();
		
		List<ProcessingFactory> _list = ProcessingFactoryFinder.newInstance().loadModelFactories(params);
		for(ProcessingFactory _m : _list){
			models.put(_m.getIdentifier(), _m);
		}
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
