package com.app.login;

import java.sql.*;

import com.app.user.User;


public class LoginService {
	//User user = new User();
	public boolean isUserValid(String name, String password, User user,Connection conn) {
		boolean status = false;
		//user.setUsername(name);
		try{
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				Statement stmt = conn.createStatement();
				String sql = "select * from user_login where uname='" + name + "' and password='" + password + "'";
				rs = stmt.executeQuery(sql);
				if(rs!=null && rs.next())
				{
					//User user = new User();
					user.setUsername(rs.getString("uname"));
					user.setUser_id(rs.getInt("user_id"));
					System.out.println(user.getUser_id());
					
				}
				status = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
