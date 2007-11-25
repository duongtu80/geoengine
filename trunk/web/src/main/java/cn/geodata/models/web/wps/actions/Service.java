package cn.geodata.models.web.wps.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import cn.geodata.model.exception.InvalidParameterValueException;
import cn.geodata.model.exception.MissingParameterValueException;
import cn.geodata.model.exception.VersionNegotiationFailedException;

public class Service implements ServletRequestAware {
	
	/**
	 * Service type
	 */
	protected String service;

	/**
	 * Service version
	 */
	protected String version;

	/**
	 * Request operation
	 */
	protected String request;

	/**
	 * XML string
	 */
	protected String xmlValue;

	public String getRequest() {
		return request;
	}

	public void setRequest(String request)
			throws MissingParameterValueException {
		this.request = request;

		if (this.request == null) {
			throw new MissingParameterValueException("Miss request parameter");
		}
		this.request = this.request.toUpperCase();
	}

	public String getService() {
		return service;
	}

	public void setService(String service)
			throws InvalidParameterValueException {
		this.service = service.toUpperCase();

		if (this.service.equals("WPS") == false) {
			throw new InvalidParameterValueException(
					"Request service does not support");
		}
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version)
			throws VersionNegotiationFailedException {
		this.version = version;

		if (this.version.equals("0.4.0") == false) {
			throw new VersionNegotiationFailedException(
					"Request version does not support");
		}
	}

	public String execute() throws Exception {
		if (this.request == null) {
			throw new MissingParameterValueException(
					"Missing request parameter");
		}

		if (this.request.equals("GETCAPABILITIES")) {
			return "GetCapablities";
		} else if (this.request.equals("DESCRIBEPROCESS")) {
			return "DescribeProcess";

		} else if (this.request.equals("EXECUTE")) {
			return "Execute";
		} else {
			throw new InvalidParameterValueException(
					"Does not support operation:" + this.request);
		}
	}

	public String getXmlValue() {
		return xmlValue;
	}

	public void setXmlValue(String xmlValue) {
		this.xmlValue = xmlValue;
	}
	
	protected HttpServletRequest servletRequest;

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
}
