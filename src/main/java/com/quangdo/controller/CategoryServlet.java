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

import com.quangdo.dao.CategoryDao;
import com.quangdo.model.Category;
@WebServlet(urlPatterns = {"/CategoryList"})
public class CategoryServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = resp.getWriter()) {
			       out.println("<!DOCTYPE html>");
			       out.println("<html>");
			       out.println("<head>");
			       out.println("<title>Servlet CategoryServlet</title>");
			       out.println("</head>");
			       out.println("<body>");
			       CategoryDao categoryDao = new CategoryDao();
			       List<Category> list = new ArrayList<Category>();
			       list = categoryDao.getListCategories();
			       
		req.setAttribute("data", list);
		RequestDispatcher rs = req.getRequestDispatcher("/WEB-INF/views/Category.jsp");
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

