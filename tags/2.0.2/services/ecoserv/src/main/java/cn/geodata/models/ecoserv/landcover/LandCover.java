package cn.geodata.models.ecoserv.landcover;

import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.IndexColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.media.jai.RasterFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.GridCoverageFactory;
import org.geotools.geometry.Envelope2D;
import org.geotools.referencing.CRS;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;

import cn.geodata.models.raster.GeoRaster;

public class LandCover {
	private Logger log = Logger.getAnonymousLogger();
	
	protected int id;
	protected String title;
	protected String note;
	protected int rowCount;
	protected int colCount;
	protected double cellX;
	protected double cellY;
	protected Envelope2D extent;
	protected Integer[] data;
	
	protected Map<Integer, Integer> types; 
	
	public LandCover(int id){
		this.id = id;
		this.initLandCover();
	}

//	public LandCover(Envelope2D extent, int rowCount, int colCount){
//		this.rowCount = rowCount;
//		this.colCount = colCount;
//		this.extent = extent;
//		
//		this.cellX = extent.getWidth() / colCount;
//		this.cellY = extent.getHeight() / rowCount;
//		this.data = new int[rowCount][colCount];
//		
//		this.initLandCover();
//	}
	
	public LandCover(JSONObject data) {
		this(data.getInt("id"));
		
		this.colCount = data.getInt("width");
		this.rowCount = data.getInt("height");
		this.extent = new Envelope2D(null, data.getDouble("minx"), data.getDouble("miny"), data.getDouble("maxx") - data.getDouble("minx"), data.getDouble("maxy") - data.getDouble("miny"));
		this.cellX = data.getDouble("cellx");
		this.cellY = data.getDouble("celly");
		this.title = data.getString("title");
		this.note = data.getString("note");
		
		this.data = new Integer[this.rowCount * this.colCount];
		JSONArray _array = data.getJSONArray("data");
		for(int _row = 0;_row < this.rowCount;_row++){
			for(int _col = 0; _col < this.colCount; _col++){
				this.data[_row * this.colCount + _col] = _array.getInt(_row * this.colCount + _col);
			}
		}
	}

	public LandCover(int id, String title, String note, Envelope2D extent, double cellX, double cellY){
		this(id);

		this.title = title;
		this.note = note;
		this.extent = extent;
		this.colCount = (int)Math.ceil(extent.getWidth() / cellX);
		this.rowCount = (int)Math.ceil(extent.getHeight() / cellY);
		this.cellX = cellX;
		this.cellY = cellY;
		this.data = new Integer[rowCount * colCount];
	}

	public LandCover(int id, String title, String note, Envelope2D extent, double cellX, double cellY, Integer[] data){
		this(id);

		this.title = title;
		this.note = note;
		this.extent = extent;
		this.colCount = (int)Math.ceil(extent.getWidth() / cellX);
		this.rowCount = (int)Math.ceil(extent.getHeight() / cellY);
		this.cellX = cellX;
		this.cellY = cellY;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	private void initLandCover(){
		this.types = new HashMap<Integer, Integer>();
		
		this.types.put(11, 1);
		this.types.put(12, 1);
			
		this.types.put(21, 2);
		this.types.put(22, 2);
		this.types.put(23, 2);
		this.types.put(24, 2);
		this.types.put(31, 2);
		this.types.put(32, 2);
			
		this.types.put(41, 3);
		this.types.put(42, 3);
		this.types.put(43, 3);
		this.types.put(51, 3);
		this.types.put(52, 3);
			
		this.types.put(71, 4);
		this.types.put(72, 4);
		this.types.put(73, 4);
		this.types.put(74, 4);
			
		this.types.put(81, 5);
		this.types.put(82, 5);
			
		this.types.put(90, 6);
		this.types.put(91, 6);
		this.types.put(92, 6);
		this.types.put(93, 6);
		this.types.put(94, 6);
		this.types.put(95, 6);
		this.types.put(96, 6);
		this.types.put(97, 6);
		this.types.put(98, 6);
		this.types.put(99, 6);
	}
	
	public void init(MultiPolygon region, GeoRaster raster) throws IOException{
		GeometryFactory _factory = new GeometryFactory();
		
		double _y = this.extent.getMaxY() - cellY / 2;
		for(int _row=0;_row < this.rowCount;_row++){
			double _x = this.extent.getMinX() + cellX / 2;
			for(int _col=0;_col < this.colCount;_col++){
				if(region.contains(_factory.createPoint(new Coordinate(_x, _y)))){
					data[_row * this.colCount + _col] = this.convertLandCoverType(raster.getLocationValue(_x, _y)); 
				}
				else{
					data[_row * this.colCount + _col] = 0;
				}
				_x += cellX;
			}
			_y -= cellY;
		}
	}

	public int convertLandCoverType(Number type){
		if(type == null)
			return 0;
		
		int _type = type.intValue();
		return this.types.get(_type);
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColCount() {
		return colCount;
	}

	public String getTitle() {
		return title;
	}

	public String getNote() {
		return note;
	}

	public double getCellX() {
		return cellX;
	}

	public double getCellY() {
		return cellY;
	}

	public Envelope2D getExtent() {
		return extent;
	}

	public Integer[] getData() {
		return data;
	}

	public JSONObject createJSON(){
		JSONArray _array = new JSONArray();
		if(this.data != null){
			for(int _row = 0;_row < this.rowCount;_row++){
				for(int _col = 0; _col < this.colCount; _col++){
					_array.put(this.data[_row * this.colCount + _col]);
				}
			}
		}
		
		JSONObject _data = new JSONObject();
		
		_data.put("width", this.colCount);
		_data.put("height", this.rowCount);
		_data.put("minx", this.extent.getMinX());
		_data.put("maxx", this.extent.getMaxX());
		_data.put("miny", this.extent.getMinY());
		_data.put("maxy", this.extent.getMaxY());
		_data.put("cellx", this.cellX);
		_data.put("celly", this.cellY);
		_data.put("data", _array);
		_data.put("id", this.id);
		_data.put("title", this.title);
		_data.put("note", this.note);
		
		return _data;
	}
	
	public File outputGeoTIFF() throws Exception {
		File _file = File.createTempFile("raster", ".tif");
		
		byte[] _reds = {(byte) 0xFF, 0x30, (byte) 0xdd, 0x14, (byte) 0xab, (byte) 0xc9, 0x6f};
		byte[] _greens = {(byte) 0xFF, (byte) 0x8e, (byte) 0xe7, (byte) 0x94, (byte) 0xf9, 0x6e, (byte) 0x98};
		byte[] _blues = {(byte) 0xFF, (byte) 0xe3, 0x37, 0x41, 0x5b, (byte) 0xe3, 0x5c};
		
		IndexColorModel _model = new IndexColorModel(4, _reds.length, _reds, _greens, _blues, 0);
	    BufferedImage _image = new BufferedImage(this.colCount, this.rowCount, BufferedImage.TYPE_BYTE_INDEXED, _model);

		WritableRaster _raster = _image.getRaster();
		for(int _row = 0;_row < this.rowCount;_row++){
			for(int _col = 0; _col < this.colCount; _col++){
				_raster.setSample(_col, _row, 0, this.data[_row * this.colCount + _col]);
			}
		}

		this.extent.setCoordinateReferenceSystem(CRS.decode("EPSG:4326", true));
		GridCoverage2D _grid = new GridCoverageFactory().create("image", _image, this.extent);

		GeoRaster.writeTiff(_file, _grid);
		
		return _file;
	}
	
	public InputStream outputPNG(int scale) throws IOException, SQLException{
		byte[] _reds = {(byte) 0xFF, 0x30, (byte) 0xdd, 0x14, (byte) 0xab, (byte) 0xc9, 0x6f, 0x11};
		byte[] _greens = {(byte) 0xFF, (byte) 0x8e, (byte) 0xe7, (byte) 0x94, (byte) 0xf9, 0x6e, (byte) 0x98, 0x11};
		byte[] _blues = {(byte) 0xFF, (byte) 0xe3, 0x37, 0x41, 0x5b, (byte) 0xe3, 0x5c, 0x11};
		
		IndexColorModel _model = new IndexColorModel(4, _reds.length, _reds, _greens, _blues, 0);
	    BufferedImage _image = new BufferedImage(this.getColCount() * scale, this.getRowCount() * scale, BufferedImage.TYPE_BYTE_INDEXED, _model);
		
	    WritableRaster _r = _image.getRaster();
		for(int _row=0;_row < scale * this.getRowCount(); _row++){
			for(int _col=0;_col < scale * this.getColCount();_col++){
				if(scale > 2 && (_row % scale == 0 || _col % scale == 0)){
					_r.setSample(_col, _row, 0, _reds.length - 1);
				}
				else{
					_r.setSample(_col, _row, 0, this.getData()[(_col / scale) + (_row / scale) * this.getColCount()]);
				}
			}
		}
		
		ByteArrayOutputStream _s = new ByteArrayOutputStream();
		try{
			ImageIO.write(_image, "png", _s);
			return new ByteArrayInputStream(_s.toByteArray());
		}
		finally{
			_s.close();
		}
	}
}
