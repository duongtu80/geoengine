package cn.geodata.model.exception;

import net.opengeospatial.ows.ExceptionType;

public class InvalidUpdateSequenceException extends ProcessingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4090465653010212958L;

	public InvalidUpdateSequenceException(String message, String location){
		super("InvalidUpdateSequence", message, location);
	}
	
	public InvalidUpdateSequenceException(ExceptionType type){
		super(type);
	}
	
	public InvalidUpdateSequenceException(String message){
		this(message, null);
	}

	public InvalidUpdateSequenceException(){
		this(null, null);
	}
}
