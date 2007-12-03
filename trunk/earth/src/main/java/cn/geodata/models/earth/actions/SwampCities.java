package cn.geodata.models.earth.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.logging.Logger;

import net.opengeospatial.wps.ExecuteResponseDocument;

import org.apache.xmlbeans.XmlOptions;
import org.jdom.Element;
import org.jdom.input.DOMBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import cn.geodata.model.value.LiteralValue;
import cn.geodata.model.value.ModelValue;
import cn.geodata.model.wps.WpsClient;

public class SwampCities {
	private Logger log = Logger.getAnonymousLogger();
	
	private float seaLevel;
	private InputStream stream;
	private String url;
	
	public SwampCities() {
		this.url = "http://127.0.0.1:8080/web/wps";
		this.seaLevel = 1;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public float getSeaLevel() {
		return seaLevel;
	}

	public void setSeaLevel(float seaLevel) {
		this.seaLevel = seaLevel;
	}
	
	public InputStream getStream() {
		return stream;
	}

	public String execute() throws Exception {
		log.info("Url:" + this.url);
		WpsClient _client = new WpsClient(new URI(this.url));
		
		log.info("Sea level:" + this.seaLevel);
		ModelValue[] _inputs = new ModelValue[1];
		_inputs[0] = new LiteralValue("rise", "rise", "", this.seaLevel);
		
		
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
}
