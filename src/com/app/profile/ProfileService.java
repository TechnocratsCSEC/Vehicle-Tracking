package com.app.profile;

import java.sql.*;

public class ProfileService {
	Profile p = new Profile();
	
	public Profile getUserProfile(String uname, Connection conn) {
		try {
			ResultSet rs = null;
			Statement stmt = conn.createStatement();
			String prof = "select fname, email, phone from user_login where uname='" + uname + "'";
			rs = stmt.executeQuery(prof);
			if(rs.next()) {
				p.setUserName(uname);
				String fname = rs.getString(1);
				System.out.println(fname);
				p.setFullName(fname);
				
				String email = rs.getString(2);
				System.out.println(email);
				p.setEmailAdd(email);
				String phone = rs.getString(3);

				p.setPhone(phone);

				
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
		
	}
	
	/*public boolean changeUserName(String uname,String nname, Connection conn) {
		boolean done = false;
		try {
			ResultSet rs = null;
			Statement stmt = conn.createStatement();
			String prof = "update user_login set uname= '" + nname + "' where uname='" + uname + "'";
			stmt.executeUpdate(prof);
			conn.close();
			done = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return done;	
	}*/

}