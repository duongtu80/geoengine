package cn.geodata.models.data.parsers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import cn.geodata.models.data.LiteralDataParser;
import cn.geodata.models.data.Parser;
import cn.geodata.models.data.Utilities;

public class ArrayXMLParser implements Parser {
	private static Logger log = Utilities.getLogger();

	private List<MimeType> mimes;
//	private List<Class> types;
	private LiteralDataParser parser;

	public ArrayXMLParser() {
		this.mimes = new ArrayList<MimeType>();
//		this.types = new ArrayList<Class>();
		
		try {
			this.mimes.add(new MimeType("text", "xml"));
		} catch (MimeTypeParseException e) {
			log.warning("Failed to add mimes");
		}
		
		this.parser = new LiteralDataParser();
//		this.types.add(List.class);
	}
	
	public Object decode(Class type, InputStream val, MimeType mime,
			String encoding) throws IOException {
		Class _subType = type.getComponentType();

		List _list = new ArrayList();
		Document _doc = null;
		try {
			_doc = new SAXBuilder().build(val);
		} catch (JDOMException e) {
			log.log(Level.WARNING, "Failed to parse xml content", e);
		}
		
		for(Element _e : (List<Element>)_doc.getRootElement().getChildren()){
			_list.add(this.parser.encode(_subType, _e.getTextTrim()));
		}
		
		return _list.toArray((Object[])Array.newInstance(_subType, 0));
	}

	public InputStream encode(Object val, MimeType mime, String encoding) throws IOException {
		Class _type = val.getClass();
		Element _root = new Element("array");
		int _len = Array.getLength(val);
		for(int i=0;i<_len;i++){
			Element _item = new Element("value");
			_item.setText(this.parser.encode(_type, Array.get(val, i)));
			
			_root.addContent(_item);
		}
		
		Document _doc = new Document(_root);
		XMLOutputter _outputer = new XMLOutputter();
		
		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
		_outputer.output(_doc, _stream);
		
		return new ByteArrayInputStream(_stream.toByteArray());
	}

	public boolean isSupports(Class type, MimeType mime) {
		if(type.isArray() && this.parser.isLiteral(type.getComponentType())){
			for(MimeType _m : this.mimes){
				if(_m.match(mime)){
					return true;
				}
			}
		}
		
		return false;
	}

	public List<MimeType> listMimes(Class type) {
		if(type.isArray() && this.parser.isLiteral(type.getComponentType())){
			return this.mimes;
		}
		
		return null;
	}
}
