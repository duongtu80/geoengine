package cn.geodata.models.wps.rest.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerException;

import net.opengis.ows.x11.ExceptionReportDocument;
import net.opengis.wps.x100.DescribeProcessDocument;
import net.opengis.wps.x100.DescribeProcessDocument.DescribeProcess;
import net.opengis.wps.x100.impl.DescribeProcessDocumentImpl;
import net.opengis.wps.x100.impl.ExecuteDocumentImpl;

import org.apache.commons.io.IOUtils;
import org.apache.xmlbeans.XmlObject;
import org.opengis.parameter.InvalidParameterValueException;

import cn.geodata.models.ProcessContainer;
import cn.geodata.models.container.MemeryContainer;
import cn.geodata.models.wps.WPSException;
import cn.geodata.models.wps.WPSOperations;
import cn.geodata.models.wps.rest.operation.DescribeProcessOp;
import cn.geodata.models.wps.rest.operation.ExecuteOp;
import cn.geodata.models.wps.rest.operation.GetCapabilitiesOp;
import cn.geodata.models.wps.rest.util.Util;
import cn.geodata.models.wps.rest.util.WPS;

/**
 * Servlet implementation class for Servlet: WpsServlet
 *
 */
public class WpsServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;
	
	private static ProcessContainer processes = new MemeryContainer();
	
	private static Logger log = Logger.getLogger("cn.geodata.models.web");

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public WpsServlet() {
		super();
	}   	
	
	private String getParameter(HttpServletRequest request, String key){
		Enumeration<String> _enum = request.getParameterNames();
		while(_enum.hasMoreElements()){
			String _key = _enum.nextElement();
			if(_key.equalsIgnoreCase(key)){
				return request.getParameter(_key);
			}
		}
		log.log(Level.WARNING, "No parameter " + key);
		
		return null;
	}
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String _service = this.getParameter(request, "service");
			String _request = this.getParameter(request, "request");
			String _version = this.getParameter(request, "AcceptVersions");
			
			if(_service == null){
				throw new WPSException(WPSException.ErrorType.MissingParameterValue, "service");
			}
			
			if(_service.equalsIgnoreCase(WPS.WPS_SERVICE) == false){
				throw new WPSException(WPSException.ErrorType.InvalidParameterValue, "Only supports " + WPS.WPS_SERVICE);
			}
			
			if(_version != null){
				if(_version.equalsIgnoreCase(WPS.WPS_VERSION) == false){
					throw new WPSException(WPSException.ErrorType.VersionNegotiationFailed, "Only supports WPS " + WPS.WPS_VERSION);
				}
			}
			
			if(_request == null){
				throw new WPSException(WPSException.ErrorType.MissingParameterValue, "request");
			}
			
			XmlObject _doc = null;
			if(_request.equalsIgnoreCase("GetCapabilities")){
				log.info("GetCapabilities...");
				
				_doc = (new GetCapabilitiesOp()).execute(WpsServlet.processes, null);
			}
			else if(_request.equalsIgnoreCase("DescribeProcess")){
				log.info("DescribeProcess...");
				
				if(this.getParameter(request, "identifier") == null){
					throw new WPSException(WPSException.ErrorType.MissingParameterValue,"Identifier");
				}
				
				String[] _identifiers = this.getParameter(request, "identifier").split(",");
				
				DescribeProcessDocument _requestDoc = DescribeProcessDocument.Factory.newInstance();
				DescribeProcess _describeProcess = _requestDoc.addNewDescribeProcess();
				
				_describeProcess.setService(WPS.WPS_SERVICE);
				_describeProcess.setVersion(WPS.WPS_VERSION);
				
				for(String _identifier : _identifiers){
					_describeProcess.addNewIdentifier().setStringValue(_identifier);
				}
				
				_doc = (new DescribeProcessOp()).execute(WpsServlet.processes, _requestDoc);
			}
			else if(_request.equalsIgnoreCase("Execute")){
				log.info("Executing...");
				
				if(this.getParameter(request, "identifier") == null){
					throw new WPSException(WPSException.ErrorType.MissingParameterValue, "Identifier");
				}
				
				String _id = this.getParameter(request, "identifier");
				String[] _names = this.getParameter(request, "inputs").split("\\s*,\\s*");
				String[] _values = this.getParameter(request, "values").split("\\s*,\\s+");
				
				String _output = this.getParameter(request, "output");
				
				Map<String, String> _inputs = new HashMap<String, String>();
				for(int i=0;i<_names.length;i++){
					_inputs.put(_names[i], _values[i]);
				}
				
				WPSOperations _op = new WPSOperations(processes, Util.getInstance().getConfig());
				MimeType _mime = _op.executeSimple(_id, _inputs, _output, response.getOutputStream());

				response.setContentType(_mime.toString());
			}
			else{
				throw new WPSException(WPSException.ErrorType.InvalidParameterValue, "Does not support operation :" + _request);
			}
			
			if(_doc != null)
				this.outputDocument(_doc, response, false);
		}
		catch(WPSException err){
			log.log(Level.SEVERE, "Failed to call the operation", err);
			ExceptionReportDocument _errDoc = ExceptionReportDocument.Factory.newInstance();
			err.encode(_errDoc.addNewExceptionReport());
			
			this.outputDocument(_errDoc, response, true);
		}
		catch(Exception err){
			log.log(Level.SEVERE, "Unknown error", err);

			ExceptionReportDocument _errDoc = ExceptionReportDocument.Factory.newInstance();
			new WPSException(WPSException.ErrorType.NoApplicableCode, err.getMessage(), err).encode(_errDoc.addNewExceptionReport());
			
			this.outputDocument(_errDoc, response, true);
		}
	}
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			byte[] _input = IOUtils.toByteArray(request.getInputStream());
//			log.info("Request:" + new String(_input));
			XmlObject _obj = XmlObject.Factory.parse(new ByteArrayInputStream(_input));
			
			XmlObject _outDoc = null;
			if (_obj instanceof DescribeProcessDocumentImpl) {
				_outDoc = (new DescribeProcessOp()).execute(WpsServlet.processes, _obj);
			}
			else if(_obj instanceof ExecuteDocumentImpl){
				_outDoc = (new ExecuteOp()).execute(WpsServlet.processes, _obj);
			}
			else{
				throw new WPSException(WPSException.ErrorType.InvalidParameterValue, "Does not support the request data type:" + _obj.schemaType().getShortJavaImplName());
			}
			
			this.outputDocument(_outDoc, response, false);
		}
		catch(WPSException err){
			log.log(Level.SEVERE, "Failed to call the operation", err);
			ExceptionReportDocument _errDoc = ExceptionReportDocument.Factory.newInstance();
			err.encode(_errDoc.addNewExceptionReport());
			
			this.outputDocument(_errDoc, response, true);
		}
		catch(Exception err){
			log.log(Level.SEVERE, "Unknown error", err);
			
			ExceptionReportDocument _errDoc = ExceptionReportDocument.Factory.newInstance();
			new WPSException(WPSException.ErrorType.NoApplicableCode, err.getMessage(), err).encode(_errDoc.addNewExceptionReport());
			
			this.outputDocument(_errDoc, response, true);
		}
	}
	
	/**
	 * Output DOM
	 * @param doc
	 * @param response
	 * @throws IOException
	 * @throws TransformerException
	 */
	public void outputDocument(XmlObject element, ServletResponse response, boolean isException){
		response.setContentType("text/xml");
		
		//Add WPS headers
		HttpServletResponse _request = (HttpServletResponse) response;
		if(isException){
			_request.addHeader(WPS.WPS_SERVICE, WPS.EXCEPTION_TYPE);
		}
		else{
			_request.addHeader(WPS.WPS_SERVICE, WPS.NORMAL_TYPE);
		}
		
		try {
			element.save(response.getOutputStream());
		} catch (IOException e) {
			log.log(Level.WARNING, "Failed to output", e);
		}
	}
}