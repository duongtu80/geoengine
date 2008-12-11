package cn.geodata.models.wetland.actions.map;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import junit.framework.TestCase;

public class ProcessOutputExcelTest extends TestCase {
	
	public void testTest1() throws Exception {
		HSSFWorkbook _wb = new HSSFWorkbook();
		HSSFSheet _s = _wb.createSheet("waterlevel");
		
		for(int i=0;i<HSSFDataFormat.getNumberOfBuiltinBuiltinFormats();i++){
			System.out.println(HSSFDataFormat.getBuiltinFormat((short)i));
		}
		
		HSSFCellStyle _dateCellStyle = _wb.createCellStyle();
		_dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

		HSSFRow _rowHeader = _s.createRow(0);
		HSSFCell _c = _rowHeader.createCell(0);
		
		_c.setCellStyle(_dateCellStyle);
		_c.setCellValue(new Date());
		
		FileOutputStream _stream = new FileOutputStream(new File("d:\\tttt.xls"));
		_wb.write(_stream);
	}
}
