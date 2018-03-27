package com.app.vehicledetails;

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

/**
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/details.do")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/technocrat")
    private DataSource ds;
	Connection conn;
	User user = new User();
	DetailsService ts = new DetailsService();
	Details vd = new Details();
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("track serv");
		String uname = (String) request.getSession().getAttribute("name");
		System.out.println(uname);
		try{
			conn = ds.getConnection();
		}
		catch(SQLException e){
			log(e.getMessage(), e);
		}
		String vehicleno = request.getParameter("vehicle");
		System.out.println(vehicleno);
		Details d = ts.vehicleDetails(uname, vehicleno, conn);
		String desc = d.getVehicleDesc();
		request.setAttribute("vehi", vehicleno);
		request.setAttribute("desc", desc);
		request.getRequestDispatcher("view/tracking.jsp").forward(request, response);		
	}

}
