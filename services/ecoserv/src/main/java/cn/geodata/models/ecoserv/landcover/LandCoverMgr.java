package cn.geodata.models.ecoserv.landcover;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.geotools.geometry.Envelope2D;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.MultiPolygon;

import cn.geodata.models.raster.GeoRaster;

/**
 * Manage land cover database
 * 
 * @author mfeng
 *
 */
public class LandCoverMgr {
	private Logger log = Logger.getAnonymousLogger();
	
	private int generateId() throws SQLException{
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			_state = _con.prepareStatement("SELECT nextval('landcover_id_seq'::regclass)");
			System.out.println("Execute:" + _state.execute());
			
			ResultSet _res = _state.getResultSet();
			_res.next();
			
			return _res.getInt(1);
		}
		finally{
			if(_state != null){
				_state.close();
			}
			
			_con.close();
		}
	}
	
	/**
	 * 
	 * Create a new landcover instance and initializes it using land cover dataset
	 * 
	 * @param extent
	 * @param cellx
	 * @param celly
	 * @param raster
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public LandCover createLandCover(MultiPolygon region, String title, String note, double cellx, double celly, GeoRaster raster) throws IOException, SQLException {
		Envelope _extent = region.getEnvelopeInternal();
		
		LandCover _landCover = new LandCover(
				0,
				title,
				note,
				new Envelope2D(null, _extent.getMinX(), _extent.getMinY(), _extent.getWidth(), _extent.getHeight()), 
				cellx, celly);
		_landCover.init(region, raster);
		log.exiting("LandCoverMgr", "createLandCover");

		return _landCover;
	}
	
	/**
	 * Save land cover to database
	 * 
	 * @param landcover
	 * @param creator
	 * @throws SQLException
	 */
	public void saveLandCover(LandCover landcover, String creator) throws SQLException {
		if(landcover.getId() == 0){
			this.insertLandCover(landcover, creator);
		}
		else{
			this.updateLandCover(landcover);
		}
	}

	/**
	 * List saved land covers by creator name
	 * 
	 * @param creator
	 * @return
	 * @throws SQLException
	 */
	public List<LandCover> listLandCover(String creator) throws SQLException {
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			_state = _con.prepareStatement("SELECT \"owner\", width, height, minx, miny, maxx, maxy, cellx, celly, id, title, note FROM landcover WHERE \"owner\"='" + creator + "' order by update_date desc");

			_state.execute();
			ResultSet _rs = _state.getResultSet();
			
			List<LandCover> _lands = new ArrayList<LandCover>();
			while(_rs.next()){
				Envelope2D _extent = new Envelope2D(null, _rs.getDouble(4), _rs.getDouble(5), _rs.getDouble(6) - _rs.getDouble(4), _rs.getDouble(7) - _rs.getDouble(5));
				LandCover _landCover = new LandCover(_rs.getInt(10), _rs.getString(11), _rs.getString(12), _extent, _rs.getDouble(8), _rs.getDouble(9), null);
				
				_lands.add(_landCover);
			}
			
			return _lands;
		}
		finally{
			if(_state != null){
				_state.close();
			}
			_con.close();
		}
	}

	/**
	 * Get land cover instance by ID
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public LandCover getLandCover(int id) throws SQLException{
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			_state = _con.prepareStatement("SELECT \"owner\", width, height, minx, miny, maxx, maxy, cellx, celly, cells, title, note FROM landcover WHERE id=" + id);

			_state.execute();
			ResultSet _rs = _state.getResultSet();
			
			if(_rs.next()){
				Envelope2D _extent = new Envelope2D(null, _rs.getDouble(4), _rs.getDouble(5), _rs.getDouble(6) - _rs.getDouble(4), _rs.getDouble(7) - _rs.getDouble(5));
				LandCover _landCover = new LandCover(id, _rs.getString(11), _rs.getString(12), _extent, _rs.getDouble(8), _rs.getDouble(9), (Integer[])_rs.getArray(10).getArray());
				
				return _landCover;
			}
			
			log.warning("Failed to get landcover with id " + id);
			return null;
		}
		finally{
			if(_state != null){
				_state.close();
			}
			_con.close();
		}
	}
	
	/**
	 * Save a new land cover instance into database and create new ID for it
	 * 
	 * @param landcover
	 * @param creator
	 * @throws SQLException
	 */
	private void insertLandCover(LandCover landcover, String creator) throws SQLException {
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			int _id = this.generateId();
			_state = _con.prepareStatement("INSERT INTO landcover(\"owner\", width, height, minx, miny, maxx, maxy, cellx, celly, cells, id, title, note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			_state.setString(1, creator);
			_state.setInt(2, landcover.getColCount());
			_state.setInt(3, landcover.getRowCount());
			_state.setDouble(4, landcover.getExtent().getMinX());
			_state.setDouble(5, landcover.getExtent().getMinY());
			_state.setDouble(6, landcover.getExtent().getMaxX());
			_state.setDouble(7, landcover.getExtent().getMaxY());
			_state.setDouble(8, landcover.getCellX());
			_state.setDouble(9, landcover.getCellY());
			
			_state.setArray(10, _con.createArrayOf("integer", landcover.getData()));
			_state.setInt(11, _id);
			_state.setString(12, landcover.getTitle());
			_state.setString(13, landcover.getNote());

			_state.execute();
			log.info("Insert successfully");

			landcover.setId(_id);
		}
		finally{
			if(_state != null){
				_state.close();
			}
			_con.close();
		}
	}
	
	/**
	 * Update land cover database using the give land cover instance
	 * 
	 * @param landcover
	 * @throws SQLException
	 */
	private void updateLandCover(LandCover landcover) throws SQLException {
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			_state = _con.prepareStatement("UPDATE landcover SET update_date=?, width=?, height=?, minx=?, miny=?, maxx=?, maxy=?, cellx=?, celly=?, cells=?, title=?, note=? WHERE id=?");
			
			_state.setDate(1, new Date(new java.util.Date().getTime()));
			_state.setInt(2, landcover.getColCount());
			_state.setInt(3, landcover.getRowCount());
			_state.setDouble(4, landcover.getExtent().getMinX());
			_state.setDouble(5, landcover.getExtent().getMinY());
			_state.setDouble(6, landcover.getExtent().getMaxX());
			_state.setDouble(7, landcover.getExtent().getMaxY());
			_state.setDouble(8, landcover.getCellX());
			_state.setDouble(9, landcover.getCellY());
			_state.setArray(10, _con.createArrayOf("integer", landcover.getData()));
			_state.setString(11, landcover.getTitle());
			_state.setString(12, landcover.getNote());
			_state.setInt(13, landcover.getId());

			_state.execute();
			log.info("Updated successfully");
		}
		finally{
			if(_state != null){
				_state.close();
			}
			_con.close();
		}
	}
}
