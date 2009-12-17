package cn.geodata.models.data;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.activation.MimeType;

import cn.geodata.models.data.parsers.ArrayXMLParser;
import cn.geodata.models.data.parsers.VectorXMLParser;

public class ComplexDataParser {
	private Logger log = Logger.getAnonymousLogger();
	private List<Parser> parsers;

	public ComplexDataParser(){
		this.parsers = new ArrayList<Parser>();
		this.parsers.add(new VectorXMLParser());
		this.parsers.add(new ArrayXMLParser());
	}
	
	public Object decode(Class type, InputStream val, MimeType mime, String encoding) throws IOException {
		Parser _p = this.findParser(type, mime);
		return _p.decode(type, val, mime, encoding);
	}

	public InputStream encode(Object val, MimeType mime, String encoding) throws IOException {
		if(val == null){
			return new ByteArrayInputStream(new byte[0]);
		}

		Parser _p = this.findParser(val.getClass(), mime);
		return _p.encode(val, mime, encoding);
	}
	
	private Parser findParser(Class type, MimeType mime){
		for(Parser _p : this.parsers){
			if(_p.isSupports(type, mime)){
				return _p;
			}
		}
		
		log.warning("Failed to find a parser for type " + type.getName() + " mime " + mime.toString());
		return null;
	}

	public List<MimeType> getMimes(Class type) {
		List<MimeType> _mimes = new ArrayList<MimeType>();
		
		for(Parser _p : this.parsers){
			List<MimeType> _ms = _p.listMimes(type);
			if(_ms != null)
				_mimes.addAll(_ms);
		}

		return _mimes;
	}
}
