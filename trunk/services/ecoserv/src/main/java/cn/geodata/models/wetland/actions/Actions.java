package cn.geodata.models.wetland.actions;

public class Actions {
	private String key;
	
	public Actions(String key){
		this.key = key;
	}
	
	public String map() throws Exception {
		return "map";
	}

	public String getKey() {
		return key;
	}
}
