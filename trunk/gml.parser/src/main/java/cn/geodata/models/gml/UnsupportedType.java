package cn.geodata.models.gml;

import java.io.IOException;


public class UnsupportedType extends IOException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -327291603951174058L;

	public UnsupportedType(String message) {
		super(message);
	}
	
	public UnsupportedType(Throwable err){
		super(err.getMessage());
	}

	public UnsupportedType(String message, Throwable err){
		super(message);
	}
}
