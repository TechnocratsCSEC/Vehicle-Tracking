package com.app.vehicledetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.app.vehicledetails.Details;

public class DetailsService {
	Details t = new Details();
		
	public Details vehicleDetails(String uname, String vehicleno, Connection conn) {
		boolean details=true;	
		try {
			System.out.println("detail");
			ResultSet rs = null;
			Statement stmt = conn.createStatement();
			String quer = "select vehidesc from vehicles where uname='" + uname + "' and vehicleno='" + vehicleno + "'";
			rs=stmt.executeQuery(quer);
			if(rs!=null && rs.next()) {
				System.out.println(rs.getString(1));
				t.setVehicleDesc(rs.getString(1));
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

}
