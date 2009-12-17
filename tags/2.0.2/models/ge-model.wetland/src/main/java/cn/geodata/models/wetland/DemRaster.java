package cn.geodata.models.wetland;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class DemRaster {
	private EnviRasterReader raster;
	private float nodata;
	
	public DemRaster() throws FileNotFoundException, IOException{
		String[] _fileList = new String[] {"dem", "dem.hdr"};
		File _temp = new File(System.getProperty("java.io.tmpdir"));
		
		for(String _f : _fileList){
			File _file = new File(_temp, _f);
			if(_file.exists() == false || _file.length() == 0){
				IOUtils.copy(WaterRegionModel.class.getResourceAsStream("/wetland/data/" + _f), new FileOutputStream(_file));
			}
		}

		this.raster = new EnviRasterReader(new File(_temp, _fileList[0]).toURL(), new File(_temp, _fileList[1]).toURL(), 1024 * 1024);
		this.nodata = 0;
	}

	public DemRaster(URL body, URL header, int bufferSize) throws IOException {
		this.raster = new EnviRasterReader(body, header, bufferSize);
		this.nodata = 0;
	}

	public EnviRasterReader getRaster() {
		return raster;
	}

	public float getNodata() {
		return nodata;
	}
}
