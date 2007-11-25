package cn.geodata.model.status;

import net.opengeospatial.ows.ExceptionType;
import net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport;
import net.opengeospatial.wps.ProcessFailedType;
import net.opengeospatial.wps.StatusType;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.model.GeoNamespaceContext;
import cn.geodata.model.exception.ProcessingException;

/**
 * 进程执行失败
 * @author Fengm
 *
 */
public class ProcessFailed extends Status {
	private ProcessingException exception;
	
	public ProcessFailed(ProcessingException exception){
		this.exception = exception;
	}

	/**
	 * 获取执行失败的异常信息
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
