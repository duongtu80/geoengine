package cn.geodata.models.ecoserv.models;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.geodata.models.ecoserv.landcover.LandCover;
import cn.geodata.models.ecoserv.utils.DayMet;
import cn.geodata.models.ecoserv.utils.DayMetReader;

public class LandCoverChange {
	private Logger log = Logger.getAnonymousLogger();
	private Map<Integer, Double> fluxs; 
		
	public LandCoverChange(){
		fluxs = new HashMap<Integer, Double>();
		fluxs.put(new Integer(1), new Double(0));
		fluxs.put(new Integer(2), new Double(0));
		fluxs.put(new Integer(3), new Double(3));
		fluxs.put(new Integer(4), new Double(4));
		fluxs.put(new Integer(5), new Double(5));
		fluxs.put(new Integer(6), new Double(2));
	}
	
	public JSONArray calculation(LandCover landcover, Date start, Date end) throws IOException, ParseException{
		DayMetReader _reader = new DayMetReader("c:\\mfeng\\tmp");
		ArrayList<DayMet> _data = _reader.read(start, end, "p4", -110, 45);
		
		Map<Integer, Long> counts = new HashMap<Integer, Long>();
		for(int _row=0;_row< landcover.getRowCount();_row++){
			for(int _col=0;_col<landcover.getColCount();_col++){
				int _pos = _row * landcover.getColCount() + _col;
				Integer _type = landcover.getData()[_pos];
				
				if(counts.containsKey(_type)){
					counts.put(_type, counts.get(_type) + 1);
				}
				else{
					counts.put(_type, new Long(1));
				}
			}
		}

		JSONArray _list = new JSONArray();
		for(int i=0;i<_data.size();i++){
			log.info(_data.get(i).getY() + " " + _data.get(i).getDay());
			double _dry = calculatePrecIndex(1, _data, i);
			double _co2 = 0;
			
			JSONObject _date = new JSONObject(); 
			_date.put("date", _data.get(i).getDate().getTime());
			
			for(Integer _type : counts.keySet()){
				double _co2_t = counts.get(_type) * _dry * fluxs.get(_type) * Math.sin(_data.get(i).getDay() / 360.0);
//				_date.put(_type, _co2_t);
				
				_co2 += _co2_t;
			}
			_date.put("CO2", _co2);
			
			_list.put(_date);
		}
		
		return _list;
	}
	
	private double averagePrec(ArrayList<DayMet> data, int index){
		int _startDate = index - 10;
		if(_startDate < 0)
			_startDate = 0;
		
		double _prec = 0;
		int _count = 0;
		for(;_startDate < index;_startDate ++){
			_prec += data.get(_startDate).getPrcp();
			_count ++;
		}
		
		if(_count <= 0)
			return 0;
		
		return _prec / _count;
	}
	
	private double calculatePrecIndex(double a, ArrayList<DayMet> data, int index){
		double _prec = this.averagePrec(data, index);
		return 1 - Math.pow(Math.E, (-1) * a * _prec);
	}
}
