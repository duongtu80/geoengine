package cn.geodata.models;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.logging.Logger;

import cn.geodata.models.geoprocessing.ProcessType;
import cn.geodata.models.geoprocessing.ValueType;

/**
 * 
 * @author Fengm
 * 
 */
public abstract class AbstractProcessing implements Processing, ParameterAware,
		MetadataAware, ParameterDefinitionAware, StatusAware {
	private static Logger log = Logger.getLogger(AbstractProcessing.class.getName());
	protected ProcessType metadata;

	protected Map<String, ValueType> outputDefinitions;
	protected Map<String, ValueType> inputDefinitions;

//	protected Map<String, List<IOValueType>> rawInputs;
//	protected Map<String, List<IOValueType>> rawOutputs;
//
	protected Map<String, Object> inputs;
	protected Map<String, Object> outputs;

	public Map<String, Object> getInputs() {
		return this.inputs;
	}

	public Map<String, Object> getOutputs() {
		return this.outputs;
	}

	public void setInputs(Map<String, Object> inputs) {
		this.inputs = inputs;
	}

	public void setOutputs(Map<String, Object> outputs) {
		this.outputs = outputs;
	}

//	@Override
//	public Map<String, List<IOValueType>> getRawInputs() {
//		return rawInputs;
//	}
//
//	@Override
//	public Map<String, List<IOValueType>> getRawOutputs() {
//		return rawOutputs;
//	}
//
//	@Override
//	public void setRawInputs(Map<String, List<IOValueType>> rawInputs) {
//		this.rawInputs = rawInputs;
//	}
//
//	@Override
//	public void setRawOutputs(Map<String, List<IOValueType>> rawOutputs) {
//		this.rawOutputs = rawOutputs;
//	}
//
	public void setMetadata(ProcessType metadata) {
		this.metadata = metadata;
	}

	public void setInputDefinitions(Map<String, ValueType> inputDefinitions) {
		this.inputDefinitions = inputDefinitions;
	}

	public void setOutputDefinitions(Map<String, ValueType> outputDefinitions) {
		this.outputDefinitions = outputDefinitions;
	}

	private Method findInputMethod(String name){
		for(Method _m : this.getClass().getDeclaredMethods()){
			if(("set" + name).equalsIgnoreCase(_m.getName()) && _m.getDeclaringClass().equals(AbstractProcessing.class) == false){
				return _m;
			}
		}
		
		return null;
	}
	
	protected void initializeInputs() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		for(String _key : this.getInputs().keySet()){
			Method _m = this.findInputMethod(_key);
			if(_m != null){
				_m.invoke(this, this.getInputs().get(_key));
				log.info("Set " + _key + ":" + this.getInputs().get(_key));
			}
		}
	}
}
