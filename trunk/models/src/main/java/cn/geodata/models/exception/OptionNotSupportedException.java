package cn.geodata.models.exception;

import net.opengeospatial.ows.ExceptionType;

public class OptionNotSupportedException extends ProcessingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7141732217943551944L;

	public OptionNotSupportedException(String message, String location){
		super("OptionNotSupported", message, location);
	}
	
	public OptionNotSupportedException(ExceptionType type){
		super(type);
	}
	
	public OptionNotSupportedException(String message){
		this(message, null);
	}

	public OptionNotSupportedException(){
		this(null, null);
	}
}
