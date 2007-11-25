package cn.geodata.model.exception;

import net.opengeospatial.ows.ExceptionType;

public class VersionNegotiationFailedException extends ProcessingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1270838947462352602L;

	public VersionNegotiationFailedException(String message, String location){
		super("VersionNegotiationFailed", message, location);
	}
	
	public VersionNegotiationFailedException(ExceptionType type){
		super(type);
	}
	
	public VersionNegotiationFailedException(String message){
		this(message, null);
	}

	public VersionNegotiationFailedException(){
		this(null, null);
	}
}
