package com.app.profile;

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

import com.app.user.User;
	
@WebServlet("/profile.do")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/technocrat")
    private DataSource ds;
	Connection conn;
	
	User user = new User();
	Profile p = new Profile();
	ProfileService pservice = new ProfileService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = (String) request.getSession().getAttribute("name");
		p.setUserName(uname);
		System.out.println(uname);
		try{
			conn = ds.getConnection();
			Profile p = pservice.getUserProfile(uname, conn);
			String fname = p.getFullName();
			String phone= p.getPhone();
			String email = p.getEmailAdd();
			
			request.setAttribute("uname", uname);
			request.setAttribute("fname", fname);
			request.setAttribute("email", email);
			request.setAttribute("phone", phone);
			
		}
		catch(SQLException e){
			log(e.getMessage(), e);
		}
		
		request.getRequestDispatcher("view/profile.jsp").forward(request, response);
	}
}
