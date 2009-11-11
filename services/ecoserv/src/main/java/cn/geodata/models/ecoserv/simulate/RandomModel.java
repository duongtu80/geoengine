package cn.geodata.models.ecoserv.simulate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.geodata.models.csv.CSVReader;
import cn.geodata.models.ecoserv.landcover.LandCoverMgr;

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

	public Scenario calculate(Date startDate, Date endDate, List<String> scenarios) throws Exception {
		this.dates = new ArrayList<Long>();
		for(int _year=startDate.getYear() + 1900;_year<endDate.getYear() + 1900;_year++){
			for(int _month=0;_month<12;_month+=3){
				dates.add(new Date(_year - 1900, _month, 1).getTime());
			}
		}
		
		CSVReader _modelData = new CSVReader(RandomModel.class.getResourceAsStream("/conf/simulation-params.txt"));
		List<Map<String, String>> _modelParams = _modelData.getRecords();

		Map<String, List<Map<String, Double>>> values = new HashMap<String, List<Map<String, Double>>>();
		for(String _s: scenarios){
			CarbonModel _carbon = new CarbonModel();
			_carbon.initLandCover(new LandCoverMgr().getLandCover(_s));
			
			List<Map<String, Double>> _vals = new ArrayList<Map<String, Double>>();
			for(Long _d: dates){
				Date _date = new Date(_d);
				double _dd = (_date.getMonth() + 1) / 12.0;
				
				Map<String, Double> _val = new HashMap<String, Double>();
				for(String _h: this.params){
					if(_h.equals("GHG")){
						Calendar _calender = Calendar.getInstance();
						_calender.clear();
						_calender.set(_date.getYear() + 1900, _date.getMonth(), 1);
						
						double _vv = 0;
//						int _count = 0;
						
						while(_calender.get(Calendar.YEAR) == _date.getYear() + 1900 && _calender.get(Calendar.MONTH) == _date.getMonth()){
							_vv = Math.max(_vv, _carbon.calculate(_calender.getTime()));
//							_vv += _carbon.calculate(_calender.getTime());
//							_count ++;
							
							_calender.add(Calendar.DATE, 1);
						}
//						_val.put(_h, _vv / _count);
						_val.put(_h, _vv);
					}
					else{
						double _vv = Double.parseDouble(_modelParams.get(0).get(_h)) * _dd + Double.parseDouble(_modelParams.get(1).get(_h)) + Math.random() * Double.parseDouble(_modelParams.get(2).get(_h));
						_vv = (_vv - Double.parseDouble(_modelParams.get(3).get(_h))) / (Double.parseDouble(_modelParams.get(4).get(_h)) - Double.parseDouble(_modelParams.get(3).get(_h)));
						
						_val.put(_h, _vv);
					}
				}
				
				_vals.add(_val);
			}
			values.put(_s, _vals);
		}
		
		return new Scenario(scenarios, dates, params, values);
	}
}
