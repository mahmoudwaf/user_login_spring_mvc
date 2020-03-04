package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MySqlConnector {
	public Connection getConnection() {
		String DATASOURCE_CONTEXT = "java:jboss/datasources/MySqlDS";
	    Connection connection = null;
	    try {
	      Context initialContext = new InitialContext();
	      DataSource datasource = (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
		      if (datasource != null) {
		    	  connection =  datasource.getConnection();
		      }
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	    return connection;
	}
	
	public void fetchUsers() {
		String sql = "select * from exam.users";
		try {
			Statement st = getConnection().prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("username"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
