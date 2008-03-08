package cn.geodata.models.wetland.actions.map;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;

public class ChartData {
	private String columnNames;
	private String matrix;
	private String wetland;
	
	public ChartData(InputStream stream, String pos) throws IOException{
		String[] _lines = (String[]) IOUtils.readLines(stream).toArray(new String[0]);

		int _loc = 0;
		String[] _lineNames = _lines[0].split("\t");
		for (int i = 1; i < _lineNames.length; i++) {
			if(_lineNames[i].equalsIgnoreCase(pos)){
				_loc = i;
				break;
			}
		}
		
		if(_loc == 0){
			throw new IOException("Failed to find the request wetland " + pos);
		}

		this.columnNames = "0:|";
		this.matrix = "t:";
		for(int i=1;i<_lines.length;i++){
			String _line = _lines[i].trim();
			if(_line.length() > 0){
				String[] _values = _line.split("\t");
				
				if(this.columnNames.length() > 3){
					this.columnNames += "|";
				}
				this.columnNames += _values[0];
				
				if(matrix.length() > 2){
					matrix += ",";
				}
				matrix += _values[_loc];
			}
		}
		
		this.wetland = pos;
	}

	public String getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String columnNames) {
		this.columnNames = columnNames;
	}

	public String getMatrix() {
		return matrix;
	}

	public void setMatrix(String matrix) {
		this.matrix = matrix;
	}
}
