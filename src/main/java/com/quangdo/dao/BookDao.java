package com.quangdo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.quangdo.connectMySQL.ConnectMySQL;
import com.quangdo.model.*;


public class BookDao {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Book> getListBook (){
		try {
			String query = "select * from book";
			connection = new ConnectMySQL().getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			List<Book> list = new ArrayList<Book>();
			while (rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				list.add(book);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static void main(String[] args) {
		BookDao bookDao = new BookDao();
		List<Book> list = bookDao.getListBook();
		System.out.println(list);
	}

}
