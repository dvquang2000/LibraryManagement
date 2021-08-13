package com.quangdo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quangdo.connectMySQL.ConnectMySQL;
import com.quangdo.exception.ApplicationException;

import com.quangdo.model.User;

public class UserDao {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public User loginUser(String email,String password) throws SQLException{
		try {
			String  sql = "select * from user a where a.email = ? and password = ?";
			//String  sql = "select * from user a where a.email = ?";//'"+ email+"'and password ='"+password+"'";
			connection = new ConnectMySQL().getConnection();
			ps= connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			rs.next();
			User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ApplicationException("Email or Password invalid", e);
		}
		
	}
	public User loginUser(String email) throws SQLException{
		try {
			String  sql = "select * from user a where a.email = ?";//'"+ email+"'and password ='"+password+"'";
			connection = new ConnectMySQL().getConnection();
			ps= connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			rs.next();
			User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ApplicationException("Email or Password invalid", e);
		}
		
	}
	
	public List<User> getListUser (){
		try {
			String query = "select * from user a";
			connection = new ConnectMySQL().getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			throw new ApplicationException("Get list account error", e);
		}
		
	}
	public static void main(String[] args) throws SQLException {
		UserDao userDao = new UserDao();
		//User user = userDao.loginUser("accout1.com","11");
		List<User> users = userDao.getListUser();
		System.out.println(users);
	}
}
