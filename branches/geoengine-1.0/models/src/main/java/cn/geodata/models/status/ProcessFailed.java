package cn.geodata.models.status;

import net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport;
import net.opengeospatial.wps.ProcessFailedType;
import net.opengeospatial.wps.StatusType;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.models.GeoNamespaceContext;
import cn.geodata.models.exception.ProcessingException;

/**
 * Failed to execute the process
 * @author Fengm
 *
 */
public class ProcessFailed extends Status {
	private ProcessingException exception;
	
	public ProcessFailed(ProcessingException exception){
		this.exception = exception;
	}

	/**
	 * Exception information
	 * @return
	 */
	public ProcessingException getException() {
		return exception;
	}

	public void setException(ProcessingException exception) {
		this.exception = exception;
	}

	@Override
	protected Element createProcessStatusNode(Document doc) {
		Element _element = (Element) doc.createElementNS(GeoNamespaceContext.URI_WPS, this.getTitle());
		_element.appendChild(this.getException().encode(doc));
		
		return _element;
	}

	@Override
	public String getTitle() {
		return "ProcessFailed";
	}

	@Override
	public void encode(StatusType type) {
		super.encode(type);
		
		ProcessFailedType _node = type.addNewProcessFailed();
		
		ExceptionReport _exceptionReport = _node.addNewExceptionReport();
		this.exception.encode(_exceptionReport.addNewException());
	}
}
