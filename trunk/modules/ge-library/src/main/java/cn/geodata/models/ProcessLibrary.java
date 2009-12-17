package cn.geodata.models;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.UrlResource;

import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;
import cn.geodata.models.exception.ProcessingException;

public class ProcessLibrary {
	private static Logger log = Logger.getLogger(ProcessLibrary.class.getName());
	
	private XmlBeanFactory modelFactory;
	private Map<String, Class> modelList; 
	
	public Map<String, Class> getModelList() {
		return modelList;
	}

	private static ProcessLibrary instance;
	
	public static ProcessLibrary createInstance(){
		if(instance == null){
			instance = new ProcessLibrary();
			try {
				instance.init();
			} catch (IOException e) {
				log.log(Level.WARNING, "Failed to initilize model library", e);
			} catch (ClassNotFoundException e) {
				log.log(Level.WARNING, "Can't find model class", e);
			}
		}
		
		return instance;
	}
	
	private ProcessLibrary(){
	}
	
	public void init() throws IOException, ClassNotFoundException{
		this.modelFactory = this.getModelFactory();
		this.modelList = this.loadModels();
	}
	
	private XmlBeanFactory getModelFactory() throws IOException {
		try {
			return new XmlBeanFactory(new UrlResource(ProcessLibrary.class.getResource("/ge-models.xml").toURI()));
		} catch (BeansException e) {
			log.log(Level.SEVERE, "Failed to load models configure file", e);
		} catch (URISyntaxException e) {
			log.log(Level.SEVERE, "Model configure file url error", e);
		}
		
		throw new IOException("Failed to load model factory");
	}
	
	private Map<String, Class> loadModels() throws IOException, ClassNotFoundException {
		Map<String, Class> _ps = new HashMap<String, Class>();

		String beans[] = modelFactory.getBeanNamesForType(Calculate.class);
		for(String b : beans){
			BeanDefinition d = modelFactory.getBeanDefinition(b);
			Class c = Class.forName(d.getBeanClassName());
			if(!this.isProcessClass(c)){
				log.warning("Model " + b + " has been ignored");
			}
			else{
				_ps.put(b, c);
			}
		}
		
		return _ps;
	}
	
	public String getBean4ProcessId(String procName){
		if(this.modelList.containsKey(procName)){
			return procName;
		}
		
//		for(String _b : this.modelList.keySet()){
//			Class _c = this.modelList.get(_b);
//			
//			if(_c.getSimpleName().equalsIgnoreCase(procName)){
//				return _b;
//			}
//		}
		
		return null;
	}
	
	public Processing createProcess(String id) throws ProcessingException{
		String _bean = this.getBean4ProcessId(id);
		
		if(_bean == null){
			throw new ProcessingException("No model with name " + id);
		}
		
		Calculate _proc = (Calculate) this.modelFactory.getBean(_bean);
		Processing _p = new Processing(_proc, this);
		
		return _p;
	}
	
	public boolean isProcessClass(Class c){
		if(getProcessMetadata(c) != null){
			return true;
		}
		
		return false;
	}
	
	public GeoProcess getProcessMetadata(Class c){
		return (GeoProcess) c.getAnnotation(GeoProcess.class);
	}
	
	public GeoInput getInputMetadata(Method m){
		return (GeoInput) m.getAnnotation(GeoInput.class);
	}
	
	public GeoOutput getOutputMetadata(Method m){
		return (GeoOutput) m.getAnnotation(GeoOutput.class);
	}
	
	public Map<String, Method> getInputs(Class c){
		Map<String, Method> _inputs = new HashMap<String, Method>();
		
		for(Method _m: c.getMethods()){
			GeoInput _i = this.getInputMetadata(_m);
			if(_m.getName().startsWith("set") && _i != null){
				_inputs.put(_m.getName().substring(3), _m);
			}
		}
		
		return _inputs;
	}

	public Map<String, Method> getOutputs(Class c){
		Map<String, Method> _outputs = new HashMap<String, Method>();
		
		for(Method _m: c.getMethods()){
			GeoOutput _i = this.getOutputMetadata(_m);
			if(_m.getName().startsWith("get") && _i != null){
				_outputs.put(_m.getName().substring(3), _m);
			}
		}
		
		return _outputs;
	}

	public Class getInputType(Method m){
		return m.getParameterTypes()[0];
	}
	
	public Class getOutputType(Method m){
		return m.getReturnType();
	}

	public void setInput(Calculate process, String key, Object val) throws ProcessingException{
		if(val == null){
			log.warning("Set null to " + key);
			return;
		}
		
		Map<String, Method> _inputs = this.getInputs(process.getClass());
		if(_inputs.containsKey(key)){
			try {
				_inputs.get(key).invoke(process, val);
			} catch (IllegalArgumentException e) {
				log.log(Level.WARNING, "Failed to set input value to " + key, e);
				throw new ProcessingException("Failed to set input value to " + key);
			} catch (IllegalAccessException e) {
				log.log(Level.WARNING, "Failed to set input value to " + key, e);
				throw new ProcessingException("Failed to set input value to " + key);
			} catch (InvocationTargetException e) {
				log.log(Level.WARNING, "Failed to set input value to " + key, e);
				throw new ProcessingException("Failed to set input value to " + key);
			}
		}
		else{
			throw new ProcessingException("No input parameter " + key + " in " + Arrays.toString(_inputs.keySet().toArray()));
		}
	}

	public void setInput(Processing process, String key, Object val) throws ProcessingException{
		this.setInput(process.getProcess(), key, val);
	}

	public Object getOutput(Calculate process, String key) throws ProcessingException{
		Map<String, Method> _outputs = this.getOutputs(process.getClass());
		if(_outputs.containsKey(key)){
			try {
				return _outputs.get(key).invoke(process);
			} catch (IllegalArgumentException e) {
				log.log(Level.WARNING, "Failed to set output value to " + key, e);
				throw new ProcessingException("Failed to set output value to " + key);
			} catch (IllegalAccessException e) {
				log.log(Level.WARNING, "Failed to set output value to " + key, e);
				throw new ProcessingException("Failed to set output value to " + key);
			} catch (InvocationTargetException e) {
				log.log(Level.WARNING, "Failed to set output value to " + key, e);
				throw new ProcessingException("Failed to set output value to " + key);
			}
		}
		else{
			throw new ProcessingException("No output parameter " + key + " in " + Arrays.toString(_outputs.keySet().toArray()));
		}
	}
	
	public Object getOutput(Processing process, String key) throws ProcessingException{
		return this.getOutput(process.getProcess(), key);
	}
	
	public void executeProcess(Processing proc) throws ProcessingException {
		proc.run();
	}
	
	public void executeProcess(ProcessContainer container, Processing proc){
		container.pushProcess(proc);
		proc.start();
	}
}
