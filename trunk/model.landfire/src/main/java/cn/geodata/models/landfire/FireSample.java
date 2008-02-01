package cn.geodata.models.landfire;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.configuration.HierarchicalConfiguration;
import org.geotools.data.FeatureStore;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.FactoryRegistryException;
import org.geotools.factory.GeoTools;
import org.geotools.feature.AttributeType;
import org.geotools.feature.AttributeTypeFactory;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureType;
import org.geotools.feature.IllegalAttributeException;
import org.geotools.feature.SchemaException;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.vividsolutions.jts.geom.Point;

public class FireSample {
	private Logger log = Logger.getAnonymousLogger();
	private HierarchicalConfiguration config;
	private XmlBeanFactory beanFactory;
	
	public FireSample(){
		this.beanFactory = new XmlBeanFactory(new ClassPathResource("/META-INF/fireModelLib.xml"));
		this.config = (new Configure()).getSubConfig("sample");
	}
	
	public void doSamples() throws IOException, FactoryRegistryException, SchemaException, IllegalAttributeException, MismatchedDimensionException, TransformException{
		double _numFactor = config.getDouble("numFactor");
		double _minDistance = config.getDouble("minDistance");
		int _maxTry = config.getInt("maxTry");
		File _repositoryPath = new File(config.getString("shapefile"));
		double _bufferFactor = config.getDouble("bufferFactor");
		File _output = new File(config.getString("outputShp"));
		
		log.info("numFactor:" + _numFactor);
		log.info("minDistance:" + _minDistance);
		log.info("maxTry:" + _maxTry);
		log.info("bufferFactor:" + _bufferFactor);

		if(_repositoryPath.exists() == false){
			throw new FileNotFoundException(_repositoryPath.toString());
		}

		log.info("repository:" + _repositoryPath.getAbsolutePath());
		log.info("output:" + _output.getAbsolutePath());
		
		List<AbstractSampleModel> _models = new ArrayList<AbstractSampleModel>();
		for(String _model : config.getStringArray("models")){
			log.info("add model:" + _model);
			String _modelType = config.getString(_model + ".type", "");
			if(_modelType.equalsIgnoreCase("standard")){
				_models.add(new StandardRasterModel(_model, config.configurationAt(_model)));
			}
			else{
				_models.add((AbstractSampleModel)this.beanFactory.getBean(_model));
			}
		}

		CollectSamples _collect = (CollectSamples)this.beanFactory.getBean("collectSamples");
		Map<String, AttributeType> _fields = _collect.getFields();
		
		for(AbstractSampleModel _model: _models){
			for(String _f : _model.getFields()){
				if(_fields.containsKey(_f) == false){
					_fields.put(_f, AttributeTypeFactory.newAttributeType(_f, Double.class));
				}
			}
		}
		
		for(String _k : _fields.keySet()){
			log.info("field:" + _k + " " + _fields.get(_k).getBinding().getName());
		}
		
		FeatureType _featureType = CommonFactoryFinder.getFeatureTypeFactory(GeoTools.getDefaultHints()).newFeatureType((AttributeType[])_fields.values().toArray(new AttributeType[0]), _output.getName());		
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		
		List<String> _ids = this.retrieveIdList(_repositoryPath);
		for(String _id : _ids){
			List<Map<String, Object>> _result = _collect.findSamples(_id, _numFactor, _minDistance, _bufferFactor, _maxTry);
			
			log.info("process " + _id);
			for(int i=0;i<_result.size();i++){
				log.info("  sample...");
				
				Map<String, Object> _vals = _result.get(i);
				Point _pt = (Point) _vals.get("sample");

				log.info("  point count:" + _vals.size());
				for(AbstractSampleModel _model: _models){
					Double[] _results = _model.getSample(_id, _pt);
					
					log.info("    process model " + _model.getModelName() + "...");
					for (int j = 0; j < _results.length; j++) {
						
						String _colName = _model.getFields()[j];
						if(_vals.containsKey(_colName) == false){
							_vals.put(_colName, _results[j]);
						}
					}
				}
				
				log.info("  create feature...");
				List<Object> _fldValues = new ArrayList<Object>();
				for(int m=0;m < _featureType.getAttributeCount();m++){
					_fldValues.add(_vals.get(_featureType.getAttributeType(m).getLocalName()));
				}
				
				_fs.add(_featureType.create(_fldValues.toArray()));
			}
		}
		
		log.info("save features...");
		ShapefileDataStore _dataStore = new ShapefileDataStore(_output.toURL());
		_dataStore.createSchema(_featureType);
		
		FeatureStore _featureStore = (FeatureStore) _dataStore.getFeatureSource();
		_featureStore.addFeatures(_fs);
		
		log.info("finished. " + _fs.size() + " features saved.");
	}
	
	private List<String> retrieveIdList(File repository) {
		List<String> _list = new ArrayList<String>();
		for(File _f : repository.listFiles()){
			if(_f.isDirectory()){
				File _shp = new File(_f, _f.getName() + ".shp");
				if(_shp.exists()){
					log.info("add id " + _f.getName());
					_list.add(_f.getName());
				}
			}
		}
		
		return _list;
	}
	
	public static void main(String[] args) throws FactoryRegistryException, Throwable, SchemaException, IllegalAttributeException {
		FireSample _sample = new FireSample();
		_sample.doSamples();
	}
}
