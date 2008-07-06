package cn.geodata.models.wetland;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import junit.framework.TestCase;

public class DayMetReaderTest extends TestCase {

	public void testRead() throws IOException, ParseException {
		DayMetReader _reader = new DayMetReader();
		_reader.setUrl("http://www.daymet.org/getRawData.do?lon=%f&lat=%f");
		
		double _x = -99.08000;
		double _y = 47.08000;
		
		ArrayList<DayMet> _list = _reader.read(null, null, _x, _y);
		for(DayMet _line : _list){
			System.out.println(_line.getDate().toString());
		}
	}

}
