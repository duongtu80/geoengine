package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Logger;

import net.sf.json.JSONObject;

import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.feature.AttributeType;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.feature.FeatureType;
import org.geotools.feature.SchemaException;
import org.jdom.output.XMLOutputter;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPolygon;

import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;
import cn.geodata.models.gml.ParserUtil;

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
		FeatureType _ft1 = this.catchment.getFeatures().getSchema();

		AttributeType[] _attrs = _ft1.getAttributeTypes().clone();
		for(int i=0;i<_attrs.length;i++){
			if(Geometry.class.isAssignableFrom(_attrs[i].getBinding())){
				_attrs[i] = (CommonFactoryFinder.getAttributeTypeFactory(GeoTools.getDefaultHints()).newAttributeType(_attrs[i].getLocalName(), MultiLineString.class));
			}
		}
		FeatureType _ft = CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType(_attrs, "boundary");
		
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		FeatureIterator _it = this.catchment.getCatchments().features();
		while(_it.hasNext()){
			Feature _f = _it.next();
			
			Object[] _vs = new Object[_attrs.length];
			for(int i=0;i<_attrs.length;i++){
				if(Geometry.class.isAssignableFrom(_attrs[i].getBinding()) == false){
					_vs[i] = _f.getAttribute(_attrs[i].getLocalName());
				}
				else{
					_vs[i] = _f.getDefaultGeometry().getBoundary();
				}
			}
			
			_fs.add(_ft.create(_vs));
		}
		
		return _fs;
	}
}
