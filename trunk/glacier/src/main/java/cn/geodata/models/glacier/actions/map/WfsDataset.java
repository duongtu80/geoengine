package cn.geodata.models.glacier.actions.map;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.geotools.data.wfs.WFSDataStore;
import org.geotools.data.wfs.WFSDataStoreFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

public class WfsDataset {
	private String url;
	private InputStream stream;
	
	public void setUrl(String url) {
		this.url = url;
	}

	public InputStream getStream() {
		return stream;
	}

	public String execute() throws Exception {
		SAXBuilder _builder = new SAXBuilder();
		Document _doc = _builder.build(new URL(this.url + "?service=WFS&request=GetCapabilities"));
		
		Namespace _wfsNamespace = Namespace.getNamespace("wfs", "http://www.opengis.net/wfs");
		
		XPath _xpath = XPath.newInstance("//wfs:FeatureType");
		
		_xpath.addNamespace("wfs", "http://www.opengis.net/wfs");
		_xpath.addNamespace("ogc", "http://www.opengis.net/ogc");
		_xpath.addNamespace("geo", "http://www.geodata.cn/data");
		_xpath.addNamespace("ows", "http://www.opengis.net/ows");
		
		JSONArray _list = new JSONArray();
		List<Element> _nodes = _xpath.selectNodes(_doc);
		for(Element _n : _nodes){
			JSONObject _dataset = new JSONObject();
			
			_dataset.put("value", _n.getChildTextTrim("Name", _wfsNamespace));
			_dataset.put("name", _n.getChildTextTrim("Title", _wfsNamespace));
			
			_list.put(_dataset); 
		}

		JSONObject _obj = new JSONObject();
		_obj.put("items", _list);
//		_obj.put("identity", "value");
//		_obj.put("label", "id");
		
		this.stream = new ByteArrayInputStream(_obj.toString().getBytes("utf-8"));
		
		return "success";
	}

	private WFSDataStore getWfsFeatureCollection(String url) throws IOException{
		WFSDataStoreFactory _factory = new WFSDataStoreFactory();
		
		Map<String, Object> _params = new HashMap<String, Object>();
		_params.put(_factory.URL.key, new URL(url));
		_params.put(_factory.TIMEOUT.key, new Integer(60000));
		_params.put(_factory.PROTOCOL.key, false);
		
		return (WFSDataStore) _factory.createDataStore(_params);
	}
}
