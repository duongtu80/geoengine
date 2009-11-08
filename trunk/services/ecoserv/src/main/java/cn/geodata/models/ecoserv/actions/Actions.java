package cn.geodata.models.ecoserv.actions;

public class Actions {
	private String key;
	
	public Actions(String key){
		this.key = key;
	}
	
	public String map() throws Exception {
		return "map";
	}

	public String landcover() throws Exception {
		return "landcover";
	}

	public String getKey() {
		return key;
	}
}
