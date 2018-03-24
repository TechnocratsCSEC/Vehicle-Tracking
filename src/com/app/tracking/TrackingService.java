package com.app.tracking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TrackingService {
		
	public boolean storeVehicle(String uname, String source, String dest, Connection conn) {
		boolean usernameExists=true;
		try {
			System.out.println("Stored");
			ResultSet rs = null;
			Statement stmt = conn.createStatement();
			String sql = "insert into tracker(uname, source, dest) values('" + uname + "','" + source + "','" + dest + "')";
			stmt.executeUpdate(sql);
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usernameExists;
	}

}
