package cn.geodata.models.gml.define;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.jdom.Element;

import cn.geodata.models.gml.ParserUtil;
import cn.geodata.models.gml.UnsupportedType;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;

public class PolygonDef extends AbstractParser {
	private static Logger log = ParserUtil.getLogger();

	public boolean canEncode(Object obj) {
		if (obj instanceof Polygon) {
			return true;
		}
		return false;
	}

	public boolean canParse(Element ele) {
		if(ele.getNamespace().equals(this.config.getUriGML())
				&& ele.getName().equals("Polygon")
				){
			return true;
		}
		return false;
	}
	
	protected Element encodeLinearRing(LineString ring){
		StringBuffer _txt = new StringBuffer();
		for(Coordinate _c : ring.getCoordinates()){
			if(_txt.length() > 0){
				_txt.append(" ");
			}
			_txt.append(_c.x + " " + _c.y);
		}
		
		Element _posList = new Element("posList", this.config.getUriGML());
		_posList.setText(_txt.toString());
		_posList.setAttribute("dimension", "2");
		
		Element _ele = new Element("LinearRing", this.config.getUriGML());
		_ele.addContent(_posList);
		
		return _ele;
	}
	
	public Object parseLinearRing(Element ele) throws IOException {
		ArrayList<Coordinate> _list = new ArrayList<Coordinate>();
		Element _posList = ele.getChild("posList", this.config.getUriGML());
		int _count = Integer.parseInt(_posList.getAttributeValue("dimension"));
		
		String[] _items = _posList.getTextTrim().split("\\s+");
		for (int i = 0; i < _items.length / _count; i++) {
			double _x = Double.parseDouble(_items[0]);
			double _y = Double.parseDouble(_items[1]);

			double _z = 0;
			if(_items.length > 2){
				_z = Double.parseDouble(_items[2]);
			}
			
			_list.add(new Coordinate(_x, _y, _z));
		}
		
		GeometryFactory _factory = new GeometryFactory();
		return _factory.createLinearRing((Coordinate[])_list.toArray(new Coordinate[0]));
	}
	
	public Element encode(Object obj) throws IOException {
		if(this.canEncode(obj) == false){
			throw new UnsupportedType(obj.toString());
		}
		
		Polygon _poly = (Polygon) obj;
		
		Element _ele = new Element("Polygon", this.config.getUriGML());
		if(_poly.getExteriorRing() != null){
			Element _ring = this.encodeLinearRing(_poly.getExteriorRing());
			_ring.setName("exterior");
			
			_ele.addContent(_ring);
		}
		
		for(int i=0;i<_poly.getNumInteriorRing();i++){
			Element _ring = this.encodeLinearRing(_poly.getInteriorRingN(i));
			_ring.setName("interior");
			
			_ele.addContent(_ring);
		}
		
		return _ele;
	}

	public Object parse(Element ele) throws IOException {
		if(this.canParse(ele) == false){
			throw new UnsupportedType("Element " + ele.getName());
		}
		
		LinearRing _exterior = null;
		Element _exteriorNode = ele.getChild("exterior", this.config.getUriGML());
		if(_exteriorNode != null){
			_exterior = (LinearRing) this.parseLinearRing(_exteriorNode);
		}
		
		ArrayList<LinearRing> _interiors = new ArrayList<LinearRing>();
		for(Element _r : (List<Element>) ele.getChildren("interior", this.config.getUriGML())){
			_interiors.add((LinearRing)this.parseLinearRing(_r));
		}
		
		GeometryFactory _factory = new GeometryFactory();
		return _factory.createPolygon(_exterior, (LinearRing[])_interiors.toArray(new LinearRing[0]));
	}

}
