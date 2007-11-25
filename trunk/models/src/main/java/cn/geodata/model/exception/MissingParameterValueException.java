package cn.geodata.model.exception;

import net.opengeospatial.ows.ExceptionType;

public class MissingParameterValueException extends ProcessingException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7488022287873483544L;

	public MissingParameterValueException(String message, String location){
		super("MissingParameterValue", message, location);
	}
	
	public MissingParameterValueException(ExceptionType type){
		super(type);
	}
	
	public MissingParameterValueException(String message){
		this(message, null);
	}

	public MissingParameterValueException(){
		this(null, null);
	}
}
