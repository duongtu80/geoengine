package cn.geodata.models.wetland.actions.map;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

public class ChartData2 {
	private Map<String, ArrayList<Double>> data;
	private String[] xlabels;
	private String[] ylabels;
	
	public ChartData2(InputStream stream) throws IOException{
		data = new HashMap<String, ArrayList<Double>>();
		
		ArrayList<String> _lables = null;
		for(String _line : IOUtils.toString(stream).split("\r\n")){
			if(_line.length() > 0){
				String[] _parts = _line.replace("\t", "\t ").split("\t");
				ArrayList<Double> _data = new ArrayList<Double>();
				for(int i=1;i<_parts.length;i++){
					if(_parts[i].length() <= 1){
//						_data.add(Double.NaN);
						_data.add(Double.NaN);
					}
					else{
						Double _v = Double.parseDouble(_parts[i]);
						if(_v.doubleValue() <= 0)
							_data.add(Double.NaN);
						else
							_data.add(_v);
					}
				}
				
				if(_lables == null){
					_lables = new ArrayList<String>();
					for(int i=0;i<_data.size() / 12;i++){
						_lables.add("" + (1988 + i));
					}
				}
				
				data.put(_parts[0], _data);
			}
		}
		this.ylabels = _lables.toArray(new String[0]);
		this.xlabels = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	}

	public Map<String, ArrayList<Double>> getData() {
		return data;
	}

	public void setData(Map<String, ArrayList<Double>> data) {
		this.data = data;
	}

	public String[] getXlabels() {
		return xlabels;
	}

	public void setXlabels(String[] xlabels) {
		this.xlabels = xlabels;
	}

	public String[] getYlabels() {
		return ylabels;
	}

	public void setYlabels(String[] ylabels) {
		this.ylabels = ylabels;
	}

}
