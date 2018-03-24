package com.app.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.app.user.User;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/technocrat")
    private DataSource ds;
	Connection conn;
	
   private LoginService userValidation = new LoginService();
   User user=new User();
	
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.getRequestDispatcher("view/login.jsp").forward(request, response);
   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		try{
			conn = ds.getConnection();
			boolean isUserValid=userValidation.isUserValid(name, password,user,conn);
			if(isUserValid){
				request.getSession().setAttribute("name", name);
				System.out.println(user.getUser_id());
				request.getSession().setAttribute("user_id", user.getUser_id());
				request.getSession().setAttribute("csrfToken", generateCSRFToken());
				String sessionid = request.getSession().getId();
				response.setHeader("Set-Cookie", "JSESSIONID=" +  sessionid + ";");
				if(name.equals("admin")) {
					response.sendRedirect("admin.do");
					System.out.println("Login Successful");
				}
				else {
					response.sendRedirect("tracking.do");	
					System.out.println("Login Successful");
				}
			}
			else{
				System.out.println("Invalid credientials");
				request.getRequestDispatcher("view/login.jsp").forward(request, response);
			}
		}
		catch(SQLException e){
			log(e.getMessage(), e);
		}
	}
	
	public static String generateCSRFToken() {
		String token = UUID.randomUUID().toString();
		return token;
	}
}
