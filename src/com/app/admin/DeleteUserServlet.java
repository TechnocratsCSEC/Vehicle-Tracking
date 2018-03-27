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

@WebServlet("/deleteUser.do")
public class DeleteUserServlet extends HttpServlet {
	@Resource(name = "jdbc/technocrat")
    private DataSource ds;
	Connection conn;
	private static final long serialVersionUID = 1L;
       
	private AdminService todoService = new AdminService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int user_id=Integer.parseInt((String) request.getSession().getAttribute("user_id"));
		int todo_id=Integer.parseInt((String) request.getParameter("todo_id"));
		try{
			conn = ds.getConnection();
			todoService.deleteUser(todo_id,conn);
			response.sendRedirect("regUser.do");
		}
		catch(SQLException e){
			log(e.getMessage(), e);
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}