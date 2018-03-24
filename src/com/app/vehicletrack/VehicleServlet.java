package com.app.vehicletrack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.app.user.User;

/**
 * Servlet implementation class VehicleServlet
 */
@WebServlet("/vehicle.do")
public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/technocrat")
    private DataSource ds;
	Connection conn;
	User user = new User();
	Vehicle veh = new Vehicle();
	VehicleService trackit = new VehicleService();
	
	ArrayList<String> tracks = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("vehicle");
	
		String uname = user.getUsername();
		veh.setUsername(uname);
		System.out.println(uname);
		try{
			conn = ds.getConnection();
		}
		catch(SQLException e){
			log(e.getMessage(), e);
		}
		Vehicle v = trackit.trackVehicle(uname,conn);
		System.out.println(v.getSource());
		System.out.println(v.getDest());
		String src = v.getSource();
		String dest = v.getDest();
		request.setAttribute("frominput", src);
		request.setAttribute("toinput", dest);
		//request.setAttribute("hello", v);
		request.getRequestDispatcher("view/vehicle_track.jsp").forward(request, response);	
		
	}
	
	

}
