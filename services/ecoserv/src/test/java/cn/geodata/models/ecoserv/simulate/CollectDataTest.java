package cn.geodata.models.ecoserv.simulate;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import cn.geodata.models.raster.GeoRaster;

import junit.framework.TestCase;

public class CollectDataTest extends TestCase {
	public void testCollectSample() throws Exception {
//		this.collectSample(new File("p:\\mfeng\\data\\climate\\IPCC_Climate_Data\\unzip\\sres_b2\\tmax"));
//		this.collectSample(new File("p:\\mfeng\\data\\climate\\IPCC_Climate_Data\\unzip\\sres_b2\\tmin"));
//		this.collectSample(new File("p:\\mfeng\\data\\climate\\IPCC_Climate_Data\\unzip\\sres_b2\\prec"));
		this.collectSample(new File("p:\\mfeng\\data\\climate\\IPCC_Climate_Data\\unzip\\sres_b2\\srad"));
		this.collectSample(new File("p:\\mfeng\\data\\climate\\IPCC_Climate_Data\\unzip\\sres_b2\\vapr"));
		this.collectSample(new File("p:\\mfeng\\data\\climate\\IPCC_Climate_Data\\unzip\\sres_b2\\wspd"));
//		this.collectSample(new File("p:\\mfeng\\data\\climate\\IPCC_Climate_Data\\unzip\\sres_a2\\tmax"));
//		this.collectSample(new File("p:\\mfeng\\data\\climate\\IPCC_Climate_Data\\unzip\\sres_a2\\tmin"));
//		this.collectSample(new File("p:\\mfeng\\data\\climate\\IPCC_Climate_Data\\unzip\\sres_a2\\prec"));
		this.collectSample(new File("p:\\mfeng\\data\\climate\\IPCC_Climate_Data\\unzip\\sres_a2\\srad"));
		this.collectSample(new File("p:\\mfeng\\data\\climate\\IPCC_Climate_Data\\unzip\\sres_a2\\vapr"));
		this.collectSample(new File("p:\\mfeng\\data\\climate\\IPCC_Climate_Data\\unzip\\sres_a2\\wspd"));
	}
	
	public void collectSample(File folder) throws Exception {
		
		File _out = new File("E:\\Downloads\\" + folder.getParentFile().getName() + "_" + folder.getName() + ".txt");
		FileOutputStream _s = new FileOutputStream(_out);
		
		Pattern _p = Pattern.compile(".+anom(\\d{4})\\.(\\d+)\\..*");
		
		List<String> _dates = new ArrayList<String>();
		Map<String, File> _files = new HashMap<String, File>();
		
		for(File _f: (Collection<File>) FileUtils.listFiles(folder, new String[] {"tif"}, true)){
			Matcher _m = _p.matcher(_f.getName());
			if(!_m.matches())
				throw new Exception();
			
			String _id = _m.group(1) + "-" + String.format("%02d", Integer.parseInt(_m.group(2)));
			
			_dates.add(_id);
			_files.put(_id, _f);
		}

		Collections.sort(_dates);
		for(String _t: _dates){
			File _f = _files.get(_t);
			
			GeoRaster _r = new GeoRaster(_f, -340282346638528860000000000000000000000.000000);
			Number _val = _r.getLocationValue(-99.096349011162,
					47.103407185113);
			
			Matcher _m = _p.matcher(_f.getName());
			if(!_m.matches())
				throw new Exception();
				
			System.out.println(_t);
			IOUtils.write(_t + "\t" + _val + "\n", _s);
//			System.out.println(_val);
		}

		_s.close();
	}
}
