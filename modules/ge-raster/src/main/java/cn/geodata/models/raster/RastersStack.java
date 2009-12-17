package cn.geodata.models.raster;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.Envelope2D;

import cn.geodata.models.csv.CSVReader;
import cn.geodata.models.csv.CSVWriter;

import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;


/**
 * Manage rasters for a category
 * 
 * @author mfeng
 *
 */
public class RastersStack {
	private static Logger log = Logger.getAnonymousLogger();

	private List<GeoRaster> rasters;
	private GeoRaster lastKey;
	
	public static Map<String, RastersStack> initStack(File stackFile) throws IOException {
		CSVReader _reader = new CSVReader(stackFile);
		
//		List<String> _headers = _reader.getHeader();
		List<Map<String, String>> _records = _reader.getRecords();
		
		Map<String, List<GeoRaster>> _stack = new HashMap<String, List<GeoRaster>>();
		for(int i =0 ;i<_records.size();i++){
			Map<String, String> _r = _records.get(i);
			
			File _file = new File(_r.get("file"));
			
			double _minx = Double.parseDouble(_r.get("minx"));
			double _miny = Double.parseDouble(_r.get("miny"));
			double _width = Double.parseDouble(_r.get("width"));
			double _height = Double.parseDouble(_r.get("height"));
			
			Envelope2D _envelope = new Envelope2D(null, _minx, _miny, _width, _height);
			
			int _bandNum = Integer.parseInt(_r.get("bandNum"));
			int _band = Integer.parseInt(_r.get("band"));
			int _type = Integer.parseInt(_r.get("type"));
			int _colNum = Integer.parseInt(_r.get("colNum"));
			int _rowNum = Integer.parseInt(_r.get("rowNum"));
			int _tileWidth = Integer.parseInt(_r.get("tileWidth"));
			int _tileHeight = Integer.parseInt(_r.get("tileHeight"));
			
			String _nodata = _r.get("nodata");
			String _category = _r.get("category");
			
			GeoRaster _raster = new GeoRaster(
						_file,
						_envelope,
						_colNum,
						_rowNum,
						_tileWidth,
						_tileHeight,
						_type,
						_bandNum,
						_band,
						_nodata
					);
			
			List<GeoRaster> _rasters = _stack.containsKey(_category) ? _stack.get(_category) : new ArrayList<GeoRaster>();
			_rasters.add(_raster);
			
			_stack.put(_category, _rasters);
		}
		
		Map<String, RastersStack> _rs = new HashMap<String, RastersStack>();
		for(String _k : _stack.keySet()){
			_rs.put(_k, new RastersStack(_stack.get(_k)));
		}
		
		return _rs;
	}
	
	public static void initFolder(File folder, File output) throws IOException{
		String[] _columns = new String[] {
				"file",
				"minx",
				"miny",
				"width",
				"height",
				"bandNum",
				"band",
				"type",
				"colNum",
				"rowNum",
				"tileWidth",
				"tileHeight",
				"nodata",
				"category"};

		CSVWriter _writer = new CSVWriter(output, _columns);
		Collection<File> _files =  FileUtils.listFiles(folder, new String[] {"tif", "TIF"}, true);
		
		for(File _f : _files){
			System.out.println("+add file " + _f.getAbsolutePath());
			
			GeoRaster _r = new GeoRaster(_f, 0);
			Envelope2D _env = _r.getEnvelope();
			
			for(int i=0;i<_r.getBandNum();i++){
				List<Object> _vals = new ArrayList<Object>();
				
				_vals.add(_f.getAbsoluteFile());
				_vals.add(_env.getMinX());
				_vals.add(_env.getMinY());
				_vals.add(_env.getWidth());
				_vals.add(_env.getHeight());
				_vals.add(_r.getBandNum());
				_vals.add(i);
				_vals.add(_r.getType());
				_vals.add(_r.getColNum());
				_vals.add(_r.getRowNum());
				_vals.add(_r.getTileWidth());
				_vals.add(_r.getTileHeight());
				_vals.add(_r.getNodata());
				
				String _cat = _f.getName().split("\\.")[0] + (_r.getBandNum() > 1? "_" + i : "");
				_vals.add(_cat);
				
				_writer.addLine(_vals);
			}
		}
		
		_writer.write();
	}


	public RastersStack(List<GeoRaster> rasters) throws IOException{
		this.rasters = rasters;
	}
	
	public List<GeoRaster> getRasters() {
		return this.rasters;
	}
	
	public List<GeoRaster> findDatasets(Polygon poly) {
		List<GeoRaster> _list = new ArrayList<GeoRaster>();
		
		Envelope2D _ext = Utilities.getEnvelope(poly);
		for(GeoRaster _raster : this.rasters){
			if(_raster.getEnvelope().intersects(_ext)){
				_list.add(_raster);
			}
		}
		
		return _list;
	}
	
	public Number getLocationValue(List<GeoRaster> keys, DirectPosition2D pt) throws IOException{
		return this.getLocationValue(keys, pt.getX(), pt.getY());
	}

	public Number getLocationValue(List<GeoRaster> keys, double x, double y) throws IOException{
//		return new Integer(10);
		if(this.lastKey != null){
			Number _val = this.lastKey.getLocationValue(x, y);
			if(_val != null){
				return _val;
			}
		}
		
		List<GeoRaster> _keys = keys;
		if(_keys == null)
			_keys = this.getRasters();
		
		for(GeoRaster _key : _keys){
			if(_key.equals(this.lastKey) == false){
				Number _val = _key.getLocationValue(x, y);
				if(_val != null){
					this.lastKey = _key;
					return _val;
				}
			}
		}
		
		return null;
	}

	public Number getLocationValue(double x, double y) throws IOException{
		return this.getLocationValue(null, x, y);
	}
	
	public Number getLocationValue(Point pt) throws IOException {
		return this.getLocationValue(pt.getX(), pt.getY());
	}
}
