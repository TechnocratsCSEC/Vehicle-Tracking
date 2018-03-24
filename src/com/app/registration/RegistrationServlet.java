package com.app.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/technocrat")
    private DataSource ds;
	Connection conn;
	private RegistrationService userRegister= new RegistrationService();
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String fname = request.getParameter("fname");
		String email = request.getParameter("InputEmail");
		String phone = request.getParameter("InputPhone");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		String category = request.getParameter("category");
		String subcat="";
		System.out.println(category);
		if(category.equals("Government")) {
			subcat += request.getParameter("subcat1");
			System.out.println(subcat);
		}
		else if(category.equals("Logistics")) {
			subcat += request.getParameter("subcat2");
			System.out.println(subcat);
		}
		else
			subcat = "NULL";
				
		if (password!=null && confirm_password!=null) {
			if (!password.equals(confirm_password)) { 
				request.setAttribute("error", "Confirmation password did not match");
				request.getRequestDispatcher("view/registration.jsp").forward(request, response);
			}
			else{
				try{
					conn = ds.getConnection();
				}
				catch(SQLException e){
					log(e.getMessage(), e);
				}
				boolean isUserRegistered=userRegister.isUserRegistered(uname,fname,email,phone,password,category,subcat,conn);
				if(isUserRegistered){
					request.setAttribute("error", "User already registered");
					request.getRequestDispatcher("view/registration.jsp").forward(request, response);
				}
				else{
					response.sendRedirect("login.do");
				} 
			} 
		}		
	}
}
