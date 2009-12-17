package cn.geodata.models.ecoserv.landcover;

import java.sql.Connection;
import java.sql.SQLException;

import org.postgresql.ds.PGConnectionPoolDataSource;

public class ConnectionPool {
	private static PGConnectionPoolDataSource dataSource = null;

	public static Connection getConnection() throws SQLException {
		if (ConnectionPool.dataSource == null) {
			PGConnectionPoolDataSource _ds = new PGConnectionPoolDataSource();
			_ds.setUser("wetland");
			_ds.setPassword("123456");
			_ds.setDatabaseName("wetland");
			_ds.setServerName("localhost");
			
//			_ds.setUser("wetland");
//			_ds.setPassword("");
//			_ds.setDatabaseName("wetland");
//			_ds.setServerName("localhost");

			ConnectionPool.dataSource = _ds;
		}
		
		return ConnectionPool.dataSource.getConnection(); 
	}
}
