package com.quangdo.connectMySQL;

import java.sql.*;


public class ConnectMySQL {
	public Connection getConnection() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/quanlythuvien";
			String user = "root";
			String password = "qtouliver";
			return DriverManager.getConnection(url, user, password);
	};			
}
