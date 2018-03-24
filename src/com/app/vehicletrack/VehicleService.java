package com.app.vehicletrack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VehicleService {
	
	Vehicle veh = new Vehicle();
	
	public Vehicle trackVehicle(String uname, Connection conn) {
		boolean usernameExists=true;
		try {
			ResultSet rs = null;
			Statement stmt = conn.createStatement();
			String track = "select source, dest from tracker where uname='" + uname + "'";
			rs = stmt.executeQuery(track);
			if(rs.next()) {
				usernameExists = true;
				String src = rs.getString(1);
				System.out.println(src);
				veh.setSource(src);
				String dest = rs.getString(2);
				System.out.println(dest);
				veh.setDest(dest);
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return veh;
		
	}

}
