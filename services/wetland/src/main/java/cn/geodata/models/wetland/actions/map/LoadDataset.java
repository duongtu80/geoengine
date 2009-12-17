package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.logging.Logger;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.jdom.output.XMLOutputter;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.feature.type.AttributeDescriptor;

import cn.geodata.models.gml.ParserUtil;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiLineString;

public class LoadDataset {
	private Logger log = Logger.getAnonymousLogger();

	// private String dataset;
	private InputStream stream;
	private String dataset;
	private Catchment catchment;
	
	public LoadDataset(Catchment catchment){
		this.catchment = catchment;
	}

	public InputStream getStream() {
		return stream;
	}
	
	public void setDataset(String dataset) {
		this.dataset = dataset;
	}

	public String execute() throws Exception {
		FeatureCollection _fs = null;
		
		if(this.dataset == null || this.dataset.length() == 0 || this.dataset.equalsIgnoreCase("basins")){
			_fs = this.loadBasins();
		}
		else if(this.dataset.equalsIgnoreCase("boundary")){
			_fs = this.loadBasinBoundary();
		}
		else{
			throw new Exception("Unknow dataset name:" + this.dataset);
		}
		
		XMLOutputter _output = new XMLOutputter();
		String _txt = _output.outputString(ParserUtil.createParserFinder().encode(_fs));

		this.stream = new ByteArrayInputStream(_txt.getBytes("utf-8"));
		return "success";
	}
	
	private FeatureCollection loadBasins() throws Exception {
		return this.catchment.getCatchments();
	}
	
	private FeatureCollection loadBasinBoundary() throws Exception {
		SimpleFeatureType _ft1 = (SimpleFeatureType) this.catchment.getFeatures().getSchema();

		SimpleFeatureTypeBuilder _builder = new SimpleFeatureTypeBuilder();
		_builder.setName("boundary");
		
		Iterator<AttributeDescriptor> _itt = _ft1.getAttributeDescriptors().iterator();
		while(_itt.hasNext()){
			AttributeDescriptor _attr = _itt.next();
			
			if(Geometry.class.isAssignableFrom(_attr.getClass())){
				_builder.add(_attr.getLocalName(), MultiLineString.class);
			}
			else{
				_builder.add(_attr);
			}
		}
		_itt.remove();
		
		SimpleFeatureType _ft = _builder.buildFeatureType();
		
		FeatureCollection<SimpleFeatureType, SimpleFeature> _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		FeatureIterator<SimpleFeature> _it = this.catchment.getCatchments().features();
		while(_it.hasNext()){
			SimpleFeatureBuilder _bb = new SimpleFeatureBuilder(_ft);
			Iterator<Object> _vit = _it.next().getAttributes().iterator();
			
			while(_vit.hasNext()){
				Object _b = _vit.next();
				
				if (_b instanceof Geometry) {
					Geometry _geo = (Geometry) _b;
					_bb.add(_geo.getBoundary());
				}
				else
					_bb.add(_b);
			}
			
			_fs.add(_bb.buildFeature(null));
		}
		
		return _fs;
	}
}
