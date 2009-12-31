package cn.geodata.models.ecoserv.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.geotools.feature.FeatureCollection;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.geodata.models.data.DataParser;
import cn.geodata.models.data.parsers.GeoJsonComplexParser;
import cn.geodata.models.ecoserv.simulate.DateObject;
import cn.geodata.models.ecoserv.simulate.MultipleWaterSurfaceModel;
import cn.geodata.models.ecoserv.simulate.RandomModel;
import cn.geodata.models.ecoserv.simulate.Scenario;
import cn.geodata.models.ecoserv.simulate.Scenarios;
import cn.geodata.models.geojson.GeoJSON;
import cn.geodata.models.geojson.GeoJSONUtil;
import cn.geodata.models.geojson.UnsupportedGeoJSONType;
import cn.geodata.models.raster.GeoRaster;
import cn.geodata.models.wetland.multiple.WetlandWater;

public class Operations {
	private Logger log = Logger.getAnonymousLogger();
	
	protected InputStream stream;
	protected String contentType;
	protected String contentDisposition;
	
	private int id;
	private String param;
	private String txt;
	
	private MultipleWaterSurfaceModel waterSurfaceModel;
	private RandomModel ecoservModel;
	
	public Operations(RandomModel ecoservModel, MultipleWaterSurfaceModel multipleWaterSurfaceModel){
		this.ecoservModel = ecoservModel;
		this.waterSurfaceModel = multipleWaterSurfaceModel;
		
		this.contentType = "text/xml";
		this.contentDisposition = "inline;filename=output.xml";
	}
	
	public String loadScenario() throws Exception{
		log.info(this.param);
		
		JSONObject _param = JSONObject.fromObject(this.param);

		Date _startDate = new Date(_param.getLong("startDate"));
		Date _endDate = new Date(_param.getLong("endDate"));
		String _landcover = _param.getString("landCover");
		
		Scenario _output = this.ecoservModel.calculate(_startDate, _endDate, Arrays.asList(new String[] {_landcover}));
		
		this.outputJSON(_output.toJSON());
		
		return "success";
	}
	
	public String loadParam() throws Exception {
		Scenario _output = Scenario.load(this.txt);
		
		ByteArrayOutputStream _s = new ByteArrayOutputStream();
		_output.generateLineChart(this.param, _s, 195, 99);
		
		this.outputPNG(_s.toByteArray());
		return "success";
	}

	public String loadParams() throws Exception {
		List<Scenario> _outputs = new ArrayList<Scenario>();
		for(String _t : this.txt.split("\\s*,\\s*")){
			_outputs.add(Scenario.load(_t));
		}
		
		ByteArrayOutputStream _s = new ByteArrayOutputStream();
		new Scenarios().generateLineChart(_outputs, this.param, _s, 195, 99);

		this.outputPNG(_s.toByteArray());
		return "success";
	}

	public String loadSpider() throws Exception {
		Scenario _output = Scenario.load(this.txt);
		
		ByteArrayOutputStream _s = new ByteArrayOutputStream();
		_output.generateSpiderChart(_s, 398, 400);
		
		this.outputPNG(_s.toByteArray());
		return "success";
	}
	
	public String download() throws Exception {
		Scenario _output = Scenario.load(this.txt);
		
		ByteArrayOutputStream _s = new ByteArrayOutputStream();
		_output.output(_s);
		
		this.stream = new ByteArrayInputStream(_s.toByteArray());
		this.contentType = "application/vnd.ms-excel";
		this.contentDisposition = "attachment;filename=" + this.txt.replaceAll("\\s+", "_") + ".csv";
		
		return "success";
	}

	public String loadSpiders() throws Exception {
		List<Scenario> _outputs = new ArrayList<Scenario>();
		for(String _t : this.txt.split("\\s*,\\s*")){
			_outputs.add(Scenario.load(_t));
		}
		
		ByteArrayOutputStream _s = new ByteArrayOutputStream();
		new Scenarios().generateSpiderChart(_outputs, _s, 398, 400);
		
		this.outputPNG(_s.toByteArray());
		return "success";
	}
	
	public String loadParamData() throws Exception {
		List<Long> _dates = new ArrayList<Long>();
		List<String> _columns = new ArrayList<String>();
		List<Integer> _colors = new ArrayList<Integer>();
		
		List<Scenario> _outputs = new ArrayList<Scenario>();
		for(String _t : this.txt.split("\\s*,\\s*")){
			Scenario _s = Scenario.load(_t);
			for(Long _d : _s.getDates()){
				if(_dates.contains(_d) == false)
					_dates.add(_d);
			}
			
			_columns.add(_s.getScenarios().get(0));
			_colors.add(0xFF0000);
			
			_outputs.add(_s);
		}
		Collections.sort(_dates);
		
		JSONArray _data = new JSONArray();
		for(int i=0;i<_dates.size();i++){
			JSONArray _items = new JSONArray();
			
			_items.add(_dates.get(i));
			for(int j=0;j<_outputs.size();j++){
				if(_outputs.get(j).getDates().contains(_dates.get(i))){
					_items.add(_outputs.get(j).getValues().get(_outputs.get(j).getScenarios().get(0)).get(_outputs.get(j).getDates().indexOf(_dates.get(i))).get(this.param));
				}
				else{
					_items.add(-9999);
				}
			}
			
			_data.add(_items);
		}
		
		JSONObject _root = new JSONObject();
		_root.put("columns", JSONArray.fromObject(_columns.toArray()));
		_root.put("colors", _colors);
		_root.put("data", _data);
		
		this.outputJSON(_root);
		return "success";
	}
	
	private DateObject<Map<String, Double>> locateWetlandbyDate(Scenario scenario, Date date) throws Exception{
//		for(DateObject<Map<String, Double>> _wet: scenario.getWaters()){
//			if(_wet.getDate().equals(date)){
//				return _wet;
//			}
//		}

		//Using the saved data for test
		ObjectInputStream _stream = new ObjectInputStream(new FileInputStream(new File("/tmp/watertable_7119788779025450908.dat")));
		
		List<DateObject<Map<String, Double>>> _data = (List<DateObject<Map<String, Double>>>) _stream.readObject();
		for(DateObject<Map<String, Double>> _wet: _data){
			if(_wet.getDate().equals(date)){
				return _wet;
			}
		}
		
		throw new Exception("Failed to locate water table simulation result on date:" + date);
	}

	/**
	 * Load water table simulation for each catchment on given date from the scenario simulation result
	 * 
	 * @return
	 * @throws Exception
	 */
	public String loadWaterTable() throws Exception {
		log.info(this.param);
		JSONObject _param = JSONObject.fromObject(this.param);
		
		Scenario _s = Scenario.load(_param.getString("scenario"));
		Date _date = new Date(_param.getLong("date"));
		
		this.outputJSON(JSONObject.fromObject(this.locateWetlandbyDate(_s, _date)));
		
		return "success";
	}
	
	/**
	 * Calculate water surface based on the water tables simulated for the scenario on given date
	 * 
	 * @return
	 * @throws Exception
	 */
	public String calWaterSurface() throws Exception {
		log.info(this.param);
		JSONObject _param = JSONObject.fromObject(this.param);
		
		Scenario _s = Scenario.load(_param.getString("scenario"));
		Date _date = new Date(_param.getLong("date"));
		
		DateObject<Map<String, Double>> _wet = this.locateWetlandbyDate(_s, _date);

		this.outputFeatureColJSON(this.waterSurfaceModel.calculate(_wet.getValue()));
		
		return "success";
	}
	
	private void outputFeatureColJSON(FeatureCollection<SimpleFeatureType, SimpleFeature> featureCol) throws UnsupportedEncodingException, UnsupportedGeoJSONType{
		this.outputJSON(new GeoJSON().encode(featureCol));
	}

	private void outputJSON(JSONObject json) throws UnsupportedEncodingException{
		log.info("JSON output " + json.toString());
		
		this.stream = new ByteArrayInputStream(json.toString().getBytes("utf-8"));
		this.contentType = "text";
		this.contentDisposition = "inline;filename=\"output.txt\"";
	}

	private void outputPNG(byte[] bytes) throws UnsupportedEncodingException{
		this.stream = new ByteArrayInputStream(bytes);
		this.contentType = "image/png";
		this.contentDisposition = "inline;filename=\"image1.png\"";
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public InputStream getStream() {
		return stream;
	}

	public String getContentType() {
		return contentType;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public String loadOutput() throws Exception {
		
		
		return "success";
	}
}
