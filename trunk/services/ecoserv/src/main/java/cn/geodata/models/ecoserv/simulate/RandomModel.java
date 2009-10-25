package cn.geodata.models.ecoserv.simulate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.geodata.models.csv.CSVReader;

public class RandomModel {
	
	private List<Long> dates;
	private List<String> params;
	
	public RandomModel() throws IOException {
		this.dates = new ArrayList<Long>();
		for(int _year=1990;_year<2000;_year++){
			for(int _month=0;_month<12;_month+=3){
				dates.add(new Date(_year - 1900, _month, 1).getTime());
			}
		}
		
		this.params = Arrays.asList(new String[]{"Water Storage", "Soil Erosion", "Water Quality", "GW Recharge", "Flor Quality", "Biomass", "CarbonSeq", "GHG", "Amphibians", "Waterfowl", "Shorebirds", "Pollinators"});
	}

	public Scenarios calculate(List<String> scenarios) throws IOException {
		CSVReader _modelData = new CSVReader(RandomModel.class.getResourceAsStream("/conf/simulation-params.txt"));
		List<Map<String, String>> _modelParams = _modelData.getRecords();

		Map<String, List<Map<String, Double>>> values = new HashMap<String, List<Map<String, Double>>>();
		for(String _s: scenarios){
			List<Map<String, Double>> _vals = new ArrayList<Map<String, Double>>();
			for(Long _d: dates){
				Date _date = new Date(_d);
				double _dd = (_date.getMonth() + 1) / 12.0;
//				System.out.println(_dd);
//				double _dd = 1.0;
				
				Map<String, Double> _val = new HashMap<String, Double>();
				for(String _h: this.params){
					double _vv = Double.parseDouble(_modelParams.get(0).get(_h)) * _dd + Double.parseDouble(_modelParams.get(1).get(_h)) + Math.random() * Double.parseDouble(_modelParams.get(2).get(_h));
					_vv = (_vv - Double.parseDouble(_modelParams.get(3).get(_h))) / (Double.parseDouble(_modelParams.get(4).get(_h)) - Double.parseDouble(_modelParams.get(3).get(_h)));
					
					_val.put(_h, _vv);
				}
				
				_vals.add(_val);
			}
			values.put(_s, _vals);
		}
		
		return new Scenarios(scenarios, dates, params, values);
	}
}
