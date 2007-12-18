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
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.opengeospatial.wps.ComplexValueType;
import net.opengeospatial.wps.IOValueType;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jdom.Element;
import org.jdom.input.DOMBuilder;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.geoprocessing.ValueType;

public class ComplexParsers {
	private static Logger log = Logger.getAnonymousLogger();
	
	private List<ComplexParser> parsers;

	public List<ComplexParser> getParsers() {
		return parsers;
	}

	public void setParsers(List<ComplexParser> parsers) {
		this.parsers = parsers;
	}
	
	public boolean supports(DataCategory category, MimeType mime){
		for(ComplexParser _parser : this.parsers){
			if(_parser.getCategories().contains(category) && _parser.getMimes().contains(mime)){
				return true;
			}
		}
		return false;
	}
	
	public ComplexParser findParser(MimeType mimeType, DataCategory category){
		for(ComplexParser _p : this.parsers){
			if(_p.getMimes().contains(mimeType) && _p.getCategories().contains(category)){
				return _p;
			}
		}
		
		log.warning("Not found parser for " + mimeType + " category:" + category);
		return null;
	}
	
	public List<MimeType> getMimes4Category(DataCategory category) {
		List<MimeType> _list = new ArrayList<MimeType>();
		for(ComplexParser _p : this.parsers){
			if(_p.getCategories().contains(category)){
				_list.addAll(_p.getMimes());
			}
		}
		
		return _list;
	}
	
	public MimeType getDefaultMime4Category(DataCategory category) {
		return this.getMimes4Category(category).get(0);
	}
	
	public ComplexStream parseToStream(ValueType type, ComplexValueType value) throws IOException {
		MimeType _mime = null;
		try {
			_mime = new MimeType("text/xml");
			if(value.getFormat() != null && value.getFormat().length() > 0){
				_mime = new MimeType(value.getFormat());
			}
			
		} catch (MimeTypeParseException e) {
			log.log(Level.SEVERE, "Failed to create MIME", e);
			throw new IOException("Failed to create MIME");
		}
		
		List<DataCategory> _list = new ArrayList<DataCategory>();
		for(String _c : type.getCategoryArray()){
			_list.add(DataCategories.getInstance().findCategory(_c));
		}
		
		InputStream _stream = null;
		NodeList _nodes = value.getDomNode().getChildNodes();
		//If only one child node
		if(_nodes.getLength() == 1 && _nodes.item(0).getNodeType() == Node.TEXT_NODE){
			_stream = new ByteArrayInputStream(_nodes.item(0).getNodeValue().getBytes());
		}
		else{
			//Find the element node
			for(int i=0;i<_nodes.getLength();i++){
				if(_nodes.item(i).getNodeType() == Node.ELEMENT_NODE){
					Element _ele = (new DOMBuilder()).build((org.w3c.dom.Element)_nodes.item(i));
					
					ByteArrayOutputStream _out = new ByteArrayOutputStream();
					XMLOutputter _outputer = new XMLOutputter();
					_outputer.outputElementContent(_ele, _out);
					
					_stream = new ByteArrayInputStream(_out.toByteArray());
				}
			}
			if(_stream == null){
				log.warning("Failed to find value element");
				throw new NullPointerException("Failed to find value element");
			}
		}
		
		return new ComplexStream(_mime, _list, _stream);
	}

	public ComplexStream parseToStream(ValueType type, IOValueType.ComplexValueReference reference) throws IOException {
		MimeType _mime = null;
		try {
			_mime = new MimeType("text/xml");
			if(reference.getFormat() != null && reference.getFormat().length() > 0){
				_mime = new MimeType(reference.getFormat());
			}
		} catch (MimeTypeParseException e) {
			log.log(Level.SEVERE, "Failed to create MIME", e);
			throw new IOException("Failed to create MIME");
		}
		
		List<DataCategory> _list = new ArrayList<DataCategory>();
		for(String _c : type.getCategoryArray()){
			_list.add(DataCategories.getInstance().findCategory(_c));
		}
		
		URL _url = new URL(reference.getReference());
		InputStream _stream = _url.openStream();
		
		return new ComplexStream(_mime, _list, _stream);
	}
	
	public ComplexURL parseToUrl(ValueType type, ComplexValueType value) throws MimeTypeParseException, IOException {
		MimeType _mime = new MimeType("text/xml");
		if(value.getFormat() != null && value.getFormat().length() > 0){
			_mime = new MimeType(value.getFormat());
		}
		
		List<DataCategory> _list = new ArrayList<DataCategory>();
		for(String _c : type.getCategoryArray()){
			_list.add(DataCategories.getInstance().findCategory(_c));
		}
		
		File _f = Utilities.createTempFile();
		
		NodeList _nodes = value.getDomNode().getChildNodes();
		//If only one child node
		if(_nodes.getLength() == 1 && _nodes.item(0).getNodeType() == Node.TEXT_NODE){
			FileUtils.writeStringToFile(_f, _nodes.item(0).getNodeValue());
		}
		else{
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
		
		return new ComplexURL(_mime, _list, _f.toURL());
	}

	public ComplexURL parseToUrl(ValueType type, IOValueType.ComplexValueReference reference) throws MimeTypeParseException, IOException {
		MimeType _mime = new MimeType("text/xml");
		if(reference.getFormat() != null && reference.getFormat().length() > 0){
			_mime = new MimeType(reference.getFormat());
		}
		
		List<DataCategory> _list = new ArrayList<DataCategory>();
		for(String _c : type.getCategoryArray()){
			_list.add(DataCategories.getInstance().findCategory(_c));
		}
		
		URL _url = new URL(reference.getReference());
		return new ComplexURL(_mime, _list, _url);
	}

	public Object parserComplex(ComplexStream object) throws IOException {
		ComplexParser _parser = null;
		for(DataCategory _c : object.getCategories()){
			_parser = this.findParser(object.getMime(), _c);
			if(_parser != null){
				break;
			}
		}

		if(_parser == null){
			log.warning("Failed to find a valiable parser for " + object.toString());
			throw new NullPointerException("Failed to find a valiable parser");
		}
		
		//No params
		return _parser.parse(object.getStream(), object.getMime(), new HashMap<String, Object>());
	}
	
	public ComplexStream encodeToStream(ValueType type, MimeType requestMime, Object val) throws IOException {
		DataCategory _category = null;
		for(String _cat : type.getCategoryArray()){
			DataCategory _c = DataCategories.getInstance().findCategory(_cat);
			if(_c.getClass().isInstance(val)){
				_category = _c;
				break;
			}
		}
		
		if(_category == null){
			log.warning("The output value is not valiable type:" + val.getClass().toString() + " list:" + Arrays.toString(type.getCategoryArray()));
			throw new NullPointerException("The output value is not valiable type");
		}
		
		MimeType _mime = requestMime;
		if(_mime == null){
			_mime = this.getDefaultMime4Category(_category);
		}
		
		ComplexParser _parser = this.findParser(_mime, _category);
		if(_parser == null){
			log.warning("Failed to find a valiable parser for " + _category.toString() + " MIME:" + _mime.toString());
			throw new NullPointerException("Failed to find a valiable parser");
		}
		
		ComplexValueType _value = ComplexValueType.Factory.newInstance();
		_value.setEncoding(_mime.toString());
		
		InputStream _stream = _parser.encode(val, _mime, new HashMap<String, Object>());
		
		return new ComplexStream(_mime, Arrays.asList(new DataCategory[] {_category}), _stream);
	}
	
	
	public ComplexValueType encodeComplex(ComplexStream stream) throws IOException {
		ComplexValueType _value = ComplexValueType.Factory.newInstance();
		
		_value.setEncoding(stream.getMime().toString());		
		Document _doc = _value.getDomNode().getOwnerDocument();
		
		try {
			if(stream.getMime().match("text/xml")){
				Document _inputDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(stream.getStream());
				_value.getDomNode().appendChild(_doc.importNode(_inputDoc.getDocumentElement(), true));
			}
			else{
				_value.getDomNode().appendChild(_doc.createTextNode(IOUtils.toString(stream.getStream())));
			}
		} catch (DOMException e) {
			log.log(Level.SEVERE, "DOM exception", e);
			throw new IOException(e);
		} catch (MimeTypeParseException e) {
			log.log(Level.SEVERE, "MimeType exception", e);
			throw new IOException(e);
		} catch (SAXException e) {
			log.log(Level.SEVERE, "SAX exception", e);
			throw new IOException(e);
		} catch (ParserConfigurationException e) {
			log.log(Level.SEVERE, "ParserConfigurationException", e);
			throw new IOException(e);
		}
		
		return _value;
	}
}
