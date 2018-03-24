package com.app.registration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationService {
	
	public boolean isUserRegistered(String uname,String fname,String email,String phone,String password,String category, String subcat, Connection conn) {
		boolean usernameExists=true;
		try {
			ResultSet rs = null;
			Statement stmt = conn.createStatement();
			String sql = "select * from user_login where uname='" + uname + "'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				usernameExists = true;
			}
			else{
				String insertSql = "insert into user_login (uname,fname,email,phone,password,category,subcat) values('" + uname + "','" + fname + "','" + email + "','" + phone + "','" + password + "','"+ category + "','" + subcat +"');";
				stmt.executeUpdate(insertSql);
				usernameExists=false;
				return usernameExists;
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usernameExists;
	}

}
