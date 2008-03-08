package cn.geodata.models.wetland;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

public class DayMetReader {
	private static Logger log = Logger.getAnonymousLogger();
	
	public DayMetReader(){
		
	}
	
	public ArrayList<DayMet> read(Date startDate, Date endDate, double x, double y) throws IOException, ParseException{
		URL _url = new URL("http://www.daymet.org/getRawData.do?lat=" + y + "&lon=" + x);
		
		boolean _inside = false;
		if(startDate == null){
			_inside = true;
		}
		
		ArrayList<DayMet> _list = new ArrayList<DayMet>();
		List<String> _lines = (List<String>)IOUtils.readLines(_url.openStream());
		for(int i=4;i<_lines.size();i++){
			String[] _parts = _lines.get(i).trim().split("\\s+");
			if(_parts.length == 9){
				DayMet _met = new DayMet();
				_met.setYear(Integer.parseInt(_parts[0]));
				_met.setDay(Integer.parseInt(_parts[1]));
				_met.setTmax(Double.parseDouble(_parts[2]));
				_met.setTmin(Double.parseDouble(_parts[3]));
				_met.setTday(Double.parseDouble(_parts[4]));
				_met.setPrcp(Double.parseDouble(_parts[5]));
				_met.setVpd(Double.parseDouble(_parts[6]));
				_met.setSrad(Double.parseDouble(_parts[7]));
				_met.setDaylen(Double.parseDouble(_parts[8]));
				
				_met.setSrad(_met.getSrad() * _met.getDaylen() * (1e-6));
				_met.setX(x);
				_met.setY(y);
				
				if(_inside == false && startDate != null && _met.getDate().before(startDate) == false){
					_inside = true;
				}
				if(_inside == true && endDate != null && _met.getDate().after(endDate)){
					_inside = false;
					break;
				}
				
				if(_inside)
					_list.add(_met);
			}
			else{
				log.warning("skip " + _lines.get(i));
			}
		}
		
		return _list;
	}
}
