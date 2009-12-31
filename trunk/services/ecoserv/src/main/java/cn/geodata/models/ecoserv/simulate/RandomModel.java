package cn.geodata.models.ecoserv.simulate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import cn.geodata.models.csv.CSVReader;
import cn.geodata.models.ecoserv.landcover.LandCover;
import cn.geodata.models.ecoserv.landcover.LandCoverMgr;
import cn.geodata.models.ecoserv.utils.DayMet;
import cn.geodata.models.ecoserv.utils.DayMetReader;
import cn.geodata.models.raster.GeoRaster;

public class RandomModel {
	private Logger log = Logger.getAnonymousLogger();
	
	private List<Long> dates;
	private List<String> params;
	private GeoRaster dem;
	
	public RandomModel(GeoRaster dem) throws IOException {
		this.dem = dem;
		
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
		List<DateObject<Map<String,Double>>> _waters = null;
		
		for(String _s: scenarios){
			log.info("Start scenario " + _s);
			
			LandCover _landcover = new LandCoverMgr().getLandCover(_s);
			ArrayList<DayMet> _climate = new DayMetReader().read(null, null, "p4", _landcover.getExtent().getCenterX(), _landcover.getExtent().getCenterY());
			
			log.info("Start water surface model calculation");
			if(_waters == null)
				_waters = new MultipleWaterSurfaceModel(dem).calculateWaterTable(new Date(startDate.getYear(), 0, 1), new Date(endDate.getYear(), 11, 31), _climate);
			
			log.info("Start rest model calculations");
			CarbonModel _carbon = new CarbonModel();
			_carbon.initLandCover(_landcover, _climate);
			
			
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
					else if(_h.equals("Soil Erosion")){
						//Still use the random model before we come up with the new model
						double _vv = Double.parseDouble(_modelParams.get(0).get(_h)) * _dd + Double.parseDouble(_modelParams.get(1).get(_h)) + Math.random() * Double.parseDouble(_modelParams.get(2).get(_h));
						_vv = (_vv - Double.parseDouble(_modelParams.get(3).get(_h))) / (Double.parseDouble(_modelParams.get(4).get(_h)) - Double.parseDouble(_modelParams.get(3).get(_h)));
						
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
			
			log.info("End of scenario " + _s);
		}
		
		return new Scenario(scenarios, dates, params, values, _waters);
	}
}
