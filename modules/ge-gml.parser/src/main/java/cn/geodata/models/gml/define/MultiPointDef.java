package cn.geodata.models.gml.define;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

import cn.geodata.models.gml.UnsupportedType;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.Point;

public class MultiPointDef extends AbstractParser {

	public boolean canEncode(Object obj) {
		if (obj instanceof MultiPoint) {
			return true;
		}
		return false;
	}

	public boolean canParse(Element ele) {
		if(ele.getNamespace().equals(this.config.getUriGML())
				&& ele.getName().equals("MultiPoint")
				){
			return true;
		}
		return false;
	}

	public Element encode(Object obj) throws IOException {
		if(this.canEncode(obj) == false){
			throw new UnsupportedType(obj.toString());
		}
		
		Element _ele = new Element("MultiPoint", this.config.getUriGML());
		MultiPoint _pts = (MultiPoint) obj;

		for(int i=0;i<_pts.getNumPoints();i++){
			Element _member = new Element("pointMember", this.config.getUriGML());
			_member.addContent(this.getParserFinder().encode(_pts.getGeometryN(i)));
		}
		
		return _ele;
	}

	public Object parse(Element ele) throws IOException {
		if(this.canParse(ele) == false){
			throw new UnsupportedType("Element " + ele.getName());
		}
		
		ArrayList<Coordinate> _pts = new ArrayList<Coordinate>();
		for(Element _ptMemberNode : (List<Element>)ele.getChildren("pointMember", this.config.getUriGML())){
			Point _pt = (Point) this.getParserFinder().parse(_ptMemberNode.getChild("Point", this.config.getUriGML()));
			_pts.add(_pt.getCoordinate());
		}
		
		GeometryFactory _factory = new GeometryFactory();
		return _factory.createMultiPoint((Coordinate[])_pts.toArray(new Coordinate[0]));
	}
}
