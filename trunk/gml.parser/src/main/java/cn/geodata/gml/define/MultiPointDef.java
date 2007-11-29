package cn.geodata.gml.define;

import org.jdom.Element;

import cn.geodata.gml.GMLConfiguration;
import cn.geodata.gml.UnsupportedType;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.Point;

public class MultiPointDef implements Definition {
	protected GMLConfiguration config;
	
	public MultiPointDef(GMLConfiguration config){
		this.config = config;
	}

	@Override
	public boolean canEncode(Object obj) {
		if (obj instanceof MultiPoint) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canParse(Element ele) {
		if(ele.getNamespace().equals(this.config.getUriGML())
				&& ele.getName().equals("MultiPoint")
				){
			return true;
		}
		return false;
	}

	@Override
	public Element encode(Object obj) throws Exception {
		if(this.canEncode(obj) == false){
			throw new UnsupportedType();
		}
		
		Element _ele = new Element("MultiPoint", this.config.getUriGML());
		MultiPoint _pts = (MultiPoint) obj;

		PointDef _pointDef = new PointDef(this.config);
		for(int i=0;i<_pts.getNumPoints();i++){
			Element _member = new Element("pointMember", this.config.getUriGML());
			_member.addContent(_pointDef.encode(_pts.getGeometryN(i)));
		}
		
		return _ele;
	}

	@Override
	public Object parse(Element ele) throws Exception {
		if(this.canParse(ele) == false){
			throw new UnsupportedType();
		}
		
		String[] _items = ele.getChild("pos", this.config.getUriGML()).getTextTrim().split("\\s+");
		
		double _x = Double.parseDouble(_items[0]);
		double _y = Double.parseDouble(_items[1]);

		double _z = 0;
		if(_items.length > 2){
			_z = Double.parseDouble(_items[2]);
		}
		
		GeometryFactory _factory = new GeometryFactory();
		Point _pt = _factory.createPoint(new Coordinate(_x, _y, _z));

		return _pt;
	}
}
