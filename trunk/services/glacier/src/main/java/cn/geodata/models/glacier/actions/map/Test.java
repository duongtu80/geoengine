package cn.geodata.models.glacier.actions.map;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Test {

	private int count;
	private InputStream stream;

	public Test(){
		this.count = 0;
	}
	
	public InputStream getStream() {
		return stream;
	}

	public String execute() throws Exception {
		this.stream =  new ByteArrayInputStream(("" + count++).getBytes());
		
		return "success";
	}
}
