package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbcproject", "root","Rajamani@-01");
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery("select*from employee");
			//code for display table row
			while(r.next()==true)
			{
				System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println(r.getInt(3));
				System.out.println("--------------");
			}
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("check driver class");
			e.printStackTrace();
		} catch (SQLException e) {
		System.out.println("check database name and credentials");
			e.printStackTrace();
		}
		

	}

}
