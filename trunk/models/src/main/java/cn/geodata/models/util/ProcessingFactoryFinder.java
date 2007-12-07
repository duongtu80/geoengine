package cn.geodata.models.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.geotools.factory.FactoryRegistry;

import cn.geodata.models.ProcessingFactory;

/**
 * 工厂搜索类
 * @author Fengm
 *
 */
public class ProcessingFactoryFinder {
	private static ProcessingFactoryFinder instance = null;
	private FactoryRegistry register;
	
	public ProcessingFactoryFinder() {
		
	}
	
	/**
	 * 创建/加载全局唯一工厂查找类
	 * @return
	 */
	public static ProcessingFactoryFinder newInstance() {
		if(instance == null){
			instance = new ProcessingFactoryFinder();
		}
		
		return instance;
	}
	
	/**
	 * 加载所有模型
	 * @param params
	 * @return
	 */
	public List<ProcessingFactory> loadModelFactories(Map<String, String> params){
		ArrayList<ProcessingFactory> _list = new ArrayList<ProcessingFactory>();
		for(Iterator<ProcessingFactory> _it = this.listFactories(); _it.hasNext();){
			ProcessingFactory _factory = _it.next();
			_list.add(_factory);
		}
		
		return _list;
	}
	
	/**
	 * 加载所有模型工厂
	 * @return
	 */
	private FactoryRegistry getFactoryRegister() {
		if(this.register == null){
			this.register = new FactoryRegistry(Arrays.asList(new Class[]{ProcessingFactory.class}));
		}
		return this.register;
	}
	
	/**
	 * 获取所有模型工厂
	 * 
	 * @return
	 */
	public Iterator<ProcessingFactory> listFactories() {
		return this.getFactoryRegister().getServiceProviders(ProcessingFactory.class, null, null);
	}

}
