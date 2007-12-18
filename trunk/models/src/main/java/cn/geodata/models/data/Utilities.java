package cn.geodata.models.data;

import java.io.File;
import java.io.IOException;

public class Utilities {
	public static File createTempFile() throws IOException{
		return File.createTempFile("complex", "dat");
	}
}
