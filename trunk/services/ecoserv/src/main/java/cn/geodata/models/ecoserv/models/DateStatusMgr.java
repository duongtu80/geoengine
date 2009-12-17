package cn.geodata.models.ecoserv.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import cn.geodata.models.ecoserv.landcover.ConnectionPool;
import cn.geodata.models.ecoserv.landcover.LandCoverMgr;

public class DateStatusMgr {
	private Logger log = Logger.getAnonymousLogger();
	
	private int generateId() throws SQLException{
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			_state = _con.prepareStatement("SELECT nextval('date_status_id_seq'::regclass)");
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
	
//	public DateStatus init(Simulation simulation, LandCover landcover, Date date, Integer[] data, double precipitation, int precipitationState) throws SQLException{
//		return new DateStatus(this.generateId(), landcover, data, precipitation, precipitationState, date, simulation);
//	}
//	
	/**
	 * Save land cover to database
	 * 
	 * @param landcover
	 * @param creator
	 * @throws SQLException
	 */
	public void save(DateStatus data) throws SQLException {
		if(data.getId() <= 0){
			this.insert(data);
		}
		else{
			this.update(data);
		}
	}

	/**
	 * List saved land covers by creator name
	 * 
	 * @param creator
	 * @return
	 * @throws SQLException
	 */
	public List<DateStatus> list() throws SQLException {
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			_state = _con.prepareStatement("SELECT id, landcover_id, cells, precipitation, precipitation_state, status_date, simulation_id FROM date_status");

			_state.execute();
			ResultSet _rs = _state.getResultSet();
			
			List<DateStatus> _lands = new ArrayList<DateStatus>();
			while(_rs.next()){
				DateStatus _data = new DateStatus(_rs.getInt(1), new LandCoverMgr().getLandCover(_rs.getInt(2)), (Integer[])_rs.getArray(3).getArray(), _rs.getDouble(4), _rs.getInt(5), _rs.getDate(6), new SimulationMgr().get(_rs.getInt(7)));
				_lands.add(_data);
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
	public DateStatus get(int id) throws SQLException{
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			_state = _con.prepareStatement("SELECT id, landcover_id, cells, precipitation, precipitation_state, status_date, simulation_id FROM date_status WHERE id=" + id);

			_state.execute();
			ResultSet _rs = _state.getResultSet();
			
			if(_rs.next()){
				DateStatus _data = new DateStatus(_rs.getInt(1), new LandCoverMgr().getLandCover(_rs.getInt(2)), (Integer[])_rs.getArray(3).getArray(), _rs.getDouble(4), _rs.getInt(5), _rs.getDate(6), new SimulationMgr().get(_rs.getInt(7)));
				
				return _data;
			}
			
			log.warning("Failed to get date status with id " + id);
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
	 * Delete simulation
	 * 
	 * @param data
	 * @throws SQLException
	 */
	public void delete(DateStatus data) throws SQLException{
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			_state = _con.prepareStatement("DELETE FROM date_status WHERE id=" + data.getId());
			_state.execute();
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
	private void insert(DateStatus data) throws SQLException {
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			int _id = this.generateId();
			_state = _con.prepareStatement("INSERT INTO date_status(landcover_id, cells, precipitation, precipitation_state, id, status_date, simulation_id) VALUES (?, ?, ?, ?, ?,?,?)");
			
			_state.setInt(1, data.getLandcover().getId());
			_state.setArray(2, _con.createArrayOf("integer", data.getCells()));
			_state.setDouble(3, data.getPrecipitation());
			_state.setInt(4, data.getPrecipitationState());
			_state.setInt(5, _id);
			_state.setDate(6, new Date(data.getDate().getTime()));
			_state.setInt(7, data.getSimulation().getId());

			_state.execute();
			log.info("Insert successfully");

			data.setId(_id);
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
	private void update(DateStatus data) throws SQLException {
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			_state = _con.prepareStatement("UPDATE date_status SET landcover_id=?, cells=?, precipitation=?, precipitation_state=?, status_date=?, simulation_id=? WHERE id=?");
			
			_state.setInt(1, data.getLandcover().getId());
			_state.setArray(2, _con.createArrayOf("integer", data.getCells()));
			_state.setDouble(3, data.getPrecipitation());
			_state.setInt(4, data.getPrecipitationState());
			_state.setDate(5, new Date(data.getDate().getTime()));
			_state.setInt(6, data.getSimulation().getId());
			_state.setInt(7, data.getId());

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
