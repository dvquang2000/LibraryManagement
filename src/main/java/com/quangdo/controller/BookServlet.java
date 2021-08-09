package com.quangdo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.group.Response;

import com.quangdo.dao.BookDao;
import com.quangdo.model.Book;

@WebServlet(urlPatterns = {"/BookList"})
public class BookServlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = resp.getWriter()) {
			       out.println("<!DOCTYPE html>");
			       out.println("<html>");
			       out.println("<head>");
			       out.println("<title>Servlet BookServlet</title>");
			       out.println("</head>");
			       out.println("<body>");
		BookDao bookDao = new BookDao();
		List<Book> list = new ArrayList<Book>();
		list = bookDao.getListBook();
		req.setAttribute("data", list);
		RequestDispatcher rs = req.getRequestDispatcher("/WEB-INF/views/Book.jsp");
		rs.forward(req, resp);
		out.println("</body>");
        out.println("</html>");
		} 
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	public String getServletInfo() {
		
		return "short description";
	}
	
}
