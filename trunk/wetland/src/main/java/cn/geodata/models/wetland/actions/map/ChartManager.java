package cn.geodata.models.wetland.actions.map;

import java.io.IOException;

public class ChartManager {
	private String dataPath;
	
	public String getDataPath() {
		return dataPath;
	}
	public void setDataPath(String dataPath) {
		this.dataPath = dataPath;
	}
	
	public ChartData loadChartData(String dataType, String wetland) throws IOException{
		return new ChartData(ChartManager.class.getResourceAsStream(this.getDataPath() + dataType + ".txt"), wetland);
	}

	public ChartData2 loadChartData2(String dataType) throws IOException{
		return new ChartData2(ChartManager.class.getResourceAsStream(this.getDataPath() + dataType + ".txt"));
	}
}
