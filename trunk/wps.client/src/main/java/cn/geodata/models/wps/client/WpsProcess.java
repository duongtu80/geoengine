package cn.geodata.models.wps.client;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;

import net.opengeospatial.ows.impl.ExceptionReportDocumentImpl;
import net.opengeospatial.wps.ComplexValueType;
import net.opengeospatial.wps.DataInputsType;
import net.opengeospatial.wps.ExecuteDocument;
import net.opengeospatial.wps.ExecuteResponseDocument;
import net.opengeospatial.wps.IOValueType;
import net.opengeospatial.wps.InputDescriptionType;
import net.opengeospatial.wps.LiteralValueType;
import net.opengeospatial.wps.OutputDefinitionType;
import net.opengeospatial.wps.OutputDefinitionsType;
import net.opengeospatial.wps.OutputDescriptionType;
import net.opengeospatial.wps.ProcessDescriptionType;
import net.opengeospatial.wps.ExecuteDocument.Execute;
import net.opengeospatial.wps.IOValueType.ComplexValueReference;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.data.DataParser;

public class WpsProcess extends WpsObject {
	private static Logger log = Logger.getAnonymousLogger();
	
	private URI execute;
	private WpsService wpsService;
	private ProcessDescriptionType metadata;
	private ExecuteResponseDocument response;
	private MimeType complexMime; 
	private Map<String, MimeType> outputFormat;
	
	public WpsProcess(){
		this.outputFormat = new HashMap<String, MimeType>();
	}
	
	public Map<String, MimeType> getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(Map<String, MimeType> outputFormat) {
		this.outputFormat = outputFormat;
	}

	public ProcessDescriptionType getMetadata() {
		return metadata;
	}

	public void setMetadata(ProcessDescriptionType metadata) {
		this.metadata = metadata;
	}

	public MimeType getComplexMime() {
		return complexMime;
	}

	public void setComplexMime(MimeType complexMime) {
		this.complexMime = complexMime;
	}

	public URI getExecute() {
		return execute;
	}

	public void setExecute(URI execute) {
		this.execute = execute;
	}

	public WpsService getWpsService() {
		return wpsService;
	}

	public void setWpsService(WpsService wpsService) {
		this.wpsService = wpsService;
	}

	public ExecuteResponseDocument getResponse() {
		return response;
	}

	public void setResponse(ExecuteResponseDocument response) {
		this.response = response;
	}
	
	protected IOValueType createInputNode(String key) {
		for(InputDescriptionType _type: this.metadata.getDataInputs().getInputArray()){
			if(_type.getIdentifier().getStringValue().equals(key)){
				IOValueType _val = IOValueType.Factory.newInstance();
				
				_val.setIdentifier(_type.getIdentifier());
				_val.setTitle(_type.getTitle());
				return _val;
			}
		}
		log.severe("Not found the requst input parameter " + key);
		throw new NullPointerException("Not found the requst input parameter");
	}

	public void execute(Map<String, Object> inputs) throws IOException{
		ExecuteDocument _requestDoc = ExecuteDocument.Factory.newInstance();
		
		Execute _execute = _requestDoc.addNewExecute();
		_execute.setService(this.getService());
		_execute.setVersion(this.getVersion());
		_execute.setIdentifier(this.metadata.getIdentifier());
		
		List<IOValueType> _inputs = new ArrayList<IOValueType>();
		
		DataInputsType _inputsType = _execute.addNewDataInputs();
		
		DataParser _dataParser = DataParser.getInstance();
		for(String _key : inputs.keySet()){
			Object _val = inputs.get(_key);
			
			if(_val == null){
				log.warning("Input value is null " + _key);
			}
			else{
				IOValueType _type = this.createInputNode(_key);
				if (_val instanceof ComplexValueReference) {
					_type.setComplexValueReference((ComplexValueReference) _val);
				}
				else if(_val instanceof ComplexValueType){
					_type.setComplexValue((ComplexValueType) _val);
				}
				else if(_val instanceof LiteralValueType){
					_type.setLiteralValue((LiteralValueType) _val);
				}
				else{
					_dataParser.encode(_type, this.complexMime, _val, false);
				}
				_inputs.add(_type);
			}
		}
		_inputsType.setInputArray(_inputs.toArray(new IOValueType[0]));
		
		OutputDefinitionsType _outputsType = _execute.addNewOutputDefinitions();
		for(OutputDescriptionType _outputMetadata : this.metadata.getProcessOutputs().getOutputArray()){
			if(outputFormat.containsKey(_outputMetadata.getIdentifier().getStringValue())){
				OutputDefinitionType _output = _outputsType.addNewOutput();
				
				_output.setIdentifier(_outputMetadata.getIdentifier());
				_output.setTitle(_outputMetadata.getTitle());
				_output.setFormat(outputFormat.get(_outputMetadata.getIdentifier().getStringValue()).toString());
			}
		}
		
		log.info("Request" + _requestDoc.toString());
		
		HttpClient _http = new HttpClient();
		PostMethod _post = new PostMethod(this.execute.toString());
		_post.setRequestBody(_requestDoc.newInputStream());

		int _status = _http.executeMethod(_post);
		log.info("Execute:" + _status);

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
			
			this.response = (ExecuteResponseDocument) _doc;
		}
		else{
			throw new IOException("Error:" + _post.getResponseBodyAsString());
		}
	}
	
	public Object getOutput(String name, DataCategory category) throws IOException{
		for(IOValueType _type : this.response.getExecuteResponse().getProcessOutputs().getOutputArray()){
			if(_type.getIdentifier().getStringValue().equals(name)){
				return DataParser.getInstance().parse(category, _type);
			}
		}
		return null;
	}
	
	public IOValueType getOutput(String name) throws IOException{
		for(IOValueType _type : this.response.getExecuteResponse().getProcessOutputs().getOutputArray()){
			if(_type.getIdentifier().getStringValue().equals(name)){
				return _type;
			}
		}
		return null;
	}
	
	/**
	 * Create complex reference
	 * @param key
	 * @param uri reference url
	 * @param format format
	 * @param encoding encoding (optional)
	 * @param schema schema (optional)
	 * @return
	 */
	public ComplexValueReference createComplexRef(String uri, String format, String encoding, String schema){
		ComplexValueReference _ref = ComplexValueReference.Factory.newInstance();
		
		_ref.setReference(uri);
		_ref.setFormat(format);
		
		if(encoding != null)
			_ref.setEncoding(encoding);
		if(schema != null)
			_ref.setSchema(schema);
		
		return _ref;
	}
}
