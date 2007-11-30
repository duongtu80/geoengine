package cn.geodata.gml.define;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.jdom.Element;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;

import cn.geodata.gml.GMLConfiguration;
import cn.geodata.gml.UnsupportedType;

public class LineStringDef extends AbstractDefinition {
	private static Logger log = Logger.getAnonymousLogger();

	public LineStringDef(GMLConfiguration config){
		this.config = config;
	}

	@Override
	public boolean canEncode(Object obj) {
		if (obj instanceof LineString) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canParse(Element ele) {
		if(ele.getNamespace().equals(this.config.getUriGML())
				&& ele.getName().equals("LineString")
				){
			return true;
		}
		return false;
	}

	@Override
	public Element encode(Object obj) throws Exception {
		if(this.canEncode(obj) == false){
			throw new UnsupportedType(obj.toString());
		}
		
		LineString _line = (LineString) obj;
		
		StringBuffer _txt = new StringBuffer();
		for(Coordinate _c : _line.getCoordinates()){
			if(_txt.length() > 0){
				_txt.append(" ");
			}
			_txt.append(_c.x + " " + _c.y);
		}
		
		Element _posList = new Element("posList", this.config.getUriGML());
		_posList.setText(_txt.toString());
		_posList.setAttribute("dimension", "2");
		
		Element _ele = new Element("LineString", this.config.getUriGML());
		_ele.addContent(_posList);
		
		return _ele;
	}

	@Override
	public Object parse(Element ele) throws Exception {
		if(this.canParse(ele) == false){
			throw new UnsupportedType("Element " + ele.getName());
		}
		
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
		return _factory.createLineString((Coordinate[])_list.toArray(new Coordinate[0]));
	}
}
