package cn.geodata.models.glacier.actions.map;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Logger;

import org.jdom.output.XMLOutputter;

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
		XMLOutputter _output = new XMLOutputter();
		String _txt = _output.outputString(ParserUtil.createParserFinder()
				.encode(this.basins.getBasins()));

		this.stream = new ByteArrayInputStream(_txt.getBytes("utf-8"));
		return "success";
	}
}
