package cn.geodata.models.geojson;

import java.io.IOException;

public class UnsupportedGeoJSONType extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3353157231138978486L;
	
	public UnsupportedGeoJSONType(String message){
		super(message);
	}
}
