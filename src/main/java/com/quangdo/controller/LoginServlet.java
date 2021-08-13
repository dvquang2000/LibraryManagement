package com.quangdo.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.quangdo.dao.UserDao;
import com.quangdo.model.User;

import Utils.MyUtils;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LoginServlet() {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rememberString = req.getParameter("remember");
        User user = null;
        boolean remember = "Y".equals(rememberString);
        boolean hasError = false;
        String errorString = null;
        if (email == null || password == null || email.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required email and password!"; 
        }
        else {
        	try {
				 UserDao userDao = new UserDao();
				 
				 user = userDao.loginUser(email);
				 if(BCrypt.checkpw(password, user.getPassword()) == false) {
					 hasError = true;
					 errorString = "Email or Password invalid";
				 }
			
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
        }
        if(hasError) {
        	user = new User();
        	user.setEmail(email);
        	user.setPassword(password);
        	req.setAttribute("errorString", errorString);
        	req.setAttribute("user", user);
        	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
        	dispatcher.forward(req, resp);
        	
        }
        else {
			HttpSession session = req.getSession();
			MyUtils.storeLoginedUser(session, user);
			if(remember) {
				MyUtils.storeUserCookie(resp, user);
			}
			else {
				MyUtils.deletedUserCookie(resp);
			}
			
				resp.sendRedirect(req.getContextPath()+"/UserInfor");
			
		}
	}
}
