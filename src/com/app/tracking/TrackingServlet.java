package com.app.tracking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.app.user.User;
import com.app.tracking.*;

/**
 * Servlet implementation class Tracking
 */
@WebServlet("/tracking.do")
public class TrackingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TrackingService ts = new TrackingService();
       
	@Resource(name = "jdbc/technocrat")
    private DataSource ds;
	Connection conn;
	User user = new User();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/tracking.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("track serv");
		String uname = user.getUsername();
		System.out.println(uname);
		String source = request.getParameter("source");
		String dest = request.getParameter("dest");
		try{
			conn = ds.getConnection();
		}
		catch(SQLException e){
			log(e.getMessage(), e);
		}
		boolean isStored=ts.storeVehicle(uname,source,dest,conn);
		if(isStored){
			response.sendRedirect("vehicle.do");	
		}
	}

}
