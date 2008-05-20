package cn.geodata.models.wps.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import net.opengeospatial.ows.DCPDocument.DCP;
import net.opengeospatial.ows.OperationDocument.Operation;
import net.opengeospatial.ows.impl.ExceptionReportDocumentImpl;
import net.opengeospatial.wps.CapabilitiesDocument;
import net.opengeospatial.wps.DescribeProcessDocument;
import net.opengeospatial.wps.ProcessBriefType;
import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess;
import net.opengeospatial.wps.impl.ProcessDescriptionsDocumentImpl;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

public class WpsService extends WpsObject {
	private static Logger log = Logger.getAnonymousLogger();
	
	private URI uri;
	private CapabilitiesDocument metadata;
	
	public WpsService() {
		
	}
	
	public WpsService(URI uri){
		this.uri = uri;
	}
	
	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	public CapabilitiesDocument getMetadata() {
		return metadata;
	}
	
	public void setMetadata(CapabilitiesDocument metadata) {
		this.metadata = metadata;
	}
	
	public URI getCapibilitiesUri() throws URISyntaxException {
		String _query = this.uri.getQuery();
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
		
		_params.put("service", this.getService());
		_params.put("version", this.getVersion());
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

		return new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), uri.getPath(), _queryStr, uri.getFragment()) ;
	}
	
	/**
	 * Connect and get the service metadata
	 * 
	 * @throws IOException
	 */
	public void connect() throws IOException {
		if(this.uri == null){
			throw new NullPointerException("No service address assigned");
		}
		
		URI _query;
		try {
			_query = this.getCapibilitiesUri();
		} catch (URISyntaxException e) {
			log.log(Level.WARNING, "Failed to create the uri", e);
			throw new IOException("Failed to create uri for GetCapabilities request");
		}
		
		log.info("GetCapibilities uri:" + _query.toString());

		HttpClient _http = new HttpClient();
		GetMethod _get = new GetMethod(_query.toString());
		log.info("GetCapibilitites:" + _http.executeMethod(_get));
		
//		log.info("Response:" + _get.getResponseBodyAsString());

		int _status = _http.executeMethod(_get);
		log.info("GetCapabilities:" + _status);

		if(_status == 200 && _get.getResponseHeader("Content-Type").getValue().startsWith("text/xml")){
			String[] _contentParts = _get.getResponseHeader("Content-Type").getValue().split(";");
			XmlOptions _option = new XmlOptions();
			_option.put(XmlOptions.CHARACTER_ENCODING, _contentParts[1]);
			
			XmlObject _doc;
			try {
				_doc = XmlObject.Factory.parse(_get.getResponseBodyAsStream(), _option);
			} catch (XmlException e) {
				log.log(Level.SEVERE, "Failed to parse the response stream", e);
				throw new IOException("Failed to parse the response stream");
			}
			if (_doc instanceof ExceptionReportDocumentImpl) {
				ExceptionReportDocumentImpl _exception = (ExceptionReportDocumentImpl) _doc;
				throw new IOException(_exception.toString());
			}
			
			this.metadata = (CapabilitiesDocument) _doc;
		}
		else{
			throw new IOException("Error:" + _get.getResponseBodyAsString());
		}
	}
	
	/**
	 * Get process object with the given name
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public WpsProcess getWpsProcess(String key) throws IOException{
		for(ProcessBriefType _proc : this.metadata.getCapabilities().getProcessOfferings().getProcessArray()){
			if(_proc.getIdentifier().getStringValue().equalsIgnoreCase(key)){
				WpsProcess _process = new WpsProcess();
				
				try {
					_process.setComplexMime(new MimeType("text/xml"));
				} catch (MimeTypeParseException e) {
					log.log(Level.WARNING, "Failed to create MIME", e);
					throw new IOException(e.getMessage());
				}
				_process.setExecute(this.findPostUri("Execute"));
				_process.setMetadata(this.describeProcess(key));
				_process.setWpsService(this);
				
				return _process;
			}
		}
		throw new NullPointerException("Not found process " + key);
	}
	
	/**
	 * Find post url for the operation
	 * 
	 * @param op
	 * @return
	 * @throws IOException
	 */
	protected URI findPostUri(String op) throws IOException{
		try {
			for(Operation _op : this.metadata.getCapabilities().getOperationsMetadata().getOperationArray()){
				if(_op.getName().equals(op)){
					for(DCP _dcp : _op.getDCPArray()){
						if(_dcp.getHTTP().getPostArray().length > 0){
							return new URI(_dcp.getHTTP().getPostArray(0).getHref());
						}
					}
				}
			}
			
			throw new IOException("Failed to find pos uri for operation " + op);
		} catch (URISyntaxException e) {
			log.log(Level.WARNING, "Failed to get uri", e);
			throw new IOException(e.getMessage());
		}
	}
	
	/**
	 * @return Get the list of all brief process description
	 */
	public List<ProcessBriefType> listProcesses() {
		List<ProcessBriefType> _list = new ArrayList<ProcessBriefType>();
		for(ProcessBriefType _proc : this.metadata.getCapabilities().getProcessOfferings().getProcessArray()){
			_list.add(_proc);
		}
		
		return _list;
	}
	
	/**
	 * Retrieve the process metadata
	 * 
	 * @param key
	 * @return Metadata of the process
	 * @throws HttpException
	 * @throws IOException
	 */
	public ProcessDescriptionType describeProcess(String key) throws HttpException, IOException{
		DescribeProcessDocument _requestDoc = DescribeProcessDocument.Factory.newInstance();
		DescribeProcess _describeProcess = _requestDoc.addNewDescribeProcess();
		
		_describeProcess.setService(this.getService());
		_describeProcess.setVersion(this.getVersion());
		_describeProcess.addNewIdentifier().setStringValue(key);
		
		log.fine("Request:" + _requestDoc.toString());
		
		HttpClient _http = new HttpClient();
		PostMethod _post = new PostMethod(this.findPostUri("DescribeProcess").toString());
		
		_post.setRequestBody(_requestDoc.newInputStream());

		int _status = _http.executeMethod(_post);
		log.fine("DescribeProcess:" + _status);
		
		if(_status == 200 && _post.getResponseHeader("Content-Type").getValue().startsWith("text/xml")){
			String[] _contentParts = _post.getResponseHeader("Content-Type").getValue().split(";");
			XmlOptions _option = new XmlOptions();
			_option.put(XmlOptions.CHARACTER_ENCODING, _contentParts[1]);
			
			XmlObject _doc;
			try {
				_doc = XmlObject.Factory.parse(_post.getResponseBodyAsStream(), _option);
			} catch (XmlException e) {
				log.log(Level.SEVERE, "Failed to parse the response stream", e);
				throw new IOException("Failed to parse the response stream");
			}
			if (_doc instanceof ExceptionReportDocumentImpl) {
				ExceptionReportDocumentImpl _exception = (ExceptionReportDocumentImpl) _doc;
				throw new IOException(_exception.toString());
			}
			
			ProcessDescriptionsDocumentImpl _processesDoc = (ProcessDescriptionsDocumentImpl) _doc;
			ProcessDescriptionType[] _procs = _processesDoc.getProcessDescriptions().getProcessDescriptionArray();
			if(_procs.length == 1){
				return _procs[0];
			}
			else{
				throw new IOException("Got the wrong process metadata.");
			}
		}
		else{
			throw new IOException("Error:" + _post.getResponseBodyAsString());
		}
	}
}
