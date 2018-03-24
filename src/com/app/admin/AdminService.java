package com.app.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminService {
	
	private static List<Admin> users = new ArrayList<Admin>();
	
	public List<Admin> retrieveUsers(Connection conn) {
		users.clear();
		try {
			 
			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;
				Statement stmt = conn.createStatement();
				String sql = "select * from user_login";
				System.out.println(sql);
				rs = stmt.executeQuery(sql);

				if (rs != null) {
					
					while (rs.next()) {
						Admin t=new Admin();
						System.out.println(rs.getInt("user_id"));
						t.setUser(rs.getInt("user_id"));
						t.setUname(rs.getString("uname"));
						t.setFname(rs.getString("fname"));
			            users.add(t);
			        }  
					
				}
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(users.size());
		return users;
	}
	
	public void deleteUser(int user_id, Connection conn) {

		Admin t1 = null;
		
		for(Admin t : users) { 
			   if(t.getUser() == user_id) { 
				 t1=t;  
			   }
			}
		
		try {
			if (conn != null && !conn.isClosed()) {

				Statement stmt = conn.createStatement();
				String sql = "delete from todos where user_id="+user_id;
				System.out.println(sql);
				int delete = stmt.executeUpdate(sql);
				if(delete==1)
				{
					users.remove(t1);
				}	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
