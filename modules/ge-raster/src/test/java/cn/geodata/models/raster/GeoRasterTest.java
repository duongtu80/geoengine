package cn.geodata.models.raster;

import it.geosolutions.imageioimpl.plugins.tiff.TIFFImageReaderSpi;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

import org.geotools.geometry.Envelope2D;
import org.geotools.referencing.CRS;

import junit.framework.TestCase;

public class GeoRasterTest extends TestCase {
	public void testTest1() throws Exception {
		WritableRaster _w = GeoRaster.createWritableRaster(DataBuffer.TYPE_BYTE, 100, 100, 1);
		for(int _r=0;_r < _w.getHeight();_r++){
			for(int _c=0;_c < _w.getWidth();_c++){
				int _val = (int)(Math.random() * 100) + 10;
				System.out.println(_val);
				_w.setSample(_c, _r, 0, _val);
			}
		}
		_w.setSample(0, 0, 0, 0);
		
		GeoRaster.writeTiff(new File("p:\\mfeng\\prog\\data_manage_sys\\temp\\test1.tif"), new Envelope2D(CRS.decode("EPSG:4326"), 0, 0, 10, 10), _w);
	}
	
	public void testRead() throws Exception {
		GeoRaster _m = new GeoRaster(new File("p:\\mfeng\\prog\\data_manage_sys\\temp\\test1.tif"));
		System.out.println(_m.getType() + "|" + DataBuffer.TYPE_BYTE);
		System.out.println(_m.getNodata());
		for(int _r=0;_r < _m.getRowNum();_r++){
			for(int _c=0;_c < _m.getColNum();_c++){
				System.out.println(_m.getCell(_c, _r));
			}
		}
	}
	
	public void atestProcess() throws Exception {
		BufferedImage _ii = ImageIO.read(new File("p:\\mfeng\\prog\\data_manage_sys\\temp\\cproda.tif"));
		Raster _t = _ii.getRaster();
		System.out.println(_t.getWidth() + "," + _t.getHeight());
			
//		GeoRaster _m = new GeoRaster(new File("p:\\mfeng\\prog\\data_manage_sys\\temp\\cproda.tif"), CRS.decode("EPSG:4326"));
		
		for(int _pos=0;_pos < _t.getHeight();_pos ++){
			WritableRaster _w = GeoRaster.createWritableRaster(DataBuffer.TYPE_FLOAT, 10, 10, 1);
			for(int _r=0;_r < _w.getHeight();_r++){
				for(int _c=0;_c < _w.getWidth();_c++){
					float _val = _t.getSample(_c * 10 + _r, _pos, 0);
					System.out.println(_val);
					_w.setSample(9 - _c, 9 - _r, 0, _val);
				}
			}
			GeoRaster.writeTiff(new File("p:\\mfeng\\prog\\data_manage_sys\\temp\\cproda\\cproda_" + new DecimalFormat("00").format(_pos) + ".tif"), new Envelope2D(CRS.decode("EPSG:4326"), 0, 0, 10, 10), _w);
		}
	}
}
