package cn.geodata.models.gml.define;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

import cn.geodata.models.gml.UnsupportedType;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

public class MultiPolygonDef extends AbstractParser {

	@Override
	public boolean canEncode(Object obj) {
		if (obj instanceof MultiPolygon) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canParse(Element ele) {
		if(ele.getNamespace().equals(this.config.getUriGML())
				&& ele.getName().equals("MultiPolygon")
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
		
		Element _ele = new Element("MultiPolygon", this.config.getUriGML());
		MultiPolygon _polys = (MultiPolygon) obj;

		for(int i=0;i<_polys.getNumGeometries();i++){
			Element _member = new Element("polygonMember", this.config.getUriGML());
			_member.addContent(this.getParserFinder().encode(_polys.getGeometryN(i)));
			
			_ele.addContent(_member);
		}
		
		return _ele;
	}

	@Override
	public Object parse(Element ele) throws IOException {
		if(this.canParse(ele) == false){
			throw new UnsupportedType("Element " + ele.getName());
		}
		
		ArrayList<Polygon> _polys = new ArrayList<Polygon>();
		for(Element _lineMemberNode : (List<Element>)ele.getChildren("polygonMember", this.config.getUriGML())){
			Polygon _poly = (Polygon) this.getParserFinder().parse(_lineMemberNode.getChild("Polygon", this.config.getUriGML()));
			_polys.add(_poly);
		}
		
		GeometryFactory _factory = new GeometryFactory();
		return _factory.createMultiPolygon((Polygon[])_polys.toArray(new Polygon[0]));
	}
}
