package com.app.tracking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.app.vehicledetails.Details;

public class TrackingService {
	Details t = new Details();
		
	public boolean storeVehicle(String uname, String source, String dest, Connection conn) {
		boolean usernameExists=true;	
		try {
			System.out.println("Stored");
			ResultSet rs = null;
			Statement stmt = conn.createStatement();
			String quer = "select uname from tracker where uname = '" + uname + "'";
			rs=stmt.executeQuery(quer);
			if(rs.next()) {
				String sql = "update tracker set source='" + source + "', dest='" + dest + "' where uname = '" + uname + "'";
		        stmt.executeUpdate(sql);
			}
			else {
				String sql = "insert into tracker(uname, source, dest) values('" + uname + "','" + source + "','" + dest + "')";
				stmt.executeUpdate(sql);
			}
			
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usernameExists;
	}
	
	public boolean vehicleDetails(String uname, String vehicleno, Connection conn) {
		boolean details=true;	
		try {
			System.out.println("detail");
			ResultSet rs = null;
			Statement stmt = conn.createStatement();
			String quer = "select vehicledesc from tracker where uname = '" + uname + "', vehicleno= '" + vehicleno +"'";
			rs=stmt.executeQuery(quer);
			if(rs!=null && rs.next()) {
				System.out.println(rs.getString(1));
				t.setVehicleDesc(rs.getString(1));
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return details;
	}

}
