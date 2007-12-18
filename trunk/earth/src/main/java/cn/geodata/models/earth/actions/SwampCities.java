package cn.geodata.models.earth.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import net.opengeospatial.wps.ExecuteResponseDocument;
import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.InputDescriptionType;
import net.opengeospatial.wps.LiteralValueType;
import net.opengeospatial.wps.ProcessDescriptionType;

import org.jdom.Element;
import org.jdom.input.DOMBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import cn.geodata.models.value.ModelValueParserFinder;
import cn.geodata.models.value.ModelValueUtil;
import cn.geodata.models.wps.WpsClient;

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

		ProcessDescriptionType _processDesc = _client.describeProcess(new String[]{"swamp.cities"}).getProcessDescriptions().getProcessDescriptionArray(0);
		
		Map<String, InputDescriptionType> _inputDefinitions = new HashMap<String, InputDescriptionType>();
		for(InputDescriptionType _inputType : _processDesc.getDataInputs().getInputArray()){
			_inputDefinitions.put(_inputType.getIdentifier().getStringValue(), _inputType);
		}

		ModelValueParserFinder _finder = ModelValueUtil.createParserFinder();
		
		List<IOValueType> _inputs = new ArrayList<IOValueType>();
		
		IOValueType _paramRise = ModelValueUtil.createInputValue(_inputDefinitions.get("rise"));
		_paramRise.setLiteralValue(_finder.getLiteralEncoder().encodeLiteral(this.seaLevel));
		_inputs.add(_paramRise);
		
		IOValueType _paramCities = ModelValueUtil.createInputValue(_inputDefinitions.get("cities"));
		_paramCities.setComplexValueReference(_finder.getReferenceEncoder().encodeUrl(_citiesUrl.toString(), "text/gml", "utf-8", null));
		_inputs.add(_paramCities);
		
		ExecuteResponseDocument _execute = _client.execute(_processDesc.getIdentifier().getStringValue(), _inputs.toArray(new IOValueType[0]));
		
		
//		XmlOptions _options = new XmlOptions();
//		_options.setSaveUseOpenFrag();
//		_options.setSaveOuter();
		
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
