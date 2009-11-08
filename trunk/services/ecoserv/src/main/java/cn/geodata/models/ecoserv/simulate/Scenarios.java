package cn.geodata.models.ecoserv.simulate;

import java.awt.Font;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

public class Scenarios {
	private List<String> params;

	public Scenarios() {
		this.params = Arrays.asList(new String[]{"Water Storage", "Soil Erosion", "Water Quality", "GW Recharge", "Flor Quality", "Biomass", "CarbonSeq", "GHG", "Amphibians", "Waterfowl", "Shorebirds", "Pollinators"});
	}
	
	public void generateSpiderChart(List<Scenario> scenarios, OutputStream stream, int width, int height) throws Exception {
        DefaultCategoryDataset _dataset = new DefaultCategoryDataset();
		for(String _p: this.params){
			_dataset.addValue(0.3, "Threshold", _p);
		}

		for(Scenario _scenario: scenarios){
			for(String _s: _scenario.getScenarios()){
				for(String _p: this.params){
					double _v = 0;
					for(int i=0;i<_scenario.getDates().size();i++){
						_v = _v + _scenario.getValues().get(_s).get(i).get(_p);
					}
					
					_dataset.addValue(_v / _scenario.getDates().size(), _s, _p);
				}
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
	
	public void generateLineChart(List<Scenario> scenarios, String param, OutputStream stream, int width, int height) throws Exception {
	    TimeSeriesCollection _dataset = new TimeSeriesCollection();
        
	    List<Date> _dates = new ArrayList<Date>();
		for(Scenario _scenario: scenarios){
			for(String _s: _scenario.getScenarios()){
		        TimeSeries s1 = new TimeSeries(_s, Month.class);
		        for(int j=_scenario.getDates().size() - 1;j >= 0;j--){
		        	Date _date = new Date(_scenario.getDates().get(j));
		        	Double _val = _scenario.getValues().get(_s).get(j).get(param);
		        	
		        	s1.add(new Month(_date.getMonth() + 1, _date.getYear() + 1900), _val);
		        	
		        	if(_dates.contains(_date) == false){
		        		_dates.add(_date);
		        	}
		        }
		        _dataset.addSeries(s1);
			}
		}
		
        TimeSeries s0 = new TimeSeries("Threshold", Month.class);
        for(int j=0;j<_dates.size();j++){
        	Date _date = _dates.get(j);
        	s0.add(new Month(_date.getMonth() + 1, _date.getYear() + 1900), 0.3);
        }
        _dataset.addSeries(s0);
        
		JFreeChart _plot = ChartFactory.createTimeSeriesChart(param, null, null, _dataset, false, false, false);
		_plot.getXYPlot().getRangeAxis().setRange(0, 1);
		_plot.getXYPlot().getRangeAxis().setVisible(false);
		_plot.getTitle().setFont(new Font("Verdana", Font.PLAIN, 11));
		
		ChartUtilities.writeChartAsPNG(stream, _plot, width, height);
	}
}
