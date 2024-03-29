package cn.geodata.models.ecoserv.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

public class DayMetReader {
	private static Logger log = Logger.getAnonymousLogger();
	
	private String url;
	private String cache;
	
	public void setCache(String cache) {
		this.cache = cache;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public DayMetReader(){
		this.cache = System.getProperty("java.io.tmpdir");
		this.url = "http://www.daymet.org/getRawData.do?lon=%f&lat=%f";
	}
	
	public DayMetReader(String cache) {
		this.cache = cache;
	}

	public ArrayList<DayMet> read(Date startDate, Date endDate, String tag, double x, double y) throws IOException, ParseException{
		File _f = new File(new File(this.cache), tag.toLowerCase());
		
		if(_f.exists() == false){
			//Cache the daymet stream
			URL _url = new URL(String.format(this.url, x, y));
			log.info("URL:" + this.url);
			IOUtils.copy(_url.openStream(), new FileOutputStream(_f));
		}
		
		InputStream _stream = new FileInputStream(_f);
		
		boolean _inside = false;
		if(startDate == null){
			_inside = true;
		}
		
		ArrayList<DayMet> _list = new ArrayList<DayMet>();
		List<String> _lines = (List<String>)IOUtils.readLines(_stream);
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
