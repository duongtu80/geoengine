package cn.geodata.models.wps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import net.opengis.ows.x11.AddressType;
import net.opengis.ows.x11.CodeType;
import net.opengis.ows.x11.ContactType;
import net.opengis.ows.x11.ExceptionType;
import net.opengis.ows.x11.GetCapabilitiesDocument;
import net.opengis.ows.x11.KeywordsType;
import net.opengis.ows.x11.OnlineResourceType;
import net.opengis.ows.x11.ResponsiblePartySubsetType;
import net.opengis.ows.x11.TelephoneType;
import net.opengis.ows.x11.HTTPDocument.HTTP;
import net.opengis.ows.x11.OperationDocument.Operation;
import net.opengis.ows.x11.OperationsMetadataDocument.OperationsMetadata;
import net.opengis.ows.x11.ServiceIdentificationDocument.ServiceIdentification;
import net.opengis.ows.x11.ServiceProviderDocument.ServiceProvider;
import net.opengis.wps.x100.CapabilitiesDocument;
import net.opengis.wps.x100.ComplexDataCombinationsType;
import net.opengis.wps.x100.ComplexDataDescriptionType;
import net.opengis.wps.x100.ComplexDataType;
import net.opengis.wps.x100.DataType;
import net.opengis.wps.x100.DescribeProcessDocument;
import net.opengis.wps.x100.DocumentOutputDefinitionType;
import net.opengis.wps.x100.ExecuteDocument;
import net.opengis.wps.x100.ExecuteResponseDocument;
import net.opengis.wps.x100.InputDescriptionType;
import net.opengis.wps.x100.InputType;
import net.opengis.wps.x100.LiteralDataType;
import net.opengis.wps.x100.LiteralInputType;
import net.opengis.wps.x100.LiteralOutputType;
import net.opengis.wps.x100.OutputDataType;
import net.opengis.wps.x100.OutputDefinitionType;
import net.opengis.wps.x100.OutputDescriptionType;
import net.opengis.wps.x100.OutputReferenceType;
import net.opengis.wps.x100.ProcessBriefType;
import net.opengis.wps.x100.ProcessDescriptionType;
import net.opengis.wps.x100.ProcessDescriptionsDocument;
import net.opengis.wps.x100.ProcessStartedType;
import net.opengis.wps.x100.ResponseDocumentType;
import net.opengis.wps.x100.StatusType;
import net.opengis.wps.x100.SupportedComplexDataInputType;
import net.opengis.wps.x100.SupportedComplexDataType;
import net.opengis.wps.x100.WPSCapabilitiesType;
import net.opengis.wps.x100.ExecuteDocument.Execute;
import net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse;
import net.opengis.wps.x100.ProcessDescriptionType.DataInputs;
import net.opengis.wps.x100.ProcessDescriptionType.ProcessOutputs;
import net.opengis.wps.x100.ProcessDescriptionsDocument.ProcessDescriptions;
import net.opengis.wps.x100.ProcessOfferingsDocument.ProcessOfferings;

import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.jdom.Element;
import org.jdom.input.DOMBuilder;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.geodata.models.ProcessContainer;
import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;
import cn.geodata.models.Status;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;
import cn.geodata.models.data.ComplexDataParser;
import cn.geodata.models.data.LiteralDataParser;
import cn.geodata.models.exception.ProcessingException;

public class WPSOperations {
	private Logger log = Logger.getAnonymousLogger();
	
	public static String version = "1.0.0";
	public static String[] supportedVersions = new String[]{"1.0.0"};
	public static String service = "WPS";
	
	private XMLConfiguration config;
	private LiteralDataParser literalParser;
	private ComplexDataParser complexParser;
	private ProcessContainer processes;
	private ProcessLibrary library;
	private MimeType defaultMime;
	private String defaultEncoding;
	
	public WPSOperations(ProcessContainer processes, XMLConfiguration config){
		this.processes = processes;
		this.config = config;
		
		this.library = ProcessLibrary.createInstance();
		this.literalParser = new LiteralDataParser();
		this.complexParser = new ComplexDataParser();
		
		try {
			this.defaultMime = new MimeType("text/xml");
		} catch (MimeTypeParseException e) {
			log.log(Level.WARNING, "Failed to create MIME text/xml", e);
		}
		this.defaultEncoding = "utf-8";
	}
	
	public CapabilitiesDocument getCapabilities(GetCapabilitiesDocument params) throws WPSException{
		//Initialize the response object
		CapabilitiesDocument _doc = CapabilitiesDocument.Factory.newInstance();
		
		WPSCapabilitiesType _cap = _doc.addNewCapabilities();
		_cap.addNewService().setStringValue(service);
		_cap.setVersion(version);
		
		this.initServiceMetadata(_cap);
		
		//ProcessOfferings element
		ProcessOfferings _processOfferings = _cap.addNewProcessOfferings();
		
		ProcessLibrary _lib = ProcessLibrary.createInstance();
		Map<String, Class> _models = _lib.getModelList();
		for(String _modelKey : _models.keySet()){
			createProcessBrief(_processOfferings.addNewProcess(), _modelKey);
		}
		
		return _doc;
	}
	
	public ProcessDescriptionsDocument describeProcesses(DescribeProcessDocument params) throws WPSException {
		ProcessDescriptionsDocument _doc = ProcessDescriptionsDocument.Factory.newInstance();

		ProcessLibrary _lib = ProcessLibrary.createInstance();
		Map<String, Class> _models = _lib.getModelList();

		ProcessDescriptions _ps = _doc.addNewProcessDescriptions();
		_ps.setService(service);
		_ps.setVersion(version);
		
		for(CodeType _id : params.getDescribeProcess().getIdentifierArray()){
			this.createWpsProcessDesc(_ps, _id);
		}
		
		return _doc;
	}
	
	public ExecuteResponseDocument execute(ExecuteDocument params) throws WPSException {
		Map<String, Class> _models = this.library.getModelList();

		Execute _exe = params.getExecute();
		String _id = _exe.getIdentifier().getStringValue();

		if(_models.containsKey(_id) == false){
			throw new WPSException(WPSException.ErrorType.OperationNotSupported, "Operation not supported:" + _id, null);
		}
		
		boolean _isLineage = false;
		boolean _isStatus = false;
		boolean _isStore = false;
		
		boolean _isRaw = false;
		if(_exe.isSetResponseForm() && _exe.getResponseForm().isSetRawDataOutput()){
			
		}
		
		ResponseDocumentType request = _exe.getResponseForm().getResponseDocument();
		
		if(request != null){
			_isStatus = request.getStatus();
			_isLineage = request.getLineage();
			_isStore = request.getStoreExecuteResponse();
		}
		
		Processing _p = null;
		try {
			_p =  this.library.createProcess(_id);
			Map<String, Method> _inputs = this.library.getInputs(_models.get(_id));
			
			for(InputType _input : _exe.getDataInputs().getInputArray()){
				String _inputId = _input.getIdentifier().getStringValue();
				if(_inputs.containsKey(_inputId)){
					Method _inputType = _inputs.get(_inputId);
					if(_input.isSetData()){
						_p.setInput(_inputId, this.decodeDataType(this.library.getInputType(_inputType), _input.getData()));
					}
				}
			}
			
			if(_isStatus == true)
				this.library.executeProcess(this.processes, _p);
			else
				this.library.executeProcess(_p);
			
		} catch (ProcessingException e) {
			log.log(Level.WARNING, "Failed to inialize the process", e);
		}
		
		
		ExecuteResponseDocument _doc = ExecuteResponseDocument.Factory.newInstance();
		ExecuteResponse _ps = _doc.addNewExecuteResponse();

		_ps.setService(service);
		_ps.setVersion(version);
		
		this.createProcessBrief(_ps.addNewProcess(), _id);
		_ps.setStatus(this.createStatusType(_p));
		
		if(_isStatus){
			try {
				this.createOutputsNode(_ps.addNewProcessOutputs(), request, _models.get(_id), _p);
			} catch (ProcessingException e) {
				log.log(Level.WARNING, "Failed to create output node", e);
			}
		}
		
		return _doc;
	}

	public void executeSimple(ExecuteDocument params, OutputStream stream) throws WPSException {
		Execute _exe = params.getExecute();
		boolean _isRaw = false;
		if(_exe.isSetResponseForm() && _exe.getResponseForm().isSetRawDataOutput()){
			_isRaw = true;
		}
		
		if(_isRaw == false){
			throw new WPSException(WPSException.ErrorType.InvalidParameterValue, "Not raw output request");
		}

		Map<String, Class> _models = this.library.getModelList();
		String _id = _exe.getIdentifier().getStringValue();

		if(_models.containsKey(_id) == false){
			throw new WPSException(WPSException.ErrorType.OperationNotSupported, "Operation not supported:" + _id);
		}
		
		OutputDefinitionType _definition = _exe.getResponseForm().getRawDataOutput();
		
		Processing _p = null;
		try {
			_p =  this.library.createProcess(_id);
			Map<String, Method> _inputs = this.library.getInputs(_models.get(_id));
			
			for(InputType _input : _exe.getDataInputs().getInputArray()){
				String _inputId = _input.getIdentifier().getStringValue();
				if(_inputs.containsKey(_inputId)){
					Method _inputType = _inputs.get(_inputId);
					if(_input.isSetData()){
						_p.setInput(_inputId, this.decodeDataType(this.library.getInputType(_inputType), _input.getData()));
					}
				}
			}
			
			this.library.executeProcess(_p);
			
		} catch (ProcessingException e) {
			log.log(Level.WARNING, "Failed to inialize the process", e);
		}
		
		String _outputId = _definition.getIdentifier().getStringValue();
		
		Class _type = this.library.getOutputType(this.library.getOutputs(_models.get(_id)).get(_outputId));
		Object _val = null;
		try {
			_val = _p.getOutput(_outputId);
		} catch (ProcessingException e) {
			log.log(Level.WARNING, "Failed to get output value", e);
		}
		
		if(_val != null){
			if(this.literalParser.isLiteral(_type)){
				try {
					stream.write(this.literalParser.encode(_type, _val).getBytes(this.defaultEncoding));
				} catch (UnsupportedEncodingException e) {
					log.log(Level.WARNING, "Unsupported encoding", e);
				} catch (IOException e) {
					log.log(Level.WARNING, "Failed to output stream", e);
				}
			}
			else{
				try {
					IOUtils.copy(this.complexParser.encode(_val, this.defaultMime, this.defaultEncoding), stream);
				} catch (IOException e) {
					log.log(Level.WARNING, "Failed to output stream", e);
				}
			}
		}
	}

	public MimeType executeSimple(String modelId, Map<String, String> inputs, String output, OutputStream stream) throws WPSException {
		Map<String, Class> _models = this.library.getModelList();
		String _id = modelId;

		if(_models.containsKey(_id) == false){
			throw new WPSException(WPSException.ErrorType.OperationNotSupported, "Operation not supported:" + _id);
		}
		
		Processing _p = null;
		try {
			_p =  this.library.createProcess(_id);
			log.fine("Creating process " + _id);
			
			Map<String, Method> _inputs = this.library.getInputs(_models.get(_id));
			for(String _input: inputs.keySet()){
				if(_inputs.containsKey(_input)){
					Method _inputType = _inputs.get(_input);
					Class _type = this.library.getInputType(_inputType);
					
					if(this.literalParser.isLiteral(_type)){
						_p.setInput(_input, this.literalParser.decode(_type, inputs.get(_input)));
					}
					else{
						URL _url = null;
						try {
							_url = new URL(inputs.get(_input));
						} catch (MalformedURLException e) {
							log.log(Level.WARNING, "Failed to create URL " + inputs.get(_input), e);
							throw new WPSException(WPSException.ErrorType.InvalidParameterValue, "Failed to create URL " + inputs.get(_input), e);
						}
						
						try {
							if(_url != null)
								_p.setInput(_input, this.complexParser.decode(_type, _url.openStream(), this.defaultMime, this.defaultEncoding));
						} catch (IOException e) {
							log.log(Level.WARNING, "Failed retrieve input stream from " + _url.toString(), e);
							throw new WPSException(WPSException.ErrorType.NoApplicableCode, "Failed retrieve input stream from " + _url.toString(), e);
						}
					}
				}
				
			}
			
			this.library.executeProcess(_p);
			
		} catch (Exception e) {
			log.log(Level.WARNING, "Failed to inialize the process", e);
		}
		
		String _outputId = output;
		
		Class _type = this.library.getOutputType(this.library.getOutputs(_models.get(_id)).get(_outputId));
		Object _val = null;
		try {
			_val = _p.getOutput(_outputId);
		} catch (ProcessingException e) {
			log.log(Level.WARNING, "Failed to get output value", e);
		}
		
		if(_val != null){
			if(this.literalParser.isLiteral(_type)){
				try {
					stream.write(this.literalParser.encode(_type, _val).getBytes(this.defaultEncoding));
					try {
						return new MimeType("text/plain");
					} catch (MimeTypeParseException e) {
						log.log(Level.WARNING, "Failed to create MIME object", e);
					}
				} catch (UnsupportedEncodingException e) {
					log.log(Level.WARNING, "Unsupported encoding", e);
					throw new WPSException(WPSException.ErrorType.NoApplicableCode, "Unsupported encoding", e);
				} catch (IOException e) {
					log.log(Level.WARNING, "Failed to output stream", e);
					throw new WPSException(WPSException.ErrorType.NoApplicableCode, "Failed to output stream", e);
				}
			}
			else{
				try {
					IOUtils.copy(this.complexParser.encode(_val, this.defaultMime, this.defaultEncoding), stream);
					return this.defaultMime;
				} catch (IOException e) {
					log.log(Level.WARNING, "Failed to output stream", e);
					throw new WPSException(WPSException.ErrorType.NoApplicableCode, "Failed to output stream", e);
				}
			}
		}
		
		return null;
	}

	protected void createOutputsNode(net.opengis.wps.x100.ExecuteResponseDocument.ExecuteResponse.ProcessOutputs response, ResponseDocumentType request, Class model, Processing proc) throws ProcessingException{
		List<String> _idList = new ArrayList<String>();
		
		if(request != null){
			DocumentOutputDefinitionType[] _ids = request.getOutputArray();
			for(DocumentOutputDefinitionType _id : _ids){
				_idList.add( _id.getIdentifier().getStringValue());
			}
		}
		else{
			_idList.addAll(this.library.getOutputs(model).keySet());
		}
		
		Map<String, Method> _outputsMetadata = this.library.getOutputs(model);
		
		boolean _isLineage = false;
		boolean _isStatus = false;
		boolean _isStore = false;
		
		if(request != null){
			_isStatus = request.getStatus();
			_isLineage = request.getLineage();
			_isStore = request.getStoreExecuteResponse();
		}
		
		for(String _id : _idList){
			Object _v = proc.getOutput(_id);
			if(_v != null){
				OutputDataType _outputNode = response.addNewOutput();
				GeoOutput _metadata = this.library.getOutputMetadata(_outputsMetadata.get(_id));
				
				_outputNode.addNewIdentifier().setStringValue(_id);
				_outputNode.addNewTitle().setStringValue(_metadata.title());
				
				if(_isStore){
					this.createRefNode(_outputNode.addNewReference(), model, _v);
				}
				else{
					this.createDataNode(_outputNode.addNewData(), model, _v);
				}
			}
		}
	}
	
	protected void createRefNode(OutputReferenceType node, Class type, Object v){
		
	}
	
	protected void createDataNode(DataType node, Class type, Object val){
		if(this.literalParser.isLiteral(type)){
			node.addNewLiteralData().setStringValue(this.literalParser.encode(type, val));
		}
		else{
			InputStream _s = null;
			try {
				_s = this.complexParser.encode(val, this.defaultMime, this.defaultEncoding);
			} catch (IOException e) {
				log.log(Level.WARNING, "Failed to encode object", e);				
			}
			
			try {
				node.addNewComplexData().set(XmlObject.Factory.parse(_s));
			} catch (XmlException e) {
				log.log(Level.WARNING, "Failed to set complex object", e);
			} catch (IOException e) {
				log.log(Level.WARNING, "Failed to set complex object", e);
			}
		}
	}
	
	protected StatusType createStatusType(Processing process){
		StatusType _status = StatusType.Factory.newInstance();
		
		Status _s = process.getStatus();
		if(_s.isFailed() == false){
			if(_s.getPercent() >= 100){
				_status.setProcessSucceeded(_s.getMessage());
			}
			else{
				ProcessStartedType _startedNode = _status.addNewProcessStarted();
				
				_startedNode.setPercentCompleted(_s.getPercent());
				_startedNode.setStringValue(_s.getMessage());
			}
		}
		else{
			ExceptionType _exceptionNode = _status.addNewProcessFailed().addNewExceptionReport().addNewException();
			for(String _m : _s.getErrorMessages()){
				_exceptionNode.addExceptionText(_m);
			}
		}
		
		return _status;
	}
	
	protected void createProcessBrief(ProcessBriefType briefNode, String modelId){
		Class _model = this.library.getModelList().get(modelId);
		GeoProcess _metadata = this.library.getProcessMetadata(_model);
		
		briefNode.addNewIdentifier().setStringValue(modelId);
		briefNode.addNewTitle().setStringValue(_metadata.title());
		briefNode.addNewAbstract().setStringValue(_metadata.description());
	}
	
	protected void initServiceMetadata(WPSCapabilitiesType cap) {
		//ServiceIndentification element
		ServiceIdentification _serviceIdentification = cap.addNewServiceIdentification();
		
		_serviceIdentification.addNewTitle().setStringValue(config.getString("identification.title"));
		_serviceIdentification.addNewAbstract().setStringValue(config.getString("identification.abstract"));
		
		KeywordsType _keywords = _serviceIdentification.addNewKeywords();
		for(String _key : (List<String>)config.getList("identification.keywords.keyword")){
			_keywords.addNewKeyword().setStringValue(_key);
		}
		
		//_serviceIdentification.setServiceType("WPS");
		_serviceIdentification.setServiceTypeVersionArray(
				this.supportedVersions
				);
		
		_serviceIdentification.setFees(config.getString("identification.fees"));
		_serviceIdentification.setAccessConstraintsArray(
				(String[])config.getList("identification.accessConstraints").toArray(new String[0])
				);
		
		//ServiceProvider element
		ServiceProvider _serviceProvider = cap.addNewServiceProvider();
		
		_serviceProvider.setProviderName(config.getString("provider.name"));
		
		OnlineResourceType _onlineResource =  OnlineResourceType.Factory.newInstance();
		_onlineResource.setHref(config.getString("provider.site"));
		_serviceProvider.setProviderSite(_onlineResource);
		
		for(HierarchicalConfiguration _contactConf : (List<HierarchicalConfiguration>)config.configurationsAt("provider.contact")){
			ResponsiblePartySubsetType _contact = _serviceProvider.addNewServiceContact();
			_contact.setIndividualName(_contactConf.getString("name"));
			_contact.setPositionName(_contactConf.getString("position"));
			
			ContactType _contantInfo = _contact.addNewContactInfo();
			TelephoneType _telephone = _contantInfo.addNewPhone();
			_telephone.setVoiceArray((String[])_contactConf.getList("phone").toArray(new String[0]));
			
			AddressType _address = _contantInfo.addNewAddress();
			_address.setDeliveryPointArray((String[])_contactConf.getList("address.deliveryPoint").toArray(new String[0]));
			_address.setCity(_contactConf.getString("address.city"));
			_address.setAdministrativeArea(_contactConf.getString("address.administrativeArea"));
			_address.setPostalCode(_contactConf.getString("address.postCode"));
			_address.setCountry(_contactConf.getString("address.country"));
			_address.setElectronicMailAddressArray((String[])_contactConf.getList("email").toArray(new String[0]));
		}
		
		//OperationsMetadata element
		String _url = "http://" + config.getString("global.host") + ":" + config.getString("global.port") + "/web/wps?";

		OperationsMetadata _operationsMetadata = cap.addNewOperationsMetadata();
		
		//GetCapabilities
		Operation _getCapabilities = _operationsMetadata.addNewOperation();
		_getCapabilities.setName("GetCapabilities");
		
		HTTP _getCapabilitiesHttp = _getCapabilities.addNewDCP().addNewHTTP();
		_getCapabilitiesHttp.addNewGet().setHref(_url);

		//DescribeProcess
		Operation _describeProcess = _operationsMetadata.addNewOperation();
		_describeProcess.setName("DescribeProcess");
		
		HTTP _describeProcessHttp = _describeProcess.addNewDCP().addNewHTTP();
		_describeProcessHttp.addNewGet().setHref(_url);
		_describeProcessHttp.addNewPost().setHref(_url);

		//DescribeProcess
		Operation _execute = _operationsMetadata.addNewOperation();
		_execute.setName("Execute");
		
		HTTP _executeHttp = _execute.addNewDCP().addNewHTTP();
		_executeHttp.addNewPost().setHref(_url);
	}

	protected void createWpsProcessDesc(ProcessDescriptions ps, CodeType id) throws WPSException{
		String _id = id.getStringValue();
		
		ProcessLibrary _lib = ProcessLibrary.createInstance();
		Map<String, Class> _models = _lib.getModelList();
		
		if(_models.containsKey(_id) == false){
			throw new WPSException(WPSException.ErrorType.OperationNotSupported, "Operation not supported:" + _id);
		}
		
		GeoProcess _mp = _lib.getProcessMetadata(_models.get(_id));
		ProcessDescriptionType _p = ps.addNewProcessDescription();
		
		_p.addNewIdentifier().setStringValue(_id);
		_p.addNewTitle().setStringValue(_mp.title());
		_p.addNewAbstract().setStringValue(_mp.description());

		DataInputs _inputsNode = _p.addNewDataInputs();
		Map<String, Method> _inputs = _lib.getInputs(_models.get(_id));
		for(String _input: _inputs.keySet()){
			GeoInput _mi = _lib.getInputMetadata(_inputs.get(_input));
			
			InputDescriptionType _inputNode = _inputsNode.addNewInput();
			_inputNode.addNewIdentifier().setStringValue(_input);
			_inputNode.addNewTitle().setStringValue(_mi.title());
			_inputNode.addNewAbstract().setStringValue(_mi.description());
			
			Class _type = _lib.getInputType(_inputs.get(_input));
			if(this.literalParser.isLiteral(_type)) {
				LiteralInputType _literalData = _inputNode.addNewLiteralData();
				_literalData.addNewDataType().setStringValue(_type.getSimpleName());
			}
			else{
				for(MimeType _m: this.complexParser.getMimes(_type)){
					SupportedComplexDataInputType _complexData = _inputNode.addNewComplexData();
					ComplexDataCombinationsType _support = _complexData.addNewSupported();

					ComplexDataDescriptionType _format = _support.addNewFormat();
					_format.setMimeType(_m.toString());
					_format.setEncoding(this.defaultEncoding);
					_format.setSchema(_type.getSimpleName());
				}
			}
		}
		
		ProcessOutputs _outputsNode = _p.addNewProcessOutputs();
		Map<String, Method> _outputs = _lib.getOutputs(_models.get(_id));
		for(String _output: _outputs.keySet()){
			GeoOutput _mo = _lib.getOutputMetadata(_outputs.get(_output));
			
			OutputDescriptionType _outputNode = _outputsNode.addNewOutput();
			_outputNode.addNewIdentifier().setStringValue(_output);
			_outputNode.addNewTitle().setStringValue(_mo.title());
			_outputNode.addNewAbstract().setStringValue(_mo.description());
			
			Class _type = _lib.getOutputType(_outputs.get(_output));
			if(this.literalParser.isLiteral(_type)) {
				LiteralOutputType _literalData = _outputNode.addNewLiteralOutput();
				_literalData.addNewDataType().setStringValue(_type.getSimpleName());
			}
			else{
				for(MimeType _m: this.complexParser.getMimes(_type)){
					SupportedComplexDataType _complexData = _outputNode.addNewComplexOutput();
					ComplexDataCombinationsType _support = _complexData.addNewSupported();

					ComplexDataDescriptionType _format = _support.addNewFormat();
					_format.setMimeType(_m.toString());
					_format.setEncoding(this.defaultEncoding);
					_format.setSchema(_type.getSimpleName());
				}
			}
		}
	}

	protected Object decodeDataType(Class type, DataType data) throws WPSException {
		if(data.isSetLiteralData()){
			LiteralDataType _literal = data.getLiteralData();
			this.literalParser.decode(type, _literal.getStringValue());
		}
		else if(data.isSetComplexData()){
			ComplexDataType _complex = data.getComplexData();
			
			MimeType _mime = null;

			File _f = null;
			try {
				_f = File.createTempFile("data", "dat");
			} catch (IOException e1) {
				log.log(Level.WARNING, "Failed to create the temp file", e1);
			}
			
			NodeList _nodes = _complex.getDomNode().getChildNodes();
			//If only one child node
			if(_nodes.getLength() == 1 && _nodes.item(0).getNodeType() == Node.TEXT_NODE){
				if(_mime == null){
					throw new WPSException(WPSException.ErrorType.InvalidParameterValue, "Unknown input stream type");
				}
				
				try {
					FileUtils.writeStringToFile(_f, _nodes.item(0).getNodeValue());
				} catch (DOMException e) {
					log.log(Level.WARNING, "Failed to write the buffer", e);
				} catch (IOException e) {
					log.log(Level.WARNING, "Failed to write the buffer", e);
				}
			}
			else{
				if(_mime == null){
					_mime = this.defaultMime;
				}

				//Find the element node
				for(int i=0;i<_nodes.getLength();i++){
					if(_nodes.item(i).getNodeType() == Node.ELEMENT_NODE){
						Element _ele = (new DOMBuilder()).build((org.w3c.dom.Element)_nodes.item(i));
						
						OutputStream _output = null;
						try {
							_output = new FileOutputStream(_f);
						} catch (FileNotFoundException e) {
							log.log(Level.WARNING, "Failed to create the temp file", e);
						}

						XMLOutputter _outputer = new XMLOutputter();
						try {
							_outputer.outputElementContent(_ele, _output);
							_output.close();
						} catch (IOException e) {
							log.log(Level.WARNING, "Failed to write the buffer", e);
						}
						
						break;
					}
				}
			}
			
			String _encoding = this.defaultEncoding;
			if(_complex.getEncoding() != null || _complex.getEncoding().length() > 0){
				_encoding = _complex.getEncoding();
			}

			try {
				this.complexParser.decode(type, new FileInputStream(_f), _mime, _encoding);
			} catch (FileNotFoundException e) {
				log.log(Level.WARNING, "Failed to create the temp file", e);
			} catch (IOException e) {
				log.log(Level.WARNING, "Failed to write the buffer", e);
			}
		}
		
		return null;
	}
}
