package cn.geodata.models.glacier.actions.models;

import java.io.InputStream;

public class Temperature {
	private long date;
	private double maxDistance;
	private double x;
	private double y;
	private InputStream stream;
	
	public String execute() throws Exception {
		return "success";
	}
}
