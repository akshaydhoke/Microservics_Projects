package com.java8;

import java.sql.*;

class DriverActionImpl implements DriverAction {

	@Override
	public void deregister() {
		System.out.println(" Driver has been de-registerd ");
	}
}

public class DriverActionExp {
	public static void main(String[] args) {

		try {

//        	Creating Driver Object ::
			Driver driver = new com.mysql.jdbc.Driver();

//			Creating DriverAction Obj from DriverActionImpl ::
			DriverAction driverAction = new DriverActionImpl();

//			Passing Driver and DriverAction Objects in DriverManager ::

			DriverManager.registerDriver(driver, driverAction);

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springBoot", "root","Talent_123");

			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery("select * from UserRecord");
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+ rs.getString(2)+ " "+ rs.getString(3));
			}
			
//			Closing connection and Driver Connection.
			con.close();
			driverAction.deregister();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
