package cn.geodata.gml.define;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

import cn.geodata.gml.UnsupportedType;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;

public class MultiLineStringDef extends AbstractParser {

	@Override
	public boolean canEncode(Object obj) {
		if (obj instanceof MultiLineString) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canParse(Element ele) {
		if(ele.getNamespace().equals(this.config.getUriGML())
				&& ele.getName().equals("MultiLineString")
				){
			return true;
		}
		return false;
	}

	@Override
	public Element encode(Object obj) throws IOException {
		if(this.canEncode(obj) == false){
			throw new UnsupportedType(obj.toString());
		}
		
		Element _ele = new Element("MultiLineString", this.config.getUriGML());
		MultiLineString _lines = (MultiLineString) obj;

		for(int i=0;i<_lines.getNumGeometries();i++){
			Element _member = new Element("lineStringMember", this.config.getUriGML());
			_member.addContent(this.getParserFinder().encode(_lines.getGeometryN(i)));

			_ele.addContent(_member);
		}
		
		return _ele;
	}

	@Override
	public Object parse(Element ele) throws IOException {
		if(this.canParse(ele) == false){
			throw new UnsupportedType("Element " + ele.getName());
		}
		
		ArrayList<LineString> _lines = new ArrayList<LineString>();
		for(Element _lineMemberNode : (List<Element>)ele.getChildren("lineStringMember", this.config.getUriGML())){
			LineString _line = (LineString) this.getParserFinder().parse(_lineMemberNode.getChild("LineString", this.config.getUriGML()));
			_lines.add(_line);
		}
		
		GeometryFactory _factory = new GeometryFactory();
		return _factory.createMultiLineString((LineString[])_lines.toArray(new LineString[0]));
	}
}
