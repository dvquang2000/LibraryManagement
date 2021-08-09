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

import com.quangdo.model.Book;
import com.quangdo.querydata.DetailCategory;
@WebServlet(urlPatterns = {"/getBookByCategory"})
public class DetailCategoryServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = resp.getWriter()) {
			       out.println("<!DOCTYPE html>");
			       out.println("<html>");
			       out.println("<head>");
			       out.println("<title>Servlet BookServlet</title>");
			       out.println("</head>");
			       out.println("<body>");
		DetailCategory detailCategory = new DetailCategory();
		List<Book> list = new ArrayList<Book>();
		int id = Integer.valueOf(req.getParameter("code"));
		list = detailCategory.queryBookFromIdCategory(id);
		req.setAttribute("data", list);
		RequestDispatcher rs = req.getRequestDispatcher("detail_category.jsp");
		rs.forward(req, resp);
        out.print(id);
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
