package com.quangdo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quangdo.connectMySQL.ConnectMySQL;
import com.quangdo.model.Book;
@WebServlet(urlPatterns = {"/home1"})
public class JstlServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JstlServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Connection connection = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String query = "select * from book";
			connection = new ConnectMySQL().getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			List<Book> list = new ArrayList<Book>();
			while (rs.next()) {
				Book book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				list.add(book);
			}
			//list.add(new Book(1, "1234", "1234", "2020-11-11", 1));
			//list.add(new Book(2, "1234", "1234", "2020-11-11", 3));
			//System.out.println(list);
				req.setAttribute("book", list);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/Book.jsp");
				dispatcher.forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}	
}

	
