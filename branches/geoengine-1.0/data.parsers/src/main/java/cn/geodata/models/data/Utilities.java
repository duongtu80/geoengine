package cn.geodata.models.data;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Utilities {
	private static Logger log = Logger.getLogger("cn.geodata.models");
	
	public static File createTempFile() throws IOException{
		return File.createTempFile("complex", "dat");
	}
	
	public static Logger getLogger(){
		return log;
	}
}
