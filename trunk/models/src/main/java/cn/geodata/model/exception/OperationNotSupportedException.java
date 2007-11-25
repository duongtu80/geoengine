package cn.geodata.model.exception;

import net.opengeospatial.ows.ExceptionType;

public class OperationNotSupportedException extends ProcessingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4154300646440402788L;
	
	public OperationNotSupportedException(String message, String location){
		super("OperationNotSupported", message, location);
	}
	
	public OperationNotSupportedException(ExceptionType type){
		super(type);
	}
	
	public OperationNotSupportedException(String message){
		this(message, null);
	}

	public OperationNotSupportedException(){
		this(null, null);
	}
}
