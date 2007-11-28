package cn.geodata.gml.define;

import org.jdom.Element;

import cn.geodata.gml.GMLConfiguration;
import cn.geodata.gml.UnsupportedType;

import com.vividsolutions.jts.geom.Point;

public class PointDef implements Definition {
	protected GMLConfiguration config;
	
	public PointDef(GMLConfiguration config){
		this.config = config;
	}

	@Override
	public boolean canEncode(Object obj) {
		if (obj instanceof Point) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canParse(Element ele) {
		if(ele.getNamespace().getURI().equals(this.config.getUriGML().toString())
				&& ele.getName().equals("Point")
				){
			return true;
		}
		return false;
	}

	@Override
	public Element encode(Object obj) throws UnsupportedType {
		if(this.canEncode(obj) == false){
			throw new UnsupportedType();
		}
		
		return null;
	}

	@Override
	public Object parse(Element ele) {
		// TODO Auto-generated method stub
		return null;
	}

}
