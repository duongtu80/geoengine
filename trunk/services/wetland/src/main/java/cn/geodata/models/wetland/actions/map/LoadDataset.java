package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Logger;

import net.sf.json.JSONObject;

import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.jdom.output.XMLOutputter;

import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;
import cn.geodata.models.gml.ParserUtil;

public class LoadDataset {
	private Logger log = Logger.getAnonymousLogger();

	// private String dataset;
	private InputStream stream;
	private String dataset;
	private Catchment catchment;
	
	public LoadDataset(Catchment catchment){
		this.catchment = catchment;
	}

	public InputStream getStream() {
		return stream;
	}
	
	public void setDataset(String dataset) {
		this.dataset = dataset;
	}

	public String execute() throws Exception {
		FeatureCollection _fs = this.catchment.getCatchments();
		
		XMLOutputter _output = new XMLOutputter();
		String _txt = _output.outputString(ParserUtil.createParserFinder().encode(_fs));

		this.stream = new ByteArrayInputStream(_txt.getBytes("utf-8"));
		return "success";
	}
}
