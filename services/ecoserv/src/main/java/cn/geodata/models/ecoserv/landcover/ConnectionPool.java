package cn.geodata.models.ecoserv.landcover;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.geotools.data.jdbc.JDBCDataStoreConfig;
import org.geotools.data.jdbc.datasource.ManageableDataSource;
import org.geotools.data.postgis.PostgisDataStore;
import org.geotools.data.postgis.PostgisDataStoreFactory;
import org.postgresql.ds.PGConnectionPoolDataSource;

public class ConnectionPool {
	private static PGConnectionPoolDataSource dataSource = null;
	private static ManageableDataSource pgConnection;

	public ConnectionPool(String server, String database, String username, String password){
		if (ConnectionPool.dataSource == null) {
			PGConnectionPoolDataSource _ds = new PGConnectionPoolDataSource();
			_ds.setUser(username);
			_ds.setPassword(password);
			_ds.setDatabaseName(database);
			_ds.setServerName(server);
			
			ConnectionPool.dataSource = _ds;
		}
	}
	
	public static Connection getConnection() throws SQLException {
		if (ConnectionPool.dataSource == null) {
			PGConnectionPoolDataSource _ds = new PGConnectionPoolDataSource();
			_ds.setUser("wetland");
			_ds.setPassword("123456");
			_ds.setDatabaseName("wetland");
			_ds.setServerName("localhost");
			
			ConnectionPool.dataSource = _ds;
		}
		
		return ConnectionPool.dataSource.getConnection(); 
	}
	
	public static ManageableDataSource getPGConnection() throws IOException {
		if(ConnectionPool.pgConnection == null){
			ConnectionPool.pgConnection = PostgisDataStoreFactory.getDefaultDataSource("localhost", "wetland", "123456", 5432, "wetland", 5, 1, false);
		}
		
		return ConnectionPool.pgConnection;
	}
	
	public static PostgisDataStore getPGDataStore() throws IOException {
		JDBCDataStoreConfig _jdbc = JDBCDataStoreConfig.createWithNameSpaceAndSchemaName("http://www.geodata.cn", "public");
		
		return new PostgisDataStore(ConnectionPool.getPGConnection(), _jdbc, PostgisDataStore.OPTIMIZE_SQL);
	}
}
