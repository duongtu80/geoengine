package cn.geodata.gml;

import java.net.URI;
import java.net.URISyntaxException;

public class GMLConfiguration {
	private URI uriGML;
	private URI uriWPS;
	private URI uriOWS;
	
	private String version;
	
	public GMLConfiguration() throws URISyntaxException{
		this.uriWPS = new URI("http://www.opengeospatial.net/wps");
		this.uriGML = new URI("http://www.opengis.net/gml");
		this.uriOWS = new URI("http://www.opengeospatial.net/ows");
	}
	
	public URI getUriGML() {
		return uriGML;
	}

	public void setUriGML(URI uriGML) {
		this.uriGML = uriGML;
	}

	public URI getUriWPS() {
		return uriWPS;
	}

	public void setUriWPS(URI uriWPS) {
		this.uriWPS = uriWPS;
	}

	public URI getUriOWS() {
		return uriOWS;
	}

	public void setUriOWS(URI uriOWS) {
		this.uriOWS = uriOWS;
	}

	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
}
