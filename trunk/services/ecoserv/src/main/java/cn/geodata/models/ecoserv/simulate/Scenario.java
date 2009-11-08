package cn.geodata.models.ecoserv.simulate;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleEdge;

/**
 * The output object for scenario simulation
 * 
 * @author mfeng
 *
 */
public class Scenario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6958280261765887955L;

	private String id;
	private List<String> scenarios;
	private List<Long> dates;
	private List<String> params;
	private Map<String, List<Map<String, Double>>> values;
	
	public String getId() {
		return id;
	}

	public List<String> getScenarios() {
		return scenarios;
	}

	public List<Long> getDates() {
		return dates;
	}

	public List<String> getParams() {
		return params;
	}

	public Map<String, List<Map<String, Double>>> getValues() {
		return values;
	}

//	public Scenarios() throws IOException {
//		this.dates = new ArrayList<Long>();
//		for(int _year=1990;_year<=2031;_year++){
//			dates.add(new Date(_year - 1900, 0, 1).getTime());
//		}
//		
//		this.params = Arrays.asList(new String[]{"Water Storage", "Soil Erosion", "Water Quality", "GW Recharge", "Flor Quality", "Biomass", "CarbonSeq", "GHG", "Amphibians", "Waterfowl", "Shorebirds", "Pollinators"});
//		
//		this.scenarios = new ArrayList<String>();
//		scenarios.add("Wetland");
//		scenarios.add("Crop");
//		scenarios.add("Urban");
//		
//		DecimalFormat _format = new DecimalFormat("00");
//		this.values = new TreeMap<String, List<Map<String, Double>>>();
//		for(int i=0;i<scenarios.size();i++){
//			values.put(scenarios.get(i), this.covertToDouble(new CSVReader(Operations.class.getResourceAsStream("/conf/model_output/scenario-" + _format.format(i + 1) + ".txt")).getRecords()));
//		}
//	}

//	private List<Map<String, Double>> covertToDouble(List<Map<String, String>> values) {
//		List<Map<String, Double>> _values = new ArrayList<Map<String,Double>>();
//		for(Map<String, String> _val: values){
//			Map<String, Double> _v = new HashMap<String, Double>();
//			for(String _vv: _val.keySet()){
//				_v.put(_vv, Double.parseDouble(_val.get(_vv)));
//			}
//			
//			_values.add(_v);
//		}
//		
//		return _values;
//	}
	
	public Scenario(List<String> scenarios, List<Long> dates,
			List<String> params, Map<String, List<Map<String, Double>>> values) throws IOException {
		super();
		
		this.scenarios = scenarios;
		this.dates = dates;
		this.params = params;
		this.values = values;
		
		this.save();
	}

	public JSONObject toJSON() throws IOException{
		List<Double> _values = new ArrayList<Double>();
		for(int _d=0;_d<this.dates.size();_d++){
			for(String _h: this.params){
				for(String _s: this.scenarios){
					_values.add(values.get(_s).get(_d).get(_h));
				}
			}
		}

		JSONObject _data = new JSONObject();
		
		_data.put("id", this.id);
		_data.put("dates", JSONArray.fromCollection(this.dates));
		_data.put("scenarios", JSONArray.fromCollection(this.scenarios));
		_data.put("params", JSONArray.fromCollection(this.params));
		_data.put("values", JSONArray.fromCollection(_values));
		
		return _data;
	}
	
	public void output(OutputStream stream) throws IOException {
		IOUtils.write(StringUtils.join(this.params.iterator(), ",") + "\n", stream);
		
		DecimalFormat _format = new DecimalFormat("0.##");
		for(int _d=0;_d<this.dates.size();_d++){
			List<String> _values = new ArrayList<String>();
			for(String _h: this.params){
				for(String _s: this.scenarios){
					_values.add(_format.format(values.get(_s).get(_d).get(_h)));
				}
			}
			IOUtils.write(StringUtils.join(_values.iterator(), ",") + "\n", stream);
		}
	}
	
	public void generateSpiderChart(OutputStream stream, int width, int height) throws Exception {
        DefaultCategoryDataset _dataset = new DefaultCategoryDataset();
		for(String _p: this.params){
			_dataset.addValue(0.3, "Threshold", _p);
		}

		for(String _s: this.scenarios){
			for(String _p: this.params){
				double _v = 0;
				for(int i=0;i<this.dates.size();i++){
					_v = _v + this.values.get(_s).get(i).get(_p);
				}
				
				_dataset.addValue(_v / this.dates.size(), _s, _p);
			}
		}

		JFreeChart _plot = this.createSpiderChart(_dataset);
		ChartUtilities.writeChartAsPNG(stream, _plot, width, height);
	}
	
	private JFreeChart createSpiderChart(CategoryDataset dataset) {
		SpiderWebPlot _spider = new SpiderWebPlot(dataset);
		_spider.setStartAngle(54D);
		_spider.setBackgroundAlpha(0.5f);
		_spider.setInteriorGap(0.40000000000000002D);
		_spider.setWebFilled(false);
		
		JFreeChart _plot = new JFreeChart(null,
				TextTitle.DEFAULT_FONT, _spider, false);
		
		_plot.setTitle(new TextTitle("Scenarios", new Font("Arial", Font.BOLD, 13)));
		
		LegendTitle _legend = new LegendTitle(_spider);
		_legend.setPosition(RectangleEdge.TOP);
		_plot.addSubtitle(_legend);
		
		return _plot;
	}
	
	public void generateLineChart(String param, OutputStream stream, int width, int height) throws Exception {
	    TimeSeriesCollection _dataset = new TimeSeriesCollection();
        
		for(String _s: this.scenarios){
	        TimeSeries s1 = new TimeSeries(_s, Month.class);
	        for(int j=0;j<this.dates.size();j++){
	        	Date _date = new Date(this.dates.get(j));
	        	Double _val = this.values.get(_s).get(j).get(param);
	        	
	        	s1.add(new Month(_date.getMonth() + 1, _date.getYear() + 1900), _val);
	        }
	        _dataset.addSeries(s1);
		}
        
        TimeSeries s0 = new TimeSeries("Threshold", Month.class);
        for(int j=0;j<this.dates.size();j++){
        	Date _date = new Date(this.dates.get(j));
        	s0.add(new Month(_date.getMonth() + 1, _date.getYear() + 1900), 0.3);
        }
        _dataset.addSeries(s0);
        
		JFreeChart _plot = ChartFactory.createTimeSeriesChart(param, null, null, _dataset, false, false, false);
		_plot.getXYPlot().getRangeAxis().setRange(0, 1);
		_plot.getXYPlot().getRangeAxis().setVisible(false);
		_plot.getTitle().setFont(new Font("Verdana", Font.PLAIN, 11));
		
		ChartUtilities.writeChartAsPNG(stream, _plot, width, height);
	}
	
	/**
	 * Save the scenarios to file
	 * 
	 * @return id
	 * @throws IOException
	 */
	public void save() throws IOException{
		File _file = File.createTempFile("mod", "");
		this.id = _file.getName();
		
		ObjectOutputStream _stream = new ObjectOutputStream(new FileOutputStream(_file));
		_stream.writeObject(this);
		
		_stream.close();
	}
	
	/**
	 * Load the scenarios from file
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Scenario load(String id) throws IOException, ClassNotFoundException{
		File _file = new File(System.getProperty("java.io.tmpdir"), id);
		
		ObjectInputStream _stream = new ObjectInputStream(new FileInputStream(_file));
		Scenario _s = (Scenario) _stream.readObject();
		
		_stream.close();
		return _s;
	}
}
