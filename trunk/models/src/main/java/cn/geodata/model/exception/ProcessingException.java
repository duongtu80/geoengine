package cn.geodata.model.exception;

import net.opengeospatial.ows.ExceptionType;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.model.GeoNamespaceContext;

public abstract class ProcessingException extends Exception {
	protected String location;
	protected String code;
	
	public ProcessingException(String code, String message, String location){
		super(message);
		this.code = code;
		this.location = location;
	}
	
	public ProcessingException(ExceptionType type){
		super(type.getExceptionTextArray().length == 1? type.getExceptionTextArray(0):"");
		this.code = type.getExceptionCode().toString();
		this.location = type.getLocator();
	}
	
	public String getCode() {
		return code;
	}

	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void encode(ExceptionType type){
		type.setLocator(this.location);
		type.setExceptionCode(this.code);
		
		if(this.getMessage() != null){
			type.setExceptionTextArray(new String[] {this.getMessage()});
		}
	}
	
	public Element encode(Document doc){
		Element _exceptionReport = (Element)doc.createElementNS(GeoNamespaceContext.URI_OWS, "ExceptionReport");

		Element _exception = (Element)doc.createElementNS(GeoNamespaceContext.URI_OWS, "Exception");
		_exceptionReport.appendChild(_exception);
		
		_exception.setAttribute("exceptionCode", this.getCode());
		if(this.getLocation() != null){
			_exception.setAttribute("locator", this.getLocation());
		}
		
		if(this.getMessage() != null){
			Element _exceptionText = (Element)doc.createElementNS(GeoNamespaceContext.URI_OWS, "ExceptionText");
			_exception.appendChild(_exceptionText);

			_exceptionText.setTextContent(this.getMessage());
		}
		
		return _exceptionReport;
	}
}
