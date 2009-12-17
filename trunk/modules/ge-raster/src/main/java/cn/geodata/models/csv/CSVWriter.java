package cn.geodata.models.csv;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class CSVWriter {
	private List<String> lines;
	
	private File file;
	private String[] headers;
	
	public CSVWriter(File file, String[] headers) throws IOException{
		this.file = file;
		this.headers = headers;
		
		this.lines = new ArrayList<String>();
		this.lines.add(Arrays.toString(headers).replaceAll("[\\[\\]\\s]", ""));
	}
	
	public void addLine(String[] values) throws IOException{
		if(values.length != this.headers.length){
			throw new IOException("Value number does not consist with header number");
		}
		
		this.lines.add(Arrays.toString(values).replaceAll("[\\[\\]\\s]", ""));
	}

	public void addLine(List<Object> values) throws IOException{
		if(values.size() != this.headers.length){
			throw new IOException("Value number does not consist with header number");
		}
		
		String[] _values = new String[values.size()];
		for(int i=0;i<values.size();i++){
			Object _val = values.get(i);
			
			if(_val == null)
				_values[i] = "";
			else
				_values[i] = _val.toString();
		}
		
		this.addLine(_values);
	}

	public void write() throws IOException{
		FileUtils.writeLines(file, "utf-8", lines, "\n");
	}
}
