package cn.geodata.models;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;

public class GeoNamespaceContext implements NamespaceContext {
	private Map<String, String> map;
	
	public static final String PREFIX_WPS = "wps";
	public static final String PREFIX_GML = "gml";
	public static final String PREFIX_OWS = "ows";
	public static final String PREFIX_GEO = "geo";
	
	public static final String URI_WPS = "http://www.opengeospatial.net/wps";
	public static final String URI_GML = "http://www.opengis.net/gml";
	public static final String URI_OWS = "http://www.opengeospatial.net/ows";
	public static final String URI_GEO = "http://www.geodata.cn/model";
	public static final String URI_GML_3_1_1_SCHEMA = "http://schemas.opengis.net/gml/3.1.1/base/gml.xsd";
	
	public static final String WPS_VERSION = "0.4.0";
	
	public GeoNamespaceContext(){
		this.map = new Hashtable<String, String>();
		
		this.map.put(PREFIX_WPS, URI_WPS);
		this.map.put(PREFIX_GML, URI_GML);
		this.map.put(PREFIX_OWS, URI_OWS);
		this.map.put(PREFIX_GEO, URI_GEO);
	}
	
	public Map<String, String> getNamespaceMap(){
		return this.map;
	}
	
	public String getNamespaceURI(String prefix) {
		if(this.map.containsKey(prefix)){
			return this.map.get(prefix);
		}
		else{
			return "";
		}
	}

	public String getPrefix(String namespaceURI) {
		if(this.map.containsValue(namespaceURI)){
			for (String _key : this.map.keySet()) {
				if(this.map.get(_key).equals(namespaceURI)){
					return _key;
				}
			}
		}
		return "";
	}

	public Iterator getPrefixes(String namespaceURI) {
		return this.map.keySet().iterator();
	}

}
