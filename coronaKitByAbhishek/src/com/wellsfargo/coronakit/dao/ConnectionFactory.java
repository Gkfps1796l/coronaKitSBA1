package com.wellsfargo.coronakit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
	private static DataSource dataSource;
	public static Connection getConnection() throws SQLException {
		if(dataSource==null) {			
			try {
				InitialContext context = new InitialContext();
				dataSource = (DataSource)context.lookup("java:/comp/env/jdbc/coronakitdb");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
		return dataSource.getConnection();
	}
}
