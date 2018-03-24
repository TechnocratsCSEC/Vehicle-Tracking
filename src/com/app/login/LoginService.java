package com.app.login;

import java.sql.*;

import com.app.user.User;


public class LoginService {
	User user = new User();
	public boolean isUserValid(String name, String password, User user,Connection conn) {
		boolean status = false;
		user.setUsername(name);
		try{
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				Statement stmt = conn.createStatement();
				String sql = "select * from user_login where uname='" + name + "' and password='" + password + "'";
				rs = stmt.executeQuery(sql);
				status = rs.next();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
