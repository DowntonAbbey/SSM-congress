package com.qf.meeting.dbutils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JdbcUtils {
   
	private static ComboPooledDataSource dataSource=null;
	
	static{
		dataSource=new ComboPooledDataSource();
		try {
			dataSource.setJdbcUrl("jdbc:mysql:///congress");
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setUser("root");
			dataSource.setPassword("root");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	
	
	public static QueryRunner getQueryRunner(){
		return new QueryRunner(dataSource);
	}
	
}
