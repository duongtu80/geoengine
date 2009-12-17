package cn.geodata.models.wetland.actions.map;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ProcessOutputExcel extends AbstractProcess {
	private Logger log = Logger.getAnonymousLogger();
	
	private String id;
	private InputStream stream;
	
	public void setId(String id) {
		this.id = id;
	}

	public InputStream getStream() {
		return stream;
	}

	public String execute() throws Exception {
		JSONObject _status = this.manage.getProcess(id).getStatus();
		if((Integer)_status.get("percent") < 100){
			throw new Exception("Not finished yet");
		}
		
		HSSFWorkbook _wb = new HSSFWorkbook();
		HSSFSheet _s = _wb.createSheet("waterlevel");
		
		String[] _tags = new String[] {"Date", "ET", "WaterLevel", "Precipitation"};
		
		HSSFRow _rowHeader = _s.createRow(0);
		for(int i=0;i<_tags.length;i++){
			_rowHeader.createCell(i).setCellValue(_tags[i]);
		}
		
		JSONObject _data = this.manage.getProcess(id).getData();
		
		JSONArray _dates = _data.getJSONArray("date");
		JSONArray _ets = _data.getJSONArray("eT");
		JSONArray _waterLevels = _data.getJSONArray("waterLevel");
		JSONArray _precipitation = _data.getJSONArray("precipitation");

		HSSFCellStyle _dateCellStyle = _wb.createCellStyle();
		_dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
		
		for(int i=0;i<_dates.size();i++){
			HSSFRow _rowData = _s.createRow(i + 1);
			
//			log.info("Date:" + new Date(_dates.getLong(i)));
			HSSFCell _c = _rowData.createCell(0);
			_c.setCellStyle(_dateCellStyle);
			_c.setCellValue(new Date(_dates.getLong(i)));
			
			_rowData.createCell(1).setCellValue(_ets.getDouble(i));
			_rowData.createCell(2).setCellValue(_waterLevels.getDouble(i));
			_rowData.createCell(3).setCellValue(_precipitation.getDouble(i));
		}
		
		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
		_wb.write(_stream);
		
		this.stream = new ByteArrayInputStream(_stream.toByteArray());
		
		return "success";
	}
}
