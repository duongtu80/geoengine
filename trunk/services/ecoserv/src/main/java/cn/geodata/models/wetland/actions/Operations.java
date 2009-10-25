package cn.geodata.models.wetland.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.logging.Logger;

import net.sf.json.JSONObject;
import cn.geodata.models.ecoserv.simulate.RandomModel;
import cn.geodata.models.ecoserv.simulate.Scenarios;

public class Operations {
	private Logger log = Logger.getAnonymousLogger();
	
	protected InputStream stream;
	protected String contentType;
	protected String contentDisposition;
	
	private int id;
	private String param;
	private String txt;
	
	public Operations(){
		this.contentType = "text/xml";
		this.contentDisposition = "inline;filename=output.xml";
	}
	
	public String loadScenario() throws IOException{
		Scenarios _output = new RandomModel().calculate(Arrays.asList(new String[]{"Wetland", "Crop", "Developed"}));
		this.outputJSON(_output.toJSON());
		
		return "success";
	}
	
	public String loadParam() throws Exception {
		Scenarios _output = Scenarios.load(this.txt);
		
		ByteArrayOutputStream _s = new ByteArrayOutputStream();
		_output.generateLineChart(this.param, _s, 195, 99);
		
		this.outputPNG(_s.toByteArray());
		return "success";
	}

	public String loadSpider() throws Exception {
		Scenarios _output = Scenarios.load(this.txt);
		
		ByteArrayOutputStream _s = new ByteArrayOutputStream();
		_output.generateSpiderChart(_s, 398, 400);
		
		this.outputPNG(_s.toByteArray());
		return "success";
	}

	private void outputJSON(JSONObject json) throws UnsupportedEncodingException{
		this.stream = new ByteArrayInputStream(json.toString().getBytes("utf-8"));
		this.contentType = "text";
		this.contentDisposition = "inline;filename=\"output.txt\"";
	}

	private void outputPNG(byte[] bytes) throws UnsupportedEncodingException{
		this.stream = new ByteArrayInputStream(bytes);
		this.contentType = "image/png";
		this.contentDisposition = "inline;filename=\"image1.png\"";
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public InputStream getStream() {
		return stream;
	}

	public String getContentType() {
		return contentType;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public String loadOutput() throws Exception {
		
		
		return "success";
	}
}
