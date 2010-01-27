package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.util.logging.Logger;

import net.sf.json.JSONObject;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.jdom.output.XMLOutputter;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import cn.geodata.models.ProcessLibrary;
import cn.geodata.models.Processing;
import cn.geodata.models.gml.ParserUtil;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiPolygon;

public class WaterRegionStart extends ProcessStart {
	private static Logger log = Logger.getAnonymousLogger();
	private Catchment catchment;
	
	public WaterRegionStart(Catchment catchment){
		this.catchment = catchment;
	}

	public String execute() throws Exception {
		XMLOutputter _output = new XMLOutputter();
//		try{
			//Input Parameters
			String _basin = this.params.getString("basin");
			double _waterLevel = this.params.getDouble("level");
			
			JSONObject _params = this.params.getJSONObject("params");
	
			//Processing
			ProcessLibrary _library = ProcessLibrary.createInstance();
			Processing _regionModel = this.createProcess(_library, _params.getJSONObject("WaterRegion"));
			
			MultiPolygon _border = this.catchment.findCatchmentByTag(_basin);
			_regionModel.setInput("Catchment", _border);
			_regionModel.setInput("WaterLevel", _waterLevel);
	
			//Execute the process
			_library.executeProcess(_regionModel);
			
			//Serialize output feature collection
			
			
			FeatureCollection _fs = this.createFeatureCollection((Geometry) _regionModel.getOutput("WaterRegion"));
			String _txt = _output.outputString(ParserUtil.createParserFinder().encode(_fs));
			this.stream = new ByteArrayInputStream(_txt.getBytes("utf-8"));
//		}
//		catch(Exception err){
//			org.jdom.Element _err = new org.jdom.Element("error");
//			_err.setText(err.getMessage());
//			
//			this.stream = new ByteArrayInputStream(_output.outputString(_err).getBytes("utf-8"));			
//		}
		
		return "success";
	}
	
	private FeatureCollection<SimpleFeatureType, SimpleFeature> createFeatureCollection(Geometry geom){
		FeatureCollection<SimpleFeatureType, SimpleFeature> _col = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();

		if(geom == null)
			return _col;
		
		SimpleFeatureTypeBuilder _typeBuilder = new SimpleFeatureTypeBuilder();
		_typeBuilder.setName("Water");
		_typeBuilder.add("shape", geom.getClass());
		
		SimpleFeatureBuilder _featureBuilder = new SimpleFeatureBuilder(_typeBuilder.buildFeatureType());
		_featureBuilder.add(geom);
		
		_col.add(_featureBuilder.buildFeature(null));
		
		return _col;
	}
	
}
