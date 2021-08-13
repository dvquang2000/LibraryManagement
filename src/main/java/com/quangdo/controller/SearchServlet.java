package com.quangdo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quangdo.dao.BookDao;
import com.quangdo.model.Book;
@WebServlet(urlPatterns = {"/Search"})
public class SearchServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public SearchServlet(){
		super();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchString = req.getParameter("string");
		BookDao bookDao = new BookDao();
		List<Book> list = bookDao.searchBook(searchString);
		req.setAttribute("data", list);
		RequestDispatcher rs = req.getRequestDispatcher("/WEB-INF/views/Book.jsp");
		rs.forward(req, resp);	
		
	}
}
