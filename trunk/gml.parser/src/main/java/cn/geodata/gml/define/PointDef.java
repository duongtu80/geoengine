package cn.geodata.gml.define;

import java.util.logging.Logger;

import org.jdom.Element;

import cn.geodata.gml.GMLConfiguration;
import cn.geodata.gml.UnsupportedType;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class PointDef extends AbstractParser {
	private static Logger log = Logger.getAnonymousLogger();
	
	@Override
	public boolean canEncode(Object obj) {
		if (obj instanceof Point) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canParse(Element ele) {
		if(ele.getNamespace().equals(this.config.getUriGML())
				&& ele.getName().equals("Point")
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
		
		Point _pt = (Point) obj;
		
		Element _pos = new Element("pos", this.config.getUriGML());
		_pos.setText(_pt.getX() + " " + _pt.getY());

		Element _ele = new Element("Point", this.config.getUriGML());
		_ele.addContent(_pos);
		
		return _ele;
	}

	@Override
	public Object parse(Element ele) throws Exception {
		if(this.canParse(ele) == false){
			throw new UnsupportedType("Element " + ele.getName());
		}
		
		String[] _items = null;
		Element _posNode = ele.getChild("pos", this.config.getUriGML());
		if(_posNode != null){
			_items = _posNode.getTextTrim().split("\\s+");
		}
		else{
			Element _coor = ele.getChild("coordinates", this.config.getUriGML());
			if(_coor != null){
				String _splitor = _coor.getAttributeValue("cs");
				if(_splitor == null){
					_splitor = ",";
				}
				_items = _coor.getTextTrim().split(_splitor);
			}
		}
		
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
