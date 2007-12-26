package cn.geodata.models.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.geotools.factory.FactoryRegistry;

import cn.geodata.models.ProcessingFactory;

/**
 * Factory finder
 * @author Fengm
 *
 */
public class ProcessingFactoryFinder {
	private FactoryRegistry register;
	
	public ProcessingFactoryFinder() {
		
	}
	
	/**
	 * Find model factories by condition
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
	 * Load all model factories
	 * @return
	 */
	private FactoryRegistry getFactoryRegister() {
		if(this.register == null){
			this.register = new FactoryRegistry(Arrays.asList(new Class[]{ProcessingFactory.class}));
		}
		return this.register;
	}
	
	/**
	 * List all model factories
	 * 
	 * @return
	 */
	public Iterator<ProcessingFactory> listFactories() {
		return this.getFactoryRegister().getServiceProviders(ProcessingFactory.class, null, null);
	}

}
