package cn.geodata.models.gml;

import java.net.URISyntaxException;

import org.jdom.Namespace;

public class GMLConfiguration {
	private Namespace uriGML;
	private Namespace uriWPS;
	private Namespace uriOWS;
	private Namespace uriWFS;
	
	private String version;
	
	public GMLConfiguration() throws URISyntaxException{
		this.uriWPS = Namespace.getNamespace("wps", "http://www.opengeospatial.net/wps");
		this.uriGML = Namespace.getNamespace("gml", "http://www.opengis.net/gml");
		this.uriOWS = Namespace.getNamespace("ows", "http://www.opengeospatial.net/ows");
		this.uriWFS = Namespace.getNamespace("wfs", "http://www.opengis.net/wfs");
	}
	
	public Namespace getUriWFS() {
		return uriWFS;
	}

	public void setUriWFS(Namespace uriWFS) {
		this.uriWFS = uriWFS;
	}

	public Namespace getUriGML() {
		return uriGML;
	}

	public void setUriGML(Namespace uriGML) {
		this.uriGML = uriGML;
	}

	public Namespace getUriWPS() {
		return uriWPS;
	}

	public void setUriWPS(Namespace uriWPS) {
		this.uriWPS = uriWPS;
	}

	public Namespace getUriOWS() {
		return uriOWS;
	}

	public void setUriOWS(Namespace uriOWS) {
		this.uriOWS = uriOWS;
	}

	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
}
