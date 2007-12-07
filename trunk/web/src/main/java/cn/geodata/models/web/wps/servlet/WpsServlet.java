package cn.geodata.models.web.wps.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerException;

import net.opengeospatial.ows.ExceptionReportDocument;
import net.opengeospatial.wps.DescribeProcessDocument;
import net.opengeospatial.wps.DescribeProcessDocument.DescribeProcess;
import net.opengeospatial.wps.impl.DescribeProcessDocumentImpl;
import net.opengeospatial.wps.impl.ExecuteDocumentImpl;

import org.apache.commons.io.IOUtils;
import org.apache.xmlbeans.XmlObject;

import cn.geodata.models.WPS;
import cn.geodata.models.exception.InvalidParameterValueException;
import cn.geodata.models.exception.MissingParameterValueException;
import cn.geodata.models.exception.NoApplicableCodeException;
import cn.geodata.models.exception.ProcessingException;
import cn.geodata.models.exception.VersionNegotiationFailedException;
import cn.geodata.models.web.wps.operation.DescribeProcessOp;
import cn.geodata.models.web.wps.operation.ExecuteOp;
import cn.geodata.models.web.wps.operation.GetCapabilitiesOp;

/**
 * Servlet implementation class for Servlet: WpsServlet
 *
 */
public class WpsServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getAnonymousLogger();

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public WpsServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String _service = request.getParameter("service");
			String _request = request.getParameter("request");
			String _version = request.getParameter("AcceptVersions");
			
			if(_service == null){
				throw new MissingParameterValueException("service");
			}
			
			if(_service.equalsIgnoreCase("WPS") == false){
				throw new InvalidParameterValueException("Only supports " + _service);
			}
			
			if(_version != null){
				if(_version.equalsIgnoreCase("0.4.0") == false){
					throw new VersionNegotiationFailedException("Only supports WPS 0.4.0");
				}
			}
			
			if(_request == null){
				throw new MissingParameterValueException("request");
			}
			
			XmlObject _doc = null;
			if(_request.equalsIgnoreCase("GetCapabilities")){
				log.info("GetCapabilities...");
				
				_doc = (new GetCapabilitiesOp()).execute(null);
			}
			else if(_request.equalsIgnoreCase("DescribeProcess")){
				log.info("DescribeProcess...");
				
				if(request.getParameter("Identifier") == null){
					throw new MissingParameterValueException("Identifier");
				}
				
				String[] _identifiers = request.getParameter("Identifier").split(",");
				
				DescribeProcessDocumentImpl _requestDoc = (DescribeProcessDocumentImpl) DescribeProcessDocument.Factory.newInstance();
				DescribeProcess _describeProcess = _requestDoc.addNewDescribeProcess();
				
				_describeProcess.setService(WPS.WPS_SERVICE);
				_describeProcess.setVersion(WPS.WPS_VERSION);
				
				for(String _identifier : _identifiers){
					_describeProcess.addNewIdentifier().setStringValue(_identifier);
				}
				
				_doc = (new DescribeProcessOp()).execute(_requestDoc);
			}
			else if(_request.equalsIgnoreCase("Execute")){
				throw new Exception("Execute operation does not support GET");
			}
			else{
				throw new InvalidParameterValueException("Does not support operation :" + _request);
			}
			
			this.outputDocument(_doc, response, false);
		}
		catch(ProcessingException err){
			log.log(Level.SEVERE, "Failed to call the operation", err);
			ExceptionReportDocument _errDoc = ExceptionReportDocument.Factory.newInstance();
			err.encode(_errDoc.addNewExceptionReport().addNewException());
			
			this.outputDocument(_errDoc, response, true);
		}
		catch(Exception err){
			log.log(Level.SEVERE, "Unknown error", err);
			ExceptionReportDocument _errDoc = ExceptionReportDocument.Factory.newInstance();
			new NoApplicableCodeException(err.getMessage()).encode(_errDoc.addNewExceptionReport().addNewException());
			
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
				_outDoc = (new DescribeProcessOp()).execute(_obj);
			}
			else if(_obj instanceof ExecuteDocumentImpl){
				_outDoc = (new ExecuteOp()).execute(_obj);
			}
			else{
				throw new InvalidParameterValueException("Does not support the request data type:" + _obj.schemaType().getShortJavaImplName());
			}
			
			this.outputDocument(_outDoc, response, false);
		}
		catch(ProcessingException err){
			log.log(Level.SEVERE, "Failed to call the operation", err);
			ExceptionReportDocument _errDoc = ExceptionReportDocument.Factory.newInstance();
			err.encode(_errDoc.addNewExceptionReport().addNewException());
			
			this.outputDocument(_errDoc, response, true);
		}
		catch(Exception err){
			log.log(Level.SEVERE, "Unknown error", err);
			ExceptionReportDocument _errDoc = ExceptionReportDocument.Factory.newInstance();
			new NoApplicableCodeException(err.getMessage()).encode(_errDoc.addNewExceptionReport().addNewException());
			
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
		response.setCharacterEncoding("utf-8");
		
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