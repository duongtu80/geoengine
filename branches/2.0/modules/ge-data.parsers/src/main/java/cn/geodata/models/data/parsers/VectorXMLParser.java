package cn.geodata.models.data.parsers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

import org.geotools.feature.FeatureCollection;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import cn.geodata.models.data.Parser;
import cn.geodata.models.gml.ParserFinder;
import cn.geodata.models.gml.ParserUtil;

import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

public class VectorXMLParser implements Parser {
	private Logger log = Logger.getAnonymousLogger();
	
	private List<MimeType> mimes;
	private List<Class> types;
	private ParserFinder finder;
	
	public VectorXMLParser(){
		this.mimes = new ArrayList<MimeType>();
		this.types = new ArrayList<Class>();
		
		try {
			this.mimes.add(new MimeType("text", "xml"));
		} catch (MimeTypeParseException e) {
			log.warning("Failed to add mimes");
		}
		
		this.types.add(Point.class);
		this.types.add(MultiPoint.class);
		this.types.add(LineString.class);
		this.types.add(MultiLineString.class);
		this.types.add(Polygon.class);
		this.types.add(MultiPolygon.class);
		this.types.add(FeatureCollection.class);
		
		this.finder = ParserUtil.createParserFinder();
	}

	public Object decode(Class type, InputStream val, MimeType mime, String encoding) throws IOException {
		try {
			return this.finder.parse((new SAXBuilder()).build(val).getRootElement());
		} catch (JDOMException e) {
			log.log(Level.SEVERE, "Failed to parse the xml", e);
			throw new IOException("Failed to parse the xml");
		}
	}

	public InputStream encode(Object val, MimeType mime, String encoding) throws IOException {
		Element _ele = finder.encode(val);
		XMLOutputter _outputter = new XMLOutputter();
		
		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
		_outputter.output(_ele, _stream);

		return new ByteArrayInputStream(_stream.toByteArray());
	}

	public boolean isSupports(Class type, MimeType mime) {
		if(this.types.contains(type)){
			for(MimeType _m : this.mimes){
				if(_m.match(mime)){
					return true;
				}
			}
		}
		return false;
	}

	public List<MimeType> listMimes(Class type) {
		if(this.types.contains(type)){
			return this.mimes;
		}
		
		return null;
	}
}
