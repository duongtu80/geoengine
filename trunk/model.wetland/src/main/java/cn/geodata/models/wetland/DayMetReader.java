package cn.geodata.models.wetland;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class DayMetReader {
	public DayMetReader(){
		
	}
	
	public ArrayList<DayMet> read() throws IOException{
		ArrayList<DayMet> _list = new ArrayList<DayMet>();
		for(String _line : (List<String>)IOUtils.readLines(DayMetReader.class.getResourceAsStream("/data/daymet.txt"))){
			String[] _parts = _line.trim().split("\\s+");
			if(_parts.length == 8){
				DayMet _met = new DayMet();
				_met.setYear(Integer.parseInt(_parts[0]));
				_met.setDay(Integer.parseInt(_parts[1]));
				_met.setTmax(Double.parseDouble(_parts[1]));
				_met.setTmin(Double.parseDouble(_parts[1]));
				_met.setTday(Double.parseDouble(_parts[1]));
				_met.setPrcp(Double.parseDouble(_parts[1]));
				_met.setVpd(Double.parseDouble(_parts[1]));
				_met.setSrad(Double.parseDouble(_parts[1]));
				_met.setDaylen(Double.parseDouble(_parts[1]));
				
				_list.add(_met);
			}
		}
		
		return _list;
	}
}
