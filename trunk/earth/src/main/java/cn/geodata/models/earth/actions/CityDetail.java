package cn.geodata.models.earth.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.geotools.data.DataStore;
import org.geotools.data.FeatureSource;
import org.geotools.data.wfs.WFSDataStoreFactory;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureIterator;
import org.opengis.filter.Filter;
import org.opengis.filter.FilterFactory2;
import org.opengis.filter.identity.FeatureId;

public class CityDetail {
	private String id;
	private String cityName;
	private String countryName;
	private String status;
	private int popRank;
	private String popClass;
	private String dataUrl;

	public CityDetail() {
		this.dataUrl = "http://152.61.40.52:18080/geoserver/wfs?version=1.0.0&";
	}
	
	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}

	public String getCityName() {
		return cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getStatus() {
		return status;
	}

	public int getPopRank() {
		return popRank;
	}

	public String getPopClass() {
		return popClass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String execute() throws Exception {
		FeatureSource _dataSource = this.getDataStore().getFeatureSource("unep:cities");
		
		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		
		Set<FeatureId> _set = new HashSet<FeatureId>();
		_set.add(_factory.featureId(this.id));
		Filter _filter = _factory.id(_set);
		
		FeatureIterator _it = _dataSource.getFeatures(_filter).features();
		try{
			Feature _f = _it.next();
			this.cityName = (String)_f.getAttribute("CITY_NAME");
			this.countryName = (String)_f.getAttribute("CNTRY_NAME");
			this.popClass = (String)_f.getAttribute("POP_CLASS");
			this.popRank = (Integer)_f.getAttribute("POP_RANK");
			this.status = (String)_f.getAttribute("STATUS");
		}
		finally{
			_it.close();
		}
		
		return "success";
	}
	
	private DataStore getDataStore() throws IOException {
		WFSDataStoreFactory _factory = new WFSDataStoreFactory();

		Map _params = new HashMap();
		_params.put(_factory.URL.key, this.dataUrl);
		
		return _factory.createDataStore(_params );
	}

	public String getDataUrl() {
		return dataUrl;
	}
}
