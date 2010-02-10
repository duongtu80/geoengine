package cn.geodata.models.wetland.dem;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.geodata.models.csv.CSVReader;

public class ClimateModel {
	private File path;
	
	public ClimateModel(File path){
		this.path = path;
	}
	
	/**
	 * @param scenario
	 * @param year
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public List<Double> precipitationAvgYearly(String scenario, int year) throws ParseException, IOException {
		CSVReader _rd = new CSVReader(new File(this.path, scenario.toLowerCase() + ".csv"));
		List<Double> _prec = new ArrayList<Double>();
		
		SimpleDateFormat _format = new SimpleDateFormat("yyyy-MM");
		for (Map<String, String> _d : _rd.getRecords()) {
			Date _date = _format.parse(_d.get("month"));

			if (_date.getYear() + 1900 == year) {
				_prec.add(Double.parseDouble(_d.get("prec")));
			}
		}

		return _prec;
	}

	/**
	 * Total from the list
	 * 
	 * @param list
	 * @return
	 */
	public double sumList(List<Double> list){
		double _prec = 0;
		for(double _p: list){
			_prec += _p;
		}
		
		return _prec;
	}

	/**
	 * Average from the list
	 * 
	 * @param list
	 * @return
	 */
	public double avgList(List<Double> list){
		if( list.size() == 0)
			return 0;
		
		double _prec = 0;
		for(double _p: list){
			_prec += _p;
		}
		
		return _prec / list.size();
	}
}
