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

public class SimulationMgr {
	private Logger log = Logger.getAnonymousLogger();
	
	private int generateId() throws SQLException{
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			_state = _con.prepareStatement("SELECT nextval('simulation_id_seq'::regclass)");
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
	 * Save land cover to database
	 * 
	 * @param landcover
	 * @param creator
	 * @throws SQLException
	 */
	public void save(Simulation data, String username) throws SQLException {
		if(data.getId() <= 0){
			this.insert(data, username);
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
	public List<Simulation> list() throws SQLException {
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			_state = _con.prepareStatement("SELECT id, create_date, username FROM simulation");

			_state.execute();
			ResultSet _rs = _state.getResultSet();
			
			List<Simulation> _lands = new ArrayList<Simulation>();
			while(_rs.next()){
				Simulation _data = new Simulation(_rs.getInt(1), _rs.getString(3), _rs.getDate(2));
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
	public Simulation get(int id) throws SQLException{
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			_state = _con.prepareStatement("SELECT id, create_date, username FROM simulation WHERE id=" + id);

			_state.execute();
			ResultSet _rs = _state.getResultSet();
			
			if(_rs.next()){
				Simulation _data = new Simulation(_rs.getInt(1), _rs.getString(3), _rs.getDate(2));
				
				return _data;
			}
			
			log.warning("Failed to get simulation with id " + id);
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
	public void delete(Simulation data) throws SQLException{
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			_state = _con.prepareStatement("DELETE FROM simulation WHERE id=" + data.getId());
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
	private void insert(Simulation data, String username) throws SQLException {
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			int _id = this.generateId();
			_state = _con.prepareStatement("INSERT INTO simulation(id, create_date, username) VALUES (?, ?, ?)");
			
			_state.setInt(1, _id);
			_state.setDate(2, new Date(new java.util.Date().getTime()));
			_state.setString(3, username);

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
	private void update(Simulation data) throws SQLException {
		Connection _con = ConnectionPool.getConnection();
		PreparedStatement _state = null;
		try{
			_state = _con.prepareStatement("UPDATE simulation SET username=? WHERE id=?");
			
			_state.setString(1, data.getUsername());
			_state.setInt(2, data.getId());

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
