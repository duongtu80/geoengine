package cn.geodata.models.ecoserv.actions;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.FeatureIterator;
import org.geotools.geometry.Envelope2D;
import org.geotools.referencing.CRS;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;

import cn.geodata.models.ecoserv.landcover.LandCover;
import cn.geodata.models.ecoserv.landcover.LandCoverMgr;
import cn.geodata.models.ecoserv.models.LandCoverChange;
import cn.geodata.models.raster.GeoRaster;

import com.vividsolutions.jts.geom.MultiPolygon;

public class LandcoverOp {
	private Logger log = Logger.getAnonymousLogger();

	protected InputStream stream;
	protected String contentType;
	protected String contentDisposition;
	
	protected String username;
	protected String data;
	protected Envelope2D extent;
	protected double cellSize;
	
	protected long startDate;
	protected long endDate;
	
	protected int id;
	
	public LandcoverOp() throws NoSuchAuthorityCodeException, FactoryException{
		//Give initialize extent and cell size
		this.extent = new Envelope2D(CRS.decode("EPSG:4326", true),
				-99.180463,47.047617,-99.009145,47.145636);
		this.cellSize = 120;
		
		this.contentType = "text/xml";
		this.contentDisposition = "landcover.xml";
		
		this.id = -1;
	}
	
	private MultiPolygon findBasinPolygon(String basin) throws IOException{
		ShapefileDataStore _store = new ShapefileDataStore(new File(LandcoverOp.class.getResource("/data/north_dakota/basin.shp").getFile()).toURL());
		FeatureSource _source = _store.getFeatureSource();
		
		FeatureIterator<SimpleFeature> _it = _source.getFeatures().features();
		while(_it.hasNext()){
			SimpleFeature _f = _it.next();
			
			if(_f.getAttribute("NAME").equals(basin)){
				return (MultiPolygon) _f.getDefaultGeometry();
			}
		}
		return null;
	}
	
	private LandCover initializeLandCover() throws IOException, SQLException {
		MultiPolygon _basin = this.findBasinPolygon("basin1");
		GeoRaster _raster = new GeoRaster(new File(LandcoverOp.class.getResource("/data/north_dakota/region.tif").getFile()), new Integer(0));
		
		return new LandCoverMgr().createLandCover(
				_basin, 
				"Landcover", "",
				_raster.getCellSizeX() * 1, _raster.getCellSizeY() * 1, _raster);
	}
	
	public String loadLand() throws Exception {
		log.info("Load landcover id " + this.id);
		
		LandCover _landCover = null;
		if(this.id < 0){
			_landCover = this.initializeLandCover();
		}
		else{
			_landCover = new LandCoverMgr().getLandCover(this.id);
		}
			
		this.stream = new ByteArrayInputStream(_landCover.createJSON().toString(2).getBytes("utf-8"));
		this.contentType = "text";
		this.contentDisposition = "attachment;filename=wetland.txt";
		
		return "success";
	}
	
	public String saveLand() throws Exception {
		log.info("Save data " + this.data);
		
		JSONObject _data = JSONObject.fromObject(this.data);
		
		log.info("Create landcover object");
		LandCover _landcover = new LandCover(_data);
		
		log.info("Save land cover object");
		(new LandCoverMgr()).saveLandCover(_landcover, this.username);
		
		log.info("Generate output stream [" + _landcover.getId() + "]");
		this.stream = new ByteArrayInputStream(("{id: " + _landcover.getId() + "}").getBytes("UTF-8"));
		this.contentType = "text";
		this.contentDisposition = "wetland.txt";
		
		return "success";
	}
	
	public String listLand() throws Exception {
		List<LandCover> _lands = (new LandCoverMgr()).listLandCover(this.username);
		
		JSONArray _list = new JSONArray();
		for(int i=0;i<_lands.size();i++){
			_list.add(_lands.get(i).createJSON());
		}
		
		JSONObject _data = new JSONObject();
		_data.put("landcover", _list);
		
		this.stream = new ByteArrayInputStream(_data.toString(2).getBytes("utf-8"));
		this.contentType = "text";
		this.contentDisposition = "wetland.txt";

		return "success";
	}
	
	public String downloadGeoTIFF() throws Exception {
		log.info("Download geotiff " + this.data);
		
		JSONObject _data = JSONObject.fromObject(this.data);
		
		log.info("Create landcover object");
		LandCover _landcover = new LandCover(_data);
		File _file = _landcover.outputGeoTIFF();
		
		this.stream = new FileInputStream(_file);
		this.contentType = "image/tiff";
		this.contentDisposition = "attachment;filename=\"" + _landcover.getTitle().replaceAll("[^\\w\\d]+", "_") + ".tif\"";
		
		return "success";
	}

	public String loadGeoTIFF() throws Exception {
		log.info("Load geotiff " + this.id);
		
		LandCover _landcover = new LandCoverMgr().getLandCover(this.id);
		File _file = _landcover.outputGeoTIFF();
		
		this.stream = new FileInputStream(_file);
		this.contentType = "image/tiff";
		this.contentDisposition = "attachment;filename=\"data.tif\"";
		
		return "success";
	}

	/**
	 * @return
	 * @deprecated
	 * @throws Exception
	 */
	public String loadImage() throws Exception {
		log.info("Load image " + this.id);
		
		LandCover _landcover = new LandCoverMgr().getLandCover(this.id);
		this.stream = _landcover.outputPNG(10);
		this.contentType = "image/png";
		this.contentDisposition = "filename=data.png;";
		
		return "success";
	}
	
	public String carbon() throws Exception {
		log.info("Carbon calculating...");
		
		Date _startDate = new Date(this.startDate);
		Date _endDate = new Date(this.endDate);
		
		List<LandCover> _lands = new ArrayList<LandCover>();
		_lands.add(new LandCoverMgr().getLandCover(28));
		_lands.add(new LandCoverMgr().getLandCover(29));
		
		LandCover _landcover = new LandCoverMgr().getLandCover(this.id);
		JSONObject _data = new JSONObject();
//		_data.put("data", new LandCoverChange().calculation(_landcover, _startDate, _endDate));
		
		JSONArray _data1 = new LandCoverChange().calculation(this.initializeLandCover(), _startDate, _endDate);
		JSONArray _data2 = new LandCoverChange().calculation(_landcover, _startDate, _endDate);
		
		JSONArray _data3 = new JSONArray();
		for(int i=0;i<_data1.size();i++){
			JSONObject _item = new JSONObject();
			_item.put("date", _data1.getJSONObject(i).get("date"));
			_item.put("Original", _data1.getJSONObject(i).get("CO2"));
			_item.put("Changed", _data2.getJSONObject(i).get("CO2"));
			
			_data3.add(_item);
		}
		
		_data.put("data", _data3);
		
		this.stream = new ByteArrayInputStream(_data.toString().getBytes("UTF-8"));
		this.contentType = "text";
		this.contentDisposition = "attachment;filename=\"data.txt\"";
		
		return "success";
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setData(String data) {
		this.data = data;
	}

	public InputStream getStream() {
		return stream;
	}

	public String getContentType() {
		return contentType;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}
}
