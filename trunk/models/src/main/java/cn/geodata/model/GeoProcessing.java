package cn.geodata.model;

import java.util.List;
import java.util.Map;

import net.opengeospatial.wps.IOValueType;

import org.apache.log4j.Logger;

import cn.geodata.model.exception.NoApplicableCodeException;
import cn.geodata.model.exception.ProcessingException;
import cn.geodata.model.status.ProcessAccepted;
import cn.geodata.model.status.ProcessFailed;
import cn.geodata.model.status.ProcessSucceeded;
import cn.geodata.model.status.Status;
import cn.geodata.model.value.ModelValue;

/**
 * 可调用进程的父类
 * @author Fengm
 *
 */
public abstract class GeoProcessing implements Runnable {
	private static Logger Log = Logger.getLogger(GeoProcessing.class);
	
	private Map<String, List<IOValueType>> inputs;
	private Map<String, List<IOValueType>> output;
	
	private Status Status;
	
	public Map<String, List<IOValueType>> getInputs() {
		return inputs;
	}

	/**
	 * 设置输入参数
	 * @param inputs
	 */
	public void setInputs(Map<String, List<IOValueType>> inputs) {
		this.inputs = inputs;
	}

	/**
	 * 获取输出参数
	 * @return
	 */
	public Map<String, List<IOValueType>> getOutput() {
		return output;
	}

	/**
	 * 设置输出参数
	 * @param output
	 */
	public void setOutputs(Map<String, List<IOValueType>> output) {
		this.output = output;
	}

	/**
	 * 获取进度信息
	 * @return
	 */
	public Status getStatus() {
		return Status;
	}

	/**
	 * 设置进度信息
	 * @param status
	 */
	public void setStatus(Status status) {
		Status = status;
	}

	/**
	 * 执行进程
	 */
	protected abstract void execute() throws Exception;

	@Override
	public void run() {
		try{
			this.Status = new ProcessAccepted();
			//启动进程
			this.execute();
			this.Status = new ProcessSucceeded();			
		}
		catch(ProcessingException err){
			Log.error("过程执行失败", err);
			this.Status = new ProcessFailed(err);
		}
		catch(Exception err){
			Log.error("过程执行失败", err);
			this.Status = new ProcessFailed(new NoApplicableCodeException(err.getMessage()));			
		}
	}
}
