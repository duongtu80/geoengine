package cn.geodata.models.ecoserv.simulate;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import cn.geodata.models.ecoserv.landcover.LandCover;
import cn.geodata.models.ecoserv.utils.DayMet;
import cn.geodata.models.ecoserv.utils.DayMetReader;

public class CarbonModel {
	private Logger log = Logger.getAnonymousLogger();
	private Map<Integer, Double> fluxs; 
	private Map<Integer, Long> counts;
	private List<DayMet> climate;
	private double max = 8;
	private double min = 0;
		
	public CarbonModel(){
		fluxs = new HashMap<Integer, Double>();
		fluxs.put(new Integer(1), new Double(2));
		fluxs.put(new Integer(2), new Double(0));
		fluxs.put(new Integer(3), new Double(3));
		fluxs.put(new Integer(4), new Double(4));
		fluxs.put(new Integer(5), new Double(5));
		fluxs.put(new Integer(6), new Double(2));
	}
	
	public void initLandCover(LandCover landcover, List<DayMet> climate) throws IOException, ParseException {
		this.climate = climate;
		this.counts = new HashMap<Integer, Long>();

		for(int _row=0;_row< landcover.getRowCount();_row++){
			for(int _col=0;_col<landcover.getColCount();_col++){
				int _pos = _row * landcover.getColCount() + _col;
				Integer _type = landcover.getData()[_pos];
				
				if(_type == null || _type.equals(0)){
					continue;
				}
				
				if(counts.containsKey(_type)){
					counts.put(_type, counts.get(_type) + 1);
				}
				else{
					counts.put(_type, new Long(1));
				}
			}
		}
	}
	
	public double calculate(Date date) throws ParseException {
		int _dateIndex = (int)(date.getTime() - this.climate.get(0).getDate().getTime()) / (1000 * 60 * 60 * 24);
		if(_dateIndex < 0)
			_dateIndex = 0;
		
		if(_dateIndex > this.climate.size()){
			_dateIndex = this.climate.size() - 1;
		}
		
		double _dry = calculatePrecIndex(1, _dateIndex);
		double _co2 = 0;
		
		for(Integer _type : counts.keySet()){
			if(fluxs.get(_type) != null){
				double _co2_t = counts.get(_type) * _dry * fluxs.get(_type) * Math.sin(date.getDay() / 360.0);
				_co2 += _co2_t;
			}
		}
		
		if(_co2 < min)
			_co2 = 0;
		else if(_co2 > max)
			_co2 = 1;
		else{
			_co2 = (_co2 - min) / (max - min); 
		}
		
		return _co2;
	}
	
	private double averagePrec(int index){
		int _startDate = index - 10;
		if(_startDate < 0)
			_startDate = 0;
		
		double _prec = 0;
		int _count = 0;
		for(;_startDate < index;_startDate ++){
			_prec += this.climate.get(_startDate).getPrcp();
			_count ++;
		}
		
		if(_count <= 0)
			return 0;
		
		return _prec / _count;
	}
	
	private double calculatePrecIndex(double a, int index){
		double _prec = this.averagePrec(index);
		return 1 - Math.pow(Math.E, (-1) * a * _prec);
	}
}
