package cn.geodata.models.glacier.actions.map;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Logger;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.jdom.output.XMLOutputter;
import org.opengis.feature.Feature;

import cn.geodata.models.glacier.actions.models.BasinDataset;
import cn.geodata.models.gml.ParserUtil;

public class LoadDataset {
	private Logger log = Logger.getAnonymousLogger();

	// private String dataset;
	private InputStream stream;
	// private String wfsUrl;
	private BasinDataset basins;

	public LoadDataset(BasinDataset basins) {
		this.basins = basins;
	}

	// public void setWfsUrl(String wfsUrl) {
	// this.wfsUrl = wfsUrl;
	// }
	//
	public InputStream getStream() {
		return stream;
	}

	// public void setDataset(String dataset) {
	// this.dataset = dataset;
	// }
	//
	public String execute() throws Exception {
		FeatureCollection _fs = this.basins.getBasins();
		FeatureIterator _it = _fs.features();
		
		FeatureCollection _ns = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		while(_it.hasNext()){
			Feature _f = _it.next();
			
//			if(_f.getAttribute("STATION").equals("台兰"))
				_ns.add(_f);
		}
		
		XMLOutputter _output = new XMLOutputter();
		String _txt = _output.outputString(ParserUtil.createParserFinder().encode(_ns));

		this.stream = new ByteArrayInputStream(_txt.getBytes("utf-8"));
		return "success";
	}
}
