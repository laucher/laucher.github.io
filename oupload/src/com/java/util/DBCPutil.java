package com.java.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;
import javax.sql.rowset.spi.TransactionalWriter;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPutil {
	private static DataSource dataSource;
	
	static{	
		try {
			InputStream in = DBCPutil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties props = new Properties();
			props.load(in);
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public static DataSource getDataSource(){
		return dataSource;
	}
	public static Connection getConnection() {
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
		return connection;
	}
	public static void  startTran(Connection conn){
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void endTran(Connection conn){
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void  rollbackTran(Connection conn){
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void  setSaveTran(Connection conn){
		try {
			conn.setSavepoint();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void  setTranLeve(Connection conn,int level){
		try {
			conn.setTransactionIsolation(level);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
