package cn.geodata.models.wetland.actions;

import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
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

import cn.geodata.models.csv.CSVReader;
import cn.geodata.models.ecoserv.actions.Operations;

public class OperationsTest extends TestCase {
	private String txt;
	private String[] headers = new String[]{"Water Storage", "Soil Erosion", "Water Quality", "GW Recharge", "Flor Quality", "Biomass", "CarbonSeq", "GHG", "Amphibians", "Waterfowl", "Shorebirds", "Pollinators"};
	private String[] titles = new String[]{"Wetland", "Crop", "Development"};

	public void atestLoadResource() throws Exception {
		DecimalFormat _format = new DecimalFormat("00");
		String _local = "/conf/model_output/scenario-" + _format.format(1)
				+ ".txt";

		System.out.println(IOUtils.toString(Operations.class
				.getResourceAsStream(_local)));
		CSVReader _reader = new CSVReader(Operations.class
				.getResourceAsStream(_local));
		System.out.println(_reader.getRecords().size());
		JSONArray _res = new JSONArray();
		for (Map<String, String> _map : _reader.getRecords()) {
			System.out.println(_map.get("Year"));
		}
	}

	public void atestLineChart() throws Exception {
		// DefaultCategoryDataset _dataset = new DefaultCategoryDataset();
		// _dataset.addValue(0.2, "test1", "value1");
		// _dataset.addValue(0.5, "test1", "value2");
		// _dataset.addValue(0.8, "test1", "value3");

		TimeSeries s1 = new TimeSeries("WaterTable (m)", Month.class);
		s1.add(new Month(1, 1990), 0.5);
		s1.add(new Month(2, 1990), 0.6);
		s1.add(new Month(3, 1990), 0.2);
		s1.add(new Month(4, 1990), 0.8);

		TimeSeriesCollection _dataset = new TimeSeriesCollection();
		_dataset.addSeries(s1);

		JFreeChart _plot = ChartFactory.createTimeSeriesChart("Test Title",
				null, null, _dataset, false, false, false);
		// _plot.getXYPlot().getDomainAxis().setRange(0, 1);

		ChartUtilities.saveChartAsPNG(new File("c:\\mfeng\\tmp\\eeee.png"),
				_plot, 300, 200);
	}

	public void atestSpiderChart() throws Exception {
		JFreeChart _plot = this.createChart(this.createDataset());

		ChartUtilities.saveChartAsPNG(new File("c:\\mfeng\\tmp\\eeee1.png"),
				_plot, 300, 200);
	}

    private static CategoryDataset createDataset()
    {
            String s = "First";
            String s1 = "Second";
            String s2 = "Third";
            String s3 = "Category 1";
            String s4 = "Category 2";
            String s5 = "Category 3";
            String s6 = "Category 4";
            String s7 = "Category 5";
            DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
            defaultcategorydataset.addValue(1.0D, s, s3);
            defaultcategorydataset.addValue(4D, s, s4);
            defaultcategorydataset.addValue(3D, s, s5);
            defaultcategorydataset.addValue(5D, s, s6);
            defaultcategorydataset.addValue(5D, s, s7);
            defaultcategorydataset.addValue(5D, s1, s3);
            defaultcategorydataset.addValue(7D, s1, s4);
            defaultcategorydataset.addValue(6D, s1, s5);
            defaultcategorydataset.addValue(8D, s1, s6);
            defaultcategorydataset.addValue(4D, s1, s7);
            defaultcategorydataset.addValue(4D, s2, s3);
            defaultcategorydataset.addValue(3D, s2, s4);
            defaultcategorydataset.addValue(2D, s2, s5);
            defaultcategorydataset.addValue(3D, s2, s6);
            defaultcategorydataset.addValue(6D, s2, s7);
            return defaultcategorydataset;
    }

	private static JFreeChart createChart(CategoryDataset categorydataset) {
		SpiderWebPlot spiderwebplot = new SpiderWebPlot(categorydataset);
		spiderwebplot.setStartAngle(54D);
		spiderwebplot.setInteriorGap(0.40000000000000002D);
		JFreeChart jfreechart = new JFreeChart("Spider Web Chart Demo 1",
				TextTitle.DEFAULT_FONT, spiderwebplot, false);
		LegendTitle legendtitle = new LegendTitle(spiderwebplot);
		legendtitle.setPosition(RectangleEdge.BOTTOM);
		jfreechart.addSubtitle(legendtitle);
		
		return jfreechart;
	}
	
	public void testGenerateSpider() throws Exception {
		DecimalFormat _format = new DecimalFormat("00");

		List<CSVReader> _readers = new ArrayList<CSVReader>();
		_readers.add(new CSVReader(Operations.class.getResourceAsStream("/conf/model_output/scenario-" + _format.format(1) + ".txt")));
		_readers.add(new CSVReader(Operations.class.getResourceAsStream("/conf/model_output/scenario-" + _format.format(2) + ".txt")));
		_readers.add(new CSVReader(Operations.class.getResourceAsStream("/conf/model_output/scenario-" + _format.format(3) + ".txt")));
		
		JSONObject _obj = new JSONObject();
		JSONArray _scen = new JSONArray();
		for(int j=0;j<_readers.size();j++){
			JSONObject _s = new JSONObject();
//			_s.put("name", _format.format(j));
			_s.put("name", this.titles[j]);

			JSONArray _values = new JSONArray();
			for(int i=0;i<this.headers.length;i++){
				String _h = this.headers[i];			

				JSONObject _o = new JSONObject();
				_o.put("param", _h);
				_o.put("value", Math.random());
//				_o.put("value", this.averageList(_readers.get(j).getRecords(), _h));
				
				_values.add(_o);
			}
			_s.put("values", _values);
			_scen.add(_s);
		}
		_obj.put("scenarios", _scen);
		
		generateSpiderChart(_obj);
	}
	
	private double averageList(List<Map<String, String>> records, String h) {
		double _m = 0;
		for (Map<String, String> map : records) {
			_m += Double.parseDouble(map.get(h));
		}
		
		return _m / records.size();
	}

	public String generateSpiderChart(JSONObject obj) throws Exception {
		JSONObject _obj = obj;// JSONObject.fromString(this.txt);
		JSONArray _scens = _obj.getJSONArray("scenarios");
		
        DefaultCategoryDataset _dataset = new DefaultCategoryDataset();
		for(int i=0;i<_scens.size();i++){
			JSONObject _scen = _scens.getJSONObject(i);
			String _name = _scen.getString("name");
			
			JSONArray _list = _scen.getJSONArray("values");
	        for(int j=0;j<_list.size();j++){
	        	JSONObject _item = _list.getJSONObject(j);
	        	String _param = _item.getString("param");
	        	double _val = _item.getDouble("value");

				_dataset.addValue(_val, _name, _param);
	        }
		}
        
		JFreeChart _plot = this.createSpiderChart(_dataset);
		
		ByteArrayOutputStream _s = new ByteArrayOutputStream();
		ChartUtilities.writeChartAsPNG(_s, _plot, 300, 200);
		
		ChartUtilities.saveChartAsPNG(new File("c:\\mfeng\\tmp\\test1.png"), _plot, 400, 400);
		
		return "success";
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

	public void atestGenerateLineChart() throws Exception {
		DecimalFormat _format = new DecimalFormat("00");

		List<CSVReader> _readers = new ArrayList<CSVReader>();
		_readers.add(new CSVReader(Operations.class.getResourceAsStream("/conf/model_output/scenario-" + _format.format(1) + ".txt")));
		_readers.add(new CSVReader(Operations.class.getResourceAsStream("/conf/model_output/scenario-" + _format.format(2) + ".txt")));
		_readers.add(new CSVReader(Operations.class.getResourceAsStream("/conf/model_output/scenario-" + _format.format(3) + ".txt")));
		
		for(int i=0;i<this.headers.length;i++){
			String _h = this.headers[i];			
			
			JSONObject _obj = new JSONObject();
			_obj.put("param", _h);
			
			JSONArray _scen = new JSONArray();
			for(int j=0;j<_readers.size();j++){
				CSVReader _r = _readers.get(j);
				
				JSONObject _s = new JSONObject();
				_s.put("name", _format.format(j));
				
				JSONArray _values = new JSONArray();
				for(Map<String, String> _m : _r.getRecords()){
					JSONObject _o = new JSONObject();
					_o.put("date", new Date(Integer.parseInt(_m.get("Year")) - 1900, Integer.parseInt(_m.get("Month")) - 1, 1).getTime());
					_o.put("value", _m.get(_h));
					
					_values.add(_o);
				}
				_s.put("values", _values);
				
				_scen.add(_s);
			}
			_obj.put("scenarios", _scen);
			this.generateLineChart(_obj);
		}
	}
	
	private String generateLineChart(JSONObject obj) throws Exception {
		JSONObject _obj = obj; //JSONObject.fromString(this.txt);
		
		String _param = _obj.getString("param");
		JSONArray _scens = _obj.getJSONArray("scenarios");
		
	    TimeSeriesCollection _dataset = new TimeSeriesCollection();
		for(int i=0;i<_scens.size();i++){
			JSONObject _scen = _scens.getJSONObject(i);
			String _name = _scen.getString("name");
			JSONArray _list = _scen.getJSONArray("values");

	        TimeSeries s1 = new TimeSeries(_name, Month.class);
	        for(int j=0;j<_list.size();j++){
	        	JSONObject _item = _list.getJSONObject(j);
	        	
	        	Date _date = new Date(_item.getLong("date"));
	        	Double _val = _item.getDouble("value");
	        	
	        	s1.add(new Month(_date.getMonth() + 1, _date.getYear() + 1900), _val);
	        }
	        _dataset.addSeries(s1);
		}
        
		JFreeChart _plot = ChartFactory.createTimeSeriesChart(_param, null, null, _dataset, false, false, false);
		_plot.getXYPlot().getRangeAxis().setRange(0, 1);
		_plot.getXYPlot().getRangeAxis().setVisible(false);
		_plot.getTitle().setFont(new Font("Verdana", Font.PLAIN, 11));
		
		int _pos = 0;
		for(int i=0;i<this.headers.length;i++){
			if(this.headers[i].equals(_param)){
				_pos = i;
				break;
			}
		}
		
		ChartUtilities.saveChartAsPNG(new File("c:\\mfeng\\tmp", new DecimalFormat("00").format(_pos) + ".png"), _plot, 200, 100);
//		ByteArrayOutputStream _s = new ByteArrayOutputStream();
//		ChartUtilities.writeChartAsPNG(_s, _plot, 300, 200);
//		
//		this.outputPNG(_s.toByteArray());
		return "success";
	}
}
