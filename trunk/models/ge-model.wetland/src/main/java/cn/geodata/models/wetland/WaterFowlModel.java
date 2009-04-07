package cn.geodata.models.wetland;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

@GeoProcess(title="Water Fowl Model", keywords={"bird", "waterfowl"})
public class WaterFowlModel implements Calculate  {
	private double wetlandArea;
	private String waterFowl; 
	private int number;
	
	private Map<String, Double> coefficentA;
	private Map<String, Double> coefficentB;

	public WaterFowlModel() throws IOException {
		this.coefficentA = new HashMap<String, Double>();
		this.coefficentB = new HashMap<String, Double>();
		
		for(String _line: (List<String>)IOUtils.readLines(WaterFowlModel.class.getResourceAsStream("/wetland/waterFowls.txt"))){
			String[] _parts = _line.split("\\s*,\\s*");
			if(_parts.length == 3){
				this.coefficentA.put(_parts[0], Double.parseDouble(_parts[1]));
				this.coefficentB.put(_parts[0], Double.parseDouble(_parts[2]));
			}
		}
	}
	
	public void calculate() throws Exception {
		if(this.coefficentA.containsKey(this.waterFowl) == false){
			throw new Exception("No parameter for " + this.waterFowl);
		}
		
		//Translate to ha
		double _wetlandArea = this.wetlandArea / 10000;
		
		//Calculate
		this.number = (int)Math.round(_wetlandArea * this.coefficentA.get(this.waterFowl) + Math.sqrt(_wetlandArea) * this.coefficentB.get(this.waterFowl));
	}

	@GeoOutput(title="Number of breeding pairs", required=true)
	public int getNumber() {
		return number;
	}

	@GeoInput(title="Wetland Area", required=true)
	public void setWetlandArea(double wetlandArea) {
		this.wetlandArea = wetlandArea;
	}

	@GeoInput(title="Waterfowl Name", required=true)
	public void setWaterFowl(String waterFowl) {
		this.waterFowl = waterFowl;
	}


	public void cancel() {
	}

	public int getPercent() {
		return 0;
	}

	public String getStatus() {
		return null;
	}
}
