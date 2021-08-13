package Utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quangdo.model.User;

public class MyUtils {
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
	
	public static void storeConnection(ServletRequest request,Connection connection) {
		request.setAttribute(ATT_NAME_CONNECTION, connection);
	}
	public static Connection getStoredConnection(ServletRequest request) {
		Connection connection = (Connection)request.getAttribute(ATT_NAME_CONNECTION); 
		return connection;
	}
	public static void storeLoginedUser(HttpSession session,User loginedUser) {
		session.setAttribute("loginedUser", loginedUser);
	}
	public static User getLoginedUser(HttpSession session) {
		User loginedUser = (User)session.getAttribute("loginedUser");
		return loginedUser;
	}
	public static void storeUserCookie(HttpServletResponse response,User user) {
		System.out.println("Store user cookie");
		Cookie cookieUser = new Cookie( ATT_NAME_USER_NAME,user.getEmail());
		cookieUser.setMaxAge(24*60);
		response.addCookie(cookieUser);
	}
	public static String getUserEmailInCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				if(ATT_NAME_USER_NAME.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	public static void deletedUserCookie(HttpServletResponse response) {
		Cookie cookieUser = new Cookie(ATT_NAME_USER_NAME, null);
		cookieUser.setMaxAge(0);
		response.addCookie(cookieUser);
	}
}
