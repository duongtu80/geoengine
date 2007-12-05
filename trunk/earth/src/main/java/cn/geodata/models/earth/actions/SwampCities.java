package cn.geodata.models.earth.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.logging.Logger;

import net.opengeospatial.wps.ExecuteResponseDocument;

import org.apache.xmlbeans.XmlOptions;
import org.geotools.catalog.wfs.WFSService;
import org.geotools.data.wfs.WFSDataStore;
import org.jdom.Element;
import org.jdom.input.DOMBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import cn.geodata.model.value.ComplexValueReference;
import cn.geodata.model.value.LiteralValue;
import cn.geodata.model.value.ModelValue;
import cn.geodata.model.wps.WpsClient;

public class SwampCities {
	private Logger log = Logger.getAnonymousLogger();
	
	private double seaLevel;
	private InputStream stream;
	private String modelUrl;
	private String dataUrl;
	
	public SwampCities() {
		this.modelUrl = "http://127.0.0.1:8080/web/wps";
		this.seaLevel = 1;
	}
	
	public String getModelUrl() {
		return modelUrl;
	}

	public void setModelUrl(String modelUrl) {
		this.modelUrl = modelUrl;
	}

	public double getSeaLevel() {
		return seaLevel;
	}

	public void setSeaLevel(double seaLevel) {
		this.seaLevel = seaLevel;
	}
	
	public InputStream getStream() {
		return stream;
	}

	public String execute() throws Exception {
		log.info("Model Url:" + this.modelUrl);
		WpsClient _client = new WpsClient(new URI(this.modelUrl));
		
		log.info("Sea level:" + this.seaLevel);
		log.info("Data url:" + this.dataUrl);

		org.apache.xml.utils.URI _citiesUrl = new org.apache.xml.utils.URI(this.dataUrl);
		_citiesUrl.setQueryString("service=WFS&request=GetFeature&typename=unep:cities");

		log.info("Cities url:" + _citiesUrl.toString());

		ModelValue[] _inputs = new ModelValue[2];
		_inputs[0] = new LiteralValue("rise", "rise", "", this.seaLevel);
		_inputs[1] = new ComplexValueReference("cities", "cities", "", _citiesUrl.toString(), "text/gml", "utf-8", null);
		
		ExecuteResponseDocument _execute = _client.execute("SwampCities", _inputs);
		
		XmlOptions _options = new XmlOptions();
//		_options.setSaveUseOpenFrag();
		_options.setSaveOuter();
		
//		this.stream = _execute.getExecuteResponse().getProcessOutputs().getOutputArray(0).getComplexValue().newInputStream(_options);
		Element _ele = (new DOMBuilder()).build((org.w3c.dom.Element)_execute.getExecuteResponse().getProcessOutputs().getOutputArray(0).getComplexValue().getDomNode());
		
		ByteArrayOutputStream _outStream = new ByteArrayOutputStream();
		XMLOutputter _outputer = new XMLOutputter();
		_outputer.setFormat(Format.getCompactFormat());
		
		_outputer.output((Element)_ele.getChildren().get(0), _outStream);
		this.stream = new ByteArrayInputStream(_outStream.toByteArray());
		
		return "success";
	}

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}
}
