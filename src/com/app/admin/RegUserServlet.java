package com.app.admin;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class RegUserServlet
 */
@WebServlet("/regUser.do")

public class RegUserServlet extends HttpServlet {
	@Resource(name = "jdbc/technocrat")
    private DataSource ds;
	Connection conn;
	private static final long serialVersionUID = 1L;
       
	private AdminService todoService = new AdminService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			conn = ds.getConnection();
			request.setAttribute("users", todoService.retrieveUsers(conn));
			request.getRequestDispatcher("view/regUser.jsp").forward(request, response);

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