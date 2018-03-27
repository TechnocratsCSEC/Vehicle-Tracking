package com.app.admin;

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
 * Servlet implementation class RegVehicleServ
 */
@WebServlet("/regVehicle.do")
public class RegVehicleServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/technocrat")
    private DataSource ds;
	Connection conn;

	private AdminService todoService = new AdminService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			conn = ds.getConnection();
			request.setAttribute("vehicles", todoService.retrieveVehicles(conn));
			request.getRequestDispatcher("view/regVehi.jsp").forward(request, response);

		}
		catch(SQLException e)
		{
			log(e.getMessage(), e);
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
