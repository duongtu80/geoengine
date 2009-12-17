package cn.geodata.models.data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.opengis.wps.x100.ComplexDataType;
import net.opengis.wps.x100.InputReferenceType;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.geotools.data.shapefile.indexed.DataComparator;
import org.jdom.Element;
import org.jdom.input.DOMBuilder;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ComplexParsers {
	private static Logger log = Utilities.getLogger();
	
	private List<ComplexParser> parsers;
	private DocumentBuilder documentBuilder;
	
	public ComplexParsers() {
		DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();
		_factory.setNamespaceAware(true);
		
		try {
			this.documentBuilder = _factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			log.log(Level.SEVERE, "Failed to create document builder", e);
		}
	}

	public List<ComplexParser> getParsers() {
		return parsers;
	}

	public void setParsers(List<ComplexParser> parsers) {
		this.parsers = parsers;
	}
	
	public boolean supports(Class type, MimeType mime){
		for(ComplexParser _parser : this.parsers){
			if(_parser.getCategories().contains(type) && this.containsMime(_parser.getMimes(), mime)){
				return true;
			}
		}
		return false;
	}
	
	public ComplexParser findParser(MimeType mimeType, Class type){
		for(ComplexParser _p : this.parsers){
			if(this.containsMime(_p.getMimes(), mimeType) && _p.getCategories().contains(type)){
				return _p;
			}
		}
		
		log.warning("Not found parser for " + mimeType + " category:" + type);
		return null;
	}
	
	protected boolean containsMime(List<MimeType> list, MimeType mime) {
		for(MimeType _m : list){
			if(_m.match(mime)){
				return true;
			}
		}
		return false;
	}
	
	public List<MimeType> getMimes4Category(Class type) {
		List<MimeType> _list = new ArrayList<MimeType>();
		if(this.parsers != null){
			for(ComplexParser _p : this.parsers){
				if(_p.getCategories().contains(type)){
					_list.addAll(_p.getMimes());
				}
			}
		}
		
		return _list;
	}
	
	public MimeType getDefaultMime4Category(Class type) {
		return this.getMimes4Category(type).get(0);
	}
	
	public ComplexStream parseToStream(Class type, ComplexDataType value) throws IOException {
		MimeType _mime = null;
		try {
			if(value.getMimeType() != null && value.getMimeType().length() > 0){
				_mime = new MimeType(value.getMimeType());
			}
			
		} catch (MimeTypeParseException e) {
			log.log(Level.SEVERE, "Failed to create MIME " + value.getMimeType(), e);
			throw new IOException("Failed to create MIME");
		}
		
		InputStream _stream = null;
		NodeList _nodes = value.getDomNode().getChildNodes();
		//If only one child node
		if(_nodes.getLength() == 1 && _nodes.item(0).getNodeType() == Node.TEXT_NODE){
			if(_mime == null){
				throw new IOException("Unknown input stream type");
			}
			
			_stream = new ByteArrayInputStream(_nodes.item(0).getNodeValue().getBytes());
		}
		else{
			try {
				if(_mime == null){
					_mime = new MimeType("text/xml");
				}
			} catch (MimeTypeParseException e) {
				log.log(Level.WARNING, "Failed to create MIME text/xml", e);
			}
			
			//Find the element node
			for(int i=0;i<_nodes.getLength();i++){
				if(_nodes.item(i).getNodeType() == Node.ELEMENT_NODE){
					Element _ele = (new DOMBuilder()).build((org.w3c.dom.Element)_nodes.item(i));
					
					ByteArrayOutputStream _out = new ByteArrayOutputStream();
					XMLOutputter _outputer = new XMLOutputter();
					_outputer.output(_ele, _out);
					
					_stream = new ByteArrayInputStream(_out.toByteArray());
					break;
				}
			}
			if(_stream == null){
				log.warning("Failed to find value element");
				throw new NullPointerException("Failed to find value element");
			}
		}
		
		return new ComplexStream(_mime, type, _stream);
	}

	public ComplexStream parseToStream(Class type, InputReferenceType reference) throws IOException {
		MimeType _mime = null;
		try {
			if(reference.getMimeType() != null && reference.getMimeType().length() > 0){
				_mime = new MimeType(reference.getMimeType());
			}
			else{
				throw new IOException("Unknown input stream type");
			}
		} catch (MimeTypeParseException e) {
			log.log(Level.SEVERE, "Failed to create MIME", e);
			throw new IOException("Failed to create MIME");
		}
		
		URL _url = new URL(reference.getHref());
		InputStream _stream = _url.openStream();
		
		return new ComplexStream(_mime, type, _stream);
	}
	
	public ComplexURL parseToUrl(Class type, ComplexDataType value) throws IOException {
		MimeType _mime = null;
		try {
			if(value.getMimeType() != null && value.getMimeType().length() > 0){
				_mime = new MimeType(value.getMimeType());
			}
			
		} catch (MimeTypeParseException e) {
			log.log(Level.SEVERE, "Failed to create MIME " + value.getMimeType(), e);
			throw new IOException("Failed to create MIME");
		}
		
		File _f = Utilities.createTempFile();
		
		NodeList _nodes = value.getDomNode().getChildNodes();
		//If only one child node
		if(_nodes.getLength() == 1 && _nodes.item(0).getNodeType() == Node.TEXT_NODE){
			if(_mime == null){
				throw new IOException("Unknown input stream type");
			}
			
			FileUtils.writeStringToFile(_f, _nodes.item(0).getNodeValue());
		}
		else{
			try {
				if(_mime == null){
					_mime = new MimeType("text/xml");
				}
			} catch (MimeTypeParseException e) {
				log.log(Level.WARNING, "Failed to create MIME text/xml", e);
			}

			//Find the element node
			for(int i=0;i<_nodes.getLength();i++){
				if(_nodes.item(i).getNodeType() == Node.ELEMENT_NODE){
					Element _ele = (new DOMBuilder()).build((org.w3c.dom.Element)_nodes.item(i));
					
					OutputStream _output = new FileOutputStream(_f);
					XMLOutputter _outputer = new XMLOutputter();
					_outputer.outputElementContent(_ele, _output);
					_output.close();
					
					break;
				}
			}
		}
		
		return new ComplexURL(_mime, type, _f.toURL());
	}

	public ComplexURL parseToUrl(Class type, InputReferenceType reference) throws MimeTypeParseException, IOException {
		MimeType _mime = null;
		if(reference.getMimeType() != null && reference.getMimeType().length() > 0){
			try {
				_mime = new MimeType(reference.getMimeType());
			} catch (MimeTypeParseException e) {
				log.log(Level.SEVERE, "Failed to create MIME", e);
				throw new IOException("Failed to create MIME");
			}
		}
		else{
				throw new IOException("Unknown input stream type");
		}
		
		URL _url = new URL(reference.getHref());
		return new ComplexURL(_mime, type, _url);
	}

	public Object parserComplex(ComplexStream object) throws IOException {
		ComplexParser _parser = this.findParser(object.getMime(), object.getType());;

		if(_parser == null){
			log.warning("Failed to find a valiable parser for " + object.toString());
			throw new NullPointerException("Failed to find a valiable parser");
		}
		
		//No params
		return _parser.parse(object.getStream(), object.getMime(), new HashMap<String, Object>());
	}
	
	public ComplexStream encodeToStream(MimeType requestMime, Object val) throws IOException {
		Class _type = val.getClass();
		MimeType _mime = requestMime;
		
		if(_mime == null){
			_mime = this.getDefaultMime4Category(_type);
		}
		
		ComplexParser _parser = this.findParser(_mime, _type);
		if(_parser == null){
			log.warning("Failed to find a valiable parser for " + _type.toString() + " MIME:" + _mime.toString());
			throw new NullPointerException("Failed to find a valiable parser");
		}
		
		ComplexDataType _value = ComplexDataType.Factory.newInstance();
		_value.setMimeType(_mime.toString());
		
		InputStream _stream = null;
		if(val == null){
			_stream = new ByteArrayInputStream(new byte[0]);
		}
		else{
			_stream = _parser.encode(val, _mime, new HashMap<String, Object>());
		}
		
		return new ComplexStream(_mime, _type, _stream);
	}
	
	
	public ComplexDataType encodeComplex(ComplexStream stream) throws IOException {
		ComplexDataType _value = ComplexDataType.Factory.newInstance();
		
		_value.setMimeType(stream.getMime().toString());		
		Document _doc = _value.getDomNode().getOwnerDocument();
		
		try {
//			IOUtils.copy(stream.getStream(), new FileOutputStream(new File(new File("D:\\mfeng\\tmp\\test3"), (new Date().getTime() + ".xml"))));
			if(stream.getMime().match("text/xml") || stream.getMime().match("text/gml")){
				Document _inputDoc = this.documentBuilder.parse(stream.getStream());
				_value.getDomNode().appendChild(_doc.importNode(_inputDoc.getDocumentElement(), true));
			}
			else{
				_value.getDomNode().appendChild(_doc.createTextNode(IOUtils.toString(stream.getStream())));
			}
		} catch (DOMException e) {
			log.log(Level.SEVERE, "DOM exception", e);
			throw new IOException(e.getMessage());
		} catch (MimeTypeParseException e) {
			log.log(Level.SEVERE, "MimeType exception", e);
			throw new IOException(e.getMessage());
		} catch (SAXException e) {
			log.log(Level.SEVERE, "SAX exception", e);
			throw new IOException(e.getMessage());
		}
		
		return _value;
	}
}
