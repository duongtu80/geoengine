package cn.geodata.model.wps;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import net.opengeospatial.ows.ExceptionReportDocument;
import net.opengeospatial.ows.GetCapabilitiesDocument;
import net.opengeospatial.wps.CapabilitiesDocument;
import net.opengeospatial.wps.DataInputsType;
import net.opengeospatial.wps.DescribeProcessDocument;
import net.opengeospatial.wps.ExecuteDocument;
import net.opengeospatial.wps.ExecuteResponseDocument;
import net.opengeospatial.wps.ProcessDescriptionsDocument;
import net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess;
import net.opengeospatial.wps.ExecuteDocument.Execute;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.model.GeoNamespaceContext;
import cn.geodata.model.WPS;
import cn.geodata.model.exception.ExceptionParser;
import cn.geodata.model.util.Utilities;
import cn.geodata.model.value.ModelValue;

public class WpsClient {
	private static Logger Log = Logger.getLogger(WpsClient.class);
	
	protected String service;
	protected String version;
	protected URI capibilitiesUri;
	protected URI describeUri;
	protected URI executeUri;

	public URI getCapibilitiesUri() throws URISyntaxException {
		String _query = this.capibilitiesUri.getQuery();
		HashMap<String, String> _params = new HashMap<String, String>();
		if(_query != null){
			for(String _q : _query.split("&")){
				String[] _parts = _q.split("=");
				if(_parts.length == 2){
					_params.put(_parts[0], _parts[1]);
				}
				else if(_parts.length == 1){
					_params.put(_parts[0], "");
				}
			}
		}
		
		_params.put("service", this.service);
		_params.put("version", this.version);
		_params.put("request", "GetCapabilities");
		
		String _queryStr = null;
		for(String _key : _params.keySet()){
			if(_queryStr == null){
				_queryStr = _key + "=" + _params.get(_key);
			}
			else{
				_queryStr += "&" + _key + "=" + _params.get(_key);
			}
		}

		return new URI(capibilitiesUri.getScheme(), capibilitiesUri.getUserInfo(), capibilitiesUri.getHost(), capibilitiesUri.getPort(), capibilitiesUri.getPath(), _queryStr, capibilitiesUri.getFragment()) ;
	}

	public void setCapibilitiesUri(URI capibilitiesUri) {
		this.capibilitiesUri = capibilitiesUri;
	}

	public URI getDescribeUri() {
		return describeUri;
	}

	public void setDescribeUri(URI describeUri) {
		this.describeUri = describeUri;
	}

	public URI getExecuteUri() {
		return executeUri;
	}

	public void setExecuteUri(URI executeUri) {
		this.executeUri = executeUri;
	}

	public WpsClient() {
		this.service = "WPS";
		this.version = "0.4.0";
	}
	
	public WpsClient(URI capibilitiesUri){
		this();
		
		this.capibilitiesUri = capibilitiesUri;
		this.describeUri = capibilitiesUri;
		this.executeUri = capibilitiesUri;
	}
	
	public CapabilitiesDocument getCapibilities() throws Exception {
		URI _query = this.getCapibilitiesUri();
		Log.debug("GetCapibilities uri:" + _query.toString());

		HttpClient _http = new HttpClient();
		GetMethod _get = new GetMethod(_query.toString());
		Log.debug("GetCapibilitites:" + _http.executeMethod(_get));
		
		Log.debug("Response:" + _get.getResponseBodyAsString());

		int _status = _http.executeMethod(_get);
		Log.debug("GetCapabilities:" + _status);

		if(_status == 200 && _get.getResponseHeader("Content-Type").getValue().startsWith("text/xml")){
			String[] _contentParts = _get.getResponseHeader("Content-Type").getValue().split(";");
			XmlOptions _option = new XmlOptions();
			_option.put(XmlOptions.CHARACTER_ENCODING, _contentParts[1]);
			
			if(_get.getResponseHeader(WPS.WPS_SERVICE).getValue().equals(WPS.EXCEPTION_TYPE)){
				throw ExceptionParser.parse(ExceptionReportDocument.Factory.parse(_get.getResponseBodyAsStream(), _option).getExceptionReport());
			}
			
			return CapabilitiesDocument.Factory.parse(_get.getResponseBodyAsStream(), _option);
		}
		else{
			throw new Exception("返回错误信息:" + _get.getResponseBodyAsString());
		}
	}
	
	public ProcessDescriptionsDocument describeProcess(String[] identifiers) throws Exception{
		DescribeProcessDocument _requestDoc = DescribeProcessDocument.Factory.newInstance();
		DescribeProcess _describeProcess = _requestDoc.addNewDescribeProcess();
		
		_describeProcess.setService(this.service);
		_describeProcess.setVersion(this.version);

		for(String _identifier : identifiers){
			_describeProcess.addNewIdentifier().setStringValue(_identifier);
		}
		
		Log.debug("Request:" + _requestDoc.toString());
		
		HttpClient _http = new HttpClient();
		PostMethod _post = new PostMethod(this.getDescribeUri().toString());
		
		_post.setRequestBody(_requestDoc.newInputStream());

		int _status = _http.executeMethod(_post);
		Log.debug("DescribeProcess:" + _status);
		
		if(_status == 200 && _post.getResponseHeader("Content-Type").getValue().startsWith("text/xml")){
			String[] _contentParts = _post.getResponseHeader("Content-Type").getValue().split(";");
			XmlOptions _option = new XmlOptions();
			_option.put(XmlOptions.CHARACTER_ENCODING, _contentParts[1]);
			
			if(_post.getResponseHeader(WPS.WPS_SERVICE).getValue().equals(WPS.EXCEPTION_TYPE)){
				throw ExceptionParser.parse(ExceptionReportDocument.Factory.parse(_post.getResponseBodyAsStream(), _option).getExceptionReport());
			}
			
			return ProcessDescriptionsDocument.Factory.parse(_post.getResponseBodyAsStream(), _option);
		}
		else{
			throw new Exception("返回错误信息:" + _post.getResponseBodyAsString());
		}
	}
	
	public ExecuteResponseDocument execute(String identifier, ModelValue[] inputParams) throws Exception {
		ExecuteDocument _requestDoc = ExecuteDocument.Factory.newInstance();
		
		Execute _execute = _requestDoc.addNewExecute();
		_execute.setService(WPS.WPS_SERVICE);
		_execute.setVersion(WPS.WPS_VERSION);
		_execute.addNewIdentifier().setStringValue(identifier);
		
		DataInputsType _inputsType = _execute.addNewDataInputs();
		for(ModelValue _input : inputParams){
			_input.encode(_inputsType.addNewInput());
		}
		
		Log.info("Request" + _requestDoc.toString());
		
		HttpClient _http = new HttpClient();
		PostMethod _post = new PostMethod(this.getDescribeUri().toString());
		_post.setRequestBody(_requestDoc.newInputStream());

		int _status = _http.executeMethod(_post);
		Log.debug("Execute:" + _status);

		if(_status == 200 && _post.getResponseHeader("Content-Type").getValue().startsWith("text/xml")){
			String[] _contentParts = _post.getResponseHeader("Content-Type").getValue().split(";");
			XmlOptions _option = new XmlOptions();
			_option.put(XmlOptions.CHARACTER_ENCODING, _contentParts[1]);
			
			if(_post.getResponseHeader(WPS.WPS_SERVICE).getValue().equals(WPS.EXCEPTION_TYPE)){
				throw ExceptionParser.parse(ExceptionReportDocument.Factory.parse(_post.getResponseBodyAsStream(), _option).getExceptionReport());
			}
			
			return ExecuteResponseDocument.Factory.parse(_post.getResponseBodyAsStream(), _option);
		}
		else{
			throw new Exception("返回错误信息:" + _post.getResponseBodyAsString());
		}
	}
}
