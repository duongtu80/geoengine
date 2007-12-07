package cn.geodata.gml.define;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.feature.FeatureType;
import org.jdom.Element;

import cn.geodata.gml.FeatureParser;
import cn.geodata.gml.ParserUtil;
import cn.geodata.gml.UnsupportedType;

public class FeatureCollectionDef extends AbstractParser {
	private static Logger log = ParserUtil.getLogger();

	@Override
	public boolean canEncode(Object obj) {
		if (obj instanceof FeatureCollection) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canParse(Element ele) {
		if((ele.getNamespace().equals(this.config.getUriGML()) || (ele.getNamespace().equals(this.config.getUriWFS()) ))
				&& ele.getName().equals("FeatureCollection")
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
		
		Element _ele = new Element("FeatureCollection", this.config.getUriGML());

		FeatureCollection _fs = (FeatureCollection) obj;
		FeatureIterator _it = _fs.features();
		try{
			while(_it.hasNext()){
				Element _fm = new Element("featureMember", this.config.getUriGML());
				_fm.addContent(this.finder.encode(_it.next()));
				
				_ele.addContent(_fm);
			}
		}
		finally{
			_it.close();
		}

		return _ele;
	}

	@Override
	public Object parse(Element ele) throws IOException {
		if(this.canParse(ele) == false){
			throw new UnsupportedType("Element " + ele.getName());
		}
		
		FeatureParser _featureParser = this.finder.findFeatureParser();
		
		List<Element> _list = new ArrayList<Element>();
		for(Element _fm : (List<Element>)ele.getChildren("featureMember", this.config.getUriGML())){
			_list.add((Element)_fm.getChildren().get(0));
		}
		
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		FeatureType _featureType = _featureParser.parseFeatureType((Element[])_list.toArray(new Element[0]));
		for(Element _ele : _list){
			_fs.add(_featureParser.parse(_featureType, _ele));
		}
		
		return _fs;
	}
}
