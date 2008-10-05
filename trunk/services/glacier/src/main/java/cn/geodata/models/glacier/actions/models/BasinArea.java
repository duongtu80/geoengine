package cn.geodata.models.glacier.actions.models;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

public class BasinArea {
	private Map<String, double[]> map;
	
	public BasinArea() throws IOException{
		Map<String, double[]> map = new HashMap<String, double[]>();
		List<String> _list = IOUtils.readLines(BasinArea.class.getResourceAsStream("/glacier/glacier.area.csv"), "gb2312");
		
		for(String _l : _list){
			String[] _parts = _l.split(",");
			String _n = _parts[0];
			
			double[] _vs = new double[_parts.length - 1];
			for(int i=1;i<_parts.length;i++){
				_vs[i-1] = Double.parseDouble(_parts[i]);
			}
			
			map.put(_n, _vs);
		}
	}
	
	public double[] getBasinArea(String basin){
		return this.map.get(basin);
	}
	
	public double[] getLevels(){
		return this.map.remove("Levels");
	}
}
