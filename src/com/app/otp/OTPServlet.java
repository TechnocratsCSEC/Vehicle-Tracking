package com.app.otp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.app.user.User;
import com.app.vehicletrack.VehicleServlet;

@WebServlet("/otp.do")
public class OTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int key;
	String key1;
	
	@Resource(name = "jdbc/technocrat")
    private DataSource ds;
	Connection conn;
	User user = new User();
	//VehicleServlet tracker = new VehicleServlet();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/otp.jsp").forward(request, response);
		Random r = new Random();
		key = r.nextInt(10000);
		key1 = String.valueOf(key);
		String msd = "Your OTP is " + key ;
        OTPService.send(msd);  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        String otp = request.getParameter("otp");
        if(otp.equals(key1)) {
			response.sendRedirect("tracking.do");	
        }
	}

}
