package cn.geodata.models.sealevel;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.geotools.data.FeatureSource;
import org.geotools.data.FeatureStore;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.feature.FeatureType;
import org.opengis.filter.Filter;
import org.opengis.filter.FilterFactory2;

public class CreateTMdataset {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		if(args.length != 2){
			System.out.println("usage: CreateTMdataset [inputfile] [outputfile]");
		}
		
		File _input = new File(args[0]);
		File _output = new File(args[1]);
		
		CreateTMdataset _obj = new CreateTMdataset();
		_obj.createTMdataset(_input, _output);
	}
	
	public void createTMdataset(File input, File output) throws IOException{
		FeatureStore _featureStore = this.createFeatureStore(output);
		_featureStore.addFeatures(this.selectFeatures(input));
		
		System.out.println("output to " + output.getAbsolutePath());
	}
	
	protected FeatureCollection selectFeatures(File input) throws IOException {
		FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
		FeatureSource _featureSource = this.loadFeatureSource();
		
		int _count = 0;
		for(String _line: (List<String>)FileUtils.readLines(input)){
			String[] _parts = _line.trim().split(",");
			if(_parts.length == 2){
				System.out.print("searching p" + _parts[0] + "r" + _parts[1]);
				
				int _path = Integer.parseInt(_parts[0]);
				int _row = Integer.parseInt(_parts[1]);
				_fs.add(this.searchFeature(_featureSource, _path, _row)); 
				
				System.out.println(" ok");
				_count++;
			}
		}
		
		System.out.println(_count + " datasets found");
		
		return _fs;
	}
	
	protected Feature searchFeature(FeatureSource fs, int path, int row) throws IOException {
		FilterFactory2 _factory = CommonFactoryFinder.getFilterFactory2(GeoTools.getDefaultHints());
		Filter _filter = _factory.and(
				_factory.equals(_factory.property("PATH"), _factory.literal(path)), 
				_factory.equals(_factory.property("ROW"), _factory.literal(row)) 
			);
		
		FeatureIterator _it = fs.getFeatures(_filter).features();
		try{
			if(_it.hasNext()){
				return _it.next();
			}
			else{
				throw new IOException("Failed to find path=" + path + " row=" + row);
			}
		}
		finally{
			_it.close();
		}
	}
	
	protected FeatureStore createFeatureStore(File output) throws IOException{
		ShapefileDataStore _dataStore = new ShapefileDataStore(output.toURL());
		_dataStore.createSchema(this.createFeatureType());
		
		return (FeatureStore) _dataStore.getFeatureSource();
	}
	
	protected FeatureType createFeatureType() throws IOException {
		return this.loadFeatureSource().getSchema();
	}
	
	protected FeatureSource loadFeatureSource() throws IOException {
		ShapefileDataStore _dataStore = new ShapefileDataStore(CreateTMdataset.class.getResource("/data/tm_path_row.shp"));
		return _dataStore.getFeatureSource();
	}
}
