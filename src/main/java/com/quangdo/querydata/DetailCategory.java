package com.quangdo.querydata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.quangdo.connectMySQL.ConnectMySQL;
import com.quangdo.model.Book;

public class DetailCategory {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Book> queryBookFromIdCategory (int id){
		try {
			String query = "select * from book where book.id = ?";
			connection = new ConnectMySQL().getConnection();
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery(query);
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
}
