package cn.geodata.models.glacier.actions.map;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import junit.framework.TestCase;

public class GlacierRunoffTest extends TestCase {
	public void testTest1() throws Exception {
//		System.out.println(new String("站点".getBytes(), "iso-8859-1"));
		GlacierRunoff
				.main(new String[] {
						"e:\\getdropbox\\My Dropbox\\data\\glacier\\data\\basin.shp",
						"站点", "1995", "2000",
						"o:\\mfeng\\test\\glacier\\100226" });
	}
	
//	public void testTest2() throws Exception {
//		SortedMap<String, Charset> _chart = Charset.availableCharsets();
//
//		List<String> _list = new ArrayList<String>();
//		for(String _c: _chart.keySet()){
//			_list.add(_c);
//		}
//		
//		for(String _c: _chart.keySet()){
//			for(String _b: _list){
//				try{
//					if((new String("站点".getBytes(_b), _chart.get(_c))).equals("վ��")){
//						System.out.println(_b + " ---- " + _c);
//					}
//				}
//				catch (Exception e) {
////					System.out.println("Skip " + _b);
//				}
//			}
//		}
//	}
}
