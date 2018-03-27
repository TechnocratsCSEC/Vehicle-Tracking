package com.app.admin;

public class Admin {

		private String uname;
		private String fname;
		private int user_id;
		private String vehicleNo;
		private String vehicleDesc;
		
		public String getVehicleNo() {
			return vehicleNo;
		}

		public void setVehicleNo(String vehicleno) {
			this.vehicleNo = vehicleno;
		}
		
		public String getVehicleDesc() {
			return vehicleDesc;
		}

		public void setVehicleDesc(String vehicledesc) {
			this.vehicleDesc = vehicledesc;
		}

		
		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		
		public String getUname() {
			return uname;
		}

		public void setUname(String uname) {
			this.uname = uname;
		}

		/*public Admin(){
			
		}
		
		public Admin(int user, String uname, String fname) {
			super();
			this.user = user;
			this.uname=uname;
			this.fname = fname;			
		}*/
		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		
			

}