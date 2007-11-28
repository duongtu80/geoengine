package cn.geodata.gml;

import java.io.OutputStream;

import org.jdom.Element;

public class Encoder {
	protected GMLConfiguration config;
	
	public Encoder(GMLConfiguration config) {
		this.config = config;
	}
	
	public void encode(Object obj, OutputStream stream) {
		
	}
	
	public Element encode(Object obj) {
		
		return null;
	}
}
