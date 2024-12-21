package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC1 {

	public static void main(String[] args) {
		try {
			//step-1:load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//step=2:Establish/open the connection
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbcproject", "root","Rajamani@-01");
																																																			
			//step-3:prepare sql statement
			Statement s=con.createStatement();
			
			//step-4:we have to send sql query to mysql database
			s.executeUpdate("create table employee(eno int primary key,ename varchar(40),esalary int)");
			//step-5:close all the connections
			s.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("i forgot to attache driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("something wrong with db or credentials");			
			e.printStackTrace();
		}

	}

}
