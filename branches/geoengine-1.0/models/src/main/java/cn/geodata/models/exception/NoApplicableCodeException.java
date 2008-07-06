package cn.geodata.models.exception;

import net.opengeospatial.ows.ExceptionType;

public class NoApplicableCodeException extends ProcessingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6985642358754158898L;

	public NoApplicableCodeException(String message, String location){
		super("NoApplicableCode", message, location);
	}
	
	public NoApplicableCodeException(ExceptionType type){
		super(type);
	}
	
	public NoApplicableCodeException(String message){
		this(message, null);
	}

	public NoApplicableCodeException(){
		this(null, null);
	}
}
