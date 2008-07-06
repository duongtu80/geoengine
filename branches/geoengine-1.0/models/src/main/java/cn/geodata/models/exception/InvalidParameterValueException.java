package cn.geodata.models.exception;

import net.opengeospatial.ows.ExceptionType;

public class InvalidParameterValueException extends ProcessingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5540825643754103002L;

	public InvalidParameterValueException(String message, String location){
		super("InvalidParameterValue", message, location);
	}
	
	public InvalidParameterValueException(ExceptionType type){
		super(type);
	}

	public InvalidParameterValueException(String message){
		this(message, null);
	}

	public InvalidParameterValueException(){
		this(null, null);
	}
}
