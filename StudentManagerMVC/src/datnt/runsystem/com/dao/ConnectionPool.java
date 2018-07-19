package datnt.runsystem.com.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

public class ConnectionPool {
	/*
	 * username và password database
	 */
	private final String usernameDB = "datnt";
	private final String passwordDB = "";
	
	/*
	 * Database url 
	 */
	private final String urlDB      = "jdbc:mysql://localhost:3306/StudenManagerDB?autoReconnect=true&useSSL=false";
	
	/*
	 * Số lượng connection tối đa trong pool
	 */
	private final int    maxConn    = 10;
	
	private DataSource                    dataSource;
	private GenericObjectPool<Connection> gPool;
	
	private static ConnectionPool instance   = null;
	
	@SuppressWarnings("unused")
	private ConnectionPool() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		this.gPool = new GenericObjectPool<Connection>();
		this.gPool.setMaxActive(this.maxConn);
		
		ConnectionFactory connectionFactory = 
				new DriverManagerConnectionFactory(this.urlDB, this.usernameDB, this.passwordDB);
		
		PoolableConnectionFactory pcf = 
				new PoolableConnectionFactory(connectionFactory, gPool, null, null, false, true);
		
		this.dataSource = new PoolingDataSource(this.gPool);
	}
	
	public static ConnectionPool getInstance() throws ClassNotFoundException {
		
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}
	
	public GenericObjectPool<Connection> getConnectionPool() {
		return this.gPool;
	}
	
	public DataSource getDataSource() {
		return this.dataSource;
	}
}
