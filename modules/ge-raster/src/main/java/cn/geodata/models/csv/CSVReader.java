package cn.geodata.models.csv;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class CSVReader {
	private List<String> header;
	private List<Map<String, String>> records;
	
	public CSVReader(File file) throws IOException{
		List<String> _lines = (List<String>)FileUtils.readLines(file);
		
		this.header = this.readHeader(_lines.get(0));
		
		this.records = new ArrayList<Map<String,String>>();
		for(int i=1;i<_lines.size();i++){
			String[] _parts = _lines.get(i).split("\\s*,\\s*");
			if(_parts.length == this.header.size()){
				Map<String, String> _r = new HashMap<String, String>();
				for(int j=0;j<_parts.length;j++){
					_r.put(this.header.get(j), _parts[j]);
				}
				
				this.records.add(_r);
			}
		}
	}
	
	public CSVReader(InputStream stream) throws IOException{
		List<String> _lines = (List<String>)IOUtils.readLines(stream);
		
		this.header = this.readHeader(_lines.get(0));
		
		this.records = new ArrayList<Map<String,String>>();
		for(int i=1;i<_lines.size();i++){
			String[] _parts = _lines.get(i).split("\\s*,\\s*");
			if(_parts.length == this.header.size()){
				Map<String, String> _r = new HashMap<String, String>();
				for(int j=0;j<_parts.length;j++){
					_r.put(this.header.get(j), _parts[j]);
				}
				
				this.records.add(_r);
			}
		}
	}
	
	private List<String> readHeader(String line){
		return Arrays.asList(line.split("\\s*,\\s*"));
	}

	public List<String> getHeader() {
		return header;
	}

	public List<Map<String, String>> getRecords() {
		return records;
	}
}
