package cn.geodata.models.tools;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.geotools.data.FeatureSource;
import org.geotools.data.wfs.WFSDataStore;
import org.geotools.data.wfs.WFSDataStoreFactory;
import org.geotools.feature.FeatureType;

/**
 * 
 * WFS feature source
 * 
 * @author tank
 *
 */
public class WfsFeatureSource {
	private String url;
	private String datasetName;
	private FeatureType featureType;
	private FeatureSource featureSource;
	
	public String getUrl() {
		return url;
	}
	
	public String getDatasetName() {
		return datasetName;
	}
	
	public WfsFeatureSource(String url, String datasetName) throws IOException{
		this.url = url;
		this.datasetName = datasetName;
		
		WFSDataStoreFactory _factory = new WFSDataStoreFactory();
		
		Map<String, Object> _params = new HashMap<String, Object>();
		_params.put(_factory.URL.key, new URL(this.url));
		_params.put(_factory.TIMEOUT.key, new Integer(60000));
		_params.put(_factory.PROTOCOL.key, false);
		
		WFSDataStore _dataStore = (WFSDataStore) _factory.createDataStore(_params);
		for(String _schema : _dataStore.getTypeNames()){
			System.out.println(_schema);
		}
			
		this.featureSource = _dataStore.getFeatureSource(datasetName);
		this.featureType = this.featureSource.getSchema();
	}

	public FeatureType getFeatureType() {
		return featureType;
	}

	public FeatureSource getFeatureSource() {
		return featureSource;
	}
}
